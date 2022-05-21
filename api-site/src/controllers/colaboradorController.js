var colaboradorModel = require("../models/colaboradorModel");

var sessoes = [];

function deletar(req, res) {
    var idColaborador = req.body.idColaborador;
    if (idColaborador == undefined) {
        res.status(400).send("id Colaborador undefined!");
    } else {
        colaboradorModel.deletar(idColaborador)
            .then(
                function(resultado) {
                    res.json(resultado);
                }
            ).catch(
                function(erro) {
                    console.log(erro);
                    console.log(
                        "\nHouve um erro no delete! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}


function atualizar(req, res) {
    var nome = req.body.nome;
    var telefone = req.body.telefone;
    var nivel_acesso = req.body.nivel_acesso;
    var funcao = req.body.funcao;
    var email = req.body.email;
    var senha = req.body.senha;
    var idColaborador = req.body.idColaborador;
    if (nome == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else if (idColaborador == undefined) {
        res.status(400).send("id Colaborador undefined!");
    } else {
        colaboradorModel.atualizar(nome, nivel_acesso, funcao, telefone, email, senha, idColaborador)
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

function listar(req, res) {
    var fkEmpresa = req.body.fkEmpresa;
    if (fkEmpresa == undefined) {
        console.log("fkEmpresa está undefined")
    } else {
        colaboradorModel.listar(fkEmpresa)
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
}

function entrar(req, res) {
    var email = req.body.email;
    var senha = req.body.senha;

    if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está indefinida!");
    } else {
        colaboradorModel.entrar(email, senha)
            .then(
                function(resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    } else if (resultado.length == 0) {
                        res.status(403).send("Email e/ou senha inválido(s)");
                    } else {
                        res.status(403).send("Mais de um usuário com o mesmo login e senha!");
                    }
                }
            ).catch(
                function(erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao realizar o login! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }

}

function cadastrar(req, res) {
    var nome = req.body.nome;
    var telefone = req.body.telefone;
    var nivel_acesso = req.body.nivel_acesso;
    var funcao = req.body.funcao;
    var email = req.body.email;
    var senha = req.body.senha;
    var fkEmpresa = req.body.fkEmpresa;

    if (nome == undefined) {
        res.status(400).send("Seu nome está undefined!");
    } else if (email == undefined) {
        res.status(400).send("Seu email está undefined!");
    } else if (senha == undefined) {
        res.status(400).send("Sua senha está undefined!");
    } else {
        colaboradorModel.cadastrar(nome, nivel_acesso, funcao, telefone, email, senha, fkEmpresa)
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

module.exports = {
    cadastrar,
    entrar,
    listar,
    atualizar,
    deletar
}