package pizza;

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
	
	
	
	public ArrayList<Pizza> inStock(){
		ArrayList<Pizza> pizzasNotInStock = new ArrayList<Pizza>();
		
		for (Pizza p: cart) {
			if (!p.inStock()) {
				pizzasNotInStock.add(p);
			}
		}

		return pizzasNotInStock;
	}
	
	public void addPizza(String pizzaName) throws Exception{
		System.out.println("ADDING: " + pizzaName);
		Pizza p = new Pizza(pizzaName);
		cart.add(p);
	}
}
