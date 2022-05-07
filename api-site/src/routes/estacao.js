var express = require("express");
var router = express.Router();

var estacaoController = require("../controllers/estacaoController");

router.post("/cadastrar", function (req, res) {
    estacaoController.cadastrar(req, res);
})
 

module.exports = router;