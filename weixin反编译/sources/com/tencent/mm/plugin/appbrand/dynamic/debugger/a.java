package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class a {
    private static com.tencent.mm.t.c.e.a iWi = new com.tencent.mm.t.c.e.a() {
        public final void B(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt(DownloadInfo.STATUS, i);
            f.a("com.tencent.mm", bundle, a.class, null);
        }
    };

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, c cVar) {
            b.B(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), bundle.getInt(DownloadInfo.STATUS));
        }
    }

    public static void a(String str, ArrayList<LogInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putParcelableArrayList("logList", arrayList);
        com.tencent.mm.ipcinvoker.d.c.BG().b(b.kne.getClass().getName(), bundle);
    }

    public static com.tencent.mm.t.c.e.a adl() {
        return iWi;
    }
}
