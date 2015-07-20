package www.leetcode.com.RomantoInteger;

import java.util.HashMap;


public class RomantoInteger {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int value = 0;
		String str = null;
		
		str = "MMCCCIX";	// 2309
		System.out.println( "로마숫자 " + str + "을 변환한 숫자는 " + solution.romanToInt( str ) );
		
		str = "CMXCIX";	// 999
		System.out.println( "로마숫자 " + str + "을 변환한 숫자는 " + solution.romanToInt( str ) );
		
		str = "ii";	// 0
		System.out.println( "로마숫자 " + str + "을 변환한 숫자는 " + solution.romanToInt( str ) );
	}

}

class Solution {
	
	public int romanToInt(String s) {
		int result = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put( 'I', 1 );
		map.put( 'V', 5 );
		map.put( 'X', 10 );
		map.put( 'L', 50 );
		map.put( 'C', 100 );
		map.put( 'D', 500 );
		map.put( 'M', 1000 );
		
		int count = s.length();
		for( int i = 0; i < count; i++ ) {
			Character roman = s.charAt( i );
			Integer value = map.get( roman );
			if( value == null ) {
				value = 0;
				continue;
			}
			if( i + 1 < count ) {
				Character nextroman = s.charAt( i + 1 );
				if( roman == 'I' && ( nextroman == 'V' || nextroman == 'X' ) )
					value *= -1;
				if( roman == 'X' && ( nextroman == 'L' || nextroman == 'C' ) )
					value *= -1;
				if( roman == 'C' && ( nextroman == 'D' || nextroman == 'M' ) )
					value *= -1;
			}
			result += value;
		}
		
		return result;
	}
}

/*
class Solution {

	private HashMap<Character, Integer> mapRomanValue = new HashMap<Character, Integer>();
	
	public Solution() {
		InitRomanValue();
	}
	
	public int romanToInt(String s) {
		int result = 0;
		
		int count = s.length();
		for( int i = 0; i < count; i++ ) {
			Character roman = s.charAt( i );
			int value = GetRomanValue( roman );
			if( i + 1 < count ) {
				Character nextroman = s.charAt( i + 1 );
				if( roman == 'I' && ( nextroman == 'V' || nextroman == 'X' ) )
					value *= -1;
				if( roman == 'X' && ( nextroman == 'L' || nextroman == 'C' ) )
					value *= -1;
				if( roman == 'C' && ( nextroman == 'D' || nextroman == 'M' ) )
					value *= -1;
			}
			result += value;
		}
		
		return result;
	}
	
	private void InitRomanValue() {
		mapRomanValue.put( 'I', 1 );
		mapRomanValue.put( 'V', 5 );
		mapRomanValue.put( 'X', 10 );
		mapRomanValue.put( 'L', 50 );
		mapRomanValue.put( 'C', 100 );
		mapRomanValue.put( 'D', 500 );
		mapRomanValue.put( 'M', 1000 );
	}
	
	private int GetRomanValue(Character key) {
		Integer value = mapRomanValue.get( key );
		if( value == null )	value = 0;
		return value;
	}
}
*/

