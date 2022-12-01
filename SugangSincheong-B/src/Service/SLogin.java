package Service;
import Entity.EAccount;
import ValueObject.VAccount;

public class SLogin {
	
	private EAccount eAccount;
	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VAccount login(String id, String password) {
		VAccount vAccount = this.eAccount.getLogin(id, password);
		return vAccount;
	}
	
	public VAccount findId(String name, int studentCode) {
		VAccount vAccount = this.eAccount.getFindId(name, studentCode);
		return vAccount;
	}
}
