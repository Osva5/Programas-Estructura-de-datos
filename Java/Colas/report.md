# Reporte - Colas (FIFO)

---

**ASIGNATURA:**  
Estructura de datos

**DOCENTE:**  
Miguel Ángel Lomelí Vargas

**ALUMNO:**  
MONTEALEGRE NAHUACATL OSVALDO

---

## Introducción

Implementación del TAD Cola (FIFO - First In, First Out) utilizando una lista enlazada como estructura subyacente. Se incluyen tres programas de demostración: simulación de turnos, simulación de ventanilla de boletos y un menú interactivo para gestionar la cola.

---

## Entorno y requisitos

- **JDK:** Java 8 o superior
- **Compilación:** `javac Main.java Main2.java Main3.java TCola.java TLista.java TNodo.java`
- **Ejecución:** `java Main`, `java Main2` o `java Main3`
- **Editor:** VS Code, NetBeans, IntelliJ IDEA o cualquier editor de texto

---

## Archivos de la práctica

| Archivo | Descripción |
|---|---|
| `TNodo.java` | Nodo de lista enlazada simple con dato entero y referencia al siguiente nodo |
| `TLista.java` | Lista enlazada simple con inserción al inicio, final, ordenado, eliminación y búsqueda |
| `TCola.java` | TAD Cola que utiliza TLista internamente con comportamiento FIFO |
| `Main.java` | Simulación de turnos (consultorio) usando una cola |
| `Main2.java` | Simulación de ventanilla de boletos con cola de clientes |
| `Main3.java` | Menú interactivo para operaciones básicas de cola |

---

## TNodo.java

Nodo de lista enlazada simple con atributo `dato` (int) y referencia `sig` al siguiente nodo. Incluye método `toString()`.

## TLista.java

Lista enlazada simple con nodo cabecera (`cab`) y puntero a final (`fin`). Métodos: inserta al inicio, al final, en orden, muestra lista, elimina del inicio, elimina por valor, busca por valor, encuentra predecesor, libera lista y verifica si está vacía.

## TCola.java

Implementa una cola usando TLista como composición. `insertaDato` agrega al final y `eliminaDato` remueve del inicio, garantizando comportamiento FIFO. Incluye `colaVacia()`, `liberaCola()`, `mostrar()` y `preguntaTurno()`.

## Main.java

Simula un sistema de turnos de consultorio donde los usuarios ingresan su número de turno y son atendidos en orden FIFO.

## Main2.java

Simula una ventanilla de venta de boletos. Permite agregar clientes a la cola, vender boletos (desencolar) y consultar si hay clientes esperando, con un límite de boletos disponibles.

## Main3.java

Menú interactivo con opciones para insertar en cola, eliminar de cola, mostrar cola y salir.

---

## Conclusión

Se implementó el TAD Cola con lista enlazada, demostrando su comportamiento FIFO a través de simulaciones prácticas de sistemas de turnos y atención al cliente.
