package com.exyfi.calculator.state;


import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.Tokenizer;

public class EndState implements State {

    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }
}
