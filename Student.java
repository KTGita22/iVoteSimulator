
// Class for Student; set the unique ID and dictate their answer selection.

public class Student 
{
	private int studentID;
	private String studentAnswer;
	
	public Student(int id)
	{
		this.setId(id);
	}

	public int getId() 
	{
		return studentID;
	}

	public void setId(int id) 
	{
		this.studentID = id;
	}
	
	public String getStudentAnswer()
	{
		return studentAnswer;
	}
	
	public void chooseAnswer(int number)
	{
		// Randomly assign studentAnswer with A, B, C, or D based on number of answers the question has.
		this.studentAnswer = "" + (char) ((int) (Math.random() * number) + 65);	
	}
	
	public void chooseMultipleAnswers(int number)
	{
		String s = "";
		for (int a = 0; a < number; a++)
		{
			// If random number is 0, add letter to student's answer.
			if ((int)(Math.random() * 2) == 0)
			{
				s += (char)(a + 65);
			}
		}
		studentAnswer = s;
	}
}
