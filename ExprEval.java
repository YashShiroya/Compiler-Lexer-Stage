
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

    TokenStruct lex(ListIterator<TokenStruct> it) {
        
        if(it.hasNext()) { 
            return it.next();
        }
        else {
            System.out.print("---------\nReached end of tokens!\n---------");
        }

        return null;
    }    

    public static double evaluate(String expr, double xval) throws Exception {

        Lexer lexEval = new Lexer(expr);

        // Getter gets private TokenList
        ArrayList<TokenStruct> tokenList = lexEval.releaseTokenList();

        //Change variable to actual "NUMBER"
        for (TokenStruct t : tokenList) {
            if(t.type.name().equals("VAR")) {
                t.type = TokenType.NUMBER;
                t.data = Double.toString(xval);
            }
            if(lexEval.lexer_debug) System.out.println(t.data);
        }

        //List iterator
        ListIterator<TokenStruct> it = tokenList.listIterator();
        //Init nextToken to nextToken
        TokenStruct nextToken = it.next();

        if(lexEval.lexer_debug) lexEval.printTokens();

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

