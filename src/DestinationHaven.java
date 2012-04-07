import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCanvas;

import controllers.ControllerController;
import controllers.IntroController;

public class DestinationHaven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame("JOGL Hello World");

		ControllerController cc = new ControllerController();
		cc.push(new IntroController());

		GLCanvas glCanvas = new GLCanvas();
		glCanvas.addGLEventListener(cc);
		glCanvas.addKeyListener(cc);
		glCanvas.addMouseListener(cc);
		glCanvas.addMouseMotionListener(cc);

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
