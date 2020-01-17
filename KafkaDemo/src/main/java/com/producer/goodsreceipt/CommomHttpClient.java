package com.producer.goodsreceipt;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class CommomHttpClient {
	
    private static final CloseableHttpClient client = HttpClients.createDefault();

    public CloseableHttpResponse post(String url, String data)throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url);
		 post.setConfig(getRequestConfig());
		if (data != null) {
			StringEntity stringEntity = new StringEntity(data);
			stringEntity.setContentEncoding("UTF-8");
			post.setEntity(stringEntity);
		}

		post.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
		post.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
		post.setHeader("Authorization", "2QPyzxWf8krUAatfhw2rdywd2fka");
		CloseableHttpResponse res = client.execute(post);
		return res;
	}

    public CloseableHttpResponse get(String url, String parameter) throws ClientProtocolException, IOException{
    	HttpGet get = new HttpGet(url);
        get.setConfig(getRequestConfig());
        get.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
        get.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
        get.setHeader("Authorization", "2QPyzxWf8krUAatfhw2rdywd2fka");
        CloseableHttpResponse res = client.execute(get);
        return res;
    }
    
    public CloseableHttpResponse put(String url, String data){
    	return null;
    }
    public CloseableHttpResponse delete(String url, String data) throws ClientProtocolException, IOException{
    	HttpDelete delete = new HttpDelete();
        delete.setConfig(getRequestConfig());
    	delete.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
    	delete.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
    	delete.setHeader("Authorization", "2QPyzxWf8krUAatfhw2rdywd2fka");
    	CloseableHttpResponse res = client.execute(delete);
        return res;
    }
    
    public RequestConfig getRequestConfig(){
    	HttpHost proxy = new HttpHost("172.16.100.2", 8080);
    	  
    	RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
    	return requestConfig;
    }
}
