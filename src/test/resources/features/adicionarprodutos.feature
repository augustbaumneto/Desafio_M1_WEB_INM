# language: pt

## Feature de Adicionar Produtos no site do https://www.saucedemo.com/

@adicionar_produtos
Funcionalidade: O usuário ao se logar pode escolher e adicionar produtos no carrinho para efetuar a compra posteriormente
		- Ao selecionar produtos este devem ser incluidos no carrinho.
		- Não é possível selecionar uma segunda vez o mesmo produto já adicionado
		- É possível retirar produtos adicionados
		- Ao se clicar no carrinho todos os produtos devem ser exibidos 
  

  Esquema do Cenario: Adicionar produto no carrinho pela tela de inventário com carrinho vazio
    Dado um usuario logado na página de inventário
    E carrinho esta vazio
    Quando escolho o produto '<produto>' e clico no botao adicionar no carrinho equivalente
    Entao botão(s) clicado(s) deve(m) ser alterado(s) para remover
    E carrinho deve indicar que possui 1 produtos adicionados
    Quando clicar no carrinho
    Entao deve ser direcionado para a página do carrinho
    E deve ser exibido os itens selecionados com os mesmos dados da página anterior

    Exemplos:
      |         produto				 |
      |   Sauce Labs Backpack  |
      |  Sauce Labs Bike Light |
      | Sauce Labs Bolt T-Shirt|
      |Sauce Labs Fleece Jacket|
      |    Sauce Labs Onesie   |
      |      T-Shirt (Red)     |
      
  Cenario: Adicionando dois produtos no carrinho pela tela de inventário com carrinho vazio
    Dado um usuario logado na página de inventário
    E carrinho esta vazio
    Quando escolho dois produtos e clico no botao adicionar no carrinho equivalente de ambos
    Entao botão(s) clicado(s) deve(m) ser alterado(s) para remover
    E carrinho deve indicar que possui 2 produtos adicionados
    Quando clicar no carrinho
    Entao deve ser direcionado para a página do carrinho
    E deve ser exibido os itens selecionados com os mesmos dados da página anterior  
    
  Cenario: Acessar tela do carrinho sem produtos adicionados
    Dado um usuario logado na página de inventário
    E carrinho esta vazio
    Quando clicar no carrinho
    Entao deve ser direcionado para a página do carrinho
    E não deve ser apresentado itens na tela
    
 Cenario: Adicionando seis produtos no carrinho pela tela de inventário com carrinho vazio
    Dado um usuario logado na página de inventário
    E carrinho esta vazio
    Quando escolho seis produtos e clico no botao adicionar no carrinho equivalente de ambos
    Entao botão(s) clicado(s) deve(m) ser alterado(s) para remover
    E carrinho deve indicar que possui 6 produtos adicionados
    Quando clicar no carrinho
    Entao deve ser direcionado para a página do carrinho
    E deve ser exibido os itens selecionados com os mesmos dados da página anterior  
  
    