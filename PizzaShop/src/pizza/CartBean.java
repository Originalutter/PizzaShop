package pizza;

import java.util.ArrayList;

public class CartBean {
	
	private Pizza[] cart;
	
	public int getPrice() {
		int price = 0;
		for (Pizza p: cart) {
			price = price + p.getPrice();
		}
		return price;
	}
	
	public Pizza[] inStock(){
		ArrayList<Pizza> pizzasNotInStock = new ArrayList<Pizza>();
		
		for (Pizza p: cart) {
			if (!p.inStock()) {
				pizzasNotInStock.add(p);
			}
		}

		return (Pizza[]) pizzasNotInStock.toArray();
	}
}
