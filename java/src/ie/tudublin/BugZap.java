package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX = 250;
	float playerY = 490;
	float playerWidth = 40;

	float bugX = 250;
	float bugY = 250;
	float bugWidth = 40;

	int score = 0;

	boolean gameStarted = false;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		background(0);
		
	}

	
	public void draw()
	{	
		if(gameStarted == true) 
		{
			clear();
			drawPlayer(playerX, playerY, playerWidth);
			drawBug(bugX, bugY, bugWidth);
			printScore(score);

			if(bugY > 500) 
			{
				gameStarted = false;
				keyCode = 0;
			}
		} else
		{
			clear();
			respawnBug();
			score = 0;
			textSize(75);
			text("BUGZAP",113,100);

			textSize(30);
			text("Press Right Arrow To Play",113,140);
			if(keyCode == RIGHT) 
			{
				gameStarted = true;
			}
		}
	}

	void printScore(int score) 
	{
		fill(255);
		textSize(15);
		text("score: " + score, 425, 20);
	}

	void drawPlayer(float x,float y, float w) 
	{
		float offset = 20;
		noStroke();
		fill(255);
		triangle(playerX,playerY,   playerX+offset,playerY-offset,   playerX+playerWidth,playerY);
	}

	void drawBug(float x, float y, float w) 
	{
		fill(255,0,0);
		circle(x, y, w);
		if ((frameCount % 30) == 0)
		{	
			bugX = random(bugX-50, bugX+50);
			bugY = random(y+20, y+50);
		}		
	}

	void respawnBug() 
	{
		bugX = random(50, 450);
		bugY = -10;
	}

	public void keyPressed()
	{
		if(gameStarted == true) 
			{
			if (keyCode == LEFT)
			{
				System.out.println("Left arrow pressed");
				playerX -= 6;
			}
			if (keyCode == RIGHT)
			{
				System.out.println("Right arrow pressed");
				playerX += 6;
			}
			if (key == ' ')
			{
				float lazerX = playerX + 20;
				float lazerY = playerY - 20;
				System.out.println("SPACE key pressed");
				stroke(255,0,0);
				line(lazerX, lazerY,lazerX, 0);
				if(lazerX >= bugX-bugWidth/2 && lazerX <=bugX+bugWidth/2) 
				{
					System.out.println("WORKS");
					score++;
					respawnBug();
				}
			} 
		}
	}	
}
