const botoesFiltro = document.querySelectorAll(".filtro-pill");
const cards = document.querySelectorAll(".card-boneca");

botoesFiltro.forEach(function (botao) {
    botao.addEventListener("click", function () {
        botoesFiltro.forEach(function (b) {
            b.classList.remove("ativo");
        });
        botao.classList.add("ativo");

        const categoriaEscolhida = botao.dataset.categoria;

        cards.forEach(function (card) {
            if (categoriaEscolhida === "todas" || card.dataset.categoria === categoriaEscolhida) {
                card.style.display = "block";
            } else {
                card.style.display = "none";
            }
        });
    });
});

const pesquisaFiltroListagem = document.getElementById("pesquisa-bonecas");

pesquisaFiltroListagem.addEventListener("input", function () {
    const textoDigitado = pesquisaFiltroListagem.value;
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