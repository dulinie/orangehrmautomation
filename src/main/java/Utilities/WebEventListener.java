package Utilities;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import base.BaseTest;


public class WebEventListener extends BaseTest implements WebDriverListener {

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Navigating to URL: " + url);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Searching for element using locator: " + locator);
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Attempting to click element: " + element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Successfully clicked the element.");
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException error) {
        System.out.println("Exception occurred: " + error.getCause());
        try {
            WaitUtils.takeScreenshotAtEndOfTest(BaseTest.driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
}