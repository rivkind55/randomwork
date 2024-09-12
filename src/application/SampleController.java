package application;

import java.util.TimerTask;
import java.util.Random;
import java.util.Timer; 

import javafx.fxml.FXML;
import javafx.scene.shape.Sphere;
import javafx.scene.paint.*;


public class SampleController {
	@FXML
	Sphere sphere1 = new Sphere(); 
	boolean xdir = true; 
	boolean ydir = false; 
	Timer timer = new Timer(); 
	TimerTask task = new TimerTask() {
		
		int locationx = 100; 
		int locationy = 700; 
		int radius    = 10; 
		
		Random rand = new Random(); 
		
		int deltax = 50; 
		int deltay = 20; 
		int change = 1; 
		int width  = 1000; 
		int height = 1000; 

		@Override
		@FXML
		public void run() {
		    // Update location based on current direction
			// location is originally set to 0,1000.
			
			 // Check for boundary conditions
		  
		    
			if(xdir == true && ydir == false)
			{				
				locationx = locationx + deltax + radius; 				
				locationy = locationy - deltay - radius; 
				
				if(locationx >= width)
				{
					xdir = false; 
				}
				
				if(locationy <= 0) 
				{
					ydir = true; 
				}							
			}
			
			if(xdir == false && ydir == false)
			{
				locationx = locationx - deltax; 				
				locationy = locationy - deltay; 
				
				if(locationx <= 0)
				{
					xdir = true; 
				}
				if(locationy <= 0)
				{
					ydir = true; 
				}	
			}
									
			if(xdir == false && ydir == true)
			{				
				locationx = locationx - deltax; 
				locationy = locationy + deltay; 
						
				if(locationx >= 1000)
				{
					xdir = false; 
				}
				if(locationx <= 0)
				{
					xdir = true; 
				}
				//if(locationx )
				if(locationy >= width)
				{
					ydir = false; 
				}
			}	
			
			if(xdir == true && ydir == true)
			{				
				locationx = locationx + deltax; 
				locationy = locationy + deltay; 
						
				if(locationx >= width)
				{
					xdir = false; 
				}
				
				if(locationy >= height)
				{
					ydir = false; 
				}				
			}	
			
		    // Update the sphere's position
		    sphere1.setLayoutX(locationx );
		    sphere1.setLayoutY(locationy );
		}
	};
	
	{
		{
			timer.scheduleAtFixedRate(task,50,50);
		}
	 //timer.schedule(task,200);
	}
	@FXML 
	public void moveCircle()
	{
		sphere1.setLayoutX(Math.random()*400);
		sphere1.setLayoutY(Math.random()*650);
	}
	
	
	
//	{
//		sphere1.setLayoutX(Math.random()*1000);
//		sphere1.setLayoutY(Math.random()*1000);
//		}

}
