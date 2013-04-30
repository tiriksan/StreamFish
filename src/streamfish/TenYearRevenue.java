package streamfish;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author HJ
 */
public class TenYearRevenue extends javax.swing.JPanel {

    private GUI gui;
    private int[] years;
    private String[] revenues;
    private TodaysDate date;
    
    public TenYearRevenue(GUI gui) {
        this.gui = gui;
        gui.setTitle("Revenue pr. year");
        date = new TodaysDate();
        years = new int[10];
        revenues = new String[10];
        
        initComponents();
        update(Integer.parseInt("" + jSpinner1.getValue()));
        
        jSpinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                update(Integer.parseInt("" + jSpinner1.getValue()));
            }
        });
    }
    
    public void update(int y) {
        years[9] = date.getCurrentYear();
        
        for (int i = 0; i < years.length; i++) {
            years[9 - i] = years[9] - i - y;
        }
        
        y1.setText("" + years[0] + ":");
        y2.setText("" + years[1] + ":");
        y3.setText("" + years[2] + ":");
        y4.setText("" + years[3] + ":");
        y5.setText("" + years[4] + ":");
        y6.setText("" + years[5] + ":");
        y7.setText("" + years[6] + ":");
        y8.setText("" + years[7] + ":");
        y9.setText("" + years[8] + ":");
        y10.setText("" + years[9] + ":");
        
        for (int i = 0; i < revenues.length; i++) {
            revenues[i] = gui.getYearlyRevenue(years[i]);
        }
        
        r1.setText(revenues[0]);
        r2.setText(revenues[1]);
        r3.setText(revenues[2]);
        r4.setText(revenues[3]);
        r5.setText(revenues[4]);
        r6.setText(revenues[5]);
        r7.setText(revenues[6]);
        r8.setText(revenues[7]);
        r9.setText(revenues[8]);
        r10.setText(revenues[9]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        y1 = new javax.swing.JLabel();
        r1 = new javax.swing.JLabel();
        y6 = new javax.swing.JLabel();
        r6 = new javax.swing.JLabel();
        y2 = new javax.swing.JLabel();
        r2 = new javax.swing.JLabel();
        y7 = new javax.swing.JLabel();
        r7 = new javax.swing.JLabel();
        r3 = new javax.swing.JLabel();
        y8 = new javax.swing.JLabel();
        r8 = new javax.swing.JLabel();
        y3 = new javax.swing.JLabel();
        r4 = new javax.swing.JLabel();
        y9 = new javax.swing.JLabel();
        y4 = new javax.swing.JLabel();
        r9 = new javax.swing.JLabel();
        r10 = new javax.swing.JLabel();
        y5 = new javax.swing.JLabel();
        r5 = new javax.swing.JLabel();
        y10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Year");

        jLabel2.setText("Revenue");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 5));

        jLabel3.setText("Go back");

        jLabel4.setText("years");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(y2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(r2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y7)
                        .addGap(18, 18, 18)
                        .addComponent(r7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(y3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(r3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y8)
                        .addGap(18, 18, 18)
                        .addComponent(r8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(y4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(r4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y9)
                        .addGap(18, 18, 18)
                        .addComponent(r9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(y5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(r5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y10)
                        .addGap(18, 18, 18)
                        .addComponent(r10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(y1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(r1))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y6)
                        .addGap(18, 18, 18)
                        .addComponent(r6)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y1)
                    .addComponent(r1)
                    .addComponent(y6)
                    .addComponent(r6))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y2)
                    .addComponent(r2)
                    .addComponent(y7)
                    .addComponent(r7))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y3)
                    .addComponent(r3)
                    .addComponent(y8)
                    .addComponent(r8))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y4)
                    .addComponent(r4)
                    .addComponent(y9)
                    .addComponent(r9))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y5)
                    .addComponent(r5)
                    .addComponent(y10)
                    .addComponent(r10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gui.byttVindu(this, new Statistics(gui));
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel r1;
    private javax.swing.JLabel r10;
    private javax.swing.JLabel r2;
    private javax.swing.JLabel r3;
    private javax.swing.JLabel r4;
    private javax.swing.JLabel r5;
    private javax.swing.JLabel r6;
    private javax.swing.JLabel r7;
    private javax.swing.JLabel r8;
    private javax.swing.JLabel r9;
    private javax.swing.JLabel y1;
    private javax.swing.JLabel y10;
    private javax.swing.JLabel y2;
    private javax.swing.JLabel y3;
    private javax.swing.JLabel y4;
    private javax.swing.JLabel y5;
    private javax.swing.JLabel y6;
    private javax.swing.JLabel y7;
    private javax.swing.JLabel y8;
    private javax.swing.JLabel y9;
    // End of variables declaration//GEN-END:variables
}