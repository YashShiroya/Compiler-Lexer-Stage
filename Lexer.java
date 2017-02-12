import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

// the Lexer class encapsulates all of the logic related to tokenStructs --
// It handles converting an expression string into an array of tokenStructs,
// as well as the functions that the parser uses to consume that array of tokenStructs
public class Lexer {
    private String expression;
    private ArrayList<TokenStruct> tokenStructs;

    boolean lexer_debug = false;

    public Lexer(String expression) {
        this.expression = expression.replaceAll("\\s+", ""); // remove all of the spaces from the input expression
        this.tokenize(); // initialize our token array from the expression string
    }

    // Simply prints each token. You wouldn't need anything like this except for debugging
    public void printTokens() {
        for (TokenStruct t : tokenStructs) {
            System.out.printf("%s ", t.toString());
            System.out.print("\n");
        }
	System.out.print("\n");
    }


    //____________

    //Experimental methods

   public ArrayList<TokenStruct> releaseTokenList() {
        // System.out.println("Accessed: releaseTokenList");
        return tokenStructs;
   }

    //____________

    // This function converts this.expression into an array of tokenStructs
    private void tokenize() {

        // System.out.println("debug_mode: " + lexer_debug);

        tokenStructs = new ArrayList<TokenStruct>();
        StringBuilder buffer = new StringBuilder(); // use a StringBuilder because string concatenation in Java is expensive
        
        // loop through all of the enum values (In this example, it will give NUMBER, PLUS, LPAREN, and RPAREN)
        for (TokenType tokenType : TokenType.values()) {
            // here lies the magic...
            // as an `enum`, the TokenType class provides a default String name() method which returns the literal name of the token (such as NUMBER, PLUS, etc...)
            String tokenName = tokenType.name();

            // remember that each TokenType had an associated string called "pattern" that contained the regex needed to match that particular type of token
            String tokenPattern = tokenType.pattern;

            // what we are doing is building up one really long regex from a bunch of small regexes here
            // this creates a series of "matching groups" -- see http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#groupname
            // It allows you to match a specific portion of a longer regex and refer to it later by name
            // the () creates a group
            // the ?<string> at the beginning gives that group the name "string"
            // after the name to before the end of the group is the actual pattern that that group should match
            buffer.append(String.format("|(?<%s>%s)", tokenName, tokenPattern));
        }

        // the result of the above loop will be the following string:
        // "|(?<NUMBER>[0-9]+(\\.[0-9]+)?)|(?<PLUS>\+)|(?<LPAREN>\()|(?<RPAREN>\))"

        //________________

        //Experimental
        /*
         * Make a copy of expression
         * Iterate and check with all 'values' in enum and "replace" with "<blank>"
         * Check if expression string is empty?
         */

        String expressionReplaced = expression;

            for(TokenType t: TokenType.values()) {
               expressionReplaced = expressionReplaced.replaceAll(t.pattern, "");
               if(true) {
                    System.out.println("exp replaced " + t.name() + ": " + expressionReplaced);
               }
            }
        
        //________________
        
        if(lexer_debug) System.out.println("len: " + expressionReplaced.length());

        if(expressionReplaced.length() != 0) {
            System.out.print("err_str:" + expressionReplaced + " \n");
            System.out.println("Error: Lexer detected unidentified tokens.");
        }

        // we create a pattern object from the above regex, minus the first character (since its an extraneous | character that was just an artifact of looping)
        Pattern pattern = Pattern.compile(buffer.substring(1));

        // the pattern object gives us access to a customized matcher object based on the pattern and the input string
        Matcher matcher = pattern.matcher(expression);
        
        // matcher.find() starts at the beginning the string or the end of the last thing found by matcher.find() and returns true if there is anything in the remainder of the string matches anything in the regex
        while (matcher.find()) {
            // figure out which token it matched
            for (TokenType tokenType : TokenType.values()) {
                if (matcher.group(tokenType.name()) != null) {
                    // the name of the group that was matched corresponds to the name of the TokenType
                    // we have found a token!
                    // a new TokenStruct object to the list of tokenStructs with the correct type and data
                    tokenStructs.add(new TokenStruct(tokenType, matcher.group(tokenType.name())));
                    break;
                }
            }
        }
    }
}
