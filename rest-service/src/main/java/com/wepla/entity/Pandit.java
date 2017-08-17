package com.wepla.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pandits")
public class Pandit extends Person {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pandit{");
        sb.append("id='").append(id).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append("contactNo='").append(contactNo).append('\'');
        sb.append("emailId='").append(emailId).append('\'');
        sb.append("address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
