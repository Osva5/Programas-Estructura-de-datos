# Reporte - Árbol Binario de Búsqueda (BST)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de un Árbol Binario de Búsqueda (ABB) en Java. El programa permite al usuario insertar valores enteros en el árbol respetando la propiedad BST (menores a la izquierda, mayores a la derecha) y visualizar el árbol mediante tres recorridos: preorden, inorden y postorden.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TArbol.java TNodoA.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TNodoA.java` | Nodo de árbol binario con dato entero, referencias izquierda/derecha y método `imprimeValor()` |
| `TArbol.java` | Árbol Binario de Búsqueda con inserción y recorridos preorden, inorden y postorden |
| `Main.java` | Programa principal que crea el árbol, solicita valores al usuario y muestra los recorridos |

---

## TNodoA.java

Define la estructura de un nodo de árbol binario. Contiene un atributo `dato` (int), referencias `izq` y `der` para los hijos izquierdo y derecho, sus respectivos getters/setters y el método `imprimeValor()` que imprime el valor del nodo en consola.

## TArbol.java

Implementa las operaciones del Árbol Binario de Búsqueda:
- `insertar(int dato)`: Inserta un nodo respetando el orden BST.
- `imprimePreOrden(TNodoA nodo)`: Recorrido raíz → izquierdo → derecho.
- `imprimeInOrden(TNodoA nodo)`: Recorrido izquierdo → raíz → derecho.
- `imprimePostOrden(TNodoA nodo)`: Recorrido izquierdo → derecho → raíz.

## Main.java

Solicita al usuario el valor de la raíz y valores adicionales para insertar en el árbol. Al finalizar, muestra el árbol en los tres órdenes de recorrido.

---

## Conclusión

Se implementó un Árbol Binario de Búsqueda funcional con los tres recorridos clásicos, demostrando el funcionamiento de estructuras de datos jerárquicas y la lógica de inserción ordenada en BST.
