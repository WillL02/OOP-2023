package ie.tudublin;

public class Main
{
	
	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }
	
	public static void main(String[] args)
	{
		int lives = 9;
		System.out.println("Hello world");
		
		Cat ginger = new Cat("Ginger");
		ginger.setLives(lives);

		for(int i=0;i<lives+1;i++) 
		{
			ginger.kill();
		}
	}
	
}