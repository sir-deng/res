package com.tencent.mm.plugin.collect.b;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private b gLB;
    private e gLE;
    public li los;

    public l() {
        a aVar = new a();
        aVar.hnT = new lh();
        aVar.hnU = new li();
        aVar.hnS = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1588;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.los = (li) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        x.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", this.los.url, this.los.sQD, this.los.waR);
        if (!bi.oN(this.los.url)) {
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, this.los.url);
        }
        if (!bi.oN(this.los.sQD)) {
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, this.los.sQD);
        }
        g.Dr();
        g.Dq().Db().a(w.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC, this.los.waR);
        JSONObject a = a(this.los.waQ);
        JSONArray ay = ay(this.los.waP);
        if (a != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", a.toString());
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, a.toString());
        }
        if (ay != null) {
            x.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", ay.toString());
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, ay.toString());
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    private JSONArray ay(List<arm> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = a((arm) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                return null;
            }
        }
        return jSONArray;
    }

    private static JSONObject a(arm arm) {
        int i = (arm == null || bi.oN(arm.fzT)) ? 0 : 1;
        if (i == 0) {
            x.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Columns.TYPE, arm.type);
            jSONObject.put("wording", arm.fzT);
            jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, arm.url);
            jSONObject.put("waapp_username", arm.wGb);
            jSONObject.put("waapp_path", arm.wGc);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            return null;
        }
    }
}
