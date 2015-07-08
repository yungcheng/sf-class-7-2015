package annotation;

public class Stuff {

	@SetMe
	private String aValue;

	private String bValue;
	
	@CallMe(value=2, name="Frankie")
	public void doStuff() {
		System.out.println("Hello!? Who is that!?");
	}
	
	@CallMe(value=1, name="Jim")
	@CallMe
	private void doMoreStuff() {
		System.out.println("oh, look, here we go again");
	}

	@Override
	public String toString() {
		return "Stuff [aValue=" + aValue + ", bValue=" + bValue + "]";
	}
}
