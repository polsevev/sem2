package inf101.v20.lab4.grid;

import java.util.List;

/**
 * IGrid is a generic grid 
 * 
 * @author Anna Eilertsen - anna.eilertsen@uib.no 
 *
 */
public interface IGrid<T> {

	void setEmptySymbol(String symbol);

	/**
	 *
	 * @return
	 * Symbol of an empty cell in grid
	 */
	String getEmptySymbol();

	/**
	 * @return The height of the grid.
	 */
	int getHeight();

	/**
	 * @return The width of the grid.
	 */
	int getWidth();

	/**
	 * 
	 * Set the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to change the contents of.
	 * @param y The row of the cell to change the contents of.
	 * @param element The contents the cell is to have.
	 */
	void set(int x, int y, T element);

	/**
	 * 
	 * Get the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to get the contents of.
	 * @param y The row of the cell to get contents of.
	 */
	T get(int x, int y);

	/**
	 * Prints the current grid to console.
	 */
	public void gridOut();

}