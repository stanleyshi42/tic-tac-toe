package ticTacToe;

public class TimeoutException extends Exception {
	public TimeoutException() {
		this("Time's up!");
	}

	public TimeoutException(String errorMessage) {
		super(errorMessage);
	}
}
