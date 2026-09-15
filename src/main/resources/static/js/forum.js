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