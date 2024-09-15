package altparser;

public class OptionalNode implements ASTNode{
    ASTNode left, right;
    OptionalNode(ASTNode left, ASTNode right) {
        this.left=left;
        this.right= right;
    }
    @Override
    public void accept() {

    }
}
