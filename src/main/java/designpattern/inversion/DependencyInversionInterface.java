package designpattern.inversion;

/**
 * DependencyInversion1
 *
 * @author Alicia
 * @description
 * @date 2021/1/13
 */
public class DependencyInversionInterface {
    // 方式1：通过接口传递实现依赖
    interface IOpenAndClose{
        public void open(ITV tv); //
    }

    interface ITV{
        public void play();
    }


}


