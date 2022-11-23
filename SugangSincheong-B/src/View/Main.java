package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ValueObject.VAccount;

public class Main {
	PLoginDialog loginDialog;
	public Main () {
	}
	private void initialize() {
		ActionHandler actionHandler = new ActionHandler();
		
		this.loginDialog = new PLoginDialog(actionHandler);
		this.loginDialog.setVisible(true);
	}
	private void run() {
		VAccount account = this.loginDialog.login();
		if (account != null) {
			System.out.println("로그인 성공 " + account);
			loginDialog.dispose();
			//f로그인 성공 
			PMainFrame mainFrame = new PMainFrame(account);
			mainFrame.setVisible(true);	
			mainFrame.setTitle("수강신청 프로그램 "); 
			mainFrame.setLocationRelativeTo(null); //윈도우 창 가운데에 띄움 
		} else {
			System.out.println("로그인 실패 " + account);
		}
		
	}
	private void finish() {
	}
	public class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			run(); //로그인 함수 호출 
		}		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.run();
		main.finish();
	}
}
