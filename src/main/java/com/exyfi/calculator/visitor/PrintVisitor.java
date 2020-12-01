package com.exyfi.calculator.visitor;


import com.exyfi.calculator.token.BraceToken;
import com.exyfi.calculator.token.NumberToken;
import com.exyfi.calculator.token.ArithmeticToken;
import com.exyfi.calculator.token.Token;

import java.util.List;

public class PrintVisitor implements TokenVisitor {

    private final StringBuilder builder;

    public PrintVisitor() {
        builder = new StringBuilder();
    }

    public String printToken(List<Token> tokens) {
        tokens.forEach(token -> token.accept(this));
        return builder.toString();
    }

    @Override
    public void visit(NumberToken token) {
        printToken(token);
    }

    @Override
    public void visit(BraceToken token) {
        printToken(token);
    }

    @Override
    public void visit(ArithmeticToken token) {
        printToken(token);
    }

    private void printToken(Token token) {
        builder.append(token).append(" ");
    }

}
