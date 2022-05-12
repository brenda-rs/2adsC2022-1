function cadColab(nome, sobrenome, telefone, cargo, email, senha) {

    var tb = document.getElementById("tbColab");
    var qntlinhas = tb.rows.length
    var linha = tb.insertRow(qntlinhas);

    var cellNome = linha.insertCell(0);
    var cellSobrenome = linha.insertCell(1)
    var cellTelefone = linha.insertCell(2);
    var cellCargo = linha.insertCell(3);
    var cellEmail = linha.insertCell(4);
    var cellSenha = linha.insertCell(5);

    cellNome.innerHTML = nome;
    cellSobrenome.innerHTML = sobrenome;
    cellTelefone.innerHTML = telefone;
    cellCargo.innerHTML = cargo;
    cellEmail.innerHTML = email;
    cellSenha.innerHTML = senha;
}