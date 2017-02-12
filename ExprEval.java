
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

    static boolean timeline = true;

    enum exprSign {DEFUALT, PLUS, MINUS};
    enum termSign {DEFUALT, MULTIPLY, DIVIDE};

    private static TokenStruct nextToken = null;

    private static ArrayList<TokenStruct> tokenList = null;

    private static ListIterator<TokenStruct> it = null;


    public static void error() {
        System.out.println("ERROR: Grammar Violated");
        System.exit(1);
    }

    private static void lex() {
        
        if(it.hasNext()) { 
            nextToken = it.next();
        }
    }    

    public static double evaluate(String expr, double xval) throws Exception {

        Lexer lexEval = new Lexer(expr);

        // Getter gets private TokenList
        tokenList = lexEval.releaseTokenList();

        //Change variable to actual "NUMBER"
        for (TokenStruct t : tokenList) {
            if(t.type.name().equals("VAR")) {
                t.type = TokenType.NUMBER;
                t.data = Double.toString(xval);
            }
            //if(timeline) System.out.println(t.data);
        }

        //List iterator
        it = tokenList.listIterator();
        
        //Init nextToken to nextToken
        lex();

        if(timeline) lexEval.printTokens();

        double exprVal = expr();

        if(it.hasNext()) error();

        return exprVal;
    }

    /*
        <expr> -> <term> {(+ | -) <term>}
        <term> -> <factor> {(* | /) <factor>}
        <factor> -> id | int_constant | double_constant | ( <expr> )
    */

    // Function expr
    // Parses wheres thas in the language
    // generated by the rule:
    // <expr> -> <term> {(+ | -) <term>}

    public static double expr() {
      //Parse the first term

        double termLeft = (double) term();

        exprSign sign = exprSign.DEFUALT;

        // As long as the next token is + or -, call
        // lex to get the next token and parse the
        // next term
        while (nextToken.type.name().equals("PLUS") ||
                 nextToken.type.name().equals("MINUS")) {

            if(nextToken.type.name().equals("PLUS")) sign = exprSign.PLUS;
            else if(nextToken.type.name().equals("MINUS")) sign = exprSign.MINUS;

            //Update nextToken
            lex();

            // System.out.println("exprSign: h1 " + sign);

            double termRight = (double) term();

            // System.out.println("exprSign: h2 " + sign);

            if(sign == exprSign.PLUS) {termLeft += termRight; System.out.println("sum: " + termLeft);}
            else if(sign == exprSign.MINUS) termLeft -= termRight;
            else {System.out.print("INTERNAL: In expr(), Sign not modified.");} 
        }
        return termLeft;
    }

    // Function term
    // Parses strings in the language generated by the rule:
    // <term> -> <factor> {(* | /) <factor>)

    public static double term() {
      // Parse the first factor
        double factorLeft = factor();

        termSign signt = termSign.DEFUALT;

        // As long as the next token is * or /,
        // next token and parse the next factor
        while (nextToken.type.name().equals("MULTIPLY") ||
                 nextToken.type.name().equals("DIVIDE")) {

            if(nextToken.type.name().equals("MULTIPLY")) signt = termSign.MULTIPLY;
            else if(nextToken.type.name().equals("DIVIDE")) signt = termSign.DIVIDE;

            //Update nextToken
            lex();
            double factorRight = (double) factor();

            if(signt == termSign.MULTIPLY) factorLeft *= factorRight;
            else if(signt == termSign.DIVIDE) factorLeft /= factorRight;
            else {System.out.print("INTERNAL: In term(), Sign not modified.");} 

        }
        return factorLeft;
    }


    // Function factor
    // Parses strings in the language
    // generated by the rule:
    //   <factor> -> id  |  (<expr>)

    public static double factor() {
       // Determine which RHS (Right-hand side)

        double factorVal = (double) 0;

        if (nextToken.type.name().equals("NUMBER")) {
            
            // For the RHS id, just call lex
            TokenStruct temp = nextToken;

            System.out.println("number: " + nextToken.data);
            
            //Update nextToken
            lex();
            return Double.parseDouble(temp.data);
        }
        else if (nextToken.type.name().equals("LPAREN")) {
            
            //Update nextToken
            lex();

            factorVal = expr();
            
            if (nextToken.type.name().equals("RPAREN")) {
                
                //Update nextToken
                lex();
                return factorVal;

            }
            else {
                error();
            }

        }
        else error();
        return factorVal;
    }
}

