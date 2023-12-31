# Reservation Management


This project aims to build an application using a microservice architecture for handling resource reservations. It involves creating two main microservices: one to manage resources and another for handling reservations by individuals. The technical setup includes Gateway, Discovery, and Configuration services, supported by technologies like Spring Cloud and Angular Framework. Security is established through OAuth2 and OIDC, utilizing Keycloak. Tasks encompass developing microservices, generating RESTful API documentation, building a web frontend, implementing Keycloak authentication, and deploying the application via Docker and Docker Compose.

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![SpringSecurity](https://img.shields.io/badge/Spring%20Security-6DB33F.svg?style=for-the-badge&logo=Spring-Security&logoColor=white)
![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Consul](https://img.shields.io/badge/Consul-F24C53.svg?style=for-the-badge&logo=Consul&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=white)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75.svg?style=for-the-badge&logo=Apache-Tomcat&logoColor=black)
![Git](https://img.shields.io/badge/Git-F05032.svg?style=for-the-badge&logo=Git&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717.svg?style=for-the-badge&logo=GitHub&logoColor=white)

## Prerequisites
```

* Spring Cloud
* Consul Dicovery
* H2 DataBase
* Docker Compose
* Keycloak

```
## How to run using Docker
```
To Run This Project using Docker, docker engine must be install in the local machine.
* Each service must be built before running Docker compose, to do so, 
  use the following command (sould be in the service directory):
    $ mvn clean package -DskipTests
* Run docker compose using the following command (Docker compose can be ran only inside the project directory)
    $ docker compose up -d --build
```

## Consul Discovery
This Project relies on Consul discovery service, first, download [Consul](https://developer.hashicorp.com/consul/install?product_intent=consul).
```
* to run Consul service, we use the following command
    $ consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=«IP ADDRESS»
* To access Consul's interface go to 
    $ http://localhost:8500

* Use Consul with Micro Services as a Discovery:
  1. Add "consul discovery" dependency.
  2. Add "@EnableConsulDiscovry" to the main of any ms.
```
## Keycloak
```
Run keycloak using thefollowin commands (if not using docker):
 $ cd to_keycloak_dir/bin
 $ kc.bat start-dev
```
### Create a Realm:

1. **Log in to Keycloak Admin Console:** Access the Keycloak Admin Console using the URL provided after installing Keycloak (usually `http://localhost:8080/auth`).

2. **Access Administration Interface:** Log in with your admin credentials.

3. **Create a New Realm:** Once logged in, go to the "Master" realm (default). From the top left dropdown, click on "Add realm" to create a new realm. Give it a name and click "Create."

### Create Clients within a Realm:

1. **Inside the Desired Realm:** Select the realm you created or the existing one where you want to create a client.

2. **Navigate to Clients:** Go to the "Clients" section from the left-hand menu.

3. **Add a New Client:** Click on "Create" to add a new client within the realm. Fill in the necessary details like Client ID, Client Protocol, etc.

### Create Users within a Realm:

1. **Access the Desired Realm:** Go to the realm where you want to add users.

2. **Manage Users:** From the left-hand menu, click on "Users" to access the user management section.

3. **Add a New User:** Click on "Add user" to create a new user. Fill in the user details such as username, email, etc.

### Create Roles within a Realm:

1. **Realm Roles vs. Client Roles:** You can create roles at the realm level or within a specific client.

2. **Realm Roles:** To create roles at the realm level, navigate to "Roles" from the left-hand menu within the desired realm and click on "Add role."

3. **Client Roles:** If you want roles specific to a client, go to the "Clients" section, select the desired client, then click on "Roles" to add roles for that particular client.

4. **Assign Roles to Users:** After creating roles, you can assign these roles to users within the "Users" section of the realm or within specific clients.

## Solutions To CORS 

- **Gateway**
```yaml
spring:
  cloud:
    gateway:
      globalcors:
        cors-configurations:
          '[/**]':
            allowed-origins: "http://localhost:4200/"
            allowed-headers: "*"
            allowed-methods:
              - GET
              - POST
              - PUT
              - DELETE
              - OPTION
 ```
- **Server spring security cors**
```java
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList("*"));
            configuration.setAllowedHeaders(Arrays.asList("*"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
    }
```

## Project Dependencies
<table>
    <tr>
        <th>Reservation</th>
        <th>Resource</th>
        <th>Gateway</th>
        <th>Configuraion</th>
    </tr>
    <tr>
        <td><a href="https://github.com/anasbn44/reservation-management/blob/b241bdbb61aa4088d91f82103f919c99f13a60e5/reservation-service/pom.xml"><img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg"/></a></td>
        <td><a href="https://github.com/anasbn44/reservation-management/blob/b241bdbb61aa4088d91f82103f919c99f13a60e5/resources-service/pom.xmll"><img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg"/></a></td>
        <td><a href="https://github.com/anasbn44/reservation-management/blob/b241bdbb61aa4088d91f82103f919c99f13a60e5/gateway-service/pom.xml"><img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg"/></a></td>
        <td><a href="https://github.com/anasbn44/reservation-management/blob/b241bdbb61aa4088d91f82103f919c99f13a60e5/config-service/pom.xml"><img src="https://upload.wikimedia.org/wikipedia/commons/5/52/Apache_Maven_logo.svg"/></a></td>
</table>

## Project Structure
```
This application will consist of two functional microservices:
- "Resources-Service" to manage resources.
- "Reservation-Service"service to handle reservations made by individuals.

The technical microservices to be implemented are:
- Gateway Service based on Spring Cloud Gateway.
- Discovery Service using Consul Discovery.
- Configuration Service based on Spring Cloud Config.

```

<img src="captures/poject-architecture.jpeg">

## Project Diagram
<img src="captures/diagram.png">

## Project Consul Service
<img src="captures/consul.png">

## Project Angular Front Application
#### Home page
<img src="captures/front-home.png">

#### Login With Keycloak
<img src="captures/front-login.png">

#### Resources Page
<img src="captures/front-resources.png">

#### Persons Page
<img src="captures/front-uses.png">

#### Reservations Page
<img src="captures/front-reservation.png">

#### Reservations Infomations
<img src="captures/front-reservation-info.png">
