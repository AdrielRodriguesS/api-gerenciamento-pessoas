# Api para Gerenciamento de Pessoas

## Como Usar
- Faça o download da aplicação ou clone o repositório  
- Rode em sua IDE ou direto no Servidor  
- Como default a aplicação irá rodar na porta 8080 em http://localhost/8080

## Paths

### Entidade Pessoas:
**GET:** http://localhost/8080/pessoas/buscarTodas - Busca todas pessoas  
**GET:** http://localhost/8080/pessoas/buscar/{id} - Busca pessoa pelo Id  
**POST:** http://localhost/8080/pessoas/criar - Cria uma pessoa no Banco  
**PUT:** http://localhost/8080/pessoas/atualizar/{id} - Atualiza os dados de uma pessoa  
**DELETE:** http://localhost/8080/pessoas/apagar/{id} - Apaga uma pessoa (e seus endereços caso existam)  

**Exemplo de JSON para POST e PUT:**  
{  
    "nome": "Pessoa5",  
    "dataNascimento": "2005-01-01"  
}  

### Entidade Endereço
**GET:** http://localhost/8080/endereco/buscar?pessoaId={id} - Busca os endereços de uma pessoa passando seu Id  
**GET:** http://localhost/8080/endereco/buscar/principal/{id} - Busca o endereço principal da pessoa  
**POST:** http://localhost/8080/endereco/criar - cria um endereço  
**PUT:** http://localhost/8080/endereco/atualizar/{id} - atualiza os dados de um endereço  
**DELETE:** http://localhost/8080/endereco/apagar/{id} - apaga um endereço  

**Exemplo de JSON para POST e PUT:**  
{  
    "logradouro": "Rua tres_um",  
    "cep": "33333-111",  
    "numero": "003",  
    "cidade": "CidadeTres",  
    "enderecoPrincipal": true  
    "pessoaId" : "1"  
}  

#### Enjoy!!!

