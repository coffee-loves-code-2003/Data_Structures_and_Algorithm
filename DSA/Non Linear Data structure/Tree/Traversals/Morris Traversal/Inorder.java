//Morris Traversal for the creation of threaded binary tree for inorder simulation
import java.util.*;
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data)
    {
        this.data=data;
    }
}
public class Inorder {
    public ArrayList<Integer> getInorder(TreeNode root)
    {
        //Creation of ArrayList
        ArrayList<Integer> inorder=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                inorder.add(curr.data);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=prev.right;
                }
                //Creating threats to its root follows inorder style Left Root Right
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                //If the data has been printed successfully remove the thread and print its root node of that sub tree
                else
                {
                    prev.right=null;
                    inorder.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return inorder;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right=new TreeNode(3);
        Inorder obj=new Inorder();
        System.out.print(obj.getInorder(root));
    }
}
