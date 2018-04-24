package com.baidu.LogAnalyzer;

import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

//import storm configuration packages
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;

public class LogAnalyserStorm {
	   public static void main(String[] args) throws Exception{
		      //Create Config instance for cluster configuration
		      Config config = new Config();
		      config.setDebug(false);
				
		      //
		      TopologyBuilder builder = new TopologyBuilder();
		      builder.setSpout("call-log-reader-spout", new FakeCallLogReaderSpout());

		      builder.setBolt("call-log-creator-bolt", new CallLogCreatorBolt())
		         .shuffleGrouping("call-log-reader-spout");

		      builder.setBolt("call-log-counter-bolt", new CallLogCounterBolt())
		         .fieldsGrouping("call-log-creator-bolt", new Fields("call"));
			 
		      // run in cluster mode
		      String topologyName = args[0];
		      try {
	                StormSubmitter.submitTopologyWithProgressBar(topologyName, config, builder.createTopology());
	            } catch (AlreadyAliveException e) {
	                e.printStackTrace();
	            } catch (InvalidTopologyException e) {
	                e.printStackTrace();
	            } 
		     
		      // run in local mode
		      //LocalCluster cluster = new LocalCluster();
		      //cluster.submitTopology("LogAnalyserStorm", config, builder.createTopology());
		      //Thread.sleep(10000);
		      //Stop the topology
		      //cluster.shutdown();
		   }
}
