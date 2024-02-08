package com.alea.util;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HandlerUtil {
    public String getLastBrowserHandle(WebDriver driver) {
        int count = driver.getWindowHandles().size();
        Set<String> windows = null;
        for (int i = 0; i < 5; i++) {
            windows = driver.getWindowHandles();
            try {
                Thread.sleep(500);
            } catch (Exception ignore) {
            }
            if (windows.size() != count)
                break;
        }
        int last = windows.size() - 1;
        String handle = windows.toArray()[last].toString();
        return handle;
    }
}
