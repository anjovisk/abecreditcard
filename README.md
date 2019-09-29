# abecreditcard
API para aprovação de transações no cartão de crédito.

> ### Desenho da API v1
> ##### Auditoria
> - (POST) /v1/public/payment/authorizations

> ### Testes
> - Coleção de testes da API no postman: https://www.getpostman.com/collections/8cac695256e8c13acb3f

> ### 11 Regras utilizadas para desenhar a API
> ##### APIs organizadas ao longo de recursos
>> A API foi organizada com base no recurso: autorização (pagamento).
> ##### APIs padronizadas
>> A API foi padronizada utilizando substrantivos no plural para URIs que fazem referência à coleções e singular para as demais.
> ##### APIs projetadas para mapear entidades de negócio e suas operações
>> - /v1/public/payment/authorizations
> ##### APIs simples
>> coleção/item: /v1/public/payment/authorizations
> ##### Atualização em lote para operações complexas
>> A API recebe as várias informações necessárias para realizar a autorização e registrar informações auditáveis.
> ##### Padrão ISO 8601 para os atributos de data/hora
>> Os recursos que possuem atributos de data/hora utilizam o formato yyyy-MM-ddTHH:mm:ss.
> ##### APIs documentadas
>> As APIs foram devidamente documentadas utilizando o Swagger. Para consultar a documentação acesse http://x.x.x.x:porta/swagger-ui.html
> ##### Utilizar o protocolo HTTPS/SSL
>> O servidor de aplicações deve ser configurado com um certificado válido para permitir acesso às APIs utilizando o protocolo HTTPS.
> ##### APIs versionadas
>> As APIs foram versionadas. Todas elas ainda se encontram na versão v1. Quando necessário, a nova versão ficará disponível em uma nova URI (Ex.: /v1/public/payment/authorization -> /v2/public/payment/authorization). A versão anterior ainda continuará acessível por tempo indeterminado.
> ##### Utilizar paginação para coleções com grandes volumes
>>  Coleções de transações realizadas são obtidas parcialmente através de páginas. Além dos resultados, a API retorna a página atual, a quantidade total de itens, a quantidade de itens retornados e a quantidade de itens ignorados (offset).
> ##### Utilização os códigos HTTP
>> - 200 (OK) Quando a autorização for processada com sucesso.
>>   - POST /v1/public/payment/authorization
>> - 500 Quando ocorrer um erro interno ao tentar processar a autorização.
