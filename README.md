## O DESAFIO
Para conseguir controlar os agendamentos de serviços realizados em assistências técnicas, é necessário que haja um controle dos horários disponíveis para realização do conserto de equipamentos eletroeletrônicos que estejam na garantia. Assim, as assistências técnicas poderão consultar seus agendamentos disponíveis e os clientes poderão marcar um horário para ser atendido. Com o controle detalhado, trará mais qualidade e conforto no atendimento e consequentemente trazendo uma melhoria na prestação do serviço.

São operações necessárias da API:
- Agendar atendimento ao cliente. Os agendamentos deverão ser realizados informando um identificador do cliente (documento), horário (dia/hora), tipo de equipamento e a assistência técnica para qual ele deseja o atendimento. Ao realizar o agendamento, um identificador do agendamento deverá ser gerado e informado. Considerar que cada agendamento ocupará 30 minutos na agenda da assistência técnica.
- Desmarcar agendamento a partir do identificador do agendamento.
- Consultar agenda de agendamentos de uma data.
- Listar assistências técnicas disponíveis.
- Listar horários livres por data para uma assistência técnica.

Tipos de equipamento aceitos: Smartphone, smartwatch, TV, microondas.


## PROPOSTA
Propomos o desenvolvimento da Assistech (uma API REST) para o gerenciamento de agendamentos de serviços em assistências técnicas para equipamentos eletroeletrônicos cobertos por garantia.
A solução abrange as seguintes funcionalidades principais:

Agendamento de Serviços: Permite aos clientes agendar atendimentos informando um identificador de cliente (CPF), horário e data desejados, tipo de equipamento e a assistência técnica. Cada agendamento gerará um identificador único e ocupará um intervalo de 30 minutos na agenda da assistência técnica. 
Cancelamento de Agendamentos: Facilita o cancelamento de agendamentos utilizando o identificador do agendamento. 
Consulta de Agendas: Permite consultar a agenda de agendamentos para uma data específica. 
Listagem de Assistências Técnicas: Fornece uma lista das assistências técnicas disponíveis. 
Listagem de Horários Livres: Permite verificar horários livres em uma data específica para uma determinada assistência técnica.


## CONSTRUÇÃO E VALIDAÇÃO
- Configuração do ambiente de desenvolvimento utilizando Eclipse/Intellij como IDE. Configuração do repositório Git no GitHub para controle de versão. 
- Criação do arquivo .env para armazenar informações sensíveis do banco de dados, garantindo segurança ao não subir essas informações para o repositório público. 
- Escolha de Java com Spring Boot como a linguagem e framework principais devido à sua robustez e escalabilidade. 
- Seleção do MySQL como banco de dados relacional para armazenar as informações de agendamentos. 
- Utilização do Trello para cadastro, atribuição e controle das tarefas (tasks), permitindo uma gestão visual e colaborativa do projeto. 
- Insomnia para testes de aplicações dos endpoints da API.
- DBeaver para consulta e manipulação do banco de dados.


## SOLUÇÃO
A solução consiste em uma API RESTful para o gerenciamento de agendamentos de serviços em assistências técnicas. A API foi desenvolvida para ser escalável, segura e fácil de usar tanto por assistências técnicas quanto por clientes.

Arquitetura:
- Camada de Apresentação: A API fornece endpoints RESTful para interação com os clientes e assistências técnicas. 
- Camada de Serviço: Contém a lógica de negócios para gerenciamento dos agendamentos, incluindo validações e regras de negócio. 
- Camada de Persistência: Utiliza Spring Data JPA para interagir com o banco de dados MySQL, abstraindo a complexidade das operações de banco de dados.

Ambiente e Ferramentas: 
- Linguagens e Frameworks: 
- Java com Spring Boot: Para a implementação da API. 
- Spring Data JPA: Para gerenciamento da persistência dos dados. 
- MySQL: Como banco de dados relacional para armazenar informações de agendamentos.

Ferramentas de Desenvolvimento: 
- Eclipse/Intellij: Utilizado como IDE para o desenvolvimento do projeto. 
- Git e GitHub: Para controle de versão e colaboração entre os membros da equipe. 
- .env: Para armazenamento seguro das configurações do banco de dados.


## Autores
[@AllanVasconceL0s](https://github.com/AllanVasconceL0s)
[@geyllalirasantos](https://github.com/geyllalirasantos)
[@hugofranca06](https://github.com/hugofranca06)
[@LuizMXavier](https://github.com/LuizMXavier)
[@Pedrolins29](https://github.com/Pedrolins29)
