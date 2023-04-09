package view;

import controller.ControllerChef;

public class Main {

	public static void main(String[] args) 
	{
		for(int i = 1; i <= 5; i++)
		{
			ControllerChef prato = new ControllerChef(i);
			prato.cozinha();
		}
	}

}
