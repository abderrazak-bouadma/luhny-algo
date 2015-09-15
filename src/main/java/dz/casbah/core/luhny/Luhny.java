package dz.casbah.core.luhny;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 11/7/13
 * Time: 2:45 PM
 */
public class Luhny {

    private static String backup;
    private static final String SECRECT_FILTER = "X";

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException(hint());
        }
        String rawString = args[0];
        backup = rawString;
        System.out.print(filterCreditCartDigits(rawString));
        System.exit(0);
    }

    private static String hint() {
        return "You may provide at least one argument " +
                "which is a String of credit card digits " +
                "-between 14 and 16- separated with white spaces or dash '-'";
    }

    private static String filterCreditCartDigits(String rawString) {
        if (check(rawString)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < backup.length(); i++) {
                if (!backup.substring(i).equals(" ") && !backup.substring(i).equals("-")) {
                    sb.append(SECRECT_FILTER);
                } else {
                    sb.append(backup.substring(i));
                }
            }
            return sb.toString();
        }
        return backup;
    }

    public static boolean check(String s) {
        if (!StringUtils.isBlank(s) && s.length() >= 4 && s.length() <= 16) {
            final String cleanedReversedString = cleanString(s);
            int sum = 0;
            for (int i = 0; i < cleanedReversedString.length(); i++) {
                int digit = Integer.parseInt(cleanedReversedString.substring(i));
                digit *= 2;
                if (digit > 9) {
                    final String s1 = String.valueOf(digit);
                    digit = 0;
                    for (int j = 0; j < s1.length(); j++) {
                        digit += Integer.parseInt(s1.substring(j));
                    }
                }
                sum += digit;
            }
            if (sum % 10 == 0)
                return true;
        }
        return false;
    }

    private static String cleanString(String s) {
        final String remove = StringUtils.remove(s, " ");
        final String remove1 = StringUtils.remove(remove, "-");
        return StringUtils.reverse(remove1);
    }
}
