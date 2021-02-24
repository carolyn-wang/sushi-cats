package Poke;

import java.awt.Image;

public class Sushi {
private String name;
private Image top;
private boolean hasRice;
private boolean hasStrip;
private Image complete;
private Image completeS;
private int x;
private int y;

public Sushi (String nameIn, Image topIn, boolean hasRiceIn, boolean hasStripIn, Image completeIn,Image completeSIn, int xIn, int yIn) {
	name = nameIn;
	top = topIn;
	hasRice = hasRiceIn;
	hasStrip = hasStripIn;
	complete = completeIn;
	completeS = completeSIn;
	x = xIn;
	y = yIn;
}
public Sushi (String nameIn, Image topIn, boolean hasRiceIn, boolean hasStripIn, Image completeIn, Image completeSIn) {
	name = nameIn;
	top = topIn ;
	hasRice = hasRiceIn;
	hasStrip = hasStripIn;
	complete = completeIn;
	completeS = completeSIn;
	x = 0;
	y = 0;
}

public Sushi (String nameIn, Image topIn, int xIn, int yIn) {
	name = nameIn;
	top = topIn ;
	hasRice = false;
	hasStrip = false;
	complete = null;
	completeS = null;
	x = xIn;
	y = yIn;
}


public Sushi copy() {
	return new Sushi(name, top, hasRice, hasStrip, complete, completeS, x, y);
}


public String getName() {
	return name;
}

public Image getTop() {
	return top;
}

public Image getComplete() {
	return complete;
}

public Image getCompleteS() {
	return completeS;
}

public boolean getHasRice() {
	return hasRice;
}

public boolean getHasStrip() {
	return hasStrip;
}

public int getX() {
	return x;
	
}

public int getY() {
	return y;
	
}

public int getWidth() {
	return top.getWidth(null);
}

public int getHeight() {
	return top.getHeight(null);
}


public void moveSushi(int xIn, int yIn) {
	x = xIn;
	y = yIn;
}

public boolean equals(Order orderIn) {
	if(name.equals(orderIn.getName()) && hasStrip == orderIn.getHasStrip()) {
		return true;
	}
	return false;
}


public void setX(int xIn) {
	x = xIn;
}

public void setY(int yIn) {
	y = yIn;
}

public void setHasRice(boolean hasRiceIn) {
	hasRice = hasRiceIn;
}

public void setHasStrip(boolean hasStripIn) {
	hasStrip = hasStripIn;
}
}
