// TokenType is used to enumerate each different type of token and the criteria to match it
// each enum option contains a string, `pattern`, that is a regex which defines what that token looks like
// it is used by the Lexer class to split a string into an array of tokens
// remember that in Java, each enum case is sortof like an object that can hold its own data -- this is very different from enums in C
enum TokenType {

    NUMBER("[0-9]+(\\.[0-9]+)?"),

    PLUS("\\+"),
    MINUS("\\-"),
    MULTIPLY("\\*"),
    DIVIDE("\\/"),
    EXPONENT("\\^"),

    //sin, cos, tan, ln, atan, atan2

    //Regex replace with "" all matched instances
    ATAN2("atan2"),
    ATAN("atan"),
    SIN("sin"),
    COS("cos"),
    TAN("tan"),
    LOG("ln"),

    


    LPAREN("\\("),
    RPAREN("\\)"),

    COMMA("\\,"),
    VAR("x");

    public final String pattern;

    private TokenType(String pattern) {
        this.pattern = pattern;
    }
}
