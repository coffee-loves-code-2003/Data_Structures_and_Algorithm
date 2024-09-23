package Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class postorder {
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
    public List<Integer> getOutput(TreeNode root, Stack<TreeNode>stack,List<Integer>list)
    {
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty())
        {
            if(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            else
            {
                TreeNode temp_right=stack.peek().right;
                if(temp_right==null)
                {
                    temp_right=stack.peek();
                    stack.pop();
                    list.add(temp_right.val);
                    while(!stack.isEmpty() && temp_right==stack.peek().right)
                    {
                        temp_right=stack.peek();
                        list.add(temp_right.val);
                        stack.pop();

                    }

                }
                else
                {
                    curr=temp_right;
                }
            }
        }
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer>list=new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        Stack<TreeNode>stack=new Stack<>();
        Solution obj=new Solution();
        return obj.getOutput(root,stack,list);
    }
}
}
