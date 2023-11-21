# cruzeiro-projetos-icust
Repositório com códigos do projeto iCust para Projeto de Linguagens de Programação

## Tecnologias
Para desenvolvimento do backend foi utilizado o Java com Spring Boot para gerar uma REST API com integração à um banco MySQL provisionado na AWS.
Para deploy do servidor, foi utilizado Terraform com integração com a AWS Para provisionamento de um EC2 via ECS Fargate com ALB.

Para executar o terraform é necessário ter a AWS CLI configurado no máquina com sua conta.
Para deploy precisa antes fazer o build da imagem docker do servidor Java, conforme oriengtações do ECR na AWS.

Para executar local, importe o projeto back em uma IDE (usamos IntelliJ) como projeto gradle. É possível acessar o Swagger em http://localhost:8080/swagger-ui/index.html
