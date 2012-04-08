package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class ControllerController implements GLEventListener, KeyListener,
		MouseListener, MouseMotionListener {
	private static Stack<IController> subControllers = new Stack<IController>();

	public void push(IController controller) {
		subControllers.push(controller);
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		subControllers.peek().draw(drawable);
	}

	@Override
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
			boolean deviceChanged) {
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		Logger.getLogger("ControllerController").log(Level.INFO, "GLInit");
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {

	}

	@Override
	public void mouseDragged(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mouseExited(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mousePressed(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		subControllers.peek().handleMouseEvent(event);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		subControllers.peek().handleKeyEvent(event);
	}

	@Override
	public void keyReleased(KeyEvent event) {
		subControllers.peek().handleKeyEvent(event);
	}

	@Override
	public void keyTyped(KeyEvent event) {
		subControllers.peek().handleKeyEvent(event);
	}
}
