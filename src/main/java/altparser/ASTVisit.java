package altparser;
//alternate parsing using Shunting Yard algo
public interface ASTVisit {

    void visitConcat();
    void visitKleeneStar();
    void visitAlternation();
    void visitChar();
}
