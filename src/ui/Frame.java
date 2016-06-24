package ui;

import core.DependenciaDAO;
import core.TemaDAO;

import entidades.Dependencia;
import entidades.Tema;

import input_output.Exportar;

import java.awt.Toolkit;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {
    
    private static final String FILE = "Grafo";
    private static final String EXTENSION = ".pdf";

    public Frame() {
        initComponents();
        initFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_top = new javax.swing.JPanel();
        boton_temas = new javax.swing.JButton();
        boton_dependencias = new javax.swing.JButton();
        boton_exportar = new javax.swing.JButton();
        panel_temas = new javax.swing.JPanel();
        boton_agregar_tema = new javax.swing.JButton();
        scroll_temas = new javax.swing.JScrollPane();
        tabla_temas = new javax.swing.JTable();
        panel_dependencias = new javax.swing.JPanel();
        boton_agregar_dependencia = new javax.swing.JButton();
        scroll_dependencias = new javax.swing.JScrollPane();
        tabla_dependencias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Contenidos del Curso");
        setBackground(new java.awt.Color(255, 255, 255));

        panel_top.setBackground(new java.awt.Color(248, 248, 255));

        boton_temas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_temas.setForeground(new java.awt.Color(255, 255, 255));
        boton_temas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png"))); // NOI18N
        boton_temas.setText("Temas");
        boton_temas.setFocusPainted(false);
        boton_temas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_temas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_temasActionPerformed(evt);
            }
        });

        boton_dependencias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_dependencias.setForeground(new java.awt.Color(255, 255, 255));
        boton_dependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png"))); // NOI18N
        boton_dependencias.setText("Dependencias");
        boton_dependencias.setFocusPainted(false);
        boton_dependencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_dependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_dependenciasActionPerformed(evt);
            }
        });

        boton_exportar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_exportar.setForeground(new java.awt.Color(255, 255, 255));
        boton_exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png"))); // NOI18N
        boton_exportar.setText("Exportar Grafo");
        boton_exportar.setFocusPainted(false);
        boton_exportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_exportar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-activo.png"))); // NOI18N
        boton_exportar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-activo.png"))); // NOI18N
        boton_exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_topLayout = new javax.swing.GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(boton_temas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(boton_dependencias, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(boton_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        panel_topLayout.setVerticalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(boton_dependencias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(boton_temas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_temas.setBackground(new java.awt.Color(248, 248, 255));

        boton_agregar_tema.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_agregar_tema.setForeground(new java.awt.Color(255, 255, 255));
        boton_agregar_tema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-normal.png"))); // NOI18N
        boton_agregar_tema.setText("<html>Agregar<br>&nbsp;&nbsp;Tema</html>");
        boton_agregar_tema.setFocusPainted(false);
        boton_agregar_tema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_agregar_tema.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-activo.png"))); // NOI18N
        boton_agregar_tema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregar_temaActionPerformed(evt);
            }
        });

        tabla_temas.setBackground(new java.awt.Color(248, 248, 255));
        tabla_temas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_temas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sigla", "Nombre", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_temas.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tabla_temas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_temasMouseClicked(evt);
            }
        });
        scroll_temas.setViewportView(tabla_temas);

        javax.swing.GroupLayout panel_temasLayout = new javax.swing.GroupLayout(panel_temas);
        panel_temas.setLayout(panel_temasLayout);
        panel_temasLayout.setHorizontalGroup(
            panel_temasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_temasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(boton_agregar_tema, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(scroll_temas, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        panel_temasLayout.setVerticalGroup(
            panel_temasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_temasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_temasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_temasLayout.createSequentialGroup()
                        .addComponent(boton_agregar_tema, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(125, Short.MAX_VALUE))
                    .addGroup(panel_temasLayout.createSequentialGroup()
                        .addComponent(scroll_temas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(50, 50, 50))))
        );

        panel_dependencias.setBackground(new java.awt.Color(248, 248, 255));

        boton_agregar_dependencia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boton_agregar_dependencia.setForeground(new java.awt.Color(255, 255, 255));
        boton_agregar_dependencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-normal.png"))); // NOI18N
        boton_agregar_dependencia.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;Agregar<br>Dependencia</html>");
        boton_agregar_dependencia.setFocusPainted(false);
        boton_agregar_dependencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_agregar_dependencia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-activo.png"))); // NOI18N
        boton_agregar_dependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregar_dependenciaActionPerformed(evt);
            }
        });

        tabla_dependencias.setBackground(new java.awt.Color(248, 248, 255));
        tabla_dependencias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_dependencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tema", "Correlativo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_dependencias.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tabla_dependencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_dependenciasMouseClicked(evt);
            }
        });
        scroll_dependencias.setViewportView(tabla_dependencias);

        javax.swing.GroupLayout panel_dependenciasLayout = new javax.swing.GroupLayout(panel_dependencias);
        panel_dependencias.setLayout(panel_dependenciasLayout);
        panel_dependenciasLayout.setHorizontalGroup(
            panel_dependenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dependenciasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(boton_agregar_dependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(scroll_dependencias, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        panel_dependenciasLayout.setVerticalGroup(
            panel_dependenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dependenciasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_dependenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_dependenciasLayout.createSequentialGroup()
                        .addComponent(boton_agregar_dependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_dependenciasLayout.createSequentialGroup()
                        .addComponent(scroll_dependencias, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_temas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_dependencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel_temas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_dependencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initFrame() {
        //Icono
        URL icono = getClass().getResource("/imagenes/icono.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(icono));
        //Centrar frame
        setLocationRelativeTo(null);
        //Panel inicial
        visible(0);
        //Header de tablas
        tabla_temas.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_dependencias.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        //Contenido de tablas
        actualizarTemas();
    }
    
    //Cambio entre paneles
    private void visible(int p) {
        switch (p) {
            case 1: {
                panel_temas.setVisible(true);
                panel_dependencias.setVisible(false);
                boton_temas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-activo.png")));
                boton_dependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png")));
                break;
            }
            case 2: {
                panel_temas.setVisible(false);
                panel_dependencias.setVisible(true);
                boton_temas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png")));
                boton_dependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-activo.png")));
                break;             
            }
            default: {
                panel_temas.setVisible(true);
                panel_dependencias.setVisible(false);
                boton_temas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png")));
                boton_dependencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-normal.png")));
                break;
            }
        }
    }
    
    private DefaultTableModel limpiarTabla(JTable tabla) {
        DefaultTableModel m = (DefaultTableModel)tabla.getModel();
        int s = m.getRowCount();
        for(int i=0; i<s;i++){
            m.removeRow(0);
        }
        return m;
    }
    
    private void actualizarTabla(JTable tabla, DefaultTableModel model) {
        tabla.setRowSorter(null);
        tabla.setModel(model);
    }
    
    private void actualizarTemas() {
        //Limpiar tabla
        DefaultTableModel m = limpiarTabla(tabla_temas);
        //Contenido tabla
        TemaDAO handler = new TemaDAO();
        List<Tema> temas = handler.read();
        Iterator<Tema> i = temas.iterator();
        while (i.hasNext()) {
            Tema t = i.next();
            Object[] fila = { t.getId(), t.getSigla(), t.getNombre(), t.getDescripcion() };
            m.addRow(fila);
        }
        //Actualizar
        actualizarTabla(tabla_temas, m);
        actualizarDependencias();
    }
    
    private void actualizarDependencias() {
        //Limpiar tabla
        DefaultTableModel m = limpiarTabla(tabla_dependencias);
        //Contenido tabla
        TemaDAO handlerTema = new TemaDAO();
        DependenciaDAO handler = new DependenciaDAO();
        List<Dependencia> dependencias = handler.read();
        Iterator<Dependencia> i = dependencias.iterator();
        while (i.hasNext()) {
            Dependencia d = i.next();
            Tema t1 = handlerTema.read(d.getTema().getId());
            Tema t2 = handlerTema.read(d.getCorrelativo().getId());
            Object[] fila = { d.getId(), t1.toString(), t2.toString() };
            m.addRow(fila);
        }
        //Actualizar
        actualizarTabla(tabla_dependencias, m);
    }
    
    //BOTÓN TEMAS
    private void boton_temasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_temasActionPerformed
        visible(1);
    }//GEN-LAST:event_boton_temasActionPerformed

    //BOTÓN DEPENDENCIAS
    private void boton_dependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_dependenciasActionPerformed
        visible(2);
    }//GEN-LAST:event_boton_dependenciasActionPerformed

    //BOTÓN EXPORTAR GRAFO
    private void boton_exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_exportarActionPerformed
        
    	JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File(".")); //Posición inicial
        chooser.setDialogTitle("Seleccionar path destino");
        chooser.setAcceptAllFileFilterUsed(false); //No permite selección múltiple
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            //Ruta:
            String path = chooser.getSelectedFile().toString()+"\\";
            //Archivo:
            String filename = FILE+EXTENSION;
            
            //Si ya existe se renombra con (1) (2) (3) etc.
            int i = 1;
            Path fullpath = Paths.get(path+filename);
            boolean existe = Files.exists(fullpath);
            while (existe) {
                filename = FILE +"("+ ++i +")" + EXTENSION;
                fullpath = Paths.get(path+filename);
                existe = Files.exists(fullpath);
            }
           
            //Grafo
            try {
                Exportar exportar = new Exportar(path, filename);
                exportar.exportarPDF();
            } catch(Exception e) {
                Message.showError("Error", "No se puede exportar en PDF. Probablemente deba instalar o reinstalar GraphViz.");
            }
        }
    }//GEN-LAST:event_boton_exportarActionPerformed

    //BOTÓN AGREGAR TEMA
    private void boton_agregar_temaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregar_temaActionPerformed
        FrameTema.showInputTema();
        actualizarTemas();
    }//GEN-LAST:event_boton_agregar_temaActionPerformed

    //BOTÓN AGREGAR DEPENDENCIA
    private void boton_agregar_dependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregar_dependenciaActionPerformed
        FrameDependencia.showInputDependencia();
        actualizarDependencias();
    }//GEN-LAST:event_boton_agregar_dependenciaActionPerformed

    //CLICK SOBRE TABLA TEMAS
    private void tabla_temasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_temasMouseClicked
        // Doble click:
        if (evt.getClickCount() == 2) {
            String idTema = String.valueOf(tabla_temas.getValueAt(tabla_temas.getSelectedRow(), 0));
            try {
                int id = Integer.parseInt(idTema);
                TemaDAO handler = new TemaDAO();
                Tema tema = handler.read(id);
                FrameTema.showInputTema(tema);
                actualizarTemas();
            } catch (Exception e) {}
        }
    }//GEN-LAST:event_tabla_temasMouseClicked

    //CLICK SOBRE TABLA DEPENDENCIAS
    private void tabla_dependenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_dependenciasMouseClicked
        // Doble click:
        if (evt.getClickCount() == 2) {
            String idDependencia = String.valueOf(tabla_dependencias.getValueAt(tabla_dependencias.getSelectedRow(), 0));
            try {
                int id = Integer.parseInt(idDependencia);
                DependenciaDAO handler = new DependenciaDAO();
                Dependencia dependencia = handler.read(id);
                FrameDependencia.showInputDependencia(dependencia);
                actualizarDependencias();
            } catch (Exception e) {}
        }
    }//GEN-LAST:event_tabla_dependenciasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            OUTER:
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (null != info.getName()) {
                    switch (info.getName()) {
                        case "GTK+":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                        case "Windows":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregar_dependencia;
    private javax.swing.JButton boton_agregar_tema;
    private javax.swing.JButton boton_dependencias;
    private javax.swing.JButton boton_exportar;
    private javax.swing.JButton boton_temas;
    private javax.swing.JPanel panel_dependencias;
    private javax.swing.JPanel panel_temas;
    private javax.swing.JPanel panel_top;
    private javax.swing.JScrollPane scroll_dependencias;
    private javax.swing.JScrollPane scroll_temas;
    private javax.swing.JTable tabla_dependencias;
    private javax.swing.JTable tabla_temas;
    // End of variables declaration//GEN-END:variables

}
