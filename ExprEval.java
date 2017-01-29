
import java.lang.*;

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
    return 0;
  }
}


