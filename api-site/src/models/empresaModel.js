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




module.exports = {
    cadastrar,
    buscarFk,
    cadastrarEndereco
};