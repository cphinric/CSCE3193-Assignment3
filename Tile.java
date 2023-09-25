//Parker Hinrichs (02.24.2023) Assignment 3: Zelda Map

public class Tile {
    int x;
    int y;
    static int w;
    static int h;
    
    Tile(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //Unmarshaling constructor
    Tile(Json ob)
    {
        x = (int)ob.getLong("x");
        y = (int)ob.getLong("y");
    }

    //Mashal constructor
    Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", x);
        ob.add("y", y);
        return ob;
    }

    boolean isTile(int mouse_x, int mouse_y)
    {
        //System.out.println(mouse_x);
        for(int i = 0; i < Model.tiles.size(); i++)
        {
            Tile t = Model.tiles.get(i);
            if((mouse_x < ((t.x + 50)) && mouse_x > (t.x - 50)) && (mouse_y < t.y + 50 && mouse_y > t.y - 50))
            {
                Model.tiles.remove(i);
                return true;
            }
            
        }
        return false;
    }
}
