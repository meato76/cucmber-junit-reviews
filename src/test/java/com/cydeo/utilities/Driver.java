package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
    //private static WebDriver driver; // default value = null //single run
    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>(); //parallel run

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    public static WebDriver getDriver(){

        //  if(driver == null){  //single run
        if(driverPool.get() == null){  //parallel run
            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    //     driver = new ChromeDriver();  //single run
                    driverPool.set(new ChromeDriver());
                    //      driver.manage().window().maximize();  //single run
                    driverPool.get().manage().window().maximize();  //parallel run
                    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //single run
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //parallel run

                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    //  driver = new FirefoxDriver(); //single run
                    driverPool.set(new FirefoxDriver()); //parallel run
                    // driver.manage().window().maximize(); //single run
                    driverPool.get().manage().window().maximize(); //parallel run
                    //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //single run
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //parallel run
                    break;
            }

        }

        return driverPool.get();

    }

    /*
    Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
     */
    public static void closeDriver(){
        //   if (driver!=null){ //single run
        if (driverPool.get()!=null){ //parallel run
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            //  driver.quit(); //single run
            driverPool.get().quit(); //single run
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            // driver = null; //single run
            driverPool.remove(); //parallel run
        }
    }

}
