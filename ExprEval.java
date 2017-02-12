
import java.lang.*;
import java.util.*;

class ExprEval {
    public static void main(String args[]) throws Exception {
        if (args.length < 2) {
          System.out.println("Usage: java expression xval");
          System.exit(1);
        }
      double val = evaluate(args[0], Double.parseDouble(args[1]));
      System.out.println("y="+val);
    }

    // int accept(TokenType type) {
    //     if (sym == s) {
    //         nextsym();
    //         return 1;
    //     }
    //     return 0;
    // }

    // int expect(TokenType type) {
    //     if (accept(s))
    //         return 1;
    //     error("expect: unexpected symbol");
    //     return 0;
    // }

    ListIterator<ArrayList<TokenStruct>> it = tokenList.listIterator();

    TokenStruct lex() {
        if(it.hasNext()) { 
            return it.next().type.name();
        }
        else {
            System.out.print("---------\nReached end of tokens!\n---------");
        }
    }    

    public static double evaluate(String expr, double xval) throws Exception {

        Lexer lexEval = new Lexer(expr);

        String nextToken = "";


        // getter
        ArrayList<TokenStruct> tokenList = lexEval.releaseTokenList();

        for (TokenStruct t : tokenList) {
            if(t.type.name().equals("VAR")) {
                t.type = TokenType.NUMBER;
                t.data = Double.toString(xval);
            }
            if(lexEval.lexer_debug) System.out.println(t.data);
        }


        lexEval.printTokens();

        double current_val = (double) 0;

        /*
            <expr> -> <term> {(+ | -) <term>}
            <term> -> <factor> {(* | /) <factor>}
            <factor> -> id | int_constant | double_constant | ( <expr> )
        */

        // double expr() {

        //     double termOut = term();

        //     while(nextToken == "PLUS" || nextToken == "MULTIPY") {

        //     }
        // }

        return 0;
    }
}

