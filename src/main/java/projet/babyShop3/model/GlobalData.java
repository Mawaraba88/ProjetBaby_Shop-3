package projet.babyShop3.model;

import java.util.ArrayList;
import java.util.List;

import projet.babyShop3.entity.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}

}
