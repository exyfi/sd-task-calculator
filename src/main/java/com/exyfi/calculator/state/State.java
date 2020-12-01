package com.exyfi.calculator.state;

import com.exyfi.calculator.token.Token;
import com.exyfi.calculator.token.Tokenizer;


public interface State {

    Token createToken(Tokenizer tokenizer);

    void setNextState(Tokenizer tokenizer);

}
