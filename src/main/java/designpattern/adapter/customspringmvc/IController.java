package designpattern.adapter.customspringmvc;

/**
 * @author fifi
 */
public interface IController {

        }
class HttpController {
    public void doHttpHandler(){
        System.out.println("http...");
    }
}
 class AnnotationController {
    public void doAnnotationHandler(){
        System.out.println("annotation...");
    }

     public void doSimpleHandler() {
     }
 }