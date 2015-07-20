package www.leetcode.com.ReverseInteger;

public class ReverseInteger {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int solve = solution.reverse( 123 );
		System.out.println( "결과 = " + solve );
		solve = solution.reverse( -123 );
		System.out.println( "결과 = " + solve );
		solve = solution.reverse( 1563847412 );
		System.out.println( "결과 = " + solve );
		System.out.println( "해답 = 0" );
		solve = solution.reverse( 2143847412 );
		System.out.println( "결과 = " + solve );
		System.out.println( "해답 = 2147483412" );
		solve = solution.reverse( -2147483412 ); 
		System.out.println( "결과 = " + solve );
		System.out.println( "해답 = -2143847412" );
		solve = solution.reverse( -2147483648 ); 
		System.out.println( "결과 = " + solve );
		System.out.println( "해답 = 0" );
	}

}

class Solution {
    public int reverse(int x) {
    	int result = 0;
    	if( x == 0 ) return result;
    	
    	int digit = 1;
        int value = x;        
        while( true ) {
        	if( value > 0 ) {
        		if( ( value / digit <= 9 ) && ( value / digit >= 1 ) )
            		break;	
        	} else {
        		if( ( value / digit >= -9 ) && ( value / digit <= -1 ) )
            		break;	
        	}        	
        	digit *= 10;
        }
        
        boolean minmax = false;
        if( value > 0 ) {
        	if( Integer.MAX_VALUE / digit < value % 10 )
        		minmax = true;
        } else {
        	if( Integer.MIN_VALUE / digit > value % 10 )
        		minmax = true;
        }
        while( true ) {
        	if( digit < 1 )
        		break;
           	if( minmax ) {
        		result = 0;
        		break;
        	}
        	
        	int rest = value % 10;
        	if( value > 0 ) {
        		if( Integer.MAX_VALUE - result < rest * digit )
        			minmax = true;
        	} else {
        		if( Integer.MIN_VALUE - result > rest * digit )
        			minmax = true;
        	}
        	
        	result += rest * digit;
        	value /= 10;
        	digit /= 10;
        }
    	
    	return result;
    }
}