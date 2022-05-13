var colab, index;

function cadColab(nome, sobrenome, telefone, cargo, email, senha) {

    colab = document.getElementById("tbColab");
    var qntlinhas = colab.rows.length
    var linha = colab.insertRow(qntlinhas);
    var linhaParam;

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

    preecherCamposForm();
}

function altColab(nome, sobrenome, telefone, cargo, email, senha) {

    colab.rows[index].cells[0].innerHTML = nome
    colab.rows[index].cells[1].innerHTML = sobrenome
    colab.rows[index].cells[2].innerHTML = telefone
    colab.rows[index].cells[3].innerHTML = cargo
    colab.rows[index].cells[4].innerHTML = email
    colab.rows[index].cells[4].innerHTML = senha

}

function preecherCamposForm() {
    for (var i = 0; i < colab.rows.length; i++) {

        colab.rows[i].onclick = function() {

            index = this.rowIndex;
            document.getElementById("input_nome").value = colab.rows[index].cells[0].innerText;
            document.getElementById("input_sobrenome").value = colab.rows[index].cells[1].innerText;
            document.getElementById("tel").value = colab.rows[index].cells[2].innerText;
            document.getElementById("lista_funcao").value = colab.rows[index].cells[3].innerText;
            document.getElementById("input_email").value = colab.rows[index].cells[4].innerText;
            document.getElementById("input_senha").value = colab.rows[index].cells[5].innerText;
        }

    }
}

function delColab() {
    for (var i = 0; i < colab.rows.length; i++) {
        if (index == i) {
            colab.deletRow(index);
            return;
        }
    }
}