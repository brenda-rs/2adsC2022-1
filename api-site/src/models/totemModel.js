var database = require("../database/config")

function cadastrar(id_host, fk_estacao) {
    var instrucao = `
        INSERT INTO totem (id_host, status_totem, fk_estacao) VALUES ('${id_host}','ATIVO','${fk_estacao}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}
 
function cadastrarComponenteCpu(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade) {
    var instrucao = `
    INSERT INTO componente (tipo, modelo, marca, data_implementada, bobina_cota_total, memoria_total, cpu_velocidade_base, disco_capacidade) VALUES ('CPU', '${modelo}', '${marca}', '${data_implementada}', '10', '${memoria_total}', '${cpu_velocidade_base}', '${disco_capacidade}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarComponenteDisco(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade) {
    var instrucao = `
    INSERT INTO componente (tipo, modelo, marca, data_implementada, bobina_cota_total, memoria_total, cpu_velocidade_base, disco_capacidade) VALUES ('DISCO', '${modelo}', '${marca}', '${data_implementada}', '10', '${memoria_total}', '${cpu_velocidade_base}', '${disco_capacidade}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarComponenteMemoria(modelo, marca, data_implementada, memoria_total, cpu_velocidade_base, disco_capacidade) {
    var instrucao = `
    INSERT INTO componente (tipo, modelo, marca, data_implementada, bobina_cota_total, memoria_total, cpu_velocidade_base, disco_capacidade) VALUES ('MEMORIA', '${modelo}', '${marca}', '${data_implementada}', '10', '${memoria_total}', '${cpu_velocidade_base}', '${disco_capacidade}');
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

module.exports = {
    cadastrar,
    cadastrarComponenteCpu,
    cadastrarComponenteDisco,
    cadastrarComponenteMemoria,
};