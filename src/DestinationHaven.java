import controllers.ControllerStack;
import controllers.IntroController;

public class DestinationHaven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControllerStack.push(new IntroController());
		ControllerStack.start();
	}
}
