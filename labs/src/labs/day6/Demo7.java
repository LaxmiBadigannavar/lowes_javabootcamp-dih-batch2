package labs.day6;
abstract class Shape{
    public double length;
    public double height;
    public double radius;
    public final float pie = 3.14f;
    public abstract void getArea();
}

class Rectangle extends Shape{
    public Rectangle(double length, double height){
        this.length = length;
        this.height = height;
    }
    public void draw(){
        System.out.println("drawing....");
    }

    @Override
    public void getArea() {
        System.out.println("Area of Rectangle: "+ (length * height));
    }
}

class Circle extends Shape{
    public Circle(double radius){
        this.radius = radius;
    }

    public void create(){
        System.out.println("drawing...");
    }

    @Override
    public void getArea() {
        System.out.println("Area of Circle: "+ (pie * radius * radius));
    }
}

public class Demo7 {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(14, 20);
        rectangle.draw();
        rectangle.getArea();

        Circle circle = new Circle(60);
        circle.create();
        circle.getArea();

	}

}
