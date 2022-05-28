var express = require("express");
var router = express.Router();

var empresaController = require("../controllers/empresaController");

router.post("/cadastrar", function (req, res) {
    empresaController.cadastrar(req, res);
})

router.post("/buscarFk", function (req, res) {
    empresaController.buscarFk(req, res);
})


router.post("/cadastrarEndereco", function (req, res) {
    empresaController.cadastrarEndereco(req, res);
})

router.get("/listar", function (req, res) {
    empresaController.listar(req, res);
})

router.put("/atualizarEmpresa", function (req, res) {
    empresaController.atualizarEmpresa(req, res);
})

router.put("/atualizarEndereco", function (req, res) {
    empresaController.atualizarEndereco(req, res);
})


router.put("/desativar", function (req, res) {
    empresaController.desativar(req, res);
})

router.post("/puxarDadosEmpresa", function (req, res) {
    empresaController.puxar_dados_empresa(req, res);
})


module.exports = router;