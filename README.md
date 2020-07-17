# CkkaPosSdk

  **Adding aar dependency with Gradle**

  **Step 1. Add the JitPack repository to your build file.**
  
  Add it in your root build.gradle at the end of repositories:

    allprojects {
            repositories {
                ...
                maven { url 'https://jitpack.io' }
            }
        }
  
**Step 2. Add the dependency**


    dependencies {
                implementation 'com.github.ckka2020:CkkaPosSdk:1.0.10'
        }
  
  
  <br></br>
  
**Adding aar dependency with Maven**
  
**Step 1. Add the JitPack repository to your build file**

          <repositories>
                <repository>
                    <id>jitpack.io</id>
                    <url>https://jitpack.io</url>
                </repository>
            </repositories>

**Step 2. Add the dependency**

            <dependency>
                <groupId>com.github.ckka2020</groupId>
                <artifactId>CkkaPosSdk</artifactId>
                <version>1.0.10</version>
            </dependency>

  **Hardware Acceleration**
  
Hardware acceleration is required since QR Code is used. It is automatically included as part of the library.

If your application does not behave properly then make sure it is enabled in your manifest file:


        <application android:hardwareAccelerated="true" ... >
    
  **Android Permissions**
  
Internet permission is required for making api calls to CKKA. It is automatically included as part of the library. 

  **Usage with SDK**

    Step 1. Get instance of CkkaSdk
    Step 2. Call this api sendDataToCkka and pass parameters as following:
    PARAMETER 1: your <POS-ID> as String, 
    PARAMETER 2: <Total transaction Amount> as double,
    PARAMETER 3: <YOUR PRODUCT DETAILS> as Json String and
    PARAMETER 4: <YOUR CALL BACK METHOD> as OnCkkaActionListener to receive response from CKKA as Success or Failure override methods.

 
 
 THANKS.
 
 Feel free to share your queries on ckka2020@gmail.com
 
 


  
