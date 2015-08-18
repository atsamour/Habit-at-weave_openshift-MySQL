OpenShift is Red Hat's Platform-as-a-Service (PaaS) that allows developers to quickly develop, host, and scale applications in a cloud environment. It has decent documentation and relatively steep learning curve.

After installing `Ruby` and `RHC`, Openshift's client tool, by following [these](https://developers.openshift.com/en/getting-started-overview.html) steps, you can start creating a Java web application following [these](https://developers.openshift.com/en/tomcat-getting-started.html) steps.


## Habit@weave
Habit@weave is a web application for the control and monitoring smart homes and wearable devices.
The power consumption graphs and the capability to schedule actions can help the user to make the right decisions for efficient energy saving at home, while the calorie consumption and sleep quality charts may contribute to adoption of habits that improve heath. The user can use the application from a PC, as well as from any other portable device with access to the Internet. It is an initial effort towards a functional Ambient Assisted Living system.
It's also a good starting point for any Java web application with Hibernate JPA and Shiro security frameworks.

###Demo

Application's demo runs here [http://habitat-atsamour.rhcloud.com](http://habitat-atsamour.rhcloud.com).
E-mail: `test2@gmail.com`
Password: `1234`

![Screenshot](http://s4.postimg.org/7sibz1n4d/image.png)

You can find the sample database used in the application at [amazon cloud](https://s3-eu-west-1.amazonaws.com/atsamourfiles/awesomedb(openshift-MySQL-5.5).zip) (add a database named `awesomedb` to the OpenShift MySQL Cartridge and import tables there)

The folders are organized as a Maven project. Backend is written in Java using javax.servlet API, frontend is based on Bootstrap and implemented with JSP views.

### To deploying a jar filer that doesn't exist at Maven repository

Download and put the .jar (e.g.) file to the project's folder (e.g. C:\Users\username\Dropbox\heroku-examples\appfolder)
Then call mvn deploy:deploy-file to actually deploy the jar to `repo` folder:

    mvn deploy:deploy-file -Durl=file:///C:\Users\username\Dropbox\heroku-examples\appfolder\repo\ -Dfile=json-taglib-0.4.1.jar -DgroupId=atg.taglib.json -DartifactId=json-taglib -Dpackaging=jar -Dversion=0.4.1

![Screenshot](http://s13.postimg.org/ryipgphmv/sleep.png)
![Screenshot](http://s27.postimg.org/mm701vq3n/activity.png)
