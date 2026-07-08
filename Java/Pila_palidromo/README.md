# Reporte - Pila para Palíndromos (Palabras)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de una pila (LIFO) mediante herencia de una lista enlazada para caracteres. La pila se utiliza en un programa que verifica si una palabra ingresada por el usuario es un palíndromo (se lee igual al derecho y al revés).

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TLista.java TNodo.java TPila.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TNodo.java` | Nodo de lista enlazada para caracteres (char) |
| `TLista.java` | Lista enlazada simple para caracteres con inserción al final y eliminación al inicio |
| `TPila.java` | Pila que hereda de TLista, con métodos `push(char)` y `pop()` |
| `Main.java` | Programa que verifica si una palabra es palíndromo usando la pila |

---

## TNodo.java

Nodo de lista enlazada simple con `dato` de tipo `char`, referencia `siguiente`, getters y setters.

## TLista.java

Lista enlazada simple para caracteres con nodo cabecera y puntero a final. Métodos: `insertarFinal()` (agrega al final), `eliminarInicio()` (elimina el primero) y `listaVacia()`.

## TPila.java

Pila que extiende de TLista. `push(char c)` inserta al final de la lista y `pop()` elimina del inicio, logrando comportamiento LIFO por herencia.

## Main.java

Lee una palabra del usuario, apila todos sus caracteres y luego los desapila uno a uno comparándolos con la palabra original de izquierda a derecha. Si todos coinciden, la palabra es un palíndromo.

---

## Conclusión

Se implementó una pila mediante herencia de lista enlazada para caracteres y se aplicó exitosamente en la detección de palabras palíndromas.
