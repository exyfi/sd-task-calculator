package com.exyfi.calculator;

import com.exyfi.calculator.exceptions.CalculatorException;
import com.exyfi.calculator.token.Token;

import com.exyfi.calculator.token.Tokenizer;
import com.exyfi.calculator.visitor.CalcVisitor;
import com.exyfi.calculator.visitor.RPNVisitor;
import com.exyfi.calculator.visitor.PrintVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

public class CalculatorApp {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            Tokenizer tokenizer = new Tokenizer();
            PrintVisitor printVisitor = new PrintVisitor();
            CalcVisitor calcVisitor = new CalcVisitor();

            while (!(input = reader.readLine()).isEmpty()) {
                parseAndCalculateExpression(input, tokenizer, printVisitor, calcVisitor);
            }
        } catch (IOException | ParseException e) {
            throw new CalculatorException("Exception occurred during reading expression ", e);
        }
    }

    private static void parseAndCalculateExpression(String input, Tokenizer tokenizer, PrintVisitor printVisitor, CalcVisitor calcVisitor) throws ParseException {
        RPNVisitor rpnVisitor = new RPNVisitor();

        List<Token> tokens = tokenizer.parse(input);
        System.out.println(printVisitor.printToken(tokens));

        List<Token> rpnTokens = rpnVisitor.parse(tokens);
        System.out.println(printVisitor.printToken(rpnTokens));

        System.out.println("Calculated expression");
        System.out.println(calcVisitor.calculate(rpnTokens));
        System.exit(0);
    }
}
