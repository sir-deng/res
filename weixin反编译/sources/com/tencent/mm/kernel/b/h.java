package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.booter.c;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public final class h extends g {
    public c gAA;
    public MMApplicationLike gUv;
    public a<ApplicationLifeCycle> gUw = new a();
    public e mProfileCompat;

    /* renamed from: com.tencent.mm.kernel.b.h$3 */
    class AnonymousClass3 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ int gUy;

        public AnonymousClass3(int i) {
            this.gUy = i;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onTrimMemory(this.gUy);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$5 */
    class AnonymousClass5 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Configuration gUz;

        public AnonymousClass5(Configuration configuration) {
            this.gUz = configuration;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.gUz);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$6 */
    class AnonymousClass6 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Context val$context;

        public AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final /* synthetic */ void az(Object obj) {
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
        }
    }

    public final String getPackageName() {
        return ad.getPackageName();
    }

    public h(String str, Application application, MMApplicationLike mMApplicationLike) {
        super(str, application);
        ad.VG(str);
        this.gUv = mMApplicationLike;
    }
}
