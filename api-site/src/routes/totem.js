var express = require("express");
var router = express.Router();

var totemController = require("../controllers/totemController");
/* 
router.get("/listar", function (req, res) {
    totemController.listar(req, res);
});
*/

router.post("/cadastrar", function (req, res) {
    totemController.cadastrar(req, res);
})
 

module.exports = router;