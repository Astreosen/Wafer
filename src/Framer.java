import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Framer extends JFrame {
	public Paneler pane = new Paneler();
	Framer()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(screenSize.width / 2 - 270, screenSize.height / 2 - 270);
		this.add(pane);
		
		
	}
	
}
