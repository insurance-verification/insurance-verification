# Insurance Verification System
A micro-service initially designed to to meet the requirements of Oklahoma Insurance Verification as defined at
https://www.okivs.com/documents/OKIVS_Insurer_Implemenation_Guide_v1.0.pdf


## Documentation


Test keystore created with:
keytool -genkeypair -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

A great reference on certificates is here:
https://github.com/jonashackt/spring-boot-rest-clientcertificate


## Obtain 
Below are instructions for installing project locally
~~~
gradlew build
~~~

build without tests
~~~
gradle build -x test
~~~

## Run the application

~~~bash
java -jar ok-ivs-0.1.0.jar 
~~~