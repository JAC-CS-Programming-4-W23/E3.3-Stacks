public class Main {

    public static void main(String[] args) {
        throw new RuntimeException("Run the TestStack not this Main!");
    }

    public static boolean balanced(String exp) {

        // create a stack half the size of the input.
        // we won't need more it would be impossible to balance that many open brackets.
        IntStack openBrackets = new IntStack(exp.length()/2 + 1);

        for (char c : exp.toCharArray()) {

            // skip characters
            if(Character.isAlphabetic(c))
                continue;

            // open brackets are pushed on to the stack
            if (c == '(' || c == '{' || c == '[') {
                if (openBrackets.isFull()) // cannot close the open brackets (see above).
                    return false;
                openBrackets.push(c);
            }
            else { // assume that the rest are close brackets, which are popped and checked.
                if (openBrackets.isEmpty()) // too many close brackets
                    return false;
                char tmp = (char) openBrackets.pop(); // precoditions checked above.
                if (c == ')' && tmp != '(')
                    return false;
                if (c == '}' && tmp != '{')
                    return false;
                if (c == ']' && tmp != '[')
                    return false;
            }
        }

        // if there are open brackets left on the stack then we return false.
        return openBrackets.isEmpty();
    }

}
