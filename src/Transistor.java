
public class Transistor extends Main {
	public int Oy = 250;
	public int Ox = 350;
	public int width = 60;
	public int height = 20;
	public double Voltage = 0;
	public double Current = 0;
	public double Resistance = 10;
	public double temperature = 21;
	public boolean isNew = true;
	public boolean isOn = false;
	
	public void Physics()
	{
		for (int i = 0; i < super.cable.size(); i++)
		{
			if (super.cable.get(i).x.size() <= 1)
			{
				
				continue;
			}
			if ((((super.cable.get(i).x.get(0) == Ox - (width/2) -  20 && super.cable.get(i).y.get(0) == Oy) || (super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) == Ox - (width/2) -  20 && super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) == Oy)) || ((super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) == Ox + (width/2) +  20 && super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) == Oy) || (super.cable.get(i).x.get(0) == Ox + (width/2) +  20 && super.cable.get(i).y.get(0) == Oy))) && super.cable.get(i).Voltage !=0)
			{
				if (isOn == true)
				{
					Voltage = super.cable.get(i).Voltage;
				}
			}
			
			if (((super.cable.get(i).x.get(0) == Ox && super.cable.get(i).y.get(0) == Oy + (height / 2) + 20) || (super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) == Ox && super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) == Oy + (height / 2) + 20)))
			{
				if (super.cable.get(i).Voltage > 0)
				{
					isOn = true;
				} 
			}
		}
	}
}