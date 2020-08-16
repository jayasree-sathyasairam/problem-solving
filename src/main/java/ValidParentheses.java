public class ValidParentheses {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            int count = 0;
            String result = "";
            char[] iterateParentheses = args[i].toCharArray();
            for (int j = 0; j < iterateParentheses.length; j++) {
                if ((iterateParentheses[j] == ')') && (count == 0)) {
                    result = result + "()";
                } else if (iterateParentheses[j] == '(') {
                    result = result + "(";
                    count++;
                } else if (iterateParentheses[j] == ')'){
                    result = result + ")";
                    count--;
                }
            }
            if (count > 0) {
                for (int j = 0; j < count; j++) {
                    result = result + ")";
                }
            }
            System.out.println(result);
        }
    }
}
