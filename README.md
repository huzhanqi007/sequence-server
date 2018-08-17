## 分布式全局ID生成器(常用、可靠)
### 1. 方法一：Uuid
     UUID生成方法
     UUID.randomUUID().toString();
     UUID变种一
     UuidAndExtendWorker.getOrderIdByUUId(2);
     UUID变种二
     UuidAndExtendWorker.getIdByUUId();
### 2. 方法二：类snowflake算法
     new SnowFlakeIdWorker(2).nextId();
### 3. 方法三：mongodb
     ObjectId.get().toHexString();
### 4. 方法三：redis
     redisIdWorker.incrementHash("redisIdWorker","redisIdWorker",1l);