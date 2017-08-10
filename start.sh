#!/usr/bin/env bash
# 定义变量
export PROJECT_HOME=/home/admin/app
export PROJECT_HOME_SRC=$PROJECT_HOME/src
export PROJECT_HOME_LOGS_O=$PROJECT_HOME/logs/$PROJECT_NAME/${ENV}
export PROJECT_HOME_TARGET=$PROJECT_HOME/target
export PROJECT_HOME_LOGS=$PROJECT_HOME/src/app/logs

# 日志地址
export BUILD_LOG=${PROJECT_HOME_LOGS_O}/jetty_stdout.log
if [ -n $SERVER_INDEX ];then
    BUILD_LOG=${PROJECT_HOME_LOGS_O}/jetty_stdout_$SERVER_INDEX.log
fi
export OPT_JETTY=/opt/jetty
#export NGINX_CONF=/opt/nginx/conf/nginx.conf
export ANTX_PATH=/home/admin/antx-${PROJECT_NAME}.properties
JETTY_HOME=$PROJECT_HOME/.default
export MODULE_NAME=web
JETTY_PID="$JETTY_HOME/logs/jetty_$JETTY_PORT.pid"
JETTY_PS_STR="-Djetty.app."$JETTY_PORT."E"
if [ ! -d "$PROJECT_HOME_LOGS_O" ];then
    mkdir -p ${PROJECT_HOME_LOGS_O}
fi
if [ ! -d "$PROJECT_HOME_TARGET" ];then
    mkdir -p ${PROJECT_HOME_TARGET}
fi
if [ ! -d "$PROJECT_HOME_SRC" ];then
    mkdir -p ${PROJECT_HOME_SRC}
fi
if [ ! -d "$PROJECT_HOME_LOGS" ];then
    mkdir -p ${PROJECT_HOME_LOGS}
fi
if [ ! -f "$BUILD_LOG" ];then
    touch $BUILD_LOG
fi
#scp publish@172.21.10.74:/home/publish/antx/antx-${PROJECT_NAME}.properties /root
#sshpass -p 'taobao1234' scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null publish@172.21.10.70:/home/publish/antx-${ENV}/antx-${PROJECT_NAME}.properties /home/admin
cd $PROJECT_HOME/src/app
#rm -rf .ssh
#rm -rf jetty7.3.1
#rm Dockerfile apache-maven-3.3.9-bin.tar.gz nginx.conf settings.xml start.sh antx-buick.properties
#cd $PROJECT_HOME_SRC/app
#git clone git@git.dawanju.net:mhc/buick.git
#sed -i "s/dubbo.protocol.port  = [[:digit:]]\{2,5\}/dubbo.protocol.port  = ${DUBBO_PORT}/g" $ANTX_PATH
cd $PROJECT_HOME_SRC/app
mvn clean package -Dmaven.test.skip -U
#cd $PROJECT_HOME_SRC/app/$PROJECT_NAME-deploy/src/main/assembly
#sed -i 's|../${PROJECT_NAME}-web/target/${PROJECT_NAME}-web-1.0-SNAPSHOT|../${PROJECT_NAME}-'${MODULE_NAME}'/target/${PROJECT_NAME}-'${MODULE_NAME}'-1.0-SNAPSHOT|g' assembly.xml

#cd $PROJECT_HOME_SRC/app/$PROJECT_NAME-deploy
#pwd
#mvn assembly:assembly
#mkdir -p $PROJECT_NAME/target
#cp -af  $PROJECT_HOME_SRC/$PROJECT_NAME/$PROJECT_NAME-deploy/target/$PROJECT_NAME.jar $PROJECT_HOME/target/$PROJECT_NAME.jar
#pid=`ps -C java  | grep -- 9090 | awk '{print $1}'`
#if [ -n "$pid" ];then
  #kill -9 $pid
#fi
java $JAVA_OPTIONS -jar $PROJECT_HOME_SRC/app/${JAR_DIR}/target/$PROJECT_NAME.jar --spring.profiles.active=$SPRING_PROFILES_ACTIVE --spring.dubbo.protocol.port=$SPRING_DUBBO_PROTOCOL_PORT --server.port=$JETTY_PORT | tee $BUILD_LOG 
running() {
  local PID=$(cat "$1" 2>/dev/null) || return 1
  kill -0 "$PID" 2>/dev/null
}

start() {
    if [ -f "$JETTY_PID" ]; then
        if running $JETTY_PID; then
            echo "Already Running!"
            exit 1
        else
            rm -f "$JETTY_PID"
        fi
    fi
    if [ -d "$JETTY_HOME" ]; then
        rm -rf $JETTY_HOME
    fi

    cd $PROJECT_HOME/target
    rm -rf $PROJECT_NAME.war
    tar zxf $PROJECT_HOME/target/${PROJECT_NAME}.tar.gz
    mkdir -p $JETTY_HOME
    cp -drf $OPT_JETTY/* $JETTY_HOME/.

    cd $JETTY_HOME/target
    echo $JETTY_HOME/target
    ln -s $PROJECT_HOME/target/${PROJECT_NAME}.war .
    if [ ! -z ${JETTY_DEBUG_PORT} ]; then
        JAVA_OPTIONS="$JAVA_OPTIONS -Xdebug -XX:PermSize=96m -XX:MaxPermSize=384m -agentlib:jdwp=transport=dt_socket,address=${JETTY_DEBUG_PORT},server=y,suspend=n"
    fi
    sed -i "s/name=\"jetty.port\"\s\+default=\"[[:digit:]]\{2,5\}\"/name=\"jetty.port\" default=\"$JETTY_PORT\"/g" $JETTY_HOME/etc/jetty.xml
    $JAVA_HOME/bin/java $JAVA_OPTIONS $JETTY_PS_STR -Djetty.home=$JETTY_HOME -Dproject.name=$PROJECT_NAME -Dproject.home=$PROJECT_HOME -jar $JETTY_HOME/start.jar --ini=$JETTY_HOME/start.ini 2>&1 | tee $BUILD_LOG &
    pid=`ps -C java  | grep -- "$JETTY_PS_STR" | awk '{print $2}'`
    touch "$JETTY_PID"
    echo "$pid" > "$JETTY_PID"
#sed -ni '1h;1!H;${;g;s/upstream myServer\s*{[^}]*}/upstream myServer {\n        server 127.0.0.1:'"$JETTY_PORT"';\n    }/g;p;}' $NGINX_CONF
#/opt/nginx/sbin/nginx -s reload
# tail -f $BUILD_LOG
}

stop() {
    echo -n "Stopping Jetty: "
    PID=$(cat "$JETTY_PID" 2>/dev/null)
    kill "$PID" 2>/dev/null
    #TIMEOUT=30
    #while running $JETTY_PID; do
        #if (( TIMEOUT-- == 0 )); then
            #kill -KILL "$PID" 2>/dev/null
        #fi
        #sleep 1
    #done

    rm -f "$JETTY_PID"
    echo OK

    STR=`ps -C java  | grep -- "$JETTY_PS_STR"`
    if [ ! -z "$STR" ]; then
        echo ""
    else
        echo ""
    fi

    for i in `seq 1 5`
    do
        STR=`ps -C java  | grep -- "$JETTY_PS_STR"`
        if [ -z "$STR" ]; then
            echo
            break
        fi
        echo -ne "\r"
        sleep 1
    done
    echo "remove .default dir"
    rm -rf $PROJECT_HOME/.default
}
#stop
#start
#tail -f $BUILD_LOG
