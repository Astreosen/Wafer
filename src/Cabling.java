import java.util.ArrayList;

public class Cabling extends Main{
	public ArrayList<Integer> x = new ArrayList<>();
	public ArrayList<Integer> y = new ArrayList<>();
	public double Voltage = 0;
	public double Current = 0;
	public double length = 0;
	public double temperature = 21;
	public boolean isNew = true;
	public int changedVals = 0;
	public double tol = 4;
	
	private int Mx = 0;
	private int My = 0;
	
	private int Cx = 0;
	private int Cy = 0;
	
	Cabling()
	{
		isNew = true;
		changedVals = 0;
	}
	
	
	
	public void Physics()
	{
		if (x.isEmpty() || y.isEmpty()) return;
		
		for (int i = 0; i < super.cable.size(); i++)
		{
			if (super.cable.get(i) == this)
			{
				continue;
			}
			
			if (super.cable.get(i).x.isEmpty() || super.cable.get(i).y.isEmpty())
			{
				continue;
			}
			
			if (((Math.abs(super.cable.get(i).x.get(0) - x.get(0)) <= 10 && Math.abs(super.cable.get(i).y.get(0) - y.get(0)) <= tol) || (Math.abs(super.cable.get(i).x.get(0) - x.get(x.size() - 1)) <= tol && Math.abs(super.cable.get(i).y.get(0) - y.get(y.size() - 1)) <= tol) || (Math.abs(super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) - x.get(0)) <= tol && Math.abs(super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) - y.get(0)) <= tol) || (Math.abs(super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) - x.get(x.size() - 1)) <= tol && Math.abs(super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) - y.get(y.size() - 1)) <= tol)) && super.cable.get(i).Voltage != 0)
			{
				Voltage = super.cable.get(i).Voltage;
				Current = super.cable.get(i).Current;
			}
		}
		//power
		for (int i = 0; i < super.power.size(); i++)
		{
			//positive terminal
			if ((super.power.get(i).Ox == x.get(0) && super.power.get(i).Oy - 18 == y.get(0)) || (super.power.get(i).Ox == x.get(x.size() - 1) && super.power.get(i).Oy - 18 == y.get(y.size() - 1)))
			{
				Voltage = super.power.get(i).Voltage;
				if (i != 0)
				{
					isNew = false;
				}
			}
			
			
			
		}
		
		for (int i = 0; i < super.resists.size(); i++)
		{
			//left terminal
			if (((super.resists.get(i).Ox - super.resists.get(i).Rx == x.get(0) && super.resists.get(i).Oy == y.get(0)) || (super.resists.get(i).Ox - super.resists.get(i).Rx == x.get(x.size() - 1) && super.resists.get(i).Oy == y.get(y.size() - 1))) && super.resists.get(i).Voltage != 0)
			{
				Voltage = super.resists.get(i).Voltage;
				Current = super.resists.get(i).Current;
			}
			
			//right terminal
			if (((super.resists.get(i).Ox + super.resists.get(i).Lx == x.get(0) && super.resists.get(i).Oy == y.get(0)) || (super.resists.get(i).Ox + super.resists.get(i).Lx == x.get(x.size() - 1) && super.resists.get(i).Oy == y.get(y.size() - 1))) && super.resists.get(i).Voltage != 0)
			{
				Voltage = super.resists.get(i).Voltage;
				Current = super.resists.get(i).Current;
			}
		}
		
		for (int i = 0; i < super.transists.size(); i++)
		{
			//left terminal
			if (((super.transists.get(i).Ox - (super.transists.get(i).width/2)-20 == x.get(0) && super.transists.get(i).Oy == y.get(0)) || (super.transists.get(i).Ox  - (super.transists.get(i).width/2)-20 == x.get(x.size() - 1) && super.transists.get(i).Oy == y.get(y.size() - 1))) && super.transists.get(i).Voltage != 0)
			{
				if (super.transists.get(i).isOn == true)
				{
					Voltage = super.transists.get(i).Voltage;
					Current = super.transists.get(i).Current;
				}
			}
			
			//right terminal
			if (((super.transists.get(i).Ox  + (super.transists.get(i).width/2)+20 == x.get(0) && super.transists.get(i).Oy == y.get(0)) || (super.transists.get(i).Ox + (super.transists.get(i).width/2)+20 == x.get(x.size() - 1) && super.transists.get(i).Oy == y.get(y.size() - 1))) && super.transists.get(i).Voltage != 0)
			{
				if (super.transists.get(i).isOn == true)
				{
					Voltage = super.transists.get(i).Voltage;
					Current = super.transists.get(i).Current;
				}
			}
		}
	}
	
	
	
	  

	
	
}
