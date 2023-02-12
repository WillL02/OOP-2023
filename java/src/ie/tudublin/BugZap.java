package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX = 250;
	float playerY = 490;
	float playerWidth = 50;

	boolean gameStart = false;

	float bugX = 250;
	float bugY = 250;
	float bugWidth = 25;
	int bugSpeed = 120;

	int score = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		background(0);
		
	}
	
	public void draw()
	{	
		if(gameStart == false) {
			splashScreen();
		}
		
		if(gameStart == true) {	
			clear();
			drawPlayer(playerX, playerY, playerWidth);
			drawBug();
			fill(255,255,255);
			text("Score: " + score, 475, 20);
			textSize(10); 
			textAlign(RIGHT);
		}

		if(bugY >= playerY) 
		{
			gameOver();
		}
	}

	public void gameOver()
	{
		gameStart = false;
		clear();
		fill(163,163,163);
		textSize(50); 
		textAlign(CENTER);
		text("GAME OVER!", 250, 100);
		text("PRESS DELETE TO PLAY", 250, 175);
		text("PRESS ENTER TO EXIT", 250, 250);
		

		if(keyCode == BACKSPACE) {
			gameStart = true;
			score = 0;
			
			resetBug();
		}

		if (keyCode == ENTER) {
			exit();
		}
	}
	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			if(playerX <= 1){
				System.out.println("Border Reached.");
			} else {
				System.out.println("Left arrow pressed!");
				playerX -= 4;
			}
		}
		if (keyCode == RIGHT)
		{
			if(playerX >= 500){
				System.out.println("Border Reached.");
			} else {
				System.out.println("Right arrow pressed!");
				playerX += 4;
			}
		}
		
		if (key == ' ')
		{
			System.out.println("SPACE key pressed!");
			stroke(255,0,0);
			float lazerX = playerX + 10;
			float lazerY = playerY - 10;
			line(lazerX, lazerY, lazerX+2, 0);
			if(playerX > bugX-(bugWidth/2) && playerX < bugX+(bugWidth/2)) 
			{
				score++;
				System.out.println(score);
				resetBug();
			}

			
		}
	}	

	void drawPlayer(float x, float y, float w) {
		noStroke();
		fill(255,255,255);
		triangle(playerX, 490, playerX+10, 480, playerX+20, 490);
		if ((frameCount % 120) == 0)
		{
			
			System.out.println("PLAYER COORDS: X: " + playerX + " Y: " + playerX);
		}
	}

	void drawBug() {
		noStroke();
		fill(125,67,0);
		circle(bugX,bugY,bugWidth);
		
		if ((frameCount % bugSpeed) == 0)
		{
			bugX = random(bugX-20,bugX+20);
			bugY = random(bugY+20,bugY+10);
			System.out.println("BUG COORDS: X: " + bugX + " Y: " + bugY);
		}
	}
	
	void splashScreen() {
		clear();
		fill(163,163,163);
		text("BugZap", 250, 100);
		text("PRESS SPACE TO PLAY", 250, 175);
		textSize(50); 
		textAlign(CENTER);

		if(keyCode == ' ') {
		gameStart = true;
		}
	}

	void resetBug() 
	{
		bugX = 250;
	 	bugY = -25;
		bugWidth = 25;
		if(bugSpeed != 10) {
			bugSpeed = bugSpeed - 10;
		}
	}
}
