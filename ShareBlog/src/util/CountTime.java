package util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountTime {
	/***
	 * ��õ�ǰʱ��
	 * @return
	 */
	public static String GetCurrentTime()
	{
		Date currentTime = new Date(System.currentTimeMillis());   
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
        String dateString = formatter.format(currentTime);   
        return dateString;
	}
	
	/***
	 * ����
	 * @param args
	 */
	public static void main(String []args)
	{
		System.out.println(CountTime.GetCurrentTime());
	}
}
