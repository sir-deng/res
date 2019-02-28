package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.at;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private final int itU;
    public byte[] lEK;
    public int lEM;
    private boolean lEN;
    private ArrayList<sx> lEO;
    public final int mType;

    public n(int i, int i2) {
        this(i, null, i2);
    }

    public n(int i, byte[] bArr, int i2) {
        this(i, bArr, i2, false);
    }

    public n(int i, byte[] bArr, int i2, boolean z) {
        this.lEN = false;
        this.lEO = new ArrayList();
        this.lEK = null;
        a aVar = new a();
        aVar.hnT = new ach();
        aVar.hnU = new aci();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.hnS = 411;
        aVar.hnV = i.CTRL_INDEX;
        aVar.hnW = 1000000210;
        this.gLB = aVar.Kf();
        this.lEK = bArr;
        this.mType = i;
        this.itU = i2;
        this.lEN = z;
    }

    public final int getType() {
        return 411;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        ach ach = (ach) this.gLB.hnQ.hnY;
        if (this.lEK != null) {
            ach.vOw = com.tencent.mm.platformtools.n.N(this.lEK);
        } else {
            ach.vOw = new bes();
        }
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", ach.vOw == null ? "Buf is NULL" : ach.vOw.toString());
        ach.vRY = this.mType;
        ach.sfa = this.itU;
        if (this.mType == 7) {
            ach.wrL = this.lEM;
        }
        return a(eVar, this.gLB, this);
    }

    public final aci aCB() {
        return this.gLB == null ? null : (aci) this.gLB.hnR.hnY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i2 + "   errCode:" + i3);
        if (this.mType == 8) {
            if (i2 == 0 && i3 == 0) {
                as.Hm();
                c.Db().a(w.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                as.Hm();
                c.Db().a(w.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            }
        }
        if (this.mType == 11) {
            if (i2 == 0 && i3 == 0) {
                as.Hm();
                c.Db().a(w.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                as.Hm();
                c.Db().a(w.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            com.tencent.mm.plugin.emoji.model.i.aCl().lCz.a(this.mType, aCB());
        }
        if (i2 == 0 || i2 == 4) {
            aci aci = (aci) ((b) qVar).hnR.hnY;
            if (aci.vOw != null) {
                this.lEK = com.tencent.mm.platformtools.n.a(aci.vOw);
            }
            if (this.mType == 8) {
                if (i3 == 0) {
                    aCC();
                    r(this.lEO);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
                } else if (i3 == 2) {
                    aCC();
                    ((ach) ((b) qVar).hnQ.hnY).vOw = ((aci) ((b) qVar).hnR.hnY).vOw;
                    a(this.hok, this.gLE);
                } else if (i3 == 3) {
                    if (this.lEO != null) {
                        this.lEO.clear();
                    }
                    ((ach) ((b) qVar).hnQ.hnY).vOw = new bes();
                    a(this.hok, this.gLE);
                }
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public static f a(aci aci) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (aci == null) {
            return null;
        }
        f fVar = new f();
        if (aci != null) {
            fVar.lDm = aci.wrM;
            List arrayList = new ArrayList();
            if (!(aci.wrN == null || aci.wrN.isEmpty())) {
                Object[] toArray = aci.wrN.toArray();
                if (toArray != null && toArray.length > 0) {
                    for (Object obj : toArray) {
                        if (obj != null && (obj instanceof sx)) {
                            sx sxVar = (sx) obj;
                            if (!(sxVar == null || bi.oN(sxVar.vPI))) {
                                arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(sxVar));
                            }
                        }
                    }
                }
            }
            fVar.lDn = arrayList;
            fVar.lDo = aci.wrO;
            fVar.lDp = aci.wrQ;
            Collection collection = aci.wrY;
            if (fVar.lDr == null) {
                fVar.lDr = new LinkedList();
                fVar.lDr.addAll(collection);
            }
            fVar.lDq = aci.wrU;
        }
        return fVar;
    }

    protected final int Bo() {
        return 100;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    private void aCC() {
        aci aCB = aCB();
        if (aCB == null || aCB.wrN == null || aCB.wrN.size() <= 0) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
        } else {
            this.lEO.addAll(aCB.wrN);
        }
    }

    private void r(ArrayList<sx> arrayList) {
        com.tencent.mm.storage.emotion.a aVar = com.tencent.mm.plugin.emoji.model.i.aCl().lCx;
        if (aVar == null) {
            x.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
            return;
        }
        long j;
        h hVar;
        sx sxVar;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (aVar.gLA instanceof h) {
            h hVar2 = (h) aVar.gLA;
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround preparedDownloadCustomEmojiList in a transaction, ticket = %d", Long.valueOf(hVar2.dA(Thread.currentThread().getId())));
            j = r4;
            hVar = hVar2;
        } else {
            j = -1;
            hVar = null;
        }
        Iterator it;
        EmojiGroupInfo emojiGroupInfo;
        if (arrayList == null || arrayList.size() <= 0) {
            it = aVar.ckT().iterator();
            while (it.hasNext()) {
                emojiGroupInfo = (EmojiGroupInfo) it.next();
                if (emojiGroupInfo.field_sync > 0) {
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", emojiGroupInfo.field_productID);
                    aVar.Yx(emojiGroupInfo.field_productID);
                }
            }
            aVar.Yx("com.tencent.xin.emoticon.tusiji");
        } else if (arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
        } else {
            Map ckS = aVar.ckS();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", Integer.valueOf(arrayList.size()));
            for (int i = 0; i < r13; i++) {
                sxVar = (sx) arrayList.get(i);
                if (sxVar == null || bi.oN(sxVar.vPI)) {
                    x.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                } else {
                    com.tencent.mm.sdk.e.c cVar;
                    x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", sxVar.vPI);
                    arrayList2.add(sxVar.vPI);
                    if (ckS.containsKey(sxVar.vPI)) {
                        cVar = (EmojiGroupInfo) ckS.get(sxVar.vPI);
                        if (cVar == null) {
                            cVar = new EmojiGroupInfo();
                        }
                        cVar.field_productID = sxVar.vPI;
                    } else if (sxVar.vPI.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar = (EmojiGroupInfo) ckS.get(String.valueOf(EmojiGroupInfo.xIE));
                        if (cVar == null) {
                            cVar = new EmojiGroupInfo();
                        }
                        cVar.field_productID = String.valueOf(EmojiGroupInfo.xIE);
                    } else {
                        cVar = new EmojiGroupInfo();
                        cVar.field_productID = sxVar.vPI;
                    }
                    if (sxVar.vPI.equals("com.tencent.xin.emoticon.tusiji")) {
                        cVar.field_flag = 0;
                        cVar.field_packName = "emoji_custom_all";
                        cVar.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                    } else {
                        cVar.field_packName = sxVar.whv;
                        cVar.field_type = EmojiGroupInfo.xIB;
                    }
                    cVar.field_packIconUrl = sxVar.nlA;
                    cVar.field_packGrayIconUrl = sxVar.whI;
                    cVar.field_packCoverUrl = sxVar.whD;
                    cVar.field_packDesc = sxVar.whw;
                    cVar.field_packAuthInfo = sxVar.whx;
                    cVar.field_packPrice = sxVar.why;
                    cVar.field_packType = sxVar.whz;
                    cVar.field_packFlag = sxVar.whA;
                    cVar.field_packExpire = (long) sxVar.whE;
                    cVar.field_packTimeStamp = (long) sxVar.wid;
                    cVar.field_sort = 1;
                    cVar.field_idx = i;
                    if (cVar.field_sync == 0) {
                        if (cVar.field_status == 7 && cVar.field_packStatus == 1) {
                            cVar.field_sync = 2;
                        } else {
                            cVar.field_sync = 1;
                        }
                    }
                    if (cVar.field_sync == 2) {
                        cVar.field_status = 7;
                    }
                    if (cVar.field_sync == 2 && !sxVar.vPI.equals("com.tencent.xin.emoticon.tusiji")) {
                        com.tencent.mm.sdk.b.b atVar = new at();
                        atVar.fpM.type = 1;
                        atVar.fpM.fpP = sxVar.vPI;
                        com.tencent.mm.sdk.b.a.xmy.m(atVar);
                        if (!atVar.fpN.foB) {
                            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", sxVar.vPI);
                            cVar.field_sync = 1;
                        }
                    }
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", cVar.field_productID, Long.valueOf(cVar.field_lastUseTime), Integer.valueOf(cVar.field_sort));
                    aVar.a(cVar);
                }
            }
            for (EmojiGroupInfo emojiGroupInfo2 : ckS.values()) {
                if (!(emojiGroupInfo2 == null || bi.oN(emojiGroupInfo2.field_productID) || emojiGroupInfo2.field_productID.equals(String.valueOf(EmojiGroupInfo.xIF)))) {
                    if (emojiGroupInfo2.field_productID.equals(String.valueOf(EmojiGroupInfo.xIE))) {
                        if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", "com.tencent.xin.emoticon.tusiji");
                            arrayList3.add("com.tencent.xin.emoticon.tusiji");
                        }
                    } else if (!arrayList2.contains(emojiGroupInfo2.field_productID)) {
                        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", emojiGroupInfo2.field_productID);
                        arrayList3.add(emojiGroupInfo2.field_productID);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    aVar.Yx((String) it.next());
                }
            }
            aVar.b("event_update_group", 0, bi.chl().toString());
        }
        if (hVar != null) {
            hVar.fT(j);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
        aVar.b("event_update_group", 0, bi.chl().toString());
        ArrayList arrayList4;
        Iterator it2;
        if (!this.lEN) {
            ArrayList arrayList5 = (ArrayList) aVar.cld();
            if (arrayList5.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", Integer.valueOf(arrayList5.size()));
                arrayList4 = new ArrayList();
                it2 = arrayList5.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!bi.oN(str)) {
                        if (str.equals(String.valueOf(EmojiGroupInfo.xIE))) {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                        } else {
                            arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(str));
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aCi().t(arrayList4);
                if (!com.tencent.mm.plugin.emoji.model.i.aCi().lFb.lFr) {
                    com.tencent.mm.plugin.emoji.model.i.aCi().lFb.aCG();
                }
            }
        } else if (arrayList != null && arrayList.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", Integer.valueOf(arrayList.size()));
            arrayList4 = new ArrayList();
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sxVar = (sx) it2.next();
                if (!(sxVar == null || bi.oN(sxVar.vPI))) {
                    if (sxVar.vPI.equals(String.valueOf(EmojiGroupInfo.xIE))) {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.c("com.tencent.xin.emoticon.tusiji"));
                    } else {
                        arrayList4.add(new com.tencent.mm.plugin.emoji.sync.a.b(sxVar.vPI, (byte) 0));
                    }
                }
            }
            com.tencent.mm.plugin.emoji.model.i.aCi().t(arrayList4);
            if (!com.tencent.mm.plugin.emoji.model.i.aCi().lFb.lFr) {
                com.tencent.mm.plugin.emoji.model.i.aCi().lFb.aCG();
            }
        }
    }
}
