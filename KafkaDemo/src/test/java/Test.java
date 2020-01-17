import com.alibaba.fastjson.JSONObject;
import com.producer.ConfluentKafkaProducer;
import com.producer.ProducerRecord;
import com.producer.labelling.*;
import com.producer.orderevents.*;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static final CloseableHttpClient client = HttpClients.createDefault();
    private static final String BASE_URL = "https://qa.api.dev4apps.com/kafkaproxy";
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i =1; i <=2000;i ++){
            ProducerRecordDTO<ReleaseOrderRecordDTO> record = new ProducerRecordDTO();
            ReleaseOrderRecordDTO recordDTO = new ReleaseOrderRecordDTO();
            List<ReleaseOrderRecordDTO> recordDTOList = new ArrayList<ReleaseOrderRecordDTO>();
            recordDTOList.add(recordDTO);
            record.setRecords(recordDTOList);
            ReleaseOrderValueDTO valueDTO = new ReleaseOrderValueDTO();
            recordDTO.setValue(valueDTO);
            ReleaseOrderContentDTO contentDTO = new ReleaseOrderContentDTO();
            valueDTO.setContent(contentDTO);
            ReleaseOrderAddressDTO addressDTO = new ReleaseOrderAddressDTO();
            contentDTO.setAddress(addressDTO);
            ReleaseOrderReleaseLineDTO releaseLineDTO1 = new ReleaseOrderReleaseLineDTO();
            ReleaseOrderReleaseLineDTO releaseLineDTO2 = new ReleaseOrderReleaseLineDTO();
            List<ReleaseOrderReleaseLineDTO> releaseLineDTOList = new ArrayList<ReleaseOrderReleaseLineDTO>();
            releaseLineDTOList.add(releaseLineDTO1);
            releaseLineDTOList.add(releaseLineDTO2);
            contentDTO.setReleaseLine(releaseLineDTOList);
            valueDTO.setTimestamp(getTimestamp());
            valueDTO.setBrand("AMQ");
            valueDTO.setBrandCode("MQ");
            valueDTO.setSchema("kering.toolkit.ReleaseOrder");
            valueDTO.setSchemaVersion("V2R1.17");
            valueDTO.setSender("D1M-Shanghai");
            valueDTO.setSenderCountry("CN");
            valueDTO.setIntendedReceiver("Cargo-Shanghai");
            String messageId = UUID.randomUUID().toString();
            valueDTO.setMessageId(messageId);
            contentDTO.setOrderId("10");
            contentDTO.setOrderType("E");
            contentDTO.setWhsCode("54176");
            contentDTO.setPurchaseOrder("201909231710004200");
            contentDTO.setCapturedDate(getTimestamp());
            contentDTO.setCustomerFirstName("Fay");
            contentDTO.setCustomerLastName("Luo");
            contentDTO.setCustomerPhone("18521569855");
            Long lo = 20011800000000l;
            contentDTO.setReleaseId(String.valueOf(lo+i));
            contentDTO.setCarrierCode("SF");
            contentDTO.setCurrencyCode("CNY");
            contentDTO.setIsCanceled(false);
            contentDTO.setOrderSubTotal("5600.00");
            contentDTO.setTotalDiscounts("0.00");
            contentDTO.setDeliveryNo(String.valueOf(lo+i));
            addressDTO.setAddress1("天山西路122号");
            addressDTO.setAddress2("上海市");
            addressDTO.setAddress3("黄浦区");
            addressDTO.setCity("上海市");
            releaseLineDTO1.setSkuCode("807582633");
            releaseLineDTO1.setOrderLineId("1");
            releaseLineDTO1.setReleaseLineId("1");
            releaseLineDTO1.setQuantity(1.0);
            releaseLineDTO2.setSkuCode("808051037");
            releaseLineDTO2.setOrderLineId("2");
            releaseLineDTO2.setQuantity(2.0);
            releaseLineDTO2.setReleaseLineId("2");
            String data = JSONObject.toJSONString(record);
            System.out.println(i + "~~~~~~~~~~~~~~~~~~~~~~~"+data);
           // String data1 = getLabelling(i);
            //System.out.println(i + "~~~~~~~~~~~~~~~~~~~~~~~"+data1);
            executorService.execute(()->{
               try {
                    send("Scm-WmsToolkit-ReleaseOrder", data);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            });
           // send("Scm-WmsToolkit-Labelling", data1);

        }

    }

    public static void send(String topic, String data) throws IOException {
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

    private static String getTimestamp(){
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);

        String nowAsISO = df.format(new Date());

        return nowAsISO;
    }

    private static String getLabelling(int i){
        ProducerRecordDTO<ReceiveLabellingRecordDTO> record = new ProducerRecordDTO();
        ReceiveLabellingRecordDTO recordDTO = new ReceiveLabellingRecordDTO();
        List<ReceiveLabellingRecordDTO> recordDTOList = new ArrayList<ReceiveLabellingRecordDTO>();
        recordDTOList.add(recordDTO);
        record.setRecords(recordDTOList);
        ReceiveLabellingValueDTO value = new ReceiveLabellingValueDTO();
        recordDTO.setValue(value);
        List<ReceiveLabellingContentDTO> content = new ArrayList<ReceiveLabellingContentDTO>();
        value.setContent(content);
        List<ReceiveLabellingAttachmentsDTO> attachments = new ArrayList<ReceiveLabellingAttachmentsDTO>();
        ReceiveLabellingAttachmentsDTO attachmentsDTO = new ReceiveLabellingAttachmentsDTO();
        attachments.add(attachmentsDTO);
        ReceiveLabellingContentDTO contentDTO = new ReceiveLabellingContentDTO();
        ReceiveLabellingSenderAddressDTO senderAddress = new ReceiveLabellingSenderAddressDTO();
        ReceiveLabellingShipperAddressDTO shipperAddress = new ReceiveLabellingShipperAddressDTO();
        ReceiveLabellingDeliveryAddressDTO deliveryAddress = new ReceiveLabellingDeliveryAddressDTO();
        ReceiveLabellingBillToAddressDTO billToAddress = new ReceiveLabellingBillToAddressDTO();
        ReceiveLabellingUltimateConsigneeAddressDTO ultimateConsigneeAddress = new ReceiveLabellingUltimateConsigneeAddressDTO();
        ReceiveLabellingRecipientAddressDTO recipientAddress = new ReceiveLabellingRecipientAddressDTO();
        ReceiveLabellingShipmentLevelItemsDTO shipmentLevelItems = new ReceiveLabellingShipmentLevelItemsDTO();
        ReceiveLabellingContentsInformationDTO contentsInformation = new ReceiveLabellingContentsInformationDTO();


        value.setTimestamp(getTimestamp());
        value.setBrand("AMQ");
        value.setBrandCode("MQ");
        value.setSchema("kering.toolkit.ReleaseOrder");
        value.setSchemaVersion("V2R1.17");
        value.setSender("D1M-Shanghai");
        value.setSenderCountry("CN");
        value.setIntendedReceiver("Cargo-Shanghai");
        String messageId = UUID.randomUUID().toString();
        value.setMessageId(messageId);
        contentDTO.setOrderId("10" + i);
        contentDTO.setWhsCode("54176");
        Long lo = 19111100000000l;
        contentDTO.setReleaseId(String.valueOf(lo+i));
        content.add(contentDTO);
        senderAddress.setCompany("N/A");
        senderAddress.setName("N/A");
        senderAddress.setAddressLines("N/A");
        senderAddress.setLocalityName("N/A");
        senderAddress.setSubdivisionName("N/A");
        senderAddress.setPostalCode("N/A");
        senderAddress.setPhoneNumber("N/A");
        senderAddress.setResidential("N/A");
        senderAddress.setCountryCode("N/A");
        contentDTO.setSenderAddress(senderAddress);
        shipperAddress.setCompany("N/A");
        shipperAddress.setName("N/A");
        shipperAddress.setAddressLines("N/A");
        shipperAddress.setLocalityName("N/A");
        shipperAddress.setPostalCode("N/A");
        shipperAddress.setPhoneNumber("N/A");
        shipperAddress.setVatNumber("N/A");
        shipperAddress.setCountryCode("N/A");
        contentDTO.setShipperAddress(shipperAddress);
        deliveryAddress.setCompany("N/A");
        deliveryAddress.setName("可口可乐");
        deliveryAddress.setAddressLines("控江路1500");
        deliveryAddress.setLocalityName("上海市");
        deliveryAddress.setSubdivisionName("奉贤区");
        deliveryAddress.setPostalCode("100098");
        deliveryAddress.setPhoneNumber("13141145616");
        deliveryAddress.setCountryCode("CN");
        contentDTO.setDeliveryAddress(deliveryAddress);

        billToAddress.setCompany("N/A");
        billToAddress.setName("N/A");
        billToAddress.setAddressLines("N/A");
        billToAddress.setLocalityName("N/A");
        billToAddress.setPostalCode("N/A");
        billToAddress.setPhoneNumber("N/A");
        billToAddress.setVatNumber("N/A");
        billToAddress.setCountryCode("N/A");
        contentDTO.setBillToAddress(billToAddress);
        ultimateConsigneeAddress.setCompany("N/A");
        ultimateConsigneeAddress.setName("可口可乐");
        ultimateConsigneeAddress.setAddressLines("控江路1500");
        ultimateConsigneeAddress.setLocalityName("上海市");
        ultimateConsigneeAddress.setSubdivisionName("奉贤区");
        ultimateConsigneeAddress.setPostalCode("100098");
        ultimateConsigneeAddress.setPhoneNumber("13141145616");
        ultimateConsigneeAddress.setCountryCode("CN");
        contentDTO.setUltimateConsigneeAddress(ultimateConsigneeAddress);
        recipientAddress.setCompany("N/A");
        recipientAddress.setName("N/A");
        recipientAddress.setAddressLines("N/A");
        recipientAddress.setLocalityName("N/A");
        recipientAddress.setPostalCode("N/A");
        recipientAddress.setPhoneNumber("N/A");
        recipientAddress.setCountryCode("CN");
        contentDTO.setRecipientAddress(recipientAddress);
        shipmentLevelItems.setInvoiceDate("N/A");
        shipmentLevelItems.setInvoiceNumber("N/A");
        shipmentLevelItems.setForwarderCode("N/A");
        shipmentLevelItems.setServiceCode("N/A");
        shipmentLevelItems.setAdditionalServiceCode("N/A");
        shipmentLevelItems.setExportInformationCode("N/A");
        shipmentLevelItems.setRetailPrice("7300.00");
        shipmentLevelItems.setRetailPriceCurrencyCode("RMB");
        shipmentLevelItems.setFreightPayer("N/A");
        shipmentLevelItems.setShipperRef("19120300000004");
        shipmentLevelItems.setReceiverRef("AMQ20191022TEST77");
        shipmentLevelItems.setRequestedPickupDateTime("N/A");
        shipmentLevelItems.setIncotermCode("N/A");
        shipmentLevelItems.setIncotermLocalityName("N/A");
        contentDTO.setShipmentLevelItems(shipmentLevelItems);
        contentsInformation.setReleaseLineId("1");
        contentsInformation.setSkuCode("808594957");
        contentsInformation.setContent("N/A");
        contentsInformation.setQuantity("1");
        contentsInformation.setQuantityUnitOfMeasure("EA");
        contentsInformation.setRetailPrice("3500.00");
        contentsInformation.setRetailPriceCurrencyCode("RMB");
        contentsInformation.setWeightUnitOfMeasure("g");
        contentsInformation.setLiquids("false");
        contentsInformation.setPriceAfterDiscount("0.000");
        contentDTO.setContentsInformation(contentsInformation);
        attachmentsDTO.setName("test");
        attachmentsDTO.setType("TAR");
        attachmentsDTO.setContent("MTkzODA1MjYyMzVkZTYyNzk3NDIyMmM0LjU0OTA4NTUx");
        attachments.add(attachmentsDTO);

        String data = JSONObject.toJSONString(record);
        return data;
    }
}
