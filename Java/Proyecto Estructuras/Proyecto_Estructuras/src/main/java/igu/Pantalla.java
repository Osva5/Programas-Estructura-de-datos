/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import java.awt.Color;
import java.awt.Graphics;
import logica.Vertice;
import logica.Arista;
import logica.TLista;
import logica.TNodo;


/**
 *
 * @author Osvaldo
 */

public class Pantalla extends javax.swing.JFrame {
    private int contadorNodos = 1;
    // Usamos tu TLista genérica
    private TLista<Vertice> listaVertices = new TLista<>();
    boolean grafoEsDirigido = false;

    // Búsqueda manual recorriendo la lista enlazada
    private logica.Vertice buscarVertice(int id) {
        TNodo<Vertice> temp = listaVertices.getCabecera();
        while (temp != null) {
            if (temp.getDato().id == id) {
                return temp.getDato();
            }
            temp = temp.getSiguiente();
        }
        return null;
}


public Pantalla() {
        initComponents();
        canvas1.setBackground(Color.WHITE);
        
        // Ajuste de texto para evitar palabras cortadas
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);

        canvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dibujarNodo(evt.getX(), evt.getY());
            }
        });
}
    
private void refrescarLienzo() {
        Graphics g = canvas1.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvas1.getWidth(), canvas1.getHeight());

        // 1. Dibujar Aristas usando punteros
        TNodo<Vertice> vAux = listaVertices.getCabecera();
        while (vAux != null) {
            Vertice v = vAux.getDato();
            // Recorremos la lista de adyacencia de cada vértice
            TNodo<Arista> aAux = v.adyacentes.getCabecera();
            while (aAux != null) {
                Arista a = aAux.getDato();
                trazarArista(g, v.x, v.y, a.destino.x, a.destino.y, a.peso, a.dirigida);
                aAux = aAux.getSiguiente();
            }
            vAux = vAux.getSiguiente();
        }

        // 2. Dibujar Nodos usando punteros
        vAux = listaVertices.getCabecera();
        while (vAux != null) {
            Vertice v = vAux.getDato();
            g.setColor(new Color(51, 153, 255));
            g.fillOval(v.x - 15, v.y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(v.x - 15, v.y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(v.id), v.x - 5, v.y + 5);
            vAux = vAux.getSiguiente();
        }
}

private boolean hayAristas() {
        TNodo<Vertice> temp = listaVertices.getCabecera();
        while (temp != null) {
            if (temp.getDato().adyacentes.getCabecera() != null) {
                return true;
            }
            temp = temp.getSiguiente();
        }
        return false;
}

private void actualizarEstadoCheckDirigido() {
        boolean tieneAristas = hayAristas();
        CheckDirigido.setEnabled(!tieneAristas);
        if (!tieneAristas && !grafoEsDirigido) {
            CheckDirigido.setSelected(false);
        }
}

private void trazarArista(Graphics g, int x1, int y1, int x2, int y2, int peso, boolean esDirigido) {
    // 1. Dibujar la línea base (común para ambos)
    g.setColor(Color.BLACK);
    g.drawLine(x1, y1, x2, y2);

    // 2. Dibujar el peso en el centro
    g.setColor(Color.RED);
    g.drawString(String.valueOf(peso), (x1 + x2) / 2, (y1 + y2) / 2);

    // 3. Dibujar la flecha SOLO si es dirigido
    if (esDirigido) {
        double angulo = Math.atan2(y2 - y1, x2 - x1);
        int tamanoFlecha = 15;
        
        // Ajuste para que la punta toque el borde del círculo azul (radio 15)
        int xDest = (int) (x2 - 15 * Math.cos(angulo));
        int yDest = (int) (y2 - 15 * Math.sin(angulo));

        g.setColor(Color.BLACK);
        g.fillPolygon(new int[]{
            xDest, 
            (int) (xDest - tamanoFlecha * Math.cos(angulo - Math.PI / 6)),
            (int) (xDest - tamanoFlecha * Math.cos(angulo + Math.PI / 6))
        }, new int[]{
            yDest, 
            (int) (yDest - tamanoFlecha * Math.sin(angulo - Math.PI / 6)),
            (int) (yDest - tamanoFlecha * Math.sin(angulo + Math.PI / 6))
        }, 3);
    }
}

