package pizza;

import java.sql.*;



public class UserBean {

	private String name;
	private boolean isAdmin;
	private String email;
	private String address;
	
	public UserBean()
	{
	
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
				return name;
	}
	public void setName(String name) {
		System.out.println(name);

		this.name = name;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void updateUser() throws Exception
	{
		Connection connection = null;
		Statement statement = null;
		int rs;
		
		try{
			String sqlMessage;
			Class.forName("com.myswl.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
			statement = connection.createStatement();
			connection.setAutoCommit(false);// forces an error if transaction tries to be 
											//commited without a BEGIN 
			sqlMessage = "UPDATE users SET username = " + "'" + getName();
			sqlMessage += " email=" + "'" + getEmail();
			sqlMessage += "address" + "'" + getAddress();
			sqlMessage += "WHERE username =" + "'" + getName();
			rs = statement.executeUpdate(sqlMessage);
			connection.commit();
		}
		
		catch(SQLException sqle)
		{
			connection.rollback();
			throw new Exception(sqle);
		}
		finally{
			try{
				statement.close();
			}catch(Exception e){}
			try{
				connection.close();
			}catch(Exception e){}
		}
		
	}
	
}
