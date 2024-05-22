package ticTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;

public class InputGetter {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ExecutorService executor = Executors.newCachedThreadPool();
	String input;
	boolean timeOut = false;

	public InputGetter() {
		executor.execute(() -> {
			try {
				this.input = read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public InputGetter(int sec) {
		executor.execute(() -> {
			try {
				this.input = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		executor.execute(() -> {
			try {
				timer(sec);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private String read() throws IOException {
		return this.reader.readLine();
	}

	// Stops all threads when timer ends
	private void timer(int sec) {
		try {
			while (sec > 0) {
				Thread.sleep(1000);
				sec--;
			}
			timeOut = true;
			executor.shutdownNow();
		} catch (InterruptedException e) {
			// Ignore exception
		}

	}

}
