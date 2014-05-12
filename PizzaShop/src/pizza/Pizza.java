package pizza;

public class Pizza {

	private Ingredient[] ingredients;
	private String name;
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(Ingredient[] ingredients) {
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
