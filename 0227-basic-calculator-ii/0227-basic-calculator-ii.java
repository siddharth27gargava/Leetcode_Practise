class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // Use a stack to manage intermediate results
        char operation = '+'; // Initialize the operation as addition
        int value = 0; // This will hold the current number

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);

            // If the current character is a digit, accumulate into value
            if (Character.isDigit(currentChar)) {
                value = value * 10 + (currentChar - '0');
            }

            // If we've reached the end of the string or we encounter an operator
            if (i == s.length() - 1 || currentChar == '+' || currentChar == '-'
                    || currentChar == '*' || currentChar == '/') {

                // Perform the operation based on the previous sign
                switch (operation) {
                    case '+':
                        stack.push(value); // Add the value to the stack
                        break;
                    case '-':
                        stack.push(-value); // Push the negated value for subtraction
                        break;
                    case '*':
                        stack.push(stack.pop() * value); // Multiply with the top value on the stack
                        break;
                    case '/':
                        stack.push(stack.pop() / value); // Divide the top value with current value
                        break;
                }

                operation = currentChar; // Update the operation for the next iteration
                value = 0; // Reset value for the next number
            }
        }

        int result = 0; // Initialize result to accumulate stack values
        // Pop values from the stack and add them to calculate the result
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result; // Return the final calculated result
    }
}