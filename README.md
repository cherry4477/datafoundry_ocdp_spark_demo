# datafoundry_ocdp_spark_demo

A simple example for submit spark job.

- Clone code from github
   ```
   git clone https://github.com/asiainfoLDP/datafoundry_ocdp_spark_demo.git
   ```
- Copy MapReduce jar file to jars/ directory

- Edit scripts/start.sh file:
  > replace BSI_MAPREDUCE_PRINCIPAL and BSI_MAPREDUCE_PASSWORD to tenant's principal and password

  > replace YARN parameters:  EXECUTOR_NUM, DRIVER_MEM, EXECUTOR_MEM, EXECUTOR_CORES  

  > replace SPARK_JAR_FILE to spark jar file name, and replace ARG1, ARG2 ... to real program args

- Build docker image

- Run Docker container
