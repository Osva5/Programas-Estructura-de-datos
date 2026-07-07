# Reporte - Grafos (Matriz de Adyacencia y Costos)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de la representación de grafos mediante matrices de adyacencia y de costos en Java. El programa permite leer una matriz de adyacencia (no dirigida) y una matriz de costos (dirigida) desde teclado, y visualizar ambas matrices en consola.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TGrafo.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TGrafo.java` | Clase que modela un grafo con matrices de adyacencia y costos |
| `Main.java` | Programa principal que solicita datos al usuario y muestra las matrices |

---

## TGrafo.java

Clase que representa un grafo mediante:
- `matrizA`: Matriz de adyacencia (no dirigida).
- `matrizC`: Matriz de costos (dirigida, con -1 indicando infinito almacenado como `Integer.MAX_VALUE/2`).

Métodos:
- `leeMatrizA()`: Lee la matriz de adyacencia no dirigida.
- `leeMatrizC()`: Lee la matriz de costos del grafo dirigido.
- `muestraMatrizA()`: Imprime la matriz de adyacencia.
- `muestraMatrizC()`: Imprime la matriz de costos (simbolizando infinito con el carácter ∞).

## Main.java

Pide al usuario el número de vértices, lee la matriz de costos del grafo dirigido y muestra tanto la matriz de adyacencia como la de costos en consola.

---

## Conclusión

Se implementó la representación matricial de grafos, permitiendo visualizar las conexiones (adyacencia) y los pesos (costos) de un grafo dirigido, sentando las bases para algoritmos de caminos mínimos y recorridos.
