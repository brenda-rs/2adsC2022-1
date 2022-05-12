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

    const tel = document.getElementById('tel') // Seletor do campo de telefone

    tel.addEventListener('keypress', (e) => mascaraTelefone(e.target.value)) // Dispara quando digitado no campo
    tel.addEventListener('change', (e) => mascaraTelefone(e.target.value)) // Dispara quando autocompletado o campo

    const mascaraTelefone = (valor) => {
        valor = valor.replace(/\D/g, "")
        valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
        valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
        tel.value = valor // Insere o(s) valor(es) no campo
    }


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