/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import hotel.Agenda;
import hotel.Reservation;
import hotel.Room;
import hotel.util.ObservableList;

public class ReservationList extends javax.swing.JFrame {

    public ReservationList(ObservableList<Reservation> reservations) {
    	GUI.initLookAndFeel();
    	initComponents(reservations);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(ObservableList<Reservation> reservations) {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableReservationList = new javax.swing.JTable();
        ButtonClose = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Réservations");

        TableReservationList.setModel(new DefaultTableModel(
            new Object [][] { },
            new String [] {"ID", "No de confirmation", "Client"}) {
    	
			Class[] types = new Class [] {Integer.class, Integer.class, Room.Category.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
            	return false;
            }
        });

        TableReservationList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumn column = TableReservationList.getColumnModel().getColumn(0);
        TableReservationList.getColumnModel().removeColumn(column);
        
        for (Reservation r : reservations) {
        	DefaultTableModel model = (DefaultTableModel) TableReservationList.getModel();
        	model.addRow(new Object[] {r.getId(), r.getConfirmationNumber(), r.getClient()});
        }
        
        reservations.AddElementAddedListener(new Observer() {
    			@Override
    			public void update(Observable o, Object arg) {
    				Reservation reservation = (Reservation) arg;
    				DefaultTableModel model = (DefaultTableModel) TableReservationList.getModel();
    				
    				model.addRow(new Object[] {reservation.getId(), reservation.getConfirmationNumber(), reservation.getClient()});
    			}
            });
            
        reservations.AddElementRemovedListener(new Observer() {
    			@Override
    			public void update(Observable o, Object arg) {
    				Reservation reservation = (Reservation) arg;
    				DefaultTableModel model = (DefaultTableModel) TableReservationList.getModel();
    				
    				for (int i = 0; i < model.getRowCount(); ++i) {
    					if (reservation.getId() == (Integer) model.getValueAt(i, 0)) {
    						model.removeRow(i);
    						break;
    					}
    				}
    			}
            });
        
        jScrollPane1.setViewportView(TableReservationList);

        ButtonClose.setText("Fermer");
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });
        
        ButtonAdd.setText("Ajouter");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonClose)
                    .addComponent(ButtonAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
    }//GEN-LAST:event_ButtonCloseActionPerformed
    
    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
    	ReservationForm form = new ReservationForm();
        form.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReservationList(Agenda.getInstance()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable TableReservationList;
    // End of variables declaration//GEN-END:variables
}
