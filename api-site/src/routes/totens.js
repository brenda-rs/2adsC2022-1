var express = require("express");
var router = express.Router();

var totensController = require("../controllers/totensController");

router.get("/buscarDados/:fk_Empresa", function (req, res) {
    totensController.buscarDados(req, res);
});

router.put("/excluirTotem", function (req, res) {
    totensController.excluirTotem(req, res);
});

router.put("/atualizar", function (req, res) {
    totensController.atualizarTotem(req, res);
});

module.exports = router;