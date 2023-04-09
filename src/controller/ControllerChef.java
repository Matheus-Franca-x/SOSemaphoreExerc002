package controller;

public class ControllerChef 
{
	private int id;
	public ControllerChef(int id)
	{
		this.id = id;
	}
	
	public void cozinha()
	{
		new Thread()
		{
			public void run()
			{
				cozimento();
			}
		}.start();
	}

	public void cozimento()
	{
		
		
		
		
	}
}
