package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.VAccount;

public class EAccount {

	private String id;
	private String password;
	private String name;
	private String grade;
	private String department;
	
	public EAccount() {
	}

	public VAccount getLogin(String id, String password) {
		VAccount vAccount = null;
		
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			// file read
			boolean found = false;
			while (scanner.hasNext() && !found) {
				this.id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.grade = scanner.next();
				this.department = scanner.next();
				
				
				if (this.id.compareTo(id) == 0) {
					if(this.password.compareTo(password) == 0) {
					found = true;
					}
				}
			}
			scanner.close();
			
			if (found) {
				vAccount = new VAccount();
				vAccount.setId(this.id);
				vAccount.setPassword(this.password);
				vAccount.setName(this.name);
				vAccount.setGrade(this.grade);
				vAccount.setDepartment(this.department);
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vAccount;
	}
}
