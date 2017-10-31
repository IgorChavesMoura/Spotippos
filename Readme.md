# Spotippos
### Desafio back-end Viva Real

### Tecnologias utilizadas:
1. Spring MVC com Spring-boot e Spring data
2. MySQL como base de dados

### Requisitos para rodar o projeto:
1. Possuir JRE ou JDK 
2. Possuir o Mysql instalado (Configuracao de usuario e senha no arquivo application.properties em src/main/resources)

### Formas de rodar o projeto:
* Maven:
	Para rodar com o Maven no terminal, na pasta raiz do projeto digite o seguinte comando
 ```
 mvn spring-boot:run
 ```
 
 * Pelo Main:
 	Um projeto Spring boot pode ser rodado como um arquivo Java comum, para isso, dentro do devido pacote, digite:
 	```
 	javac SpotipposApplication.java && java SpotipposApplication
 	```
 	
 * Pelo Jar:
 	Foi gerado um arquivo Jar para poder executar o projeto de uma maneira mais simples, logo dentro da pasta target digite:
 	```
 	java -jar spotippos-0.0.1-SNAPSHOT.jar
 	```
 	
#### Obs:
Nao precisa se preocupar com os dados iniciais pois ja configurei o Spring para carregar o banco ;) 
 