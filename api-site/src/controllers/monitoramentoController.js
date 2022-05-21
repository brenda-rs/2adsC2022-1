var monitoramentoModel = require("../models/monitoramentoModel");


function buscarMedidasAtuais(req, res) {
    var idTotem = req.params.idTotem;


    console.log(`Recuperando medidas em tempo real`);

    monitoramentoModel.buscarMedidasAtuais(idTotem).then(function (resultado) {
        
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

function buscarMedidasAtuaisCpu(req, res) {
    var idTotem = req.params.idTotem;


    console.log(`Recuperando medidas em tempo real`);

    monitoramentoModel.buscarMedidasAtuaisCpu(idTotem).then(function (resultado) {
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

function buscarMedidasAtuaisMemoria(req, res) {
    var idTotem = req.params.idTotem;


    console.log(`Recuperando medidas em tempo real`);

    monitoramentoModel.buscarMedidasAtuaisMemoria(idTotem).then(function (resultado) {
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

function buscarMedidasAtuaisDisco(req, res) {
    var idTotem = req.params.idTotem;


    console.log(`Recuperando medidas em tempo real`);

    monitoramentoModel.buscarMedidasAtuaisDisco(idTotem).then(function (resultado) {
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

function buscarEstacoes(req, res) {
    var idEmpresa = req.params.fkEmpresa;


    console.log(`Recuperando medidas em tempo real`);

    monitoramentoModel.buscarEstacoes(idEmpresa).then(function (resultado) {
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

module.exports = {
   buscarMedidasAtuais,
   buscarMedidasAtuaisCpu,
   buscarMedidasAtuaisMemoria,
   buscarMedidasAtuaisDisco,
   buscarEstacoes
}