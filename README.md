🥷 Cadastro de Ninjas API

Este projeto é uma API REST para cadastro e gerenciamento de ninjas, desenvolvida com Java e Spring Boot.

A aplicação permite realizar operações de CRUD (Create, Read, Update, Delete) para gerenciar dados de ninjas, seguindo o padrão de APIs REST utilizando métodos HTTP como GET, POST, PUT e DELETE.

O projeto foi desenvolvido com o objetivo de praticar desenvolvimento backend com Java, estruturação de APIs e organização de aplicações utilizando o ecossistema Spring.

🚀 Funcionalidades

Cadastro de novos ninjas

Listagem de ninjas cadastrados

Busca de ninjas

Atualização de informações de um ninja

Remoção de ninjas do sistema

🛠 Tecnologias utilizadas

Java

Spring Boot

Spring Web

Maven

📌 Endpoints da API
Método	Endpoint	Descrição
POST	/ninjas	Cadastra um novo ninja
GET	/ninjas	Lista todos os ninjas
GET	/ninjas/{id}	Busca um ninja por ID
PUT	/ninjas/{id}	Atualiza um ninja
DELETE	/ninjas/{id}	Remove um ninja
🎯 Objetivo do projeto

Este projeto foi desenvolvido para praticar conceitos fundamentais do desenvolvimento backend com Java, como:

Criação de APIs REST com Spring Boot

Estruturação de aplicações backend

Manipulação de requisições HTTP

Implementação de operações CRUD

Organização de código em camadas

O Spring Boot facilita a criação de aplicações Java prontas para produção, reduzindo configuração manual e permitindo focar na lógica da aplicação.

▶ Como executar o projeto

Clone o repositório:

git clone https://github.com/italogitt/Cadastro-de-ninjas

Entre na pasta do projeto:

cd Cadastro-de-ninjas

Execute a aplicação:

./mvnw spring-boot:run

A API estará disponível em:

http://localhost:8080
