package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator; 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 数据库连接池
 * @author zhangm
 * 
 */
public class Proxool {

	/**
	 * 标识Proxool数据库连接池时候注册
	 */
	private static boolean registerFlag = false;

	/**
	 * 全局的唯一实例
	 */
	private static Proxool proxool = null;

	/**
	 * 数据库的别名
	 */
	private static String db_alias = "xml-blogdb";
	
	/**
	 * 开发模式-1代表开发模式，2代表发布模式
	 */
	private static int model = 2;
	
	/**
	 * 私有方法，防止类被外部实例化
	 * 
	 */
	private Proxool() {
	}

	/**
	 * 获得唯一的实例对象
	 * 
	 * @return 一个唯一的Proxool对象
	 */
	public static Proxool getInstance() {
		if (proxool == null) {
			// 读取数据连接属性
			loadDBProperties();
			// 当发现数据库连接池没有注册的时候-注册数据库连接
			if (registerFlag == false && model == 1) {
				
				registerProxool();
			}
			return new Proxool();
		} else {
			return proxool;
		}
	}

	/**
	 * 从属性文件中获得数据库的别名
	 */
	private static void loadDBProperties() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Element rootElement;
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new Proxool().getClass().getResourceAsStream("/proxool.xml"));
			rootElement = document.getDocumentElement();
			NodeList list = rootElement.getElementsByTagName("use-proxool");
			Element element = (Element) list.item(0);

			// 将取得的值出入db_alias中
			db_alias = element.getChildNodes().item(0).getNodeValue();
			
			NodeList list_1 = rootElement.getElementsByTagName("model");
			Element element_1 = (Element) list_1.item(0);

			// 将取得的值出入model中
			model = Integer.parseInt(element_1.getChildNodes().item(0).getNodeValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注册Proxool数据库连接
	 * 
	 */
	private static void registerProxool() {
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			InputSource inputSource = new InputSource(new Proxool().getClass().getResourceAsStream("/proxool.xml"));
			JAXPConfigurator.configure(inputSource, false);
			registerFlag = true;
		} catch (ClassNotFoundException e) {
			registerFlag = false;
			e.printStackTrace();
		} catch (ProxoolException e) {// 抛出这个异常的原因主要是因为Proxool连接池已经注册过了
			registerFlag = true;
			e.printStackTrace();
		}
	}

	/**
	 * 返回一个连接
	 */
	public Connection getConnection() {
		// GetConnection中的String 为"Proxool."+在proxool.xml中定义的alias
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("proxool." + db_alias);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

