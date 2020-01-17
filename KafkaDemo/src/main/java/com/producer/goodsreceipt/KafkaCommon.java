package com.producer.goodsreceipt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;



/**
 * @author ColinZhou
 *
 *用于定义Kafka 公共数据和方法
 */
public class KafkaCommon {

    public static final String GOOD_RECEIPT = "Scm-WmsToolkit-GoodsReceipt";
    public static final String ORDER_EVENT = "Scm-WmsToolkit-OrderEvents";
    public static final String STOCK_CHECK = "Scm-WmsToolkit-StockCheck";
    public static final String INTERNAL_MOVEMENT = "Scm-WmsToolkit-InternalMovement";
    public static final String RELEASE_ORDER = "Scm-WmsToolkit-ReleaseOrder-Cargo";
    
    
	public static final String AUTHORIZATION = "2QPyzxWf8krUAatfhw2rdywd2fka";
	public static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";
	public static final String PRODUCE_MESSAGES_URL = BASE_URL + "/topics/";
	public static final String INIT_INSTANCE_URL = BASE_URL + "/consumers/cargo";
	public static final String POST_OFFSETS_URL = BASE_URL + "/consumers/cargo/instances/%s/offsets";
	public static final String SUBSCRIPTION = BASE_URL + "/consumers/cargo/instances/%s/subscription";
	public static final String GET_RECORDS = BASE_URL + "/consumers/cargo/instances/%s/records";
	public static final String DELETE_INSTANCE = BASE_URL + "/consumers/cargo/instances/%s";


	
	public static Properties getConfig(){
	    InputStream in = KafkaCommon.class.getClassLoader().getResourceAsStream("kafka.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
	}
	
	public static String getTimestamp(){
		TimeZone tz = TimeZone.getTimeZone("UTC");
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	    df.setTimeZone(tz);
	    
	    String nowAsISO = df.format(new Date());
	    
		return nowAsISO;
	}
	
	public static String getSimpleTimestamp(){
	    
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
	
	public static void backupFile(String path, String fileName, String content){
		PrintWriter out = null;
		try {
			if(path != null && path.length() > 1){
					
					Calendar ca = Calendar.getInstance();
					String year = String.valueOf(ca.get(Calendar.YEAR));
					int month = ca.get(Calendar.MONTH) + 1;
					String mon = month < 10 ? "0" + month : month+"";
					String day = String.valueOf(ca.get(Calendar.DATE));
					if (day.length() == 1) {
						day = "0" + day;
					}
					if(path.endsWith("/")){
						path += year + "/" + year + mon + "/" + year + mon + day + "/";
					}else {
						path += "/" + year + "/" + year + mon + "/" + year + mon + day + "/";

					}
			}	          
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			String name = path + fileName;
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(name)), true);
			out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
}