private void conectarConLogica(boolean dirigido) {
        try {
            // 1. Pedimos los datos por ventanitas
            String origenStr = javax.swing.JOptionPane.showInputDialog("ID Nodo Origen:");
            String destinoStr = javax.swing.JOptionPane.showInputDialog("ID Nodo Destino:");
            String pesoStr = javax.swing.JOptionPane.showInputDialog("Peso de la arista:");

            if (origenStr != null && destinoStr != null && pesoStr != null) {
                int idOri = Integer.parseInt(origenStr);
                int idDes = Integer.parseInt(destinoStr);
                int peso = Integer.parseInt(pesoStr);

                Vertice vOrigen = buscarVertice(idOri);
                Vertice vDestino = buscarVertice(idDes);

                if (vOrigen != null && vDestino != null) {
                    // RÚBRICA: aristaPeso(u, v, w)
                    // Agregamos la arista al origen
                    vOrigen.adyacentes.insertaFinal(new logica.Arista(vDestino, peso, grafoEsDirigido));
                    
                    // Si NO es dirigido, la arista debe ser mutua para que Kruskal funcione
                    if (!grafoEsDirigido) {
                        vDestino.adyacentes.insertaFinal(new logica.Arista(vOrigen, peso, grafoEsDirigido));
                    }
                    
                    jTextArea1.setText("Arista agregada: " + idOri + " -> " + idDes + " (Peso: " + peso + ")");
                    repaint(); // Para que se dibuje en el canvas
                    actualizarEstadoCheckDirigido();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Uno de los nodos no existe.");
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Ingrese solo números enteros.");
        }
    }


//Método para dibujar
private void dibujarNodo(int x, int y) {
        Vertice nuevoV = new Vertice(contadorNodos, x, y);
        listaVertices.insertaFinal(nuevoV); // Usamos tu método de lista
        contadorNodos++;
        refrescarLienzo();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Resultados_intrucciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        Botones = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Borrar_vertice = new javax.swing.JButton();
        Calcular_ruta = new javax.swing.JButton();
        Ver_adyacencia = new javax.swing.JButton();
        Grado_nodo = new javax.swing.JButton();
        num_vertice = new javax.swing.JButton();
        Borrar_arista = new javax.swing.JButton();
        R_profundidad = new javax.swing.JButton();
        R_amplitud = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CheckDirigido = new javax.swing.JCheckBox();
        Dibujo_reset = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Toca en cualquier lugar del recuardo para crear el vertice, en \nel costado agrega el peso, seguidamente indica si es dirigido\n o no, te pedira el ID del inicio y el final, una vez que agregues \nel grafo deseado, preciona el boton de calcular ruta y mira el \nresultado en la parte inferior. ");
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout Resultados_intruccionesLayout = new javax.swing.GroupLayout(Resultados_intrucciones);
        Resultados_intrucciones.setLayout(Resultados_intruccionesLayout);
        Resultados_intruccionesLayout.setHorizontalGroup(
            Resultados_intruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Resultados_intruccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Resultados_intruccionesLayout.setVerticalGroup(
            Resultados_intruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Resultados_intruccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Resultados_intruccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Agregar");

        Borrar_vertice.setText("Borrar Vertice");
        Borrar_vertice.addActionListener(this::Borrar_verticeActionPerformed);

        Calcular_ruta.setText("Calcular ruta");
        Calcular_ruta.addActionListener(this::Calcular_rutaActionPerformed);

        Ver_adyacencia.setText("Ver Adyacencia");
        Ver_adyacencia.addActionListener(this::Ver_adyacenciaActionPerformed);

        Grado_nodo.setText("Grado Nodo");
        Grado_nodo.addActionListener(this::Grado_nodoActionPerformed);

        num_vertice.setText("Num. Vertices");
        num_vertice.addActionListener(this::num_verticeActionPerformed);

        Borrar_arista.setText("Borrar Arista");
        Borrar_arista.addActionListener(this::Borrar_aristaActionPerformed);

        R_profundidad.setText("R. Profundidad");
        R_profundidad.addActionListener(this::R_profundidadActionPerformed);

        R_amplitud.setText("R. Amplitud");
        R_amplitud.addActionListener(this::R_amplitudActionPerformed);

        Agregar.setText("Agregar Arista");
        Agregar.addActionListener(this::AgregarActionPerformed);

        jLabel4.setText("Delete");

        jLabel5.setText("Info.");

        jLabel6.setText("Ruta");

        jLabel7.setText("Adyacencia");

        CheckDirigido.setText("Dirigido");
        CheckDirigido.addActionListener(this::CheckDirigidoActionPerformed);

        javax.swing.GroupLayout BotonesLayout = new javax.swing.GroupLayout(Botones);
        Botones.setLayout(BotonesLayout);
        BotonesLayout.setHorizontalGroup(
            BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Borrar_vertice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Borrar_arista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(num_vertice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Grado_nodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BotonesLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(R_amplitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(R_profundidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ver_adyacencia, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonesLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43))))
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CheckDirigido)
                            .addComponent(jLabel2))))
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(44, 44, 44))
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Calcular_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BotonesLayout.setVerticalGroup(
            BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckDirigido)
                .addGap(18, 18, 18)
                .addComponent(Agregar)
                .addGap(18, 18, 18)
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Grado_nodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num_vertice))
                    .addGroup(BotonesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Ver_adyacencia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Borrar_vertice)
                    .addComponent(R_amplitud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Borrar_arista)
                    .addComponent(R_profundidad))
                .addGap(18, 18, 18)
                .addComponent(Calcular_ruta)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Grafos");

        canvas1.setBackground(new java.awt.Color(255, 255, 255));
        canvas1.setPreferredSize(new java.awt.Dimension(400, 300));

        Reset.setText("Reset");
        Reset.addActionListener(this::ResetActionPerformed);

        javax.swing.GroupLayout Dibujo_resetLayout = new javax.swing.GroupLayout(Dibujo_reset);
        Dibujo_reset.setLayout(Dibujo_resetLayout);
        Dibujo_resetLayout.setHorizontalGroup(
            Dibujo_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dibujo_resetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(216, 216, 216)
                .addComponent(Reset)
                .addContainerGap())
            .addGroup(Dibujo_resetLayout.createSequentialGroup()
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Dibujo_resetLayout.setVerticalGroup(
            Dibujo_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Dibujo_resetLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(Dibujo_resetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reset)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Dibujo_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Resultados_intrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dibujo_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Resultados_intrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Borrar_verticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_verticeActionPerformed
        String idStr = javax.swing.JOptionPane.showInputDialog("ID a eliminar:");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);
            listaVertices.eliminarVerticePorId(id); // Tu método de TLista
            
            // Eliminar referencias en adyacencias
            TNodo<Vertice> tempV = listaVertices.getCabecera();
            while (tempV != null) {
                tempV.getDato().adyacentes.eliminarAristaPorDestino(id);
                tempV = tempV.getSiguiente();
            }
            refrescarLienzo();
            actualizarEstadoCheckDirigido();
        }
    }//GEN-LAST:event_Borrar_verticeActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        listaVertices.eliminarTodo(); 
        contadorNodos = 1;
        grafoEsDirigido = false;
        jTextArea1.setText(""); // Limpia las instrucciones/resultados
        refrescarLienzo();
        actualizarEstadoCheckDirigido();
    }//GEN-LAST:event_ResetActionPerformed

    private void Calcular_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Calcular_rutaActionPerformed
