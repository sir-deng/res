package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.a.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public h() {
        a aVar = new a();
        aVar.hnT = new bjm();
        aVar.hnU = new bjn();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        this.gLB = aVar.Kf();
        bjm bjm = (bjm) this.gLB.hnQ.hnY;
        as.Hm();
        bjm.wTw = ((Long) c.Db().get(w.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
    }

    public final int getType() {
        return 906;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bjn bjn = (bjn) this.gLB.hnR.hnY;
            List<bjl> list = bjn.hfI == null ? null : bjn.hfI;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(bjn.wTx);
            objArr[2] = Long.valueOf(bjn.wTv);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a avo = am.avo();
                x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", Boolean.valueOf(true));
                synchronized (avo.gUq) {
                    avo.kOd.addAll(avo.kOe);
                    avo.kOe.clear();
                }
                avo.auv();
            } else {
                int i4 = 0;
                for (bjl a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", Integer.valueOf(i4));
                am.avo().auv();
            }
            as.Hm();
            c.Db().a(w.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(bjn.wTv));
            am.avo().kSG = bjn.kSG;
            if (bjn.wTx > 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(bjn.wTx));
                com.tencent.mm.plugin.card.sharecard.a.a avo2 = am.avo();
                avo2.mHandler.post(new Runnable() {
                    public final void run() {
                        as.CN().a(new h(), 0);
                    }
                });
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }

    private static boolean a(bjl bjl) {
        if (bjl == null) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            return false;
        }
        x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", bjl.fHP, Long.valueOf(bjl.wTv));
        try {
            x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", Integer.valueOf(bjl.kSO));
            switch (bjl.kSO) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    com.tencent.mm.plugin.card.sharecard.a.a avo = am.avo();
                    if (bjl != null) {
                        long j;
                        ShareCardInfo xb = am.avp().xb(bjl.fHP);
                        String str = "MicroMsg.ShareCardBatchGetCardMgr";
                        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = bjl.fHP;
                        if (xb == null) {
                            j = 0;
                        } else {
                            j = xb.field_updateSeq;
                        }
                        objArr[1] = Long.valueOf(j);
                        objArr[2] = Long.valueOf(bjl.wTv);
                        x.i(str, str2, objArr);
                        if (xb != null && xb.field_updateSeq == bjl.wTv) {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
                            break;
                        }
                        com.tencent.mm.sdk.e.c b = n.b(bjl);
                        synchronized (avo.gUq) {
                            if (!avo.kOd.contains(b)) {
                                if (!avo.kOe.contains(b)) {
                                    avo.kOd.add(b);
                                    boolean b2 = am.avq().b(b);
                                    x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", Boolean.valueOf(b2));
                                    break;
                                }
                            }
                        }
                    } else {
                        x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
                        break;
                    }
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a avo2 = am.avo();
                    if (bjl != null) {
                        com.tencent.mm.plugin.card.base.b xb2 = am.avp().xb(bjl.fHP);
                        am.avp().xa(bjl.fHP);
                        x.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + bjl.fHP);
                        if (xb2 != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(ad.getContext(), xb2);
                        } else {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        avo2.asP();
                        break;
                    }
                    x.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", Integer.valueOf(bjl.kSO));
                    return false;
            }
            if (!(bjl.kSO == 0 || bjl.kSO == 5)) {
                as.Hm();
                String str3 = (String) c.Db().get(w.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
                as.Hm();
                boolean booleanValue = ((Boolean) c.Db().get(w.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
                if (booleanValue && !TextUtils.isEmpty(str3) && str3.equals(bjl.fHP)) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    l.auV();
                } else if (booleanValue) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", e.getMessage());
            return false;
        }
    }
}
