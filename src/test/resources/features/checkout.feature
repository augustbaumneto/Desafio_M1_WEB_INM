# language: pt

## Feature de Checkout no site do https://www.saucedemo.com/

@checkout
Funcionalidade: O usuário com produtos no carrinho pode realizar o checkout da compra
		- Carrinho deve possuir produtos
		- Na página de confirmação todos os produtos do carrinho deve ser exibido e valor deve ser a soma 
		  de produtos x quantidade mais a taxa de entrega 
       
  Cenario: Realizar checkout com produtos no carrinho
    Dado um usuario logado na página de carrinho
    E existem 2 produtos no carrinho
    Quando clicar no botão de checkout
    Entao deve ser exibido a tela de preenchimento das informações do cliente
		Quando preencher com dados válidos do cliente
		E clicar em continuar
		Entao deve ser exibida a tela de confirmação do checkout
		E deve ser exibido os itens do carrinho com os mesmos dados da página de carrinho
		E valor total exibido deve ser a soma dos valores de todos os itens mais a taxa exibida
		Quando clicar em finalizar
		Entao deve ser exibida a página de conclusão do checkout
		E deve ser exibida mensagem de confimação da ordem
		E carrinho deve estar vazio

  Cenario: Realizar checkout com todos os produtos no carrinho
    Dado um usuario logado na página de carrinho
    E existem 6 produtos no carrinho
    Quando clicar no botão de checkout
    Entao deve ser exibido a tela de preenchimento das informações do cliente
		Quando preencher com dados válidos do cliente
		E clicar em continuar
		Entao deve ser exibida a tela de confirmação do checkout
		E deve ser exibido os itens do carrinho com os mesmos dados da página de carrinho
		E valor total exibido deve ser a soma dos valores de todos os itens mais a taxa exibida
		Quando clicar em finalizar
		Entao deve ser exibida a página de conclusão do checkout
		E deve ser exibida mensagem de confimação da ordem
		E carrinho deve estar vazio