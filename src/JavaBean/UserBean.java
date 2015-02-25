package JavaBean;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	private int id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String headPicture;
	private String userType;
	
	public UserBean(){}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getHeadPicture() {return headPicture;}
	public void setHeadPicture(String headPicture) {this.headPicture = headPicture;}
	public String getUserType() {return userType;}
	public void setUserType(String userType) {this.userType = userType;}
	
}
