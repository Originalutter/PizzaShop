package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CartBean {
	
	private ArrayList<Pizza> cart = new ArrayList<Pizza>();
	
	public int getPrice() {
		int price = 0;
		for (Pizza p: cart) {
			price = price + p.getPrice();
		}
		return price;
	}
	
	
	
	public boolean inStock() throws Exception{
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Connection conn =null;
        Statement stmt = null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
            
            stmt = conn.createStatement();
            String sql;
            sql ="SELECT * FROM ingredients";
            rs= stmt.executeQuery(sql);

            while(rs.next()) {
            	if (!rs.getString("name").equals("")) {
            		Ingredient i;
					try {
						i = new Ingredient(rs.getString("name"));
	            		ingredients.add(i);
					} catch (Exception e) {return false;}
            	}
            }
            
            for (Pizza p: cart) {
    			for (Ingredient i: p.getIngredients()) {
    				for (int j = 0; j < ingredients.size(); j++) {
    					if (ingredients.get(j).getName().equals(i.getName())) {
    						if (ingredients.get(j).getInStock() > 0) {
    							ingredients.get(j).setInStock(ingredients.get(j).getInStock()-1);
    						} else {
    							return false;
    						}
    					}
    				}
    			}
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
		return true;
	}
	
	public void addPizza(String pizzaName) throws Exception{
		System.out.println("ADDING: " + pizzaName);
		Pizza p = new Pizza(pizzaName);
		cart.add(p);
	}
	
	public void submitPurchase() throws Exception{
		Connection conn =null;
        Statement stmt = null;
 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
            
            for (Pizza p: this.cart) {
            	for (Ingredient i: p.getIngredients()) {
            		stmt = conn.createStatement();
                    String sql;
                    sql ="UPDATE ingredients SET instock = instock - 1 WHERE name='" + i.getName() + "'";
                    stmt.executeUpdate(sql);
            	}
            }
        }   
        catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
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
}
