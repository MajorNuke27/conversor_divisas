package conversor_divisas.view;

import conversor_divisas.model.Divisa;
import conversor_divisas.services.ConversionService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Esau Montiel
 */
public class Principal extends javax.swing.JFrame {

    private ArrayList<Divisa> divisas;
    private ConversionService conversor;
    
    /**
     * Creates new form Principal
     */
    private Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Principal(ArrayList<Divisa> divisas, LocalDate fecha) {
        this();
        this.divisas = divisas;
        this.conversor = new ConversionService();
        this.jlbFecha.setText("Taza de cambio del dia: " + fecha.format(DateTimeFormatter.ofPattern("dd MMMM uuuu")));
        
        this.setComboBoxDivisas(divisas);
        this.jcbObjetivo.setSelectedIndex(1);
    }
    
    private void setComboBoxDivisas(ArrayList<Divisa> divisas) {
        divisas.forEach( divisa -> {
            this.jcbBase.addItem(divisa.toString());
            this.jcbObjetivo.addItem(divisa.toString());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbBase = new javax.swing.JComboBox<>();
        jcbObjetivo = new javax.swing.JComboBox<>();
        jlbDivisa1 = new javax.swing.JLabel();
        jlbDivisa2 = new javax.swing.JLabel();
        jlbNombreCantidad = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlbNombreBase = new javax.swing.JLabel();
        jlbNombreObjetivo = new javax.swing.JLabel();
        jlbCantidadBase = new javax.swing.JLabel();
        jlbCantidadObjetivo = new javax.swing.JLabel();
        jbtConvertir = new javax.swing.JButton();
        jbtLimpiar = new javax.swing.JButton();
        jlbNombreObjetivo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        jcbBase.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jcbBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBaseActionPerformed(evt);
            }
        });

        jcbObjetivo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jcbObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbObjetivoActionPerformed(evt);
            }
        });

        jlbDivisa1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbDivisa1.setText("Convertir de:");

        jlbDivisa2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbDivisa2.setText("a:");

        jlbNombreCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbNombreCantidad.setText("Ingrese la cantidad de Pesos mexicanos (MXN):");

        jlbFecha.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbFecha.setText("Tasa de cambio del dia: 8 de Diciembre de 2022");

        jtfCantidad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jtfCantidad.setToolTipText("");
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jlbNombreBase.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbNombreBase.setText("Pesos mexicanos (MXN)");

        jlbNombreObjetivo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbNombreObjetivo.setText("Pesos Argentinos (ARS):");

        jlbCantidadBase.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbCantidadBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCantidadBase.setText("000.00");
        jlbCantidadBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbCantidadObjetivo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbCantidadObjetivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCantidadObjetivo.setText("000.00");
        jlbCantidadObjetivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtConvertir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jbtConvertir.setText("Convertir");
        jbtConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConvertirActionPerformed(evt);
            }
        });

        jbtLimpiar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jbtLimpiar.setText("Limpiar");
        jbtLimpiar.setEnabled(false);
        jbtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimpiarActionPerformed(evt);
            }
        });

        jlbNombreObjetivo1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 16)); // NOI18N
        jlbNombreObjetivo1.setText("Equivalen a --->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jlbCantidadBase, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jlbNombreBase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jlbNombreObjetivo1)
                .addGap(68, 68, 68)
                .addComponent(jlbNombreObjetivo)
                .addGap(18, 18, 18)
                .addComponent(jlbCantidadObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jlbDivisa1)
                .addGap(18, 18, 18)
                .addComponent(jcbBase, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbDivisa2)
                .addGap(18, 18, 18)
                .addComponent(jcbObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jlbFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtConvertir)
                        .addGap(103, 103, 103)
                        .addComponent(jbtLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlbNombreCantidad)
                        .addGap(18, 18, 18)
                        .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(232, 232, 232))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jlbFecha)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDivisa1)
                    .addComponent(jcbBase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDivisa2)
                    .addComponent(jcbObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNombreCantidad)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtConvertir)
                    .addComponent(jbtLimpiar))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNombreBase)
                    .addComponent(jlbNombreObjetivo)
                    .addComponent(jlbCantidadObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbCantidadBase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNombreObjetivo1))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbObjetivoActionPerformed
        this.jlbNombreObjetivo.setText(this.divisas.get(this.jcbObjetivo.getSelectedIndex()).toString());
        this.jbtLimpiar.doClick();
    }//GEN-LAST:event_jcbObjetivoActionPerformed

    private void jcbBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBaseActionPerformed
        this.jlbNombreBase.setText(this.divisas.get(this.jcbBase.getSelectedIndex()).toString());
        this.jlbNombreCantidad.setText("Ingrese la cantidad de " + this.divisas.get(this.jcbBase.getSelectedIndex()).toString());
    }//GEN-LAST:event_jcbBaseActionPerformed

    private void jbtConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConvertirActionPerformed
        float cantidad = Float.parseFloat(this.jtfCantidad.getText());
        
        if(cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad ingresada debe ser mayor o igual a 1", "Cantidad invalida", JOptionPane.ERROR_MESSAGE);
            this.jtfCantidad.setText("");
            return;
        }
        
        float conversion  = this.conversor.convertir(this.divisas.get(this.jcbBase.getSelectedIndex()),
                                                        this.divisas.get(this.jcbObjetivo.getSelectedIndex()),
                                                        Float.parseFloat(this.jtfCantidad.getText()));
        
        this.jlbCantidadBase.setText(this.jtfCantidad.getText() + " $");
        this.jlbCantidadObjetivo.setText(String.valueOf(conversion) + " $");
        
    }//GEN-LAST:event_jbtConvertirActionPerformed

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        int key = evt.getKeyChar();
        String cantidad = this.jtfCantidad.getText();

        //Solo permite la entrda de numeros, punto y backspace
        if(!((key >= 48 && key <=57) || key == 46 || key == 8)) evt.consume();
        
        //Solo permite poner un punto
        if(this.jtfCantidad.getText().contains(".") && key == 46) evt.consume();
        
        //Limita la cantidad de decimales a 2
        if(cantidad.contains(".") && cantidad.substring(cantidad.indexOf('.'), cantidad.length()-1).length() == 2) evt.consume();
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jbtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimpiarActionPerformed
        this.jtfCantidad.setText("");
        this.jlbCantidadBase.setText("000.00 $");
        this.jlbCantidadObjetivo.setText("000.00 $");
        this.jbtLimpiar.setEnabled(false);
    }//GEN-LAST:event_jbtLimpiarActionPerformed

    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        String cantidad = this.jtfCantidad.getText();
        
        if(cantidad.length() > 0) this.jbtLimpiar.setEnabled(true);
        else this.jbtLimpiar.setEnabled(false);
    }//GEN-LAST:event_jtfCantidadKeyReleased
    
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtConvertir;
    private javax.swing.JButton jbtLimpiar;
    private javax.swing.JComboBox<String> jcbBase;
    private javax.swing.JComboBox<String> jcbObjetivo;
    private javax.swing.JLabel jlbCantidadBase;
    private javax.swing.JLabel jlbCantidadObjetivo;
    private javax.swing.JLabel jlbDivisa1;
    private javax.swing.JLabel jlbDivisa2;
    private javax.swing.JLabel jlbFecha;
    private javax.swing.JLabel jlbNombreBase;
    private javax.swing.JLabel jlbNombreCantidad;
    private javax.swing.JLabel jlbNombreObjetivo;
    private javax.swing.JLabel jlbNombreObjetivo1;
    private javax.swing.JTextField jtfCantidad;
    // End of variables declaration//GEN-END:variables
}
