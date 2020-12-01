package com.exyfi.calculator.visitor;


import com.exyfi.calculator.token.BraceToken;
import com.exyfi.calculator.token.NumberToken;
import com.exyfi.calculator.token.ArithmeticToken;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(BraceToken token);
    void visit(ArithmeticToken token);

}
