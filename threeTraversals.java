import java.util.*;
public class threeTraversals {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.right = new TreeNode(8);

        PreInPostTraversal(root);
    }
    public static void PreInPostTraversal(TreeNode root){
        Stack<Pair> st=new Stack<Pair>();
        st.push(new Pair(root, 1));
        if(root==null) return;

        List<Integer> pre=new ArrayList<Integer>();
        List<Integer> in=new ArrayList<Integer>();
        List<Integer> post=new ArrayList<Integer>();

        while(!st.isEmpty()) {
            Pair it=st.pop();

            if(it.num==1){
                pre.add(it.node.val);
                it.num ++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num==2){
                in.add(it.node.val);
                it.num ++;
                st.push(it);
                if(it.node.right!=null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.val);
            }
        }
        System.out.println("PreOrder -> " + pre);
        System.out.println("InOrder -> " + in);
        System.out.println("PostOrder -> " + post);  
    }
}
class Pair{
    int num;
    TreeNode node;
           public Pair(TreeNode node,int num){
           this.num=num;
           this.node=node;
            }
    }
    class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
            public TreeNode(int val){
            this.val=val;
             }
     }
