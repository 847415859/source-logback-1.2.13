/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.access;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ch.qos.logback.access.spi.PackageTest.class, ch.qos.logback.access.boolex.PackageTest.class, ch.qos.logback.access.net.PackageTest.class,
        ch.qos.logback.access.pattern.PackageTest.class, ch.qos.logback.access.joran.PackageTest.class,
        ch.qos.logback.access.jetty.PackageTest.class, ch.qos.logback.access.filter.PackageTest.class, ch.qos.logback.access.servlet.PackageTest.class,
        ch.qos.logback.access.sift.PackageTest.class })
public class AllAccessTest {

}
