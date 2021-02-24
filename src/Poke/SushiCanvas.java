package Poke;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;


//import  java.io.*;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
// import javax.sound.sampled.Clip;



public class SushiCanvas extends JComponent{
		private boolean catMaster;
		private boolean masterMeows;
		private final int WIDTH;
		private final int HEIGHT;
		private int screen;
		private boolean flashOn;
		private final static int DELAY = 500;
		private final static int CUST_ENTER_TIME = 9000;
		private final static int SUS_LENGTH = 160;
		private final static int TOP_LENGTH = 5;
		private Image background;
		private Image background2;
		private Image order;
		private Image kitchen;
		private Image assembly;
		private Image table;
		private Image floor;
		private Image sink;
		private Image plate;
		private final static int oStart = 180;
		private final static int kStart = 580;
		private final static int aStart = 970;
		private final static int buttonH = 593;
		private final int floorHeight = 140;
		private final static int spriteH = 420;
		private final int susRowStart = 400;
		private final int susRowH = 10;
		private int platePos = 180;
		private Image sendArrow;
		private Image trash;
		
		private List<Sushi> displaySus = new ArrayList<Sushi>();
		private List<Sushi> displayRice = new ArrayList<Sushi>();
		private List<Sushi> displayWrap = new ArrayList<Sushi>();
		private Sushi sentSus;
		
		private Customer bunny;
		private Customer monkey;
		private Customer pig;
		private Customer dog;
		private Customer chicken;
		private Customer goat;
		
		private Image bunnyIm;
		private Image monkeyIm;
		private Image pigIm;
		private Image dogIm;
		private Image chickIm;
		private Image goatIm;
		private Image cat;
		private Image catM;
		private Image masterM;
		private Customer[] customers = new Customer[6];
		private List<Customer> currentCustomers = new ArrayList<Customer>();
		

		private Image rice;
		private Image salmon;
		private Image tunaIm;
		private Image shrimp;
		private Image octopus;
		private Image eggIm;
		private Image seaweed;
		
		private Sushi selected;
		
		private Sushi salmonSushi;
		private Sushi tunaSushi;
		private Sushi shrimpSushi;
		private Sushi octopusSushi;
		private Sushi eggSushi;

		private Sushi [] menu = new Sushi[7];
		
		private Image salmon_complete;
		private Image tuna_complete;
		private Image shrimp_complete;
		private Image octopus_complete;
		private Image egg_complete;
		private Image salmonS_complete;
		private Image tunaS_complete;
		private Image shrimpS_complete;
		private Image octopusS_complete;
		private Image eggS_complete;
		private Sushi riceBase;
		private Sushi sWrap;
		
		private Image salm_order;
		private Image tuna_order;
		private Image shri_order;
		private Image octo_order;
		private Image egg_order;
		private Image salmS_order;
		private Image tunaS_order;
		private Image shriS_order;
		private Image octoS_order;
		private Image eggS_order;
		
		//private Image vegan_order;
		
		private Order salm;
		private Order tuna;
		private Order shri;
		private Order octo;
		private Order egg;
		private Order salmS;
		private Order tunaS;
		private Order shriS;
		private Order octoS;
		private Order eggS;
		//private Order vegan;
		


		
		private Order [] orders = new Order[10];
		
