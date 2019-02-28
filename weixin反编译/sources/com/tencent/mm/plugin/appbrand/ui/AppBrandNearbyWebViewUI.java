package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class AppBrandNearbyWebViewUI extends WebViewUI {
    private static Boolean jQM = null;

    public final void onCreate(Bundle bundle) {
        if (getIntent() != null) {
            getIntent().putExtra("forceHideShare", true);
            getIntent().putExtra("disable_bounce_scroll", true);
            getIntent().putExtra("show_long_click_popup_menu", false);
            getIntent().putExtra("key_load_js_without_delay", true);
        }
        super.onCreate(bundle);
        setResult(-1);
    }

    public final void setMMTitle(String str) {
        super.setMMTitle(str);
        oj(WebView.NIGHT_MODE_COLOR);
    }

    protected final void initView() {
        super.initView();
        if (getSupportActionBar() != null) {
            oj(WebView.NIGHT_MODE_COLOR);
            cnG();
            Bb(WebView.NIGHT_MODE_COLOR);
            getSupportActionBar().getCustomView().setBackgroundColor(-1052684);
            k.a(this);
        }
    }

    protected final int alo() {
        if (VERSION.SDK_INT >= 23 && (!h.zq() || !alp())) {
            ae.g(getWindow());
            return -1052684;
        } else if (VERSION.SDK_INT >= 21) {
            return n.iuA;
        } else {
            return super.alo();
        }
    }

    public static boolean alp() {
        Throwable th;
        if (jQM == null) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream2);
                    jQM = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        jQM = Boolean.valueOf(false);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        return jQM.booleanValue();
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileInputStream = fileInputStream2;
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                fileInputStream2 = null;
                jQM = Boolean.valueOf(false);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return jQM.booleanValue();
            } catch (Throwable th4) {
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return jQM.booleanValue();
    }
}
