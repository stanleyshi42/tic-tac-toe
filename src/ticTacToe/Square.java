package ticTacToe;

public class Square {
	private char mark;
	private Square topLeft;
	private Square top;
	private Square topRight;
	private Square left;
	private Square right;
	private Square bottomLeft;
	private Square bottom;
	private Square bottomRight;

	public Square(char mark) {
		this.mark = mark;
	}

	public char getMark() {
		return mark;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}

	public Square getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Square topLeft) {
		this.topLeft = topLeft;
	}

	public Square getTop() {
		return top;
	}

	public void setTop(Square top) {
		this.top = top;
	}

	public Square getTopRight() {
		return topRight;
	}

	public void setTopRight(Square topRight) {
		this.topRight = topRight;
	}

	public Square getLeft() {
		return left;
	}

	public void setLeft(Square left) {
		this.left = left;
	}

	public Square getRight() {
		return right;
	}

	public void setRight(Square right) {
		this.right = right;
	}

	public Square getBottomLeft() {
		return bottomLeft;
	}

	public void setBottomLeft(Square bottomLeft) {
		this.bottomLeft = bottomLeft;
	}

	public Square getBottom() {
		return bottom;
	}

	public void setBottom(Square bottom) {
		this.bottom = bottom;
	}

	public Square getBottomRight() {
		return bottomRight;
	}

	public void setBottomRight(Square bottomRight) {
		this.bottomRight = bottomRight;
	}

}
