# Reporte - Matriz (Operaciones sobre matrices bidimensionales)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de operaciones básicas sobre matrices bidimensionales de enteros en Java. El programa permite leer, imprimir, modificar un componente, consultar un componente y obtener la traza (diagonal principal) de una matriz.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java MMatriz.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `MMatriz.java` | Clase envolvente para matrices bidimensionales con operaciones básicas |
| `Main.java` | Programa principal que solicita datos al usuario y prueba las operaciones |

---

## MMatriz.java

Clase que envuelve una matriz bidimensional de enteros. Métodos:
- `leerMatriz()`: Lee todos los valores de la matriz desde teclado.
- `imprimeMatriz()`: Imprime la matriz en consola.
- `cambiarcomponente()`: Cambia el valor de una celda específica (fila, columna, nuevo valor).
- `devolvercomponente()`: Devuelve el valor de una celda específica.
- `trazaMatriz()`: Imprime los elementos de la diagonal principal.

## Main.java

Pide al usuario el número de filas y columnas, lee la matriz, la imprime, permite cambiar un componente, consulta un componente específico y finalmente muestra la diagonal principal (traza).

---

## Conclusión

Se implementaron operaciones fundamentales sobre matrices bidimensionales, incluyendo lectura, escritura, modificación y obtención de la traza, demostrando el manejo de arreglos multidimensionales en Java.
