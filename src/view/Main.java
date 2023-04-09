package view;

import java.util.concurrent.Semaphore;

import controller.ControllerChef;

public class Main {

	public static void main(String[] args) 
	{
		Semaphore perm = new Semaphore(1);
		
		for(int i = 1; i <= 5; i++)
		{
			ControllerChef prato = new ControllerChef(i, perm);
			prato.cozinha();
		}
	}

}
