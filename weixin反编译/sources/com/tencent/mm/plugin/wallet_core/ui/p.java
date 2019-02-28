package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class p implements e {
    public boolean fpU = false;
    public b tdo;
    private a tdp;

    public interface a {
        void aYX();

        void aYY();

        void cancel();
    }

    public interface b {
        int aYZ();

        Context getContext();
    }

    public final void onResume() {
        g.Dr();
        g.Dp().gRu.a(2541, (e) this);
        g.Dr();
        g.Dp().gRu.a(2791, (e) this);
    }

    public final void onPause() {
        g.Dr();
        g.Dp().gRu.b(2541, (e) this);
        g.Dr();
        g.Dp().gRu.b(2791, (e) this);
    }

    public final void aYX() {
        k oVar = new o();
        g.Dr();
        g.Dp().gRu.a(oVar, 0);
        this.tdp.aYX();
    }

    public final void cancel() {
        this.tdp.cancel();
    }

    public final void a(a aVar, boolean z) {
        this.tdp = aVar;
        g.Dr();
        x.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", Boolean.valueOf(((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()), Boolean.valueOf(z));
        if (((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue()) {
            aVar.aYY();
        } else if (this.fpU) {
            x.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", Boolean.valueOf(this.fpU));
            aVar.aYY();
        } else if (z) {
            this.fpU = true;
            k fVar = new f();
            g.Dr();
            g.Dp().gRu.a(fVar, 0);
        } else {
            aVar.aYY();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                x.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(ah.aHO()), fVar.sOu, Boolean.valueOf(fVar.sOv));
                if (ah.aHO() && fVar.sOv) {
                    Intent intent = new Intent();
                    intent.putExtra("agreement_content", fVar.sOu);
                    d.b(this.tdo.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.tdo.aYZ());
                }
            }
        } else if ((kVar instanceof o) && i == 0 && i2 == 0) {
            g.Dr();
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(true));
            x.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
        }
    }
}
