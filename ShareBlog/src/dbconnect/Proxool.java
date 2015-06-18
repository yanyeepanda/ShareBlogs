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
 * ���ݿ����ӳ�
 * @author zhangm
 * 
 */
public class Proxool {

	/**
	 * ��ʶProxool���ݿ����ӳ�ʱ��ע��
	 */
	private static boolean registerFlag = false;

	/**
	 * ȫ�ֵ�Ψһʵ��
	 */
	private static Proxool proxool = null;

	/**
	 * ���ݿ�ı���
	 */
	private static String db_alias = "xml-blogdb";
	
	/**
	 * ����ģʽ-1������ģʽ��2������ģʽ
	 */
	private static int model = 2;
	
	/**
	 * ˽�з�������ֹ�౻�ⲿʵ����
	 * 
	 */
	private Proxool() {
	}

	/**
	 * ���Ψһ��ʵ������
	 * 
	 * @return һ��Ψһ��Proxool����
	 */
	public static Proxool getInstance() {
		if (proxool == null) {
			// ��ȡ������������
			loadDBProperties();
			// ���������ݿ����ӳ�û��ע���ʱ��-ע�����ݿ�����
			if (registerFlag == false && model == 1) {
				
				registerProxool();
			}
			return new Proxool();
		} else {
			return proxool;
		}
	}

	/**
	 * �������ļ��л�����ݿ�ı���
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

			// ��ȡ�õ�ֵ����db_alias��
			db_alias = element.getChildNodes().item(0).getNodeValue();
			
			NodeList list_1 = rootElement.getElementsByTagName("model");
			Element element_1 = (Element) list_1.item(0);

			// ��ȡ�õ�ֵ����model��
			model = Integer.parseInt(element_1.getChildNodes().item(0).getNodeValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ע��Proxool���ݿ�����
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
		} catch (ProxoolException e) {// �׳�����쳣��ԭ����Ҫ����ΪProxool���ӳ��Ѿ�ע�����
			registerFlag = true;
			e.printStackTrace();
		}
	}

	/**
	 * ����һ������
	 */
	public Connection getConnection() {
		// GetConnection�е�String Ϊ"Proxool."+��proxool.xml�ж����alias
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("proxool." + db_alias);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

