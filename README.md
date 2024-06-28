# JWT_RestAPI

## Documentação para JWT_RestAPI

### Visão Geral
Esse é um aplicativo REST API simples, construído usando Spring Boot, Spring Security e JWT para autenticação e autorização. O aplicativo inclui funções de usuário e endpoints seguros que são acessíveis com base nas funções do usuário.

### Estrutura do Projeto

O projeto consiste em seis pacotes principais:

1. application
2. config
3. controller
4. model
5. security
6. service

![1](https://github.com/HeyPaulin/API_JWT/assets/101124585/c5f462fd-bf27-495f-aa70-0ae42e7b4db6)

#### 1. application
- **JwtRestApiApplication**
  - Ponto de entrada para o aplicativo Spring Boot.
  - Escaneia os componentes Spring no pacote `com.example`.

![2 ](https://github.com/HeyPaulin/API_JWT/assets/101124585/27699562-a4f5-4e79-9f09-97941d03a4f9)


#### 2. config
- **SecurityConfig**
  - Configura a segurança do aplicativo.
  - Desabilita a proteção CSRF.
  - Configura a segurança HTTP para permitir o acesso a determinados endpoints com base em funções.
  - Define quatro usuários em memória: admin, gerente, vendedor e cliente, com suas respectivas funções.

![3 1](https://github.com/HeyPaulin/API_JWT/assets/101124585/82f88127-524d-4d4d-ab78-ebc7aba57b0c)
![3 2](https://github.com/HeyPaulin/API_JWT/assets/101124585/2968f1d0-1853-4141-b5d8-acb08fc0affe)



#### 3. controller
- **AuthController**
  - Define endpoints REST para login e acesso baseado em funções.
  - Usa AuthService para gerar e extrair tokens JWT.
  - Fornece endpoints para obter os detalhes do usuário autenticado com base nas funções.
  - POST /login - Autentica um usuário e retorna um token JWT.
  - GET /username/{token} - Extrai o nome de usuário de um token JWT.
  - GET /user - Recupera os detalhes do usuário autenticado.
  - GET /admin/users - Endpoint acessível apenas por usuários com o papel ADMIN.
  - GET /manager/products - Endpoint acessível apenas por usuários com o papel GERENTE.
  - GET /seller/orders - Endpoint acessível por usuários com os papéis VENDEDOR ou CLIENTE.
  - GET /customer/products - Endpoint acessível apenas por usuários com o papel CLIENTE.
![4 1](https://github.com/HeyPaulin/API_JWT/assets/101124585/44b1892c-fec0-40b3-a75d-0ab0bf5cdc3c)
![4 2](https://github.com/HeyPaulin/API_JWT/assets/101124585/f2b4aad2-b8eb-49e5-a8c7-3a852957025b)




#### 4. model
- **LoginRequest**
  - Uma classe de modelo simples para solicitações de login.
  - Contém campos de nome de usuário e senha com os respectivos getters e setters.

![5 ](https://github.com/HeyPaulin/API_JWT/assets/101124585/d3299753-0021-4903-ab2f-4f99e2639c10)


#### 5. security
- **JwtUtil**
  - Classe utilitária para gerar e extrair tokens JWT.
  - Define a geração de chave secreta e configurações de expiração do token.
  - Usa a biblioteca JJWT para operações JWT.

![6](https://github.com/HeyPaulin/API_JWT/assets/101124585/142368e1-d4e9-45a5-b36c-d543d94ef2f5)


#### 6. service
- **AuthService**
  - Fornece serviços para gerar e extrair tokens JWT.
  - Usa JwtUtil para operações de token.

![7](https://github.com/HeyPaulin/API_JWT/assets/101124585/7f465a0d-7dee-4106-b2f6-cf8a657bf008)


### Endpoints

![Base_JWT](https://github.com/HeyPaulin/API_JWT/assets/101124585/ce073c5d-3167-43df-a153-f45ea612c429)


#### POST /login
- Endpoint para login de usuário.

![Login_JWT](https://github.com/HeyPaulin/API_JWT/assets/101124585/0d8f08b3-2311-4ba9-b87a-a5d9e896c547)


#### GET /extractUsername
- Extrai o nome de usuário do token JWT.

![Extract_JWT](https://github.com/HeyPaulin/API_JWT/assets/101124585/3cdb19e0-80a2-4934-b58a-4fd217537ae1)


#### GET /admin
- Endpoint acessível apenas pelo usuário com função de admin.

![GET_ADM](https://github.com/HeyPaulin/API_JWT/assets/101124585/80a19e22-e61e-48d7-b91d-c3b27662b88d)


#### GET /gerente
- Endpoint acessível apenas pelo usuário com função de gerente.

![GET_GERENTE](https://github.com/HeyPaulin/API_JWT/assets/101124585/4db21850-aacc-4cc5-849c-e36009006402)


#### GET /cliente
- Endpoint acessível pelo usuário com função cliente.

![GET_CLIENTE](https://github.com/HeyPaulin/API_JWT/assets/101124585/7295ae1b-e9a0-4ea6-aef7-05bc374814b6)


#### GET /vendedor
- Endpoint acessível pelo usuário com função vendedor.
  
![GET_VENDEDOR](https://github.com/HeyPaulin/API_JWT/assets/101124585/3466104b-cb05-4f6a-983b-5577fd0536af)


### Diagrama
- Diagrama ilustrando o fluxo do aplicativo.

![Diagrama](https://github.com/HeyPaulin/JWT_RestAPI/assets/101124585/f6997cc7-c155-4c1a-bb7f-3e12ac7852c2)

### Conclusão
A API E-commerce JWT User proporciona uma autenticação segura utilizando JSON Web Tokens (JWT), possibilitando o acesso a endpoints protegidos com diferentes níveis de permissão (ADMIN, GERENTE, VENDEDOR, CLIENTE). Para começar, obtenha uma chave de API, inclua-a nas suas solicitações HTTPS e utilize tokens JWT para autenticação.
