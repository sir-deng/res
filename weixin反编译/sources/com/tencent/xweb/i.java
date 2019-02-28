package com.tencent.xweb;

import android.content.Context;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.h;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

public final class i {
    static a Azo = ((a) h.a(c.WV_KIND_CW).excute("STR_CMD_GET_UPDATER", null));

    public interface a {
        void iR(Context context);

        boolean isBusy();
    }

    public static void iR(Context context) {
        e.cJL();
        if (Azo != null) {
            Azo.iR(context);
        } else {
            Log.e("WCWebUpdater", "no sWebviewUpdater");
        }
    }

    public static boolean isBusy() {
        if (Azo != null) {
            return Azo.isBusy();
        }
        Log.e("WCWebUpdater", "check is busy : no sWebviewUpdater");
        return false;
    }
}
