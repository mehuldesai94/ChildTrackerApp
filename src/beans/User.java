package beans;

public abstract class User {
	public String firstName =  "";
	public String lastName = "";
	public String password = "";
	public String birthdate = null;
	public String gender = "";
	public String address = "";
	public String phone = "";
	public String email = "";
	public int id = 0;
	public String isParent = "";
	public String isAdmin = "";
	
	public boolean isRegisterValid() {
		if(this.firstName == null || this.lastName == null || this.password == null || 
				this.birthdate == null || this.gender == null || this.address == null ||
						this.phone == null || this.email == null || this.isParent == null ||
								this.isAdmin == null ) {
			return false;
		}
		return true;
	}
}
