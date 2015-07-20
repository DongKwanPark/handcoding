package leetcode.com.zigzagconversion;

class Solution {
	
	public String convert(String s, int numRows) {
		String result = "";
		if( numRows <= 0 ) return result;
		final int maxLength = s.length();
		
		for( int row = 0; row < numRows; row++ ) {
			int index = 0, valIndex = 0;
			while( true ) {
				if( (numRows <= 2) || (row == 0) || (numRows == row + 1) ) {
					if( numRows <= 1 ) {
						valIndex = index;	
					} else if( index % 2 == 0 ) {
						valIndex = (numRows - 1) * index + row;
					} else {
						index++;
						continue;
					}
				} else {
					if( index <= 0 ) {
						valIndex = row;
					} else if( index % 2 == 0 ) {
						valIndex = valIndex + (row * 2);
					} else {
						valIndex = valIndex + ((numRows - (row + 1)) * 2);
					}
				}
				if( valIndex < maxLength ) {
					char word = s.charAt( valIndex );
					result += Character.toString( word );
					index++;
				} else break;
			}
		}
		return result;
	}
}

public class ZigZagConversion {
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		String result = solution.convert("PAYPALISHIRING", 3); //-> ok
		//String result = solution.convert("ABCDE", 4); //-> ok
		//String result = solution.convert("ABC", 2); //-> ok
		//String result = solution.convert("AB", 1);
		//String result = solution.convert("ABCD", 3);
		System.out.println( result );
		System.out.println( "PAHNAPLSIIGYIR -> solve" );
	}

}


/*
int arrIndex = 0;
for( int index = 0; index < maxLength; index++ ) {
	if( row == 0 || (numRows == row + 1) ) {
		int col = ((numRows - 1) * index);
		arrIndex = col + row;
		if( index % 2 != 0 ) continue;
	} else {
		int col = index / numRows;
		if( col % 2 == 0 ) {
			arrIndex += (numRows - (row + 1)) * 2 + row;
		} else {
			arrIndex += (( row * 2 ) + index);
		}
		continue;
	}
	if( arrIndex < maxLength ) {
		char word = s.charAt( arrIndex );
		result += Character.toString( word );	
	}
}
*/
