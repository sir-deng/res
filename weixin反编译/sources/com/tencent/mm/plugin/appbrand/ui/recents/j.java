package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;

final class j extends c<Object> {
    j(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    public final boolean bW(int i, int i2) {
        if (!this.jQJ.get(i).getClass().equals(this.jQK.get(i2).getClass())) {
            return false;
        }
        if (!(this.jQJ.get(i) instanceof k)) {
            return false;
        }
        k kVar = (k) this.jQJ.get(i);
        k kVar2 = (k) this.jQK.get(i2);
        return kVar.iIZ == kVar2.iIZ && kVar.foe.equals(kVar2.foe);
    }

    public final boolean bX(int i, int i2) {
        if (!(this.jQJ.get(i) instanceof k)) {
            return false;
        }
        k kVar = (k) this.jQJ.get(i);
        k kVar2 = (k) this.jQK.get(i2);
        if (bi.oM(kVar.appId).equals(kVar2.appId) && kVar.foe.equals(kVar2.foe) && kVar.iIZ == kVar2.iIZ && kVar.iMQ == kVar2.iMQ && bi.oM(kVar.iMO).equals(kVar2.iMO) && bi.oM(kVar.appName).equals(kVar2.appName)) {
            return true;
        }
        return false;
    }

    public final Object bY(int i, int i2) {
        if (i >= this.jQJ.size()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.jQJ.get(i) instanceof k) {
            k kVar = (k) this.jQJ.get(i);
            k kVar2 = (k) this.jQK.get(i2);
            if (kVar.iMP != kVar2.iMP) {
                bundle.putLong("running_flag", kVar2.iMP);
            }
            if (kVar.iMQ != kVar2.iMQ) {
                bundle.putBoolean("star", kVar2.iMQ);
            }
            if (kVar.iIZ != kVar2.iIZ) {
                bundle.putInt("debug_type", kVar2.iIZ);
            }
            if (!bi.oM(kVar.iMO).equals(kVar2.iMO)) {
                bundle.putString("icon", kVar2.iMO);
            }
            if (!bi.oM(kVar.appName).equals(kVar2.appName)) {
                bundle.putString("nick_name", kVar2.appName);
            }
        }
        return bundle.size() <= 0 ? null : bundle;
    }
}
