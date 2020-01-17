package com.producer;

import com.alibaba.fastjson.JSONObject;
import com.consumer.ConsumerRecordResponseDTO;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ConfluentKafkaProducer {
    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";


    public static void main(String[] args) throws IOException {
        String result = "";

        List<ConsumerRecordResponseDTO> record = JSONObject.parseArray(result, ConsumerRecordResponseDTO.class);
        System.out.println(record);
    }

    public void send(String topic, ProducerRecord producerRecord) throws IOException {
        String url = BASE_URL + "/topics/" + topic;
        HttpPost post = new HttpPost(url);
        HttpHost proxy = new HttpHost("172.16.100.2", 8080);
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        post.setConfig(requestConfig);
        String data = "{\"records\":[{\"value\":{\"brand\":\"YSL\",\"brandCode\":\"YS\",\"content\":{\"docCreationDate\":1445326387000,\"docType\":\"ASN\",\"items\":[{\"cartonNumber\":0,\"itemLine\":0,\"lockedQty\":0,\"prodDate\":0,\"quantityReceived\":0,\"quantityToBeReceived\":5,\"referenceDetailId\":0},{\"cartonNumber\":0,\"itemLine\":0,\"lockedQty\":0,\"prodDate\":0,\"quantityReceived\":0,\"quantityToBeReceived\":5,\"referenceDetailId\":0}],\"physReceiptDate\":1441848792685,\"putAwayDate\":0,\"receiptDate\":0,\"receiptNo\":0,\"uom\":\"EA\"},\"messageId\":\"162-ASN201509100015\",\"schema\":\"kering.toolkit.goodsReceipt\",\"schemaVersion\":\"2.0\",\"sender\":\"CARGO-Shanghai\",\"senderCountry\":\"CN\",\"timestamp\":\"2019-08-27T02:42:05.764Z\"}}]}\n";
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
