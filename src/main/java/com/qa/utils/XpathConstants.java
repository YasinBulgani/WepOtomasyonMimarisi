package com.qa.utils;

/**
 * Commonly used XPath expressions in the tests. Keeping them in a central
 * place helps avoiding duplication in step definitions.
 */
public final class XpathConstants {

    private XpathConstants() {
        // Utility class
    }

    /** XPath of the search box on the home page. */
    public static final String SEARCH_BOX = "//*[@name='q']";
}
