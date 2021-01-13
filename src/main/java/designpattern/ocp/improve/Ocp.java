package designpattern.ocp.improve;

/**
 * Ocp
 *
 * @author Alicia
 * @description
 * @date 2021/1/13
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle() );
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Other());
    }
}

// 绘图类
class GraphicEditor{
    // 接收shape对象，根据不同的type绘制不同的图形
    public void drawShape(Shape s){
       s.draw();
    }
}

abstract class Shape{
    int type = 0;
    abstract void draw();
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("矩形");

    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("圆形");
    }
}

class Trangle extends Shape {
    @Override
    void draw() {
        System.out.println("三角形");
    }
}

// 新增一个图形
class Other extends Shape{

    @Override
    void draw() {
        System.out.println("其他图形");
    }
}