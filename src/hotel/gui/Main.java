package hotel.gui;

import hotel.Agenda;
import hotel.LoginSystem;

public class Main {
	public static void main(String[] args) {
		/*
		LoginSystem loginSystem = new LoginSystem();
		LoginForm.showDialog(null, null, loginSystem);
		
		if (loginSystem.isConnected()) {*/
			java.awt.EventQueue.invokeLater(new Runnable() {

	            public void run() {
	            	Agenda.getInstance().init();
	                new MenuForm().setVisible(true);
	            }
	        });
		//}
	}
}
