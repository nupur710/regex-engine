import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.regexengine.CharacterMatcher;
import org.regexengine.EngineNFA;
import org.regexengine.EpsilonMatcher;
import org.regexengine.State;

import java.util.ArrayList;
import java.util.List;

public class EngineNFATest {

    EngineNFA engineNFA;
    EngineNFA engineNFA2;

    @Before
    public void init() {
        buildEngine();
        buildEngine2();
    }

    public void buildEngine() {
        engineNFA= new EngineNFA();
        engineNFA.declareStates("q0", "q1", "q2", "q3");
        engineNFA.setInitialState(engineNFA.getStateObject("q0"));
        State q3= engineNFA.getStateObject("q3");
        List<State> finalStatesList= new ArrayList<>();
        finalStatesList.add(q3);
        engineNFA.setFinalStates(finalStatesList);
        engineNFA.addTransition(engineNFA.getStateObject("q0"), engineNFA.getStateObject("q1"), new CharacterMatcher('a'));
        engineNFA.addTransition(engineNFA.getStateObject("q1"), engineNFA.getStateObject("q2"), new CharacterMatcher('b'));
        engineNFA.addTransition(engineNFA.getStateObject("q2"), engineNFA.getStateObject("q2"), new CharacterMatcher('b'));
        engineNFA.addTransition(engineNFA.getStateObject("q2"), engineNFA.getStateObject("q3"), new EpsilonMatcher());
    }

    public void buildEngine2() {
        engineNFA2= new EngineNFA();
        engineNFA2.declareStates("q0", "q1", "q2");
        engineNFA2.setInitialState(engineNFA2.getStateObject("q0"));
        State q3= engineNFA2.getStateObject("q2");
        List<State> finalStatesList= new ArrayList<>();
        finalStatesList.add(q3);
        engineNFA2.setFinalStates(finalStatesList);
        engineNFA2.addTransition(engineNFA2.getStateObject("q0"), engineNFA2.getStateObject("q1"), new CharacterMatcher('a'));
        engineNFA2.addTransition(engineNFA2.getStateObject("q1"), engineNFA2.getStateObject("q1"), new EpsilonMatcher());
        engineNFA2.addTransition(engineNFA2.getStateObject("q1"), engineNFA2.getStateObject("q2"), new CharacterMatcher('b'));
    }

    @Test
    public void computeMemoryTest() {
        Assert.assertTrue(engineNFA2.compute("ab"));
    }

    @Test
    public void computeTest() {
        Assert.assertTrue(engineNFA.compute("abbbbbb"));
        Assert.assertFalse(engineNFA.compute("aabbbbbb"));
        Assert.assertTrue(engineNFA.compute("ab"));
        Assert.assertFalse(engineNFA.compute("a"));
        Assert.assertFalse(engineNFA.compute("abc"));
    }

}
