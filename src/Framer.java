import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Framer extends JFrame {
	public Paneler pane = new Paneler();
	Framer()
	{
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(pane);
		
		
	}
	
}
