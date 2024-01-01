@echo off
chcp 65001 > nul

:menu
echo -------------------------------
echo 1. 一鍵啟用 KAFKA
echo 2. 啟動 Kafka Producer

echo ------------ topic ------------
echo 3. 建立 topic
echo 4. 移除 topic
echo 5. 查詢 所有 topic
echo 6. 查詢 topic 內容
echo ------------ topic ------------
echo QQ.常見問題
echo CC. 清空 cmd
echo 0. 退出


set /p choice=請輸入對應的數字:
echo.
if "%choice%"=="0" goto :eof
if "%choice%"=="1" goto run_kafka
if "%choice%"=="2" goto start_producer
if "%choice%"=="3" goto build_topic
if "%choice%"=="4" goto list_or_delete_topics
if "%choice%"=="5" goto list_or_delete_topics
if "%choice%"=="6" goto select_topic_context
if "%choice%"=="CC" goto clear_cmd
if "%choice%"=="QQ" goto QA

echo 無效的選擇，請重新輸入。
goto menu


:run_kafka
REM 啟動 ZooKeeper
start cmd /k .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
timeout /t 5 >nul
REM 啟動 Kafka 服务器
start cmd /k .\bin\windows\kafka-server-start.bat .\config\server.properties
goto menu


:start_producer
rem 將所有 topic 存入一個變數
setlocal enabledelayedexpansion
rem 把 topics 的東西都放進 topics 變數，並用空格作為間隔
set "topics="
for /f "tokens=* delims=" %%a in ('.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181') do (
  set "topic=%%a"
  rem 如果 topic 不包含 "-marked" 才加入到 topics
  if "!topic:- marked=!"=="!topic!" (
    set "topics=!topics! %%a"
  )
)

rem 分割 topics 到陣列
set "counter=0"
for %%i in (%topics%) do (
  set /a counter+=1
  set "topic[!counter!]=%%i"
  echo !counter!. %%i
)
echo.
set /p topic_index=請輸入要啟動的 topic 的編號:
::set /a topic_index-=1

rem 取得選擇的 topic
set "selected_topic=!topic[%topic_index%]!"
echo 選擇了 !selected_topic!

rem 啟用 producer
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic !selected_topic!
goto menu


:build_topic
set /p topic_name=請輸入要建立的 topic 的名稱:
call .\bin\windows\kafka-topics.bat --create --topic !topic_name! --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
goto menu


:list_or_delete_topics
echo 這是所有 topic
call .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
if "%choice%"=="4" goto delete_topic
goto menu


:delete_topic
set /p topic_to_delete=請輸入要移除的 topic 的名稱:
call .\bin\windows\kafka-topics.bat --delete --topic !topic_to_delete! --zookeeper localhost:2181
goto menu


:select_topic_context
set /p topic_to_delete=請輸入要查詢的 topic 的名稱:
start cmd /k .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic !topic_to_delete! --from-beginning --property print.key=true --property print.value=true --property print.headers=true
goto menu

:clear_cmd
cls
goto menu


:QA
echo 如果一鍵啟用 KAFKA一直失敗，先刪除
goto menu