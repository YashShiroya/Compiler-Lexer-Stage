
import java.lang.*;
import java.util.ArrayList;

class ExprEval {
    public static void main(String args[]) throws Exception {
        if (args.length < 2) {
          System.out.println("Usage: java expression xval");
          System.exit(1);
        }
      double val = evaluate(args[0], Double.parseDouble(args[1]));
      System.out.println("y="+val);
    }


    public static double evaluate(String expr, double xval) throws Exception {

        Lexer lexEval = new Lexer(expr);
        
        ArrayList<TokenStruct> tokenList = lexEval.releaseTokenList();

        for (TokenStruct t : tokenList) {
            if(t.type.name() == "VAR") {
                t.data = Double.toString(xval);
            }
            System.out.println(t.data);
        }



        System.out.print("\n");

        return 0;
    }
}

