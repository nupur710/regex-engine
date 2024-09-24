import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.regexengine.EngineNFA;
import parser.regexLexer;
import thompson_construction.BuildNFA;

import java.io.IOException;

public class BuildNFATest {

    EngineNFA engineNFA;

    @Before
    public void init() {
        engineNFA= new EngineNFA();
    }

    public EngineNFA getEngineNFA(String input) throws IOException {
        CharStream inputStream= CharStreams.fromString(input);
        regexLexer lexer= new regexLexer(inputStream);
        CommonTokenStream tokens= new CommonTokenStream(lexer);

        tokens.fill();
//        for(Token token : tokens.getTokens()) {
//            System.out.println("Token: " + token.getText() + " Type: " + token.getType());
//        }

        BuildNFA buildNFA= new BuildNFA(tokens);
        buildNFA.parseQuantifiers();
        return buildNFA.getFinalEngine();
    }

    @Test
    public void testSingleChar() throws IOException {
        EngineNFA nfa= getEngineNFA("a");
        Assert.assertTrue(nfa.compute("a"));
    }

    @Test
    public void testCharacterConcatenation() throws IOException {
        EngineNFA nfa= getEngineNFA("abc");
        Assert.assertTrue(nfa.compute("abc"));
    }

    @Test
    public void testPlus() throws IOException {
        EngineNFA nfa= getEngineNFA("a+");
        Assert.assertFalse(nfa.compute(""));
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("aaaaa"));
        nfa= getEngineNFA("ab+");
        Assert.assertTrue(nfa.compute("abbbbbbb"));
        Assert.assertFalse(nfa.compute("a"));
        nfa= getEngineNFA("a+b");
        Assert.assertFalse(nfa.compute("b"));
        Assert.assertTrue(nfa.compute("ab"));
    }

    @Test
    public void testKleeneStar() throws IOException {
        EngineNFA nfa= getEngineNFA("a*");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("aaaaa"));
        Assert.assertTrue(nfa.compute(""));
        nfa= getEngineNFA("a*b");
        Assert.assertTrue(nfa.compute("b"));
        Assert.assertTrue(nfa.compute("ab"));
        Assert.assertTrue(nfa.compute("aaaaaaaab"));
        nfa= getEngineNFA("abc*");
        Assert.assertTrue(nfa.compute("ab"));
        Assert.assertTrue(nfa.compute("abccc"));
    }

    @Test
    public void testOptional() throws IOException {
        EngineNFA nfa= getEngineNFA("a?");
        Assert.assertTrue(nfa.compute(""));
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertFalse(nfa.compute("aaaaa"));
        nfa= getEngineNFA("a?b?c?");
        Assert.assertTrue(nfa.compute("abc"));
        Assert.assertTrue(nfa.compute(""));
        Assert.assertTrue(nfa.compute("ac"));
        Assert.assertFalse(nfa.compute("aabc"));
    }

    @Test
    public void testOr() throws IOException {
        EngineNFA nfa= getEngineNFA("a|b");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("b"));
        Assert.assertFalse(nfa.compute(""));
        nfa = getEngineNFA("a|b|c");
        Assert.assertTrue(nfa.compute("c"));
    }

    @Test
    public void testCombos() throws IOException {
        EngineNFA nfa= getEngineNFA("a+b?c+");
        Assert.assertTrue(nfa.compute("abc"));
        Assert.assertFalse(nfa.compute("bc"));
        nfa= getEngineNFA("a*b+c?");
        Assert.assertTrue(nfa.compute("aaabc"));
        Assert.assertTrue(nfa.compute("bc"));
        Assert.assertTrue(nfa.compute("bbbc"));
    }

    @Test
    public void testClassRange() throws IOException {
        EngineNFA nfa= getEngineNFA("[a-d]c");
        Assert.assertTrue(nfa.compute("bc"));
        nfa= getEngineNFA("[a-d]+c*");
        Assert.assertTrue(nfa.compute("c"));
        Assert.assertTrue(nfa.compute("ac"));
        nfa= getEngineNFA("[m-o]+");
        Assert.assertTrue(nfa.compute("mnmn"));
        nfa= getEngineNFA("[x-z]*g?");
        Assert.assertTrue(nfa.compute("yyyg"));
        Assert.assertTrue(nfa.compute("z"));
        Assert.assertFalse(nfa.compute("xyzgg"));
        nfa= getEngineNFA("[a-d]+[c-g]*");
        Assert.assertTrue(nfa.compute("dbbbggggd"));
        Assert.assertTrue(nfa.compute("dbbbe"));
        Assert.assertTrue(nfa.compute("dbbb"));
        Assert.assertTrue(nfa.compute("cdefg"));
        Assert.assertFalse(nfa.compute("efggg"));
        nfa= getEngineNFA("[a-d][c-g]");
        Assert.assertTrue(nfa.compute("de"));
        Assert.assertFalse(nfa.compute("d"));
    }

    @Test
    public void testPredefinedCharacterClasses() throws IOException {
        EngineNFA nfa= getEngineNFA("\\\\D");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertFalse(nfa.compute("1"));
        Assert.assertTrue(nfa.compute("@"));
        Assert.assertTrue(nfa.compute("X"));
        Assert.assertFalse(nfa.compute("ab"));
        nfa= getEngineNFA("\\\\D+");
        Assert.assertTrue(nfa.compute("abcXYZ"));
        Assert.assertFalse(nfa.compute("123"));
        Assert.assertTrue(nfa.compute("!@#"));
        nfa= getEngineNFA("\\\\w");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("1"));
        Assert.assertTrue(nfa.compute("_"));
        Assert.assertFalse(nfa.compute("@"));
        nfa = getEngineNFA("\\\\w+");
        Assert.assertTrue(nfa.compute("hello"));
        Assert.assertTrue(nfa.compute("hello_world"));
        Assert.assertTrue(nfa.compute("123"));
        Assert.assertFalse(nfa.compute("@#$%"));
        nfa = getEngineNFA("\\\\W");
        Assert.assertTrue(nfa.compute("@"));
        Assert.assertFalse(nfa.compute("a"));
        Assert.assertFalse(nfa.compute("1"));
        nfa = getEngineNFA("\\\\W+");
        Assert.assertTrue(nfa.compute("@#%"));
        Assert.assertFalse(nfa.compute("abc"));
        Assert.assertTrue(nfa.compute("!@#"));
        nfa = getEngineNFA("\\\\s");
        Assert.assertTrue(nfa.compute(" "));
        Assert.assertTrue(nfa.compute("\t"));
        Assert.assertTrue(nfa.compute("\n"));
        Assert.assertFalse(nfa.compute("abc"));
        nfa = getEngineNFA("\\\\s+");
        Assert.assertTrue(nfa.compute("   "));
        Assert.assertTrue(nfa.compute("\t\t"));
        Assert.assertFalse(nfa.compute("abc"));
        Assert.assertFalse(nfa.compute("abc "));
        nfa = getEngineNFA("\\\\S");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("1"));
        Assert.assertTrue(nfa.compute("@"));
        Assert.assertFalse(nfa.compute(" "));
        nfa = getEngineNFA("\\\\S+");
        Assert.assertTrue(nfa.compute("abc"));
        Assert.assertTrue(nfa.compute("!@#"));
        Assert.assertFalse(nfa.compute("  "));
        Assert.assertFalse(nfa.compute("  a  "));
        nfa = getEngineNFA("\\\\D+\\\\S");
        Assert.assertTrue(nfa.compute("abcX"));
        Assert.assertFalse(nfa.compute("123Y"));
        Assert.assertTrue(nfa.compute("!@#Z"));
        Assert.assertFalse(nfa.compute("abc "));
        nfa = getEngineNFA("\\\\S+\\\\s");
        Assert.assertTrue(nfa.compute("abc "));
        Assert.assertTrue(nfa.compute("xyz\t"));
        Assert.assertFalse(nfa.compute(" "));
        Assert.assertFalse(nfa.compute("\t"));
        nfa = getEngineNFA("\\\\w?");
        Assert.assertTrue(nfa.compute("a"));
        Assert.assertTrue(nfa.compute("1"));
        nfa = getEngineNFA("\\\\D*");
        Assert.assertTrue(nfa.compute("abc"));
        Assert.assertTrue(nfa.compute(""));
        Assert.assertFalse(nfa.compute("123"));
        nfa= getEngineNFA("\\\\w*l[j-m]+");
        Assert.assertTrue(nfa.compute("Abnm09lkkk"));
    }
}
