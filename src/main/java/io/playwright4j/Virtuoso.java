package io.playwright4j;

import com.microsoft.playwright.Locator;

import static io.playwright4j.core.PWWrapper.pwContainer;

public class Virtuoso {

    public static Locator $(String locator) {
        return pwContainer().getPage().locator(locator);
    }

    public static void open(String url) {
        pwContainer().getPage().navigate(url);
    }
}
