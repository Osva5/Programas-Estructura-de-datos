package Kruskal;
import java.util.*;     //Paqueteria de java util 
    

class Arista implements Comparable<Arista> {        //Crea la clase arista y es comparable  
    private int origen;                     //Por que para kruskal necesita ordenar por peso 
    private int destino;
    private int peso;

    public Arista(int origen, int destino, int peso) {      //Contructor
        this.origen = origen;       //Inicia 
        this.destino = destino;     //Termina 
        this.peso = peso;           //Valor
    }

    public int getOrigen() {    //Devuelve el valor 
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Arista otra) {     //Metodo para comparar peso de aristas 
        return this.peso - otra.peso;
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " | costo: " + peso;          //Metodo para impresion del objeto 
    }
}

class UnionFind {           //Clase para detectar ciclos
    private int[] padre;        //Para representar cada conjunto 
    private int[] rango;     //Para unir arboles de forma eficiente 

    public UnionFind(int n) {
        padre = new int[n];         //Inicia los arreglos
        rango = new int[n];         

        for (int i = 0; i < n; i++) {       
            padre[i] = i;       //Cada nodo apunta a si mismo 
            rango[i] = 0;       //Rango en 0 
        }
    }

    public int find(int x) {        //Este metodo es para encontrar al lider, osea al de 0 
        if (padre[x] != x) {
            padre[x] = find(padre[x]);
        }
        return padre[x];
    }

    public boolean union(int a, int b) {        //Union de conjuntos 
        int raizA = find(a);        //encontrar las raices 
        int raizB = find(b);

        if (raizA == raizB) {       //Si tiene la misma raiz, regresa, osea que ya estan conectados, evita los ciclos 
            return false;
        }

        if (rango[raizA] < rango[raizB]) {      //Comparaciones para encontrar el arbol mas pequeño
            padre[raizA] = raizB;
        } else if (rango[raizA] > rango[raizB]) {
            padre[raizB] = raizA;
        } else {
            padre[raizB] = raizA;
            rango[raizA]++;         //lo incrementa 
        }

        return true;        //Esto pasa cuando no hay detalles, ni ciclos
    }
}

public class GKruskal {         //Clase del metodo 
    private int vertices;
    private List<Arista> aristas;       //Lista de objetos tipo arista 

    public GKruskal(int vertices) {     //Constructor 
        this.vertices = vertices;
        this.aristas = new ArrayList<>();
    }

    public void agregarArista(int origen, int destino, int peso) {      //Metodo para agregar las aristas 
        aristas.add(new Arista(origen, destino, peso));
    }

    public void ejecutarKruskal() {         //Ejecutar el algoritmo 
        Collections.sort(aristas);          //Ordena la lista con menor a mayor peso 
        UnionFind uf = new UnionFind(vertices);     //Crea la estructura 

        List<Arista> mst = new ArrayList<>();       //Para guardar la lista que forme el MST
        int costoTotal = 0;     //Acumuladro de suma 

        for (Arista a : aristas) {      //Para cada arista a, dentro de aristas
            if (uf.union(a.getOrigen(), a.getDestino())) {      //Toma la arista y lo intenta unir, si regresa true, lo agrega al MST 
                mst.add(a);
                costoTotal += a.getPeso();      //Suma los pesos 
            }

            if (mst.size() == vertices - 1) {
                break;          //Verifica v-1 para saber si ya termino 
            }
        }

        System.out.println("\n===== Árbol de Expansión Mínima (MST) =====");
        for (Arista a : mst) {
            System.out.println(a);
        }

        System.out.println("Costo total del MST: " + costoTotal);
    }
}

