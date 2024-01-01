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

## 使用小工具

[kafka_controller.bat](tool%2Fkafka_controller.bat)