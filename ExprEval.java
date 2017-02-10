
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
                t.type = TokenType.NUMBER;
                t.data = Double.toString(xval);
            }
            if(lexEval.lexer_debug) System.out.println(t.data);
        }


        lexEval.printTokens();


        System.out.print("\n");

        return 0;
    }
}

