# Proceso de diseño

En todo proceso de diseño hay que pensar, el diseño es **emergente**, es decir, a medida que escribimos o pensamos puede surgir otras formas de resolver el problema.

## Proceso
1. Analizar el problema y romper el problema si fuera necesario

2. Definir que problema vamos a atacar primero y dejarlo por escrito en un **TODOLIST**

### Proceso de diseño orientado a objetos tradicional:
3. Definir clases candidatas

4. Definir responsabilidades

5. Diagrama UML donde se vean estas relaciones, puede estar acompañado de código, diagrama de secuencia, etc

6. Codear y verificar

7. Limpiar Código, verificar que siga todo andando

8. Seguir con el siguiente problema (GOTO 3)

### Proceso de diseño orientado al test:
3. Definir un test que presente el problema y lo que se espera del resultado.

4. Hacer que falle para poder tocar código

5. Definir clase o clases candidatas y sus métodos para que el test de verde.

6. Se pueden apoyar en el proceso utilizando un diagrama UML con lo que se está escribiendo, diagrama de secuencia, pero solo de lo que estamos codeando.

7. Limpiar Código, verificar que siga todo verde.

8. Seguir con el siguiente problema del TODOLIST (GOTO 3)

### ¿Que proceso de diseño usar?
Es muy personal que proceso utilizar, algunos se sienten más cómodos con el tradicional, otros con tdd.
La realidad es que cada uno tiene sus ventajas y desventajas. El tradicional, nos permite ver el diseño como un modelo, es más simple de comunicar porque las ideas están en los diagramas. No importa él cómo lo resuelvo sino el que y quienes participan. Nos ayuda a identificar rápidamente si no estamos delegando responsabilidades.
En TDD nos obliga a solo escribir lo que resuelve el problema, no hay sobre diseño si se respeta el procedimiento, el código siempre está verificado por un test. Es más complicado de comunicar sin leer el código, pero utilizando clean code debería ser el código muy legible. Generalmente, yo lo uso cuando no tengo claro como resolverlo y espero que emerja a medida que escribo pero entre arneses, no me puedo salir de lo que tengo que resolver.
El tradicional yo lo uso cuando necesito bajar un modelo complejo, me ayuda a entenderlo aunque no termine siendo después el código una traducción del mismo.  

### ¿Que no hacer?
1. Ir directo a los bifes al como sin entender el que, tampoco tratar de atacar todo, el diseño emerge

2. No verificar código que después hay que limpiar

3. No volver a limpiar el código (sean amables con sus lectores)

### ¿Que puedo leer para profundizar?
1. [TDD de Kent Beck](https://g.co/kgs/GQJ4JE), simple, al hueso, y entretenido

2. [UML simple](http://tadp.wdfiles.com/local--files/material/GuiasParaComunicarUnDise%C3%B1o.pdf), si no sabes que es UML o tenes dudas

3. [Working effectively with legacy code](https://g.co/kgs/KNP2Hf), que hacer cuando sos nuevo y no conoces el código, incluye muchas técnicas de refactor

4. [Growing object-oriented Software](http://www.growing-object-oriented-software.com/), ejemplo de un sistema completo con diseño emergente

5. [Clean Code](https://g.co/kgs/Yxw65B), un clásico, aunque algunas cosas parezcan viejas, las buenas ideas nunca mueren
 
6. [Refactoring](https://g.co/kgs/LnA1cj), esta bueno, me gusta como escribe Kent, pero refactoring guru te lo resume

7. [Head First Desgin Pattern](https://g.co/kgs/rbjkbU) - el libro más entretenido que leí del tema, logran 100% como no dormirse leyendo algo técnico

8. [Object-Oriented Analysis and design](http://home.vinhuni.edu.vn/cuongvcc/wp-content/uploads/sites/109/2017/10/object_oriented_analysis_and_design_with_applications_2nd_edition_2788.pdf) una perlita antigua, cuando UML aun no estaba unificado.
 
### Grandes Videos
1. [Clean Code - Uncle Bob / Lesson 1](https://youtu.be/7EmboKQH8lM) (hay varios lessons)

### El site de la biblia de patrones, smells y técnicas de refactor
1. [Refactoring Guru](https://refactoring.guru/)