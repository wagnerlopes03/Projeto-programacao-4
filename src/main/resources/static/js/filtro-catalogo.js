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