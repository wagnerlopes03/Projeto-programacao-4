const btnAbrirForm = document.getElementById("btn-abrir-form");
const formNovoTopico = document.getElementById("form-novo-topico");

if (btnAbrirForm) {
    btnAbrirForm.addEventListener("click", function () {
        if (formNovoTopico.style.display === "none") {
            formNovoTopico.style.display = "block";
        } else {
            formNovoTopico.style.display = "none";
        }
    });
}

const botoesCategoria = document.querySelectorAll(".item-categoria");
const topicos = document.querySelectorAll(".item-topico");

botoesCategoria.forEach(function (botao) {
    botao.addEventListener("click", function (evento) {
        evento.preventDefault();

        botoesCategoria.forEach(function (b) {
            b.classList.remove("ativo");
        });
        botao.classList.add("ativo");

        const categoriaEscolhida = botao.dataset.categoria;

        topicos.forEach(function (topico) {
            if (categoriaEscolhida === "todas" || topico.dataset.categoria === categoriaEscolhida) {
                topico.style.display = "flex";
            } else {
                topico.style.display = "none";
            }
        });
    });
});