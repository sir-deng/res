package com.tencent.mm.bg;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;

public enum c {
    ;

    private c(String str) {
    }

    public static boolean Vi() {
        return !bi.oN(Vl());
    }

    public static String Vl() {
        as.Hm();
        x.i("MicroMsg.WebviewKeepManager", "getLastPage : %s", (String) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_STRING_SYNC, String.valueOf("")));
        return (String) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_STRING_SYNC, String.valueOf(""));
    }

    public static String Vk() {
        as.Hm();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", (String) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, String.valueOf("")));
        return (String) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, String.valueOf(""));
    }

    public static int Vm() {
        as.Hm();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageKeepTopScene : %d", Integer.valueOf(bi.a((Integer) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_TOP_SCENE_INT_SYNC, null), 0)));
        return bi.a((Integer) com.tencent.mm.y.c.Db().get(a.USERINFO_WEBVIEW_KEEP_TOP_SCENE_INT_SYNC, null), 0);
    }

    public static void f(String str, String str2, int i) {
        x.i("MicroMsg.WebviewKeepManager", "saveLastPage : url=%s title=%s scene=%d", str, str2, Integer.valueOf(i));
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_STRING_SYNC, bi.oM(str));
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, bi.oM(str2));
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_WEBVIEW_KEEP_TOP_SCENE_INT_SYNC, Integer.valueOf(i));
    }
}
