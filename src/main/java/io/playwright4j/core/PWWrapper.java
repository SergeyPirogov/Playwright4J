package io.playwright4j.core;

import com.microsoft.playwright.*;
import io.playwright4j.Configuration;

import java.util.concurrent.ConcurrentHashMap;

public class PWWrapper {

    private static final ConcurrentHashMap<Long, PWContainer> pwHolder = new ConcurrentHashMap<>();

    public static PWContainer pwContainer() {
        long threadId = Thread.currentThread().getId();
        if (!pwHolder.containsKey(threadId)) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(Configuration.headless)
                            .setTimeout(Configuration.browserToStartTimeout)
                            .setDevtools(false)
                            .setSlowMo(Configuration.poolingInterval)
            );
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            pwHolder.put(threadId, new PWContainer(context, page, playwright, browser));
        }

        return pwHolder.get(threadId);
    }

    public static void close() {
        long threadId = Thread.currentThread().getId();

        if (pwHolder.containsKey(threadId)) {
            PWContainer pwContainer = pwHolder.get(threadId);
            pwContainer.getPage().close();
            pwContainer.getContext().close();
            pwContainer.getBrowser().close();
            pwContainer.getPlaywright().close();
            pwHolder.remove(threadId);
        }
    }
}
