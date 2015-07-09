package threadlocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	@SuppressWarnings("unchecked")
	private E[] data = (E[])(new Object[10]);
	private int count;
	
	public void put(E e) {
		lock.lock();
		try {
			while (count >= data.length) {
				try {
					notFull.await();
				} catch(InterruptedException ie) {}
			}
			data[count++] = e;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public E take() {
		lock.lock();
		try {
			while (count == 0) {
				try {
					notEmpty.await();
				} catch(InterruptedException ie) {}
			}
			E rv = data[0];
			count--;
			System.arraycopy(data, 1, data, 0, count);
			notFull.signal();
			return rv; // Note, this still runs finally block!!!
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final MyQueue<Integer> q = new MyQueue<>();
		int COUNT = 10_000;
		Runnable producer = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < COUNT; i++) {
					q.put(i);
					System.out.print(".");
				}
				System.out.println("Producer finished...");
			}
		};
		
		Runnable consumer = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < COUNT; i++) {
					int j = q.take();
					System.out.print(":");
					if (j != i) {
						System.err.println("Broken!!!! " + i + " " + j);
					}
				}
				System.out.println("Consumer finished...");
			}
		};
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
		System.out.println("Running...");
		t1.join();
		t2.join();
		System.out.println("Done...");
	}

}
