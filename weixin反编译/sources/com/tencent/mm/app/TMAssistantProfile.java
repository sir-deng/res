package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.e.a;
import com.tencent.mm.sdk.platformtools.ad;

public class TMAssistantProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":TMAssistantDownloadSDKService");

    public final void onCreate() {
        a.ay(ad.getContext());
        i.cq(ffs);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.xmo, TMAssistantProfile.class.getClassLoader());
        m.ua();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public String toString() {
        return ffs;
    }
}
