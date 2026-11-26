import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Paneler extends JPanel {
	ArrayList<Resistor> Presists = new ArrayList<>();
	ArrayList<Cabling> cable = new ArrayList<>();
	ArrayList<Power> power = new ArrayList<>();
	ArrayList<Transistor> transists = new ArrayList<>();
	private int x = 0;
	private int y = 0;
	
	private int tx = 0;
	private int ty = 0;
	
	private int px = 0; 
	private int py = 0;
	Paneler()
	{
		
		setFocusable(true);
		addMouseMotionListener(new MouseMotionAdapter()
				{
			
					public void mouseMoved(MouseEvent e)
					{ 
						for (int p = 0; p < power.size(); p++)
						{
							x = e.getX(); 
							y = e.getY();	
							px = x;
							py = y;
							if (power.get(p).isNew == true)
							{
								power.get(p).Ox = px;
								power.get(p).Oy = py;
							}
							
						}
						
						for (int p = 0; p < Presists.size(); p++)
						{
							x = e.getX(); 
							y = e.getY();	
							px = x;
							py = y;
							if (Presists.get(p).isNew == true)
							{
								Presists.get(p).Ox = px;
								Presists.get(p).Oy = py;
							}
							
						}
						
						for (int p = 0; p < transists.size(); p++)
						{
							x = e.getX(); 
							y = e.getY();	
							px = x;
							py = y;
							if (transists.get(p).isNew == true)
							{
								transists.get(p).Ox = px;
								transists.get(p).Oy = py;
							}
							
						}
						
						for (int c = 0; c < cable.size(); c++)
						{
							
							x = e.getX(); 
							y = e.getY();
							tx = x;
							ty = y;

							for (int h = 0; h < cable.size(); h++)
							{
								if (h == c)
								{
									continue;
								}
								if (cable.get(h).x.size() > 0)
								{
									
									if (Math.abs(cable.get(h).x.get(0) - tx) <= 10 && Math.abs(cable.get(h).y.get(0) - ty) <= 10)
									{
										x = cable.get(h).x.get(0);
										y = cable.get(h).y.get(0);
										
										tx = cable.get(h).x.get(0);
										ty = cable.get(h).y.get(0);
										//System.out.println("99");
									} else if (Math.abs(cable.get(h).x.get(cable.get(h).x.size()-1) - tx) <= 10 && Math.abs(cable.get(h).y.get(cable.get(h).x.size()-1) - ty) <= 10)
									{
										x = cable.get(h).x.get(cable.get(h).x.size()-1);
										y = cable.get(h).y.get(cable.get(h).x.size()-1);
										
										tx = cable.get(h).x.get(cable.get(h).x.size()-1);
										ty = cable.get(h).y.get(cable.get(h).x.size()-1);
										//System.out.println("99");
									}
								}
								
								for (int p = 0; p < power.size(); p++)
								{
									if (Math.abs(power.get(p).Ox - tx) <= 10 && Math.abs((power.get(p).Oy - 18) - ty) <= 10)
									{
										x = power.get(p).Ox;
										y = power.get(p).Oy - 18;
										
										tx = power.get(p).Ox;
										ty = power.get(p).Oy - 18;
									} else if(Math.abs(power.get(p).Ox - tx) <= 10 && Math.abs((power.get(p).Oy + 10) - ty) <= 10)
									{
										x = power.get(p).Ox;
										y = power.get(p).Oy + 10;
										
										tx = power.get(p).Ox;
										ty = power.get(p).Oy + 10;
									}
								}
								
								for (int z = 0; z < transists.size(); z++)
								{
									transists.get(z).Physics();
									if (Math.abs((transists.get(z).Ox - (transists.get(z).width / 2) - 20) - x) <=10 &&  Math.abs(transists.get(z).Oy - y) <= 10)
									{
										x = transists.get(z).Ox - (transists.get(z).width / 2) - 20;
										y = transists.get(z).Oy;
										
										tx = transists.get(z).Ox - (transists.get(z).width / 2) - 20;
										ty = transists.get(z).Oy;
									} else if(Math.abs((transists.get(z).Ox + (transists.get(z).width / 2) + 20) - x) <=10 &&  Math.abs(transists.get(z).Oy - y) <= 10)
									{
										x = transists.get(z).Ox + (transists.get(z).width / 2) + 20;
										y = transists.get(z).Oy;
										
										tx = transists.get(z).Ox + (transists.get(z).width / 2) + 20;
										ty = transists.get(z).Oy;
									} else if(Math.abs(transists.get(z).Ox - x) <= 10 &&  Math.abs(transists.get(z).Oy  + (transists.get(z).height / 2) + 20 - y) <= 10)
									{
										x = transists.get(z).Ox;
										y = transists.get(z).Oy + (transists.get(z).height / 2) + 20;
										
										tx = transists.get(z).Ox;
										ty = transists.get(z).Oy + (transists.get(z).height / 2) + 20;
									}
								}
								
								for (int z = 0; z < Presists.size(); z++)
								{
									Presists.get(z).Physics();
									if (Math.abs((Presists.get(z).Ox + (Presists.get(z).Lx))- tx) <= 10 && Math.abs((Presists.get(z).Oy) - ty) <= 10)
									{
										x = Presists.get(z).Ox + (Presists.get(z).Lx);
										y = Presists.get(z).Oy;
										
										tx = Presists.get(z).Ox + (Presists.get(z).Lx);
										ty = Presists.get(z).Oy;
									} else if(Math.abs((Presists.get(z).Ox - (Presists.get(z).Rx))- tx) <= 10 && Math.abs((Presists.get(z).Oy) - ty) <= 10)
									{
										x = Presists.get(z).Ox - (Presists.get(z).Rx);
										y = Presists.get(z).Oy;
										
										tx = Presists.get(z).Ox - (Presists.get(z).Rx);
										ty = Presists.get(z).Oy;
									}
								}
							}
							
							if (cable.get(c).isNew == true)
							{
								if (cable.get(c).changedVals < cable.get(c).x.size()) {
								    cable.get(c).x.set(cable.get(c).changedVals, tx);
								} else {
								    cable.get(c).x.add(tx);
								}
								
								if (cable.get(c).changedVals < cable.get(c).y.size()) {
								    cable.get(c).y.set(cable.get(c).changedVals, ty);
								} else {
								    cable.get(c).y.add(ty);
								}
								
							}
						}
						repaint();
					
					
					}
				});
		
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{ 
				for (int p = 0; p < power.size(); p++)
				{
					if (power.get(p).isNew == true)
					{
						power.get(p).isNew = false;
					}
				}
				
				for (int p = 0; p < Presists.size(); p++)
				{
					Presists.get(p).Physics();
					if (Presists.get(p).isNew == true)
					{
						Presists.get(p).isNew = false;
					}
				}
				
				for (int p = 0; p < transists.size(); p++)
				{
					transists.get(p).Physics();
					if (transists.get(p).isNew == true)
					{
						transists.get(p).isNew = false;
					}
				}
				
				for (int c = 0; c < cable.size(); c++)
				{
					cable.get(c).Physics();
					if (cable.get(c).isNew == true)
					{
						if (cable.get(c).changedVals < cable.get(c).x.size())
						{
						    cable.get(c).x.set(cable.get(c).changedVals, tx);
						}
						else
						{
						    cable.get(c).x.add(tx);
						}
						if (cable.get(c).changedVals < cable.get(c).y.size())
						{
						    cable.get(c).y.set(cable.get(c).changedVals, ty);
						}
						else
						{
						    cable.get(c).y.add(ty);
						}
						cable.get(c).changedVals++;
						
					}
					
					for (int g = 0; g < cable.size(); g++)
					{
						int x2 = cable.get(c).x.get(0);
						int x1 = cable.get(g).x.get(0);
						
						int X2 = cable.get(c).x.get(cable.get(c).x.size() - 1);
						int X1 = cable.get(g).x.get(cable.get(g).x.size() - 1);
						
						int y2 = cable.get(c).y.get(0);
						int y1 = cable.get(g).y.get(0);
						
						int Y2 = cable.get(c).y.get(cable.get(c).y.size() - 1);
						int Y1 = cable.get(g).y.get(cable.get(g).y.size() - 1);
						if (g == c)
						{
							continue;
						}
						
						if (cable.get(g).isNew == true && ((X1 == x2 && Y1 == y2) || (X1 == X2 && Y1 == Y2)) && cable.get(g).x.size() > 1)
						{
							cable.get(g).isNew = false;
							cable.get(g).x.set(cable.get(g).changedVals, x);
							cable.get(g).y.set(cable.get(g).changedVals, y);
						}
					}
				}
				repaint();
			}
		});
		
		addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e)
				{
					System.out.println("5");
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
			        {
						System.out.println("8");
						for (int c = 0; c < cable.size(); c++)
						{
							if (cable.get(c).isNew == true)
							{
								cable.get(c).isNew = false;
								cable.get(c).x.set(cable.get(c).changedVals, cable.get(c).x.get(cable.get(c).changedVals - 1));
								cable.get(c).y.set(cable.get(c).changedVals, cable.get(c).y.get(cable.get(c).changedVals - 1));
							}
						}
						repaint();
			        }
				}
		});
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D A = (Graphics2D)g;
		A.setPaint(Color.pink);
		A.setStroke(new BasicStroke(9));
		A.drawLine(x, y, x, y);
		A.setStroke(new BasicStroke(2));
		A.setPaint(Color.black);
		Font customFont = new Font("Arial", Font.BOLD, 24);
        A.setFont(customFont);
		//Draw Cabling
		for (int c = 0; c < cable.size(); c++)
		{
			for (int i = 0; i < cable.get(c).x.size() - 1; i++)
			{
			A.drawLine(cable.get(c).x.get(i), cable.get(c).y.get(i), cable.get(c).x.get(i + 1), cable.get(c).y.get(i + 1));
			cable.get(c).Physics();
			cable.get(c).Physics();
			int yes = (cable.get(c).x.size() / 2) - 1;
			A.drawString(cable.get(c).Voltage + " Volts", cable.get(c).x.get(yes), cable.get(c).y.get(yes));
			A.drawString(cable.get(c).Current + " Amps", cable.get(c).x.get(yes), cable.get(c).y.get(yes) + 20);
			}
		}
		
		for(int i = 0; i < power.size(); i++)
		{
			A.drawLine(power.get(i).Ox, power.get(i).Oy, power.get(i).Ox, power.get(i).Oy - 18);
			A.drawLine(power.get(i).Ox + 30, power.get(i).Oy, power.get(i).Ox - 30, power.get(i).Oy);
			A.drawLine(power.get(i).Ox + 15, power.get(i).Oy + 10, power.get(i).Ox - 15, power.get(i).Oy + 10);
			A.drawString(power.get(i).Voltage + " Volts", power.get(i).Ox + 15, power.get(i).Oy + 10);
		}
		
		//Draw Resistors
		for(int i = 0; i < Presists.size(); i++)
		{
			Presists.get(i).Physics();
			
		A.drawLine(Presists.get(i).Ox - Presists.get(i).Lx, Presists.get(i).Oy, Presists.get(i).Ox - Presists.get(i).Lx + (Presists.get(i).Lx/2), Presists.get(i).Oy);
		A.drawOval(Presists.get(i).Ox - Presists.get(i).Lx + (Presists.get(i).Lx/2), Presists.get(i).Oy - 10, 40, 20);
		A.drawLine(Presists.get(i).Ox + Presists.get(i).Rx, Presists.get(i).Oy, Presists.get(i).Ox + Presists.get(i).Rx - (Presists.get(i).Rx/2), Presists.get(i).Oy);
		A.drawString(Presists.get(i).Resistance + " Ohms", Presists.get(i).Ox + 15, Presists.get(i).Oy + 50);
		A.drawString(Presists.get(i).Voltage + " Volts", Presists.get(i).Ox + 15, Presists.get(i).Oy + 20);
		A.drawString(Presists.get(i).Current + " Amps", Presists.get(i).Ox + 15, Presists.get(i).Oy - 10);
		}
		
		//Draw Transistors
		for(int i = 0; i < transists.size(); i++)
		{
			transists.get(i).Physics();
					
			A.drawRect(transists.get(i).Ox - (transists.get(i).width / 2), transists.get(i).Oy - (transists.get(i).height / 2), transists.get(i).width, transists.get(i).height);
			A.drawLine(transists.get(i).Ox - (transists.get(i).width / 2), transists.get(i).Oy, transists.get(i).Ox - (transists.get(i).width / 2) - 20, transists.get(i).Oy);
			A.drawLine(transists.get(i).Ox + (transists.get(i).width / 2), transists.get(i).Oy, transists.get(i).Ox + (transists.get(i).width / 2) + 20, transists.get(i).Oy);
			A.drawLine(transists.get(i).Ox, transists.get(i).Oy  + (transists.get(i).height / 2), transists.get(i).Ox, transists.get(i).Oy  + (transists.get(i).height / 2) + 20);
			if (transists.get(i).isOn == true)
			{
				A.drawString("on", transists.get(i).Ox - 20, transists.get(i).Oy  + (transists.get(i).height / 2) - 2);
			}
			
			if (transists.get(i).isOn == false)
			{
				A.drawString("off", transists.get(i).Ox - 20, transists.get(i).Oy  + (transists.get(i).height / 2) - 2);
			}
		}
	}
}
