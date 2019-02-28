package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.f.a.br;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;

public final class MenuDelegate_SendToDesktop extends a {

    private static class SendShortcutToDesktopTask extends MainProcessTask {
        public static final Creator<SendShortcutToDesktopTask> CREATOR = new Creator<SendShortcutToDesktopTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendShortcutToDesktopTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendShortcutToDesktopTask[i];
            }
        };
        private int fwH;
        private boolean jGd;
        private String mAppId;
        private Context mContext;
        private String username;

        public SendShortcutToDesktopTask(Context context, String str, String str2, int i) {
            this.mContext = context;
            this.username = str;
            this.mAppId = str2;
            this.fwH = i;
        }

        public SendShortcutToDesktopTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            final Context context = ad.getContext();
            String str = this.username;
            int i = this.fwH;
            if (context == null || str == null) {
                x.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
            } else {
                b brVar = new br();
                brVar.fqE.username = str;
                com.tencent.mm.sdk.b.a.xmy.m(brVar);
                if (brVar.fqF.fqH == null) {
                    x.e("MicroMsg.AppBrandShortcutManager", "no such user");
                } else {
                    Intent a = k.a(context, brVar, i, k.a(context, k.a(brVar), i), false);
                    if (a == null) {
                        x.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                    } else {
                        com.tencent.mm.plugin.base.model.b.p(context, a);
                        x.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", str);
                    }
                }
            }
            ah.h(new Runnable() {
                public final void run() {
                    if (SendShortcutToDesktopTask.this.jGd = k.e(context, SendShortcutToDesktopTask.this.username, SendShortcutToDesktopTask.this.fwH)) {
                        g.pWK.a(443, 1, 1, false);
                    }
                    SendShortcutToDesktopTask.this.afF();
                }
            }, 1000);
        }

        public final void YB() {
            if (this.mContext != null && this.jGd) {
                AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(this.mAppId);
                if (pk != null) {
                    SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(this.mContext, "pref_appbrand_" + pk.uin, 4);
                    if (!sharedPreferences.contains("has_show_send_to_desktop_tips")) {
                        if (com.tencent.mm.plugin.appbrand.a.pi(this.mAppId) != null) {
                            Context context = this.mContext;
                            h.b(context, context.getString(j.iBt), context.getString(j.dGZ), false);
                        }
                        sharedPreferences.edit().putBoolean("has_show_send_to_desktop_tips", true).commit();
                    }
                }
            }
        }

        public final void f(Parcel parcel) {
            this.username = parcel.readString();
            this.fwH = parcel.readInt();
            this.jGd = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeInt(this.fwH);
            parcel.writeInt(this.jGd ? 1 : 0);
        }
    }

    public MenuDelegate_SendToDesktop() {
        super(m.jGr - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (pVar.iuk.itc.scene != 1023) {
            nVar.f(this.jGz, context.getString(j.iDH));
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        Object obj = appBrandSysConfig.foe;
        if (context == null || TextUtils.isEmpty(obj)) {
            x.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, context or username is null or nil.");
            return;
        }
        AppBrandMainProcessService.a(new SendShortcutToDesktopTask(context, obj, str, appBrandSysConfig.iRU.iJa));
        com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 14, "", bi.Wx(), 1, 0);
    }
}
