//Parker Hinrichs (02.24.2023) Assignment 3: Zelda Map

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener
{
	View view;
	Model model;
	Json json;
	boolean leftPressed, rightPressed, upPressed, downPressed;
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean keyEsc;
	boolean keyQ;
	boolean keyS;

	Controller(Model m)
	{
		model = m;
		
	}

	void setView(View v)
	{
		view = v;
	}

	public void actionPerformed(ActionEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
		model.setPosition(e.getX() - view.scroll_x, e.getY() - view.scroll_y);
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_D: keyRight = true; break;
			case KeyEvent.VK_A: keyLeft = true; break;
			case KeyEvent.VK_W: keyUp = true; break;
			case KeyEvent.VK_X: keyDown = true; break;
			case KeyEvent.VK_ESCAPE: keyEsc = true; break;
			case KeyEvent.VK_Q: keyQ = true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_D: keyRight = false; rightPressed = true;
				if(view.isRoom(view.scroll_x - 700, view.scroll_y))
				{
					view.scroll_x -= 700;
				}  
			break;

			case KeyEvent.VK_A: keyLeft = false; leftPressed = true;
				if(view.isRoom(view.scroll_x + 700, view.scroll_y))
				{
					view.scroll_x += 700;
				}
			break;

			case KeyEvent.VK_W: keyUp = false; upPressed = true;
				if(view.isRoom(view.scroll_x , view.scroll_y + 500))
				{
					view.scroll_y += 500;
				}
			break;

			case KeyEvent.VK_X: keyDown = false; downPressed = true;
				if(view.isRoom(view.scroll_x , view.scroll_y - 500))
				{
					view.scroll_y -= 500;
				} 
			break;

			case KeyEvent.VK_ESCAPE: keyEsc = false; break;
			case KeyEvent.VK_Q: keyQ = false; break;
		}
		char l = Character.toLowerCase(e.getKeyChar());

		if(l == 's')
		{
			Json sJson = model.marshal();
			sJson.save("map.json");
			System.out.println("Saving...");
		}

		if(l == 'l')
		{
			Json lJson = Json.load("map.json");
			model.unmarshal(lJson);
			System.out.println("Loading...");
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{
		if(keyEsc) System.exit(0);
		if(keyQ) System.exit(0);
	}
}
