var express = require("express");
var router = express.Router();

var monitoramentoController = require("../controllers/monitoramentoController");

router.get("/medidas/:idTotem", function (req, res) {
    monitoramentoController.buscarMedidasAtuais(req, res);
})

router.get("/medidasCpu/:idTotem", function (req, res) {
    monitoramentoController.buscarMedidasAtuaisCpu(req, res);
})

router.get("/medidasMemoria/:idTotem", function (req, res) {
    monitoramentoController.buscarMedidasAtuaisMemoria(req, res);
})

router.get("/medidasDisco/:idTotem", function (req, res) {
    monitoramentoController.buscarMedidasAtuaisDisco(req, res);
})

router.get("/estacoes/:fkEmpresa", function (req, res) {
    monitoramentoController.buscarEstacoes(req, res);
})

module.exports = router;