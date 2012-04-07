import controllers.ControllerController;
import controllers.IntroController;

public class DestinationHaven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControllerController.push(new IntroController());
		ControllerController.start();
	}
}
