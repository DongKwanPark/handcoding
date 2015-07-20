package www.leetcode.com.RectangleArea;

public class RectangleArea {	
	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		//int answer = solution.computerArea( -3, 0, 3, 4, 0, -1, 9, 2 );
		//int answer = solution.computerArea( -1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1 );
		int answer = solution.computerArea( -2, -2, 2, 2, 3, 3, 4, 4 );
		System.out.println( "사각형의 면적 = " + answer );
	}

}

class Solution {
	public int computerArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // A,E : LEFT, B,F : BOTTOM, C,G : RIGHT, D,H : TOP
		
		// LEFT : MAX
		// TOP : MIN
		// RIGHT : MIN
		// BOTTOM : MAX
		
		int result = 0;
		
		//int left = Math.max( A, E );
		int left = A > E ? A : E;
		//int top = Math.min( D, H );
		int top = D < H ? D : H;
		//int right = Math.min( C, G );
		int right = C < G ? C : G;
		//int bottom = Math.max( B, F );
		int bottom = B > F ? B : F;
		
		int rectangleOneArea = ( C - A ) * ( D - B );
		int rectangleTwoArea = ( G - E ) * ( H - F );
		result = rectangleOneArea + rectangleTwoArea;
		
		if( left < right && bottom < top ) {
			int coveredArea = ( right - left ) * ( top - bottom );
			if( coveredArea > 0 ) result -= coveredArea;
		}
				
		return result;
	}
}
