Fluxos para Cenários 
1. Login de usuário 
 Scenario: Login bem-sucedido
    Given que o usuário está na página de login
    When ele insere um e-mail e senha válidos
    And clica no botão de login
    Then ele deve ser autenticado com sucesso
    And um token de acesso deve ser gerado

1.1 Login Inválido 
  Scenario: Login com credenciais inválidas
    Given que o usuário está na página de login
    When ele insere um e-mail ou senha inválidos
    And clica no botão de login
    Then uma mensagem de erro "E-mail ou senha incorretos" deve ser exibida

2. Adicionar Produto ao Carrinho
Feature: Adicionar Produto ao Carrinho
  Scenario: Adicionar produto com sucesso
    Given que o usuário está na página de um produto
    When ele clica no botão "Adicionar ao carrinho"
    Then o produto deve ser adicionado ao carrinho
    And o carrinho deve exibir o produto com as informações corretas

2.1 Adicionar múltiplos produtos ao carrinho
  Scenario: Adicionar múltiplos produtos ao carrinho
    Given que o usuário adicionou um produto ao carrinho
    When ele adiciona outro produto ao carrinho
    Then ambos os produtos devem ser exibidos corretamente no carrinho


3. Checkout Simples
Feature: Checkout Simples
  Scenario: Finalizar checkout com sucesso
    Given que o usuário tem produtos no carrinho
    And está na página de checkout
    When ele preenche todos os campos obrigatórios
    And escolhe um método de pagamento
    And clica no botão "Finalizar compra"
    Then a compra deve ser concluída com sucesso
    And uma mensagem "Pedido realizado com sucesso" deve ser exibida

4. Validação de Campos Obrigatórios
Feature: Validação de Campos Obrigatórios
  Scenario: Tentativa de checkout sem preencher campos obrigatórios
    Given que o usuário tem produtos no carrinho
    And está na página de checkout
    When ele deixa campos obrigatórios em branco
    And clica no botão "Finalizar compra"
    Then uma mensagem de erro "Preencha todos os campos obrigatórios" deve ser exibida
