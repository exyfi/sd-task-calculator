package com.exyfi.calculator.state;


import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.Tokenizer;

public class ErrorState implements State {
    private final String message;

    public ErrorState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }
}
