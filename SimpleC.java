/* SimpleC.java */
/* Generated By:JavaCC: Do not edit this line. SimpleC.java */
/** Simple brace matcher. */
public class SimpleC implements SimpleCConstants {

  /** Main entry point. */
  public static void main(String args[]) throws ParseException {
    SimpleC parser = new SimpleC(System.in);
    //parser.Input();
    parser.goal();
  }

/**Root production. */
// void Input() : {} {
//     goal();
// }

// int anytoken():
// {
//   Token t;
//   int count=0;
// }
// {
//   (
//     t = <LPARENT> { System.out.println("LPARENT, \""+t.image+"\"" ); count++; } |
//     t = <RPARENT> { System.out.println("RPARENT, \""+t.image+"\"" ); count++; } | 
//     t = <OTHER_CHAR> { System.out.println("OTHER_CHAR, \""+t.image+"\"" ); count++; }
//     )+

//   {return count;}


// }

//Begin Grammar
  static final public 
void goal() throws ParseException {
    program();
    jj_consume_token(0);
  }

  static final public void program() throws ParseException {
    function_or_var_list();
  }

//This
  static final public void function_or_var_list() throws ParseException {
    var_type();
    jj_consume_token(ID);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPARENT:
      case COMMA:
      case SEMICOLON:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPARENT:{
        function();
        break;
        }
      case COMMA:
      case SEMICOLON:{
        global_var();
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//This
  static final public void function() throws ParseException {
    jj_consume_token(LPARENT);
    arguments();
    jj_consume_token(RPARENT);
    compound_statement();
  }

  static final public void arg_list() throws ParseException {
    arg();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      arg();
    }
  }

  static final public void arguments() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CHARSTARSTAR:
    case CHARSTAR:
    case LONGSTAR:
    case LONG:
    case VOID:
    case DOUBLESTAR:
    case DOUBLE:{
      arg_list();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  static final public void arg() throws ParseException {
    var_type();
    jj_consume_token(ID);
  }

//This
  static final public void global_var() throws ParseException {
    global_var_list();
    jj_consume_token(SEMICOLON);
  }

//This
  static final public void global_var_list() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      jj_consume_token(ID);
    }
  }

