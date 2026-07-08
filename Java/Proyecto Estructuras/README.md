# Reporte - Proyecto Estructuras: Simulador de Grafos

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Este proyecto implementa un simulador de grafos con interfaz gráfica (GUI) en Java Swing. El programa permite crear y manipular grafos de forma visual: agregar vértices y aristas dirigidas/no dirigidas con pesos, ejecutar recorridos BFS/DFS, calcular la ruta más corta con el algoritmo de Dijkstra (para grafos dirigidos) y obtener el árbol de expansión mínima con el algoritmo de Kruskal (para grafos no dirigidos).

Todos usamos aplicaciones de navegación: ingresamos el punto de inicio y el punto final, y el programa construye la ruta óptima. Para ello se utilizan algoritmos de búsqueda de la ruta más corta, siendo Dijkstra el más conocido. En este proyecto se aplica Dijkstra para grafos dirigidos y Kruskal para no dirigidos, utilizando una **lista de adyacencia** en lugar de una matriz de adyacencia para un mejor manejo de memoria.

---

## Entorno y requisitos

- **JDK:** Java 25 o superior (configurado en pom.xml)
- **Build:** Maven (pom.xml incluido)
- **Ejecución:** `mvn clean compile exec:java` o abrir en NetBeans
- **Dependencias:** Ninguna externa (proyecto Java SE puro con Swing)
- **IDE recomendado:** NetBeans (contiene archivo `.form` para la GUI)

---

## Modelo de capas (Arquitectura)

El proyecto sigue el patrón de arquitectura en 3 capas:

| Capa | Descripción |
|---|---|
| **IGU (GUI)** | Interfaz gráfica de usuario. Contiene la ventana, canvas, botones y entradas de texto. Se diseñó con el editor visual de NetBeans. |
| **Lógica** | Contiene todas las clases y métodos del negocio: vértices, aristas, listas, algoritmos de Dijkstra, Kruskal y recorridos. Es el cerebro del programa. |
| **Persistencia** | Capa preparada para futura conexión con base de datos. Actualmente no se implementa, pero la arquitectura está lista para agregarla sin afectar las otras capas. |

---

## Archivos del proyecto

| Archivo | Descripción |
|---|---|
| `pom.xml` | Configuración Maven (groupId: com.mycompany, artifactId: grafos_pila, Java 25) |
| `nbactions.xml` | Configuración de acciones de NetBeans |

### Paquete `logica`

| Archivo | Descripción |
|---|---|
| `TNodo.java` | Nodo genérico `<T>` de lista enlazada simple. Reutilizable y flexible para cualquier tipo de dato. |
| `TLista.java` | Lista enlazada simple genérica. Es la base de la lista de adyacencia que reemplaza a los arreglos, optimizando memoria. |
| `Vertice.java` | Vértice del grafo con ID, coordenadas espaciales `(x, y)`, lista de adyacencia (TLista de Arista), y atributos para Dijkstra (`distanciaMinima`, `predecesor`, `visitado`). |
| `Arista.java` | Arista con referencia al vértice destino, peso y bandera `dirigida` para indicar si es dirigida o normal. |
| `Recorridos.java` | Algoritmos de recorrido BFS (Amplitud) usando TLista como cola auxiliar y DFS (Profundidad) con implementación recursiva. |
| `Dijkstra.java` | Algoritmo de ruta más corta de Dijkstra. Utiliza `PriorityQueue` para seleccionar el vértice con menor distancia. Métodos: `calcular()`, `obtenerCamino()`, `obtenerRutaFormateada()`. |
| `Kruskal.java` | Algoritmo de Kruskal para MST. Ordena aristas por peso (bubble sort sobre TLista) y aplica Union-Find con arreglos para detectar ciclos. |
| `Main.java` | Punto de entrada. Crea un objeto `Pantalla`, asigna título, centra y muestra la ventana. "La llave de encendido" del programa. |

### Paquete `igu`

| Archivo | Descripción |
|---|---|
| `Pantalla.java` | JFrame principal. Es el puente entre el usuario y la lógica matemática de los algoritmos. Controla canvas, botones, eventos de mouse y acción. |
| `Pantalla.form` | Archivo de diseño visual de NetBeans. |

---

## Pantalla.java (GUI)

Ventana interactiva que funciona como simulador de grafos. Permite:

