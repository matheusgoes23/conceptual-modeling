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

INSERT INTO tb_client (name, email, cpf_or_cnpj, type) VALUES ('Emma', 'emma@gmail.com', '859.746.159-02', 0);
INSERT INTO tb_client (name, email, cpf_or_cnpj, type) VALUES ('Lisa', 'lisa@gmail.com', '513.589.456-55', 1);

INSERT INTO tb_telephone (phones, client_id) VALUES ('(85) 94568-2584', 1);
INSERT INTO tb_telephone (phones, client_id) VALUES ('(85) 91125-3694', 1);
INSERT INTO tb_telephone (phones, client_id) VALUES ('(85) 95821-4851', 2);

INSERT INTO tb_state (name) VALUES ('Ceará');
INSERT INTO tb_state (name) VALUES ('Rio Grande do Norte');

INSERT INTO tb_city (name, state_id) VALUES ('Fortaleza', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Aracati', 1);
INSERT INTO tb_city (name, state_id) VALUES ('Mossoró', 2);
INSERT INTO tb_city (name, state_id) VALUES ('Natal', 2);

INSERT INTO tb_address (public_place, number, complement, district, zip_code, client_id, city_id) VALUES ('Rua velha', '554A', 'Forúm', 'England', '859125-124', 1, 1);
INSERT INTO tb_address (public_place, number, complement, district, zip_code, client_id, city_id) VALUES ('Rua antiga', '007C', 'Sala nobre', 'Germany', '879423-874', 2, 2);