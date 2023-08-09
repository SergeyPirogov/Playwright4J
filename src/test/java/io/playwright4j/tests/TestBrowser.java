package io.playwright4j.tests;

import io.playwright4j.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.playwright4j.Virtuoso.$;
import static io.playwright4j.Virtuoso.open;

public class TestBrowser {

    @BeforeEach
    void setUp() {
        Configuration.headless = false;
    }

    @Test
    void testShouldOpenPlaywrightSite() {
        open("https://playwright.dev/java/");
        assertThat($(".navbar__title")).hasText("Playwright for Java");
    }
}
