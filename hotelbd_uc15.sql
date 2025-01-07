create database hotelbd;
use hotelbd;

CREATE TABLE quartos (
  id int auto_increment not null primary key,
  numero int not null,
  tipo varchar(50) not null,
  disponivel bit not null,
  valor_diaria decimal not null,
  capacidade_adultos INT NOT NULL DEFAULT 2,
  capacidade_criancas INT NOT NULL DEFAULT 0,
  comodidades varchar(200)
  );
 
 -- disponivel = 1 / indisponivel = 0
INSERT INTO quartos (id, numero, tipo, disponivel, valor_diaria, capacidade_adultos, capacidade_criancas, comodidades) VALUES 
(1, 101, "Simples", 1, 180.0, 1, 0, "Ar condicionado, Wi-Fi, chuveiro, frigobar"),
(2, 102, "Simples", 1, 180.0, 1, 0, "Ar condicionado, Wi-Fi, chuveiro, frigobar"),
(3, 103, "Duplo", 1, 220.0, 2, 0, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(4, 104, "Duplo", 1, 220.0, 1, 1, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(5, 201, "Triplo", 1, 300.0, 2, 1, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(6, 202, "Triplo", 1, 300.0, 1, 2, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(7, 203, "Quadruplo", 1, 350.00, 2, 2, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(8, 204, "Quadruplo", 1, 350.00, 4, 0, "Ar condicionado, Wi-Fi, TV a cabo, chuveiro, frigobar"),
(9, 301, "Suíte Casal", 1, 500.00, 2, 0, "Ar condicionado, Wi-Fi, TV a cabo, banheira, frigobar"),
(10, 302, "Suíte Família", 1, 560.00, 2, 2, "Ar condicionado, Wi-Fi, TV a cabo, banheira, frigobar");

SELECT * FROM quartos;

CREATE TABLE usuarios (
	id INT NOT NULL auto_increment primary KEY,
    perfilUsuarioId int not null DEFAULT 3,
    nome varchar(100) not null,
    endereco varchar(250) not null,
    telefone varchar(15) not null,
    email varchar(100) not null,
    senha varchar(50) not null,
    preferencias varchar(300),
    dataCadastro date not null
);

INSERT INTO usuarios (id, perfilUsuarioId, nome, endereco, telefone, email, senha, preferencias, dataCadastro) VALUES
-- ADMINISTRADOR (1)
(1, 1, "Carlos Silva", "Rua das Flores, 123, Rio de Janeiro", "(21)91234-5678", "carlos.silva@hotel.com", "senhaSegura123", "Prefere turnos diurnos", '2024-05-20'),
(2, 1, "Ana Costa", "Av. João da Silva, 456, Rio de Janeiro", "(11)97654-3210", "ana.costa@hotel.com", "senhaForte456", "Turno da noite", '2024-06-01'),
-- OPERADOR (2)
(3, 2, "Lucas Oliveira", "Rua dos Campos, 789, Rio de Janeiro", "(21) 99876-5432", "lucas.oliveira@hotel.com", "senhaComplexa789", "Prefere trabalho remoto", '2024-05-20'),
(4, 2, "Maria Souza", "Rua do Porto, 321, Rio de Janeiro", "(13)91234-8765", "maria.souza@hotel.com", "senhaSimples123", "Turno da tarde", '2024-06-01'),
-- HOSPEDES (3)
(5, 3, "Tomas Silveira", "Rua do Melancia, 521, Fortaleza", "(88)91564-5205", "tomas23@email.com", "senhaS3", "Quarto com varanda", '2024-05-28'),
(6, 3, "Milena Kayla", "Rua do Padre, 699, Porto Alegre", "(51)91966-3641", "milena33k@email.com", "senhaPadrao", "", '2024-06-02'),
(7, 3, "Lucas Martins", "Rua da Costa Verde, 864, São Paulo", "(11)92582-3555", "lucas5ma@email.com", "senha!@#", "", '2024-06-15');

SELECT * FROM usuarios;

CREATE TABLE reserva(
id int not null auto_increment primary key,
hospedeId int not null,
quartoId int not null,
dataCheckin date not null, 
dataPrevCheckout date not null,
dataCheckout date,
status int not null,
detalhesPagamento varchar(200) not null,
foreign key (hospedeId) references usuarios(id),
 foreign key (quartoId) references quartos(id)
);

-- status 1-confirmado 2- pendente 3- cancelado / formasPagamento: Dinheiro, Cartão de crédito ou Cartão de débito
INSERT INTO reserva (id, hospedeId, quartoId, dataCheckin, dataPrevCheckout, dataCheckout, status, detalhesPagamento) VALUES
(1, 6, 1, '2025-01-01', '2025-01-05', '2025-01-05', 3, "Dinheiro"),
(2, 5, 7, '2025-01-10', '2025-01-20', null, 1, "Cartão de crédito"),
(3, 7, 3, '2025-01-02', '2025-01-05', '2025-01-07', 1, "Dinheiro"),
(4, 7, 3, '2025-01-10', '2025-01-15', null, 1, "Cartão de débito"),
(5, 6, 4, '2025-01-01', '2025-01-05', '2025-01-05', 1, "Cartão de crédito"),
(6, 5, 1, '2025-01-10', '2025-01-15', null, 2, "Dinheiro");