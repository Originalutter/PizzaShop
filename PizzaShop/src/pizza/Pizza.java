package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pizza {

	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private String name;

	public Pizza(String name) throws Exception{
		Connection conn =null;
        Statement stmt = null;
        ResultSet rs=null;
 
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
            
            stmt = conn.createStatement();
            String sql;
            sql ="SELECT * FROM pizzas WHERE name=" + "'" + name + "'";
            rs= stmt.executeQuery(sql);

            this.name = name;
            while(rs.next()) {
            	this.addIngredient(rs.getString("ingredient"));
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
	}
	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice(){
		int price = 0;
		for (Ingredient i: ingredients) {
			price = price + i.getPrice();
		}
		return price + 50;
	}
	public void addIngredient(String ingredientName) {
		try {
			Ingredient i = new Ingredient(ingredientName);
			ingredients.add(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean inStock(){
		boolean inStock = false;
		for(Ingredient i: ingredients) {
			try {
				if (i.inStock()) {
					inStock = true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return inStock;
	}
}
