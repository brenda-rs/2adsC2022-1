//process.env.AMBIENTE_PROCESSO = "desenvolvimento";
process.env.AMBIENTE_PROCESSO = "producao";

var express = require("express");
var cors = require("cors");
var path = require("path");
var PORTA = 3333;

var app = express();

var indexRouter = require("./src/routes/index");
var colaboradorRouter = require("./src/routes/colaborador");
var estacaoRouter = require("./src/routes/estacao");
var empresaRouter = require("./src/routes/empresa");
var totensRouter = require("./src/routes/totens");
var totemRouter = require("./src/routes/totem");
var monitoramentoRouter = require("./src/routes/monitoramento");
var contatoRouter = require("./src/routes/contatoIndex");

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, "public")));

app.use(cors());

app.use("/", indexRouter);
app.use("/colaboradores", colaboradorRouter);
app.use("/estacao", estacaoRouter);
app.use("/empresa", empresaRouter);
app.use("/totens", totensRouter);
app.use("/totem", totemRouter);
app.use("/monitoramento", monitoramentoRouter);
app.use("/monitoramentoCpu", monitoramentoRouter);
app.use("/monitoramentoMemoria", monitoramentoRouter);
app.use("/monitoramentoDisco", monitoramentoRouter);
app.use("/contato", contatoRouter);

app.listen(PORTA, function() {
    console.log(`Servidor do site está rodando rodando: http://localhost:${PORTA} \n
    Você está rodando sua aplicação em ${process.env.AMBIENTE_PROCESSO} \n
    \t\tSe "desenvolvimento", banco local (MySQL Workbench). \n
    \t\tSe "producao", banco remoto (SQL Server em nuvem Azure)`);
});