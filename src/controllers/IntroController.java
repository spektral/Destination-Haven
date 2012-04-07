package controllers;

import java.io.IOException;
import java.util.Scanner;

public class IntroController implements IController {
	private String buffer;

	@Override
	public void handleEvents() {
		Scanner in = new Scanner(System.in);
		buffer = in.nextLine();
	}

	@Override
	public void update() {
		try {
			System.out.write(buffer.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
