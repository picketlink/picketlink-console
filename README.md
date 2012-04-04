# The PicketLink Console project #

## About ##

The PicketLink Console Project aims to provide for users a easy way to manage all PicketLink configurations using a AS 7 subsystem. Basically, it is a GWT application based on the AS7 Console's architecture and principles providing UIs to manage the PicketLink AS7 Subsystem.

For more information, see this [article](https://community.jboss.org/wiki/PicketLinkConsoleForJBossAS7 "About the PicketLink Console Project").

## How to build ##

*Pre-requisites:*

+ Apache Maven 3
+ JDK 1.6+

To build the console do the following:

+ Execute a **mvn -Pdev clean** install. This will compile(GWT) only for firefox.  

## Running in hosted mode ##

Make sure you have a successful build. 

To run the PicketLink Console in hosted mode, follow this steps:

+ Enter in the directory ${project.base.dir}/app;
+ Execute a **mvn -Pdev gwt:run**;
+ Open the Firefox and access the following URL: http://127.0.0.1:8888/App.html?gwt.codesvr=127.0.0.1:9997;
+ You will be prompted to inform your credentials. This credentials are the same that you use to access the AS7 Management Console.    

*After the login you will be presented to the AS 7 Console Servers Overview Page. Click in Profile (at the upper right corner) and you will see in the menu tree a item called "PicketLink".  Expand it and click in "Federation".*

You should now be presented to the Federation Configuration page. 

## Eclipse IDE configuration ##

*Pre-requisites:*

+ [Google Eclipse Plugin](http://mojo.codehaus.org/gwt-maven-plugin/eclipse/google_plugin.html "Google Eclipse Plugin")

In order to setup and run the project using the Eclipse IDE, do the following:

+ Execute a **mvn eclipse:eclipse** in the root directory;
+ Import the project as an "Existing Maven Project";
+ Click with the right-button in the project *picketlink-console-application*;
+ Select Run As -> Web Application.