- Agregar vértices haciendo clic en el canvas.
- Agregar/eliminar aristas con pesos.
- Eliminar vértices.
- Consultar si dos vértices son adyacentes.
- Obtener el grado de un vértice.
- Contar el número de vértices existentes.
- Ejecutar recorridos BFS (Amplitud) y DFS (Profundidad).
- Calcular ruta más corta: Dijkstra para grafos dirigidos, Kruskal para no dirigidos.
- Limpiar el grafo completo.
- Alternar modo dirigido/no dirigido.
- Visualizar vértices como círculos azules y aristas con flechas (dirigidas) o líneas (no dirigidas) con etiquetas de peso.

Métodos principales: `trazarArista()`, `conectarConLogica()`, `dibujarNodo()`, entre otros.

## Dijkstra.java

El algoritmo de Dijkstra encuentra el camino más corto desde un nodo inicial a todos los demás en un grafo ponderado con pesos no negativos. Funcionamiento:

1. **Inicialización:** Distancia 0 al nodo inicial, infinito al resto.
2. **Selección:** Elige el nodo no visitado con la distancia más corta y lo marca como visitado.
3. **Actualización:** Para cada vecino no visitado, calcula la distancia tentativa desde el inicial a través del nodo actual; si es menor, actualiza.
4. **Iteración:** Repite hasta visitar todos los nodos o hasta que las distancias restantes sean infinitas.

Se implementa con `PriorityQueue` de Java para optimizar la selección del nodo con menor distancia.

## Kruskal.java

El algoritmo de Kruskal construye un Árbol de Expansión Mínima (MST) en grafos ponderados, conexos y no dirigidos. Su enfoque voraz garantiza seleccionar siempre las aristas de menor peso sin formar ciclos. Funcionamiento:

1. **Inicialización:** Cada nodo del grafo es un árbol independiente (bosque).
2. **Ordenación:** Todas las aristas se ordenan por peso de forma ascendente.
3. **Selección:** Se evalúa cada arista en orden; se añade al MST si une dos componentes diferentes.
4. **Fusión:** Los árboles se fusionan al añadir una arista. Al finalizar, el bosque se reduce a un único árbol.

Se implementa con Union-Find (arreglos) para la detección de ciclos.

## Recorridos.java

- **BFS (Amplitud):** Recorre el grafo por niveles, visitando primero todos los nodos adyacentes al inicial. Usa TLista como cola auxiliar.
- **DFS (Profundidad):** Recorre el grafo explorando primero los nodos más profundos antes de retroceder. Implementación recursiva. Ambos métodos reinician la bandera `visitado` antes de ejecutarse.

## Vertice.java

Guarda el ID del vértice, sus coordenadas espaciales `(x, y)` en el canvas, la lista de adyacencia (objetos `Arista`), y atributos específicos para Dijkstra (`distanciaMinima`, `predecesor`, `padre`, `visitado`). La lista de adyacencia se inicializa en el constructor para evitar errores al agregar aristas.

## Arista.java

Representa la conexión entre vértices. Almacena el peso, la referencia al vértice destino y una bandera `dirigida` para determinar si la arista tiene dirección o es bidireccional.

## TNodo.java y TLista.java (Genéricos)

Ambas clases son versiones genéricas de las implementaciones clásicas vistas en clase. `TNodo<T>` permite almacenar cualquier tipo de dato y mantener la referencia al siguiente nodo. `TLista<T>` proporciona métodos como `insertaFinal()`, `eliminarInicio()`, `listaVacia()`, entre otros. Juntas conforman la lista de adyacencia que optimiza el uso de memoria frente a una matriz de adyacencia tradicional.

---

## Conclusión

Este proyecto integrador combina todas las estructuras de datos vistas durante el curso (listas enlazadas genéricas, pilas, colas, grafos) junto con algoritmos clásicos de la teoría de grafos (BFS, DFS, Dijkstra, Kruskal) en una aplicación gráfica interactiva construida bajo una arquitectura en capas (IGU, Lógica, Persistencia). El uso de listas de adyacencia en lugar de matrices optimiza el consumo de memoria, y la interfaz gráfica desarrollada en NetBeans proporciona una experiencia de usuario amigable e intuitiva.

---

## Referencias

- El Algoritmo de Dijkstra: Cómo Funciona y Dónde se Usa — CódigoNautas (2024). https://codigonautas.com/algoritmo-dijkstra-que-es-ejemplo/
- Algoritmo de Dijkstra: Todo lo que necesitas saber — Tecnodigital (2025). https://informatecdigital.com/el-algoritmo-de-dijkstra/
- Algoritmo de Kruskal: Explicación y Aplicaciones — Tecnodigital (2025). https://informatecdigital.com/el-algoritmo-de-kruskal/
- Modelo de Capas: IGU, Lógica y Persistencia — TodoCode (2021). https://www.youtube.com/watch?v=C6J0TOlCieM&t=178s
