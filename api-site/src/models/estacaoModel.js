var database = require("../database/config")

function cadastrar(nomeEstacao, linhaEstacao, zonaEstacao, fkEmpresa) {
    //console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", nome, email, senha);
    var instrucao = `
        INSERT INTO estacao (nome, zona, status_estacao,fk_empresa) VALUES ('${nomeEstacao}','${zonaEstacao}','ATIVO','${fkEmpresa}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    cadastrar
};