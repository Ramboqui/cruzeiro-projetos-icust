# cruzeiro-projetos-icust
Repositório com códigos do projeto iCust para Projeto de Linguagens de Programação

## Tecnologias

## Fontend
Para desenvolvimento do frontend foi utilizado o framework Ionic em sua versão Angular, assim, gerando um código multiplataforma.
Para o ambiente de teste deve-se ter instalado o NodeJS, NPM e Ionic em sua última versão, como descrito em sua documentação, após, basta utilizar o comando ionc serve
Para deploy do app é utilizado o capacitor, bastando digitar o comando 'ionic capacitor build <plataforma>', podendo a plataforma ser Android e IOS.

Documentação Ionic: https://ionicframework.com/docs
Documentação Angular: https://angular.io/docs
Documentação Capacitor: https://capacitorjs.com/docs

## Backend
Para desenvolvimento do backend foi utilizado o Java com Spring Boot para gerar uma REST API com integração à um banco MySQL provisionado na AWS.
Para deploy do servidor, foi utilizado Terraform com integração com a AWS Para provisionamento de um EC2 via ECS Fargate com ALB.

Para executar o terraform é necessário ter a AWS CLI configurado no máquina com sua conta.
Para deploy precisa antes fazer o build da imagem docker do servidor Java, conforme oriengtações do ECR na AWS.

Para executar local, importe o projeto back em uma IDE (usamos IntelliJ) como projeto gradle. É possível acessar o Swagger em http://localhost:8080/swagger-ui/index.html


## Participantes
Lucas da Silva Gonçalves - 2319037-0
Lucas Gabriel Rodrigues - 
Larissa Gabriel Rodrigues - 2302916-1
Vinicius Sylvestre de Farias Lima - 2302916-1
Gabriel Jesus Pauferro do Nascimento - 2323268-4
Pedro Luka Oliveira Cazorla - 2355230-1
Matheus Custodio de Souza -


