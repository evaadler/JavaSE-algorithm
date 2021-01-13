package designpattern.ocp;

import sun.java2d.loops.DrawGlyphList;

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
    }
}

// 绘图类
class GraphicEditor{
    // 接收shape对象，根据不同的type绘制不同的图形
    public void drawShape(Shape s){
        if (s.type ==1 ){
            drawRectangle(s);
        }else if (s.type == 2){
            drawCircle(s);
        }

    }

    public void drawRectangle(Shape r){
        System.out.println("矩形");
    }

    public void drawCircle(Shape r){
        System.out.println("圆形");
    }
}

class Shape{
    int type = 0;
}

class Rectangle extends Shape{
    Rectangle(){
        type = 1;
    }
}

class Circle extends  Shape{
    Circle(){
        type = 2;
    }
}