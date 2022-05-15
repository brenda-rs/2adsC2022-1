var database = require("../database/config");

function buscarDados(fk_empresa) {
    var instrucao = `select id_totem as id_totem, status_totem as status_totem, estacao.nome as nome_estacao from totem join estacao
    on fk_estacao = id_estacao join empresa on fk_empresa = id_empresa where id_empresa = ${fk_empresa}`;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function excluirTotem(fk_totem) {
    var instrucao = `update totem set status_totem = 'Deletado' where id_totem = ${fk_totem}`;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    buscarDados,
    excluirTotem
};