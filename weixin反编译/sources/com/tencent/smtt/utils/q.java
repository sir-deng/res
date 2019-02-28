package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public final class q {
    private static q Akq = null;
    private File Akp = null;
    public String Akr = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    public String Aks = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String Akt = "http://wup.imtt.qq.com:8080";
    public String Aku = "http://log.tbs.qq.com/ajax?c=dl&k=";
    public String Akv = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    public String Akw = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String Akx = "http://mqqad.html5.qq.com/adjs";
    private String Aky = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    private Context mContext = null;

    @TargetApi(11)
    private q(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.mContext = context.getApplicationContext();
        cGx();
    }

    public static synchronized q cGw() {
        q qVar;
        synchronized (q.class) {
            qVar = Akq;
        }
        return qVar;
    }

    private synchronized void cGx() {
        Throwable th;
        Writer stringWriter;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File cGy = cGy();
            if (cGy == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } else {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(cGy));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.Akr = property;
                    }
                    property = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property)) {
                        this.Akt = property;
                    }
                    property = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property)) {
                        this.Aku = property;
                    }
                    property = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property)) {
                        this.Akv = property;
                    }
                    property = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property)) {
                        this.Akw = property;
                    }
                    property = properties.getProperty("tips_url", "");
                    if (!"".equals(property)) {
                        this.Akx = property;
                    }
                    property = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property)) {
                        this.Aky = property;
                    }
                    String property2 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property2)) {
                        this.Aks = property2;
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
        return;
    }

    private File cGy() {
        Throwable th;
        File file;
        try {
            if (this.Akp == null) {
                this.Akp = new File(f.ar(this.mContext, 5));
                if (this.Akp == null || !this.Akp.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.Akp, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
                return null;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            file = null;
            th = th4;
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    public static synchronized q ib(Context context) {
        q qVar;
        synchronized (q.class) {
            if (Akq == null) {
                Akq = new q(context);
            }
            qVar = Akq;
        }
        return qVar;
    }
}
