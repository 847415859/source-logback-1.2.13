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
import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.encoder.LayoutWrappingEncoder

def p = "HELLO"

appender("STDOUT", ConsoleAppender) {
  encoder(LayoutWrappingEncoder) {
    layout(PatternLayout) {
      pattern = "${p} %m%n"
    }
  }
}
appender("STDOUT-ASYNC", AsyncAppender) {
  appenderRef('STDOUT')
}
root(DEBUG, ["STDOUT-ASYNC"])

