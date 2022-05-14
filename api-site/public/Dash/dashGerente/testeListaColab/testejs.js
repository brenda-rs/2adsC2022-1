class Colaborador {

    constructor() {

        this.id = 1;
        this.arrayColaborador = [];
    }
    adicionar() {
        alert('olá mundo');
    }

    salvar() {
        let colaborador = this.lerDados();

        if (this.validaCampo(colaborador)) {

            this.adicionar(colaborador);

            alert('Alterações salva');
        }

        console.log(this, this.arrayColaborador);
    }
    adicionar(colaborador) {
        this.arrayColaborador.push(colaborador);
        this.id++;
    }

    lerDados() {
        let dadoColab = {}

        dadoColab.nomeColab = document.getElementById('input_nome').value;
        dadoColab.sobrenomeColab = document.getElementById('input_sobrenome').value;
        dadoColab.telColab = document.getElementById('tel').value;
        dadoColab.cargoColab = document.getElementById('lista_funcao').value;
        dadoColab.emailColab = document.getElementById('input_email').value;
        dadoColab.senhaColab = document.getElementById('input_senha').value;

        return dadoColab;
    }

    cancelar() {

    }
    validaCampo(colaborador) {
        let msg = '';
        if (colaborador.nomeColab == '') {
            msg += 'Informe o nome do Colaborador'
        }
        if (colaborador.sobrenomeColab == '') {
            msg += 'Informe o sobre nome do Colaborador'
        }
        if (colaborador.telColab == '') {
            msg += 'Informe o telefone do Colaborador'
        }
        if (colaborador.cargoColab == '') {
            msg += 'Informe o cargo do Colaborador'
        }
        if (colaborador.emailColab == '') {
            msg += 'Informe o email do Colaborador'
        }
        if (colaborador.senhaColab == '') {
            msg += 'Informe a senha do Colaborador'
        }
        if (msg != '') {
            alert(msg);
            return false;
        }

        return true;
    }
}
var colaborador = new Colaborador