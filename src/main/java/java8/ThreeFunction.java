package java8;

/**
 * ThreeFunction
 *
 * @author Alicia
 * @description
 * @date 2021/8/31
 */
@FunctionalInterface
public interface ThreeFunction<T,U,K,R> {
    R apply(T t, U u, K k);
}
