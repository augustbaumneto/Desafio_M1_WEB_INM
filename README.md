# desafio-ui-m1-t1-august-neto

<a id="sobre" ></a>
## Sobre o projeto📊
-----------------------
  
O projeto consisti em uma automação de testes de UI para a entrega do segundo desafio do módulo 1 do programa de quality engineering da Inmetrics.  
  
Foram implantados testes relacionados a 3 funcionalidades disponibilizadas pelo site [Sauce Demo](https://www.saucedemo.com/):
  
<a id="login" ></a>
### Login🤫
--------------------
Funcionalidade responsável por tentar fazer o login na página. Os cenários contemplados foram:  
* Login com senha e usuários OK. Valida-se:
  * Se houve mudança da página;
  * Se existe o botão de carrinho;
  * Se o titulo da nova página esta correto;
* Login com usuário e senha OK, porém usuário bloqueado. Valida-se:
  * Se não há mudança da página;
  * Se mensagem de erro adequada é aprensetada;
* Login faltando ou o usuário, ou a senha, ou ambos. Valida-se:
  * Se não há mudança da página;
  * Se mensagem de erro adequada é aprensetada;
* Login com ou login ou senha incorreto. Valida-se:
  * Se não há mudança da página;
  * Se mensagem de erro adequada é aprensetada.  
  
<a id="adicionar-produtos" ></a>
### Adicionar Produtos👀
----------------
Funcionalidade responsável por adicionar produtos ao carrinho. Os cenários contemplados foram:  
* Acessar o carrinho sem adicionar produtos:
  * Quantidade de produtos esta zerada;
  * Se é direcionado para a página de carrinho;
  * Título da página esta correto;
  * Não há produtos na lista
* Adicionar apenas 1 produto pela tela de inventário e acessar o carrinho (testado para todos os produtos):
  * Se botão do produto adicionado é alterado para remover;
  * Quantidade de produtos é alterada corretamente conforme são adicionados;
  * Se é direcionado para a página de carrinho;
  * Título da página esta correto;
  * Se quantidade e itens da lista são os mesmos adicionados;
* Adicionar os 6 produtos ao mesmo tempo pela tela de inventário e acessar o carrinho:
  * Se botão do produto adicionado é alterado para remover;
  * Quantidade de produtos é alterada corretamente conforme são adicionados;
  * Se é direcionado para a página de carrinho;
  * Título da página esta correto;
  * Se quantidade e itens da lista são os mesmos adicionados;
* Adicionar apenas 2 produtos pela tela de inventário e acessar o carrinho:
  * Se botão do produto adicionado é alterado para remover;
  * Quantidade de produtos é alterada corretamente conforme são adicionados;
  * Se é direcionado para a página de carrinho;
  * Título da página esta correto;
  * Se quantidade e itens da lista são os mesmos adicionados.
  
<a id="checkout" ></a>
### Checkout💸
----------------  
Funcionalidade responsável por fazer o checkout dos produtos adicionados no carrinho. Os cenários contemplados foram:  
* Realizar checkout com 2 produtos:
  * Se é direcionado para as páginas corretas de checkout conforme avança o fluxo;
  * Se título das páginas estão corretos;
  * Se quantidade de itens e informações dos itens são as mesmas na página de confirmação com relação ao carrinho;
  * Se cálculo das taxas estão corretos;
  * Se mensagem de conclusão é exibida corretamente;
  * Se carrinho é esvaziado após o checkout;
* Realizar checkout com  6 produtos:
  * Se é direcionado para as páginas corretas de checkout conforme avança o fluxo;
  * Se título das páginas estão corretos;
  * Se quantidade de itens e informações dos itens são as mesmas na página de confirmação com relação ao carrinho;
  * Se cálculo das taxas estão corretos;
  * Se mensagem de conclusão é exibida corretamente;
  * Se carrinho é esvaziado após o checkout;
  
#### Status🏆  
Concluído a primeira versão. 🚀  
O que não foi feito: 😭
  * Readme.md com links internos funcionais e para o arquivo de licença;
  * Evidências das telas testadas;
  * Reportes configurados no cucumber;
  * Funcionalidades adicionais.
  
<a id="tabela-de-conteudo" ></a>
## Tabela de conteúdos🤓  
------------------------------
<!--ts-->
   * [Sobre o projeto](#sobre)
      * [Login](#login)
	  * [Adicionar Produtos](#adicionar-produtos)
	  * [Checkout](#checkout)
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Tecnologias](#tecnologias)
   * [Instalação](#instalacao)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Baixando o projeto e preparando o ambiente](#baixando-e-preparando)
      * [Rodando os Testes](#rodando-os-testes)
      * [Alterando a massa de teste](#alterando-massa)
	  * [Alterando o navegador de execução](#alterar-navegador)
   * [Autor](#autor)
   * [Licença](#licenca)   
<!--te-->
  
<a id="tecnologias"></a>
## Tecnologias🛰️
-----------------------------
  
As seguintes ferramentas foram usadas na construção do projeto:  
  
- [Eclipse - 4.25](https://www.eclipse.org/downloads/)
- [Maven - 3.10.1](https://maven.apache.org/)
- [JavaSE - 1.8](https://www.java.com/pt-BR/)
- [Cucumber - 7.10.1](https://cucumber.io/)
- [Junit - 5.9.1](https://junit.org/junit5/)
- [Selenium - 4.7.2](https://www.selenium.dev/) 
  
<a id="como-usar"></a>
## Como Usar🧐
------------------
  
Não é necessário rodar nenhuma aplicação a parte para rodar os scripts de automação, basta seguir os passos e preparar o ambiente.  
  
<a id="pre-requisitos"></a>  
### Pré-requisitos⛽
--------------------
Você precisa ter instalado na máquina o [Git](https://git-scm.com), uma IDE (será exemplificado com o [Eclipse](https://www.eclipse.org/downloads/)) e o [Maven](https://maven.apache.org/).
  
<a id="baixando-e-preparando"></a>
### Baixando o projeto e preparando o ambiente🥘
------------------------------------------------ 
  
#### Direto pelo git💽  
  
```bash
# Clone este repositório
$ git clone https://gitlab.inlabs.app/augustbn/desafio-ui-m1-t1-august-neto.git

# Vá para a pasta da aplicação onde o arquivo pom.xml se encontra
$ cd desafio-ui-m1-t1-august-neto-versao

# Instale as dependências
$ mvn install

```
  
#### Pelo IDE (Eclipse)🆚  
  
  1. Abre o Eclipse e clique em "File" > "Import";  
  ![](/src/test/resources/img/import-eclipse/Passo1.png)
  
  2. Selecione a pasta "Maven" > "Existing Manven Projects" e clique em "Next";  
  ![](/src/test/resources/img/import-eclipse/Passo2.png)
  
  3. Selecione a pasta que contem o arquivo "pom.xml", marque o projeto e clique em "Finish";  
  ![](/src/test/resources/img/import-eclipse/Passo3.png)
  
  4. Selecione o projeto carregado com o lado esquerdo do mouse, vá para "Maven" > "Update Project";  
  ![](/src/test/resources/img/import-eclipse/Passo4.png)
  
  5. Marque o projeto e as opções "Update project configuration from pom.xml", "Refresh workspace resources from local filesystem", "clean project" e clique em "OK";  
  ![](/src/test/resources/img/import-eclipse/Passo5.png)
  
  6. Aguarde o projeto atualizar.  
  
<a id="rodando-os-testes"></a>
### Rodando os testes🏃‍
----------------------- 
  
  Você pode escolher rodar todos os testes de uma vez, ou rodar apenas os testes de uma determinada funcionalidade.  
  
  1. Dentro do IDE, expanda o projeto e vá até a pasta (package) __"acceptance"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "saucedemo";  
  ![](/src/test/resources/img/rodar/Passo1.png)
  
  2. Para rodar todos os testes, clique com o lado diretio em cima da pasta __"acceptance"__ e selecione a opção "Run As" > "Junit Test";  
  ![](/src/test/resources/img/rodar/Passo2.png)
      1. Se for rodar apenas os testes de uma funcionalidade, expanda a pasta __"acceptance"__, selecione a classe "Run" da funcionalidade desejada, e faça o mesmo procedimento anterior;  
      ![](/src/test/resources/img/rodar/Passo2.1.png)
  3. Aguarde rodar os testes, e acesse a aba Junit para visualizar os resultados dos testes (pode levar alguns minutos);  
  ![](/src/test/resources/img/rodar/Passo3.png)
  
  4. Para vê a execução individual de cada cenário expanda as suites, no caso de falha verifique o "Faluire Trace" para verificar o problema acontecido;  
  ![](/src/test/resources/img/rodar/Passo4.png)
  
  5. Para avaliar os cenários executados, acesse os arquivos .feature dentro da pasta __"features"__ dentro do caminho: "src" > "test" > "resources".  
  ![](/src/test/resources/img/rodar/Passo5.png)
  
<a id="alterando-massa"></a>
### Alterando a massa de teste🥯
-------------------------------
  
  1. Dentro do IDE, acesse a pasta (package) __"steps"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "saucedemo" > "acceptance";  
  ![](/src/test/resources/img/alterar-navegador/Passo1.png)
  
  2. Abra a classe que irá alterar o navegador de execução;  
  ![](/src/test/resources/img/alterar-navegador/Passo2.png)
  
  3. Encontre a linha da variavél __"navegador"__, e altare para a constante que representa o navegador desejado salvando o arquivo. Possíveis: Firefox, Chrome ou Interno;  
  ![](/src/test/resources/img/alterar-navegador/Passo3.png)
  
  4. Execute novamente;  
  ![](/src/test/resources/img/alterar-navegador/Passo4.png)
  
<a id="alterar-navegador"></a>
### Alterando o navegador de execução⛵
-------------------------------
  
  1. Dentro do IDE, acesse a pasta (package) __"massatestes"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "saucedemo";  
  ![](/src/test/resources/img/alterar-massa/Passo1.png)
  
  2. Abra a classe com a massa que deseja adicionar;  
  ![](/src/test/resources/img/alterar-massa/Passo2.png)
  
  3. Adicione uma constante com o valor desajado e salve o arquivo;  
  ![](/src/test/resources/img/alterar-massa/Passo3.png)
  
  4. Vá até o arquivo steps que utiliza a massa e altere a chamada da constante para o valor criado. Após rode novamente o programa;  
  ![](/src/test/resources/img/alterar-massa/Passo4.png)
  
<a id="autor"></a>
## Autor😉
------------------
  
Feito por August Baumgartner  
[![Linkedin Badge](https://img.shields.io/badge/-August-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://br.linkedin.com/in/august-baumgartner-neto-98512720)](https://br.linkedin.com/in/august-baumgartner-neto-98512720) 
[![Gmail Badge](https://img.shields.io/badge/-augustbn@inmetrics.com.br-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:augustbn@inmetrics.com.br)](mailto:augustbn@inmetrics.com.br)

  
<a id="licenca"></a>
## Licença⚠️
------------------
  
Este projeto esta sobe a licença [MIT](/LICENSE.md).
