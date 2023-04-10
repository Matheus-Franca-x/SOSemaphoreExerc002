package controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class ControllerChef extends Thread
{
	private int id;
	private Semaphore entrega;
	private DecimalFormat formatacao = new DecimalFormat("0.00");
	
	public ControllerChef(int id, Semaphore fila)
	{
		this.id = id;
		this.entrega = fila;
	}
	
	public void cozinha()
	{
		new Thread()
		{
			public void run()
			{
				cozimento();
				
				
					entregaCliente();
				
			}
		}.start();
	}

	public void cozimento()
	{
		
		if(this.id % 2 == 1)
		{
			sopaDeCebola();
		}
		else if(this.id % 2 == 0)
		{
			lasanhaABolonhesa();
		}
	}

	private void sopaDeCebola() 
	{
		double tempo = (int)(Math.random() * 301) + 500;
		double tempoF = 0;
		System.out.println("Preparando o prato " + this.id + " de sopa de cebola.");
		try {
			while(tempoF < tempo)
			{
				System.out.println("prato id " + this.id + " preparo " + formatacao.format((tempoF*100)/tempo) + "%");
				sleep(100);
				tempoF += 100;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void lasanhaABolonhesa() 
	{
		double tempo = (int)(Math.random() * 601) + 600;
		double tempoF = 0;
		System.out.println("Preparando o prato " + this.id + " de lasanha a bolonhesa.");
		try {
			while(tempoF < tempo)
				{
					System.out.println("prato id " + this.id + " preparo " + formatacao.format((tempoF*100)/tempo) + "%");
					sleep(100);
					tempoF += 100;
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void entregaCliente()
	{
		try {
			entrega.acquire();
			if(this.id == 1)
			{
				System.out.println("Fazendo entrega do prato id " + this.id + " de sopa de cebola.");			
			}
			else
			{
				System.out.println("Fazendo entrega do prato id " + this.id + " de lasanha a bolonhesa.");			
			}
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("O pedido foi entregue.");
			entrega.release();
		}
	}
	
	
}
