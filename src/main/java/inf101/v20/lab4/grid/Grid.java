package inf101.v20.lab4.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * A Grid contains a set of elements 
 *
 */
public class Grid<T> implements IGrid<T>, Iterable<T>{
	private List<T> cells;
	private int height;
	private int width;
	private String emptySymbol;

	/**
	 * 
	 * Construct a grid with the given dimensions.
	 * 
	 * @param width
	 * @param height
	 * @param initElement
	 *            What the cells should initially hold (possibly null)
	 */
	public Grid(int width, int height, T initElement) {
		setEmptySymbol((String) initElement);
		if(width <= 0 || height <= 0)
			throw new IllegalArgumentException();

		this.height = height;
		this.width = width;
		cells = new ArrayList<>(height * width);
		for (int i = 0; i < height * width; ++i) {
			cells.add(initElement);
		}
	}


	@Override
	public void setEmptySymbol(String symbol) {
		emptySymbol = symbol;
	}

	@Override
	public String getEmptySymbol() {
		return emptySymbol;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void set(int x, int y, T elem) {
		if(x < 0 || x >= width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y >= height)
			throw new IndexOutOfBoundsException();

		cells.set(coordinateToIndex(x, y), elem);
	}

	private int coordinateToIndex(int x, int y) {
		return x + y*width;
	}
	
	@Override
	public T get(int x, int y) {
		if(x < 0 || x >= width)
			throw new IndexOutOfBoundsException();
		if(y < 0 || y >= height)
			throw new IndexOutOfBoundsException();

		return cells.get(coordinateToIndex(x, y)); 
	}


	@Override
	public void gridOut() {
		for (int Y = 0; Y < this.getHeight(); Y++) {
			StringBuilder curLine = new StringBuilder();
			for (int X = 0; X < this.getWidth(); X++) {
				curLine.append(this.get(X, Y));
				curLine.append("   ");
			}
			System.out.println(curLine.toString());
		}

	}

	@Override
	public Iterator<T> iterator() {
		return cells.iterator();
	}

}
