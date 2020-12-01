package com.exyfi.calculator.token;

import com.exyfi.calculator.state.EndState;
import com.exyfi.calculator.state.ErrorState;
import com.exyfi.calculator.state.StartState;
import com.exyfi.calculator.state.State;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private String input;
    private int curPos;
    private State state;

    public List<Token> parse(String input) throws ParseException {
        this.input = input.trim();
        curPos = 0;
        state = new StartState();
        state.setNextState(this);
        List<Token> result = new ArrayList<>();

        while (!(state instanceof EndState) && !(state instanceof ErrorState)) {
            result.add(state.createToken(this));
            while (!isEndOfInput() && isWhiteSpace()) {
                nextChar();
            }
            state.setNextState(this);
        }

        if (state instanceof ErrorState) {
            throw new ParseException(((ErrorState) state).getMessage(), 0);
        }

        return result;
    }


    public void nextChar() {
        curPos++;
    }

    public int curPos() {
        return curPos;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isEndOfInput() {
        return curPos >= input.length();
    }

    private boolean isWhiteSpace() {
        return Character.isWhitespace(getCurrentCharacter());
    }

    public boolean isNumber() {
        return Character.isDigit(getCurrentCharacter());
    }

    public boolean isOperationOrBrace() {
        String availableSymbols = "+-*/()";
        return availableSymbols.indexOf(getCurrentCharacter()) >= 0;
    }

    public char getCurrentCharacter() {
        return input.charAt(curPos);
    }

}
