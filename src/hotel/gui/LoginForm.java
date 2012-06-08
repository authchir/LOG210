package hotel.gui;

import hotel.LoginSystem;
import hotel.util.Lang;
import hotel.util.ValidationException;

import java.awt.Component;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LoginForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LoginForm dialog;
	private LoginSystem loginSystem;
	
	public static void showDialog(Component frameComponent, Component locationComponent, LoginSystem system) {
		Frame frame = JOptionPane.getFrameForComponent(frameComponent);
		dialog = new LoginForm(frame, locationComponent, system);
		dialog.setVisible(true);
	}
	
    /** Creates new form Login */
    private LoginForm(Frame frame, Component locationComponent, LoginSystem system) {
    	super(frame, Lang.LOGIN_CONNECTION_SCREEN_TITLE.toString(), true);
    	loginSystem = system;
        GUI.initLookAndFeel();
        initComponents();
        setLocationRelativeTo(locationComponent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        LabelUsername = new javax.swing.JLabel(Lang.LOGIN_USERNAME.toString());
        LabelPassword = new javax.swing.JLabel(Lang.LOGIN_PASSWORD.toString());
        TextUsername = new javax.swing.JTextField();
        TextPassword = new javax.swing.JPasswordField();
        ButtonLogin = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);

        ButtonLogin.setText(Lang.LOGIN_CONNECT.toString());
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });
        
        ButtonCancel.setText(Lang.LOGIN_CANCEL.toString());
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelPassword)
                            .addComponent(LabelUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(TextUsername))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonLogin)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPassword)
                    .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin)
                    .addComponent(ButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Code qui permet la gestion du bouton ok
     * @param evt
     */
    @SuppressWarnings("deprecation")
	private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
    	try {
			loginSystem.login(TextUsername.getText(), TextPassword.getText()); // TODO replace getText()
			this.dispose();
		} catch (ValidationException e) {
			JOptionPane.showMessageDialog(null, Lang.LOGIN_CONNECTION_FAILED_MESSAGE.toString(), Lang.LOGIN_CONNECTION_FAILED_MESSAGE.toString(), JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm.showDialog(null, null, new LoginSystem());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JTextField TextUsername;
    private javax.swing.JLabel LabelUsername;
    private javax.swing.JLabel LabelPassword;
    // End of variables declaration//GEN-END:variables
}