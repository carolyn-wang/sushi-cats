package Poke;

import java.awt.Image;

public class Customer {
	private Image sprite;
	private Order pokeOrder;
	
	
	public Customer(Image spriteIn, Order pokeOrderIn) {
		sprite = spriteIn;
		pokeOrder = pokeOrderIn;
	}
	
	public Customer(Image spriteIn) {
		sprite = spriteIn;
		pokeOrder = null;
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public Order getOrder() {
		return pokeOrder;
		}
	
	public Customer copy() {
		return new Customer(sprite, pokeOrder);
	}
	
	public void setOrder(Order orderIn) {
		pokeOrder = orderIn;
	}
}

