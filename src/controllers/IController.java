package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.media.opengl.GLAutoDrawable;

public interface IController {
	public void handleMouseEvent(MouseEvent event);

	public void handleKeyEvent(KeyEvent event);

	public void update();

	public void draw(GLAutoDrawable drawable);
}
