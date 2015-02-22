angular.module('TradeSimple.services', []).
factory('tradeSimpleService', function($http){
    var respApp = {}

    respApp.getExecutor = function() {
        return $http.get('executor/executorstatus.json')
    };

    respApp.getSessions = function() {
        return $http.get('executor/sessions.json')
    }

    respApp.getStaticData = function() {
        return [{employees:[
                    {firstName:'John', lastName:'Doe'},
                    {firstName:'Anna', lastName:'Smith'},
                    {firstName:'Peter', lastName:'Jones'}
                ]}];
    }

    return respApp
});