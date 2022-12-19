/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Code Technology Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.jpom.system;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.cron.CronUtil;
import io.jpom.common.JpomApplicationEvent;
import io.jpom.common.RemoteVersion;
import lombok.Data;

import java.nio.charset.Charset;

/**
 * @author bwcx_jzy
 * @since 2022/12/17
 */
@Data
public abstract class BaseSystemConfig {

    /**
     * 是否开启秒级匹配
     */
    private boolean timerMatchSecond = false;

    public void setTimerMatchSecond(boolean timerMatchSecond) {
        this.timerMatchSecond = timerMatchSecond;
        // 开启秒级
        CronUtil.setMatchSecond(timerMatchSecond);
    }

    /**
     * 旧包文件保留个数
     */
    private int oldJarsCount = 2;

    public void setOldJarsCount(int oldJarsCount) {
        this.oldJarsCount = oldJarsCount;
        JpomApplicationEvent.setOldJarsCount(oldJarsCount);
    }

    /**
     * 远程更新地址
     */
    private String remoteVersionUrl;

    public void setRemoteVersionUrl(String remoteVersionUrl) {
        this.remoteVersionUrl = remoteVersionUrl;
        RemoteVersion.setRemoteVersionUrl(remoteVersionUrl);
    }

    /**
     * 系统日志编码格式
     */
    private Charset logCharset;

    /**
     * 默认 utf-8
     *
     * @return 日志文件编码格式
     */
    public Charset getLogCharset() {
        return ObjectUtil.defaultIfNull(logCharset, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 控制台编码格式
     */
    private Charset consoleCharset;

    public void setConsoleCharset(Charset consoleCharset) {
        this.consoleCharset = consoleCharset;
        ExtConfigBean.setConsoleLogCharset(consoleCharset);
    }
}