var express = require("express");
var router = express.Router();

var totensController = require("../controllers/totensController");

router.post("/buscarDados", function (req, res) {
    totensController.buscarDadosBobina(req, res);
});

module.exports = router;