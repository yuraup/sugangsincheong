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
	private int studentCode;
	
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
				this.studentCode = scanner.nextInt();
				
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
				vAccount.setStudentCode(this.studentCode);
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vAccount;
	}
	
	
	public VAccount getFindId (String name, int studentCode) {
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
				this.studentCode = scanner.nextInt();
				
				if (this.name.compareTo(name) == 0 && Integer.compare(studentCode, this.studentCode) == 0) {
					System.out.println("아이디찾기 name:" +  name);
					System.out.println("아이디찾기 studentCode:" +  studentCode);
					found = true;

				}
			}
			scanner.close();
			
			if (found) {
				VAccount vAccount = new VAccount();
				vAccount.setId(this.id);
				vAccount.setPassword(this.password);
				vAccount.setName(this.name);
				vAccount.setGrade(this.grade);
				vAccount.setDepartment(this.department);
				vAccount.setStudentCode(this.studentCode);
				return vAccount;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return new VAccount();	
	}
	
	public VAccount getFindPw (String id, int studentCode) {
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
				this.studentCode = scanner.nextInt();
				
				if (this.id.compareTo(id) == 0 && Integer.compare(studentCode, this.studentCode) == 0) {
					System.out.println("비밀번호찾기 id:" +  id);
					System.out.println("비밀번호찾기 studentCode:" +  studentCode);
					found = true;
				}
			}
			scanner.close();
			
			if (found) {
				VAccount vAccount = new VAccount();
				vAccount.setId(this.id);
				vAccount.setPassword(this.password);
				vAccount.setName(this.name);
				vAccount.setGrade(this.grade);
				vAccount.setDepartment(this.department);
				vAccount.setStudentCode(this.studentCode);
				return vAccount;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new VAccount();	
	}
}
