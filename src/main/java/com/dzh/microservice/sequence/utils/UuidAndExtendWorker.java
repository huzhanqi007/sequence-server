package com.dzh.microservice.sequence.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by herbert on 2018/8/17.
 */
public class UuidAndExtendWorker {
    /**
     * 变种1
     * 最大支持1-9
     * @param clusterId
     * @return
     */
    public static String getOrderIdByUUId(int clusterId) {
         int machineId = clusterId;//最大支持1-9个集群机器部署
         int hashCodeV = UUID.randomUUID().toString().hashCode();
         if(hashCodeV < 0) {//有可能是负数
             hashCodeV = - hashCodeV;
         }
         // 0 代表前面补充0
         // 4 代表长度为4
         // d 代表参数为正数型
         return machineId + String.format("%015d", hashCodeV);
    }

    /**
     * 变种2
     * @return
     */
    public static Long getIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        int randNo=UUID.randomUUID().toString().hashCode();
        if (randNo < 0) {
            randNo=-randNo;
        }
        return Long.valueOf(first + String.format("%016d", randNo));
    }
    public static void main(String[] args){

        for (int i=0;i<100;i++){
            UUID id = UUID.randomUUID();
            System.out.println("UUID:"+id.toString());
            System.out.println("变种1:"+getOrderIdByUUId(2));
            System.out.println("变种2:"+getIdByUUId());
        }
    }
}
