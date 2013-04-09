/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kristian
 */
public class MainMenu extends javax.swing.JPanel {

	private int kundenr = -1;
	private final GUI gui;
	private Customer[] customers;

	/**
	 * Creates new form MainMenu
	 */
	public MainMenu(final GUI gui) {
		this.gui = gui;
		initComponents();
		customers = gui.getCustomers(jTextField1.getText());
//		jTable1.setModel();1
		if (customers != null && customers.length > 0) {
			for (int i = 0; i < customers.length; i++) {
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.addRow(new Object[]{customers[i].getCustomerID(), customers[i].getCustomerName(), customers[i].getPhoneNumber(), customers[i].isBusiness()});
			}
		}

		jTextField1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				customers = gui.getCustomers(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (customers != null && customers.length > 0) {
					for (int i = 0; i < customers.length; i++) {
						model.addRow(new Object[]{customers[i].getCustomerID(), customers[i].getCustomerName(), customers[i].getPhoneNumber(), customers[i].isBusiness()});
					}
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				customers = gui.getCustomers(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (customers != null && customers.length > 0) {
					for (int i = 0; i < customers.length; i++) {
						model.addRow(new Object[]{customers[i].getCustomerID(), customers[i].getCustomerName(), customers[i].getPhoneNumber(), customers[i].isBusiness()});
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				customers = gui.getCustomers(jTextField1.getText());
				DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
				model.setRowCount(0);
				if (customers != null && customers.length > 0) {
					for (int i = 0; i < customers.length; i++) {
						model.addRow(new Object[]{customers[i].getCustomerID(), customers[i].getCustomerName(), customers[i].getPhoneNumber(), customers[i].isBusiness()});
					}
				}
			}
		});

		jTable1.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						int viewRow = jTable1.getSelectedRow();
						if (!event.getValueIsAdjusting()) {
							try{
								kundenr = Integer.parseInt(jTable1.getValueAt(viewRow, 0).toString());
							} catch (Exception e){
								
							}
						}
					}
				});
	}

	public void updt() {

		customers = gui.getCustomers(jTextField1.getText());
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);
		if (customers != null && customers.length > 0) {
			for (int i = 0; i < customers.length; i++) {
				model.addRow(new Object[]{customers[i].getCustomerID(), customers[i].getCustomerName(), customers[i].getPhoneNumber(), customers[i].isBusiness()});
			}
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        jButton1.setText("Registrer kunde");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrer ordre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer_id", "Customer name", "Phone", "Business"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(300, 64));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		gui.byttVindu(this, new Reg_ordre(kundenr, gui));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		gui.byttVindu(this, new Reg_kunde(gui));
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
