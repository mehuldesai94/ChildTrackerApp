package beans;
import java.util.*;


public class Parent extends User{
	List<Child> childs;
	
	public Parent(int id, String firstName, String lastName, String password, 
			String birthdate, String gender, String address, String phone, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.id = id;
		this.isParent = "true";
		this.isAdmin = "false";
		List<Child> childs = new ArrayList<Child>();
		this.childs = childs;
	}
	
	public Parent() {
		List<Child> childs = new ArrayList<Child>();
		this.childs = childs;
	}
	public void addChild(Child c) {
		childs.add(c);
	}
	public void removeChild(int id) {
		int count = 0;
		for(Child i : childs) {
			if(i.getId() == id) {
				childs.remove(count);
				break;
			}
			count++;
		}
	}
	public List<Child> getChildren(){
		return this.childs;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}
