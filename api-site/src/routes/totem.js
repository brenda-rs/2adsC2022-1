var express = require("express");
var router = express.Router();

var totemController = require("../controllers/totemController");

router.post("/cadastrar", function (req, res) {
    totemController.cadastrar(req, res);
})

router.post("/cadastrarComponenteCpu", function (req, res) {
    totemController.cadastrarComponenteCpu(req, res);
})

router.post("/cadastrarComponenteDisco", function (req, res) {
    totemController.cadastrarComponenteDisco(req, res);
})

router.post("/cadastrarComponenteMemoria", function (req, res) {
    totemController.cadastrarComponenteMemoria(req, res);
})

module.exports = router;