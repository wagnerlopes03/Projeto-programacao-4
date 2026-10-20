INSERT INTO categoria (nome) VALUES
    ('Geral'),
    ('Lançamentos'),
    ('Coleções'),
    ('Especiais'),
    ('Destaques');

INSERT INTO noticia (id_categoria, titulo, descricao) VALUES
    ((SELECT id FROM categoria WHERE nome = 'Especiais'), 'Lançamento da primeira Barbie com autismo', 'A Mattel lança a primeira boneca com autismo, promovendo inclusão e diversidade no mundo das brincadeiras.'),
    ((SELECT id FROM categoria WHERE nome = 'Geral'), 'Barbie e a Sustentabilidade', 'A Mattel anuncia novas iniciativas para tornar a produção da Barbie mais sustentável e amiga do meio ambiente.'),
    ((SELECT id FROM categoria WHERE nome = 'Lançamentos'), 'Mattel revela a Barbie Holiday 2026', 'A boneca comemorativa deste ano vem em um vestido vermelho longo, com brincos prateados e sapatos combinando.'),
    ((SELECT id FROM categoria WHERE nome = 'Lançamentos'), 'Barbie in the Nutcracker ganha novo especial', 'Para celebrar 25 anos do clássico, a Netflix estreia uma nova versão animada com Malibu Barbie no papel de Clara.'),
    ((SELECT id FROM categoria WHERE nome = 'Coleções'), 'Linha Fashionista ganha Barbie surda', 'A nova boneca usa aparelho auditivo rosa choque, marcando mais um passo da Mattel em representar a diversidade.'),
    ((SELECT id FROM categoria WHERE nome = 'Coleções'), 'Ken com vitiligo chega à coleção inclusiva', 'Além de bonecas cadeirantes e com próteses coloridas, a Mattel expande a linha Fashionista com um Ken representando pessoas com vitiligo.'),
    ((SELECT id FROM categoria WHERE nome = 'Especiais'), 'Barbie com síndrome de Down segue fazendo história', 'O vestido da boneca traz corações com três setas, representando o terceiro cromossomo 21 característico da síndrome.'),
    ((SELECT id FROM categoria WHERE nome = 'Especiais'), 'Barbie com deficiência visual traz braille na embalagem', 'Desenvolvida com a American Foundation for the Blind, a boneca já mostra acessibilidade desde a caixa.'),
    ((SELECT id FROM categoria WHERE nome = 'Especiais'), 'Mattel lança boneca inspirada em Opal Lee', 'A "avó do Juneteenth" ganha sua própria Barbie, com a história da educadora e ativista contada na embalagem.'),
    ((SELECT id FROM categoria WHERE nome = 'Geral'), 'Como a Barbie segue relevante décadas depois', 'A marca aposta em parcerias e experiências para transformar fama cultural em crescimento de vendas.'),
    ((SELECT id FROM categoria WHERE nome = 'Destaques'), 'Evento Especial: Barbie Collector', 'Confira o evento exclusivo para colecionadores de Barbies e descubra peças raras e edições limitadas.');
