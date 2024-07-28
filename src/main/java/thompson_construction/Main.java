package thompson_construction;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.regexengine.EngineNFA;
import parser.regexLexer;
import parser.regexParser;

public class Main {
    public static void main(String[] args) {
        String input="ab+";
        CharStream inputStream= CharStreams.fromString(input);
        regexLexer lexer= new regexLexer(inputStream);
        CommonTokenStream tokens= new CommonTokenStream(lexer);

        tokens.fill();
        for(Token token : tokens.getTokens()) {
            System.out.println("Token: " + token.getText() + " Type: " + token.getType());
        }

        BuildNFA buildNFA= new BuildNFA(tokens);
        buildNFA.parseQuantifiers();
        EngineNFA nfa= buildNFA.getFinalEngine();
        System.out.println(nfa.compute("abbb"));
    }
}
