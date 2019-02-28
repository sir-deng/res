package com.tencent.mm.plugin.appbrand.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.AppBrandMusicClientService.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.sdk.platformtools.x;

abstract class f extends g {
    private final com.tencent.mm.plugin.appbrand.ui.banner.f iKA = new com.tencent.mm.plugin.appbrand.ui.banner.f() {
        public final void al(String str, int i) {
            if (!f.this.iuk.mAppId.equals(str)) {
                f.this.jD(2);
            }
        }
    };
    int iKy = 0;
    private final b iKz = new b() {
        public final void aaO() {
            f.this.jD(1);
        }

        public final void onStop() {
            f.this.jD(1);
        }
    };
    final e iuk;

    abstract void aaK();

    f(h hVar, e eVar) {
        super(hVar);
        this.iuk = eVar;
    }

    public void enter() {
        int i;
        super.enter();
        this.iKy = 0;
        String str = this.iuk.mAppId;
        int i2 = this.iuk.isR.iIZ;
        if (this.iuk.isS == null || !this.iuk.isS.iRQ) {
            i = 0;
        } else {
            i = 1;
        }
        AppBrandMusicClientService appBrandMusicClientService;
        if (i == 0) {
            appBrandMusicClientService = AppBrandMusicClientService.jFa;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase(appBrandMusicClientService.jFb)) {
                    MainProcessTask stopBackgroundMusicTask = new StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                } else {
                    x.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                }
            }
        } else if (AppBrandMusicClientService.tN(str)) {
            ca(1);
            appBrandMusicClientService = AppBrandMusicClientService.jFa;
            b bVar = this.iKz;
            if (!(TextUtils.isEmpty(str) || bVar == null)) {
                if (appBrandMusicClientService.jEZ.containsKey(str)) {
                    appBrandMusicClientService.jEZ.remove(str);
                    appBrandMusicClientService.jEZ.put(str, bVar);
                } else {
                    appBrandMusicClientService.jEZ.put(str, bVar);
                }
            }
        }
        if (c.px(str) == c.c.HANG || a.aO(str, i2)) {
            ca(2);
            a.d(this.iKA);
        }
        switch (c.px(str)) {
            case LAUNCH_MINI_PROGRAM:
                ca(16);
                break;
            case LAUNCH_NATIVE_PAGE:
                ca(4);
                break;
            case HOME_PRESSED:
                ca(8);
                break;
        }
        this.iKy = this.iKy;
        jD(0);
    }

    public void exit() {
        super.exit();
        this.iKy = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.jFa;
        CharSequence charSequence = this.iuk.mAppId;
        if (!TextUtils.isEmpty(charSequence) && appBrandMusicClientService.jEZ.containsKey(charSequence)) {
            appBrandMusicClientService.jEZ.remove(charSequence);
        }
        a.c(this.iKA);
    }

    private void ca(int i) {
        this.iKy |= i;
    }

    final void jD(int i) {
        this.iKy &= i ^ -1;
        if (this.iKy == 0) {
            aaK();
        }
    }
}
