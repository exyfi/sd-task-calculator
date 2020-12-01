package com.exyfi.calculator.state;


import com.exyfi.calculator.token.NumberToken;
import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.Tokenizer;

public class NumberState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        StringBuilder value = new StringBuilder();
        while (!tokenizer.isEndOfInput() && Character.isDigit(tokenizer.getCurrentCharacter())) {
            value.append(tokenizer.getCurrentCharacter());
            tokenizer.nextChar();
        }
        return new NumberToken(Integer.parseInt(value.toString()));
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        if (tokenizer.isEndOfInput()) {
            tokenizer.setState(new EndState());
        } else if (tokenizer.isOperationOrBrace()) {
            tokenizer.setState(new StartState());
        } else {
            tokenizer.setState(new ErrorState("Unexpected symbol : " + tokenizer.getCurrentCharacter()));
        }
    }
}
