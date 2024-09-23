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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>>list =new ArrayList<>();
        if(root==null)
        {
            return new ArrayList<>();
        }
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer>l1=new ArrayList<>();
            int queueSize=queue.size();
            for(int i=0;i<queueSize;i++)
            {
                if(queue.peek().left!=null)
                {
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null)
                {
                    queue.add(queue.peek().right);
                }
                l1.add(queue.poll().val);
            }
            list.add(l1);
        }
            return list;

    }
}