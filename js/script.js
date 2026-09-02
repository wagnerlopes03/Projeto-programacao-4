const modal = document.getElementById("modal-noticia");
const fecharModal = document.getElementById("fechar-modal");
const modalImagem = document.getElementById("modal-imagem");
const modalTitulo = document.getElementById("modal-titulo");
const modalTexto = document.getElementById("modal-texto");
const botoesNoticias = document.querySelectorAll(".btn-ver-mais");

botoesNoticias.forEach(function (botao) {
    botao.addEventListener("click", function () {
        const card = botao.parentElement;
        const imagem = card.querySelector("img");
        const titulo = card.querySelector("h3");
        const textoCompleto = card.querySelector(".texto-completo");
        modalImagem.src = imagem.src;
        modalImagem.alt = imagem.alt;
        modalTitulo.textContent = titulo.textContent;
        modalTexto.innerHTML = textoCompleto.innerHTML;
        modal.style.display = "flex";
    });
});

fecharModal.addEventListener("click", function () {
    modal.style.display = "none";
});

function criarGlitter() {
    const glitter = document.createElement("span");
    glitter.classList.add("glitter");
    glitter.style.left = Math.random() * 100 + "%";
    glitter.style.top = Math.random() * 100 + "%";
    document.querySelector(".glitter-container").appendChild(glitter);
    setTimeout(function () {
        glitter.remove();
    }, 2000);

}

setInterval(criarGlitter, 1);