package altparser;

public class CharacterNode implements ASTNode{
    ASTNode left, right;
    CharacterNode(ASTNode left, ASTNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept() {

    }
}
