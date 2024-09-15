package altparser;

public class KleenePlus implements ASTNode {
    ASTNode left, right;
    KleenePlus(ASTNode left, ASTNode right) {
        this.left= left;
        this.right= right;
    }
    @Override
    public void accept() {

    }
}
