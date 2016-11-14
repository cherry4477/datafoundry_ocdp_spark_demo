package com.asiainfo.bdx.ocdp;

/**
 * Created by baikai on 11/11/16.
 */
public class SparkTest {

    public static void main(String[] args) {
        if (args.length != 9){
            System.out.println("Please verify parameters, need 9 parameters: \n " +
                    "1) yarn resource manager \n " +
                    "2) spark job name \n " +
                    "3) yarn driver memory \n " +
                    "4) yarn executor numbers \n" +
                    "5) yarn executor cores \n" +
                    "6) spark jar file \n" +
                    "7) spark application main class \n" +
                    "8) spark application argument");
            return;
        }
        /**
         example:

         String[] sparkJobArgs = new String[] {
         // the name of your application
         "--name",
         "testspark",

         // memory for driver (optional)
         "--driver-memory",
         "1000M",

         "--num-executors",
         "3",

         "--executor-memory",
         "512M",

         "--executor-cores",
         "1",

         // path to your application's JAR file
         // required in yarn-cluster mode
         "--jar",
         "/usr/hdp/2.4.0.0-169/spark/lib/spark-examples-1.6.0.2.4.0.0-169-hadoop2.7.1.2.4.0.0-169.jar",

         // name of your application's main class (required)
         "--class",
         "org.apache.spark.examples.SparkPi",

         // argument 1 to your Spark program (SparkFriendRecommendation)
         "--arg",
         "10"
         };
         **/
        SparkClient client = new SparkClient(args[0]);
        String[] sparkJobArgs = new String[] {
                // the name of your application
                "--name",
                args[1],

                // memory for driver (optional)
                "--driver-memory",
                args[2],

                "--num-executors",
                args[3],

                "--executor-memory",
                args[4],

                "--executor-cores",
                args[5],

                // path to your application's JAR file
                // required in yarn-cluster mode
                "--jar",
                args[6],

                // name of your application's main class (required)
                "--class",
                args[7],

                // argument 1 to your Spark program (SparkFriendRecommendation)
                "--arg",
                args[8]
        };
        client.submitSparkJob(sparkJobArgs);
    }
}
