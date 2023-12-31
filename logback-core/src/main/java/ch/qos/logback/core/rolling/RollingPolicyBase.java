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
package ch.qos.logback.core.rolling;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.helper.CompressionMode;
import ch.qos.logback.core.rolling.helper.FileNamePattern;
import ch.qos.logback.core.spi.ContextAwareBase;

/**
 * Implements methods common to most, it not all, rolling policies. Currently
 * such methods are limited to a compression mode getter/setter.
 * 
 * @author Ceki G&uuml;lc&uuml;
 */
public abstract class RollingPolicyBase extends ContextAwareBase implements RollingPolicy {
    // 压缩模式
    protected CompressionMode compressionMode = CompressionMode.NONE;
    // 文件名称形式
    FileNamePattern fileNamePattern;
    // fileNamePatternStr is always slashified, see setter
    protected String fileNamePatternStr;

    private FileAppender<?> parent;

    // use to name files within zip file, i.e. the zipEntry
    // 文件压缩格式
    FileNamePattern zipEntryFileNamePattern;
    private boolean started;

    /**
     * 给定FileNamePattern字符串，此方法根据fileNamePatternStr的最后一个字母确定压缩模式。
     * 以.gz结尾的模式表示GZIP压缩，
     * 以.zip结尾表示zip压缩。
     * 否则，默认情况下，没有压缩
     */
    protected void determineCompressionMode() {
        if (fileNamePatternStr.endsWith(".gz")) {
            addInfo("Will use gz compression");
            compressionMode = CompressionMode.GZ;
        } else if (fileNamePatternStr.endsWith(".zip")) {
            addInfo("Will use zip compression");
            compressionMode = CompressionMode.ZIP;
        } else {
            addInfo("No compression will be used");
            compressionMode = CompressionMode.NONE;
        }
    }

    public void setFileNamePattern(String fnp) {
        fileNamePatternStr = fnp;
    }

    public String getFileNamePattern() {
        return fileNamePatternStr;
    }

    public CompressionMode getCompressionMode() {
        return compressionMode;
    }

    public boolean isStarted() {
        return started;
    }

    public void start() {
        started = true;
    }

    public void stop() {
        started = false;
    }

    public void setParent(FileAppender<?> appender) {
        this.parent = appender;
    }

    public boolean isParentPrudent() {
        return parent.isPrudent();
    }

    public String getParentsRawFileProperty() {
        return parent.rawFileProperty();
    }
}
