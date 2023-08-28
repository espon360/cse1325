import java.util.Scanner;

public class Hello
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = in.nextLine();
		System.out.println("Hello, " + name);
	}
}
