angular.module("estacionamento").controller("estacionamentoCtrl", function ($scope, $http){
    var listarEstacionamento = function (patioId){
        $http.get("http://localhost:8080/estacionamento/" + patioId).then((data, status)=>{
            $scope.vagas = data.data;
            console.log($scope.vagas.length);
        });
    };
    $scope.patios = [
        {id: 1, descricao: "Patio A", quantidadeVagas:"30", taxaHora:"1.30"},
        {id: 2, descricao: "Patio B", quantidadeVagas:"60", taxaHora:"1.50"},
        {id: 3, descricao: "Patio C", quantidadeVagas:"50", taxaHora:"1.00"}
    ];
    $scope.selecionar = function (patio){
        console.log(patio)
        $scope.patioSelecionado = patio;
        listarEstacionamento($scope.patioSelecionado.id);
    };
    $scope.getArray = function (num) {
        values = [];
        for(var x = 1 ; x < num ; x++){
            values.push(x);
        }
        return values;
    }
});