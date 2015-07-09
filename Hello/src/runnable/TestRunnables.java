package runnable;

public class TestRunnables {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			private int i = 0;
			@Override
			public void run() {
				for (; i < 10_000; i++) {
					System.out.println(
							Thread.currentThread().getName()
							+ " has " + i);
				}
			}
		};
		System.out.println("about to call run");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		System.out.println("run completed");
	}
}
