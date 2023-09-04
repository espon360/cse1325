import java.util.Arrays;

public class Line // constructor
{
        private double x1;
        private double y1;
        private double x2;
        private double y2;
        private Color color;

        public Line(double x1, double x2, double y1, double y2, Color color)
        {
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;
                this.color = color;
        }
        @Override // methods
        public length() // uses distance formula then returns value
        {
                double x = (x1-x2) * (x1-x2);
                double y = (y1-y2) * (y1-y2);
                return Math.sqrt(x+y);
        }
        public String toString() // returns string as formatted in homework
        {
                return color + "(" + x1 + "," + y1 + ") - (" + x1 + "," + y1 +
                ") has length " + length(); // length method called
        }
}
