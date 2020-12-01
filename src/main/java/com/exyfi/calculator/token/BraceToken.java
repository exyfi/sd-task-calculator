package com.exyfi.calculator.token;

import com.exyfi.calculator.visitor.TokenVisitor;
import lombok.Data;

@Data
public class BraceToken implements Token {
    private final TokenType braceType;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return braceType;
    }

}
