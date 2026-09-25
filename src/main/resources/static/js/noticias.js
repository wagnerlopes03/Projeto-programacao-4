const pesquisaFiltro = document.getElementById("pesquisa-filtro");
const cards = document.querySelectorAll(".card-noticia-grid");

pesquisaFiltro.addEventListener("input", function () {
    const textoDigitado = pesquisaFiltro.value;
    cards.forEach(function (card) {
        const titulo = card.querySelector("h3");
        const tituloTexto = titulo.textContent;
        if (tituloTexto.toLowerCase().includes(textoDigitado.toLowerCase())){
            card.style.display = "block";
        } else{
            card.style.display = "none";
        }
    });
});