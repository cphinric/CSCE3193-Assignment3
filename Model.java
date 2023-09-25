//Parker Hinrichs (02.24.2023) Assignment 3: Zelda Map

import java.util.ArrayList;

class Model
{
	int mouse_x;
	int mouse_y;
	static ArrayList<Tile> tiles;

	//Constructor
	Model()
	{
		tiles = new ArrayList<Tile>();
	}

	//Unmarshaling constructor
	public void unmarshal(Json ob)
	{
		tiles = new ArrayList<Tile>();
		Json tmpList = ob.get ("tiles");
		for(int i = 0; i < tmpList.size(); i++)
		{
			tiles.add(new Tile(tmpList.get(i)));
		}
	}

	//Marshal Constructor
	Json marshal()
	{
		Json ob = Json.newObject();
		Json tmpList = Json.newList();
		ob.add("tiles", tmpList);
		for(int i = 0; i < tiles.size(); i++)
		{
			tmpList.add(tiles.get(i).marshal());
		}
		return ob;
	}

	public void update()
	{

	}

	public void setPosition(int x, int y)
	{
		mouse_x = x - ((x % 50 + 50) % 50);
		mouse_y = y - ((y % 50 + 50) % 50);
		boolean tileFound = false;
		Tile t = new Tile(mouse_x, mouse_y);
		for(int i = 0; i < tiles.size(); i++)
		{
			if(tiles.get(i).isTile(mouse_x, mouse_y) == true)
			{
				tileFound = true;
			}
		}
		if (!tileFound)
		{
			tiles.add(t);
		}
	}
}