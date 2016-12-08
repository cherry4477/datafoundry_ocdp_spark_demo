#!bin/bash
echo "36.110.131.65 hadoop-1.jcloud.local" >> /etc/hosts
echo "36.110.132.55 hadoop-2.jcloud.local" >> /etc/hosts

echo "kinit"
date
kinit BSI_MAPREDUCE_PRINCIPAL <<!!
BSI_MAPREDUCE_PASSWORD
!!

echo "Run jar..."
spark-submit --class SPARK_APP_CLASS  --master yarn-client --num-executors EXECUTOR_NUM --driver-memory DRIVER_MEM --executor-memory EXECUTOR_MEM --executor-cores EXECUTOR_CORES /root/jars/SPARK_JAR_FILE ARG1 ARG2 ...
