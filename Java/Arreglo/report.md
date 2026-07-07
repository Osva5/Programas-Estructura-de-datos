# Reporte - Arreglo (Ordenamiento y Búsqueda)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de operaciones fundamentales sobre arreglos unidimensionales en Java. El programa permite leer, imprimir, ordenar (burbuja) y buscar elementos mediante tres métodos: búsqueda secuencial, búsqueda binaria y búsqueda lineal.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TArreglo.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TArreglo.java` | Clase envolvente para arreglo con métodos de ordenamiento y búsqueda |
| `Main.java` | Programa principal que interactúa con el usuario para probar las operaciones |

---

## TArreglo.java

Clase que envuelve un arreglo unidimensional de enteros. Proporciona los siguientes métodos:
- `lectura()`: Lee los elementos del arreglo desde teclado.
- `imprime()`: Imprime el arreglo en consola.
- `ordenaArreglo()`: Ordena el arreglo mediante el algoritmo de burbuja.
- `busquedaSecuencial(int valor)`: Busca un valor recorriendo el arreglo secuencialmente.
- `busquedaBinaria(int valor)`: Busca un valor aplicando búsqueda binaria (requiere arreglo ordenado).
- `busquedaLineal(int valor)`: Busca un valor mediante búsqueda lineal.

## Main.java

Solicita al usuario el tamaño del arreglo y sus elementos, los imprime, los ordena con burbuja y luego pide un valor a buscar probando los tres métodos de búsqueda.

---

## Conclusión

Se implementaron y compararon distintos algoritmos de ordenamiento (burbuja) y búsqueda (secuencial, binaria, lineal) sobre arreglos unidimensionales, comprendiendo sus diferencias de eficiencia y casos de uso.
