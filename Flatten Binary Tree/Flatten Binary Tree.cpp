// Flatten Binary Tree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <stack>
#include <vector>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {

public:
    void flatten(TreeNode* root)
	{
        stack<TreeNode*, vector<TreeNode*>> stackdata;
		TreeNode *node, *prevnode = NULL;

		if( root )
		{
			stackdata.push(root);
			while(stackdata.empty() == false)
			{
				node = stackdata.top();
				stackdata.pop();

				if(node->right) stackdata.push(node->right);
				if(node->left) stackdata.push(node->left);

				if(prevnode) prevnode->right = node;
				node->left = NULL;
				prevnode = node;
			}
		}
    }

	bool show(TreeNode* root)
	{
		cout << root->val << endl;
		while( root->right != NULL )
		{
			if( show( root->right ) )
				break;
		}
		return true;
	}

	TreeNode* clear(TreeNode* node)
	{
		while( node->right != NULL )
			node->right = clear( node->right );
		while( node->left != NULL )
			node->left = clear( node->left );
		if( node )
			delete node;
		node = NULL;

		return node;
	}
};

TreeNode* init()
{
	TreeNode *root, *node;
	root = new TreeNode(1);
	
	node = new TreeNode(2);
	root->left = node;
	node->left = new TreeNode(3);
	node->right = new TreeNode(4);
	
	node = new TreeNode(5);
	root->right = node;
	node->right = new TreeNode(6);

	return root;
}

int _tmain(int argc, _TCHAR* argv[])
{
	TreeNode* root = init();

	Solution solution;
	solution.flatten( root );
	solution.show( root );
	solution.clear( root );

	return 0;
}

