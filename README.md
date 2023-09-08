# Sonar Badge
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=bugs)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=coverage)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)

# Documentação da API Completa: 

 Nesta documentação, você encontrará detalhes abrangentes sobre a API, seus endpoints e recursos disponíveis.
 Para começar a explorar, acesse a documentação completa clicando no seguinte link: [Documentação da API de Contas Bancárias](https://github.com/macgii/Teste-Contas-Bancarias/wiki).

# Como executar o projeto com docker

### Pré-requisitos

Certifique-se de que você tenha o seguinte instalado em seu sistema:

       Git, Docker e Postman.
***
## Passo 1: Clonar o Repositório

Abra um terminal ou prompt de comando. <br />
Navegue até o diretório onde você deseja clonar o repositório. <br />
Execute o seguinte comando para clonar o repositório:

```
git clone https://github.com/macgii/Teste-Contas-Bancarias.git
```

Aguarde até que o processo de clonagem seja concluído.

***
## Passo 2: Entrar na Pasta do Projeto

Após a conclusão da clonagem, execute o seguinte comando para entrar na pasta do projeto:
```
cd teste-contas-bancarias
```

***
## Passo 3: Executar o Docker Compose

Verifique se há um arquivo chamado docker-compose.yml na pasta do projeto. Esse arquivo contém as configurações do Docker Compose para o projeto.
Com o Docker instalado em seu sistema, execute o seguinte comando para iniciar os contêineres definidos no arquivo docker-compose.yml:

```
docker-compose up
```

Aguarde até que o Docker Compose inicie os contêineres e imprima logs na tela. Dependendo do projeto, pode ser necessário baixar e construir imagens de contêineres antes de iniciar.

***
## Passo 4: Requisições:

Faça o download e Importe a Collection do Postman: <br />
[Download](https://github.com/macgii/Teste-Contas-Bancarias/blob/main/collection/banco.postman_collection.json) <br />
Abra o Postman. <br />
Vá em "File" -> "Import" e selecione o arquivo da collection. <br />
Explore a collection importada para fazer requisições.

***
## Links Úteis para Acessar Localmente
### Explore a API!
Aqui, você encontrará uma lista de links úteis que oferecem documentação e ferramentas para interação com os recursos e funcionalidades, proporcionando uma experiência completa de desenvolvimento, monitoramento e análise de código. Vamos dar uma olhada:

 ### **Actuator** - [http://localhost:8080/actuator](http://localhost:8080/actuator)
  
O Spring Boot Actuator oferece informações sobre o aplicativo em execução, métricas, status de saúde e muito mais.

### **Prometheus** - [http://localhost:9090/](http://localhost:9090/)
Prometheus é um sistema de monitoramento de código aberto que coleta métricas e estatísticas sobre sistemas em execução.

### **Grafana** - [http://localhost:3000/login](http://localhost:3000/login)
Grafana é uma plataforma de análise e visualização de código aberto que permite criar painéis e gráficos personalizados para seus dados.

### **Swagger** - [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
Swagger é uma ferramenta que permite criar, documentar e testar APIs REST de forma interativa.

### **SonarCloud** - [Acesse aqui](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias&branch=main)
SonarCloud é uma plataforma de análise de código que fornece insights sobre a qualidade do código, identifica problemas e ajuda a melhorar a manutenção do software.

### **Dockerhub** - [Acesse aqui](https://hub.docker.com/u/macgii)
Dockerhub é um registro de contêineres que permite armazenar, compartilhar e gerenciar imagens de contêineres Docker.
