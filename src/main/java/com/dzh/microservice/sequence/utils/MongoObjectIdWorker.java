package com.dzh.microservice.sequence.utils;

import com.dzh.microservice.sequence.source.ObjectId;

/**
 * Created by herbert on 2018/8/17.
 */
public class MongoObjectIdWorker {
    public static void main(String[] args) {
        String objectId = ObjectId.get().toHexString();
        System.out.println(objectId);
    }
}
