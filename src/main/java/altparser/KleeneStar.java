package altparser;

public class KleeneStar implements ASTNode{
    ASTNode left, right;
    KleeneStar(ASTNode left, ASTNode right) {
        this.left= left;
        this.right= right;
    }
    @Override
    public void accept() {

    }
}
