var database = require("../database/config")

function cadastrar(razaoSocial, cnpj, telefone) {
    var instrucao =
        `
        insert into empresa (razao_social, cnpj, telefone, status) values ('${razaoSocial}','${cnpj}','${telefone}','ativo');
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

function listar() {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
    select * from empresa join endereco_empresa on fk_empresa = id_empresa where status = 'ativo';
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function puxar_dados_empresa(id_empresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
     select * from empresa join endereco_empresa on fk_empresa = id_endereco where status = 'ativo' and id_empresa = ${id_empresa};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function atualizarEmpresa(razao_social, cnpj, telefone, id_empresa) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
    update empresa set razao_social = '${razao_social}', cnpj = '${cnpj}', telefone = ${telefone} where id_empresa = ${id_empresa};
    `;
    console.log("Executando a instrução SQL: \n" + instrucao);
    return database.executar(instrucao);
}

function atualizarEndereco(id_empresa, logradouro, numero, uf, cidade) {
    console.log("ACESSEI O USUARIO MODEL \n \n\t\t >> Se aqui der erro de 'Error: connect ECONNREFUSED',\n \t\t >> verifique suas credenciais de acesso ao banco\n \t\t >> e se o servidor de seu BD está rodando corretamente. \n\n function listar()");
    var instrucao = `
    update endereco_empresa set logradouro = '${logradouro}', numero = ${numero}, cidade = '${cidade}', uf = '${uf}' where fk_empresa = ${id_empresa};
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
    atualizarEmpresa,
    atualizarEndereco,
    desativar,
    puxar_dados_empresa
};