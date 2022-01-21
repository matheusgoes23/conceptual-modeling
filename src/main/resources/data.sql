INSERT INTO tb_category (name) VALUES ('Informatica');
INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Eletronicos');
INSERT INTO tb_category (name) VALUES ('Acessorios');

INSERT INTO tb_product (name, price) VALUES ('Notebook', 4000.0);
INSERT INTO tb_product (name, price) VALUES ('Câmera', 500.0);
INSERT INTO tb_product (name, price) VALUES ('Clean Code', 135.0);
INSERT INTO tb_product (name, price) VALUES ('Banco de Dados', 112.8);
INSERT INTO tb_product (name, price) VALUES ('Relógio', 132.2);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 4);
