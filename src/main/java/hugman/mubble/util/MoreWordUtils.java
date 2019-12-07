package hugman.mubble.util;

public class MoreWordUtils
{
	public static String pluralize(int number, String text)
	{
		if(number == 0 ||number == 1)
		{
			return number + " " + text;
		}
		else
		{
			if(text.endsWith("y"))
			{
				return number + " " + text.substring(0, text.length() - 1) + "ies";
			}
			else
			{
				return number + " " + text + "s";
			}
		}
	}
}