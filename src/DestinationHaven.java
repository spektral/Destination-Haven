import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCanvas;

import controllers.ControllerController;

public class DestinationHaven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ControllerController.push(new IntroController());
		// ControllerController.start();

		Frame frame = new Frame("JOGL Hello World");
		GLCanvas glCanvas = new GLCanvas();
		glCanvas.addGLEventListener(new ControllerController());
		frame.add(glCanvas);
		frame.setSize(1000, 400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
