package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ae extends i {
    private long hSg;
    public String sPc;
    public String sPd;
    public String sPe;
    public String sPf;
    public String sPg;
    public int sPh;
    public int sPi;

    public ae() {
        D(null);
    }

    public final int azx() {
        return 0;
    }

    public final int Hx() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        x.d("MicroMsg.NetSceneTransferWording", "json: %s", jSONObject);
        this.sPc = jSONObject.optString("delay_confirm_wording");
        this.sPd = jSONObject.optString("delay_confirm_switch_wording");
        this.sPe = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.sPf = jSONObject.optString("delay_confirm_desc_url");
        this.sPh = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.hSg = jSONObject.optLong("expire_time", 0) * 1000;
        this.sPi = jSONObject.optInt("delay_confirm_switch_flag", 0);
        g.Dr();
        t Db = g.Dq().Db();
        if (!bi.oN(this.sPc)) {
            Db.a(a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, this.sPc);
        }
        if (!bi.oN(this.sPd)) {
            Db.a(a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, this.sPd);
        }
        if (!bi.oN(this.sPe)) {
            Db.a(a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, this.sPe);
        }
        if (!bi.oN(this.sPf)) {
            try {
                this.sPg = URLDecoder.decode(this.sPf, "UTF-8");
                if (!bi.oN(this.sPg)) {
                    Db.a(a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, this.sPg);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        Db.a(a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(this.sPh));
        Db.a(a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(this.hSg));
        Db.a(a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, Integer.valueOf(this.sPi));
        if (this.sPi == 0) {
            x.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            com.tencent.mm.bp.a aso = new aso();
            aso.pWh = 0;
            ((h) g.h(h.class)).Fe().b(new e.a(com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX, aso));
            Db.set(147457, Long.valueOf((((Long) Db.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
    }

    public static boolean a(boolean z, com.tencent.mm.wallet_core.d.i iVar) {
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(a.USERINFO_DELAY_TRANSFER_EXPIRE_TIME_LONG, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            x.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", Long.valueOf(longValue), Boolean.valueOf(z));
            if (iVar != null) {
                iVar.a(new ae(), false, 1);
            } else {
                g.Dr();
                g.Dp().gRu.a(new ae(), 0);
            }
            return true;
        }
        x.d("MicroMsg.NetSceneTransferWording", "not time");
        return false;
    }

    public final boolean bhJ() {
        return false;
    }
}
