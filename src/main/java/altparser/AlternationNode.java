package altparser;

public class AlternationNode implements ASTNode{
    ASTNode left, right;
    AlternationNode(ASTNode left, ASTNode right) {
        this.left= left;
        this.right= right;
    }
    @Override
    public void accept() {

    }
}
