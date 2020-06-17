package cleancode.old.junitcase;

import junit.framework.Assert;

/**
 * ComparisonCompactor
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class ComparisonCompactor {
    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";

    private int contextLength;
    private String expected;
    private String actual;
    private int prefix;
    private int suffix;
    private String compactActual;
    private String compactExpected;
    private int prefixLength;
    private int suffixLength;

    public ComparisonCompactor(int contextLength, String expected, String actual) {
    }

    public String formatCompactedComparison(String message) {
        if (canBeCompact()){
            return Assert.format(message, expected, actual);
        }
        return Assert.format(compactActual, compactExpected, actual);
    }

    private void compactExpectedAndActual() {
        //prefixLength = findCommonPrefix();
        //suffixLength = findCommonSuffix();
        findCommonPrefixAndSuffix();
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private void findCommonPrefixAndSuffix() {
        findCommonPrefix();
        suffixLength = 0;
        for (; !suffixOverlapsPrefix(suffixLength); suffixLength++){
            if (charFromEnd(expected, suffixLength) != charFromEnd(actual, suffixLength)){
                break;
            }
        }
    }

    private char charFromEnd(String s, int i) {
        return s.charAt(s.length() - i - 1);
    }

    private boolean suffixOverlapsPrefix(int suffixLength) {
        return actual.length() - suffixLength <= prefixLength ||
                expected.length() - suffixLength <= prefixLength;
    }

    private boolean canBeCompact() {
        return expected != null && actual != null && areStringsEqual();
    }


    private String compactString(String source) {
        String result = DELTA_START
                + source.substring(prefix, source.length()- suffixLength)
                + DELTA_END;
        if (prefixLength > 0) {
            result = computeCommonPrefix() + result;
        }
        if (suffixLength > 0) {
            result = result + computeCommonSuffix();
        }
        return result;
    }

    private void findCommonPrefix() {
        int prefixIndex = 0;
        int end = Math.min(expected.length(), actual.length());
        for (; prefixIndex < end; prefixIndex++) {
            if (expected.charAt(prefixIndex) != actual.charAt(prefixIndex)){
                break;
            }
        }
    }

    private int findCommonSuffix() {
        int expectedSuffix = expected.length() - 1;
        int actualSuffix = actual.length() -1;
        for (; actualSuffix >= prefixLength && expectedSuffix >= prefix; actualSuffix--,expectedSuffix--){
            if (expected.charAt(expectedSuffix) != actual.charAt(actualSuffix)){
                break;
            }
        }
        return expected.length() - expectedSuffix;
    }

    private String computeCommonPrefix() {
        return (prefix > contextLength ? ELLIPSIS : "") +
                expected.substring(Math.max(0, prefix - contextLength), prefix);
    }

    private String computeCommonSuffix() {
        int end = Math.min(expected.length() - suffixLength + contextLength,
                expected.length() );
        return expected.substring(expected.length() - suffixLength, end) +
                (expected.length() - suffixLength < expected.length() -
                        contextLength ? ELLIPSIS : "");
    }

    private boolean areStringsEqual() {
        return expected.equals(actual);
    }

}
