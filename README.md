Projeto Locadora de Mídias (Spring Boot)

Este projeto é uma aplicação web acadêmica para o gerenciamento de uma locadora de mídias, desenvolvido utilizando a arquitetura MVC com o framework Spring Boot.

A aplicação foi migrada de um projeto Java (Servlets/Ant) para uma arquitetura moderna baseada em Spring.

🚀 Tecnologias Utilizadas

Backend: Java 17

Framework: Spring Boot

Spring Web (MVC): Para a camada de Controle (URLs e Servidor Embutido).

Spring Data JPA: Para a camada de Repositório (persistência de dados).

Spring Boot Validation: Para validação dos dados de entrada.

Frontend: Thymeleaf (para renderização das páginas HTML).

Banco de Dados: MariaDB (ou MySQL).

Build: Apache Maven.

⚙️ Como Executar

Banco de Dados:

Certifique-se de que o MariaDB/MySQL esteja rodando (ex: via XAMPP).

Crie um banco de dados (schema) chamado locadora_db.

Importe o script SQL (fornecido pelo professor) para criar as tabelas e as chaves estrangeiras.

Configuração:

Abra o arquivo src/main/resources/application.properties.

Altere a linha spring.datasource.password=sua_senha_aqui para a sua senha real do banco (ex: spring.datasource.password=root ou a senha que você usa).

Execução:

Abra o projeto no NetBeans (ou sua IDE preferida).

Encontre a classe principal LocacaoMidiasApplication.java.

Clique com o botão direito nela e escolha "Executar arquivo" (Run File).

Acesso:

O servidor estará rodando em http://localhost:8080/locadora.

