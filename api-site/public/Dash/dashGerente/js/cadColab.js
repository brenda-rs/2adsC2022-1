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
    var callAcao = linha.insertCell(6);

    cellNome.innerHTML = nome;
    cellSobrenome.innerHTML = sobrenome;
    cellTelefone.innerHTML = telefone;
    cellCargo.innerHTML = cargo;
    cellEmail.innerHTML = email;
    cellSenha.innerHTML = senha;

    callAcao.classList.add('btn-group');

    var bt = document.createElement('button');
    callAcao.appendChild(bt);
    bt.classList.add('btn-info');
    bt.classList.add('btn');

    var imgEdit = document.createElement('i');
    bt.appendChild(imgEdit);
    imgEdit.classList.add('fa-edit');
    imgEdit.classList.add('fa');

    var bt = document.createElement('button');
    callAcao.appendChild(bt);
    bt.classList.add('btn-info');
    bt.classList.add('btn');

    var imgDel = document.createElement('i');
    bt.appendChild(imgDel);
    imgDel.classList.add('fa-trash');
    imgDel.classList.add('fa');



    preecherCamposForm();
    limpar();
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

function limpar() {
    document.getElementById("input_nome").value = '';
    document.getElementById("input_sobrenome").value = '';
    document.getElementById("tel").value = '';
    document.getElementById("lista_funcao").value = '';
    document.getElementById("input_email").value = '';
    document.getElementById("input_senha").value = '';
}


function cadastrar() {
    //aguardar();

    var nomeVar = input_nome.value;
    var sobrenomeVar = input_sobrenome.value;
    var telefoneVar = tel.value;
    var nivel_acessoVar = lista_funcao.value;
    var emailVar = input_email.value;
    var senhaVar = input_senha.value;
    var funcaoVar = "";
    if (nivel_acessoVar == 1) {
        funcaoVar = "Manuteção";
    } else if (nivel_acessoVar == 2) {
        funcaoVar = "Gerente";
    } else {
        funcaoVar = "eagle totens";
    }
    nomeVar = nomeVar + " " + sobrenomeVar;

    fetch("/colaboradores/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nome: nomeVar,
            telefone: telefoneVar,
            nivel_acesso: nivel_acessoVar,
            funcao: funcaoVar,
            email: emailVar,
            senha: senhaVar,
        })
    }).then(function(resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            window.location = "cadastroColaborador.html";
            finalizarAguardar();
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function(resposta) {
        console.log(`#ERRO: ${resposta}`);
        //finalizarAguardar();
    });
}