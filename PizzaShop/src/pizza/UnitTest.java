package pizza;

public class UnitTest {

	public static void main(String[] args) {
		CartBean cart = new CartBean();
		try {
			cart.addPizza("veszuvio");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cart.getPrice());
	}

}
