package com.exyfi.calculator.token;

public enum TokenType {
    LEFT_BRACE {
        @Override
       public int priority() {
            return 3;
        }
    },
    RIGHT_BRACE {
        @Override
       public int priority() {
            return 3;
        }
    },
    NUMBER {
        @Override
       public int priority() {
            return 3;
        }
    },
    PLUS {
        @Override
       public int priority() {
            return 1;
        }
    },
    MINUS {
        @Override
       public int priority() {
            return 1;
        }
    },
    MUL {
        @Override
        public int priority() {
            return 2;
        }
    },
    DIV {
        @Override
       public int priority() {
            return 2;
        }
    };

    public abstract int priority();
}
