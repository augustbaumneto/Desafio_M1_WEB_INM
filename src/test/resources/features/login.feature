# language: pt

## Feature de login no site do https://www.saucedemo.com/

@login
Funcionalidade: Apenas usuarios cadastrados podem se logar
	Usários cadastros utilizando senha e login válidos e não bloqueados conseguem se logar
  

  Cenario: Um usuario valido não bloqueado consegue se logar
    Dado um usuario valido não bloqueado
    Quando tenta se logar
    Entao é redirecionado para a página de inventário
    
  Esquema do Cenario: Um usuario faltando algum dado ou com algum dado invalido não consegue se logar
    Dado um usuario com username '<dado1>' e senha '<dado2>' 
    Quando tenta se logar
    Entao deve continua na pagina de login
    E mensagem de erro informando que '<mensagem>' é apresentada
    
    Exemplos:
    |  dado1  |  dado2  |          mensagem          |
    |  vazio  |  vazia  |    usuario é necessário    |
    |  vazio  | correta |    usuario é necessário    |
    |  vazio  |incorreta|    usuario é necessário    |
    | correto |  vazia  |     senha é necessária     |
    | correto |incorreta|usuario e senha não combinam|
    |incorreto|  vazia  |     senha é necessária     |
    |incorreto| correta |usuario e senha não combinam|
    |incorreto|incorreta|usuario e senha não combinam|
    
  Cenario: Um usuario valido bloqueado não consegue se logar
    Dado um usuario valido e bloqueado
    Quando tenta se logar
    Entao deve continua na pagina de login
    E mensagem de erro informando que 'o usuario esta bloqueado' é apresentada