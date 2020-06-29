package java8;

/**
 * TwoParamsFunctional
 *
 * @author Alicia
 * @description
 * @date 2020/6/22
 */
@FunctionalInterface
public interface TwoParamsFunctional<T, R> {
    public R process(T t1, T t2);
}
