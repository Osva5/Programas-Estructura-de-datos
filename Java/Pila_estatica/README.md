# Reporte - Pila Estática (Array-Based Stack)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de una pila estática (basada en arreglo) en Java. La pila utiliza un arreglo de tamaño fijo con un puntero `tope` para manejar las operaciones push y pop. Se aplica en un programa que verifica si un número entero es capicúa (palíndromo numérico).

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TPilaA.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TPilaA.java` | Pila estática implementada con arreglo de tamaño fijo |
| `Main.java` | Programa que verifica si un número es capicúa usando la pila estática |

---

## TPilaA.java

Pila estática implementada con un arreglo `int[]`. Atributos:
- `pila[]`: Arreglo de enteros de tamaño fijo.
- `tope`: Índice que indica el tope de la pila.

Métodos:
- `pilaVacia()`: Verifica si la pila está vacía.
- `pilaLlena()`: Verifica si la pila está llena.
- `insertaDato(int dato)`: Apila un elemento (push).
- `eliminaDato()`: Desapila un elemento (pop).

## Main.java

Verifica si un número entero ingresado por el usuario es capicúa. Para ello, descompone el número en dígitos, apila la primera mitad en la pila estática y luego desapila comparando con la segunda mitad del número.

---

## Conclusión

Se implementó una pila estática con arreglo fijo y se aplicó exitosamente para la verificación de números capicúa, demostrando el comportamiento LIFO de la estructura.
