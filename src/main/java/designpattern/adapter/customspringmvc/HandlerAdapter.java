//package designpattern.adapter.customspringmvc;
//
///**
// * HandlerAdapter
// *
// * @author Alicia
// * @description
// * @date 2021/1/20
// */
// public interface HandlerAdapter {
//     boolean supports(IController controller);
//
//     void handle(AnnotationController controller) ;
//}
//
//class SimpleHandlerAdapter implements HandlerAdapter{
//
//    @Override
//    public void handle(AnnotationController handler){
//        ((AnnotationController)handler).doSimpleHandler();
//    }
//    @Override
//    public boolean supports(IController handler){
//        return (handler instanceof SimpleController);
//    }
//}
