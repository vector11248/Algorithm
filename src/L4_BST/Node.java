package L4_BST;

/**
 * @program: Leetcode
 * @description:
 * @author: Wangky
 * @create: 2018-05-23 08:27
 **/
public class Node {
    private int val;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int val) {
        this.val = val;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node parent) {
        this.val = val;
        this.parent = parent;
    }

    public Node(int val, Node parent, Node left, Node right) {
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.parent = this;
        this.left = left;
        this.right = right;
    }

    private  Node find(int val){
        // output:find the Node with key val from the subtree rooted at this Node
        // input:val:the key of the node  we want to find
        if(this.val == val){
            return this;
        }
        else if(this.val > val){
            // find left subtree
            if(this.left==null){
                return null;
            }else {
                return left.find(val);
            }

        }
        else {
            if(this.right == null){
                return null;
            }else {
                return right.find(val);
            }
        }

    }

    private Node findMin(){
        // return the node with the minimum key in this subtree rooted at this
        // returns the node with the minimum key
        Node current = this;
        while (current.left!=null){
            current = current.left;
        }
        return current;
    }

    private Node nextLarger(){
        // return the node with the larger key in the subtree
        if(this.right!=null){
            return this.right.findMin();
        }
        Node current = this;
        while (current.parent!=null && current==current.parent.right){
            current = current.parent;
        }
        return current.parent;
    }

    private void insert(Node node){
        // insert a node into the subtree rooted at current node
        // node:node to be inserted
        if(node == null){
            return;
        }
        if( node.val <= this.val){
            if(this.left == null){
                this.left = node;
                node.parent = this;
            }else {
                this.left.insert(node);
            }
        }
        else {
            if(this.right == null){
                this.right = node;
                node.parent = this;
            }else {
                this.right.insert(node);
            }
        }
        return;

    }

    private void delete(){
        /*
            case1:node x has no children,just delete it(i.e,change its parent node so
                    that it doesn't point to x)
            case2:node x has one child,Splice out x by linking x's parent and x's child
            case3:node x has two children,Splice out x's successor and replace x with x's successor
         */

        // Case # 1 && #2

        if( this.left == null || this.right == null){
            if(this == this.parent.left) {
                // if this node is root ?? this parent ?

                // well,it will goes on 'else' path
                Node next = (this.left!=null)?this.left:this.right;//neither left nor right are null ,still ok
                if(next != null){
                    this.parent.left = next;
                    next.parent = this.parent;
                }else {
                    this.parent.left = null;
                }
            }
            else {
                Node next = (this.left!=null)?this.left:this.right;//neither left nor right are null ,still ok
                if(next != null){
                    this.parent.right = next;
                    next.parent = this.parent;
                }else {
                    this.parent.right = null;
                }
            }
            return;
        }

        // case #3 the node x has two children
        // splice out x's successor and replace x with x's successor
        else {
            Node successor = nextLarger();
            int temp = this.val;
            this.val = successor.val;
            successor.val = temp;

            // splice
            successor.delete();

        }

    }


    public static void main(String[] args) {
        // init a root;
        Node root = new Node(5,null,null,null);
//        for (int i = 0; i <10 ; i++) {
//            Node node = new Node(i);
//            root.insert(node);
//        }
//        Node toDelete0 = root.find(0);
//        Node toDelete1 = root.find(1);
//
//
//        if(toDelete0!=null && toDelete1!=null){
//            toDelete0.delete();
//            toDelete1.delete();
//        }

        //System.out.println(root.findMin().val);

        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.insert(node4);
        root.insert(node6);
        root.insert(node7);
        System.out.println(root.right.val);
        System.out.println(node6.right.val);

//        System.out.println(root.parent);
//        System.out.println(node6.parent.val);
//        System.out.println(node7.nextLarger().val);
//        Node current = node4;
//        while (current!=null){
//            System.out.println(current.val);
//            current = current.nextLarger();
//        }



//        Node cur = root.find(5);
//        cur.delete();
//        Node nextL = cur.nextLarger();
//        System.out.println(nextL.val);
//        System.out.println(node4.nextLarger().val);
//        System.out.println(node4.parent.val);

    }


}
