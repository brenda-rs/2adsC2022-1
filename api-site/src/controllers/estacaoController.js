var estacaoModel = require("../models/estacaoModel");

function cadastrar(req, res) {
    var nomeEstacao = req.body.nomeEstacao;
    var linhaEstacao = req.body.linhaEstacao;
    var zonaEstacao = req.body.zonaEstacao;
    var fkEmpresa = req.body.fkEmpresa;
    if (nomeEstacao == undefined) {
        res.status(400).send("O nome da estação está undefined!");
    } else if (linhaEstacao == undefined) {
        res.status(400).send("A linha está undefined!");
    } else if (zonaEstacao == undefined) {
        res.status(400).send("A zona da estação está undefined!");
    } else {
        estacaoModel.cadastrar(nomeEstacao, linhaEstacao, zonaEstacao, fkEmpresa)
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
    cadastrar
}