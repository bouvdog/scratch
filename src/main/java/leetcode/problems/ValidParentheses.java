package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    enum States { OPEN_PAREN, CLOSE_PAREN, OPEN_BRACE, CLOSE_BRACE, OPEN_BRACKET, CLOSE_BRACKET }

    final Map<String, States> charsToStatesTable = new HashMap<>();

    Deque<States> states = new ArrayDeque<>();

    boolean valid = true;
    
    public ValidParentheses() {
        charsToStatesTable.put("(", States.OPEN_PAREN);
        charsToStatesTable.put(")", States.CLOSE_PAREN);
        charsToStatesTable.put("{", States.OPEN_BRACE);
        charsToStatesTable.put("}", States.CLOSE_BRACE);
        charsToStatesTable.put("[", States.OPEN_BRACKET);
        charsToStatesTable.put("]", States.CLOSE_BRACKET);
    }

    public boolean isValid(String s) {
        if ((s == null) || s.length() ==0) {
            return false;
        }
        valid = true;
        states.clear();
        String[] parseTarget = s.split("");
        for (String b : parseTarget) {
            States i = charsToStatesTable.get(b);
            switch (i) {
                case OPEN_BRACE:
                    openBrace();
                    break;
                case OPEN_BRACKET:
                    openBracket();
                    break;
                case OPEN_PAREN:
                    openParen();
                    break;
                case CLOSE_BRACE:
                    closeBrace();
                    break;
                case CLOSE_PAREN:
                    closeParen();
                    break;
                case CLOSE_BRACKET:
                    closeBracket();
                    break;
            }

        }
        if (states.size() != 0) {
            valid = false;
        }
        return valid;
    }

    public void openParen() {
        if (states.size() == 0) {
            states.push(States.OPEN_PAREN);
            return;
        }

        States state = states.peek();
        if (state.equals(States.OPEN_PAREN)) {
            states.push(States.OPEN_PAREN);
        } else if (state == States.OPEN_BRACE) {
            states.push(States.OPEN_PAREN);
        } else if (state == States.OPEN_BRACKET) {
            states.push(States.OPEN_PAREN);
        } else {
            valid = false;
        }
    }

    public void closeParen() {
        States state = states.peek();
        if (state == States.OPEN_PAREN) {
            states.pop();
        } else {
            valid= false;
        }
    }

    public void openBrace() {
        if (states.size() == 0) {
            states.push(States.OPEN_BRACE);
            return;
        }
        States state = states.peek();
        if (state.equals(States.OPEN_PAREN)) {
            states.push(States.OPEN_BRACE);
        } else if (state == States.OPEN_BRACE) {
            states.push(States.OPEN_BRACE);
        } else if (state == States.OPEN_BRACKET) {
            states.push(States.OPEN_BRACE);
        } else {
            valid = false;
        }
    }
    public void openBracket() {
        if (states.size() == 0) {
            states.push(States.OPEN_BRACKET);
            return;
        }
        States state = states.peek();
        if (state.equals(States.OPEN_PAREN)) {
            states.push(States.OPEN_BRACKET);
        } else if (state == States.OPEN_BRACE) {
            states.push(States.OPEN_BRACKET);
        } else if (state == States.OPEN_BRACKET) {
            states.push(States.OPEN_BRACKET);
        } else {
            valid = false;
        }
    }

    public void closeBrace() {
        States state = states.peek();
        if (state == States.OPEN_BRACE) {
            states.pop();
        } else {
            valid = false;
        }
    }

    public void closeBracket() {
        States state = states.peek();
        if (state == States.OPEN_BRACKET) {
            states.pop();
        } else {
            valid = false;
        }
    }
}
