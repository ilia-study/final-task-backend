package tenders.server.utils;

public class Utils {
  private final static String PERCENT = "%";

  public static String wrapStringLikeExpression(String expression) {
    return PERCENT + expression + PERCENT;
  }
}
