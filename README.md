# MicroServico-UserProducer

Um micro serviço que se comunica com outro para realizar envio de emails com persistencia e fila, atraves da configuração do payload e os metodos de assinatura do rabbitmq, utilizando rabbitmqcloud dentro de uma instancia da Amazon Web Services. 

para isso nos precisamos criar uma conta na https://www.cloudamqp.com/
<img width="1117" height="636" alt="image" src="https://github.com/user-attachments/assets/5e8f6f04-be2d-45f7-ad28-6b341266a8bf" />

depois de criarmos nossa conta vamos criar nossa instancia, no meu caso utilizei a litle lemur free, configuramos a região 
<img width="1502" height="676" alt="image" src="https://github.com/user-attachments/assets/94ff8ba3-704f-43fa-9202-70e0bd8df698" />

depois vamos entrar na nossa instancia para pegar nossas crendenciais para conseguirmos realizar a conexão do noss micro serviço com a instancia

<img width="1714" height="471" alt="image" src="https://github.com/user-attachments/assets/609f7657-d553-4530-8960-d5da3716e32d" />

dentro da instancia nos podemos visualizar quanto nos podemos consumir no nosso plano free e podemos visualizar nossar credenciais que vamos utilizar para conectar no nosso spring, atraves da nossa application.propreites

<img width="1564" height="847" alt="image" src="https://github.com/user-attachments/assets/0b8209c4-3939-470b-8ac8-cb2ec71e56e4" />

vamos copiar o endereço dentro da tag de spring.rabbitmq.addresses=
