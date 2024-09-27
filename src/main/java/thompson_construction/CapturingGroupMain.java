package thompson_construction;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.regexengine.EngineNFA;
import parser.regexLexer;

import java.io.IOException;
import java.util.Map;

public class CapturingGroupMain {
    public static void main(String[] args) throws IOException {
        String input = "(\\\\d\\\\d\\\\d)e+h";
        String testString = "123eeeeh";
        CharStream inputStream = CharStreams.fromString(input);
        regexLexer lexer = new regexLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        tokens.fill();
        BuildNFA buildNFA = new BuildNFA(tokens);
        try {
            buildNFA.parseQuantifiers();
            EngineNFA nfa = buildNFA.getFinalEngine();
            boolean matched = nfa.compute(testString);
            Map<Integer, String> capturedGroups = nfa.getCapturedGroupText();
            System.out.println("Match result: " + matched);
            System.out.println("Captured groups:");
            for (Map.Entry<Integer, String> entry : capturedGroups.entrySet()) {
                System.out.println("Group " + entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Error parsing regex: " + e.getMessage());
            e.printStackTrace();
        }
    }
}