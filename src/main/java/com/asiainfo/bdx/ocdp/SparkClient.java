package com.asiainfo.bdx.ocdp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;
import org.apache.spark.SparkConf;

import java.io.IOException;

/**
 * Created by baikai on 11/11/16.
 */
public class SparkClient {

    private Configuration conf;

    public SparkClient(String yarnRM){
        conf = new Configuration();
        conf.set("yarn.resourcemanager.address", yarnRM);
        conf.set("hadoop.security.authentication", "Kerberos");
        conf.set("yarn.resourcemanager.principal", "rm/_HOST@ASIAINFO.COM");
       // conf.addResource(new Path("/etc/hadoop/conf/yarn-site.xml"));
       // conf.addResource(new Path("/etc/hadoop/conf/core-site.xml"));

        this.authentication();
    }

    public void submitSparkJob(String[] args){
        System.out.println("args list is: " + args);
        // identify that you will be using Spark as YARN mode
        System.setProperty("SPARK_YARN_MODE", "true");

        // create an instance of SparkConf object
        SparkConf sparkConf = new SparkConf();

        // create ClientArguments, which will be passed to Client
        ClientArguments cArgs = new ClientArguments(args, sparkConf);

        // create an instance of yarn Client client
        Client client = new Client(cArgs, conf, sparkConf);

        // submit Spark job to YARN
        client.run();
    }

    private void authentication(){
        System.out.println("Authentication with KDC.");
        UserGroupInformation.setConfiguration(conf);
        try{
            UserGroupInformation.getLoginUser().reloginFromTicketCache();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
