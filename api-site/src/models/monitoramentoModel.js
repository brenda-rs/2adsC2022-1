var database = require("../database/config")

/* -- select banco local
function buscarMedidasAtuais(idTotem) {
    instrucaoSql = `select estacao.nome as nome_estacao, status_totem as totem_status, componente_disco.id_componente as id_disco, 
    componente_disco.modelo as modelo_disco, uso_de_disco as disco_uso, disco_livre as disco_livre,
    componente_bobina.id_componente as id_bobina, cotas_disponiveis as disponiveis_cotas,
    componente_memoria.id_componente as id_memoria, componente_memoria.modelo as modelo_memoria, ram_livre as livre_ram, uso_ram as ram_uso,
    componente_cpu.id_componente as id_cpu, componente_cpu.modelo as modelo_cpu, tempo_cpu as velocidade_cpu, processos_cpu as cpu_processos from empresa 
    join estacao on fk_empresa = id_empresa
    join totem on fk_estacao = id_estacao 
    join medida_disco on medida_disco.fk_totem = id_totem
    join componente as componente_disco on fk_componente_disco = componente_disco.id_componente 
    join carga_papel on carga_papel.fk_totem = id_totem 
    join componente as componente_bobina on fk_componente_bobina = componente_bobina.id_componente
    join medida_memoria on medida_memoria.fk_totem = id_totem
    join componente as componente_memoria on  fk_componente_memoria = componente_memoria.id_componente
    join medida_cpu on medida_cpu.fk_totem = id_totem
    join componente as componente_cpu on fk_componente_cpu = componente_cpu.id_componente
    where id_totem = ${idTotem};`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}
*/

function buscarMedidasAtuais(idTotem) {
    instrucaoSql = `select estacao.nome as nome_estacao, status_totem as totem_status, 
    componente_bobina.id_componente as id_bobina, cotas_disponiveis as disponiveis_cotas from empresa 
    join estacao on fk_empresa = id_empresa 
    join totem on fk_estacao = id_estacao 
    join carga_papel on carga_papel.fk_totem = id_totem
    join componente as componente_bobina on fk_componente_bobina = componente_bobina.id_componente 
    where id_totem = ${idTotem};`;
    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasAtuaisCpu(idTotem) {
    instrucaoSql = `select tempo_cpu, id_componente as id_componente_cpu, cpu_velocidade_base as capacidade_cpu, 
    modelo as modelo_cpu,processos_cpu as processos from medida_cpu 
    join totem on medida_cpu.fk_totem = id_totem 
    join componente as componente_cpu on fk_componente_cpu = componente_cpu.id_componente
    where id_totem = ${idTotem} order by id_medida_cpu desc offset 8 rows fetch next 8 rows only;`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasAtuaisMemoria(idTotem) {
    instrucaoSql = `select id_componente as id_componente_memoria, memoria_total as memoria_total, modelo as modelo_memoria, ram_livre as livre_ram,
    uso_ram as ram_uso, id_medida_memoria as id_memoria_medida from medida_memoria join componente on fk_componente_memoria = id_componente
    join totem on fk_totem = id_totem where id_totem = ${idTotem} order by id_medida_memoria desc offset 1 rows fetch next 1 rows only;`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarMedidasAtuaisDisco(idTotem) {
    instrucaoSql = `select id_componente as id_componente_disco, disco_capacidade as capacidade_disco, uso_de_disco as disco_uso, modelo as modelo_disco, uso_de_disco, disco_livre, id_medida_disco from medida_disco join componente on fk_componente_disco = id_componente
    join totem on fk_totem = id_totem where id_totem = ${idTotem} order by id_medida_disco desc offset 1 rows fetch next 1 rows only;`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

function buscarEstacoes(idEmpresa) {
    instrucaoSql = `select id_estacao as fk_estacao, nome as nome_estacao from estacao join empresa on id_empresa = fk_empresa where fk_empresa = ${idEmpresa};`;

    console.log("Executando a instrução SQL: \n" + instrucaoSql);
    return database.executar(instrucaoSql);
}

module.exports = {
    buscarMedidasAtuais,
    buscarMedidasAtuaisCpu,
    buscarMedidasAtuaisMemoria,
    buscarMedidasAtuaisDisco,
    buscarEstacoes
};