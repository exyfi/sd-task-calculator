package com.exyfi.calculator.token;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    private final Tokenizer tokenizer = new Tokenizer();

    @Test
    public void testCorrectExpression() throws ParseException {
        List<Token> actual = tokenizer.parse("1+2");

        List<Token> expected = List.of(new NumberToken(1), new ArithmeticToken(TokenType.PLUS), new NumberToken(2));

        assertEquals(actual, expected);
    }

    @Test
    public void testIncorrectException() {
        assertThrows(ParseException.class, () -> tokenizer.parse("111!"));
    }

    @Test
    public void testExpressionWithBrace() throws ParseException {
        List<Token> actual = tokenizer.parse("(1+2)");

        List<Token> expected = List.of(new BraceToken(TokenType.LEFT_BRACE), new NumberToken(1), new ArithmeticToken(TokenType.PLUS), new NumberToken(2), new BraceToken(TokenType.RIGHT_BRACE));

        assertEquals(expected, actual);
    }

}