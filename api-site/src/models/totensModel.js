var database = require("../database/config");

function buscarDados(fk_totem) {
    var instrucao = `select * from carga_papel where fk_totem = ${fk_totem} order by data_hora_medida_bobina desc offset 1 rows fetch next 1 rows only;`;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    buscarDados
};