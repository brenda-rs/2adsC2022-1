var empresaModel = require("../models/empresaModel");

function cadastrar(req, res) {
    var razaoSocial = req.body.razaoSocial;
    var cnpj = req.body.cnpj;
    var telefone = req.body.telefone;
    if (razaoSocial == undefined) {
        res.status(400).send("razaoSocial está undefined!");
    } else if (cnpj == undefined) {
        res.status(400).send("cnpj está undefined!");
    } else if (telefone == undefined) {
        res.status(400).send("telefone está undefined!");
    } else {
        empresaModel.cadastrar(razaoSocial, cnpj, telefone)
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
//buscarFkEmpresa
function buscarFk(req, res) {
    var cnpj = req.body.cnpj;
    
    if (cnpj == undefined) {
        res.status(400).send("cnpj está undefined!");
    } else {
        empresaModel.buscarFk(cnpj)
            .then(
                function (resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Email e/ou senha inválido(s)");
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("Houve um erro ao realizar a busca da fk!", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrarEndereco(req, res) {
    var logradouro = req.body.logradouro;
    var uf = req.body.uf;
    var cidade = req.body.cidade;
    var numero = req.body.numero;
    var fk_empresa = req.body.fk_empresa
    if (logradouro == undefined) {
        res.status(400).send("razaoSocial está undefined!");
    } else if (uf == undefined) {
        res.status(400).send("cnpj está undefined!");
    } else if (cidade == undefined) {
        res.status(400).send("telefone está undefined!");
    } else {
        empresaModel.cadastrarEndereco(logradouro, uf, cidade, fk_empresa, numero)
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
    buscarFk,
    cadastrarEndereco
}