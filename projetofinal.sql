DROP DATABASE IF EXISTS Projeto2;
CREATE DATABASE Projeto2;
USE Projeto2;

CREATE TABLE Medico (
	crm VARCHAR(45) NOT NULL,
	nome VARCHAR(45) NOT NULL,
	idade INT NOT NULL,
	endereco VARCHAR(45) NOT NULL,
	telefone VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
	senha VARCHAR(45) NOT NULL,
    
	PRIMARY KEY (crm))
ENGINE = InnoDB;

CREATE TABLE Paciente (
	cpf VARCHAR(45) NOT NULL,
	nome VARCHAR(45) NOT NULL,
	idade INT NOT NULL,
	endereco VARCHAR(45) NOT NULL,
	telefone VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
    
	PRIMARY KEY (cpf))
ENGINE = InnoDB;

CREATE TABLE Consulta (
	Medico_crm VARCHAR(45) NOT NULL,
	Paciente_cpf VARCHAR(45) NOT NULL,
	dataC VARCHAR(45) NOT NULL,
	horario VARCHAR(45) NOT NULL,
    
    PRIMARY KEY(Medico_crm, Paciente_cpf),
    
    CONSTRAINT Consulta_Medico_fk
    FOREIGN KEY (Medico_crm)
    REFERENCES Medico (crm)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    
	CONSTRAINT Consulta_Paciente_fk
    FOREIGN KEY (Paciente_cpf)
    REFERENCES Paciente(cpf)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    
	)
ENGINE = InnoDB;

CREATE TABLE Sala (
	numero VARCHAR(45) NOT NULL,
	piso INT NOT NULL,
	tamanho VARCHAR(45) NOT NULL,
	especialidade VARCHAR(45) NOT NULL,
    Medico_crm VARCHAR(45),
    
	PRIMARY KEY (numero),
    
    CONSTRAINT Sala_Medico_fk
    FOREIGN KEY (Medico_crm)
    REFERENCES Medico (crm)
    ON DELETE SET NULL
    ON UPDATE CASCADE
    )
ENGINE = InnoDB;

CREATE TABLE Historico(
	idHistorico VARCHAR(45) NOT NULL,
	massa VARCHAR(45) NOT NULL,
	altura VARCHAR(45) NOT NULL,
	tipoSanguineo VARCHAR(45) NOT NULL,
    fumante TINYINT NOT NULL,
    alcool TINYINT NOT NULL,
    Paciente_cpf VARCHAR(45) NOT NULL UNIQUE,
    
    PRIMARY KEY(idHistorico),
    
    CONSTRAINT Historico_Pacienye_fk
    FOREIGN KEY (Paciente_cpf)
    REFERENCES Paciente(cpf)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    )
ENGINE = InnoDB;

