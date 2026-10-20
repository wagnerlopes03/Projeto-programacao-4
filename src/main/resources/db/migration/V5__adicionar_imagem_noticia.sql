ALTER TABLE noticia ADD COLUMN imagem_url VARCHAR(500);

UPDATE noticia SET imagem_url = '/assets/barbie_holiday_2026.jpg' WHERE titulo LIKE '%Holiday 2026%';
UPDATE noticia SET imagem_url = '/assets/barbie_nutcracker.jpg' WHERE titulo LIKE '%Nutcracker%';
UPDATE noticia SET imagem_url = '/assets/barbie_surda.jpg' WHERE titulo LIKE '%surda%';
UPDATE noticia SET imagem_url = '/assets/ken_vitiligo.jpg' WHERE titulo LIKE '%vitiligo%';
UPDATE noticia SET imagem_url = '/assets/barbie_down.jpg' WHERE titulo LIKE '%Down%';
UPDATE noticia SET imagem_url = '/assets/barbie_deficiencia_visual.jpg' WHERE titulo LIKE '%deficiência visual%';
UPDATE noticia SET imagem_url = '/assets/barbie_opal_lee.jpg' WHERE titulo LIKE '%Opal Lee%';
UPDATE noticia SET imagem_url = '/assets/barbie_estrategia.jpg' WHERE titulo LIKE '%relevante%';
UPDATE noticia SET imagem_url = '/assets/barbie_convention.jpg' WHERE titulo LIKE '%Barbie Collector%';
UPDATE noticia SET imagem_url = '/assets/barbie_autismo.jpg' WHERE titulo LIKE '%autismo%';
UPDATE noticia SET imagem_url = '/assets/sustentabilidade.jpg' WHERE titulo LIKE '%Sustentabilidade%';