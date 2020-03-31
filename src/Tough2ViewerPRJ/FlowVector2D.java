/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * FlowVector2D.java
 *
 * Created on 17-dic-2009, 18.08.51
 */
package Tough2ViewerPRJ;

import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.data.xy.VectorSeries;
import org.jfree.data.xy.VectorSeriesCollection;
import org.jfree.data.xy.VectorXYDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author stebond
 */
public class FlowVector2D extends javax.swing.JFrame {

    public boolean init_completed = false;
    String Fluxname[] = Tough2Viewer.dataobj.getFLOWName();//{"FHEAT", "FLOH/FLOF", "FLOF","FLO(GAS)","FLO(AQ.)","FLO(WTR2)","VEL(GAS)","VEL(AQ.)","TURB.-COEFF."};
    int actual_time = 0;
    int actual_variable = 0;
    String first;
    String second;
    String mygridtype;
    String[] UM_flow;

    /**
     * Creates new form FlowVector2D
     */
    public FlowVector2D() {
        Tough2Viewer.dataobj.set_actualVariableToPlot(0);
        Tough2Viewer.dataobj.set_actualTimeToPlot(0);

        initComponents();
//
        UM_flow = Tough2Viewer.dataobj.getFluxUM();
        jPanel1.setLayout(new java.awt.BorderLayout());
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Fluxname));
        jSlider1.setPaintTicks(true);
        jSlider1.setMinimum(0);
        jSlider1.setMaximum(Tough2Viewer.dataobj.get_TimeSteps() - 1);
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setValue(0);
        Font font1 = new Font("Serif", Font.ITALIC, 8);
        jSlider1.setFont(font1);
        jSlider1.setSnapToTicks(true);
        Hashtable labelTable1 = new Hashtable();
        for (int i = 0; i < Tough2Viewer.dataobj.get_TimeSteps() - 1; i++) {
            String myTickLabel = String.valueOf(i);
            labelTable1.put(i, new JLabel(myTickLabel));
        }
        jSlider1.setLabelTable(labelTable1);
        jSlider1.setPaintLabels(true);

        mygridtype = Tough2Viewer.dataobj.getGridType();
        if (mygridtype.length() > 2) {
            String error = "Grid Type is " + mygridtype;
            JOptionPane.showMessageDialog(null, error);
            this.setVisible(false);
            this.dispose();

        }
        first = mygridtype.substring(0, 1);
        second = mygridtype.substring(1, 2);

        Tough2Viewer.dataobj.CreateVectorData3D();
        init_completed = true;
        plotVectorGraph();
        try {
            Thread.sleep(250);
        } catch (Exception ignore) {

        }
        plotVectorGraph();
        jCheckBox1.setSelected(true);

    }

    private void plotVectorGraph() {
        if (init_completed) {
            JFreeChart chart1;
            chart1 = createChart(createDataset());
            ChartPanel panelchart1 = new ChartPanel(chart1);
            panelchart1 = new ChartPanel(chart1);
            panelchart1.setSize(jPanel1.getSize());
            panelchart1.setVisible(true);
            jPanel1.removeAll();
            jPanel1.repaint();
            //jPanel1.add(panelchart1,BorderLayout.CENTER);
            jPanel1.add(panelchart1);

            jPanel1.setVisible(true);
            jPanel1.repaint();
            this.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jSlider1 = new javax.swing.JSlider();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("2D Flow Vector");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jTextField1.setText("200");

        jCheckBox1.setText("Normalize Vectors");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        jLabel1.setText("Vector lenght");

        jLabel2.setText("Varible");

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClose)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClose)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int a = jComboBox1.getSelectedIndex();
        Tough2Viewer.dataobj.set_actualVariableToPlot(a);
        plotVectorGraph();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        int a = jSlider1.getValue();
        Tough2Viewer.dataobj.set_actualTimeToPlot(a);
        String Tooltip = Float.toString(Tough2Viewer.dataobj.get_Times(a)) + " S";
        jSlider1.setToolTipText(Tooltip);
        plotVectorGraph();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:
        plotVectorGraph();
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed
    private VectorXYDataset createDataset() {
        VectorSeries s1 = new VectorSeries(Fluxname[actual_variable]);

        int scala1 = Integer.parseInt((String) jTextField1.getText());
        double scala = (double) scala1;
        actual_variable = Tough2Viewer.dataobj.get_actualVariableToPlot();
        actual_time = Tough2Viewer.dataobj.get_actualTimeToPlot();

        for (int i_b = 0; i_b < Tough2Viewer.dataobj.get_nxyz(); i_b++) {
            double compx = 0;
            double compy = 0;
            double compz = 0;
            if (jCheckBox1.isSelected()) {
                compx = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3));
                compy = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3 + 1));
                compz = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3 + 2));
                double module = Math.sqrt(compx * compx + compy * compy + compz * compz);
                if (module > 0.0f) {
                    compx = compx / module;
                    compy = compy / module;
                    compz = compz / module;
                } else {
                    compx = 0.0f;
                    compy = 0.0f;
                    compz = 0.0f;
                }

            } else {

                compx = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3) / Tough2Viewer.dataobj.get_VectorModuleStatistics(actual_variable));
                compy = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3 + 1) / Tough2Viewer.dataobj.get_VectorModuleStatistics(actual_variable));
                compz = (double) (Tough2Viewer.dataobj.get_VectorDataArray(i_b, actual_time, actual_variable * 3 + 2) / Tough2Viewer.dataobj.get_VectorModuleStatistics(actual_variable));
            }

            compx = compx * scala;
            compy = compy * scala;
            compz = compz * scala;

            if (mygridtype.contentEquals("yz")) {
                s1.add((double) Tough2Viewer.dataobj.get_Yo(i_b),
                        (double) Tough2Viewer.dataobj.get_Zo(i_b),
                        compy,
                        compz);
            } else if (mygridtype.contentEquals("xz")) {
                s1.add((double) Tough2Viewer.dataobj.get_Xo(i_b),
                        (double) Tough2Viewer.dataobj.get_Zo(i_b),
                        compx,
                        compz);
            } else {
                s1.add((double) Tough2Viewer.dataobj.get_Xo(i_b),
                        (double) Tough2Viewer.dataobj.get_Yo(i_b),
                        compx,
                        compy);
            }

        }

        VectorSeriesCollection dataset = new VectorSeriesCollection();
        dataset.addSeries(s1);
        return dataset;
    }

    private JFreeChart createChart(VectorXYDataset dataset) {
        NumberAxis xAxis = new NumberAxis(first);
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        xAxis.setLowerMargin(0.01);
        xAxis.setUpperMargin(0.01);
        xAxis.setAutoRangeIncludesZero(false);

        NumberAxis yAxis = new NumberAxis(second);
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setLowerMargin(0.01);
        yAxis.setUpperMargin(0.01);
        yAxis.setAutoRangeIncludesZero(false);
        VectorRenderer renderer = new VectorRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5, 5, 5, 5));
        plot.setOutlinePaint(Color.black);

        JFreeChart chart = new JFreeChart("Flow for : " + Fluxname[actual_variable] + "(" + UM_flow[actual_variable] + ")", plot);
        chart.setBackgroundPaint(Color.white);
        chart.removeLegend();

        return chart;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}