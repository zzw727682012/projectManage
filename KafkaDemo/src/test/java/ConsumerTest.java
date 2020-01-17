import com.alibaba.fastjson.JSONObject;
import com.consumer.*;
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
import java.util.ArrayList;
import java.util.List;

public class ConsumerTest {
    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";

    public static void main(String[] args) throws IOException, KeyManagementException, NoSuchAlgorithmException, InterruptedException {
        String sub = BASE_URL + "/consumers/cargo_colin/instances/colin/subscription";
        String instance = BASE_URL + "/consumers/cargo_colin/instances/colin";
        String getTopic = BASE_URL + "/topics/Scm-WmsToolkit-GoodsReceipt/partitions";


        final ConsumerTest consumer = new ConsumerTest();
        consumer.initInstance();
        consumer.subscription("Scm-WmsToolkit-Labelling-Cargo");
        consumer.postOffsets();

        consumer.getRecords();
        consumer.getRecords();
        consumer.getRecords();
        consumer.getRecords();
        consumer.getRecords();


        consumer.httpDelete(sub);
        consumer.httpDelete(instance);

      /*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        System.out.println(new SimpleDateFormat("YYYYMMDD").format(new Date()));
       executorService.scheduleAtFixedRate(new Runnable() {
           @Override
           public void run() {
               try {
                   consumer.getRecords();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

        },0,5,TimeUnit.SECONDS);*/

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

    public void postOffsets() throws IOException {
        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/offsets";
   /*     String offset = "{\"offsets\":[{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":1,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":2,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":3,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":4,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":5,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":6,\"offset\":0},{\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\",\"partition\":7,\"offset\":0}]}";
        httpPost(url,offset);*/

        //String data = "{\"partitions\":[{\"partition\":0,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":1,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":2,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":3,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":4,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":5,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":6,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"},{\"partition\":7,\"topic\":\"Scm-WmsToolkit-Labelling-Cargo\"}]}";
        String data = "{\"partitions\":[{\"partition\":0,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":1,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":2,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":3,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":4,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":5,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":6,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"},{\"partition\":7,\"topic\":\"Scm-WmsToolkit-ReleaseOrder-Cargo\"}]}";

        httpGet(url, data);
    }

    public void subscription(String topic) throws IOException {
        List<String> topicList = new ArrayList<String>();
        topicList.add(topic);
        String data = "{ \n" +
                "  \"topics\" : [ \n" +
                "    \"Scm-WmsToolkit-ReleaseOrder-Cargo\"\n" +
                "  ] \n" +
                "}\n";
        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/subscription";
        httpPost(url, data);
    }

    public void getRecords() throws IOException {

        String url = BASE_URL + "/consumers/cargo_colin/instances/colin/records";
        httpGet(url, null);

    }

    private void httpPost(String url, String data) throws IOException {
        System.out.println("url:" + url);
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
        post.setHeader("Authorization", authorization);
        CloseableHttpResponse res = client.execute(post);
        System.out.println(res.getStatusLine().getStatusCode());
        if (res.getEntity() != null) {
            String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
            System.out.println(result);
        }
    }

    private void httpGet(String url, String data) throws IOException {
        HttpGet get = new HttpGet(url);

        if (data != null) {
            HttpGetWithEntity getWithEntity = new HttpGetWithEntity(url);
            StringEntity stringEntity = new StringEntity(data);
            stringEntity.setContentEncoding("UTF-8");
            getWithEntity.setEntity(stringEntity);

            String authorization = "2QPyzxWf8krUAatfhw2rdywd2fka";
            System.out.println("url:" + url);
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
        System.out.println("url:" + url);
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
            File file = new File("D:\\tomcat.txt");

            if(record != null && record.size() != 0){
                for (ConsumerRecordResponseDTO r :  record) {
                    PrintWriter fileWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)), true);

                    fileWriter.println(r.toString());
                    List<PostOffsetDTO> posList = new ArrayList<PostOffsetDTO>();
                    PostOffsetDTO dto =new PostOffsetDTO();
                    dto.setTopic("Scm-WmsToolkit-ReleaseOrder-Cargo");
                    dto.setOffset(3600l);
                    dto.setPartition(r.getPartition());
                    posList.add(dto);
                    PostOffsetsRequestDTO postOffsetsRequestDTO = new PostOffsetsRequestDTO();
                    postOffsetsRequestDTO.setOffsets(posList);
                    data = JSONObject.toJSONString(postOffsetsRequestDTO);
                    String commitUrl = BASE_URL + "/consumers/cargo_colin/instances/colin/offsets";
                    httpPost(commitUrl,data);
                }
            }
            System.out.println(result);
        }
    }

    private void httpDelete(String url) throws IOException {
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
