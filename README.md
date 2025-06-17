## Tecnologias usadas
- JAVA
- JIRA
- API
- Identity Security Cloud (Sailpoint)
- WEBHOOK
- LAMBDA (AWS)

## Sobre o projeto
Essa automação é um case que estou aplicando onde trabalho. 

A automação realiza requisições à API do JIRA para identificar tickets de solicitação de acesso a sistemas que estejam com o status PENDENTE. Em seguida, armazena as informações retornadas no ticket e verifica o tipo da solicitação — se é concessão ou revogação de acesso. Com base nisso, direciona para a condição correspondente e inicia o processo de provisionamento do usuário no sistema.

Para isso, a automação faz uma chamada à API do sistema: utilizando o método POST para conceder o acesso ou DELETE para revogar. Após a requisição, valida o código de status (status code) retornado pela API do sistema e, se tudo estiver correto, conclui o ticket no JIRA.

Possíveis erros de retorno também foram mapeados na automação. Caso ocorra alguma falha que impeça a execução completa do processo, a automação atualiza o status do ticket para "Atuação Manual" e o direciona para um analista da equipe de operações, que ficará responsável pelo tratamento manual da solicitação.

## Como funciona
- JAVA - Linguagem usada.
- IDENTITY SECURITY CLOUD (ISC) - Onde o colaborador faz a solicitação de acesso.
- JIRA - Onde chega o ticket assim que o colaborador faz a solicitação de acesso.
- WEBHOOK - Simula o sistema onde o usuário vai ser provisionado.
- LAMBDA AWS - Onde a automação vai rodar.
