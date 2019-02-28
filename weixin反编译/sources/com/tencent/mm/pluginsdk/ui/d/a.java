package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class a {
    public static ArrayList<k> bc(Context context, String str) {
        ArrayList<k> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.h.a.vBk.matcher(str);
        while (matcher.find()) {
            k a = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static k a(Context context, String str, int i, int i2) {
        return a(context, str, i, i2, 0, 0);
    }

    public static k a(Context context, String str, int i, int i2, int i3, int i4) {
        if (context == null) {
            context = ad.getContext();
        }
        k p = com.tencent.mm.pluginsdk.ui.d.b.a.vAZ.p(context, str);
        if (p != null) {
            p.start = i;
            p.end = i2;
            p.linkColor = i3;
            p.backgroundColor = i4;
        }
        return p;
    }
}
