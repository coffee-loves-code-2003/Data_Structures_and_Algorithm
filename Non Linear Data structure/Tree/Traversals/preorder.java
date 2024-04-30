package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class preorder {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode>obj=new Stack<>();
        List<Integer>l1=new ArrayList<>();
        if(root==null)
        {
            return l1;
        }
        obj.push(root);
        while(!obj.isEmpty())
        {
            TreeNode temp=obj.pop();
            l1.add(temp.val);
            if(temp.right!=null)
            {
                obj.push(temp.right);
            }
            if(temp.left!=null)
            {
                obj.push(temp.left);
            }

        }
        return l1;

    }
}
}
