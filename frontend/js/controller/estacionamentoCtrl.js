angular.module("estacionamento").controller("estacionamentoCtrl", function ($scope, $http){
    var listarEstacionamento = function (patioId){
        $http.get("http://localhost:8080/estacionamento/" + patioId).then((data, status)=>{
            $scope.vagas = data.data;
            console.log($scope.vagas.length);
        });
    };
    var addEstacionamento = function (registro){
        $http.post("http://localhost:8080/estacionamento", registro).then((data, status)=>{
            console.log(data);
            listarEstacionamento(registro.patioId);
            if(!data.data.saida){
                $scope.ticket = {
                    "msg" : "Bem vindo.",
                    "entrada" : data.data.entrada,
                    "saida" : null,
                    "tempoPermanencia" : 0,
                    "valor" : 0.00
                }
            }else{
                $scope.ticket = {
                    "msg" : "Boa viagem.",
                    "entrada" : data.data.entrada,
                    "saida" : data.data.saida,
                    "tempoPermanencia" : data.data.tempoPermanencia,
                    "valorPago" : data.data.valorPago
                }
            }
            var dialog = document.getElementById('ticketDialog');
            dialog.showModal();
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
    $scope.add = function (placa){
        console.log(placa);
        var novoRegistro = {
            "placa": placa,
            "patioId": $scope.patioSelecionado.id
        }
        
        addEstacionamento(novoRegistro);
        delete $scope.placa;
        $scope.close('registro');
    }
    $scope.logIn = function (){
        var dialog = document.getElementById('registro');
        dialog.showModal();
    }

    $scope.close = function (idDialog){
        var dialog = document.getElementById(idDialog);
        delete $scope.placa;
        dialog.close();
    }
});