package com.exyfi.calculator.state;


import com.exyfi.calculator.token.BraceToken;
import com.exyfi.calculator.token.ArithmeticToken;
import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.TokenType;
import com.exyfi.calculator.token.Tokenizer;

public class StartState implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        char c = tokenizer.getCurrentCharacter();
        tokenizer.nextChar();
        switch (c) {
            case '(':
                return new BraceToken(TokenType.LEFT_BRACE);
            case ')':
                return new BraceToken(TokenType.RIGHT_BRACE);
            case '+':
                return new ArithmeticToken(TokenType.PLUS);
            case '-':
                return new ArithmeticToken(TokenType.MINUS);
            case '*':
                return new ArithmeticToken(TokenType.MUL);
            case '/':
                return new ArithmeticToken(TokenType.DIV);
            default:
                return null;
        }
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        if (tokenizer.isEndOfInput()) {
            tokenizer.setState(new EndState());
        } else if (tokenizer.isNumber()) {
            tokenizer.setState(new NumberState());
        } else if (tokenizer.isOperationOrBrace()) {
            tokenizer.setState(new StartState());
        } else {
            tokenizer.setState(new ErrorState("Unexpected character : " + tokenizer.getCurrentCharacter()));
        }
    }

}
