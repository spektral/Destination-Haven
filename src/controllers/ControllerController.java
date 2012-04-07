package controllers;

import java.util.Stack;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class ControllerController implements GLEventListener {
	private static Stack<IController> subControllers = new Stack<IController>();

	public static void start() {
		while (true) {
			subControllers.peek().handleEvents();
			subControllers.peek().update();
		}
	}

	public static void push(IController controller) {
		subControllers.push(controller);
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		subControllers.peek().draw(drawable);

		GL gl = drawable.getGL();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		gl.glOrtho(-1.0, 1.0, -1.0, 1.0, -1.0, 1.0);
		gl.glBegin(GL.GL_POLYGON);
		gl.glVertex2f(-0.5f, -0.5f);
		gl.glVertex2f(-0.5f, 0.5f);
		gl.glVertex2f(0.5f, 0.5f);
		gl.glVertex2f(0.5f, -0.5f);
		gl.glEnd();
		gl.glFlush();
	}

	@Override
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
			boolean deviceChanged) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

	}
}
