package Utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;

public class WebEventListener implements WebDriverListener {

    private static final Logger logger = LogManager.getLogger(WebEventListener.class);

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        logger.debug("Navigating to URL: {}", url);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.debug("Searching for element using locator: {}", locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.debug("Attempting to click element: {}", element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {
        logger.debug("Successfully clicked the element.");
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException error) {
        logger.error("Exception occurred: {}", error.getCause());
        ScreenshotUtils.captureScreenshot(BaseTest.driver, "Error_" + System.currentTimeMillis());
    }
}