		public SushiCanvas (int wIn, int hIn) {
			screen = 0;
			WIDTH = wIn;
			HEIGHT = hIn;
			//background = new ImageIcon("background.png").getImage();
			background2 = new ImageIcon("background2.jpg").getImage();
			order = new ImageIcon("button_ordering.png").getImage();
			kitchen = new ImageIcon("button_kitchen.png").getImage();
			assembly = new ImageIcon("button_assembly.png").getImage();
			table = new ImageIcon("table.png").getImage();
			sink = new ImageIcon("sink.png").getImage();
			floor = new ImageIcon("floor.png").getImage();
			plate = new ImageIcon("plate1.png").getImage();
			cat = new ImageIcon("cat.png").getImage();
			catM = new ImageIcon("catMaster.png").getImage();
			masterM = new ImageIcon("sushimaster.gif").getImage();
			
			rice = new ImageIcon("rice.png").getImage();
			seaweed = new ImageIcon("seaweed.png").getImage();
			salmon = new ImageIcon("salmon.png").getImage();
			tunaIm = new ImageIcon("tuna.png").getImage();
			shrimp = new ImageIcon("shrimp.png").getImage();
			octopus = new ImageIcon("octopus.png").getImage();
			eggIm = new ImageIcon("egg.png").getImage();
			
			sendArrow = new ImageIcon("send.png").getImage();
			trash = new ImageIcon("trash.png").getImage();
			sentSus = null;
			

			salmon_complete = new ImageIcon("salmon_complete.png").getImage();
			tuna_complete = new ImageIcon("tuna_complete.png").getImage();
			shrimp_complete = new ImageIcon("shrimp_complete.png").getImage();
			octopus_complete = new ImageIcon("octopus_complete.png").getImage();
			egg_complete = new ImageIcon("egg_complete.png").getImage();
			
			salmonS_complete = new ImageIcon("salmonS_complete.png").getImage();
			tunaS_complete = new ImageIcon("tunaS_complete.png").getImage();
			shrimpS_complete = new ImageIcon("shrimpS_complete.png").getImage();
			octopusS_complete = new ImageIcon("octopusS_complete.png").getImage();
			eggS_complete = new ImageIcon("eggS_complete.png").getImage();
			
			 salmonSushi = new Sushi("salmon", salmon, false, false, salmon_complete, salmonS_complete);
			 tunaSushi = new Sushi("tuna", tunaIm, false, false, tuna_complete, tunaS_complete);
			 shrimpSushi = new Sushi("shrimp", shrimp,  false, false, shrimp_complete, shrimpS_complete);
			 octopusSushi = new Sushi("octopus", octopus,  false, false, octopus_complete, octopusS_complete);
			 eggSushi = new Sushi("egg", eggIm,  false, false, egg_complete, eggS_complete);

			 
			 riceBase = new Sushi("rice", rice, 220, susRowH-10 );
			 sWrap = new Sushi ("seaweed", seaweed, 70, susRowH-10);
			 
			 selected = null;
			 

			 		menu[0]= salmonSushi;
					menu[1]= tunaSushi;
					menu[2]= eggSushi;
					menu[3]= shrimpSushi;
					menu[4]= octopusSushi;

					menu[5] = riceBase;
					menu[6] = sWrap;
					
					bunnyIm = new ImageIcon("bunnyIm.png").getImage();
					monkeyIm = new ImageIcon("monkeyIm.png").getImage();
					pigIm = new ImageIcon("pigIm.png").getImage();
					dogIm = new ImageIcon("dogIm.png").getImage();
					chickIm =  new ImageIcon("chickIm.png").getImage();
					goatIm = new ImageIcon("goat.png").getImage();
					

			salm_order = new ImageIcon("salm_order.png").getImage();
			tuna_order = new ImageIcon("tuna_order.png").getImage();
			shri_order = new ImageIcon("shri_order.png").getImage();
			octo_order = new ImageIcon("octo_order.png").getImage();
			egg_order = new ImageIcon("egg_order.png").getImage();
			salmS_order = new ImageIcon("salmS_order.png").getImage();
			tunaS_order = new ImageIcon("tunaS_order.png").getImage();
			shriS_order = new ImageIcon("shriS_order.png").getImage();
			octoS_order = new ImageIcon("octoS_order.png").getImage();
			eggS_order = new ImageIcon("eggS_order.png").getImage();
			//vegan_order = new ImageIcon("vegan_order.png").getImage();
			
			salm = new Order(salm_order, "salmon", false);
			shri = new Order(shri_order, "shrimp", false);
			octo = new Order(octo_order, "octopus", false);
			egg = new Order(egg_order, "egg", false);
			tuna = new Order(tuna_order, "tuna", false);
			salmS = new Order(salmS_order, "salmon", true);
			shriS = new Order(shriS_order, "shrimp", true);
			octoS = new Order(octoS_order, "octopus", true);
			eggS = new Order(eggS_order, "egg", true);
			tunaS = new Order(tunaS_order, "tuna", true);
			//vegan = new Order(vegan_order, "rice", false);
			
			orders[0] = salm;
			orders[1] = shri;
			orders[2] = octo;
			orders[3] = salmS;
			orders[4] = shriS;
			orders[5] = octoS;
			orders[6] = egg;
			orders[7] = tuna;
			orders[8] = eggS;
			orders[9] = tunaS;
			//order[10] = vegan;
			
			bunny = new Customer (bunnyIm);
			monkey = new Customer (monkeyIm );
			pig = new Customer (pigIm);
			dog = new Customer (dogIm);
			chicken = new Customer(chickIm);
			goat = new Customer(goatIm);
			

			customers[0] = bunny;
			customers[1] = monkey;
			customers[2] = pig;
			customers[3] = dog;
			customers[4] = chicken;
			customers[5] = goat;
			
			
			
			class TimerListener implements ActionListener{
				public void actionPerformed (ActionEvent e) {
					switchFlash();
				}
			}
			Timer t = new Timer(DELAY, new TimerListener());
			t.start();
		

			
			//timer for customers entering
			class TimerListener2 implements ActionListener{
				public void actionPerformed (ActionEvent e) {
					if(screen > 0) {
						Customer nextCust = customers[(int)(Math.random() * customers.length)].copy();
						nextCust.setOrder(orders[(int)(Math.random() * orders.length)]);
						currentCustomers.add(nextCust);
						//currentCustomers.add(0,(customers[(int)(Math.random() * customers.length)]).copy());
						repaint();
					}
				
//				if(screen = 3 && sendingPlate()) {
//				
//				while(platePos >= -500) {
//					platePos--;
//					repaint();
//				}
//				platePos++;
//				}
				}
			}
				Timer t2 = new Timer(CUST_ENTER_TIME, new TimerListener2());
				t2.start();
				

//				  try{
//				      AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(this.getClass().getResource("sushi_cats_music.mp3"));
//				     Clip clip = AudioSystem.getClip();
//				     clip.open(audioInputStream);
//				     clip.start( );
//				    }
//				   catch(Exception ex)
//				   {  }
				
				
				class SCMouseListener implements MouseListener{

					public void mouseClicked(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						if(screen >=1) {
							checkButtonClick(x,y);
						}
						if(screen == 1) {
							if(x<= 120 && y <= 120){
								catMaster = !catMaster;
							}
							
							if(x>= 1100 && y<= 120){
								masterMeows = !masterMeows;
							}
						}
						if(screen == 3) {
							for(int n = 0; n<displaySus.size(); n++) {
								if (x >= displaySus.get(n).getX() && x <= displaySus.get(n).getX() + displaySus.get(n).getWidth() && y >= displaySus.get(n).getY() && y <= displaySus.get(n).getY() + displaySus.get(n).getHeight()) {
									displaySus.add(displaySus.get(n).copy());
									displaySus.remove(n);
									selected = displaySus.get(displaySus.size()-1);
									repaint();
									}
								}
							if (x<= 120 && y >= 150 && y <= 400){
								sendOrder();
							}
							
						}
					
					}

					public void mousePressed(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();			
						if(screen == 3) {
							for(int n = 0; n<displaySus.size(); n++) {
								if (x >= displaySus.get(n).getX() && x <= displaySus.get(n).getX() + displaySus.get(n).getWidth() && y >= displaySus.get(n).getY() && y <= displaySus.get(n).getY() + displaySus.get(n).getHeight()) {
									displaySus.add(displaySus.get(n).copy());
									displaySus.remove(n);
									selected = displaySus.get(displaySus.size()-1);
									repaint();
									}
								}
							
					
							 if(selectSushi(x,y) >= 0 && selectSushi(x,y) < 5) {
								displaySus.add(menu[selectSushi(x,y)].copy());
								selected = displaySus.get(displaySus.size()-1);
								repaint();
								//System.out.println("selecting 1-5");
							}
							else if (selectSushi(x,y) == 5) {
								displayRice.add(menu[selectSushi(x,y)].copy());
								selected = displayRice.get(displayRice.size()-1);
								repaint();
								//System.out.println("selecting 6");
							}
							
							else if (selectSushi(x,y) == 6) {
								displayWrap.add(menu[selectSushi(x,y)].copy());
								selected = displayWrap.get(displayWrap.size()-1);
								repaint();
								//System.out.println("selecting 7");
							}
						
//							else {
//								selected = null;
//								System.out.println("selecting null");
//							}
					
						}

					}

					public void mouseReleased(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						if(screen == 3) {
						if (x<= 120 && y >= 400){
								trash();
							}
						else if(selected != null && !selected.getHasRice() && !selected.getName().equals("rice") && !selected.getName().equals("seaweed") ) {
						for(int n = 0; n<displayRice.size(); n++) {
						if (x >= displayRice.get(n).getX()-20 && x <= displayRice.get(n).getX() + displayRice.get(n).getWidth() && y >= displayRice.get(n).getY() -50 && y <= displayRice.get(n).getY() + 150) {
								displayRice.remove(n);
								selected.setHasRice(true);
							}
							repaint();
						}
						}
						
//						else if(selected != null && selected.getName().equals("seaweed") ) {
//						for(int n = 0; n<displaySus.size(); n++) {
//						if(displaySus.get(n).getHasRice()) {
//						if (x >= displaySus.get(n).getX() && x <= displaySus.get(n).getX() + displaySus.get(n).getWidth() && y >= displaySus.get(n).getY() && y <= displaySus.get(n).getY()) {
//								displaySus.get(n).setHasStrip(true);
//							}
//							repaint();
//							
//						}
//						}
//						}
						
						else if(selected != null && !selected.getHasStrip() && !selected.getName().equals("rice") && selected.getHasRice()) {
								for(int n = 0; n<displayWrap.size(); n++) {
									if (x >= displayWrap.get(n).getX()-20 && x <= displayWrap.get(n).getX() + displayWrap.get(n).getWidth() + 20 && y >= displayWrap.get(n).getY() -40 && y <= displayWrap.get(n).getY() + 20) {
								selected.setHasStrip(true);
								displayWrap.remove(n);
								repaint();
									}
							}
						}

					
//						for(int n = 0; n < displaySus.size(); n++) {
//							if (x >= displaySus.get(n).getX() && x <= displaySus.get(n).getX() + displaySus.get(n).getWidth() && y >= displaySus.get(n).getY() && y <= displaySus.get(n).getY() + displaySus.get(n).getHeight()) {
//									repaint();
//								}
//							}
						
//						for(Sushi selectedRice: displayRice) {
//							if (x >= selectedRice.getX() && x <= selectedRice.getX() + selectedRice.getWidth() && y >= selectedRice.getY() && y <= selectedRice.getY() + selectedRice.getHeight()) {
//							System.out.print("hi");
//							repaint();
//						}
//						}
						}
					}
					

					public void mouseEntered(MouseEvent e) {
						
					}

					public void mouseExited(MouseEvent e) {
						
					}
				
				}
				addMouseListener(new SCMouseListener());
				

				class MouseMotionEventDemo implements MouseMotionListener{

					@Override
					public void mouseDragged(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						
						if(selected != null) {
						//displaySus.get(displaySus.size()-1).moveSushi(x,y);
						selected.moveSushi(x, y);
						repaint();
						}
					}

					@Override
					public void mouseMoved(MouseEvent e) {

						
					}
					
				}
				addMouseMotionListener(new MouseMotionEventDemo());

				
			
	
		
		}

		
		public void paintComponent (Graphics gr) {
			Graphics2D g= (Graphics2D) gr;
			//this is the enter menu
			
			
			g.setColor(new Color(158,218,229));
			g.fillRect(0,0,WIDTH,HEIGHT);
			g.drawImage(background, 0, 0, this);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Sans Serif", Font.BOLD, 70));
			g.drawString("SUSHI CATS", 430, 230);
			g.setFont(new Font("Sans Serif", Font.BOLD, 50));
			if(flashOn) {
			g.drawString("ENTER", 550, HEIGHT-200);
			}
			if(screen == 1) {
				//1: register & ordering
				g.setColor(new Color (156,90,43));
				g.fillRect(0,0,WIDTH,HEIGHT);
				g.drawImage(background2,0,0,this);
				g.setColor(new Color(240,180,130));
				
				g.drawImage(floor,500, HEIGHT-floorHeight-31, this );
				g.drawImage(floor,-2, HEIGHT-floorHeight-31, this );
				g.drawImage(floor,500, HEIGHT-floorHeight, this );
				g.drawImage(floor,-2, HEIGHT-floorHeight, this );
				
				if(catMaster) {
					g.drawImage(catM, 10, spriteH, this);
				}
				else{
					g.drawImage(cat, 10, spriteH, this);
				}
				
				if(masterMeows) {
					//System.out.println("master meows is here");
					g.drawImage(masterM,700, 100, this);
				}

				
				for(int n = 0; n<currentCustomers.size() ; n++) {
					g.drawImage(currentCustomers.get(n).getOrder().getOrderIm(), 150*n + 200 + 10,spriteH - 140, this);
					g.drawImage(currentCustomers.get(n).getSprite(), 150*n+200, spriteH, this);
					
				}
				
				g.drawImage(order, oStart, buttonH, this);
				g.drawImage(kitchen, kStart, buttonH, this);
				g.drawImage(assembly, aStart, buttonH, this);
				
				
				

			}
			if (screen == 2) {
				//2: kitchen (rice)
				g.setColor(Color.WHITE);
				g.fillRect(0,0,WIDTH,HEIGHT);
				g.drawImage(sink, 80, 155, this);
				g.drawImage(order, oStart, buttonH, this);
				g.drawImage(kitchen, kStart, buttonH, this);
				g.drawImage(assembly, aStart, buttonH, this);
				
			}
			if(screen == 3) {
				//3: assembly
				g.setColor(Color.WHITE);
				g.fillRect(0,0,WIDTH,HEIGHT);
				g.drawImage(table, 50, 120, this);
				g.drawImage(plate, platePos, 120, this);
				g.drawImage(sWrap.getTop(), sWrap.getX(), sWrap.getY(), this);
				g.drawImage(riceBase.getTop(),riceBase.getX(), riceBase.getY() , this);
				g.drawImage(sendArrow, 10, 210, this);
				g.drawImage(trash, 20, 395, this);
				g.setFont(new Font("Sans Serif", Font.BOLD, 30));
				g.setColor(new Color(244,67,54));
				g.drawString("SEND", 30, 345);
				g.setColor(new Color(86,86,86));
				g.drawString("TRASH", 25, 548);
				
				
				for(int n = 0; n< TOP_LENGTH ; n++) {
					menu[n].setX(susRowStart+(SUS_LENGTH *n));
					menu[n].setY(susRowH);
					g.drawImage(menu[n].getTop(), menu[n].getX(), menu[n].getY(), this);
					//g.drawImage(menu[n].getTop(), susRowStart+(SUS_LENGTH *n), susRowH, this);
				}
				
				for(int n = 0; n<displayWrap.size() ; n++) {
					g.drawImage(displayWrap.get(n).getTop(), displayWrap.get(n).getX()-75, displayWrap.get(n).getY()-50, this);
				}
				for(int n = 0; n<displayRice.size() ; n++) {
					g.drawImage(displayRice.get(n).getTop(), displayRice.get(n).getX()-75, displayRice.get(n).getY()-50, this);
				}
				
				for(int n = 0; n<displaySus.size() ; n++) {
					if(!displaySus.get(n).getHasRice()) {
					g.drawImage(displaySus.get(n).getTop(), displaySus.get(n).getX()-75, displaySus.get(n).getY()-50, this);
					}
					else if(displaySus.get(n).getHasRice()) {
						if(displaySus.get(n).getHasStrip()) {
							g.drawImage(displaySus.get(n).getCompleteS(), displaySus.get(n).getX()-75, displaySus.get(n).getY()-50, this);
						}
						else {
						g.drawImage(displaySus.get(n).getComplete(), displaySus.get(n).getX()-75, displaySus.get(n).getY()-50, this);
						}
					}
				}
					

				g.drawImage(order, oStart, buttonH, this);
				g.drawImage(kitchen, kStart, buttonH, this);
				g.drawImage(assembly, aStart, buttonH, this);
	
			
				}
				
				}
			
			
		
