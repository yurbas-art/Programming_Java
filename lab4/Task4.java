import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        Box box = new Box(1000);
        Ball ball = new Ball(5);
        Cylinder cylinder = new Cylinder(3, 10);
        Pyramid pyramid = new Pyramid(4, 6);
        box.add(ball);
        box.add(cylinder);
        box.add(pyramid);
        System.out.println(box);
    }

    abstract static class Shape {
        public abstract double getVolume();
    }

    abstract static class SolidOfRevolution extends Shape {
        protected double radius;

        public double getRadius() {
            return radius;
        }
    }

    static class Ball extends SolidOfRevolution {
        public Ball(double radius) {
            this.radius = radius;
        }

        public double getVolume() {
            return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
        }

        public String toString() {
            return "Ball radius=" + radius;
        }
    }

    static class Cylinder extends SolidOfRevolution {
        private double height;

        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        public double getVolume() {
            return Math.PI * Math.pow(radius, 2) * height;
        }

        public String toString() {
            return "Cylinder radius=" + radius + " height=" + height;
        }
    }

    static class Pyramid extends Shape {
        private double s;
        private double h;

        public Pyramid(double s, double h) {
            this.s = s;
            this.h = h;
        }

        public double getVolume() {
            return 1.0 / 3.0 * s * s * h;
        }

        public String toString() {
            return "Pyramid s=" + s + " h=" + h;
        }
    }

    static class Box extends Shape {
        private double capacity;
        private double currentVolume;
        private ArrayList<Shape> shapes;

        public Box(double capacity) {
            this.capacity = capacity;
            this.currentVolume = 0;
            this.shapes = new ArrayList<>();
        }

        public boolean add(Shape shape) {
            if (currentVolume + shape.getVolume() <= capacity) {
                shapes.add(shape);
                currentVolume += shape.getVolume();
                return true;
            }
            return false;
        }

        public double getVolume() {
            return capacity;
        }

        public String toString() {
            return "Box capacity=" + capacity + " used=" + currentVolume;
        }
    }
}
