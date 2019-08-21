import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OtherBoardPerspective {
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
	
	public OtherBoardPerspective() {
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
}