  static final public void var_type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CHARSTAR:{
      jj_consume_token(CHARSTAR);
      break;
      }
    case CHARSTARSTAR:{
      jj_consume_token(CHARSTARSTAR);
      break;
      }
    case DOUBLE:{
      jj_consume_token(DOUBLE);
      break;
      }
    case DOUBLESTAR:{
      jj_consume_token(DOUBLESTAR);
      break;
      }
    case LONG:{
      jj_consume_token(LONG);
      break;
      }
    case LONGSTAR:{
      jj_consume_token(LONGSTAR);
      break;
      }
    case VOID:{
      jj_consume_token(VOID);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//This
// Take common, factor <ID>
  static final public void assignment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case EQUAL:{
      jj_consume_token(EQUAL);
      expression();
      break;
      }
    case LBRACE:{
      jj_consume_token(LBRACE);
      expression();
      jj_consume_token(RBRACE);
      jj_consume_token(EQUAL);
      expression();
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//This here
//Warning root for call()
  static final public void call() throws ParseException {
    jj_consume_token(LPARENT);
    call_arguments();
    jj_consume_token(RPARENT);
  }

  static final public void call_arg_list() throws ParseException {
    expression();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      expression();
    }
  }

  static final public void call_arguments() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LPARENT:
    case AMPERSAND:
    case PLUS:
    case MINUS:
    case TIMES:
    case ID:
    case STRING_CONST:
    case INTEGER_CONST:
    case DOUBLE_CONST:{
      call_arg_list();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void expression() throws ParseException {
    logical_or_expr();
  }

  static final public void logical_or_expr() throws ParseException {
    logical_and_expr();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OROR:{
        ;
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      jj_consume_token(OROR);
      logical_and_expr();
    }
  }

  static final public void logical_and_expr() throws ParseException {
    equality_expr();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ANDAND:{
        ;
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      jj_consume_token(ANDAND);
      equality_expr();
    }
  }

  static final public void equality_expr() throws ParseException {
    relational_expr();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EQUALEQUAL:
      case NOTEQUAL:{
        ;
        break;
        }
      default:
        jj_la1[11] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EQUALEQUAL:{
        jj_consume_token(EQUALEQUAL);
        relational_expr();
        break;
        }
      case NOTEQUAL:{
        jj_consume_token(NOTEQUAL);
        relational_expr();
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//This
//Taking out common. Not necessary.
  static final public void relational_expr() throws ParseException {
    additive_expr();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LESSEQUAL:
      case GREATEQUAL:
      case LESS:
      case GREAT:{
        ;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LESS:{
        jj_consume_token(LESS);
        break;
        }
      case GREAT:{
        jj_consume_token(GREAT);
        break;
        }
      case LESSEQUAL:{
        jj_consume_token(LESSEQUAL);
        break;
        }
      case GREATEQUAL:{
        jj_consume_token(GREATEQUAL);
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      additive_expr();
    }
  }

  static final public void additive_expr() throws ParseException {
    multiplicative_expr();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      multiplicative_expr();
    }
  }

//This
  static final public void multiplicative_expr() throws ParseException {
    unary_expr();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:
      case DIVIDE:
      case PERCENT:{
        ;
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:{
        jj_consume_token(TIMES);
        unary_expr();
        break;
        }
      case DIVIDE:{
        jj_consume_token(DIVIDE);
        unary_expr();
        break;
        }
      case PERCENT:{
        jj_consume_token(PERCENT);
        unary_expr();
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//This
  static final public void unary_expr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LPARENT:
    case ID:
    case STRING_CONST:
    case INTEGER_CONST:
    case DOUBLE_CONST:{
      primary_expr();
      break;
      }
    case AMPERSAND:
    case PLUS:
    case MINUS:
    case TIMES:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        break;
        }
      case AMPERSAND:{
        jj_consume_token(AMPERSAND);
        break;
        }
      case TIMES:{
        jj_consume_token(TIMES);
        break;
        }
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      unary_expr();
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//This
  static final public void primary_expr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STRING_CONST:{
      jj_consume_token(STRING_CONST);
      break;
      }
    case ID:{
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPARENT:
      case LBRACE:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LBRACE:{
          jj_consume_token(LBRACE);
          expression();
          jj_consume_token(RBRACE);
          break;
          }
        case LPARENT:{
          call();
          break;
          }
        default:
          jj_la1[21] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[22] = jj_gen;
        ;
      }
      break;
      }
    case INTEGER_CONST:{
      jj_consume_token(INTEGER_CONST);
      break;
      }
    case DOUBLE_CONST:{
      jj_consume_token(DOUBLE_CONST);
      break;
      }
    case LPARENT:{
      jj_consume_token(LPARENT);
      expression();
      jj_consume_token(RPARENT);
      break;
      }
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void compound_statement() throws ParseException {
    jj_consume_token(LCURLY);
    statement_list();
    jj_consume_token(RCURLY);
  }

  static final public void statement_list() throws ParseException {
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPARENT:
      case LCURLY:
      case LBRACE:
      case EQUAL:
      case CHARSTARSTAR:
      case CHARSTAR:
      case LONGSTAR:
      case LONG:
      case VOID:
      case IF:
      case WHILE:
      case DO:
      case FOR:
      case CONTINUE:
      case BREAK:
      case RETURN:
      case DOUBLESTAR:
      case DOUBLE:{
        ;
        break;
        }
      default:
        jj_la1[24] = jj_gen;
        break label_11;
      }
      statement();
    }
  }

  static final public void local_var() throws ParseException {
    var_type();
    local_var_list();
    jj_consume_token(SEMICOLON);
  }

  static final public void local_var_list() throws ParseException {
    jj_consume_token(ID);
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[25] = jj_gen;
        break label_12;
      }
      jj_consume_token(COMMA);
      jj_consume_token(ID);
    }
  }

  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LBRACE:
    case EQUAL:{
      assignment();
      jj_consume_token(SEMICOLON);
      break;
      }
    case LPARENT:{
      call();
      jj_consume_token(SEMICOLON);
      break;
      }
    case CHARSTARSTAR:
    case CHARSTAR:
    case LONGSTAR:
    case LONG:
    case VOID:
    case DOUBLESTAR:
    case DOUBLE:{
      local_var();
      break;
      }
    case LCURLY:{
      compound_statement();
      break;
      }
    case IF:{
      jj_consume_token(IF);
      jj_consume_token(LPARENT);
      expression();
      jj_consume_token(RPARENT);
      statement();
      else_optional();
      break;
      }
    case WHILE:{
      jj_consume_token(WHILE);
      jj_consume_token(LPARENT);
      expression();
      jj_consume_token(RPARENT);
      statement();
      break;
      }
    case DO:{
      jj_consume_token(DO);
      statement();
      jj_consume_token(WHILE);
      jj_consume_token(LPARENT);
      expression();
      jj_consume_token(RPARENT);
      jj_consume_token(SEMICOLON);
      break;
      }
    case FOR:{
      jj_consume_token(FOR);
      jj_consume_token(LPARENT);
      assignment();
      jj_consume_token(SEMICOLON);
      expression();
      jj_consume_token(SEMICOLON);
      assignment();
      jj_consume_token(RPARENT);
      statement();
      break;
      }
    case CONTINUE:
    case BREAK:
    case RETURN:{
      jump_statement();
      break;
      }
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void else_optional() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ELSE:{
      jj_consume_token(ELSE);
      statement();
      break;
      }
    default:
      jj_la1[27] = jj_gen;
      ;
    }
  }

  static final public void jump_statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CONTINUE:{
      jj_consume_token(CONTINUE);
      jj_consume_token(SEMICOLON);
      break;
      }
    case BREAK:{
      jj_consume_token(BREAK);
      jj_consume_token(SEMICOLON);
      break;
      }
    case RETURN:{
      jj_consume_token(RETURN);
      return_val_opt();
      jj_consume_token(SEMICOLON);
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void return_val_opt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LPARENT:
    case AMPERSAND:
    case PLUS:
    case MINUS:
    case TIMES:
    case ID:
    case STRING_CONST:
    case INTEGER_CONST:
    case DOUBLE_CONST:{
      expression();
      break;
      }
    default:
      jj_la1[29] = jj_gen;
      ;
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public SimpleCTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[30];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc100,0xc100,0x4000,0x80000000,0x4000,0x80000000,0x11000,0x4000,0x1c040100,0x80000,0x20000,0x300000,0x300000,0x3c00000,0x3c00000,0xc000000,0xc000000,0x70000000,0x70000000,0x1c040000,0x1c040100,0x1100,0x1100,0x100,0x80011500,0x4000,0x80011500,0x0,0x0,0x1c040100,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x300f,0x0,0x300f,0x0,0x0,0x74000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x74000,0x0,0x0,0x74000,0x3fdf,0x0,0x3fdf,0x20,0xe00,0x74000,};
   }

  /** Constructor with InputStream. */
  public SimpleC(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SimpleC(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new SimpleCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public SimpleC(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new SimpleCTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public SimpleC(SimpleCTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(SimpleCTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[57];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 30; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 57; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
