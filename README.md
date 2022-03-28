#Transaction Management

### 1.Transaction( transação ): É o princípio de fazer tudo ou nada enquanto uma Aplicacao estiver executando um monte de operações relacionadas a algum tipo de processo que começou a ser iniciado.
### 2. A transação é uma automática unidade de tarefa em que tudo ou nada está acontecendo.
#### A. Exemplo: Transferência de Dinheiro de João ( -500 reais ) para Maria ( +500 reais ).
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### B. Explicação:
##### i. Este Updates têm que acontecer ou não têm que acontecer.
##### ii. O que está acontecendo alí em cima, é uma simples transação. E todo o processo envolvido é o que pode ser chamado de Transaction Management ( Gerenciamento da transação ).
##### iii. A transação começa antes de haver um update ( -500 reais ) na conta do João.
##### iv. E a transação terminará no fim do update ( +500 reais ) realizado na conta de Maria.
##### v. Qualquer commit que a conta de Maria Sofra ou a transação como um todo, poderá receber commits ou se alguma coisa der errado em qualquer passo, seja o 1 ou o 2, é possível fazer rollback da transação inteira.
### 3. Propriedades ACID
#### a. Automicity
#### b. Consistency
#### c. Isolation
#### d. Durability
### 4. Propriedades ACID em Execução
#### a. Automicity - Ambos Updates acontecerão ou não acontecerão e isso é atômico a uma simples unidade de trabalho.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### b. Consistency - Significa que o data base deveria ser deixado em um estado consistente até o fim da transação. Tudo tem que estar em perfeito estado conforme o ciclo que acontecerá e terminará e não haverá nenhum dano.
#### Se olharmos o balanco, o balanco total no fim da transação será consistente. Ou seja, R$ 500 foram deduzidos de João e foi adicionado na conta de Maria. No final, haverá 500 reais na conta de João e 700 reais na conta de Maria.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### c. Isolation - Significa que há muitas transações acontecendo e cada uma dessas deveriam trabalhar isoladas sem impactar umas as outras.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### d. Durability - Uma vez que a transação muda, essas são committed e deveriam permanecer no database que é durável.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |

## Transaction Management Components
### 1. Transactional App
|   Transactional App   |   :---:     |
|   :---:     |   :---:     |
| Ela Coordena com:|  TransactionalManager ou TransactionCo-ordinator      |
|   Esse usa:    |   ResourceManager     |
|   Que esse se comunica:    |   Resource Implícitos (do database)     |
#### - Esta é a aplicação em si mesma.
#### - Esta é a aplicação que está sendo construída onde está sendo habilitada a Transaction Management.
#### - É essa Aplicacao quem faz os commits e rollbacks.
#### - É ela quem coordena com um componente chamado TransactionalManager ou TransactionCo-ordinator.
#### - A TransactionalManager usa o Resource Manager que se comunica com o Resource implícito do database.
#### - Transactional App executará commits e rollbacks que não passam pelo TransactionalManager/TransactionCo-ordinator.
#### - Por sua vez, o TransactionalManager/TransactionCo-ordinator usa o ResourceManager que sabe como usar API's igual ao JDBC, hibernate ORM e etc para executar transações no Resource implícito do Database.
#### - Resource implícito é só um recurso que é chamado numa transação local.
#### - E se houver mais de um Resource, no caso, de ter múltiplos Databases correndo em diferentes servidores, então uma transação distribuída deverá ser chamada.
## Services Layer ( Camada de Serviço )
### - Eles são os responsáveis, dentro do caso de uso deste projeto, para transferir o dinheiro.
### - Será criado uma Interface de serviço de conta bancária, ContaBancariaService, que Implementará uma nova Interface que será criada chamada ContaBancariaServiceImpl, e essa usará ContaBancariaRepo para transferir o dinheiro.
|   Transferência de Dinheiro (caso de uso)  |   :---:     |
|   :---:     |   :---:     |
| Interface: ContaBancariaService|  Implementará:     |
| Interface: ContaBancariaServiceImpl    |   Que usará:    |
| Interface: ContaBancariaRepo    |   Para transferir o dinheiro.     |