package Poke;

import java.awt.Image;


public class Order {
private Image orderIm;
private String name;
private boolean hasStrip;

public Order (Image orderImIn, String nameIn, boolean hasStripIn) {
	orderIm = orderImIn;
	name = nameIn;
	hasStrip = hasStripIn;
	}
		
public Image getOrderIm() {
	return orderIm;
	}

public String getName() {
	return name;
}

public boolean getHasStrip() {
	return hasStrip;
}
	
}
