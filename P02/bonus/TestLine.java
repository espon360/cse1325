import java.util.Arrays;

public class TestLine
{
        public static void main(String[] args)
        {
                for(Color color : Color.values())
                {
                        double x1 = Math.random() * 10;
                        double x2 = Math.random() * 10;
                        double y1 = Math.random() * 10;
                        double y2 = Math.random() * 10;
                        Line line =
                        new Line(x1,x2,y1,y2,color);
                        System.out.println(line);
                }
        }
}
