//http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/

package topTenAlgorithm;

import java.util.Iterator;
import static java.lang.System.*;

public class Boggle {
	public static void main(String[] args) {
		String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };
		char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' },
				{ 'Q', 'S', 'E' } };
		// String a = "GOD";
		FindWord fw = new FindWord(dictionary, boggle);
		for (int i = 0; i < dictionary.length; i++) {
			if (fw.isWord(dictionary[i])) {
				out.printf("%s ", dictionary[i]);
			}
		}
	}
}

class FindWord {
	String[] dic;
	char[][] bog;
	int D, row, col;

	FindWord(String[] dictionary, char[][] boggle) {
		dic = dictionary;
		bog = boggle;
		D = dic.length;
		row = bog.length;
		col = bog[0].length;
	}

	boolean isWord(String word) {
		char[] w = word.toCharArray();
		boolean corr = false;
		int r = 0, c = 0;
		int bond = w.length; 
		for (r = 0; r < row; r++) {
			for (c = 0; c < col; c++) {
				if (bog[r][c] == w[0]) {
					corr = true;
					break;
				}
			}
			if (corr == true)
				break;
		}
		//out.printf("r=%d, c=%d\n", r, c);
		
		for (int i = 1; i < bond; i++) {
			
			
			if (corr == false)
				break;

			corr = false;
			boolean Up = false, Down = false, Right = false, Left = false;
			if (c + 1 < col) {
				Right = true;
			}
			if (c - 1 >= 0) {
				Left = true;
			}
			if (r + 1 < row) {
				Down = true;
			}
			if (r - 1 >= 0) {
				Up = true;
			}
			//out.printf("U:%b D:%b L:%b R:%b\n",Up,Down,Left,Right);
			if (Up && bog[r - 1][c] == w[i]) {
				//out.println("Up");
				corr = true;
				r = r - 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Down && bog[r + 1][c] == w[i]) {
				//out.println("Down");
				corr = true;
				r = r + 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Left && bog[r][c - 1] == w[i]) {
				//out.println("Left");
				corr = true;
				c = c - 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;

			} else if (Right && bog[r][c + 1] == w[i]) {
				//out.println("Right");
				corr = true;
				c = c + 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Up && Right && bog[r - 1][c + 1] == w[i]) {
				//out.println("Up Right");
				corr = true;
				c = c + 1;
				r = r - 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Up && Left && bog[r - 1][c - 1] == w[i]) {
				//out.println("Up left");
				corr = true;
				c = c - 1;
				r = r - 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Down && Right && bog[r + 1][c + 1] == w[i]) {
				//out.println("Down Right");
				corr = true;
				c = c + 1;
				r = r + 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			} else if (Down && Left && bog[r + 1][c - 1] == w[i]) {
				//out.println("Down Left");
				corr = true;
				c = c - 1;
				r = r + 1;
				//out.printf("r=%d, c=%d\n", r, c);
				continue;
			}
			//out.println(corr);
		}
		return corr;
	}
}