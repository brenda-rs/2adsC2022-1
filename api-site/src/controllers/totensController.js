var totensModel = require("../models/totensModel");

function buscarDadosBobina(req, res) {
    var fk_totem = req.body.fk_totem;

    if (fk_totem == undefined) {
        
        res.status(400).send("Totem está undefined");
    } else {
        totensModel.buscarDados(fk_totem)
            .then(
                function (resultado) {
                    console.log(`\nResultados encontrados: ${resultado.length}`);
                    console.log(`Resultados: ${JSON.stringify(resultado)}`); // transforma JSON em String

                    if (resultado.length == 1) {
                        console.log(resultado);
                        res.json(resultado[0]);
                    }
                }
            ).catch(
                function (erro) {
                    console.log(erro);
                    console.log("\nHouve um erro ao buscar dados da bobina! Erro: ", erro.sqlMessage);
                    res.status(500).json(erro.sqlMessage);
                }
            );
    }
}

module.exports = {
    buscarDadosBobina
}