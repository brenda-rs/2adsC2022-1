var totensModel = require("../models/totensModel");

function buscarDados(req, res) {
    var fk_empresa = req.params.fk_Empresa;
console.log("O fk da empresa é " + fk_empresa)
    console.log(`Recuperando medidas em tempo real`);

    totensModel.buscarDados(fk_empresa).then(function (resultado) {
        if (resultado.length > 0) {
            res.status(200).json(resultado);
        } else {
            res.status(204).send("Nenhum resultado encontrado!")
        }
    }).catch(function (erro) {
        console.log(erro);
        console.log("Houve um erro ao buscar as ultimas medidas.", erro.sqlMessage);
        res.status(500).json(erro.sqlMessage);
    });
    
}

function excluirTotem(req, res) {
    var fk_totem = req.body.idTotem;
    console.log(`Recuperando medidas em tempo real`);

    totensModel.excluirTotem(fk_totem).then(
        function (resultado) {
            res.json(resultado);
        }
    ).catch(
        function (erro) {
            console.log(erro);
            console.log(
                "\nHouve um erro no delete! Erro: ",
                erro.sqlMessage
            );
            res.status(500).json(erro.sqlMessage);
        }
    );
    
}

module.exports = {
    buscarDados,
    excluirTotem
}