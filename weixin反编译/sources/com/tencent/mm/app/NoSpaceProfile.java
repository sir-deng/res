package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public class NoSpaceProfile extends e {
    public static final String ffs = (ad.getPackageName() + ":nospace");

    public final void onCreate() {
        k.b(a.xmo, NoSpaceProfile.class.getClassLoader());
        i.cq(ffs);
        k.setupBrokenLibraryHandler();
        bi.initLanguage(ad.getContext());
        m.ua();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }
}
