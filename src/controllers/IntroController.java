package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.media.opengl.GLAutoDrawable;

public class IntroController implements IController {
	private String buffer;

	@Override
	public void update() {
		try {
			System.out.write(buffer.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GLAutoDrawable drawable) {

	}

	@Override
	public void handleMouseEvent(MouseEvent event) {
		switch (event.getID()) {
		case MouseEvent.MOUSE_ENTERED:
			break;
		}
	}

	@Override
	public void handleKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub

	}
}
