import java.awt.Button;
import java.util.ArrayList;

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
		resists.add(new Resistor());
		resists.get(0).isNew = false;
		resists.get(0).Ox = 0;
		resists.get(0).Oy = 0;
		
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
			power.add(new Power(10));
			
			framer.pane.requestFocusInWindow();
			
		});
		framer.pane.add(Pbutton); 
		
		Button Rbutton = new Button("Resistor");
		Rbutton.addActionListener(e -> {
			removeDupes();
			resists.add(new Resistor());
			
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

