package Poke;

	import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;



	public class Main {
		private final static int WIDTH = 1920;
		private final static int HEIGHT = 700;

	
		
		public static void main(String[] args) throws Exception{
			JFrame frame = new JFrame("wow cats are so cute! meow =^._.^=");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(WIDTH, HEIGHT));
			SushiCanvas canvas = new SushiCanvas(WIDTH, HEIGHT);
			frame.add(canvas);
			

		

	class SCMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if(canvas.getScreen() == 0) {
			canvas.checkMenuClick(x,y);
			}

			

		}

		public void mousePressed(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//			if(canvas.getScreen() == 3) {
//				if(canvas.selectSushi(x,y)) {
//					drag = true;
//					//System.out.println("selected");
//				}
//			}
//
		}
//
		public void mouseReleased(MouseEvent e) {

			//System.out.println("unselect");
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

	}
	canvas.addMouseListener(new SCMouseListener());
//	
//	
//	class MouseMotionEventDemo implements MouseMotionListener{
//
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			int x = e.getX();
//			int y = e.getY();
//			if(drag) {
//				canvas.moveSushi(x,y);
//			}
//
//		}
//
//		@Override
//		public void mouseMoved(MouseEvent e) {
//			
//			if(canvas.getScreen() == 3) {
//				//System.out.print("mousemove");
//			}
//			
//		}
//		
//	}
//	canvas.addMouseMotionListener(new MouseMotionEventDemo());
	frame.setVisible(true);

	
	

	}
	

}
