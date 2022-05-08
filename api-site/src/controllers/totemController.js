var totemModel = require("../models/totemModel");

var sessoes = [];
/* 
function listar(req, res) {
    totemModel.listar()
        .then(function (resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function (erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );
}
 */

function cadastrar(req, res) {
    var id_totem = req.body.id_totem;
    var id_host = req.body.id_host;
    var status_totem = req.body.status_totem;
    var fk_estacao = req.body.fk_estacao;

    if (id_totem == undefined) {
        res.status(400).send("Id está undefined!");
    } else if (id_host == undefined) {
        res.status(400).send("Id Host está undefined!");
    } else if (status_totem == undefined) {
        res.status(400).send("Status está undefined!");
    } else if (fk_estacao == undefined) {
        res.status(400).send("fk_estacao está undefined!");
    }else {
        usuarioModel.cadastrar(id_host, id_host, status_totem, fk_estacao)
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
    // listar
}