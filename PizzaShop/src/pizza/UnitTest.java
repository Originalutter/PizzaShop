package pizza;

import java.util.ArrayList;

public class UnitTest {

	public static void main(String[] args) {
		System.out.println("start");
		try {
			ArrayList<String> is = new ArrayList<String>();
			is.add("ham");
			is.add("cheese");
			Pizza p = new Pizza();
			p.composeNewPizza("ny", is);
			System.out.println("klar");
		} catch (Exception e) {
			System.out.println("FEL");
		}
	}

}
