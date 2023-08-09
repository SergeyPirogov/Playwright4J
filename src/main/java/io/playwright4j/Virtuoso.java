package io.playwright4j;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static io.playwright4j.core.PWWrapper.pwContainer;

public class Virtuoso {

    public static Page page() {
        return pwContainer().getPage();
    }

    public static Locator $(String locator) {
        return page().locator(locator);
    }

    public static void open(String url) {
        page().navigate(url);
    }
}
