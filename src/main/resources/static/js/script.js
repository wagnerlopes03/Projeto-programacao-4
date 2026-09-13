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

(function () {
    const canvas = document.createElement('canvas');
    canvas.id = 'canvas-glitter-caindo';
    document.body.appendChild(canvas);
    const ctx = canvas.getContext('2d');

    let width, height;
    const particles = [];
    const particleCount = 500;

    const colors = ['#ffffff', '#ff1493', '#ffb6c1'];

    function resizeCanvas() {
        width = canvas.width = window.innerWidth;
        height = canvas.height = window.innerHeight;
    }
    window.addEventListener('resize', resizeCanvas);
    resizeCanvas();

    class FallingGlitter {
        constructor() {
            this.reset(true);
        }

        reset(initial = false) {
            this.x = Math.random() * width;
            this.y = initial ? Math.random() * height : -10;
            this.size = Math.random() * 3.5 + 1;
            this.speedY = Math.random() * 1 + 0.5;
            this.speedX = Math.random() * 0.4 - 0.2;
            this.opacity = Math.random() * 0.5 + 0.5;
            this.twinkleSpeed = Math.random() * 0.4 + 0.01;
            this.color = colors[Math.floor(Math.random() * colors.length)];
        }

        update() {
            this.y += this.speedY;
            this.x += this.speedX;
            this.opacity += this.twinkleSpeed;
            if (this.opacity >= 1 || this.opacity <= 0.3) {
                this.twinkleSpeed = -this.twinkleSpeed;
            }

            if (this.y > height) {
                this.reset();
            }
        }

        draw() {
            ctx.save();
            ctx.globalAlpha = Math.max(0, this.opacity);
            ctx.fillStyle = this.color;
            ctx.shadowBlur = 10;
            ctx.shadowColor = this.color;
            ctx.beginPath();
            ctx.translate(this.x, this.y);
            ctx.rotate(45 * Math.PI / 180);
            ctx.fillRect(-this.size / 2, -this.size / 2, this.size, this.size);
            ctx.restore();
        }
    }

    for (let i = 0; i < particleCount; i++) {
        particles.push(new FallingGlitter());
    }

    const sectionInicio = document.getElementById('inicio');
    const canvasElement = document.getElementById('canvas-glitter-caindo');
    let isInsideInicio = true;

    function animate() {
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
        const inicioHeight = sectionInicio.offsetHeight;

        if (scrollTop > inicioHeight - 100) {
            if (isInsideInicio) {
                canvasElement.style.display = 'block';
                isInsideInicio = false;
            }

            ctx.clearRect(0, 0, width, height);
            particles.forEach(p => {
                p.update();
                p.draw();
            });
        } else {
            if (!isInsideInicio) {
                canvasElement.style.display = 'none';
                isInsideInicio = true;
            }
        }

        requestAnimationFrame(animate);
    }

    animate()
})();