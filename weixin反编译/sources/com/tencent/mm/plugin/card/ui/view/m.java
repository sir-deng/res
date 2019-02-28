package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends g {
    public final boolean h(b bVar) {
        if (this.kOv == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else if (this.kOv.auj().vYx != bVar.auj().vYx) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            return true;
        } else {
            oy oyVar = this.kOv.auj().vYw;
            oy oyVar2 = bVar.auj().vYw;
            if ((oyVar == null && oyVar2 != null) || (oyVar != null && oyVar2 == null)) {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                return true;
            } else if (oyVar == null || oyVar2 == null || oyVar.title == null || oyVar2.title == null || !oyVar.title.equals(oyVar2.title)) {
                oyVar = this.kOv.aui().vZq;
                oyVar2 = bVar.aui().vZq;
                if ((oyVar == null && oyVar2 != null) || (oyVar != null && oyVar2 == null)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (oyVar != null && oyVar2 != null && oyVar.title != null && oyVar2.title != null && !oyVar.title.equals(oyVar2.title)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (oyVar == null || oyVar2 == null || oyVar.kPC == null || oyVar2.kPC == null || oyVar.kPC.equals(oyVar2.kPC)) {
                    return false;
                } else {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                }
            } else {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                return true;
            }
        }
    }

    public final String e(c cVar) {
        x.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g avx = am.avx();
        b bVar = this.kOv;
        String str = "";
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
            return str;
        }
        int i;
        avx.auz();
        avx.kOC = cVar;
        String aum = bVar.aum();
        Cursor rawQuery = am.avv().gLA.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{aum});
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } else {
            i = 0;
        }
        if (i == 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
            i = 0;
        } else {
            i wM = am.avw().wM(aum);
            if (wM != null) {
                if (g.a(wM)) {
                    avx.kOC = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                    i = 0;
                } else if (i < wM.field_lower_bound && l.isNetworkAvailable(ad.getContext())) {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", Integer.valueOf(i), Integer.valueOf(wM.field_lower_bound));
                    avx.kOC = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                    i = 0;
                }
            }
            i = 1;
        }
        if (i == 0) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
            avx.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
            return "";
        }
        com.tencent.mm.sdk.e.c wO = am.avv().wO(bVar.aum());
        if (wO == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", bVar.aum());
            avx.a(bVar, q.EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL);
            return "";
        }
        k wP = am.avv().wP(aum);
        if (wP != null && am.avv().bW(aum, wP.field_code_id)) {
            avx.a(aum, wP.field_code_id, cVar);
        }
        avx.kOD = 0;
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", aum, wO.field_code_id, Integer.valueOf(cVar.action));
        aum = bVar.aum();
        if (wO == null) {
            str = "";
        } else {
            str = e.cc(aum, wO.field_code);
            i wM2 = am.avw().wM(aum);
            if (wM2 == null || com.tencent.pb.common.c.g.Bf(str) || !wM2.field_need_insert_show_timestamp || com.tencent.pb.common.c.g.Bf(wM2.field_show_timestamp_encrypt_key)) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                str = e.ce(str, wM2.field_show_timestamp_encrypt_key);
            }
        }
        if (com.tencent.pb.common.c.g.Bf(str)) {
            avx.X(1, "");
            return "";
        }
        wO.field_status = 1;
        if (am.avv().c(wO, "card_id", "code_id")) {
            x.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", wO.field_card_id, wO.field_code_id, Integer.valueOf(wO.field_status));
        } else {
            x.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", wO.field_card_id, wO.field_code_id, Integer.valueOf(wO.field_status));
        }
        g avx2 = am.avx();
        i wM3 = am.avw().wM(bVar.aum());
        if (wM3 == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            return str;
        }
        long j = (long) (wM3.field_show_expire_interval * 1000);
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: " + j);
        avx2.kOE.K(j, j);
        return str;
    }

    public final ab axI() {
        return new n(this, this.kgL);
    }

    public final ab axJ() {
        return new f(this, this.kgL);
    }

    public final ab axK() {
        return new t(this, this.kgL);
    }
}
