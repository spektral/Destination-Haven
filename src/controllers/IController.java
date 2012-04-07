package controllers;

import javax.media.opengl.GLAutoDrawable;

public interface IController {
	public void handleEvents();

	public void update();

	public void draw(GLAutoDrawable drawable);
}
