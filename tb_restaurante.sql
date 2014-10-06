-- phpMyAdmin SQL Dump
-- version 4.0.10.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.11.141.2:3306
-- Tempo de Geração: 08/10/2014 às 22:50
-- Versão do servidor: 5.5.37
-- Versão do PHP: 5.3.3
--
--
-- Banco de dados: `GuiaCardapio`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela 'tb_restaurante'
--

CREATE TABLE IF NOT EXISTS `tb_restaurante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  `horario_funcionamento` varchar(50) DEFAULT NULL,
  `quantidade_Pessoas` int(11) DEFAULT NULL,
  `preco` varchar(10) DEFAULT NULL,
  `cartoes` varchar(50) DEFAULT NULL,
  `facebook` varchar(50) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  `instagram` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `site` varchar(50) DEFAULT NULL,
  `palavra_chave_1` varchar(20) DEFAULT NULL,
  `palavra_chave_2` varchar(20) DEFAULT NULL,
  `palavra_chave_3` varchar(20) DEFAULT NULL,
  `palavra_chave_4` varchar(20) DEFAULT NULL,
  `palavra_chave_5` varchar(20) DEFAULT NULL,
  `Imagem_1` mediumblob,
  `Imagem_2` mediumblob,
  `Imagem_3` mediumblob,
  `Imagem_4` mediumblob,
  `Imagem_5` mediumblob,
  `Imagem_6` mediumblob,
  `Imagem_7` mediumblob,
  `Imagem_8` mediumblob,
  `Imagem_9` mediumblob,
  `Imagem_10` mediumblob,
  PRIMARY KEY (`id`)
);

--
-- Fazendo dump de dados para tabela `tb_restaurante`
--
INSERT INTO `tb_restaurante` (`id`, `nome`, `telefone`, `bairro`, `endereco`, `descricao`, `horario_funcionamento`, `quantidade_Pessoas`, `preco`, `cartoes`, `facebook`, `twitter`, `instagram`, `email`, `site`, `palavra_chave_1`, `palavra_chave_2`, `palavra_chave_3`, `palavra_chave_4`, `palavra_chave_5`, `Imagem_1`, `Imagem_2`, `Imagem_3`, `Imagem_4`, `Imagem_5`, `Imagem_6`, `Imagem_7`, `Imagem_8`, `Imagem_9`, `Imagem_10`) VALUES
(1, 'Bar 1', '84-3211-17', 'Petrópolis', 'Av. Deodoro da Fonseca, 294, Petrópolis', 'Em um antigo casarão com amplas varandas localizado no coração de petrópolis, bairro tradicional e boêmio de natal, o bar 294 se destaca pela qualidade e excelência dos seus petiscos servidos. Fundado em 1990 pelos sócios Hailton Cabral e Rui Rocha, o 294 hoje é um dos bares mais antigos da cidade, o que o fez uma tradição entre os potiguares. A decoração é simples que remete aos velhos botecos, permitindo momentos de descontração e informalidade, para bons encontros e papos daqueles que nos fazem “se sentir em casa”. O cardápio tem como carro chefe o caranguejo, camarão, ensopados de frutos do mar e ostras orgânicas, todos servidos de maneira bem regional como nas barracas de praia. Também oferece outras comidinhas com produtos de alta qualidade que não podem faltar em um boteco como pastéis, salsichão, bolinhos, frango e filé.\r\n', 'Qua. e Qui.:11h as 23h. Sex. e Sáb.:11h as 00h. Do', 250, '$$', 'Visa, Master', 'facebook.com/bar294', NULL, 'instagram.com/bar294', 'restaurantebar294@hotmail.com', NULL, 'o', 'melhor', 'restaurante', 'de', 'natal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_restaurante` (`id`, `nome`, `telefone`, `bairro`, `endereco`, `descricao`, `horario_funcionamento`, `quantidade_Pessoas`, `preco`, `cartoes`, `facebook`, `twitter`, `instagram`, `email`, `site`, `palavra_chave_1`, `palavra_chave_2`, `palavra_chave_3`, `palavra_chave_4`, `palavra_chave_5`, `Imagem_1`, `Imagem_2`, `Imagem_3`, `Imagem_4`, `Imagem_5`, `Imagem_6`, `Imagem_7`, `Imagem_8`, `Imagem_9`, `Imagem_10`) VALUES
(2, 'Bar 2', '84-3211-17', 'Petrópolis', 'Av. Deodoro da Fonseca, 294, Petrópolis', 'Em um antigo casarão com amplas varandas localizado no coração de petrópolis, bairro tradicional e boêmio de natal, o bar 294 se destaca pela qualidade e excelência dos seus petiscos servidos. Fundado em 1990 pelos sócios Hailton Cabral e Rui Rocha, o 294 hoje é um dos bares mais antigos da cidade, o que o fez uma tradição entre os potiguares. A decoração é simples que remete aos velhos botecos, permitindo momentos de descontração e informalidade, para bons encontros e papos daqueles que nos fazem “se sentir em casa”. O cardápio tem como carro chefe o caranguejo, camarão, ensopados de frutos do mar e ostras orgânicas, todos servidos de maneira bem regional como nas barracas de praia. Também oferece outras comidinhas com produtos de alta qualidade que não podem faltar em um boteco como pastéis, salsichão, bolinhos, frango e filé.\r\n', 'Qua. e Qui.:11h as 23h. Sex. e Sáb.:11h as 00h. Do', 250, '$$', 'Visa, Master', 'facebook.com/bar294', NULL, 'instagram.com/bar294', 'restaurantebar294@hotmail.com', NULL, 'o', 'melhor', 'restaurante', 'de', 'natal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_restaurante` (`id`, `nome`, `telefone`, `bairro`, `endereco`, `descricao`, `horario_funcionamento`, `quantidade_Pessoas`, `preco`, `cartoes`, `facebook`, `twitter`, `instagram`, `email`, `site`, `palavra_chave_1`, `palavra_chave_2`, `palavra_chave_3`, `palavra_chave_4`, `palavra_chave_5`, `Imagem_1`, `Imagem_2`, `Imagem_3`, `Imagem_4`, `Imagem_5`, `Imagem_6`, `Imagem_7`, `Imagem_8`, `Imagem_9`, `Imagem_10`) VALUES
(3, 'Bar 3', '84-3211-17', 'Petrópolis', 'Av. Deodoro da Fonseca, 294, Petrópolis', 'Em um antigo casarão com amplas varandas localizado no coração de petrópolis, bairro tradicional e boêmio de natal, o bar 294 se destaca pela qualidade e excelência dos seus petiscos servidos. Fundado em 1990 pelos sócios Hailton Cabral e Rui Rocha, o 294 hoje é um dos bares mais antigos da cidade, o que o fez uma tradição entre os potiguares. A decoração é simples que remete aos velhos botecos, permitindo momentos de descontração e informalidade, para bons encontros e papos daqueles que nos fazem “se sentir em casa”. O cardápio tem como carro chefe o caranguejo, camarão, ensopados de frutos do mar e ostras orgânicas, todos servidos de maneira bem regional como nas barracas de praia. Também oferece outras comidinhas com produtos de alta qualidade que não podem faltar em um boteco como pastéis, salsichão, bolinhos, frango e filé.\r\n', 'Qua. e Qui.:11h as 23h. Sex. e Sáb.:11h as 00h. Do', 250, '$$', 'Visa, Master', 'facebook.com/bar294', NULL, 'instagram.com/bar294', 'restaurantebar294@hotmail.com', NULL, 'o', 'melhor', 'restaurante', 'de', 'natal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_restaurante` (`id`, `nome`, `telefone`, `bairro`, `endereco`, `descricao`, `horario_funcionamento`, `quantidade_Pessoas`, `preco`, `cartoes`, `facebook`, `twitter`, `instagram`, `email`, `site`, `palavra_chave_1`, `palavra_chave_2`, `palavra_chave_3`, `palavra_chave_4`, `palavra_chave_5`, `Imagem_1`, `Imagem_2`, `Imagem_3`, `Imagem_4`, `Imagem_5`, `Imagem_6`, `Imagem_7`, `Imagem_8`, `Imagem_9`, `Imagem_10`) VALUES
(4, 'Bar 4', '84-3211-17', 'Petrópolis', 'Av. Deodoro da Fonseca, 294, Petrópolis', 'Em um antigo casarão com amplas varandas localizado no coração de petrópolis, bairro tradicional e boêmio de natal, o bar 294 se destaca pela qualidade e excelência dos seus petiscos servidos. Fundado em 1990 pelos sócios Hailton Cabral e Rui Rocha, o 294 hoje é um dos bares mais antigos da cidade, o que o fez uma tradição entre os potiguares. A decoração é simples que remete aos velhos botecos, permitindo momentos de descontração e informalidade, para bons encontros e papos daqueles que nos fazem “se sentir em casa”. O cardápio tem como carro chefe o caranguejo, camarão, ensopados de frutos do mar e ostras orgânicas, todos servidos de maneira bem regional como nas barracas de praia. Também oferece outras comidinhas com produtos de alta qualidade que não podem faltar em um boteco como pastéis, salsichão, bolinhos, frango e filé.\r\n', 'Qua. e Qui.:11h as 23h. Sex. e Sáb.:11h as 00h. Do', 250, '$$', 'Visa, Master', 'facebook.com/bar294', NULL, 'instagram.com/bar294', 'restaurantebar294@hotmail.com', NULL, 'o', 'melhor', 'restaurante', 'de', 'natal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tb_restaurante` (`id`, `nome`, `telefone`, `bairro`, `endereco`, `descricao`, `horario_funcionamento`, `quantidade_Pessoas`, `preco`, `cartoes`, `facebook`, `twitter`, `instagram`, `email`, `site`, `palavra_chave_1`, `palavra_chave_2`, `palavra_chave_3`, `palavra_chave_4`, `palavra_chave_5`, `Imagem_1`, `Imagem_2`, `Imagem_3`, `Imagem_4`, `Imagem_5`, `Imagem_6`, `Imagem_7`, `Imagem_8`, `Imagem_9`, `Imagem_10`) VALUES
(5, 'Bar 5', '84-3211-17', 'Petrópolis', 'Av. Deodoro da Fonseca, 294, Petrópolis', 'Em um antigo casarão com amplas varandas localizado no coração de petrópolis, bairro tradicional e boêmio de natal, o bar 294 se destaca pela qualidade e excelência dos seus petiscos servidos. Fundado em 1990 pelos sócios Hailton Cabral e Rui Rocha, o 294 hoje é um dos bares mais antigos da cidade, o que o fez uma tradição entre os potiguares. A decoração é simples que remete aos velhos botecos, permitindo momentos de descontração e informalidade, para bons encontros e papos daqueles que nos fazem “se sentir em casa”. O cardápio tem como carro chefe o caranguejo, camarão, ensopados de frutos do mar e ostras orgânicas, todos servidos de maneira bem regional como nas barracas de praia. Também oferece outras comidinhas com produtos de alta qualidade que não podem faltar em um boteco como pastéis, salsichão, bolinhos, frango e filé.\r\n', 'Qua. e Qui.:11h as 23h. Sex. e Sáb.:11h as 00h. Do', 250, '$$', 'Visa, Master', 'facebook.com/bar294', NULL, 'instagram.com/bar294', 'restaurantebar294@hotmail.com', NULL, 'o', 'melhor', 'restaurante', 'de', 'natal', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);