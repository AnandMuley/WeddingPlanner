app.service('Pandit',['$resource',function($resource){
    return $resource('http://localhost:8091/rest-service/pandits/:id',null,
    {
      'create' : {method : 'POST'},
      'update' : {method : 'PUT'},
      'search' : {method : 'GET',isArray:true,params:{id:'search'}}
    });
}]);