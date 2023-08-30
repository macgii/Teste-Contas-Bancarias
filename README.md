# Sonar Badge
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=bugs)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=macgii_Teste-Contas-Bancarias&metric=coverage)](https://sonarcloud.io/summary/new_code?id=macgii_Teste-Contas-Bancarias)

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
