package streamfish;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HJ
 */
public class Storage extends javax.swing.JPanel {

	private int ingredientID = -1;
	private final GUI gui;
	private Ingredient[] ingredients;
	private Ingredient ingToBeEdited;

	public Storage(final GUI gui) {
		this.gui = gui;
		gui.setTitle("Storage");
		initComponents();
		ingredients = gui.getIngredients(jTextField1.getText());
		if (ingredients != null && ingredients.length > 0) {
			for (int i = 0; i < ingredients.length; i++) {
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
			}
		}
		
		addListSelectListener();
		addDocumentListener();
		
	}
	
	private void addListSelectListener(){
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
	private void addDocumentListener(){
		jTextField1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				ingredients = gui.getIngredients(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (ingredients != null && ingredients.length > 0) {
					for (int i = 0; i < ingredients.length; i++) {
						model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				ingredients = gui.getIngredients(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (ingredients != null && ingredients.length > 0) {
					for (int i = 0; i < ingredients.length; i++) {
						model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				ingredients = gui.getIngredients(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (ingredients != null && ingredients.length > 0) {
					for (int i = 0; i < ingredients.length; i++) {
						model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
					}
				}
			}
		});
	}
	
	public void update() {
		ingredients = gui.getIngredients(jTextField1.getText());
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);
		if (ingredients != null && ingredients.length > 0) {
			for (int i = 0; i < ingredients.length; i++) {
				model.addRow(new Object[]{ingredients[i].getID(), ingredients[i].getName(), ingredients[i].getAmount(), ingredients[i].getExpDate()});
			}
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
			RegIngredient ing = new RegIngredient(gui, "Edit", ingToBeEdited);
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
		gui.byttVindu(this, new MainMenu(gui));
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
