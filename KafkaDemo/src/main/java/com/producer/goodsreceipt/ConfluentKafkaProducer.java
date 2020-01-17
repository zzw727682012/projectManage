package com.producer.goodsreceipt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class ConfluentKafkaProducer {

	private static final Log log = LogFactory.getLog(ConfluentKafkaProducer.class);

	private CommomHttpClient client;
	
    /**
     * @param topic  消息目的
     * @param record 消息内容
     * @param path   备份路径
     * @param tag	 备份标签
     * @throws IOException
     * 生产者发送消息
     */
    public void produceMessages(String topic, ProducerRecord record, String path, String tag) throws IOException {
    	
    	String url = "https://qa.api.dev4apps.com/kafkaproxy/topics/" + topic;
        String data = JSONObject.toJSONString(record);
        
		String timestamp = KafkaCommon.getSimpleTimestamp();
		String requestName = topic.split("-")[2] + "_"+ tag + "_" + timestamp + "_Request.txt";
		String content = topic + "\n" + data;
		KafkaCommon.backupFile(path, requestName, content);
        CloseableHttpResponse res = client.post(url, data);
        String result = EntityUtils.toString(res.getEntity(), "UTF-8");
        
		String responseName = topic.split("-")[2] +  "_"+ tag + "_" + timestamp + "_Response.txt";
		KafkaCommon.backupFile(path, responseName, topic + "\n" + result);
	
    }
    
}
