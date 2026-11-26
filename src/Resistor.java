
public class Resistor extends Main{

	public int Oy = 250;
	public int Ox = 350;
	public int Lx = 40;
	public int Rx = 40;
	public double Voltage = 0;
	public double Current = 0;
	public double Resistance = 10;
	public double temperature = 21;
	public boolean isNew = true;
	
	Resistor(double Res)
	{
		Resistance = Res;
		isNew = true;
	}

	public void Physics()
	{
		//System.out.println(Voltage);
		for (int i = 0; i < super.cable.size(); i++)
		{
			if (super.cable.get(i).x.size() <= 1)
			{
				
				continue;
			}
			if ((((super.cable.get(i).x.get(0) == Ox + Lx && super.cable.get(i).y.get(0) == Oy) || (super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) == Ox - Rx && super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) == Oy)) || ((super.cable.get(i).x.get(super.cable.get(i).x.size() - 1) == Ox + Lx && super.cable.get(i).y.get(super.cable.get(i).y.size() - 1) == Oy) || (super.cable.get(i).x.get(0) == Ox - Rx && super.cable.get(i).y.get(0) == Oy))) && super.cable.get(i).Voltage !=0)
			{
				Voltage = super.cable.get(i).Voltage;
				Current = Voltage/Resistance;
				System.out.println(Current + " Amps");
				System.out.println(Voltage + " Volts R");
			}
		}
		
		
	}

}
