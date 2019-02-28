package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Map;

public final class j implements t {
    public static boolean vjW = false;
    private static j vjX;
    public a vjY;

    public interface a {
        void a(m mVar);
    }

    public static class b {
        public String vjZ;
    }

    private j() {
    }

    public static j bZa() {
        if (vjX == null) {
            vjX = new j();
        }
        return vjX;
    }

    public final void bZb() {
        if (as.Hp()) {
            an.aRP().a(14, (t) this);
            vjW = true;
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        if (as.Hp()) {
            x.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (wVar == null) {
                x.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            } else if (i == 0 && i2 == 0) {
                switch (wVar.getType()) {
                    case 14:
                        if (ad.getContext() == null || com.tencent.mm.plugin.y.a.a.a.biY() == null) {
                            x.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                            return;
                        }
                        x.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i), Integer.valueOf(i2));
                        m mVar = (m) wVar;
                        if (this.vjY != null) {
                            this.vjY.a(mVar);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static b RZ(String str) {
        if (str == null) {
            return null;
        }
        Map y = bj.y(str, "PersonalAppSetting");
        if (y == null) {
            return null;
        }
        String str2 = (String) y.get(".PersonalAppSetting.OpenID");
        if (bi.oN(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.vjZ = str2;
        return bVar;
    }
}
