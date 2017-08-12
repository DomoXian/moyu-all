# !/bin/bash
TARGET_HOME=/home/admin/app/moyu-all/moyu-core/target
TARGET_NAME=moyu.jar
mvn clean install -Dmaven.test.skip&& mvn package -Dmaven.test.skip
cd $TARGET_HOME
MOYU_PID=`ps -ef | grep "moyu" | grep -v grep | awk '{print $2}'`
echo "Moyu PID = $MOYU_PID"
kill -9 MOYU_PID
java -jar $TARGET_HOME/$TARGET_NAME --spring.profiles.active=dev > ./moyu.log &