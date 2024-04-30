package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class inorder {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode>obj=new Stack<>();
        List<Integer>l1=new ArrayList<>();
        if(root==null)
        {
            return l1;
        }
        while(true)
        {
            if(root!=null)
            {
                obj.push(root);
                root=root.left;
            }
            else
            {
                if(obj.isEmpty()==true)
                {
                    break;
                }
                root=obj.peek();
                l1.add(root.val);
                obj.pop();
                root=root.right;

            }

        }
        return l1;
    }
}
}
