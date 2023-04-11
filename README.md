# Alegra Technical Challenge

Este es un challenge tecnico que hice como parte de mi proceso de seleccion en Alegra.

## Tech Stack

**Server:** Java, Spring, JPA, Docker, Linux.

**Cliente**: HTML, CSS, VueJS.

## Link al deploy

Aqui pueden encontrar la aplicacion deployada en un servidor Linux, usando el servicio de Droplets de DigitalOcean


[Link](http://164.90.185.14:8080/)


## Correrlo en local

Clona el proyecto
```bash
  git clone https://github.com/JeremiasOviedo/alegra-challenge.git
```
Dirigete al directorio del proyecto
```bash
  cd alegra-challenge
```
Configura la conexion a base de datos de los microservicios kitchen y warehouse en sus respectivos application.properties

msvc-kitchen:
```bash
spring.datasource.url=jdbc:mysql://mysql8:3306/msvc_kitchen?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true
```
msvc-warehouse:
```bash
spring.datasource.url=jdbc:mysql://mysql8:3306/msvc_warehouse?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true
```
Ejecuta docker-compose
```bash
  docker-compose up
```
El servidor deberia iniciarse por defecto en la ip
```bash
  http://127.0.0.1:8080/
```


# Problematica

## Jornada de almuerzo ¡gratis!

>Un reconocido restaurante ha decidido tener una jornada de donación de comida a los
residentes de la región con la única condición de que el plato que obtendrán los
comensales será aleatorio. El administrador del restaurante requiere con urgencia un
sistema que permita pedir platos a la cocina.
¿En qué consiste?
El gerente del restaurante debe poder indicarle a la cocina que se debe preparar un
plato, la cocina selecciona aleatoriamente el plato a preparar y pide a la bodega de
alimentos los ingredientes requeridos, si la bodega tiene disponibilidad entrega los
ingredientes a la cocina, si no debe comprarlos en la plaza de mercado. Cuando la cocina
recibe los ingredientes, prepara el plato y entrega el plato preparado.

## ¿Cómo funciona?

>1. El gerente del restaurante presiona un botón que envía una orden a la cocina para
preparar un nuevo plato.
> 
>2. La cocina cuenta con una lista de 6 recetas disponibles (creados a criterio del
candidato), los cuales deben usar únicamente los ingredientes disponibles (ver
lista de ingredientes en la parte final del texto), todos los ingredientes deben ser
usados en mínimo una receta. Cada receta contiene los ingredientes que la
componen y la cantidad requerida de cada uno.
>
>3. Cuando la cocina recibe un pedido de un plato debe seleccionar aleatoriamente
de la lista de recetas disponibles el plato a preparar.
>
>4. La cocina debe pedir a la bodega de alimentos los ingredientes para preparar el
plato seleccionado. Debe esperar que los ingredientes sean entregados para
continuar con la preparación del plato.
>
>5. La bodega de alimentos inicia con una cantidad de 5 unidades por ingrediente.
Cuando recibe un pedido de ingredientes debe verificar si los tiene disponibles, si
no debe comprar los ingredientes restantes en la plaza de mercado, la cual puede
tener o no disponibles los ingredientes. Si no se tienen disponibles los
ingredientes en la plaza, la bodega de alimentos debe esperar hasta que estén
disponibles.
>
>6. La plaza de mercado se encuentra ubicada en la dirección https://recruitment.alegra.com/api/farmers-market/buy . Recibe en el parámetro ingredient el nombre del ingrediente que se desea comprar, las opciones válidas para este se indican en la lista de ingredientes al final del texto. Retorna en JSON un atributo con las cantidades vendidas (quanitySold) del ingrediente en la plaza, hay posibilidades de que el ingrediente no esté disponible, (se retorna quantitySold en 0). Se considera una compra exitosa cuando la respuesta de la plaza de mercado sea un número entero diferente de cero que indica las cantidades compradas.
>
>7. La cocina puede entregar el plato únicamente cuando todos los ingredientes se encuentran disponibles, al prepararse el plato los ingredientes utilizados se
disminuyen de la bodega de alimentos.
>
>La interfaz para el usuario debe contener mínimo los siguientes elementos:
>
>- Botón para pedir un plato. Tener en cuenta que como es una jornada de donación de platos gratis, se debe disponer el sistema para que reciba pedidos masivos de platos.
>
>- Se debe poder observar las órdenes en preparación en la cocina.
>
>- Debe mostrarse los ingredientes y sus cantidades disponibles en la bodega de alimentos y el historial de compras en la plaza de alimentos.
>
>- Se debe poder observar el historial de pedidos realizados a la cocina.
>
>- Las recetas con ingredientes y cantidades deben poder observarse en la pantalla.
>
>Al gerente de la empresa le gusta mantenerse a la moda por lo tanto ha exigido que el
desarrollo debe montarse en una arquitectura de microservicios que corren con docker.
>
### Ingredientes disponibles para las recetas:

>- Tomato
>- Lemon
>- Potato
>- Rice
>- Ketchup
>- Lettuce
>- Onion
>- Cheese
>- Meat
>- Chicken


