import java.awt.Button;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main {
	public static ArrayList<Resistor> resists = new ArrayList<>();
	public static ArrayList<Transistor> transists = new ArrayList<>();
	public static ArrayList<Cabling> cable = new ArrayList<>();
	public static ArrayList<Power> power = new ArrayList<>();
	public static boolean canPlace = true;
	public static void main(String[] args)
	{
		Framer framer = new Framer();
		framer.add(framer.pane);
		cable.add(new Cabling());
		cable.get(0).isNew = false;
		cable.add(new Cabling());
		cable.get(1).isNew = false;
		resists.add(new Resistor(0));
		resists.get(0).isNew = false;
		resists.get(0).Ox = 999999999;
		resists.get(0).Oy = 999999999;
		
		transists.add(new Transistor());
		transists.get(0).isNew = false;
		Button Cbutton = new Button("Cable");
		Cbutton.addActionListener(e -> {
			removeDupes();
			cable.add(new Cabling());
			cable.get(cable.size()-1).Physics();
			System.out.println(cable);
			framer.pane.requestFocusInWindow();
			
		});
		framer.pane.add(Cbutton); 
		
		Button Pbutton = new Button("Power");
		Pbutton.addActionListener(e -> {
			removeDupes();
			String Volts = JOptionPane.showInputDialog(null, "Enter Voltage:");
			double num = -1;
			while (true)
			{
				try 
				{
					num = Double.parseDouble(Volts);
					break;
				}
				catch (Exception e1)
				{
					Volts = JOptionPane.showInputDialog(null, "Invalid, Voltage Must Be A Number:");
				} 
			}
			power.add(new Power(num));
			
			framer.pane.requestFocusInWindow();
			
		});
		framer.pane.add(Pbutton); 
		
		Button Rbutton = new Button("Resistor");
		Rbutton.addActionListener(e -> {
			removeDupes();
			String RES = JOptionPane.showInputDialog(null, "Enter Resistance:");
			double num = -1;
			while (true)
			{
				try 
				{
					num = Double.parseDouble(RES); 
					break;
				}
				catch (Exception e1)
				{
					RES = JOptionPane.showInputDialog(null, "Invalid, Resistance Must Be A Number:");
				} 
			}
			resists.add(new Resistor(num));
			
			framer.pane.requestFocusInWindow();
			
		});
		framer.pane.add(Rbutton); 
		
		Button Tbutton = new Button("Transistor");
		Tbutton.addActionListener(e -> {
			removeDupes();
			transists.add(new Transistor());
			
			framer.pane.requestFocusInWindow();
		});
		framer.pane.add(Tbutton); 
		
		for (int c = 0; c < cable.size(); c++)
		{
			if (cable.get(c).x.size() <= cable.get(c).changedVals + 1)
			{
				cable.get(c).x.add(0);
			}
			
			if (cable.get(c).y.size() <= cable.get(c).changedVals + 1)
			{
				cable.get(c).y.add(0);
			}
		}
		
		framer.pane.Presists = resists;
		framer.pane.cable = cable;
		framer.pane.power = power;
		framer.pane.transists = transists;
		framer.pane.requestFocusInWindow();
		framer.setVisible(true);
	}
	
	public static void removeDupes()
	{
		for (int c = 0; c < cable.size(); c++)
		{
			if (cable.get(c).isNew == true)
			{
				cable.remove(c);
				c--;
			}
			
		}
		
		for(int i = 0; i < power.size(); i++)
		{
			if (power.get(i).isNew == true)
			{
				power.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < resists.size(); i++)
		{
			if (resists.get(i).isNew == true)
			{
				resists.remove(i);
				i--;
			}
		}
		
		for(int i = 0; i < transists.size(); i++)
		{
			if (transists.get(i).isNew == true)
			{
				transists.remove(i);
				i--;
			}
		}
	}
}  

