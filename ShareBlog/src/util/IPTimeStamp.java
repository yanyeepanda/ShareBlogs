package util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 上传下载文件名
 * @author coder
 *
 */
public class IPTimeStamp {
	private SimpleDateFormat sdf=null;
	private String ip=null;
	public IPTimeStamp()
	{}
	public IPTimeStamp(String ip)
	{
		this.ip=ip;
	}
	
	/**
	 * 生成上传下载文件名的方法   ip地址+时间+3位随机数
	 * @return
	 */
	public String getIpTimeRand()
	{
		StringBuffer buf =new StringBuffer();
		if(this.ip!=null)
		{
			String s[]=this.ip.split("\\.");
			for(int i=0;i<s.length;i++)
			{
				buf.append(this.addZero(s[i], 3));
			}
		}
		buf.append(this.getTimeStamp());
		Random r=new Random();
		for(int i=0;i<3;i++)
		{
			buf.append(r.nextInt(10));
		}
		return buf.toString();
	}
	
	public String getTimeStamp()
	{
		this.sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return this.sdf.format(new Date());
	}
	
	/**
	 * 获得当前系统时间
	 * @return
	 */
	public String getTime()
	{
		this.sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");
		return this.sdf.format(new Date());
	}
	
	private String addZero(String str,int len)
	{
		StringBuffer s=new StringBuffer();
		s.append(str);
		while(s.length()<len)
		{
			s.insert(0, 0);
		}
		return s.toString();
	}
	
	/***
	 * test
	 * @param args
	 */
	public static void main(String args[])
	{
		System.out.println(new IPTimeStamp("129.22.221.12").getIpTimeRand());
	}
}
