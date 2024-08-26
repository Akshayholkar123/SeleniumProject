import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotClass {

	public static void main(String[] args) throws AWTException {
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);
rb.keyPress(KeyEvent.VK_SHIFT);
rb.keyPress(KeyEvent.VK_ESCAPE);


rb.keyRelease(KeyEvent.VK_ESCAPE);
rb.keyRelease(KeyEvent.VK_SHIFT);
rb.keyRelease(KeyEvent.VK_CONTROL);



	}

}
