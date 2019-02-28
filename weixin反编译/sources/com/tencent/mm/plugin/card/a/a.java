package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.pb;
import com.tencent.mm.f.a.pb.b;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a extends c<pb> implements e {
    private pb kOc;

    public a() {
        this.xmG = pb.class.getName().hashCode();
    }

    private boolean a(pb pbVar) {
        if (!as.Hp()) {
            x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            return false;
        } else if (!(pbVar instanceof pb)) {
            return false;
        } else {
            this.kOc = pbVar;
            Object obj = this.kOc.fHN.fHP;
            String str = this.kOc.fHN.fHQ;
            int i = this.kOc.fHN.fHR;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                auu();
                return false;
            }
            as.CN().a(651, (e) this);
            x.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
            as.CN().a(new o(obj, i, "", str, "", "", 0, 0, null), 0);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            b bVar = new b();
            x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) kVar;
                int i3 = oVar.kRz;
                String str2 = oVar.kRy;
                String str3 = oVar.kRA;
                if (i3 == 0) {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.ftC = true;
                    CardInfo cardInfo = new CardInfo();
                    f.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.fHP = "";
                    } else {
                        bVar.fHP = cardInfo.field_card_id;
                    }
                    am.avm().putValue("key_accept_card_info", cardInfo);
                } else {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    bVar.ftC = false;
                }
            } else {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.ftC = false;
            }
            as.CN().b(651, (e) this);
            this.kOc.fHO = bVar;
            auu();
        }
    }

    private void auu() {
        if (this.kOc.frD != null) {
            this.kOc.frD.run();
        }
        this.kOc = null;
    }
}
