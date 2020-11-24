let titulo;
let descricao;
let statuss;
let geral;
let cortabela;

$(document).ready(function () {
    $("#form-tarefas").submit(function (event) {
        gravar();
    });
});

function gravar() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/desafio/novaTask/",
        data: JSON.stringify({ titulo: $("#titulo").val(), descricao: $("#descricao").val(), status: $("#status").val()}),
        dataType: "json",
        timeout: 600000,
        error: function (e) {
            console.log("ERROR : ", e);
            // $("#btn-gravar").prop("disabled", false);
        },
        success: function (data) {
            $("#titulo").val("");
            $("#descricao").val("");
            $("#status").val("");
        }

    });
}



