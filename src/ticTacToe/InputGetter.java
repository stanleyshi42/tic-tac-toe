package ticTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InputGetter {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ExecutorService executor = Executors.newSingleThreadExecutor();
	String input;

	private InputGetter() {

	}

	private String read() throws IOException {
		return this.reader.readLine();
	}

	public static String getInput() {
		return new InputGetter().input;
	}

}
