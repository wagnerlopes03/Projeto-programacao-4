INSERT INTO usuario (nome, email, senha)
VALUES ('Usuária Dreamhouse', 'seed@dreamhouse.com', 'senha123')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO posts (topico, descricao, id_usuario, id_categoria)
VALUES
    (
        'Dicas pra guardar bonecas sem estragar a caixa?',
        'Gente, comprei umas bonecas colecionáveis e quero guardar direitinho pra não perder valor. Alguém tem dica de como guardar as caixas sem elas amassarem ou desbotarem com o tempo?',
        (SELECT id FROM usuario WHERE email = 'seed@dreamhouse.com'),
        (SELECT id FROM categoria WHERE nome = 'SOS com a Fada Madrinha')
    ),
    (
        'Qual filme da Barbie vocês assistiram mais vezes?',
        'Eu já perdi a conta de quantas vezes assisti Barbie e as 12 Princesas Bailarinas. Qual é o filme que vocês mais rodam?',
        (SELECT id FROM usuario WHERE email = 'seed@dreamhouse.com'),
        (SELECT id FROM categoria WHERE nome = 'Conversa com Princesas')
    ),
    (
        'Achei minha Barbie Signature 65 Anos numa garagem sale!',
        'Vocês não vão acreditar, achei a Barbie Signature Aniversário de 65 Anos numa garagem sale por uma fração do preço de loja. Alguém mais já teve sorte assim?',
        (SELECT id FROM usuario WHERE email = 'seed@dreamhouse.com'),
        (SELECT id FROM categoria WHERE nome = 'Caça ao Tesouro')
    );