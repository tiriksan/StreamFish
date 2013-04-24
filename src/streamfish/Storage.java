package streamfish;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author HJ
 */
public class Storage extends javax.swing.JPanel {

    private int ingredientID = -1;
    private final GUI gui;
    private Ingredient[] ingredients;
    private Ingredient ingToBeEdited;
    private Orderinfo[] orderinfo;
    private int viewRow = -1;

    public Storage(final GUI gui) {
        this.gui = gui;
        gui.setTitle("Storage");
        initComponents();

        tab1setup();
        tab2setup();

        addListSelectListener();
        addDocumentListener();

    }

    private void addListSelectListener() {
        jTable1.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        int viewRow = jTable1.getSelectedRow();
                        if (!event.getValueIsAdjusting()) {
                            try {
                                ingToBeEdited = ingredients[viewRow];
                            } catch (Exception e) {
                            }
                        }
                    }
                });
    }

    private void addDocumentListener() {
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (jTabbedPane1.getSelectedIndex() == 0) {
                    ingredients = gui.getIngredients(jTextField1.getText());
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    if (ingredients != null && ingredients.length > 0) {
                        for (int i = 0; i < ingredients.length; i++) {
                            model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
                        }
                    }
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    orderinfo = gui.getTodaysTasks(jTextField1.getText());;
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0);
                    if (orderinfo != null && orderinfo.length > 0) {
                        for (int i = 0; i < orderinfo.length; i++) {
                            model.addRow(new Object[]{orderinfo[i].getMenu(), orderinfo[i].getNumberOfPersons(), orderinfo[i].getAddress()});
                        }
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ingredients = gui.getIngredients(jTextField1.getText());
                if (jTabbedPane1.getSelectedIndex() == 0) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    if (ingredients != null && ingredients.length > 0) {
                        for (int i = 0; i < ingredients.length; i++) {
                            model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
                        }
                    }
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    orderinfo = gui.getTodaysTasks(jTextField1.getText());;
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0);
                    if (orderinfo != null && orderinfo.length > 0) {
                        for (int i = 0; i < orderinfo.length; i++) {
                            model.addRow(new Object[]{orderinfo[i].getMenu(), orderinfo[i].getNumberOfPersons(), orderinfo[i].getAddress()});
                        }
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (jTabbedPane1.getSelectedIndex() == 0) {
                    ingredients = gui.getIngredients(jTextField1.getText());
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    if (ingredients != null && ingredients.length > 0) {
                        for (int i = 0; i < ingredients.length; i++) {
                            model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
                        }
                    }
                } else if (jTabbedPane1.getSelectedIndex() == 1) {
                    orderinfo = gui.getTodaysTasks(jTextField1.getText());;
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0);
                    if (orderinfo != null && orderinfo.length > 0) {
                        for (int i = 0; i < orderinfo.length; i++) {
                            model.addRow(new Object[]{orderinfo[i].getMenu(), orderinfo[i].getNumberOfPersons(), orderinfo[i].getAddress()});
                        }
                    }
                }
            }
        });
    }

    private void tab1setup() {
        ingredients = gui.getIngredients(jTextField1.getText());
        if (ingredients != null && ingredients.length > 0) {
            for (int i = 0; i < ingredients.length; i++) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
            }
        }

        jTable1.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {
                        if (!event.getValueIsAdjusting()) {
                            viewRow = jTable1.getSelectedRow();
                        }
                    }
                });
    }

    private void tab2setup() {
        orderinfo = gui.getTodaysTasks2("");

        if (orderinfo != null && orderinfo.length > 0) {
            for (int i = 0; i < orderinfo.length; i++) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.addRow(new Object[]{orderinfo[i].getMenu(), orderinfo[i].getNumberOfPersons(), orderinfo[i].getAddress()});

            }
        }

        jTable2.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent event) {

                        if (!event.getValueIsAdjusting()) {
                            viewRow = jTable2.getSelectedRow();
                        }
                    }
                });
    }

    public void update() {
        if (jTabbedPane1.getSelectedIndex() == 0) {
            ingredients = gui.getIngredients(jTextField1.getText());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (ingredients != null && ingredients.length > 0) {
                for (int i = 0; i < ingredients.length; i++) {
                    model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
                }
            }
        } else if (jTabbedPane1.getSelectedIndex() == 1) {
            orderinfo = gui.getTodaysTasks2(jTextField1.getText());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (orderinfo != null && orderinfo.length > 0) {
                for (int i = 0; i < orderinfo.length; i++) {
                    model.addRow(new Object[]{orderinfo[i].getMenu(), orderinfo[i].getNumberOfPersons(), orderinfo[i].getAddress()});
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        jLabel1.setText("Search:");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Dish Options");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingredient ID", "Name", "Amount", "Expiry date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);

        jTabbedPane1.addTab("Storage", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Menu", "#Pers", "Address"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(1).setMinWidth(70);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(70);

        jButton5.setText("Get info");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(205, 205, 205))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Todays tasks", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RegIngredient ing = new RegIngredient(gui, "Add");
        ing.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                update();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                update();
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (ingToBeEdited != null) {
            RegIngredient ing = new RegIngredient(gui, "Apply", ingToBeEdited);
            ing.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    update();
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    update();
                }

                @Override
                public void windowIconified(WindowEvent e) {
                }

                @Override
                public void windowDeiconified(WindowEvent e) {
                }

                @Override
                public void windowActivated(WindowEvent e) {
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                }
            });

        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No ingredient is selected.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        gui.byttVindu(this, new DishOptions(gui));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (viewRow >= 0) {
            new TodaysTasksFrame(orderinfo[viewRow], gui);
        } else {
            showMessageDialog(null, "Ingen valgt");
        }

    }//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
