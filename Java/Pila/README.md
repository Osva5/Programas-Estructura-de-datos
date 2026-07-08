# Reporte - Pila Dinámica (Composición)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de una pila dinámica (LIFO) utilizando composición con una lista enlazada simple de enteros. La pila se aplica en un programa que verifica si un número entero es capicúa, descomponiendo el número en dígitos y usando la pila para la comparación.

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
| `TNodo.java` | Nodo de lista enlazada simple con dato entero y referencia al siguiente |
| `TLista.java` | Lista enlazada simple con operaciones de inserción, eliminación y búsqueda |
| `TPila.java` | Pila implementada por composición con TLista (push inserta al inicio, pop elimina del inicio) |
| `Main.java` | Programa que verifica si un número es capicúa usando la pila dinámica |

---

## TNodo.java

Nodo con atributo `dato` (int) y referencia `sig`. Incluye `toString()`.

## TLista.java

Lista enlazada simple con nodo cabecera y puntero a final. Operaciones: insertar al inicio, al final, en orden, mostrar, eliminar inicio, eliminar por valor, buscar, liberar lista y verificar vacío.

## TPila.java

Pila implementada por composición (contiene una instancia de TLista). `insertaDato(int)` inserta al inicio (LIFO), `eliminaDato()` elimina del inicio. Incluye `pilaVacia()` y `liberaPila()`.

## Main.java

Verifica si un número entero ingresado por el usuario es capicúa: descompone el número en dígitos, apila la primera mitad y desapila comparando con la segunda mitad.

---

## Conclusión

Se implementó una pila dinámica mediante composición con lista enlazada y se aplicó para verificar números capicúa, demostrando el comportamiento LIFO con manejo dinámico de memoria.
