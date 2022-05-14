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

router.delete("/deletar", function (req, res) {
    colaboradorController.deletar(req, res);
});

router.put("/atualizar", function (req, res) {
    colaboradorController.atualizar(req, res);
});

router.post("/listar", function (req, res) {
    colaboradorController.listar(req, res);
});

router.post("/autenticar", function (req, res) {
    colaboradorController.entrar(req, res);
});

router.post("/cadastrar", function (req, res) {
    colaboradorController.cadastrar(req, res);
})
 

module.exports = router;