package ie.tudublin;

public class Cat
{
	String name;
	private int lives;

	public int getLives(int lives)
	{
		return this.lives;
	}

	public void setLives(int lives)
	{
		this.lives = lives;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Cat()
	{
	}
	
	public Cat(String name)
	{
	}
	
	public void speak()
	{
		System.out.println("Meow");
	}

	public void kill()
	{
		if(this.lives > 0)
		{
			this.lives--;
			System.out.println("Ouch!");
		} else {
			System.out.println("Dead.");
		}
	}
}