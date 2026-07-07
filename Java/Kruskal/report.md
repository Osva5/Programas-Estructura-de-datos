# Reporte - Algoritmo de Kruskal (Árbol de Expansión Mínima)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación del algoritmo de Kruskal para encontrar el Árbol de Expansión Mínima (MST) de un grafo no dirigido con pesos. El programa utiliza la estructura Union-Find (con compresión de caminos y unión por rango) para la detección de ciclos y ordena las aristas por peso para seleccionar las `V-1` aristas de menor costo que conectan todos los vértices.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java GKruskal.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `GKruskal.java` | Implementación del algoritmo de Kruskal con clases internas Arista y UnionFind |
| `Main.java` | Programa principal que solicita vértices, aristas y costos, y ejecuta Kruskal |

---

## GKruskal.java

Contiene tres clases:
- **Arista** (inner class): Representa una arista con `origen`, `destino` y `peso`. Implementa `Comparable<Arista>` para ordenar por peso. Incluye `toString()`.
- **UnionFind** (inner class): Estructura de conjuntos disjuntos con `find()` (compresión de caminos) y `union()` (unión por rango) para detección de ciclos.
- **GKruskal**: Algoritmo principal que almacena una lista de aristas, las ordena por peso y usa Union-Find para construir el MST. Muestra las aristas seleccionadas y el costo total.

## Main.java

Pide al usuario el número de vértices y aristas, lee cada arista (origen, destino, costo) y ejecuta `ejecutarKruskal()` para mostrar el MST.

---

## Conclusión

Se implementó el algoritmo de Kruskal con Union-Find, demostrando la construcción del Árbol de Expansión Mínima a partir de un grafo ponderado no dirigido.
