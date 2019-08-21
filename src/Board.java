import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Board {
	// Instance Variables
	String[] rowLetters = { "  ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	String[] rowOne = { " 1", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowTwo = { " 2", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowThree = { " 3", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowFour = { " 4", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowFive = { " 5", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowSix = { " 6", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowSeven = { " 7", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowEight = { " 8", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowNine = { " 9", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	String[] rowTen = { "10", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." };
	Map<Integer, String[]> map;
	Map<String, Integer> letter2Integer;

	public Board() {
		map = new TreeMap<>();
		letter2Integer = new HashMap<>();
		map.put(0, rowLetters);
		map.put(1, rowOne);
		map.put(2, rowTwo);
		map.put(3, rowThree);
		map.put(4, rowFour);
		map.put(5, rowFive);
		map.put(6, rowSix);
		map.put(7, rowSeven);
		map.put(8, rowEight);
		map.put(9, rowNine);
		map.put(10, rowTen);
		letter2Integer.put("A", 1);
		letter2Integer.put("B", 2);
		letter2Integer.put("C", 3);
		letter2Integer.put("D", 4);
		letter2Integer.put("E", 5);
		letter2Integer.put("F", 6);
		letter2Integer.put("G", 7);
		letter2Integer.put("H", 8);
		letter2Integer.put("I", 9);
		letter2Integer.put("J", 10);
	}

	public void printBoard() {
		for (Integer key : map.keySet()) {
			System.out.println(Arrays.toString(map.get(key)).replaceAll(",", " ").replaceAll("[\\[\\]]", ""));
		}
	}

	public void addCarrier(String coordinates, String orientation) {
		String columnHead = coordinates.substring(0, 1);
		String rowHead = "";
		if (coordinates.length()==3) rowHead = coordinates.substring(1);
		else rowHead = coordinates.substring(1, 2);
		if (orientation.equals("V") || orientation.equals("v")) {
			if (Integer.parseInt(rowHead) + 5 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = Integer.parseInt(rowHead); k < Integer.parseInt(rowHead) + 5; k++) {
				int element = letter2Integer.get(columnHead);
				if (!map.get(k)[element].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!"); 
				}
			}
			for (int k = Integer.parseInt(rowHead); k < Integer.parseInt(rowHead) + 5; k++) {
				int element = letter2Integer.get(columnHead);
				map.get(k)[element] = "O";
			}
		}
		if (orientation.equals("H") || orientation.equals("h")) {
			if (letter2Integer.get(columnHead) + 5 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = letter2Integer.get(columnHead); k < letter2Integer.get(columnHead) + 5; k++) {
				String row = rowHead;
				if (!map.get(Integer.parseInt(row))[k].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!");
				}
			}
			for (int k = letter2Integer.get(columnHead); k < letter2Integer.get(columnHead) + 5; k++) {
				String row = rowHead;
				map.get(Integer.parseInt(row))[k] = "O";
			}
		}
	}
	
	public void addBattleship(String coordinates, String orientation) {
		String columnHead = coordinates.substring(0, 1);
		String rowHead = "";
		if (coordinates.length()==3) rowHead = coordinates.substring(1);
		else rowHead = coordinates.substring(1, 2);
		if (orientation.equals("V") || orientation.equals("v")) {
			if (Integer.parseInt(rowHead) + 4 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 4; k++) {
				int element = letter2Integer.get(columnHead);
				if (!map.get(k)[element].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!"); 
				}
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 4; k++) {
				int element = letter2Integer.get(columnHead);
				map.get(k)[element] = "O";
			}
		}
		if (orientation.equals("H") || orientation.equals("h")) {
			if (letter2Integer.get(columnHead) + 4 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 4; k++) {
				String row = rowHead;
				if (!map.get(Integer.parseInt(row))[k].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!");
				}
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 4; k++) {
				String row = rowHead;
				map.get(Integer.parseInt(row))[k] = "O";
			}
		}
	}
	
	public void addCruiser(String coordinates, String orientation) {
		String columnHead = coordinates.substring(0, 1);
		String rowHead = "";
		if (coordinates.length()==3) rowHead = coordinates.substring(1);
		else rowHead = coordinates.substring(1, 2);
		if (orientation.equals("V") || orientation.equals("v")) {
			if (Integer.parseInt(rowHead) + 3 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 3; k++) {
				int element = letter2Integer.get(columnHead);
				if (!map.get(k)[element].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!"); 
				}
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 3; k++) {
				int element = letter2Integer.get(columnHead);
				map.get(k)[element] = "O";
			}
		}
		if (orientation.equals("H") || orientation.equals("h")) {
			if (letter2Integer.get(columnHead) + 3 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 3; k++) {
				String row = rowHead;
				if (!map.get(Integer.parseInt(row))[k].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!");
				}
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 3; k++) {
				String row = rowHead;
				map.get(Integer.parseInt(row))[k] = "O";
			}
		}
	}
	
	public void addSubmarine(String coordinates, String orientation) {
		String columnHead = coordinates.substring(0, 1);
		String rowHead = "";
		if (coordinates.length()==3) rowHead = coordinates.substring(1);
		else rowHead = coordinates.substring(1, 2);
		if (orientation.equals("V") || orientation.equals("v")) {
			if (Integer.parseInt(rowHead) + 3 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 3; k++) {
				int element = letter2Integer.get(columnHead);
				if (!map.get(k)[element].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!"); 
				}
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 3; k++) {
				int element = letter2Integer.get(columnHead);
				map.get(k)[element] = "O";
			}
		}
		if (orientation.equals("H") || orientation.equals("h")) {
			if (letter2Integer.get(columnHead) + 3 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 3; k++) {
				String row = rowHead;
				if (!map.get(Integer.parseInt(row))[k].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!");
				}
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 3; k++) {
				String row = rowHead;
				map.get(Integer.parseInt(row))[k] = "O";
			}
		}
	}
	public void addDestroyer(String coordinates, String orientation) {
		String columnHead = coordinates.substring(0, 1);
		String rowHead = "";
		if (coordinates.length()==3) rowHead = coordinates.substring(1);
		else rowHead = coordinates.substring(1, 2);
		if (orientation.equals("V") || orientation.equals("v")) {
			if (Integer.parseInt(rowHead) + 2 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 2; k++) {
				int element = letter2Integer.get(columnHead);
				if (!map.get(k)[element].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!"); 
				}
			}
			for (int k = Integer.parseInt(rowHead); 
					k < Integer.parseInt(rowHead) + 2; k++) {
				int element = letter2Integer.get(columnHead);
				map.get(k)[element] = "O";
			}
		}
		if (orientation.equals("H") || orientation.equals("h")) {
			if (letter2Integer.get(columnHead) + 2 > 11) {
				throw new ArithmeticException("Out of bounds! Try again.");
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 2; k++) {
				String row = rowHead;
				if (!map.get(Integer.parseInt(row))[k].equals(".")) {
					throw new ArithmeticException("Unable to add; intersects another ship!");
				}
			}
			for (int k = letter2Integer.get(columnHead); 
					k < letter2Integer.get(columnHead) + 2; k++) {
				String row = rowHead;
				map.get(Integer.parseInt(row))[k] = "O";
			}
		}
	}
	
	public Boolean checkShot(String coordinates) {
		Integer column = letter2Integer.get((coordinates.substring(0, 1)));
		Integer row;
		if (coordinates.length()==3) row = Integer.parseInt(coordinates.substring(1));
		else row = Integer.parseInt(coordinates.substring(1, 2));
		if (map.get(row)[column].contentEquals("O")) {
			System.out.println("Hit!");
			map.get(row)[column] = "H";
			return true;
		}
		else if (map.get(row)[column].contentEquals(".")) {
			System.out.println("Miss!");
			map.get(row)[column] = "X";
		}
		else System.out.println("You already shot here...");
		return false;
	}
	
	public void updateOtherBoard(String coordinates, Boolean hit) {
		Integer column = letter2Integer.get((coordinates.substring(0, 1)));
		Integer row;
		if (coordinates.length()==3) row = Integer.parseInt(coordinates.substring(1));
		else row = Integer.parseInt(coordinates.substring(1, 2));
		if (hit) {
			map.get(row)[column] = "H";
		}
		else map.get(row)[column] = "X";
	}
	
	public boolean checkDefeat() {
		boolean defeat = true;
		for (Integer key : map.keySet()) {
			for (int k = 0; k < map.get(key).length; k++) {
				if (map.get(key)[k].equals("O")) defeat = false;
			}
		}
		return defeat;
	}
}
