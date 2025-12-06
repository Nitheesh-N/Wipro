package wipro;

public class SmartDevice implements Camera,Phone{

	@Override
	public void makeCall() {
		System.out.println("Phone is used to make calls");
		
	}

	@Override
	public void clickPhoto() {
		System.out.println("Camera is used to click photos");
		
	}

}
