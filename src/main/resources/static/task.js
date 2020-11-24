let titulo;
let descricao;
let statuss;
let geral;
let cortabela;

$(document).ready(function () {
    $("#form-tarefas").submit(function (event) {
        gravar();
    });//
});

function gravar() {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/desafio/novaTask/",
        data: JSON.stringify({ titulo: $("#titulo").val(), descricao: $("#descricao").val(), status: $("#status").val() }),
        dataType: "json",
        // cache: false,
        // timeout: 600000,
        error: function (e) {
            console.log("ERROR : ", e);
            $("#btn-gravar").prop("disabled", false);
        },
        success: function (data) {
            $("#titulo").val("fffff");
            // $("#descricao").val("");
            // $("#status").val("");


            // geral++
            // titulo = document.getElementById("titulo");
            // descricao = document.getElementById("descricao");
            // statuss = document.getElementById("status");
            // var tabela = document.getElementById("tabela");

            // var novaLinha = tabela.insertRow(-1);
            // var novaCelula;

            // if (geral % 2 == 0) {
            //     cortabela = "FFF5EE";
            // } else {
            //     cortabela = "FFFAF0";
            // }

            // novaCelula = novaLinha.insertCell(1);
            // novaCelula.style.backgroundColor = cortabela;
            // novaCelula.innerHTML = data.titulo;

            // novaCelula = novaLinha.insertCell(2);
            // novaCelula.style.backgroundColor = cortabela;
            // novaCelula.innerHTML = data.descricao;

            // novaCelula = novaLinha.insertCell(3);
            // novaCelula.style.backgroundColor = cortabela;
            // novaCelula.innerHTML = data.status;

            // novaCelula = novaLinha.insertCell(4);
            // novaCelula.style.backgroundColor = cortabela;
            // novaCelula.innerHTML = '<input type="button" class="btn btn-danger" value="X" onclick="deleteRow(this)"/>';
        }

    });
}

// function listaTaskCadastradas() {
//     geral++
//     titulo = document.getElementById("titulo");
//     descricao = document.getElementById("descricao");
//     statuss = document.getElementById("status");
//     var tabela = document.getElementById("tabela");

//     var novaLinha = tabela.insertRow(-1);
//     var novaCelula;

//     if (geral % 2 == 0) {
//         cortabela = "FFF5EE";
//     } else {
//         cortabela = "FFFAF0";
//     }

//     novaCelula = novaLinha.insertCell(1);
//     novaCelula.style.backgroundColor = cortabela;
//     novaCelula.innerHTML = titulo.value;

//     novaCelula = novaLinha.insertCell(2);
//     novaCelula.style.backgroundColor = cortabela;
//     novaCelula.innerHTML = descricao.value;

//     novaCelula = novaLinha.insertCell(3);
//     novaCelula.style.backgroundColor = cortabela;
//     novaCelula.innerHTML = statuss.value;

//     novaCelula = novaLinha.insertCell(4);
//     novaCelula.style.backgroundColor = cortabela;
//     novaCelula.innerHTML = '<input type="button" class="btn btn-danger" value="X" onclick="deleteRow(this)"/>';
// }



