//Parker Hinrichs (02.24.2023) Assignment 3: Zelda Map

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

class View extends JPanel
{
	BufferedImage tile_image;
	Model model;
	int scroll_x = 0;
	int scroll_y = 0;
	
	//Constructor
	View(Controller c, Model m)
	{
		model = m;
		c.setView(this);

		//Error handeling (Try-catch exeption)
		try 
		{
			this.tile_image = ImageIO.read(new File("tile.png"));
		}
		catch(Exception e) //Exception if unable to read file
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	boolean isRoom(int x, int y)
	{
		if ((x == 0) && (y == 0))
		{
			//Room 1
			return true;
		}
		if ((x == -700) && (y == 0))
		{
			//Room 2
			return true;
		}
		if ((x == -700) && (y == -500))
		{
			//Room 3
			return true;
		}
		if ((x == 0) && (y == -500))
		{
			//Room 4
			return true;
		}
		return false;
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < Model.tiles.size(); i++)
		{
			Tile t = Model.tiles.get(i);
			g.drawImage(tile_image, t.x + scroll_x, t.y + scroll_y, null);
		}
	}
}

