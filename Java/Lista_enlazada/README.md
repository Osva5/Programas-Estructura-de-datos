# Reporte - Lista Enlazada Simple

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación de una lista enlazada simple en Java con nodo cabecera y puntero a final. Proporciona operaciones básicas como inserción al inicio, al final, en orden, eliminación, búsqueda y visualización, controladas mediante un menú interactivo.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java TLista.java TNodo.java`
- **Ejecución:** `java Main`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TNodo.java` | Nodo de lista enlazada simple con dato entero y referencia al siguiente nodo |
| `TLista.java` | Lista enlazada simple con operaciones de inserción, eliminación y búsqueda |
| `Main.java` | Menú interactivo para probar las operaciones de la lista |

---

## TNodo.java

Nodo con atributo `dato` (int) y referencia `sig`. Incluye método `toString()`.

## TLista.java

Lista enlazada simple con nodo cabecera (`cab`) y puntero a final (`fin`). Operaciones:
- Insertar al inicio, al final y en orden ascendente.
- Mostrar la lista completa.
- Eliminar el primer elemento o un valor específico.
- Buscar un valor y encontrar el predecesor de un nodo.
- Liberar (vaciar) la lista y verificar si está vacía.

## Main.java

Menú interactivo que permite al usuario elegir entre insertar al inicio, insertar al final, mostrar lista, eliminar un dato específico, eliminar el primer elemento, eliminar toda la lista o salir.

---

## Conclusión

Se implementó una lista enlazada simple funcional con las operaciones fundamentales de inserción, eliminación y búsqueda, demostrando el manejo dinámico de memoria y la manipulación de punteros en Java.
