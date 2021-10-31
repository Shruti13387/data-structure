public class BSTInsertion {

    private Node root;

    public static void main(String[] args) {
        BSTInsertion bsT = new BSTInsertion();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        bsT.printTree(bsT.getRoot());
    }

    private Node getRoot() {
        return root;
    }

    public boolean add(int data){
        if(root == null){
            root = new Node(data);
            return true;
        }else {
            return insertChildNode(data, root);
        }
    }

    public boolean insertChildNode(int data, Node root){

        if(root.getLeftNode() == null && root.getData()>data){
            root.setLeftNode(new Node(data));
            return true;
        }
        if(root.getRightNode() ==null && root.getData()<data){
            root.setRightNode(new Node(data));
            return true;
        }

        if(root.getLeftNode() != null && root.getData()>data){
            insertChildNode(data,root.getLeftNode());
        }
        if(root.getRightNode()!=null && root.getData()<data){
            insertChildNode(data,root.getRightNode());
        }

        return false;
    }


    //Just for Testing purpose
    public void printTree(Node current)
    {
        if (current == null) return;

        System.out.print(current.getData() + ",");
        printTree(current.getLeftNode());
        printTree(current.getRightNode());

    }
}
