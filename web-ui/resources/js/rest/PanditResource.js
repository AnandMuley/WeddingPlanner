app.service('Pandit',['$resource',function($resource){
    return $resource('http://localhost:8091/rest-service/pandits/:id',null,
    {
      'update' : {method : 'PUT'}
    });
}]);