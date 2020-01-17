package com.producer.goodsreceipt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ExcelUtils;

public class KafkaFullSyncStockCheckJob {
	
	private static final String OK = "available";
	private static final String DAM = "damaged";
	private static final String CIQ = "unavailable";	
	private static final String UOM = "EA";
	private static final String SCHEMA = "kering.toolkit.FullStockCheck";
	private static final String SCHEMA_VERSION = "2.0";
	private static final String SENDER = "CARGO-Shanghai";
	private static final String SENDER_COUNTRY = "CN";
	private static final String DAMAGED_WAREHOUSE = "38050,22150,22497,54056,15523,82197,62155";

	private static ConfluentKafkaProducer producer = new ConfluentKafkaProducer();

	public static void main(String[] args) throws IOException {
		String orgId = "";
		String projectIds = "";
		String filePath = "";


		String[] projects = projectIds.split(",");

		List<List<StockCheckRecords>> lists = getData(null, null);
		for (List<StockCheckRecords> list : lists) {
			ProducerRecord record = new ProducerRecord();
			record.setRecords(list);
			String tag = list.get(0).getValue().getContent().getWhsCode();
			producer.produceMessages("Scm-WmsToolkit-StockCheck", record, filePath, tag);
		}

	}

	
	private static List<List<StockCheckRecords>> getData(String orgId, String projectId) throws FileNotFoundException {
		
			List<List<StockCheckRecords>> lists= new LinkedList<List<StockCheckRecords>>();
			List<FullSyncStockCheckQueryItem> queryItems = ExcelUtils.importExcel(new FileInputStream("D:\\aaa.xls"));
			
			Map<String, StockCheckContent> contentMap = new HashMap<String, StockCheckContent>();
			for (FullSyncStockCheckQueryItem item : queryItems) {
				if(item.getWhsCode() == null){
					continue;
				}
				StockCheckContent content = null;
				StockCheckItems checkItems = new StockCheckItems();

				if(contentMap.containsKey(item.getWhsCode())){
					content = contentMap.get(item.getWhsCode());
				} else {
					content = new StockCheckContent();
					content.setUom(UOM);
					content.setWhsCode(item.getWhsCode());
					content.setInventoryDate(new SimpleDateFormat("YYYYMMDD").format(new Date()));
					content.setItems(new ArrayList<StockCheckItems>());
					contentMap.put(item.getWhsCode(), content);
					StockCheckRecords record = new StockCheckRecords();
					StockCheckValue value = new StockCheckValue();
					value.setBrand(item.getBrand());
					value.setBrandCode(item.getBrandCode());
					value.setContent(content);
					value.setSchema(SCHEMA);
					value.setSchemaVersion(SCHEMA_VERSION);
					value.setSender(SENDER);
					value.setSenderCountry(SENDER_COUNTRY);
					value.setMessageId(UUID.randomUUID().toString());
					value.setTimestamp(KafkaCommon.getTimestamp());
					record.setValue(value);
					List<StockCheckRecords> recordList = new ArrayList<StockCheckRecords>();
					recordList.add(record);
					lists.add(recordList);
				}
				checkItems.setSkuCode(item.getSkuCode());
				checkItems.setInventoryQty(item.getInventoryQty());
				if(isDamagedWarehouse(item.getWhsCode()) || "DAM".equals(item.getWhsBucket())){
					checkItems.setWhsBucket(DAM);
				}else if("CIQ".equals(item.getWhsBucket())) {
					checkItems.setWhsBucket(CIQ);
				}else{
					checkItems.setWhsBucket(OK);
				}
				checkItems.setLockedQty(item.getLockedQty());
				content.getItems().add(checkItems);
			}
		
		return lists;
	}
	public static boolean isDamagedWarehouse(String warehouseCode){
		
		return Arrays.asList(DAMAGED_WAREHOUSE.split(","), String.class).contains(warehouseCode);
	}
}