		public void checkMenuClick(int xIn, int yIn) {
			if (xIn >= 0 && xIn <= WIDTH && yIn >= 0 && yIn <= HEIGHT) {
				screen = 1;
				repaint();
			}
		}
		public void checkButtonClick(int xIn, int yIn) {
			if(xIn >= oStart && xIn <= oStart+130 && yIn >= buttonH-50 && yIn <= buttonH+50) {
				screen = 1;
				repaint();
			}
			if(xIn >= kStart && xIn <= kStart+130 && yIn >= buttonH-50 && yIn <= buttonH+50) {
				screen = 2;
				repaint();
			}
			if(xIn >= aStart && xIn <= aStart+130 && yIn >= buttonH-50 && yIn <= buttonH+50) {
				screen = 3;
				repaint();
			}
		}
		public void switchFlash() {
			flashOn = !flashOn;
			repaint();
		}
		
		public int getScreen() {
			return screen;
		}

		
		public int selectSushi(int xIn, int yIn) {
			
			if( yIn >= susRowH && yIn <= susRowH+150 && xIn >= susRowStart && xIn <= susRowStart+(SUS_LENGTH * TOP_LENGTH)) {
				//System.out.println((xIn-susRowStart)/SUS_LENGTH);
				return (xIn-susRowStart)/SUS_LENGTH;
			}
			else if (xIn >= riceBase.getX() && xIn <= riceBase.getX() + 150 && yIn >= riceBase.getY() && yIn <= riceBase.getY() + 100) {
				return 5;
			}
			else if (xIn >= sWrap.getX() && xIn <= sWrap.getX() + 150 && yIn >= sWrap.getY() && yIn <= sWrap.getY() + 100) {
				return 6;
			}
			return -1;
		}
		
		public void sendOrder() {
			if(selected != null) {
			for (int n = 0; n<displaySus.size(); n++) {
			if(displaySus.get(n).getHasRice()) {
				if (displaySus.get(n).getX()>= platePos - 10 && displaySus.get(n).getX() + displaySus.get(n).getWidth() <= platePos + 610 && displaySus.get(n).getY()>= 100 && displaySus.get(n).getY() <= 360) {
					sentSus = (displaySus.remove(n));
				}
			}
			}
			}
			for(int n = 0; n < currentCustomers.size() ; n++) {
				if (sentSus.equals(currentCustomers.get(n).getOrder())) {
					currentCustomers.remove(n);
				}
			}
					
				}
		
		public void trash() {
			if(selected != null) {
			if(selected.getName().equals("rice")) {
				displayRice.remove(selected);
			}
			else if(selected.getName().equals("seaweed")) {
				displayWrap.remove(selected);
			}
			else{
				displaySus.remove(selected);
			}
			
			}
		}
			
			
		

		}
	
	

