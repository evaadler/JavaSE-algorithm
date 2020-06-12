package cleancode.old.literatePrimes;

/**
 * PrimePrinter 主程序
 * 处理执行环境。如果调用方式改变，它也会随之改变。
 * 例如：如果程序被转换为SOAP服务，则该类也会被影响到
 *
 * @author Alicia
 * @description
 * @date 2020/6/12
 */
public class PrimePrinter {

    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 1000;
        int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);

        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        RowColumnPagePrinter tablePrinter =
                new RowColumnPagePrinter(ROWS_PER_PAGE,
                        COLUMNS_PER_PAGE,
                        "The first " + NUMBER_OF_PRIMES +
                " Prime Numbers");
        tablePrinter.print(primes);
    }
}
