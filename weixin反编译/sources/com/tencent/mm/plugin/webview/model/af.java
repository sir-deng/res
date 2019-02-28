package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class af extends i<ae> {
    public static final String[] gLy = new String[]{i.a(ae.gKN, "WebviewLocalData")};

    public af(e eVar) {
        super(eVar, ae.gKN, "WebviewLocalData", null);
    }

    public static int ac(String str, String str2, String str3) {
        return (str + str2 + str3).hashCode();
    }
}
