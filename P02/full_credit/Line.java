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
                if(x1 > x2)
                {
                      this.x1 = x1;
                      this.x2 = x2;
                }
                else
                {
                      this.x1 = x2;
                      this.x2 = x1;
                }

                if(y1 > y2)
                {
                      this.y1 = y1;
                      this.y2 = y2;
                }
                else
                {
                      this.y1 = y2;
                      this.y2 = y1;
                }

                this.color = color;
        }

        public double length() // uses distance formula then returns value
        {
                double x = (x1-x2) * (x1-x2);
                double y = (y1-y2) * (y1-y2);
                return Math.sqrt(x+y);
        }
        public String toString() // returns string as formatted in homework
        {
                return color + "(" + x1 + "," + y1 + ") - (" + x2 + "," + y2 +
                ") has length " + length(); // length method called
        }
}
