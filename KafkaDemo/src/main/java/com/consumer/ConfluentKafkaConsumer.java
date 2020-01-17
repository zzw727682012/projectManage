package com.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConfluentKafkaConsumer {

    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";

    public static void main(String[] args) throws IOException, KeyManagementException, NoSuchAlgorithmException, InterruptedException {
        String sub = BASE_URL + "/consumers/cargo_colin/instances/colin/subscription";
        String instance = BASE_URL + "/consumers/cargo_colin/instances/colin";
        String getTopic = BASE_URL + "/topics/Scm-WmsToolkit-GoodsReceipt/partitions";


        final ConfluentKafkaConsumer consumer = new ConfluentKafkaConsumer();
        consumer.initInstance();
        consumer.subscription("Scm-WmsToolkit-RMA-Cargo");
        consumer.getOffsets();
        consumer.getRecords();
        consumer.getRecords();
        consumer.getRecords();
        consumer.getRecords();
//        consumer.getRecords();
       // consumer.postOffsets();

        consumer.getOffsets();

        consumer.httpDelete(sub);
        consumer.httpDelete(instance);

    }

    public void initInstance() throws IOException {
        String url = BASE_URL + "/consumers/cargo_colin";
        String data = "{ \"name\": \"colin\",\n" +
                "  \"format\": \"binary\",\n" +
                "  \"auto.offset.reset\": \"earliest\",\n" +
                "  \"auto.commit.enable\": \"false\"\n" +
                "}";
        httpPost(url, data);
    }

    public void getOffsets() throws IOException, InterruptedException {
        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/offsets";
      /*  String offset = "{\"offsets\":[{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":0,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":1,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":2,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":3,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":4,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":5,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":6,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":7,\"offset\":0}]}";
        httpPost(url,offset);*/

       // String data = "{\"partitions\":[{\"partition\":0,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":1,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":2,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":3,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":4,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":5,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":6,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":7,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}]}";
        String data = "{\"partitions\":[{\"partition\":0,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":1,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":2,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":3,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":4,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":5,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":6,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":7,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}]}";

        httpGet(url, data);
    }

    public void postOffsets() throws IOException, InterruptedException {
        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/offsets";

        String data = "{\"offsets\":[" +
                "{\"offset\":1300 ,\"partition\":0 ,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}," +
                "{\"offset\":1300 ,\"partition\":1 ,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}," +
                "{\"offset\":1300 ,\"partition\":2 ,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}" +

                "]}";
        httpPost(url, data);
    }

    public void subscription(String topic) throws IOException {
        List<String> topicList = new ArrayList<String>();
        topicList.add(topic);
        String data = "{ \n" +
                "  \"topics\" : [ \n" +
                "    \"Scm-WmsToolkit-Labelling-Cargo\"\n" +
                "  ] \n" +
                "}\n";
        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/subscription";
        httpPost(url, data);
    }

    public void getRecords() throws IOException, InterruptedException {

        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/records";
        httpGet(url, null);

    }

    private void httpPost(String url, String data) throws IOException {
        System.out.println("post:url:" + url);
        System.out.println("data:" + data);
        HttpPost post = new HttpPost(url);
        HttpHost proxy = new HttpHost("172.16.100.2", 8080);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        post.setConfig(requestConfig);
        String authorization = "2QPyzxWf8krUAatfhw2rdywd2fka";
        StringEntity stringEntity = new StringEntity(data);
        stringEntity.setContentEncoding("UTF-8");
        post.setEntity(stringEntity);
        post.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
        post.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
        post.setHeader("Authorization",  "2QPyzxWf8krUAatfhw2rdywd2fka");
        CloseableHttpResponse res = client.execute(post);
        System.out.println(res.getStatusLine().getStatusCode());
        if (res.getEntity() != null) {
            String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
            System.out.println(result);
        }
    }

    public void httpGet(String url, String data) throws IOException, InterruptedException {
        HttpGet get = new HttpGet(url);

        if (data != null) {
            HttpGetWithEntity getWithEntity = new HttpGetWithEntity(url);
            StringEntity stringEntity = new StringEntity(data);
            stringEntity.setContentEncoding("UTF-8");
            getWithEntity.setEntity(stringEntity);

            String authorization = "2QPyzxWf8krUAatfhw2rdywd2fka";
            System.out.println("get:url:" + url);
            HttpHost proxy = new HttpHost("172.16.100.2", 8080);
            RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
            getWithEntity.setConfig(requestConfig);
            getWithEntity.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
            getWithEntity.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
            getWithEntity.setHeader("Authorization", authorization);
            CloseableHttpResponse res = client.execute(getWithEntity);
            System.out.println(res.getStatusLine().getStatusCode());

            if (res.getEntity() != null) {
                String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
                System.out.println(result);
            }
            return;
        }
        String authorization = "2QPyzxWf8krUAatfhw2rdywd2fka";
        System.out.println("get:url:" + url);
        HttpHost proxy = new HttpHost("172.16.100.2", 8080);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        get.setConfig(requestConfig);
        get.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
        get.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
        get.setHeader("Authorization", authorization);
        CloseableHttpResponse res = client.execute(get);
        System.out.println(res.getStatusLine().getStatusCode());

        if (res.getEntity() != null) {
            String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：

            List<ConsumerRecordResponseDTO> record = JSONObject.parseArray(result, ConsumerRecordResponseDTO.class);
            System.out.println(result);

            if(record != null && record.size() != 0){
                System.out.println("-----------------"+record.size());
                for (ConsumerRecordResponseDTO r :  record) {

                    List<PostOffsetDTO> posList = new ArrayList<PostOffsetDTO>();
                    PostOffsetDTO dto =new PostOffsetDTO();
                    dto.setTopic("Scm-WmsToolkit-Labelling-Cargo");
                    dto.setOffset(r.getOffset());
                    dto.setPartition(r.getPartition());
                    posList.add(dto);
                    PostOffsetsRequestDTO postOffsetsRequestDTO = new PostOffsetsRequestDTO();
                    postOffsetsRequestDTO.setOffsets(posList);
                    data = JSONObject.toJSONString(postOffsetsRequestDTO);

                    String commitUrl = BASE_URL + "/consumers/cargo_colin/instances/colin/offsets";
                    httpPost(commitUrl,data);
                }
            }
        }
    }

    public void httpDelete(String url) throws IOException {
        HttpDelete get = new HttpDelete(url);
        System.out.println("url:" + url);
        HttpHost proxy = new HttpHost("172.16.100.2", 8080);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        get.setConfig(requestConfig);
        String authorization = "2QPyzxWf8krUAatfhw2rdywd2fka";

        get.setHeader("Content-Type", "application/vnd.kafka.json.v2+json");
        get.setHeader("Accept", "application/vnd.kafka.v2+json, application/vnd.kafka+json, application/json");
        get.setHeader("Authorization", authorization);
        CloseableHttpResponse res = client.execute(get);
        System.out.println(res.getStatusLine().getStatusCode());

        if (res.getEntity() != null) {
            String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
            System.out.println(result);
        }
    }


}

