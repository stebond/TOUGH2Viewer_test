/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * ScaleFrame.java
 *
 * Created on 20-gen-2010, 9.13.13
 */
package Tough2ViewerPRJ;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author stebond
 */
public class ScaleFrame extends javax.swing.JFrame {

    /**
     * Creates new form ScaleFrame
     */
    public ScaleFrame() {
        initComponents();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Tough2Viewer.dataobj.getVariableName()));

        if (Tough2Viewer.dataobj.FluxFound) {
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(Tough2Viewer.dataobj.getFLOWName()));

            Tough2Viewer.dataobj.CreateVectorData3D();
        }
        this.setTitle("Color Scale Preview");
    }

    private BufferedImage canvasToImage(Canvas cnvs) {
        int w = cnvs.getWidth();
        int h = cnvs.getHeight();
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(w, h, type);
        Graphics2D g2 = image.createGraphics();
        cnvs.paint(g2);
        g2.dispose();;
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new ScaleCanvas(0);
        jComboBox1 = new javax.swing.JComboBox();
        jButtonGetSnap = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        canvas2 = new ScaleCanvas(1);
        jComboBox2 = new javax.swing.JComboBox();
        jButtonClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButtonGetSnap.setText("Snapshot");
        jButtonGetSnap.setMaximumSize(new java.awt.Dimension(33, 23));
        jButtonGetSnap.setMinimumSize(new java.awt.Dimension(33, 23));
        jButtonGetSnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetSnapActionPerformed(evt);
            }
        });

        jButton2.setText("Preview");
        jButton2.setMaximumSize(new java.awt.Dimension(33, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(33, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(33, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel1.setText("Flow variable:");

        jLabel2.setText("Variable:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGetSnap, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonClose)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {canvas1, canvas2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonGetSnap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(canvas2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {canvas1, canvas2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int a = jComboBox1.getSelectedIndex();
        Tough2Viewer.dataobj.set_actualVariableToPlot(a);
        canvas1.repaint();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        int a = jComboBox2.getSelectedIndex();
        Tough2Viewer.dataobj.set_actualFluxToPlot(a);
        if (Tough2Viewer.dataobj.FluxFound) {
            canvas2.repaint();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButtonGetSnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetSnapActionPerformed
        getsnapShot();
    }//GEN-LAST:event_jButtonGetSnapActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PrintPreview();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public void getsnapShot() {
        for (int i = 0; i < jComboBox1.getItemCount(); i++) {
            jComboBox1.setSelectedIndex(i);
            BufferedImage img2save = canvasToImage(canvas1);
            String filename = "colormap_" + Tough2Viewer.dataobj.get_DataFileName() + "_" + (String) jComboBox1.getSelectedItem() + ".png";
            String FilePathString = Tough2Viewer.dataobj.get_WorkingPath();
            String SuggestedFileName = FilePathString + "\\" + filename;
            try {
                File file = new File(SuggestedFileName);
                ImageIO.write(img2save, "png", file);
            } catch (IOException e) {
                String error = "File I/O error";
                JOptionPane.showMessageDialog(null, error);
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }

    }

    public void PrintPreview() {
        BufferedImage img2save = canvasToImage(canvas1);
        new ImageDisplayer(img2save, false, 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonGetSnap;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
