package io.playwright4j;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static io.playwright4j.core.PWWrapper.pwContainer;

public class Virtuoso {

    public static Page page() {
        return pwContainer().getPage();
    }

    public static Locator $(String locator) {
        return page().locator(locator);
    }

    public static Locator $(AriaRole role, String text) {
        return page().getByRole(role, new Page.GetByRoleOptions().setName(text));
    }

    public static void open(String url) {
        page().navigate(url);
    }
}
