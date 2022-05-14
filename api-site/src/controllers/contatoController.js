var contatoModel = require("../models/contatoModel");

function contato(req, res) {

    var nome = req.body.nome;
    var email = req.body.email;
    var telefone = req.body.telefone;
    var descricao = req.body.descricao;

    if (nome == undefined) {

        res.status(400).send("nome está undefined!");
    } else if (email == undefined) {

        res.status(400).send("email está undefined!");
    } else if (telefone == undefined) {

        res.status(400).send("telefone está undefined!");
    } else if (descricao == undefined) {

        res.status(400).send("descrição está undefined!");
    } else {

        contatoModel.contato(nome, email, telefone, descricao)
            .then(

                function (resultado) {

                    res.json(resultado);
                }
            ).catch(

                function(erro){

                    console.log(erro);
                    console.log(
                        "\nHouve um erro ao enviar as informações! Erro: ",
                        erro.sqlMessage
                    );
                    res.status(500).json(erro.sqlMessage);
                }
            )
    }
}

module.exports = {
    contato
}