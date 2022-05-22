var totemModel = require("../models/totemModel");

var sessoes = [];

function cadastrar(req, res) {
    var id_host = req.body.id_host;
    var fk_estacao = req.body.fk_estacao;
    if (id_host == undefined) {
        res.status(400).send("id_host está undefined!");
    } else if (fk_estacao == undefined) {
        res.status(400).send("fk_estacao está undefined!");
    } else {
        totemModel.cadastrar(id_host, fk_estacao)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
        }   
}
 
function cadastrarComponenteCpu(req, res) {
    var modelo = req.body.modelo;
    var marca = req.body.marca;
    var cpu_velocidade_base = req.body.cpu_velocidade_base;
    var disco_capacidade = 0.0;
    var memoria_total = 0.0;
    var data_implementada = req.body.data_implementada;

    if (modelo == undefined) {
        res.status(400).send("Modelo da cpu está undefined!");
    } else if (marca == undefined) {
        res.status(400).send("Marca da cpu está undefined!");
    } else if (cpu_velocidade_base == undefined) {
        res.status(400).send("Velocidade da cpu está undefined!");
    } else if (disco_capacidade == undefined) {
        res.status(400).send("Capacidade do disco está undefined!");
    } else if (memoria_total == undefined) {
        res.status(400).send("Total da memória está undefined!");
    } else if (data_implementada == undefined) {
        res.status(400).send("Data e hora está undefined!");
    } else {
        totemModel.cadastrarComponenteCpu(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function cadastrarComponenteDisco(req, res) {
    var modelo = req.body.modelo;
    var marca = req.body.marca;
    var cpu_velocidade_base = 0.0;
    var disco_capacidade = req.body.disco_capacidade;
    var memoria_total = 0.0;
    var data_implementada = req.body.data_implementada;

    if (modelo == undefined) {
        res.status(400).send("Modelo da cpu está undefined!");
    } else if (marca == undefined) {
        res.status(400).send("Marca da cpu está undefined!");
    } else if (cpu_velocidade_base == undefined) {
        res.status(400).send("Velocidade da cpu está undefined!");
    } else if (disco_capacidade == undefined) {
        res.status(400).send("Capacidade do disco está undefined!");
    } else if (memoria_total == undefined) {
        res.status(400).send("Total da memória está undefined!");
    } else if (data_implementada == undefined) {
        res.status(400).send("Data e hora está undefined!");
    } else {
        totemModel.cadastrarComponenteDisco(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function cadastrarComponenteMemoria(req, res) {
    var modelo = req.body.modelo;
    var marca = req.body.marca;
    var cpu_velocidade_base = 0.0;
    var disco_capacidade = 0.0;
    var memoria_total = req.body.memoria_total;
    var data_implementada = req.body.data_implementada;

    if (modelo == undefined) {
        res.status(400).send("Modelo da cpu está undefined!");
    } else if (marca == undefined) {
        res.status(400).send("Marca da cpu está undefined!");
    } else if (cpu_velocidade_base == undefined) {
        res.status(400).send("Velocidade da cpu está undefined!");
    } else if (disco_capacidade == undefined) {
        res.status(400).send("Capacidade do disco está undefined!");
    } else if (memoria_total == undefined) {
        res.status(400).send("Total da memória está undefined!");
    } else if (data_implementada == undefined) {
        res.status(400).send("Data e hora está undefined!");
    } else {
        totemModel.cadastrarComponenteMemoria(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade)
            .then(
                function (resultado) {
                    res.json(resultado);
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao realizar o cadastro! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

module.exports = {
    cadastrar,
    cadastrarComponenteCpu,
    cadastrarComponenteDisco,
    cadastrarComponenteMemoria
}