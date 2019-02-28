package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.g;
import com.tencent.xweb.xwalk.a.c;
import com.tencent.xweb.xwalk.a.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public class XWalkWebFactory implements com.tencent.xweb.c.h.a {
    static XWalkWebFactory sInstance;
    private boolean mIsDebugMode = false;
    private boolean mIsDebugModeReplase = false;

    static class a {
        private static boolean AAw = false;
        private static boolean ABm = false;
        private static boolean mbu = false;

        public static boolean hasInited() {
            return mbu;
        }

        public static boolean hasInitedCallback() {
            return AAw;
        }

        public static boolean isCoreReady() {
            return ABm;
        }

        public static boolean iU(Context context) {
            if (mbu) {
                return mbu;
            }
            Log.i("XWebViewHelper", "preInit");
            if (h.ed(context)) {
                Log.i("XWebViewHelper", "preInit finished");
                mbu = true;
                ABm = true;
            } else {
                Log.i("XWebViewHelper", "preInit xwalk is not available");
            }
            return mbu;
        }

        public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
            if (!AAw) {
                Log.i("XWebViewHelper", "initCallback");
                WebViewExtension.SetExtension(webViewExtensionListener);
                AAw = true;
            }
        }
    }

    public static XWalkWebFactory getInstance() {
        if (sInstance == null) {
            sInstance = new XWalkWebFactory();
        }
        return sInstance;
    }

    private XWalkWebFactory() {
    }

    public Object excute(String str, Object[] objArr) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.equals("STR_CMD_GET_DEBUG_VIEW")) {
            return new a((WebView) objArr[0]);
        }
        if (str.equals("STR_CMD_GET_UPDATER")) {
            return new com.tencent.xweb.xwalk.l.a();
        }
        if (str.equals("STR_CMD_CLEAR_SCHEDULER")) {
            c.a(null);
            return null;
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE")) {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = true;
            return null;
        } else if (!str.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE")) {
            return null;
        } else {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = false;
            return null;
        }
    }

    public g createWebView(WebView webView) {
        try {
            if (h.ed(webView.getContext())) {
                WebViewExtension.updateExtension(false);
                return new h(webView);
            }
        } catch (Exception e) {
            XWalkInitializer.addXWalkInitializeLog("init xwalk crashed:" + e.getMessage());
        }
        return null;
    }

    public void initInterface() {
    }

    public void initEnviroment(Context context) {
        if (this.mIsDebugMode) {
            tryLoadLocalAssetRuntime(context, this.mIsDebugModeReplase);
        }
    }

    public static synchronized boolean tryLoadLocalAssetRuntime(Context context, boolean z) {
        boolean z2 = false;
        synchronized (XWalkWebFactory.class) {
            XWalkEnvironment.init(context);
            if (z && XWalkEnvironment.getAvailableVersion() == 999) {
                XWalkEnvironment.delApiVersion(999);
            }
            if (XWalkEnvironment.getAvailableVersion() == -1 || z) {
                try {
                    InputStream open = context.getAssets().open(XWalkEnvironment.LOCAL_TEST_ZIP_NAME);
                    File file = new File(XWalkEnvironment.getDownloadZipDir(999));
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    XWalkUpdater.updateLocalXWalkRuntime();
                    z2 = true;
                } catch (IOException e) {
                }
            }
        }
        return z2;
    }

    public f getJsCore(com.tencent.xweb.g.a aVar, Context context) {
        initWebviewCore(context, null);
        switch (aVar) {
            case RT_TYPE_J2V8:
            case RT_TYPE_NATIVE_SCRIPT:
                if (!d.isXWalkReady()) {
                    return null;
                }
                f gVar;
                if (aVar == com.tencent.xweb.g.a.RT_TYPE_J2V8) {
                    gVar = new g();
                    gVar.init(0);
                    return gVar;
                } else if (aVar != com.tencent.xweb.g.a.RT_TYPE_NATIVE_SCRIPT) {
                    return null;
                } else {
                    gVar = new g();
                    gVar.init(1);
                    return gVar;
                }
            default:
                return null;
        }
    }

    public boolean initWebviewCore(Context context, b bVar) {
        boolean iU = a.iU(context);
        if (bVar != null) {
            if (iU) {
                bVar.tI();
            } else {
                bVar.tJ();
            }
        }
        return iU;
    }

    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        a.initCallback(webViewExtensionListener);
    }

    public boolean hasInited() {
        return a.hasInited();
    }

    public boolean hasInitedCallback() {
        return a.hasInitedCallback();
    }

    public boolean isCoreReady() {
        return a.isCoreReady();
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return new c();
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return new d();
    }
}
