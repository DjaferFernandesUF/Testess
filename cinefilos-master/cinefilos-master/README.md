CINÉFILOS

Descrição:
Um cinema deseja desenvolver um aplicativo piloto para gerenciar compras de ingressos de cinema em seu estabelecimento. 

Eles possuem várias salas de cinema (com intenção de ampliação em breve), cada uma exibindo diferentes filmes em diversos horários. Existem três tipos de sala: 

Salas básicas;
Salas com tecnologia para exibir filmes 3D;
Salas VIP (com poltronas especiais e garçons para fazer pedidos da lanchonete). 

Cada sala tem sua própria quantidade de poltronas e a programação de filmes (que filmes, em que horários). A configuração das salas deve ser realizada no sistema em sua inicialização e não muda, já que obedece às instalações físicas existentes. Já a grade de exibições pode mudar. Assim, podemos pensar no conceito de exibições, que reúnem uma sala, um filme e um horário inicial. O conjunto de todas as exibições correntes compõem a programação do cinema.

O objetivo é permitir que os clientes comprem ingressos para os filmes de sua escolha de maneira conveniente e também alguns itens da lanchonete. O cliente pode escolher a exibição que quer assistir e a quantidade de ingressos a adquirir na exibição. Em uma mesma compra pode-se inserir bilhetes de mais de uma exibição. Também pode inserir itens da lanchonete. 

O cinema quer incentivar a compra online dos bilhetes para reduzir as filas presenciais. Assim, estão iniciando um sistema de cartão fidelidade e quanto mais compras são realizadas online, mais pontos acumula e consequentemente mais descontos também. 


Cartão fidelidade    |            Como atingir                                  |            O que ganha
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Silver           |        cartão inicial de todo cliente que se cadastrar   |   acumula 1 ponto a cada R$ 35,00 reais em compras
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Gold             |        atingir 20 pontos                                 |   acumula 1 ponto a cada R$ 40,00 em compras, 3% de desconto nas compras a partir de R$120,00R$120,00
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Platinum         |        atingir 50 pontos                                 |  acumula 1 ponto a cada R$ 45,00 em compras , 6% de desconto nas compras a partir de R$ 160,00
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Black            |        atingir 80 pontos                                 |   acumula 1 ponto a cada R$ 50,00 em compras, 12% de desconto nas compras a partir de R$ 200,00

 
A primeira tela permite que o usuário escolha o modo de operação:

1.Modo cliente
2.Modo gerente
3.Sair

Funcionalidades para o modo Cliente: 

[Para cliente não logado: a tela inicial deve permitir cadastro ou login]

--> Cadastro de cliente: clientes ainda não se cadastratram devem poder se cadastrar informando nome, e-mail, senha. Todo cliente que acabou de se cadastrar tem o cartão fidelidade Silver.

--> Login de cliente: O cliente faz login inserindo seu e-mail/senha. Uma vez localizado o cliente, se a senha bater com a cadastrada, ele procede para a tela de compra.

[Para cliente já logado]
Exibir menu de compra. 

1.) exibição
--> se o cliente escolher esse tem que apresentar a programação atual do cinema na forma de um menu para ele escolher as exibições/quantidades que quer comprar  acrescentar o pedido à cesta de compras se houver poltronas disponíveis nas exibições de interesse na quantidade desejada

2.)lanchonete 
-->se o cliente escolher essa opção, exibe menu dos itens da lanchonete que podem ser adquiridos online para ele escolher os itens e quantidades desejadas acrescentar o pedido à cesta de compras

3.)fechar pedido 
-->vai apresentar o valor a ser pago (pode ter desconto dependendo do cartão fidelidade e valor da compra) para que o cliente proceda o pagamento - essa parte é fake, faz de conta que fez um pix 
lembrar de realizar o acúmulo de pontos do cliente e também de atualizar o tipo de cartão fidelidade cancelar compra e sair do sistema em ambos os casos após o cliente escolher a exibição/quantidade desejada ou o lanche desejado, voltar para essa tela

Funcionalidades para o modo Gerente:
Os funcionários devem estar previamente cadastrados no sistema.

As salas do cinema (seus tipos e capacidade) devem estar previamente cadastradas no sistema.

Login do gerente: O gerente insere sua senha para acessar o aplicativo.

[Para gerente já logado]

Exibir menu de gerente:
1.)atualizar exibições
2.)Remoção e inserção de exibições (verificar se a sala realmente existe - não precisa ficar checando se há choque de programação pois seria muito complexo. Vamos imaginar que essa programação já vem correta do gerente)
3.)atualizar itens do cardápio da lanchonete
4.)Atualizar preço de itens
5.)Remover itens
6.)Adicionar itens
7.)Gerar relatório de compras com data da compra, tipo do cartão do cliente e valor da compra. No fim informa o valor total arrecadado.
8.)sair do sistema

O estado do sistema deve ser armazenado em arquivos. Assim, clientes e gerentes já cadastrados não são perdidos, as salas, exibições e itens de cardápio já incluídas não são perdidas.

Entregue o sistema já com alguma programação inclusa.
