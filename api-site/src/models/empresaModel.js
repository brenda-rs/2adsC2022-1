var database = require("../database/config")

function cadastrar(razaoSocial, cnpj, telefone) {
    var instrucao =
        `
        insert into empresa (razao_social, cnpj, telefone) values ('${razaoSocial}','${cnpj}','${telefone}');
   `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function cadastrarEndereco(logradouro, uf, cidade, fk_empresa, numero) {
    var instrucao =
        `
    insert into endereco_empresa(logradouro, numero, cidade, uf, fk_empresa) values('${logradouro}','${numero}','${uf}','${cidade}',${fk_empresa});
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function buscarFk(cnpj) {
    var instrucao =
        `
         select * from empresa where cnpj = '${cnpj}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function listar(status) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
        select * from empresa where status = '${status}';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function atualizar(razao_social, cnpj, telefone, id_empresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
    UPDATE empresa SET razao_social = '${razao_social}',
    cnpj = ${cnpj},
    telefone = '${telefone}'
    WHERE id_empresa = ${id_empresa};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function desativar(status, id_empresa) {
    console.log("Model desativar");
    var instrucao = `
        UPDATE empresa SET status = '${status}' WHERE id_empresa = ${id_empresa};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}


module.exports = {
    cadastrar,
    buscarFk,
    cadastrarEndereco,
    listar,
    atualizar,
    desativar
};