var database = require("../database/config");

function contato(nome, email, telefone, descricao) {

    var instrucao =
        `
        insert into externo_lead (nome, email, telefone, descricao) values ('${nome}','${email}','${telefone}','${descricao}');
   `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    contato
}