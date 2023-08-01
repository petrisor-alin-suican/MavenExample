package com.db.afbc.at.webdriver;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

public class CaptureScreenshotUtil {

    public static Logger LOG = LoggerFactory.getLogger(CaptureScreenshotUtil.class);

    public static void captureScreenshot(WebDriver driver, Scenario scenario) {
        String fileName =
                "scr-" + scenario.getName().replaceAll("\\s", "_")
                        + "_" + System.currentTimeMillis() + ".png";
        String path = "target" + File.separator + fileName;
        try (FileOutputStream out = new FileOutputStream(path);){
            // Make sure that the directory is there
            new File("target/").mkdirs();
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            final byte[] screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
            out.write(screenshot);
            scenario.attach(screenshot, "image/png", fileName);
        } catch (Exception e) {
            LOG.error("Could not take the screenshot!");
        }
    }

}