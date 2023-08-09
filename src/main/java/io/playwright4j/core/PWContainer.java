package io.playwright4j.core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PWContainer {


    private final BrowserContext context;
    private final Page page;
    private final Playwright playwright;
    private final Browser browser;

    public PWContainer(BrowserContext context, Page page, Playwright playwright, Browser browser) {
        this.context = context;
        this.page = page;
        this.playwright = playwright;
        this.browser = browser;
    }

    public BrowserContext getContext() {
        return context;
    }

    public Page getPage() {
        return page;
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public Browser getBrowser() {
        return browser;
    }
}
