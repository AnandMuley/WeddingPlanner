package com.wepla.service

import com.wepla.builders.PanditBuilder
import com.wepla.builders.PanditDtoBuilder
import com.wepla.entity.Pandit
import com.wepla.exceptions.NoDataFoundException
import com.wepla.repository.PanditRepository
import com.wepla.rest.dto.PanditDto
import com.wepla.util.PanditAssertions
import spock.lang.Specification
import spock.lang.Subject

class PanditServiceSpec extends Specification {

    @Subject
    PanditService panditService

    PanditRepository mockPanditRepository

    def setup() {
        mockPanditRepository = Mock(PanditRepository)
        panditService = new PanditService(
                panditRepository: mockPanditRepository
        )
    }

    def "create - should create new pandit record"() {
        given: "pandit details to be persisted"
        PanditDto dto = new PanditDtoBuilder().build()
        def generatedId = UUID.randomUUID().toString()
        Pandit savedPandit = null
        1 * mockPanditRepository.save({ Pandit it ->
            it.id = generatedId
            savedPandit = it
        })

        when: "create method is called"
        panditService.create(dto)

        then: "details should be persisted and id field populated"
        assert dto.id == generatedId
        assert dto.addressDto.state == savedPandit.address.state
        assert dto.addressDto.city == savedPandit.address.city
        assert dto.addressDto.addressLine1 == savedPandit.address.addressLine1

        assert dto.emailId == savedPandit.emailId
        assert dto.contactNo == savedPandit.contactNo
        assert dto.name == savedPandit.name
        assert dto.properties.size() == savedPandit.properties.size()
    }

    def "update - should update pandit record"() {
        given: "pandit details to be updated"
        def generatedId = UUID.randomUUID().toString()
        PanditDto dto = new PanditDtoBuilder().withId(generatedId).build()
        Pandit updatedPandit = new PanditBuilder().build()
        1 * mockPanditRepository.save({ Pandit it ->
            updatedPandit = it
        })

        when: "create method is called"
        panditService.update(dto)

        then: "details should be updated and id field populated"
        assert dto.id == generatedId
        PanditAssertions.assertValue(dto.addressDto,updatedPandit.address)

        assert dto.emailId == updatedPandit.emailId
        assert dto.contactNo == updatedPandit.contactNo
        assert dto.name == updatedPandit.name
        assert dto.properties.size() == updatedPandit.properties.size()
    }

    def "getAll - should return all the details"() {
        given: "pandit details present in the database"
        List<Pandit> panditList = [new PanditBuilder().build()]
        1 * mockPanditRepository.findAll() >> panditList

        when: "search is called"
        List<PanditDto> pandits = panditService.getAll()

        then: "all details are sent"
        assert pandits.size() == 1
        def index = 0
        PanditAssertions.assertValue(pandits[index].addressDto,panditList[index].address)

        assert pandits[index].id == panditList[index].id
        assert pandits[index].name == panditList[index].name
        assert pandits[index].contactNo == panditList[index].contactNo
        assert pandits[index].emailId == panditList[index].emailId
    }

    def "findByName - should return all the details of matching pandit for given name"() {
        given: "pandit details present in the database"
        List<Pandit> panditList = [new PanditBuilder().build()]
        def name = "Arjun"
        1 * mockPanditRepository.findByNameContainingIgnoreCase(name) >> panditList

        when: "search is called"
        List<PanditDto> pandits = panditService.findByName(name)

        then: "all details are sent"
        assert pandits.size() == 1
        def index = 0
        PanditAssertions.assertValue(pandits[index].addressDto,panditList[index].address)
        assert pandits[index].id == panditList[index].id
        assert pandits[index].name == panditList[index].name
        assert pandits[index].contactNo == panditList[index].contactNo
        assert pandits[index].emailId == panditList[index].emailId

    }

    def "find - should find a customer by id"() {
        given: "pandit details present in the database"
        def id = UUID.randomUUID().toString()
        Pandit pandit = new PanditBuilder().build()
        1 * mockPanditRepository.findOne(id) >> pandit

        when: "search is called"
        PanditDto panditDto = panditService.find(id)

        then: "all details are sent"
        PanditAssertions.assertValue(panditDto.addressDto,pandit.address)
        assert panditDto.id == pandit.id
        assert panditDto.name == pandit.name
        assert panditDto.contactNo == pandit.contactNo
        assert panditDto.emailId == pandit.emailId

    }

    def "find - should throw an exception if the customer is not found"() {
        given: "pandit details are not present in the database"
        def id = UUID.randomUUID().toString()
        1 * mockPanditRepository.findOne(id) >> null

        when: "search is called"
        panditService.find(id)

        then: "exception is thrown"
        thrown(NoDataFoundException)

    }
}
