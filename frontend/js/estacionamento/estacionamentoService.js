angular.module("estacionamento").service("estacionamentoService", function($http){
    this.listar = function(patioId){
        return $http.get("http://localhost:8080/estacionamento/" + patioId);
    };
});