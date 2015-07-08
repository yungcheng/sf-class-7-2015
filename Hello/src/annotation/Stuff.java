package annotation;

@CallMe
public class Stuff {

	@CallMe
	public void doStuff() {
		System.out.println("Hello!? Who is that!?");
	}
	
	@CallMe
	private void doMoreStuff() {
		System.out.println("oh, look, here we go again");
	}
	
	@Override
	public String toString() {
		return "Hello, I'm a stuff object!";
	}
}
