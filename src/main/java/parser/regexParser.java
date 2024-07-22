// Generated from ./regex.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class regexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BACKSLASH=2, ESCAPED_RESERVED_CHAR=3, CHARACTER_CLASS=4, OPEN_PAR=5, 
		CLOSE_PAR=6, ASTERISK=7, PLUS=8, DOT=9, QUESTION_MARK=10, OPEN_BRACKET=11, 
		CLOSE_BRACKET=12, DASH=13, GREATER_THAN=14, LOWER_THAN=15, COLON=16, CARET=17, 
		DOLLAR=18, CHAR=19;
	public static final int
		RULE_main = 0, RULE_regex = 1, RULE_alternative = 2, RULE_expr = 3, RULE_subexpr = 4, 
		RULE_regexGroup = 5, RULE_complexCharacterClass = 6, RULE_complexCCPiece = 7, 
		RULE_allowedCharInCharacterClass = 8, RULE_atomicChar = 9, RULE_quantifier = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "regex", "alternative", "expr", "subexpr", "regexGroup", "complexCharacterClass", 
			"complexCCPiece", "allowedCharInCharacterClass", "atomicChar", "quantifier"
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

	@Override
	public String getGrammarFileName() { return "regex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public regexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public TerminalNode EOF() { return getToken(regexParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			regex();
			setState(23);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegexContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<AlternativeContext> alternative() {
			return getRuleContexts(AlternativeContext.class);
		}
		public AlternativeContext alternative(int i) {
			return getRuleContext(AlternativeContext.class,i);
		}
		public RegexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterRegex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitRegex(this);
		}
	}

	public final RegexContext regex() throws RecognitionException {
		RegexContext _localctx = new RegexContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_regex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047096L) != 0)) {
				{
				{
				setState(25);
				expr();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(31);
				alternative();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlternativeContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitAlternative(this);
		}
	}

	public final AlternativeContext alternative() throws RecognitionException {
		AlternativeContext _localctx = new AlternativeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alternative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__0);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047096L) != 0)) {
				{
				{
				setState(38);
				expr();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public SubexprContext subexpr() {
			return getRuleContext(SubexprContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			subexpr();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1408L) != 0)) {
				{
				setState(45);
				quantifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubexprContext extends ParserRuleContext {
		public SubexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subexpr; }
	 
		public SubexprContext() { }
		public void copyFrom(SubexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotPatternContext extends SubexprContext {
		public TerminalNode DOT() { return getToken(regexParser.DOT, 0); }
		public DotPatternContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterDotPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitDotPattern(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupPatternContext extends SubexprContext {
		public RegexGroupContext regexGroup() {
			return getRuleContext(RegexGroupContext.class,0);
		}
		public GroupPatternContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterGroupPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitGroupPattern(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharacterClassContext extends SubexprContext {
		public TerminalNode CHARACTER_CLASS() { return getToken(regexParser.CHARACTER_CLASS, 0); }
		public CharacterClassContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterCharacterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitCharacterClass(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComplexClassContext extends SubexprContext {
		public ComplexCharacterClassContext complexCharacterClass() {
			return getRuleContext(ComplexCharacterClassContext.class,0);
		}
		public ComplexClassContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterComplexClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitComplexClass(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaretAnchorContext extends SubexprContext {
		public TerminalNode CARET() { return getToken(regexParser.CARET, 0); }
		public CaretAnchorContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterCaretAnchor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitCaretAnchor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DollarAnchorContext extends SubexprContext {
		public TerminalNode DOLLAR() { return getToken(regexParser.DOLLAR, 0); }
		public DollarAnchorContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterDollarAnchor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitDollarAnchor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EscapedReservedAtomicPatternContext extends SubexprContext {
		public TerminalNode ESCAPED_RESERVED_CHAR() { return getToken(regexParser.ESCAPED_RESERVED_CHAR, 0); }
		public EscapedReservedAtomicPatternContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterEscapedReservedAtomicPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitEscapedReservedAtomicPattern(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomicPatternContext extends SubexprContext {
		public AtomicCharContext atomicChar() {
			return getRuleContext(AtomicCharContext.class,0);
		}
		public AtomicPatternContext(SubexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterAtomicPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitAtomicPattern(this);
		}
	}

	public final SubexprContext subexpr() throws RecognitionException {
		SubexprContext _localctx = new SubexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_subexpr);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				_localctx = new GroupPatternContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				regexGroup();
				}
				break;
			case CLOSE_BRACKET:
			case DASH:
			case GREATER_THAN:
			case LOWER_THAN:
			case COLON:
			case CHAR:
				_localctx = new AtomicPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				atomicChar();
				}
				break;
			case ESCAPED_RESERVED_CHAR:
				_localctx = new EscapedReservedAtomicPatternContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(ESCAPED_RESERVED_CHAR);
				}
				break;
			case CHARACTER_CLASS:
				_localctx = new CharacterClassContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				match(CHARACTER_CLASS);
				}
				break;
			case OPEN_BRACKET:
				_localctx = new ComplexClassContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				complexCharacterClass();
				}
				break;
			case DOLLAR:
				_localctx = new DollarAnchorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				match(DOLLAR);
				}
				break;
			case CARET:
				_localctx = new CaretAnchorContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				match(CARET);
				}
				break;
			case DOT:
				_localctx = new DotPatternContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				match(DOT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegexGroupContext extends ParserRuleContext {
		public Token CHAR;
		public List<Token> name = new ArrayList<Token>();
		public Token nonCapture;
		public TerminalNode OPEN_PAR() { return getToken(regexParser.OPEN_PAR, 0); }
		public RegexContext regex() {
			return getRuleContext(RegexContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(regexParser.CLOSE_PAR, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(regexParser.QUESTION_MARK, 0); }
		public TerminalNode COLON() { return getToken(regexParser.COLON, 0); }
		public TerminalNode LOWER_THAN() { return getToken(regexParser.LOWER_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(regexParser.GREATER_THAN, 0); }
		public List<TerminalNode> CHAR() { return getTokens(regexParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(regexParser.CHAR, i);
		}
		public RegexGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterRegexGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitRegexGroup(this);
		}
	}

	public final RegexGroupContext regexGroup() throws RecognitionException {
		RegexGroupContext _localctx = new RegexGroupContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_regexGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(OPEN_PAR);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION_MARK) {
				{
				setState(59);
				match(QUESTION_MARK);
				setState(68);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LOWER_THAN:
					{
					{
					setState(60);
					match(LOWER_THAN);
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(61);
						((RegexGroupContext)_localctx).CHAR = match(CHAR);
						((RegexGroupContext)_localctx).name.add(((RegexGroupContext)_localctx).CHAR);
						}
						}
						setState(64); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CHAR );
					setState(66);
					match(GREATER_THAN);
					}
					}
					break;
				case COLON:
					{
					setState(67);
					((RegexGroupContext)_localctx).nonCapture = match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(72);
			regex();
			setState(73);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComplexCharacterClassContext extends ParserRuleContext {
		public Token negated;
		public TerminalNode OPEN_BRACKET() { return getToken(regexParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(regexParser.CLOSE_BRACKET, 0); }
		public List<ComplexCCPieceContext> complexCCPiece() {
			return getRuleContexts(ComplexCCPieceContext.class);
		}
		public ComplexCCPieceContext complexCCPiece(int i) {
			return getRuleContext(ComplexCCPieceContext.class,i);
		}
		public TerminalNode CARET() { return getToken(regexParser.CARET, 0); }
		public ComplexCharacterClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexCharacterClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterComplexCharacterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitComplexCharacterClass(this);
		}
	}

	public final ComplexCharacterClassContext complexCharacterClass() throws RecognitionException {
		ComplexCharacterClassContext _localctx = new ComplexCharacterClassContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_complexCharacterClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(OPEN_BRACKET);
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(76);
				((ComplexCharacterClassContext)_localctx).negated = match(CARET);
				}
				break;
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1044456L) != 0)) {
				{
				{
				setState(79);
				complexCCPiece();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(CLOSE_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComplexCCPieceContext extends ParserRuleContext {
		public List<AllowedCharInCharacterClassContext> allowedCharInCharacterClass() {
			return getRuleContexts(AllowedCharInCharacterClassContext.class);
		}
		public AllowedCharInCharacterClassContext allowedCharInCharacterClass(int i) {
			return getRuleContext(AllowedCharInCharacterClassContext.class,i);
		}
		public TerminalNode DASH() { return getToken(regexParser.DASH, 0); }
		public ComplexCCPieceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexCCPiece; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterComplexCCPiece(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitComplexCCPiece(this);
		}
	}

	public final ComplexCCPieceContext complexCCPiece() throws RecognitionException {
		ComplexCCPieceContext _localctx = new ComplexCCPieceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_complexCCPiece);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			allowedCharInCharacterClass();
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(88);
				match(DASH);
				setState(89);
				allowedCharInCharacterClass();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllowedCharInCharacterClassContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(regexParser.CHAR, 0); }
		public TerminalNode DASH() { return getToken(regexParser.DASH, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(regexParser.OPEN_BRACKET, 0); }
		public TerminalNode OPEN_PAR() { return getToken(regexParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(regexParser.CLOSE_PAR, 0); }
		public TerminalNode ASTERISK() { return getToken(regexParser.ASTERISK, 0); }
		public TerminalNode PLUS() { return getToken(regexParser.PLUS, 0); }
		public TerminalNode DOT() { return getToken(regexParser.DOT, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(regexParser.QUESTION_MARK, 0); }
		public TerminalNode ESCAPED_RESERVED_CHAR() { return getToken(regexParser.ESCAPED_RESERVED_CHAR, 0); }
		public TerminalNode GREATER_THAN() { return getToken(regexParser.GREATER_THAN, 0); }
		public TerminalNode LOWER_THAN() { return getToken(regexParser.LOWER_THAN, 0); }
		public TerminalNode COLON() { return getToken(regexParser.COLON, 0); }
		public TerminalNode CARET() { return getToken(regexParser.CARET, 0); }
		public TerminalNode DOLLAR() { return getToken(regexParser.DOLLAR, 0); }
		public AllowedCharInCharacterClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allowedCharInCharacterClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterAllowedCharInCharacterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitAllowedCharInCharacterClass(this);
		}
	}

	public final AllowedCharInCharacterClassContext allowedCharInCharacterClass() throws RecognitionException {
		AllowedCharInCharacterClassContext _localctx = new AllowedCharInCharacterClassContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_allowedCharInCharacterClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1044456L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomicCharContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(regexParser.CHAR, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(regexParser.CLOSE_BRACKET, 0); }
		public TerminalNode DASH() { return getToken(regexParser.DASH, 0); }
		public TerminalNode GREATER_THAN() { return getToken(regexParser.GREATER_THAN, 0); }
		public TerminalNode LOWER_THAN() { return getToken(regexParser.LOWER_THAN, 0); }
		public TerminalNode COLON() { return getToken(regexParser.COLON, 0); }
		public AtomicCharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicChar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterAtomicChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitAtomicChar(this);
		}
	}

	public final AtomicCharContext atomicChar() throws RecognitionException {
		AtomicCharContext _localctx = new AtomicCharContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomicChar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 651264L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuantifierContext extends ParserRuleContext {
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
	 
		public QuantifierContext() { }
		public void copyFrom(QuantifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LazyAsteriskQuantifierContext extends QuantifierContext {
		public TerminalNode ASTERISK() { return getToken(regexParser.ASTERISK, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(regexParser.QUESTION_MARK, 0); }
		public LazyAsteriskQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterLazyAsteriskQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitLazyAsteriskQuantifier(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LazyPlusQuantifierContext extends QuantifierContext {
		public TerminalNode PLUS() { return getToken(regexParser.PLUS, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(regexParser.QUESTION_MARK, 0); }
		public LazyPlusQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterLazyPlusQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitLazyPlusQuantifier(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuestionQuantifierContext extends QuantifierContext {
		public TerminalNode QUESTION_MARK() { return getToken(regexParser.QUESTION_MARK, 0); }
		public QuestionQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterQuestionQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitQuestionQuantifier(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LazyQuestionQuantifierContext extends QuantifierContext {
		public List<TerminalNode> QUESTION_MARK() { return getTokens(regexParser.QUESTION_MARK); }
		public TerminalNode QUESTION_MARK(int i) {
			return getToken(regexParser.QUESTION_MARK, i);
		}
		public LazyQuestionQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterLazyQuestionQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitLazyQuestionQuantifier(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusQuantifierContext extends QuantifierContext {
		public TerminalNode PLUS() { return getToken(regexParser.PLUS, 0); }
		public PlusQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterPlusQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitPlusQuantifier(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsteriskQuantifierContext extends QuantifierContext {
		public TerminalNode ASTERISK() { return getToken(regexParser.ASTERISK, 0); }
		public AsteriskQuantifierContext(QuantifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).enterAsteriskQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof regexListener ) ((regexListener)listener).exitAsteriskQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_quantifier);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new AsteriskQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(ASTERISK);
				}
				break;
			case 2:
				_localctx = new PlusQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(PLUS);
				}
				break;
			case 3:
				_localctx = new QuestionQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(QUESTION_MARK);
				}
				break;
			case 4:
				_localctx = new LazyAsteriskQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(ASTERISK);
				setState(100);
				match(QUESTION_MARK);
				}
				break;
			case 5:
				_localctx = new LazyPlusQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				match(PLUS);
				setState(102);
				match(QUESTION_MARK);
				}
				break;
			case 6:
				_localctx = new LazyQuestionQuantifierContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				match(QUESTION_MARK);
				setState(104);
				match(QUESTION_MARK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013l\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0005\u0001\u001b\b\u0001\n\u0001\f\u0001\u001e\t\u0001"+
		"\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001$\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002(\b\u0002\n\u0002\f\u0002+\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0003\u0003/\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"9\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"?\b\u0005\u000b\u0005\f\u0005@\u0001\u0005\u0001\u0005\u0003\u0005E\b"+
		"\u0005\u0003\u0005G\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006N\b\u0006\u0001\u0006\u0005\u0006Q\b\u0006"+
		"\n\u0006\f\u0006T\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007[\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nj\b\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0002\u0003\u0000\u0003\u0003\u0005\u000b\r\u0013"+
		"\u0002\u0000\f\u0010\u0013\u0013v\u0000\u0016\u0001\u0000\u0000\u0000"+
		"\u0002\u001c\u0001\u0000\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u0006"+
		",\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000"+
		"\u0000\fK\u0001\u0000\u0000\u0000\u000eW\u0001\u0000\u0000\u0000\u0010"+
		"\\\u0001\u0000\u0000\u0000\u0012^\u0001\u0000\u0000\u0000\u0014i\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0018\u0005"+
		"\u0000\u0000\u0001\u0018\u0001\u0001\u0000\u0000\u0000\u0019\u001b\u0003"+
		"\u0006\u0003\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\"\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000"+
		"!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#\u0003\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%)\u0005"+
		"\u0001\u0000\u0000&(\u0003\u0006\u0003\u0000\'&\u0001\u0000\u0000\u0000"+
		"(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*\u0005\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,.\u0003"+
		"\b\u0004\u0000-/\u0003\u0014\n\u0000.-\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/\u0007\u0001\u0000\u0000\u000009\u0003\n\u0005\u0000"+
		"19\u0003\u0012\t\u000029\u0005\u0003\u0000\u000039\u0005\u0004\u0000\u0000"+
		"49\u0003\f\u0006\u000059\u0005\u0012\u0000\u000069\u0005\u0011\u0000\u0000"+
		"79\u0005\t\u0000\u000080\u0001\u0000\u0000\u000081\u0001\u0000\u0000\u0000"+
		"82\u0001\u0000\u0000\u000083\u0001\u0000\u0000\u000084\u0001\u0000\u0000"+
		"\u000085\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000087\u0001\u0000"+
		"\u0000\u00009\t\u0001\u0000\u0000\u0000:F\u0005\u0005\u0000\u0000;D\u0005"+
		"\n\u0000\u0000<>\u0005\u000f\u0000\u0000=?\u0005\u0013\u0000\u0000>=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0005\u000e\u0000"+
		"\u0000CE\u0005\u0010\u0000\u0000D<\u0001\u0000\u0000\u0000DC\u0001\u0000"+
		"\u0000\u0000EG\u0001\u0000\u0000\u0000F;\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0003\u0002\u0001\u0000"+
		"IJ\u0005\u0006\u0000\u0000J\u000b\u0001\u0000\u0000\u0000KM\u0005\u000b"+
		"\u0000\u0000LN\u0005\u0011\u0000\u0000ML\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NR\u0001\u0000\u0000\u0000OQ\u0003\u000e\u0007\u0000"+
		"PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000UV\u0005\f\u0000\u0000V\r\u0001\u0000\u0000\u0000WZ\u0003"+
		"\u0010\b\u0000XY\u0005\r\u0000\u0000Y[\u0003\u0010\b\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u000f\u0001\u0000\u0000\u0000"+
		"\\]\u0007\u0000\u0000\u0000]\u0011\u0001\u0000\u0000\u0000^_\u0007\u0001"+
		"\u0000\u0000_\u0013\u0001\u0000\u0000\u0000`j\u0005\u0007\u0000\u0000"+
		"aj\u0005\b\u0000\u0000bj\u0005\n\u0000\u0000cd\u0005\u0007\u0000\u0000"+
		"dj\u0005\n\u0000\u0000ef\u0005\b\u0000\u0000fj\u0005\n\u0000\u0000gh\u0005"+
		"\n\u0000\u0000hj\u0005\n\u0000\u0000i`\u0001\u0000\u0000\u0000ia\u0001"+
		"\u0000\u0000\u0000ib\u0001\u0000\u0000\u0000ic\u0001\u0000\u0000\u0000"+
		"ie\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000j\u0015\u0001\u0000"+
		"\u0000\u0000\f\u001c\").8@DFMRZi";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}