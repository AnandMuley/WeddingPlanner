app.controller('AdminController',['$scope','Pandit', '$resource',
        function($scope,Pandit, $resource){

    $scope.pandit = new Pandit();
    $scope.pandits = Pandit.query();

    $scope.add = function(){
        $scope.pandit.$save(function(pandit,responseHeaders){
            $scope.pandits = Pandit.query();
        });
    }

}]);