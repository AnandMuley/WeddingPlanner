app.controller('PanditRegistrationController',['$scope','Pandit',
            function($scope,Pandit){

    $scope.pandit = Pandit.get({id:"5995253a44ae7c14f24f588a"});

    $scope.add = function(){
        $scope.pandit.$create(function(pandit,responseHeaders){
            $scope.pandits = Pandit.query();
            $scope.pandit = new Pandit();
            $scope.message = "Registration Successful !";
        });
    }

    $scope.update = function(){
        Pandit.update({id:$scope.pandit.id},$scope.pandit,function(value,responseHeaders,statusCode,statusText){
            $scope.pandit = new Pandit();
            $scope.message = "Update Successful !";
        },function(httpResponse){
            $scope.message = "Update failed !";
        });
    }


}]);