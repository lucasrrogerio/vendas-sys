INSERT INTO endereco (id, cep, cidade, complemento, uf, logradouro, numero) VALUES (nextval('hibernate_sequence'), '21730660', 'Rio de Janeiro', null, 'Rio de Janeiro', 'Rua Mendonça Lima', '123');
INSERT INTO endereco (id, cep, cidade, complemento, uf, logradouro, numero) VALUES (nextval('hibernate_sequence'), '23575450', 'Rio de Janeiro', null, 'Rio de Janeiro', 'Estrada da Lama Preta', '84');
INSERT INTO endereco (id, cep, cidade, complemento, uf, logradouro, numero) VALUES (nextval('hibernate_sequence'), '23059810', 'Rio de Janeiro', null, 'Rio de Janeiro', 'Beco Santana', '1');

INSERT INTO fornecedor (id, cnpj, razao_social, endereco_id) VALUES (nextval('hibernate_sequence'), '65977993000100', 'Asfatex', 1);
INSERT INTO fornecedor (id, cnpj, razao_social, endereco_id) VALUES (nextval('hibernate_sequence'), '29995209000114', 'Bolhas e Bolhas', 2);
INSERT INTO fornecedor (id, cnpj, razao_social, endereco_id) VALUES (nextval('hibernate_sequence'), '63367244000127', 'Boi Morto', 3);

INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'HIG', 'Higiene');
INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'CER', 'Cereais');
INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'LIM', 'Limpeza');
INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'BEB', 'Bebidas');
INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'FRI', 'Frios');
INSERT INTO categoria (id, codigo, nome) VALUES (nextval('hibernate_sequence'), 'CON', 'Congelados');

INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'gabriel@id.uff.br', 'Gabriel Brandao', '13579', 'VENDEDOR');
INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'lucas@id.uff.br', 'Lucas Rogério', '12345', 'GERENTE');
INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'jose@id.uff.br', 'Jose Emiliano Junior', '24680', 'VENDEDOR');
INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'rodrigo.werneck@id.uff.br', 'Rodrigo Werneck', 'vv123', 'VENDEDOR');
INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'luisa@id.uff.br', 'Ana Luisa Esposito', '67890', 'VENDEDOR');
INSERT INTO usuario (id, email, nome, senha, tipo_usuario) VALUES (nextval('hibernate_sequence'), 'renan@id.uff.br', 'Renan Barbosa', '12389', 'VENDEDOR');

INSERT INTO produto (id, codigo_barras, descricao, is_ativo, nome, preco, qtd_estoque, url_img, categoria_id, fornecedor_id, promocao_id)
VALUES (nextval('hibernate_sequence'), '7970993443816', 'Escova Colgate Classic Clean', true, 'Escova Dental Colgate', 2.99, 340,
        'https://superprix.vteximg.com.br/arquivos/ids/169475-600-600/Escova-Dental-Colgate-Classic-Clean-Media.jpg',
        (SELECT id from categoria where codigo = 'HIG'), (SELECT id from fornecedor where cnpj = '29995209000114'), null);
INSERT INTO produto (id, codigo_barras, descricao, is_ativo, nome, preco, qtd_estoque, url_img, categoria_id, fornecedor_id, promocao_id)
VALUES (nextval('hibernate_sequence'), '9768012020726', 'Cereais Sabor Chocolate', true, 'Nescau Ball 500g', 7.99, 250,
        'https://pepeopina.files.wordpress.com/2010/04/nescau.jpg',
        (SELECT id from categoria where codigo = 'CER'), (SELECT id from fornecedor where cnpj = '63367244000127'), null);
INSERT INTO produto (id, codigo_barras, descricao, is_ativo, nome, preco, qtd_estoque, url_img, categoria_id, fornecedor_id, promocao_id)
VALUES (nextval('hibernate_sequence'), '2590624064341', 'Sabão em pó', true, 'Sabão Vanish 500g', 4.49, 540,
        'https://viatechlimpeza.com.br/wp-content/uploads/2019/10/vanish-1.jpeg',
        (SELECT id from categoria where codigo = 'LIM'), (SELECT id from fornecedor where cnpj = '29995209000114'), null);
INSERT INTO produto (id, codigo_barras, descricao, is_ativo, nome, preco, qtd_estoque, url_img, categoria_id, fornecedor_id, promocao_id)
VALUES (nextval('hibernate_sequence'), '9807530225789', 'Pedaços de frango industrializado', true, 'Nugget Sadia 500g', 8.99, 200,
        'https://geant.vteximg.com.br/arquivos/ids/212216-1000-1000/231488.jpg',
        (SELECT id from categoria where codigo = 'FRI'), (SELECT id from fornecedor where cnpj = '63367244000127'), null);
INSERT INTO produto (id, codigo_barras, descricao, is_ativo, nome, preco, qtd_estoque, url_img, categoria_id, fornecedor_id, promocao_id)
VALUES (nextval('hibernate_sequence'), '9018010287663', 'Bebida alcoolica fermentada', true, 'Cerveja Devassa 350ml', 1.59, 530,
        'https://www.imigrantesbebidas.com.br/bebida/images/products/full/429_Cerveja_Devassa_Bem_Loura_Lata_350_ml.1534623115.jpg',
        (SELECT id from categoria where codigo = 'BEB'), (SELECT id from fornecedor where cnpj = '65977993000100'), null);

