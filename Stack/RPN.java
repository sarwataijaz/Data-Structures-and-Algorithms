public class RPN {
    int size = 0;
    Nodee top;
    public RPN(String[] args) {
        StackImp llStack = new StackImp();
        for(int i=0; i< args.length; i++) {
            if(isAnOperator(args[i])) {
                System.out.println("Operator: "+args[i]);
                double num1 = Double.parseDouble((String)llStack.pop());
                double num2 = Double.parseDouble((String)llStack.pop());
                double ans = evaluate(num1,num2,args[i]);

                llStack.push(ans);
            } else {
                llStack.push(args[i]);
            }
        }
    }

    class StackImp implements Stack {
        @Override
        public int getSize() {
            return size;
        }

        @Override
        public Object peek() {
            return top.data;
        }

        @Override
        public void push(Object obj) {
            top = new Nodee(obj, top);
            ++size;
        }

        @Override
        public Object pop() {
            Object temp = top.data;
            top = top.next;
            --size;
            return temp;
        }
    }

    public double evaluate(double num1, double num2, String s) {
        double ans = 0.0;
        if(s.equals("A")) {
            ans = num1 + num2;
        }
        if(s.equals("S")) {
            ans = num1 - num2;
        }
        if(s.equals("M")) {
            ans = num1 * num2;
        }
        if(s.equals("D")) {
            ans = num1 / num2;
        }
        System.out.println(num1 + s + num2 + " = " + ans);

        return ans;
    }

    public boolean isAnOperator(String s) {
        switch (s) {
            case "A", "S", "M", "D": {
                return true;
            }
            default:
                return false;
        }
    }
}

class RPNPostfix {
    public static void main(String[] args) {
        String[] expression = {"4" , "5" , "7" , "A" , "D"} ;
        RPN rpn = new RPN(expression) ;
    }
}
