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
                function(resultado) {
                    res.json(resultado);
                }
            ).catch(
                function(erro) {
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
                function(resultado) {
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
                function(erro) {
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
                function(resultado) {
                    res.json(resultado);
                }
            ).catch(
                function(erro) {
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

function listar(req, res) {
    /* var status = req.body.status;
    if (status == undefined) {
        console.log("status inválido")
    } else { */
    empresaModel.listar()
        .then(function(resultado) {
            if (resultado.length > 0) {
                res.status(200).json(resultado);
            } else {
                res.status(204).send("Nenhum resultado encontrado!")
            }
        }).catch(
            function(erro) {
                console.log(erro);
                console.log("Houve um erro ao realizar a consulta! Erro: ", erro.sqlMessage);
                res.status(500).json(erro.sqlMessage);
            }
        );

}

function atualizar(req, res) {
    var razao_social = req.body.razao_social;
    var cnpj = req.body.cnpj;
    var telefone = req.body.telefone;
    var id_empresa = req.body.id_empresa;
    if (razao_social == undefined) {
        res.status(400).send("Sua razão social está undefined!");
    } else if (cnpj == undefined) {
        res.status(400).send("Seu cnpj está undefined!");
    } else if (telefone == undefined) {
        res.status(400).send("Sua telefone está undefined!");
    } else if (id_empresa == undefined) {
        res.status(400).send("Sua id empresa está undefined!");
    } else {
        empresaModel.atualizar(razao_social, cnpj, telefone, id_empresa)
            .then(
                function(resultado) {
                    res.json(resultado);
                }
            ).catch(
                function(erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro o update! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

function desativar(req, res) {
    var status = req.body.status;
    var id_empresa = req.body.id_empresa;
    if (status == undefined) {
        res.status(400).send("Sua razão social está undefined!");
    } else if (id_empresa == undefined) {
        res.status(400).send("Seu id_empresa está undefined!");
    } else {
        empresaModel.desativar(status, id_empresa)
            .then(
                function(resultado) {
                    res.json(resultado);
                }
            ).catch(
                function(erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao desativar! Erro: ",
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
    cadastrarEndereco,
    listar,
    atualizar,
    desativar
}