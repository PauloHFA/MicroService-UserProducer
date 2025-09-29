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

e agora dentro da nossa instancia vamos criar uma fila, broker(explicar o que e broker) para comunicação direta entre os seriços 

<img width="959" height="116" alt="image" src="https://github.com/user-attachments/assets/04c39940-ed05-40ae-8ac2-bd7b93333c1d" />

<img width="986" height="665" alt="image" src="https://github.com/user-attachments/assets/fd0dbe7a-1473-488a-9f8a-e2510d96fbac" />

ao clicar em add queue e dar um nome para a fila ela aparecera configurada

<img width="860" height="98" alt="image" src="https://github.com/user-attachments/assets/15c89db1-e1f7-4bfd-a171-cffe9e867e9a" />

agora podemos enviar as mensagens pelo meu serviço de user producer, atraves do payload 

<img width="759" height="430" alt="image" src="https://github.com/user-attachments/assets/8f7a4af9-6374-4452-afad-a7630e557cdb" />

agora dentro do spring precisamos configurar este component para conseguir realizar o envio da mensagem vamos adicionar as dependencias necessarias para o uso do rabbit 	

    <dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit-test</artifactId>
			<scope>test</scope>
	</dependency>
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-amqp</artifactId>
	</dependency>

e depois vamos criar um component com o rabbit template e vamos utilizar o metodo do rabbit template para realizar a conversão e envio da mensagem 

<img width="737" height="711" alt="image" src="https://github.com/user-attachments/assets/8cf35377-5609-4de5-a1b6-e9ab471e773d" />
