import java.util.ArrayList;

public class Power {
	public ArrayList<Integer> x = new ArrayList<>();
	public ArrayList<Integer> y = new ArrayList<>();
	public double Voltage = 10;
	public double Current = 0;
	public double length = 0;
	public double temperature = 21;
	public boolean isNew = true;
	public int changedVals = 0;
	
	public int Oy = 250;
	public int Ox = 250;
	public int Lx = 40;
	public int Rx = 40;
	
	public Power(double g)
	{
		Voltage = g;
	}
}
