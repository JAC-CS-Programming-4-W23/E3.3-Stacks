public class Main {

    public static void main(String[] args) {
        throw new RuntimeException("Run the TestStack not this Main!");
    }

    public static boolean balanced(String exp) {
        IntStack brackets = new IntStack(exp.length()/2 + 1);

        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                if (brackets.isFull())  // because the stack is 1/2 of the length of the string
                                        // if it's full then it's impossible to have enough close
                    return false;
                brackets.push(c);
            }
            else {
                if (brackets.isEmpty())
                    return false;
                char tmp = (char) brackets.pop();
                if (c == ')' && tmp != '(')
                    return false;
                if (c == '}' && tmp != '{')
                    return false;
                if (c == ']' && tmp != '[')
                    return false;
            }
        }
		
        return brackets.isEmpty();
    }

}
