package controllers;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.opengl.GLAutoDrawable;

import models.MenuItem;

public class IntroController implements IController {
	private static final int CHOICE_START = 0;
	private static final int CHOICE_OPTIONS = 1;
	private static final int CHOICE_QUIT = 2;
	private static final int CHOICE_COUNT = 3;

	private final Logger logger = Logger.getLogger("IntroController");

	private final IntroView view = new IntroView();

	private int menuChoice = 0;
	private final ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

	public IntroController() {
		for (int i = 0; i < CHOICE_COUNT; i++) {
			menuItems.add(new MenuItem());
		}

		MenuItem menuItemStart = menuItems.get(CHOICE_START);
		MenuItem menuItemOptions = menuItems.get(CHOICE_OPTIONS);
		MenuItem menuItemQuit = menuItems.get(CHOICE_QUIT);

		menuItemStart.setPoint(20, 30);
		menuItemStart.setSprite();

		menuItemOptions.setPoint(20, 30);

		menuItemQuit.setPoint(20, 30);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(GLAutoDrawable drawable) {
		view.draw(drawable);
	}

	@Override
	public void handleMouseEvent(MouseEvent event) {
		switch (event.getID()) {
		case MouseEvent.MOUSE_ENTERED:
			break;
		case MouseEvent.MOUSE_PRESSED:
			Point point = event.getLocationOnScreen();
			logger.log(Level.INFO, "" + point.x + "," + point.y);
			break;
		case MouseEvent.MOUSE_RELEASED:
			break;
		case MouseEvent.MOUSE_CLICKED:
			break;
		default:
			// logger.log(Level.INFO, "Default");
		}
	}

	@Override
	public void handleKeyEvent(KeyEvent event) {
		if (event.getID() == KeyEvent.KEY_PRESSED) {
			switch (event.getKeyCode()) {
			case KeyEvent.VK_UP:
				menuChoice--;
				if (menuChoice < 0)
					menuChoice += CHOICE_COUNT;

				logger.log(Level.INFO,
						"Menu choice = " + String.valueOf(menuChoice));
				break;
			case KeyEvent.VK_DOWN:
				menuChoice++;
				if (menuChoice >= CHOICE_COUNT)
					menuChoice -= CHOICE_COUNT;

				logger.log(Level.INFO,
						"Menu choice = " + String.valueOf(menuChoice));
				break;
			case KeyEvent.VK_ENTER:
			case KeyEvent.VK_SPACE:
				runMenuChoice();
				break;
			case KeyEvent.VK_ESCAPE:
				menuChoice = CHOICE_QUIT;
				runMenuChoice();
				break;
			}
		}
	}

	private void runMenuChoice() {
		switch (menuChoice) {
		case CHOICE_START:
			// TODO: Start the game
			// ControllerController.push(new GameController());
			logger.log(Level.INFO, "-> Start");
			break;
		case CHOICE_OPTIONS:
			// TODO: Launch options screen
			// ControllerController.push(new OptionsController());
			logger.log(Level.INFO, "-> Options");
			break;
		case CHOICE_QUIT:
			// TODO: Exit in the right way.
			// ControllerController.pop();
			logger.log(Level.INFO, "-> Quit");
			System.exit(0);
			break;
		}
	}
}
