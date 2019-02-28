package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;

public final class w extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private byte[] hHj;
    private int kRI = 0;

    public w(int i) {
        x.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", Integer.valueOf(1));
        a aVar = new a();
        aVar.hnT = new ku();
        aVar.hnU = new kv();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.hnS = 558;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aoq aoq = new aoq();
        as.Hm();
        aoq.kSQ = (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null);
        aoq.latitude = (double) am.avn().gAh;
        aoq.longitude = (double) am.avn().gAi;
        ku kuVar = (ku) this.gLB.hnQ.hnY;
        kuVar.vYD = 1;
        kuVar.vYF = aoq;
        kuVar.vYG = i;
        this.kRI = i;
    }

    public final int getType() {
        return 558;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        ku kuVar = (ku) this.gLB.hnQ.hnY;
        as.Hm();
        this.hHj = bi.Wj(bi.oM((String) c.Db().get(282880, null)));
        if (this.hHj == null || this.hHj.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        kuVar.vYE = n.N(this.hHj);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.hHj == null ? 0 : this.hHj.length);
        x.i(str, str2, objArr);
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            kv kvVar = (kv) this.gLB.hnR.hnY;
            if (kvVar.vYI == 1) {
                x.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.hHj = n.a(kvVar.vYE, new byte[0]);
            List<ot> list = kvVar.vYH == null ? null : kvVar.vYH.kyB;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.hHj == null ? 0 : this.hHj.length);
            objArr[2] = Integer.valueOf(kvVar.vWu);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.a.b avg = am.avg();
                x.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", Boolean.valueOf(true));
                synchronized (avg.gUq) {
                    avg.kOd.addAll(avg.kOe);
                    avg.kOe.clear();
                }
                avg.auv();
            } else {
                int i4 = 0;
                for (ot a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", Integer.valueOf(i4));
                am.avg().auv();
            }
            as.Hm();
            c.Db().set(282880, bi.bA(this.hHj));
            if (kvVar.vWu > 0) {
                x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(kvVar.vWu));
                if (a(this.hok, this.gLE) <= 0) {
                    x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", Integer.valueOf(a(this.hok, this.gLE)));
                    this.gLE.a(3, -1, str, this);
                    return;
                }
                return;
            }
            this.gLE.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }

    private static boolean a(ot otVar) {
        if (otVar == null) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            return false;
        }
        byte[] a = n.a(otVar.weu);
        if (a == null || a.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            return false;
        }
        x.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", Integer.valueOf(a.length), Integer.valueOf(otVar.wet));
        try {
            switch (otVar.wet) {
                case 1:
                    ky kyVar = (ky) new ky().aH(a);
                    x.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", Integer.valueOf(kyVar.kyY));
                    switch (kyVar.kyY) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            com.tencent.mm.plugin.card.a.b avg = am.avg();
                            if (kyVar != null) {
                                long j;
                                CardInfo wL = am.avh().wL(kyVar.vZy);
                                String str = "MicroMsg.BatchGetCardMgr";
                                String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = kyVar.vZy;
                                if (wL == null) {
                                    j = 0;
                                } else {
                                    j = wL.field_updateSeq;
                                }
                                objArr[1] = Long.valueOf(j);
                                objArr[2] = Long.valueOf(kyVar.vZz);
                                x.i(str, str2, objArr);
                                if (wL != null && wL.field_updateSeq == kyVar.vZz) {
                                    x.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
                                    break;
                                }
                                com.tencent.mm.sdk.e.c a2 = ak.a(kyVar);
                                synchronized (avg.gUq) {
                                    if (!avg.kOd.contains(a2)) {
                                        if (!avg.kOe.contains(a2)) {
                                            avg.kOd.add(a2);
                                            boolean b = am.avi().b(a2);
                                            x.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", Boolean.valueOf(b));
                                            break;
                                        }
                                    }
                                }
                            } else {
                                x.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
                                break;
                            }
                            break;
                        case 6:
                            break;
                        default:
                            x.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", Integer.valueOf(kyVar.vZA));
                            return false;
                    }
                    return true;
                default:
                    x.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", Integer.valueOf(otVar.wet));
                    return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
            return false;
        }
        x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
        return false;
    }
}
