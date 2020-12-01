package com.exyfi.calculator.token;


import com.exyfi.calculator.visitor.TokenVisitor;
import lombok.Data;

@Data
public class NumberToken implements Token {
    private final int value;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.NUMBER;
    }
}
