package com;

import com.alibaba.fastjson.JSONObject;
import com.consumer.Partitions;
import com.consumer.Request;
import com.consumer.releaseorder.ReleaseOrderValueDTO;
import com.consumer.releaseorder.ReturnOrderValueDTO;
import com.producer.PostOffsets;
import com.producer.ProducerRecord;
import com.producer.goodsreceipt.StockCheckContent;
import com.producer.goodsreceipt.StockCheckItems;
import com.producer.internalmovement.InternalMovementContent;
import com.producer.orderevents.Pieces;
import com.producer.stockcheck.BaseResponse;
import com.producer.stockcheck.ContentDto;
import com.producer.stockcheck.Offsets;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class CommomHttpClient {
    private static final CloseableHttpClient client = HttpClients.createDefault();
    public static final String SUBSCRIPTION ="/consumers/cargo/instances/%s/subscription";

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {

        ExecutorService executor =  Executors.newFixedThreadPool(5);
        final CommomHttpClient commomHttpClient=new CommomHttpClient();
        int i =0;
        while (i<5) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    commomHttpClient.count(8);
                }
            });
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    commomHttpClient.isDamagedWarehouse();
                }
            });
            i++;
        }
 /*       ExecutorService executor1 =  Executors.newFixedThreadPool(5);
        int a=0;
        while (a<100){
            executor1.execute(new Runnable() {
                @Override
                public void run() {
                    commomHttpClient.isDamagedWarehouse();
                }
            });
            a++;
        }*/
    }
    // n=ax+by  a,b有多少种组合
    public synchronized void count(int n) {
        try {
            System.out.println("bbbbbbbbbbbbb");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isDamagedWarehouse();
    }
    public void isDamagedWarehouse() {
        System.out.println(Thread.currentThread().getName()+"aaaaaaaaaaaaa");


    }
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i =0 ;i< nums.length;i++){
            hashMap.put(nums[i],i);
            if (hashMap.containsKey(target-nums[i])){
                index[0] = hashMap.get(target-nums[i]);
                index[1] = hashMap.get(nums[i]);
            }
        }
        return index;
    }
}
