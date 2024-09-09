public class TestStudent
{
	public static void main(String[] args)
	{
		Student student = new Student("Juan Guajardo Gutierrez", 1002128662, "jgg8662@mavs.uta.edu");

		//TEST VECTOR #1: Student.toString()
		if (!(student.toString().equals("Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1)")))
		{
			System.err.println("Expected output is Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1) but received " + student.toString());
			System.exit(69);
		}
	}
}

