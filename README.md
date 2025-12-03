# Advent of Code 2025 - Day 1: Secret Entrance

Este proyecto contiene la solución para el **Día 1** del Advent of Code 2025, desarrollado en **Java**. El problema consiste en simular el mecanismo de una caja fuerte (un dial giratorio) para encontrar la contraseña correcta basándose en una serie de instrucciones de rotación.

## Descripción del Problema

Los Elfos necesitan decorar el Polo Norte, pero la contraseña de la entrada secreta ha cambiado. Para abrir la puerta, debemos descifrar la combinación de una caja fuerte siguiendo una lista de instrucciones de rotación (ej. `L68`, `R48`).

El dial tiene números del 0 al 99.

- **L (Left)**: Gira hacia números menores (antihorario).
- **R (Right)**: Gira hacia números mayores (horario).
- El dial comienza en la posición **50**.

### Parte 1

La contraseña es el número de veces que el dial termina apuntando al **0** _después_ de completar cada rotación de la lista.

### Parte 2

Debido a nuevos protocolos de seguridad ("método 0x434C49434B"), la contraseña es el número de veces que el dial apunta al **0** en _cualquier momento_, es decir, contando cada "clic" individual durante la rotación, no solo al final.

## Estructura del Proyecto

El código está organizado en paquetes para separar las soluciones de cada parte:

- `src/main/java/software/aoc/day01/a`: Solución para la **Parte 1**.
- `src/main/java/software/aoc/day01/b`: Solución para la **Parte 2**.

Ambos paquetes siguen la misma estructura de clases:

- **`Main.java`**: Punto de entrada de la aplicación. Orquesta la lectura del archivo y la ejecución de la lógica del dial.
- **`FileInstructionReader.java`**: Se encarga exclusivamente de leer el archivo de entrada y procesarlo en una lista de instrucciones.
- **`Dial.java`**: Contiene la lógica de negocio del dial, manteniendo su estado y calculando los movimientos.

## Principios de Ingeniería de Software

El desarrollo de esta solución se ha guiado por principios sólidos de Programación Orientada a Objetos (POO) para asegurar un código limpio, mantenible y robusto.

### 1. Modularidad

El código está altamente modularizado. En lugar de tener un único archivo gigante ("God Class"), la funcionalidad se ha dividido en clases pequeñas y cohesivas.

- La lógica de entrada/salida (I/O) está separada de la lógica de negocio.
- Cada parte del problema (Parte 1 y Parte 2) tiene su propio paquete, permitiendo que evolucionen de forma independiente sin romper la otra.

### 2. Single Responsibility Principle (SRP) - Principio de Responsabilidad Única

Cada clase tiene una única razón para cambiar:

- **`FileInstructionReader`**: Su única responsabilidad es leer el archivo del disco. No sabe nada sobre cómo funciona un dial ni qué significan las instrucciones. Si cambiamos el formato del archivo o la fuente de datos (ej. base de datos), solo modificamos esta clase.
- **`Dial`**: Su única responsabilidad es modelar el comportamiento de la caja fuerte. No sabe de dónde vienen las instrucciones (si de un archivo o de un input de usuario). Se encarga de parsear los movimientos (`L` o `R`), actualizar su estado interno y contar los ceros.
- **`Main`**: Su única responsabilidad es inyectar las dependencias (pasar las instrucciones al Dial) e imprimir el resultado.

### 3. Encapsulamiento

El estado interno del objeto `Dial` está protegido.

- Los atributos `state`, `zeroCount` y `movements` son `private`.
- La lógica compleja de cómo se aplica un movimiento (`applyMovement`, `parseValue`) es `private`, exponiendo solo el método público necesario `getZeros()`. Esto define una API clara y evita que clases externas manipulen el estado del dial de forma incorrecta.

### 4. Inmutabilidad (donde aplica)

La clase `FileInstructionReader` está definida como un `record`, lo que la hace inmutable y concisa, ideal para portar datos o configuraciones simples como el `filePath`.

---

_Desarrollado para la asignatura de Ingeniería de Software - Advent of Code 2025_
