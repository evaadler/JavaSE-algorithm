//package designpattern.adapter.customspringmvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * DispatchServlet
// *
// * @author Alicia
// * @description
// * @date 2021/1/20
// */
//public class DispatchServlet {
//    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();
//
//    public DispatchServlet(){
//        handlerAdapters.add(new AnnotationHandlerAdapter());
//    }
//
//    public void doDispatch(){
//        // 此处模拟SpringMVC从request取handler的对象
//        // 适配器可以获取到希望的Controller
//        // HttpController controller = new HttpController
//        AnnotationController controller = new AnnotationController();
//
//        // 得到对应适配器
//        HandlerAdapter adapter = getHandler(controller);
//        // 通过适配器执行对应的controller对应方法
//        adapter.handle(controller);
//    }
//
//    public HandlerAdapter getHandler(IController controller){
//        for(HandlerAdapter adapter : this.handlerAdapters){
//            if (adapter.supports(controller)){
//                return adapter;
//            }
//        }
//        return null;
//    }
//}
