
angular.module('TradeSimple.controllers', []).
    controller('tradeSimpleController', function($scope, $interval, tradeSimpleService){
        $scope.sessions = {}

        $interval(function(){
            tradeSimpleService.getSessions().success(function(response){
                $scope.sessions = response
            })
        }, 1000)
});

