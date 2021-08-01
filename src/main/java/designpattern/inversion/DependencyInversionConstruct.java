package designpattern.inversion;

/**
 * DependencyInversion1
 *
 * @author Alicia
 * @description
 * @date 2021/1/13
 */
public class DependencyInversionConstruct {
    // 方式2：通过构造器实现依赖
    interface IOpenAndClose{
        public void open(); //
    }

    interface ITV{
        public void play();
    }

    // 实现接口
    class OpenAndClose implements IOpenAndClose{
        ITV itv;  // 成员

        public OpenAndClose(ITV itv){ // 构造器
            this.itv = itv;
        }

        @Override
        public void open() {
            itv.play();
        }
    }
}


