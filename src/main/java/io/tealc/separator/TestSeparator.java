/*
 * Copyright Tealc authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.tealc.separator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Collections;

@ExtendWith(ExtensionContextParameterResolver.class)
public interface TestSeparator {
    Logger LOGGER = LoggerFactory.getLogger(TestSeparator.class);
    String SEPARATOR_CHAR = "#";

    @BeforeEach
    default void beforeEachTest(ExtensionContext testContext) {
        LOGGER.info(String.join("", Collections.nCopies(76, SEPARATOR_CHAR)));
        LOGGER.info(String.format("%s.%s-STARTED", testContext.getRequiredTestClass().getName(), testContext.getRequiredTestMethod().getName()));
    }

    @AfterEach
    default void afterEachTest(ExtensionContext testContext) {
        LOGGER.info(String.format("%s.%s-FINISHED", testContext.getRequiredTestClass().getName(), testContext.getRequiredTestMethod().getName()));
        LOGGER.info(String.join("", Collections.nCopies(76, SEPARATOR_CHAR)));
    }
}
