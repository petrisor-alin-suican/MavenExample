package com.db.afbc.at.webdriver;

import com.db.afbc.at.config.Configuration;
import com.db.afbc.at.config.ConfigurationManager;
import com.db.afbc.at.utils.FrameworkLogger;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;

public class WebBrowser {

    private final static boolean isFabric = Boolean.parseBoolean(ConfigurationManager.getConfiguration().fabric());
    private final static boolean isHeadless = Boolean.parseBoolean(ConfigurationManager.getConfiguration().headless());
    private static final FrameworkLogger log = new FrameworkLogger(WebBrowser.class);
    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String userDirectory = System.getProperty("user.dir");

    public static WebDriver startDriver(){
       driver = getNewDriver();
        if(!isFabric){
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    @SneakyThrows
    private static ThreadLocal<WebDriver>  getNewDriver() {
        try {
            if(isFabric){
                log.info("Creating RemoteWebDriver instance for Fabric setup");
                System.setProperty("webdriver.chrome.driver", ConfigurationManager.getConfiguration().chromeDriverLinuxPath());
                File drv = new File(ConfigurationManager.getConfiguration().chromeDriverLinuxPath());
                log.info("Fabric Chromedriver location: " + ConfigurationManager.getConfiguration().chromeDriverLinuxPath());
                drv.setExecutable(true);
            }
            else{
               boolean isWindows =  System.getProperty("os.name").startsWith("Windows");
               String driverPath =
                       isWindows ?
                               ConfigurationManager.getConfiguration().chromeDriverWindowsPath() :
                               ConfigurationManager.getConfiguration().chromeDriverMacPath();
               if(!isWindows){
                   try{
                       Runtime.getRuntime().exec("cd automation/src/test/java/com/db/afbc/at/webdriver/chromedriver/mac");
                       Runtime.getRuntime().exec("xattr -d com.apple.quarantine chromedriver");
                   }
                   catch (Exception any){
                       log.error("Failed to take out from quarantine MAC chromedriver");
                   }

               }
                log.info("Creating ChromeDriver instance for local machine");
                System.setProperty("webdriver.chrome.driver", driverPath );
            }
        } catch (Exception any) {
            throw new Exception("Unable to start chrome driver: " + any.getMessage());
        }
        finally {
            driver.set(new ChromeDriver(getChromeOptions()));
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", userDirectory + File.separator + "downloads");
        options.setExperimentalOption("prefs", prefs);
        //options.setCapability(SUPPORTS_JAVASCRIPT, true);
        if(isHeadless){
            options.addArguments("--headless");
        }
        if(isFabric){
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            options.addArguments("--disable-setuid-sandbox");
            options.addArguments("--no-sandbox");
//            options.setProxy(null)
//            options.addArguments("--no-proxy-server");
//            options.addArguments("--proxy-server=dev-net-proxy.intranet.db.com:8080");
//            options.addArguments("--user-data-dir=/home/default");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-ipv6");;
            options.addArguments("--browser-test");
            options.addArguments("enable-automation");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--dns-prefetch-disable");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("enable-features=NetworkServiceInProcess");
            options.addArguments("disable-features=NetworkService");
            options.addArguments("--force-device-scale-factor=1");
            options.addArguments("--ignore-ssl-errors");
            options.addArguments("--aggressive-cache-discard");
            options.addArguments("--disable-cache");
            options.addArguments("--disable-application-cache");
            options.addArguments("--disable-offline-load-stale-cache");
            options.addArguments("--disk-cache-size=0");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--allow-insecure-localhost");
            options.setAcceptInsecureCerts(true);
        }
        return options;
    }

    public static void tearDownDriver(){
        log.info("Closing Browser & WebDriver instance");
        driver.get().quit();
    }

    public static Object executeScript(String script) {
        return ((JavascriptExecutor) driver.get()).executeScript(script);
    }

    public static Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver.get()).executeScript(script, args);
    }

    public static void highlightElement(WebElement element) {
        executeScript("arguments[0].setAttribute('style', 'border: 1.5px solid red;');", element);
    }

}
