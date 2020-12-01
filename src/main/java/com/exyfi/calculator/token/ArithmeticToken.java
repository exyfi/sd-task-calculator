package com.exyfi.calculator.token;


import com.exyfi.calculator.exceptions.CalculatorException;
import com.exyfi.calculator.visitor.TokenVisitor;
import lombok.Data;

@Data
public class ArithmeticToken implements Token {

    private final TokenType operationType;

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return operationType;
    }

    public int evaluate(int a, int b) {
        if (operationType.equals(TokenType.PLUS)) {
            return a + b;
        }
        if (operationType.equals(TokenType.MINUS)) {
            return a - b;
        }
        if (operationType.equals(TokenType.MUL)) {
            return a * b;
        }
        if (operationType.equals(TokenType.DIV)) {
            return a / b;
        }
        throw new CalculatorException("Illegal operation");
    }

}
