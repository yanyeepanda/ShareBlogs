package util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountTime {
	/***
	 * 获得当前时间
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
	 * 测试
	 * @param args
	 */
	public static void main(String []args)
	{
		System.out.println(CountTime.GetCurrentTime());
	}
}
