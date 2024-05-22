package ticTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;

public class InputGetter {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ExecutorService executor = Executors.newSingleThreadExecutor();
	String input;

	private InputGetter() {
		executor.execute(() -> {
			try {
				this.input = read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private InputGetter(int sec) {
		executor.execute(() -> {
			try {
				this.input = read();
			} catch (IOException e) {
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
	private void timer(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
		executor.shutdownNow();
	}

	public static String getInput() {
		return new InputGetter().input;
	}

	public static String getTimedInput(int sec) {
		return new InputGetter(sec).input;
	}

}
