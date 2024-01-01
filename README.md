# 實作 Spring Kafka Producer 以及 Consumer

## 目的

快速知道怎麼在 Producer 以及 Consumer 裡面接收以及傳遞資料

## 使用版本

- kafka - 2.12-2.8.0
- spring-boot-starter-parent 2.7.17
- spring-kafka 2.8.11
- jdk 1.8

## Kafka 相關設定

- topic
    - test(傳送純文字)
    - json(傳送 UserVo 物件)
- consumer 的 groupId
    - group_1(給 test 用)
    - group_2(給 json 用)

## Postman 測試發送資料

GET - http://localhost:8082/kafka/publish/aaron/05

## [producer](producer)

- port 8082

## [consumer](consumer)

- port 8081

## 使用小工具[kafka_controller.bat](tool%2Fkafka_controller.bat)

### 小工具功能說明

為簡便操作內容，整理 kafka 常用指令
交此工具放到 Kafka 資料夾底下，與 /bin 同一層資料夾

### 1. 一鍵啟用 KAFKA

- 啟用 zookeeper
- 啟用 kafka server

### 2. 啟動 Kafka Producer

- 建立指定的 topic producer，並手動發送資訊

### 3. 建立 topic

### 4. 移除 topic

### 5. 查詢 所有 topic

### 6. 查詢 topic 內容

包含三種資訊(Key, value, header)

- --property print.key=true
- --property print.value=true
- --property print.headers=true

### QQ.常見問題

- 如果一鍵啟用 KAFKA一直失敗，先刪除tmp/底下的資料，刪除後要重新建立 topic

### CC. 清空 cmd

### 0. 退出