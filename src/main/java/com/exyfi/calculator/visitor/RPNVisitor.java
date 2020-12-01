package com.exyfi.calculator.visitor;


import com.exyfi.calculator.exceptions.CalculatorException;
import com.exyfi.calculator.token.BraceToken;
import com.exyfi.calculator.token.NumberToken;
import com.exyfi.calculator.token.ArithmeticToken;
import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.TokenType;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RPNVisitor implements TokenVisitor {
    private final List<Token> rpnTokens = new ArrayList<>();
    private final Deque<Token> stack = new ArrayDeque<>();

    public List<Token> parse(List<Token> tokens) {
        tokens.forEach(token -> token.accept(this));

        while (!stack.isEmpty()) {
            rpnTokens.add(stack.pollLast());
        }

        return new ArrayList<>(rpnTokens);
    }

    @Override
    public void visit(NumberToken token) {
        rpnTokens.add(token);
    }

    @Override
    public void visit(BraceToken token) {
        if (token.getTokenType().equals(TokenType.LEFT_BRACE)) {
            stack.add(token);
        } else if (token.getTokenType().equals(TokenType.RIGHT_BRACE)) {
            loop:
            while (!stack.isEmpty()) {
                var curToken = stack.pollLast();
                switch (curToken.getTokenType()) {
                    case LEFT_BRACE:
                        stack.pollLast();
                        break loop;
                    case DIV:
                    case MUL:
                    case PLUS:
                    case MINUS:
                        rpnTokens.add(stack.pollLast());
                    case NUMBER:
                    case RIGHT_BRACE:
                        throw new CalculatorException("Illegal stack state");
                }

            }
        }
    }

    @Override
    public void visit(ArithmeticToken token) {
        if (!stack.isEmpty()) {
            Token nextToken = stack.peekLast();
            while (!stack.isEmpty() && token.getTokenType().priority() <= nextToken.getTokenType().priority()) {
                rpnTokens.add(stack.pollLast());
                nextToken = stack.peekLast();
            }
        }
        stack.add(token);
    }

}
