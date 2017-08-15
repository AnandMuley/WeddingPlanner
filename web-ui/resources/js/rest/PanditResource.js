app.service('Pandit',['$resource',function($resource){
    return $resource('http://localhost:8091/rest-service/pandits/:name',null,
    {
      'update' : {method : 'PUT'},
      'search' : {method : 'GET',isArray:true}
    });
}]);