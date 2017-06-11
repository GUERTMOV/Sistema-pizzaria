// INSERTS  QUE PRECISAM SER FEITOS 

INSERT INTO permissao (id,nome) VALUES (1,'ROLE_PIZZARIA');

INSERT INTO pizzaria (id,datacadastro, endereco, login, nome, senha) VALUES (1, '2017-06-07', 'Rua Um','admin', 'Pizzaria Um', '$2a$10$NuSylg7XYmtXROnSxgRj6ujBSsy1wafWGNDpdOEmFEpnu9IIr2KSO');
INSERT INTO pizzaria (id,datacadastro,endereco, login, nome, senha) VALUES (2, '2017-06-07', 'Rua 25', 'admin2', 'Pizzaria Dois', '$2a$10$NuSylg7XYmtXROnSxgRj6ujBSsy1wafWGNDpdOEmFEpnu9IIr2KSO');


INSERT INTO pizzaria_permissao (pizzaria_id, permissoes_id) VALUES (1,1);
INSERT INTO pizzaria_permissao (pizzaria_id, permissoes_id) VALUES (2,1);