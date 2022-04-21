var express = require("express");
var router = express.Router();

var colaboradorController = require("../controllers/colaboradorController");

/* router.get("/", function (req, res) {
    usuarioController.testar(req, res);
});

router.get("/listar", function (req, res) {
    usuarioController.listar(req, res);
});
*/
router.post("/autenticar", function (req, res) {
    colaboradorController.entrar(req, res);
});

router.post("/cadastrar", function (req, res) {
    colaboradorController.cadastrar(req, res);
})
 

module.exports = router;