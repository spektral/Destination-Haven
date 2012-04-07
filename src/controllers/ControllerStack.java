package controllers;

import java.util.Stack;

public class ControllerStack{
	private static Stack<IController> subControllers;
	
	public static void handleEvents() {
		subControllers.peek().handleEvents();
	}
	
	public static void update() {
		subControllers.peek().update();
	}

	public static void push(IController controller) {
		subControllers.push(controller);
	}

	public static void start() {
	}
}
