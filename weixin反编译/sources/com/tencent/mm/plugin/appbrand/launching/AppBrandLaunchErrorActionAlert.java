package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String jCc;
    final String jCd;

    AppBrandLaunchErrorActionAlert(String str, int i, String str2, String str3) {
        super(str, i);
        this.jCc = str2;
        this.jCd = str3;
    }

    @Keep
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        this.jCc = parcel.readString();
        this.jCd = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.jCc);
        parcel.writeString(this.jCd);
    }

    final void cb(Context context) {
        String str = this.jCd;
        String str2 = this.jCc;
        if (context instanceof Activity) {
            h.a(context, str, str2, false, null);
        } else {
            a.a(null, str, str2, ad.getResources().getString(j.dGf), "", null, null, null);
        }
    }
}
