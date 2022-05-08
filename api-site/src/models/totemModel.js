var database = require("../database/config")

/* function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        SELECT * FROM totem;
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
} 
 */
function cadastrar(id_totem, id_host, status_totem, fk_estacao) {
    console.log("ACESSEI O TOTEM MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function cadastrar():", id_totem, id_host, status_totem, fk_estacao);
    var instrucao = `
        INSERT INTO totem (id_totem, id_host, status_totem, fk_estacao) VALUES ('${id_totem}','${id_host}','${status_totem}','${fk_estacao}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    cadastrar,
    // listar
};