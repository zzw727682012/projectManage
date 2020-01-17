import com.alibaba.fastjson.JSONObject;
import com.producer.orderevents.*;
import com.producer.returnorder.*;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReturnOrderProducerTest {

    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";
    public static void main(String[] args) throws IOException {
        ProducerRecordDTO<ReturnOrderRecordDTO> record = new ProducerRecordDTO();
        ReturnOrderRecordDTO recordDTO = new ReturnOrderRecordDTO();
        List<ReturnOrderRecordDTO> recordDTOList = new ArrayList<ReturnOrderRecordDTO>();
        recordDTOList.add(recordDTO);
        record.setRecords(recordDTOList);
        ReturnOrderValueDTO valueDTO = new ReturnOrderValueDTO();
        recordDTO.setValue(valueDTO);
        ReturnOrderContentDTO contentDTO = new ReturnOrderContentDTO();
        valueDTO.setContent(contentDTO);
        ReturnOrderAddressDTO addressDTO = new ReturnOrderAddressDTO();
        contentDTO.setAddress(addressDTO);
        ReturnOrderItemsDTO itemsDTO1 = new ReturnOrderItemsDTO();

        List<ReturnOrderItemsDTO> itemsDTOS = new ArrayList<ReturnOrderItemsDTO>();
        itemsDTOS.add(itemsDTO1);
        contentDTO.setItems(itemsDTOS);
        valueDTO.setTimestamp("2019-08-09T15:10:00Z");
        valueDTO.setBrand("Gucci");
        valueDTO.setBrandCode("GG");
        valueDTO.setSchema("kering.toolkit.ReturnOrders");
        valueDTO.setSchemaVersion("2.0");
        valueDTO.setSender("OMS");
        valueDTO.setSenderCountry("CN");
        valueDTO.setMessageId("7D1BD702-9503-93D4-BDF2-E739BCCE5AFD");
        contentDTO.setDocNumber("34535554157273318");
        contentDTO.setRMAtype("Created");
        contentDTO.setWhsCode("22199");
        contentDTO.setRMAdecitions("Confirmed");
        itemsDTO1.setSkuCode("colin001");
        itemsDTO1.setQuantity(2.0);
        itemsDTO1.setUom("EA");
        addressDTO.setReturnLocation("");
        addressDTO.setReturnLocationAddress1("天山西路122号");
        addressDTO.setReturnLocationAddress2("");
        addressDTO.setReturnLocationAddress3("");
        addressDTO.setReturnLocationCity("上海市");
        addressDTO.setReturnLocationCountry("CN");
        addressDTO.setReturnLocationCounty("黄浦区");
        addressDTO.setReturnLocationPostalCode("200000");
        String data = JSONObject.toJSONString(record);
        System.out.println(data);
        new Test().send("Scm-WmsToolkit-ReturnOrder-Cargo", data);
    }

    public void send(String topic, String data) throws IOException {
        String url = BASE_URL + "/topics/" + topic;
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
        String result = EntityUtils.toString(res.getEntity(), "UTF-8");// 返回json格式：
        System.out.println(res.getStatusLine().getStatusCode());
        System.out.println(result);
    }
}
