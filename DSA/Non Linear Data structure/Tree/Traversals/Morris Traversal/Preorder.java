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
public class Preorder {
    public ArrayList<Integer> getPreorder(TreeNode root)
    {
        //Creation of ArrayList
        ArrayList<Integer> preorder=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                preorder.add(curr.data);
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
                    //adding the node once the thread has been formed
                    preorder.add(curr.data);

                    curr=curr.left;
                }
                //If the data has been printed successfully remove the thread 
                else
                {
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return preorder;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right=new TreeNode(3);
        Preorder obj=new Preorder();
        System.out.print(obj.getPreorder(root));
    }
}