package cleancode;

/**
 * GuessStatisticsMessage
 *
 * @author Alicia
 * @description
 * @date 2020/6/9
 */
public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessasgeParts(count);
        return String.format(
                "There %s %s %s%s",
                verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessasgeParts(int count) {

        if (count == 0) {
            thereAreNoLetters();
        } else if(count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "5";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }
}
