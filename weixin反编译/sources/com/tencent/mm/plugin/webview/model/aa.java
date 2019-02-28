package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class aa {
    private static final Set<String> tyO;

    static {
        Set hashSet = new HashSet();
        tyO = hashSet;
        hashSet.add("file:///android_asset/");
        String str = e.hbw;
        if (!bi.oN(str)) {
            str = e.hbw.replace("/data/user/0", "/data/data");
        }
        tyO.add("file://" + new File(g.Aj(0)).getAbsolutePath());
        tyO.add("file://" + new File(e.bnF, g.Ah(0)).getAbsolutePath());
        tyO.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        tyO.add("file://" + new File(e.bnF, "wenote/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r1.getAbsolutePath(), r2.getAbsolutePath());
        tyO.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        tyO.add("file://" + new File(e.bnF, "emoji/res").getAbsolutePath());
        x.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r1.getAbsolutePath(), r0.getAbsolutePath());
        Iterator it = tyO.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", (String) it.next());
        }
    }

    public static boolean ON(String str) {
        if (r.ifK) {
            x.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            return true;
        } else if (bi.oN(str)) {
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                return false;
            }
            if (toLowerCase.startsWith("file://")) {
                for (String startsWith : tyO) {
                    if (toLowerCase.startsWith(startsWith)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (bi.oN(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(s.cdD());
        }
    }
}
