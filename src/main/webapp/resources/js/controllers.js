
angular.module('TradeSimple.controllers', []).
    controller('tradeSimpleController', function($scope, tradeSimpleService){
        $scope.executor = []
        $scope.sessions = {}

        tradeSimpleService.getExecutor().
            success(function(response){
                console.log(response[0].session)
                $scope.executor = response
             })

        tradeSimpleService.getSessions().
            success(function(response){
                console.log("__ call getSessions")
                console.log(response)
                $scope.sessions = response
            })

});

