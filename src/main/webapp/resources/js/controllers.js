
angular.module('TradeSimple.controllers', []).
    controller('tradeSimpleController', function($scope, tradeSimpleService){
        $scope.executor = []
        tradeSimpleService.getExecutor().
            success(function(response){
                console.log(response[0].session)
                $scope.executor = response
             })

        console.log(tradeSimpleService.getStaticData())

});

