package pizza;

import java.sql.*;

public class Ingredient {

	private int price;
	private String name;
	
	public Ingredient(String name) throws Exception{
		Connection conn =null;
        Statement stmt = null;
        ResultSet rs=null;
 
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
            
            stmt = conn.createStatement();
            String sql;
            sql ="SELECT * FROM ingredients WHERE name=" + "'" + name + "'";
            rs= stmt.executeQuery(sql);

            rs.next();
            this.price = Integer.parseInt(rs.getString("price"));
            this.name = name;
        }   
        catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean inStock() throws Exception{
		boolean inStock = false;
		
		Connection conn =null;
        Statement stmt = null;
        ResultSet rs=null;
 
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
            
            stmt = conn.createStatement();
            String sql;
            sql ="SELECT instock FROM ingredients WHERE name=" + "'" + this.name + "'";
            rs= stmt.executeQuery(sql);

            rs.next();
            if (Integer.parseInt(rs.getString("instock")) < 0) {
            	inStock = true;
            }
        }   
        catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
        return inStock;
	}
}
