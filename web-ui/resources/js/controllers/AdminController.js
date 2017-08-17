app.controller('AdminController',['$scope','Pandit',
        function($scope,Pandit){

    $scope.pandits = Pandit.query();

    $scope.search = function(){
        $scope.pandits = Pandit.search({name:$scope.nameToSearch});
    }

}]);