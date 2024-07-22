// Generated from ./regex.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class regexLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BACKSLASH=2, ESCAPED_RESERVED_CHAR=3, CHARACTER_CLASS=4, OPEN_PAR=5, 
		CLOSE_PAR=6, ASTERISK=7, PLUS=8, DOT=9, QUESTION_MARK=10, OPEN_BRACKET=11, 
		CLOSE_BRACKET=12, DASH=13, GREATER_THAN=14, LOWER_THAN=15, COLON=16, CARET=17, 
		DOLLAR=18, CHAR=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "BACKSLASH", "ESCAPED_RESERVED_CHAR", "CHARACTER_CLASS", "OPEN_PAR", 
			"CLOSE_PAR", "ASTERISK", "PLUS", "DOT", "QUESTION_MARK", "OPEN_BRACKET", 
			"CLOSE_BRACKET", "DASH", "GREATER_THAN", "LOWER_THAN", "COLON", "CARET", 
			"DOLLAR", "CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'\\'", null, null, "'('", "')'", "'*'", "'+'", "'.'", "'?'", 
			"'['", "']'", "'-'", "'>'", "'<'", "':'", "'^'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BACKSLASH", "ESCAPED_RESERVED_CHAR", "CHARACTER_CLASS", 
			"OPEN_PAR", "CLOSE_PAR", "ASTERISK", "PLUS", "DOT", "QUESTION_MARK", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "DASH", "GREATER_THAN", "LOWER_THAN", 
			"COLON", "CARET", "DOLLAR", "CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public regexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "regex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\\\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000\u0001\u0006\u0000DDSSWW"+
		"ddsswwg\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003)\u0001\u0000"+
		"\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000"+
		"\t>\u0001\u0000\u0000\u0000\u000b@\u0001\u0000\u0000\u0000\rB\u0001\u0000"+
		"\u0000\u0000\u000fD\u0001\u0000\u0000\u0000\u0011F\u0001\u0000\u0000\u0000"+
		"\u0013H\u0001\u0000\u0000\u0000\u0015J\u0001\u0000\u0000\u0000\u0017L"+
		"\u0001\u0000\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bP\u0001\u0000"+
		"\u0000\u0000\u001dR\u0001\u0000\u0000\u0000\u001fT\u0001\u0000\u0000\u0000"+
		"!V\u0001\u0000\u0000\u0000#X\u0001\u0000\u0000\u0000%Z\u0001\u0000\u0000"+
		"\u0000\'(\u0005|\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005\\"+
		"\u0000\u0000*\u0004\u0001\u0000\u0000\u0000+9\u0003\u0003\u0001\u0000"+
		",:\u0003\u0003\u0001\u0000-:\u0003\t\u0004\u0000.:\u0003\u000b\u0005\u0000"+
		"/:\u0003\r\u0006\u00000:\u0003\u000f\u0007\u00001:\u0003\u0011\b\u0000"+
		"2:\u0003\u0015\n\u00003:\u0003\u0017\u000b\u00004:\u0003\u001b\r\u0000"+
		"5:\u0003\u001d\u000e\u00006:\u0003\u001f\u000f\u00007:\u0003!\u0010\u0000"+
		"8:\u0003#\u0011\u00009,\u0001\u0000\u0000\u00009-\u0001\u0000\u0000\u0000"+
		"9.\u0001\u0000\u0000\u00009/\u0001\u0000\u0000\u000090\u0001\u0000\u0000"+
		"\u000091\u0001\u0000\u0000\u000092\u0001\u0000\u0000\u000093\u0001\u0000"+
		"\u0000\u000094\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u000096\u0001"+
		"\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000"+
		":\u0006\u0001\u0000\u0000\u0000;<\u0003\u0003\u0001\u0000<=\u0007\u0000"+
		"\u0000\u0000=\b\u0001\u0000\u0000\u0000>?\u0005(\u0000\u0000?\n\u0001"+
		"\u0000\u0000\u0000@A\u0005)\u0000\u0000A\f\u0001\u0000\u0000\u0000BC\u0005"+
		"*\u0000\u0000C\u000e\u0001\u0000\u0000\u0000DE\u0005+\u0000\u0000E\u0010"+
		"\u0001\u0000\u0000\u0000FG\u0005.\u0000\u0000G\u0012\u0001\u0000\u0000"+
		"\u0000HI\u0005?\u0000\u0000I\u0014\u0001\u0000\u0000\u0000JK\u0005[\u0000"+
		"\u0000K\u0016\u0001\u0000\u0000\u0000LM\u0005]\u0000\u0000M\u0018\u0001"+
		"\u0000\u0000\u0000NO\u0005-\u0000\u0000O\u001a\u0001\u0000\u0000\u0000"+
		"PQ\u0005>\u0000\u0000Q\u001c\u0001\u0000\u0000\u0000RS\u0005<\u0000\u0000"+
		"S\u001e\u0001\u0000\u0000\u0000TU\u0005:\u0000\u0000U \u0001\u0000\u0000"+
		"\u0000VW\u0005^\u0000\u0000W\"\u0001\u0000\u0000\u0000XY\u0005$\u0000"+
		"\u0000Y$\u0001\u0000\u0000\u0000Z[\t\u0000\u0000\u0000[&\u0001\u0000\u0000"+
		"\u0000\u0002\u00009\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}