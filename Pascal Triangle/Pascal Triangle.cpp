// Pascal Triangle.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <vector>
using namespace std;
typedef vector<vector<int>> vVectorData;

class Solution
{
public :
	Solution() { }
	virtual ~Solution() { }

	vVectorData generate(int numRows);
	void show(vVectorData result);
};

vVectorData Solution::generate(int numRows)
{

	// 规过1
// 	vVectorData result;
// 	result.clear();
// 
// 	for( int rows = 0; rows < numRows; rows++ )
// 	{
// 		vector<int> data;
// 		data.push_back( 1 );
// 
// 		unsigned index = 0;
// 		for( vVectorData::iterator iter = result.begin(); iter != result.end(); iter++, index++ )
// 		{
// 			vVectorData::iterator prevvector = result.begin() + rows - 1;
// 			vector<int> prevdata = *prevvector;
// 			vector<int>::iterator previter = prevdata.begin() + index;
// 			if( prevdata.size() > index + 1 )
// 			{
// 				int value1 = *previter;
// 				int value2 = *(previter + 1);
// 				data.push_back( value1 + value2 );
// 			}
// 			if( (iter + 1) == result.end() )
// 				data.push_back( 1 );
// 		}
// 		result.push_back( data );
// 	}
// 
// 	return result;


	// 规过2
	vVectorData result;
	
	for( int i = 0; i < numRows; i++ )
	{
		vector<int> data;
		data.push_back( 1 );
		for( int j = 0; j < i; j++ )
		{
			if( i <= j + 1 )
			{
				data.push_back( 1 );
				break;
			}
			data.push_back( result[i-1][j] + result[i-1][j+1] );
		}
		result.push_back( data );
	}

	return result;
}

void Solution::show(vVectorData result)
{
	int size = result.size();
	for( int i = 0; i < size; i++ )
	{
		vector<int> data = result[i];
		int count = data.size();
		for( int j = 0; j < count; j++ )
		{
			printf( "%d", result[i][j] );
		}
		printf( "\n" );
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	Solution solution;
	vVectorData data = solution.generate( 10 );
	solution.show( data );

	return 0;
}