// 1. Identifica el nombre de tu cuadro de texto de la DERECHA
    // Supongamos que se llama txtResultados
    jTextArea1.setText(""); 

        try {
            if (grafoEsDirigido) {
                // Mantenemos las pantallitas que te gustan
                String inputOri = javax.swing.JOptionPane.showInputDialog("ID Origen:");
                String inputDes = javax.swing.JOptionPane.showInputDialog("ID Destino:");
                
                if (inputOri != null && inputDes != null) {
                    int idOri = Integer.parseInt(inputOri);
                    int idDes = Integer.parseInt(inputDes);
                    
                    Vertice inicio = buscarVertice(idOri);
                    Vertice fin = buscarVertice(idDes);

                    if (inicio != null && fin != null) {
                        // Ejecutamos el algoritmo
                        logica.Dijkstra.calcular(listaVertices, inicio);
                        
                        // Formateamos la ruta para que salga (1->3->4)
                        String rutaTexto = "";
                        Vertice aux = fin;
                        
                        // Si el nodo destino no tiene padre y no es el inicio, no hay camino
                        if (aux.padre == null && aux != inicio) {
                            rutaTexto = "No existe un camino entre los nodos.";
                        } else {
                            // Reconstruimos el camino de atrás hacia adelante
                            while (aux != null) {
                                rutaTexto = aux.id + (rutaTexto.isEmpty() ? "" : " -> " + rutaTexto);
                                aux = aux.padre;
                            }
                            rutaTexto = "(" + rutaTexto + ") \nCosto total: " + fin.distanciaMinima;
                        }
                        
                        jTextArea1.setText("--- RESULTADO DIJKSTRA ---\n" + rutaTexto);
                    } else {
                        jTextArea1.setText("Error: Verifique que ambos IDs existan.");
                    }
                }
            } else {
                // Lógica de Kruskal
                String resKruskal = logica.Kruskal.ejecutarKruskal(listaVertices);
                jTextArea1.setText(resKruskal);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Ingrese solo números.");
        }
    }//GEN-LAST:event_Calcular_rutaActionPerformed

    private void Grado_nodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grado_nodoActionPerformed
        try {
            String input = javax.swing.JOptionPane.showInputDialog("ID del Nodo para calcular grado:");
            if (input != null) {
                int id = Integer.parseInt(input);
                logica.Vertice v = buscarVertice(id); // Usa tu método de búsqueda

                if (v != null) {
                    // REGLA DE ORO: El grado es el tamaño de la lista de adyacentes del vértice
                    int grado = v.adyacentes.cantidadElementos(); 

                    jTextArea1.setText("--- INFORMACIÓN DEL NODO ---\n" + "ID: " + id + "\n" + "Grado (Aristas): " + grado);
                } else {
                    jTextArea1.setText("Error: El nodo " + id + " no existe.");
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar un número entero.");
        }
    }//GEN-LAST:event_Grado_nodoActionPerformed

    private void R_profundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_profundidadActionPerformed
        String idStr = javax.swing.JOptionPane.showInputDialog("ID de inicio para Profundidad:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Vertice inicio = buscarVertice(id);
                if (inicio != null) {
                    String resultado = logica.Recorridos.Profundidad(inicio, listaVertices);
                    jTextArea1.setText(resultado);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Vértice no encontrado.");
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }//GEN-LAST:event_R_profundidadActionPerformed

    private void Ver_adyacenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ver_adyacenciaActionPerformed
        String id1 = javax.swing.JOptionPane.showInputDialog("ID Nodo 1:");
        String id2 = javax.swing.JOptionPane.showInputDialog("ID Nodo 2:");

        if (id1 != null && id2 != null) {
            Vertice v1 = buscarVertice(Integer.parseInt(id1));
            if (v1 != null && v1.adyacentes.buscarPorDestino(Integer.parseInt(id2))) {
                jTextArea1.setText("Resultado: 1 (Son adyacentes)");
            } else {
                jTextArea1.setText("Resultado: 0 (No son adyacentes)");
            }
        }
    }//GEN-LAST:event_Ver_adyacenciaActionPerformed

    private void R_amplitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_amplitudActionPerformed
        String idStr = javax.swing.JOptionPane.showInputDialog("ID de inicio para Amplitud:");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Vertice inicio = buscarVertice(id);
                if (inicio != null) {
                    String resultado = logica.Recorridos.Amplitud(inicio, listaVertices);
                    jTextArea1.setText(resultado);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Vértice no encontrado.");
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        }
    }//GEN-LAST:event_R_amplitudActionPerformed

    private void Borrar_aristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar_aristaActionPerformed
        try {
            String idO = javax.swing.JOptionPane.showInputDialog("ID Origen de la arista:");
            String idD = javax.swing.JOptionPane.showInputDialog("ID Destino de la arista:");


            if(idO == null || idD == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "El id de origen o destino no es válido.");
                return;
            }

            if (idO != null && idD != null) {
                int o = Integer.parseInt(idO);
                int d = Integer.parseInt(idD);

                logica.Vertice vOrigen = buscarVertice(o);
                logica.Vertice vDestino = buscarVertice(d);

                if (vOrigen != null && vDestino != null) {
                    // 1. Borramos de Origen a Destino
                    vOrigen.adyacentes.eliminarAristaPorDestino(d);

                    // 2. Si es NO DIRIGIDO, borramos también de Destino a Origen
                    if (!grafoEsDirigido) {
                        vDestino.adyacentes.eliminarAristaPorDestino(o);
                    }

                    jTextArea1.setText("Arista (" + o + "," + d + ") eliminada correctamente.");
                    refrescarLienzo();
                    actualizarEstadoCheckDirigido();
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar arista.");
        }
    }//GEN-LAST:event_Borrar_aristaActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        try {
            int origen = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID del Vértice Origen:"));
            int destino = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("ID del Vértice Destino:"));
            int peso = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Peso de la arista:"));

            Vertice v1 = buscarVertice(origen);
            Vertice v2 = buscarVertice(destino);

            if (v1 != null && v2 != null) {
                // Agregamos la arista de v1 a v2
                v1.adyacentes.insertaFinal(new Arista(v2, peso, grafoEsDirigido));

                // Si NO es dirigido, agregamos también la vuelta de v2 a v1
                if (!grafoEsDirigido) {
                    v2.adyacentes.insertaFinal(new Arista(v1, peso, false));
                }
                refrescarLienzo();
                actualizarEstadoCheckDirigido();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Uno o ambos vértices no existen.");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: Ingrese solo números.");
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void num_verticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_verticeActionPerformed
        int cantidad = listaVertices.cantidadElementos(); //Método de cantidad
        jTextArea1.setText("Número total de vértices: " + cantidad);
    }//GEN-LAST:event_num_verticeActionPerformed

    private void CheckDirigidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDirigidoActionPerformed
        if (CheckDirigido.isSelected()) {
            if (hayAristas()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No puede activar dirigido después de agregar la primera arista.");
                CheckDirigido.setSelected(false);
                return;
            }
            grafoEsDirigido = true;
            CheckDirigido.setEnabled(false);
            jTextArea1.setText("Grafo dirigido activado. No se puede desmarcar.");
        } else {
            if (hayAristas()) {
                // Si ya hay aristas, no se puede desmarcar la casilla.
                if (grafoEsDirigido) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No puede cambiar a no dirigido después de haber agregado una arista.");
                    CheckDirigido.setSelected(true);
                    return;
                }
            } else {
                // No hay aristas: permitimos volver a no dirigido.
                grafoEsDirigido = false;
                jTextArea1.setText("Grafo no dirigido activado. Puede seguir agregando aristas.");
            }
        }
        
    }//GEN-LAST:event_CheckDirigidoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Borrar_arista;
    private javax.swing.JButton Borrar_vertice;
    private javax.swing.JPanel Botones;
    private javax.swing.JButton Calcular_ruta;
    private javax.swing.JCheckBox CheckDirigido;
    private javax.swing.JPanel Dibujo_reset;
    private javax.swing.JButton Grado_nodo;
    private javax.swing.JButton R_amplitud;
    private javax.swing.JButton R_profundidad;
    private javax.swing.JButton Reset;
    private javax.swing.JPanel Resultados_intrucciones;
    private javax.swing.JButton Ver_adyacencia;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton num_vertice;
    // End of variables declaration//GEN-END:variables
}
