package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.bb;
import java.util.HashMap;
import java.util.HashSet;

public final class aa {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> pRs;
    public HashMap<String, String> pRt;

    public aa() {
        this.pRs = null;
        this.pRt = new HashMap();
        this.pRs = new HashSet();
        this.lock = new Object();
    }

    public final boolean IV(String str) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.pRs.contains(str);
        }
        return contains;
    }

    private synchronized boolean IW(String str) {
        boolean z;
        if (this.pRs.contains(str)) {
            x.i(TAG, "it is a duplicate msg");
            z = false;
        } else {
            z = this.pRs.add(str);
        }
        return z;
    }

    public final boolean dW(String str, String str2) {
        String str3 = (String) this.pRt.get(str);
        if (!bi.oN(str3)) {
            return Q(str, str3, str2);
        }
        x.w(TAG, "empty transid: %s", str);
        return false;
    }

    public final boolean Q(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            x.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            return false;
        } else if (!IW(str)) {
            return false;
        } else {
            au auVar = new au();
            auVar.setContent(str2);
            auVar.eR(2);
            auVar.dU(str3);
            auVar.aq(bb.hU(str3));
            auVar.eS(1);
            auVar.setType(419430449);
            long Q = ((h) g.h(h.class)).aZO().Q(auVar);
            if (Q < 0) {
                x.e(TAG, com.tencent.mm.compatible.util.g.zo() + "insert msg failed :" + Q);
                this.pRs.remove(str);
                return false;
            }
            boolean b;
            auVar.ao(Q);
            if (auVar.aNJ()) {
                b.hRo.a(auVar, com.tencent.mm.x.h.g(auVar));
            } else {
                b.hRo.f(auVar);
            }
            c gVar = new com.tencent.mm.x.g();
            gVar.field_xml = auVar.field_content;
            String Wn = bi.Wn(str2);
            a aVar = null;
            if (Wn != null) {
                aVar = a.I(Wn, auVar.field_reserved);
                if (aVar != null) {
                    gVar.field_title = aVar.title;
                    gVar.field_description = aVar.description;
                }
            }
            gVar.field_type = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
            gVar.field_msgId = Q;
            com.tencent.mm.x.g fq = com.tencent.mm.plugin.y.a.biU().fq(Q);
            if (fq == null || fq.field_msgId != Q) {
                b = com.tencent.mm.plugin.y.a.biU().b(gVar);
                if (!b) {
                    x.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:" + Q);
                }
            } else {
                b = com.tencent.mm.plugin.y.a.biU().c(gVar, new String[0]);
            }
            if (aVar != null) {
                com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                cVar.field_locaMsgId = auVar.field_msgId;
                cVar.field_transferId = aVar.hdR;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.b.bnS();
                com.tencent.mm.plugin.remittance.a.b.bnU().a(cVar);
            }
            return b;
        }
    }
}
