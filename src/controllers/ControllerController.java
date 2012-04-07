package controllers;

import java.util.Stack;

public class ControllerController {
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
}
