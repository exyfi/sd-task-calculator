package com.exyfi.calculator.visitor;

import com.exyfi.calculator.token.ArithmeticToken;
import com.exyfi.calculator.token.NumberToken;
import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.TokenType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RPNVisitorTest {

    private final RPNVisitor rpnVisitor = new RPNVisitor();

    @Test
    public void testSimpleExpression() {
        List<Token> tokens = List.of(new NumberToken(1), new ArithmeticToken(TokenType.PLUS), new NumberToken(2));
        List<Token> expectedRpn = List.of(new NumberToken(1), new NumberToken(2), new ArithmeticToken(TokenType.PLUS));
        List<Token> actualRpn = rpnVisitor.parse(tokens);

        assertEquals(expectedRpn, actualRpn);
    }

    @Test
    public void testNumber() {
        List<Token> tokens = List.of(new NumberToken(1));

        List<Token> expectedRpn = List.of(new NumberToken(1));
        List<Token> actualRpn = rpnVisitor.parse(tokens);

        assertEquals(expectedRpn, actualRpn);
    }

    @Test
    public void testPriorityExpression() {

        List<Token> tokens = List.of(new NumberToken(1),
                new ArithmeticToken(TokenType.PLUS),
                new NumberToken(2),
                new ArithmeticToken(TokenType.MUL),
                new NumberToken(3));

        List<Token> expectedRpn = List.of(new NumberToken(1),
                new NumberToken(2),
                new NumberToken(3),
                new ArithmeticToken(TokenType.MUL),
                new ArithmeticToken(TokenType.PLUS));

        List<Token> actualRpn = rpnVisitor.parse(tokens);

        assertEquals(expectedRpn, actualRpn);

    }

}