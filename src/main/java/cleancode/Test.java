package cleancode;

import static util.StdOut.print;

/**
 * Test
 *
 * @author Alicia
 * @description
 * @date 2020/6/9
 */
public class Test {

    /**
     * 【before】这个函数过于长，变量的使用贯穿始终。新建类，三个变量做为该类的成员变量。语境的增强
     * 也能让算法分解为更小的函数而变得更为干净利落
     * @param candidate
     * @param count
     */
    private void printGuessStatistics(char candidate, int count) {
        String number;
        String verb;
        String pluralModifier;

        if (count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }
        String guessMessage = String.format(
                "There %s %s %s%s",
        verb, number, candidate, pluralModifier);
        print(guessMessage);
    }
}
