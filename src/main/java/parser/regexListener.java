// Generated from ./regex.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link regexParser}.
 */
public interface regexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link regexParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(regexParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(regexParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#regex}.
	 * @param ctx the parse tree
	 */
	void enterRegex(regexParser.RegexContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#regex}.
	 * @param ctx the parse tree
	 */
	void exitRegex(regexParser.RegexContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#alternative}.
	 * @param ctx the parse tree
	 */
	void enterAlternative(regexParser.AlternativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#alternative}.
	 * @param ctx the parse tree
	 */
	void exitAlternative(regexParser.AlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(regexParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(regexParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterGroupPattern(regexParser.GroupPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitGroupPattern(regexParser.GroupPatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomicPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomicPattern(regexParser.AtomicPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomicPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomicPattern(regexParser.AtomicPatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code escapedReservedAtomicPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterEscapedReservedAtomicPattern(regexParser.EscapedReservedAtomicPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code escapedReservedAtomicPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitEscapedReservedAtomicPattern(regexParser.EscapedReservedAtomicPatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code characterClass}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterCharacterClass(regexParser.CharacterClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code characterClass}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitCharacterClass(regexParser.CharacterClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexClass}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterComplexClass(regexParser.ComplexClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexClass}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitComplexClass(regexParser.ComplexClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dollarAnchor}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterDollarAnchor(regexParser.DollarAnchorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dollarAnchor}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitDollarAnchor(regexParser.DollarAnchorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caretAnchor}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterCaretAnchor(regexParser.CaretAnchorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caretAnchor}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitCaretAnchor(regexParser.CaretAnchorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void enterDotPattern(regexParser.DotPatternContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotPattern}
	 * labeled alternative in {@link regexParser#subexpr}.
	 * @param ctx the parse tree
	 */
	void exitDotPattern(regexParser.DotPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#regexGroup}.
	 * @param ctx the parse tree
	 */
	void enterRegexGroup(regexParser.RegexGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#regexGroup}.
	 * @param ctx the parse tree
	 */
	void exitRegexGroup(regexParser.RegexGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#complexCharacterClass}.
	 * @param ctx the parse tree
	 */
	void enterComplexCharacterClass(regexParser.ComplexCharacterClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#complexCharacterClass}.
	 * @param ctx the parse tree
	 */
	void exitComplexCharacterClass(regexParser.ComplexCharacterClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#complexCCPiece}.
	 * @param ctx the parse tree
	 */
	void enterComplexCCPiece(regexParser.ComplexCCPieceContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#complexCCPiece}.
	 * @param ctx the parse tree
	 */
	void exitComplexCCPiece(regexParser.ComplexCCPieceContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#allowedCharInCharacterClass}.
	 * @param ctx the parse tree
	 */
	void enterAllowedCharInCharacterClass(regexParser.AllowedCharInCharacterClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#allowedCharInCharacterClass}.
	 * @param ctx the parse tree
	 */
	void exitAllowedCharInCharacterClass(regexParser.AllowedCharInCharacterClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link regexParser#atomicChar}.
	 * @param ctx the parse tree
	 */
	void enterAtomicChar(regexParser.AtomicCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link regexParser#atomicChar}.
	 * @param ctx the parse tree
	 */
	void exitAtomicChar(regexParser.AtomicCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asteriskQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterAsteriskQuantifier(regexParser.AsteriskQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asteriskQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitAsteriskQuantifier(regexParser.AsteriskQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterPlusQuantifier(regexParser.PlusQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitPlusQuantifier(regexParser.PlusQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code questionQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuestionQuantifier(regexParser.QuestionQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code questionQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuestionQuantifier(regexParser.QuestionQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lazyAsteriskQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterLazyAsteriskQuantifier(regexParser.LazyAsteriskQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lazyAsteriskQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitLazyAsteriskQuantifier(regexParser.LazyAsteriskQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lazyPlusQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterLazyPlusQuantifier(regexParser.LazyPlusQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lazyPlusQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitLazyPlusQuantifier(regexParser.LazyPlusQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lazyQuestionQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterLazyQuestionQuantifier(regexParser.LazyQuestionQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lazyQuestionQuantifier}
	 * labeled alternative in {@link regexParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitLazyQuestionQuantifier(regexParser.LazyQuestionQuantifierContext ctx);
}