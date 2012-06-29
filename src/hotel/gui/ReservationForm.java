/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import hotel.Hotel;
import hotel.Reservation;
import hotel.Room;
import hotel.StaySystem;
import hotel.util.Lang;
import hotel.util.Observer;
import hotel.util.ValidationException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ReservationForm
	extends javax.swing.JFrame
	implements Observer<Reservation> {

	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Reservation
     */
    public ReservationForm() {
    	GUI.initLookAndFeel();
    	reservationSystem.startNewReservation();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReservation = new javax.swing.JTable();
        ButtonAdd = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonClose = new javax.swing.JButton();
        ButtonSave = new javax.swing.JButton();
        TextName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        
        try {
            javax.swing.text.MaskFormatter mf = new javax.swing.text.MaskFormatter("### ###-####");
            javax.swing.text.DefaultFormatterFactory factory = new javax.swing.text.DefaultFormatterFactory(mf);
            TextTelephone = new javax.swing.JFormattedTextField();
            TextTelephone.setFormatterFactory(factory);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(Lang.RESERVATION_FORM_TITLE.toString());
        setResizable(false);

        TableReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            new String [] { Lang.RESERVATION_FORM_ID.toString(), Lang.RESERVATION_FORM_CATEGORY.toString(), Lang.RESERVATION_FORM_QUANTITY.toString(), Lang.RESERVATION_FORM_DATE_ARRIVAL.toString(), Lang.RESERVATION_FORM_DATE_DEPARTURE.toString()}) {
        	

			private static final long serialVersionUID = 1L;
			Class[] types = new Class [] {
                Integer.class, Room.Category.class, String.class, Object.class, Object.class
            };

			@Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
            	return false;
            }
        });

        TableReservation.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumn column = TableReservation.getColumnModel().getColumn(0);
        TableReservation.getColumnModel().removeColumn(column);
        
        reservationSystem.addReservationDetailAddedListener(new Observer<Reservation.Detail>() {
			@Override
			public void update(Reservation.Detail detail) {
				DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
				
				model.addRow(new Object[] {detail.getId(), detail.getCategory(), detail.getQuantity(), detail.getArrival(), detail.getDeparture()});
			}
        });
        
        reservationSystem.addReservationDetailRemovedListener(new Observer<Reservation.Detail>() {
			@Override
			public void update(Reservation.Detail detail) {
				DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
				
				for (int i = 0; i < model.getRowCount(); ++i) {
					if (detail.getId() == (Integer) model.getValueAt(i, 0)) {
						model.removeRow(i);
						break;
					}
				}
			}
        });

        jScrollPane1.setViewportView(TableReservation);
        
        popupMenu = new JPopupMenu();
        JMenuItem createLinkedStay = new JMenuItem("Créer un séjour lié");
        createLinkedStay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SelectRoomForm form = new SelectRoomForm(Hotel.getInstance().getRooms());
				form.setVisible(true);
			}
        });
        popupMenu.add(createLinkedStay);
        
        
        TableReservation.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
                maybeShowPopup(e);
            }

        	@Override
            public void mouseReleased(MouseEvent e) {
                maybeShowPopup(e);
            }
            
			public void maybeShowPopup(MouseEvent event) {
				
				if (event.isPopupTrigger())
				{
					// Select the row under the cursor
					int rowIndex = TableReservation.rowAtPoint(event.getPoint());
					TableReservation.setRowSelectionInterval(rowIndex, rowIndex);
					
					// Show the popup menu
					popupMenu.show(event.getComponent(), event.getX(), event.getY());
				}
			}
        });

        ButtonAdd.setText(Lang.RESERVATION_FORM_ADD.toString());
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonDelete.setText(Lang.RESERVATION_FORM_DELETE.toString());
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonClose.setText(Lang.RESERVATION_FORM_CLOSE.toString());
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });

        ButtonSave.setText(Lang.RESERVATION_FORM_SAVE.toString());
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });
        
        jLabel1.setText(Lang.RESERVATION_FORM_DETAIL.toString());
        jLabel2.setText(Lang.RESERVATION_FORM_NAME.toString());
        jLabel3.setText(Lang.RESERVATION_FORM_TELEPHONE.toString());
        jLabel4.setText(Lang.RESERVATION_FORM_CLIENT.toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAdd)
                    .addComponent(ButtonDelete)
                    .addComponent(ButtonSave)
                    .addComponent(ButtonClose))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    /**
     * Code qui permet la gestion du bouton ajouter
     * @param evt
     */
    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
    	ReservationDetailForm.showDialog(this, this, reservationSystem);
    }//GEN-LAST:event_ButtonAddActionPerformed

    /**
     * Code qui permet la gestion du bouton supprimer
     * @param evt
     */
    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
    	int rowIndex = TableReservation.getSelectedRow();
    	if (rowIndex != -1) {
    		javax.swing.table.DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
    		int id = (Integer) model.getValueAt(rowIndex, 0);
    		reservationSystem.removeLine(id);
    	}
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    /**
     * Code qui permet la gestion du bouton enregistrer
     * @param evt
     */
    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
		try {
			int reservationNumber = reservationSystem.confirm(TextName.getText(), TextTelephone.getText());
	        JOptionPane.showMessageDialog(this, Lang.RESERVATION_FORM_CONFIRMATION.toString() + reservationNumber);
	        dispose();
		} catch (ValidationException e) {
			JOptionPane.showMessageDialog(this, Lang.RESERVATION_FORM_ERROR.toString());
		}
    }//GEN-LAST:event_ButtonCloseActionPerformed
    
    /**
     * Code qui permet la gestion du bouton fermer
     * @param evt
     */
    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
    	dispose();
    }//GEN-LAST:event_ButtonCloseActionPerformed
    
	@Override
	public void update(Reservation obj) {
		TextName.setText(obj.getClient().getName());
		TextName.setEnabled(false);
		TextTelephone.setText(obj.getClient().getTelephoneNumber());
		TextTelephone.setEnabled(false);
		
		DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
		
		for (Reservation.Detail detail : obj.getDetails())
			model.addRow(new Object[] {detail.getId(), detail.getCategory(), detail.getQuantity(), detail.getArrival(), detail.getDeparture()});
		
		ButtonAdd.setEnabled(false);
		ButtonDelete.setEnabled(false);
		ButtonSave.setEnabled(false);
		
		TableReservation.setEnabled(false);
	}

    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReservationForm().setVisible(true);
            }
        });
    }
    private hotel.ReservationSystem reservationSystem = new hotel.ReservationSystem();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonSave;
    private javax.swing.JTextField TextName;
    private javax.swing.JFormattedTextField TextTelephone;
    private javax.swing.JTable TableReservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables
}