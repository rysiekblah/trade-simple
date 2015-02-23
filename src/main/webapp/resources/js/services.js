angular.module('TradeSimple.services', []).
factory('tradeSimpleService', function($http){
    var respApp = {}

    respApp.getSessions = function() {
        return $http.get('executor/sessions.json')
    }

    return respApp
});