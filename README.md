# jms
JMS-ActiveMQ

Setting up

AXIS2
1.download the binary distribution of axis2 from this site  http://axis.apache.org/axis2/java/core/download.html
2.In Eclipse go to Window>Preferences>Web Services> Axis2 preferences
3. Add the binary distribution in the axis2 runtime

Spring-jms-activemq
1. run mvn generate-sources to generate the java code of the wsdl file
2. add the generared project to the build path

Running the program
1.Run the CalculatorWS server
2.Run the Spring-jms-activemq server