# Background
Mobile Call Log Analyzer is a storm example from [https://www.tutorialspoint.com/apache_storm/apache_storm_quick_guide.htm](https://www.tutorialspoint.com/apache_storm/apache_storm_quick_guide.htm).
But instead of running the project locally in the original example, I run it in cluster mode. Besides, to show the whole process in storm ui, I put code into Eclipse and try to manage dependencies through maven, which might help me generate a jar file.

# How to run the project
## Prepare
* Step 1 − Verifying Java Installation
* Step 2 − ZooKeeper Framework Installation
* Step 3 − Apache Storm Framework Installation
Please see [https://www.tutorialspoint.com/apache_storm/apache_storm_quick_guide.htm](https://www.tutorialspoint.com/apache_storm/apache_storm_quick_guide.htm)


## Build project
* Step 1 - Import the project into Eclipse
* Step 2 - Build it with maven: $mvn package

Tips: [Maven in 5 Minutes](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) might help you know about maven.
## Run the project
$ ./apache-storm-0.9.5/bin/storm jar LogAnalyzer-0.0.1-SNAPSHOT.jar com.baidu.LogAnalyzer.LogAnalyserStorm LogAnalyserStorm

Then you can find LogAnalyserStorm running on [http://localhost:8080/](http://localhost:8080/)
