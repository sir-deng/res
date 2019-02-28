package com.tencent.mm.bg;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public enum a {
    ;

    private a(String str) {
    }

    public static boolean Vi() {
        return !bi.oN(Vj());
    }

    public static String Vj() {
        g.Dr();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageUrl : %s", (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_URL_STRING_SYNC, String.valueOf("")));
        return (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_URL_STRING_SYNC, String.valueOf(""));
    }

    public static String Vk() {
        g.Dr();
        x.i("MicroMsg.WebviewKeepManager", "getLastPageTitle : %s", (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, String.valueOf("")));
        return (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, String.valueOf(""));
    }

    public static void q(String str, String str2, String str3) {
        g.Dr();
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_URL_STRING_SYNC, (Object) str);
        g.Dr();
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_TITLE_STRING_SYNC, (Object) str2);
        g.Dr();
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_GAME_WEBVIEW_KEEP_LAST_PAGE_USERNAME_STRING_SYNC, (Object) str3);
    }
}
