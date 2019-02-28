package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class r {
    private static List<a> vFS = new ArrayList();

    public interface a {
        void bUb();

        void bUc();

        void dQ(Context context);

        String getName();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            x.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!vFS.contains(aVar)) {
                vFS.add(aVar);
            }
        }
    }

    public static List<a> cdC() {
        return vFS;
    }

    public static void clear() {
        x.d("MicroMsg.WebViewPluginCenter", "clear");
        vFS.clear();
    }
}
