package www.leetcode.com.PalindromeNumber;

public class PalindromeNumber {

	public static void main(String[] args) {

		Solution solution = new Solution();
		
		int number = 12321;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
		
		number = 56788765;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
		
		number = -2147447412;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
		
		number = 0;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
		
		number = 10;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
		
		number = 131000;
		if( solution.isPalindrome( number ) )
			System.out.println( number + "�� ȸ������ �Դϴ�." );
		else
			System.out.println( number + "�� ȸ�����ڰ� �ƴմϴ�." );
	}

}

class Solution {
		
	public boolean isPalindrome(int x) {
		
		boolean result = false;
		if( Integer.MAX_VALUE < x )
			return result;
		if( 0 > x )
			return result;
		if( 10 > x )
			return true;
		
		int value = x;
		int digit = 1;
		int PalindromeNumber = 0;
		
		while( true ) {
			PalindromeNumber *= 10;
			PalindromeNumber += ( value % 10 );
			value /= 10;
			
			if( value == PalindromeNumber ) {
				result = true;
				break;
			}
			if( PalindromeNumber > value ) {
				if( ( PalindromeNumber / digit ) > 0 ) {
					PalindromeNumber /= 10;
					if( PalindromeNumber == value )
						result = true;
				}
				break;
			}
			digit *= 10;
		}
		
        return result;
    }
}







