package com.exyfi.calculator.token;

import com.exyfi.calculator.visitor.TokenVisitor;

public interface Token {
    void accept(TokenVisitor visitor);

    TokenType getTokenType();

}
