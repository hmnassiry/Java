import java.io.*;

public class CreateFile
{
	private final String directory = ".";
	private static File  fileName;

	public CreateFile (String fileName)
	{
		this.fileName = new File (directory, fileName);
	}

	public void createFileName()
	{

		try
		{
			fileName.createNewFile();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static File getFileName()
	{
		return fileName;
	}

}
