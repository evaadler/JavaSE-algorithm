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
//    private String compactActual;
//    private String compactExpected;
    private int prefixLength;
    private int suffixLength;

    public ComparisonCompactor(int contextLength, String expected, String actual) {
    }

    public String formatCompactedComparison(String message) {
        String compactExpected = expected;
        String compactActual = actual;
        if (shouldBeCompacted()){
            compactActual = compact(actual);
            compactExpected = compact(expected);
            //return Assert.format(message, expected, actual);
        }
        return Assert.format(compactActual, compactExpected, actual);
    }

//    private void compactExpectedAndActual() {
//
//        findCommonPrefixAndSuffix();
//        compactExpected = compactString(expected);
//        compactActual = compactString(actual);
//    }

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

    private boolean shouldBeCompacted() {
        return !shouldNotBeCompacted();
    }

    private boolean shouldNotBeCompacted() {
        return expected == null || actual == null || expected.equals(actual);
    }


    private String compact(String source) {
        String result = computeCommonPrefix()
                + DELTA_START
                + source.substring(prefixLength, source.length()- suffixLength)
                + DELTA_END
                + computeCommonSuffix();
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

    private String computeCommonPrefix() {
        return (prefixLength > contextLength ? ELLIPSIS : "") +
                expected.substring(Math.max(0, prefixLength - contextLength), prefixLength);
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
