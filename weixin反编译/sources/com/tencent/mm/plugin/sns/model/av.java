package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bzk;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class av implements e, l {
    public static int qYx = 0;
    private String gAM = "";
    public Set<a> gDT = new HashSet();
    private r rdW = null;
    public com.tencent.mm.plugin.sns.model.ab.a rdX = new com.tencent.mm.plugin.sns.model.ab.a() {
        public final void io(boolean z) {
            if (!z) {
                av.this.buT();
            }
        }
    };

    public enum b {
        ;

        static {
            rek = 1;
            rel = 2;
            rem = 3;
            ren = new int[]{rek, rel, rem};
        }
    }

    public interface a {
        void M(int i, boolean z);

        void bwO();
    }

    static /* synthetic */ void a(av avVar) {
        if (ae.bvP() != null && !ae.bvO()) {
            g.Dr();
            if (g.Dq().isSDCardAvailable()) {
                ae.bvP().post(new Runnable() {
                    public final void run() {
                        m mVar = null;
                        if (ae.bvO()) {
                            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                            return;
                        }
                        av.this.bwM();
                        if (ae.bvO()) {
                            x.e("MicroMsg.UploadManager", "is invalid after checkTLE");
                            return;
                        }
                        n bwf = ae.bwf();
                        m mVar2 = new m();
                        String str = "select *,rowid from SnsInfo  where " + n.rvh + " order by SnsInfo.rowid" + " asc ";
                        Cursor a = bwf.gLA.a(str, null, 2);
                        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
                        if (a.moveToFirst()) {
                            mVar2.b(a);
                            a.close();
                            mVar = mVar2;
                        } else {
                            a.close();
                        }
                        if (mVar == null) {
                            x.d("MicroMsg.UploadManager", "All has post");
                        } else if (ae.bwe().wS(mVar.ruM)) {
                            x.d("MicroMsg.UploadManager", "checking isPosting " + mVar.ruM);
                        } else {
                            x.d("MicroMsg.UploadManager", "checking startPost " + mVar.bza());
                            av.this.t(mVar);
                        }
                    }
                });
            }
        }
    }

    public final String bvL() {
        if (this.gAM == null || this.gAM.equals("")) {
            g.Dr();
            this.gAM = (String) g.Dq().Db().get(2, null);
        }
        return this.gAM;
    }

    private void a(m mVar, int i, int i2, String str) {
        int i3;
        com.tencent.mm.sdk.b.b qeVar;
        x.i("MicroMsg.UploadManager", "localId " + mVar.bza() + "processError " + i2 + " errMsg: " + str);
        com.tencent.mm.plugin.report.service.g.pWK.a(22, 129, 1, true);
        if (i != 0) {
            try {
                i3 = ((arh) new arh().aH(ae.bvU().eT((long) i).rvw)).wFu;
                try {
                    arf byS = mVar.byS();
                    if (byS != null) {
                        byS.wFu = i3;
                        mVar.field_postBuf = byS.toByteArray();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                    x.d("MicroMsg.UploadManager", "post error " + i3);
                    mVar.bze();
                    ae.bwf().b(mVar.ruM, mVar);
                    x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.ruM);
                    qeVar = new qe();
                    qeVar.fIF.fIG = (long) mVar.ruM;
                    com.tencent.mm.sdk.b.a.xmy.m(qeVar);
                    switch (i2) {
                        case 1:
                            x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                            break;
                        case 2:
                            x.e("MicroMsg.UploadManager", "parser protobuf error");
                            break;
                        case 3:
                            x.e("MicroMsg.UploadManager", "local id is not in db");
                            break;
                        case 4:
                            x.e("MicroMsg.UploadManager", "arg is error");
                            break;
                        case 5:
                            x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                            break;
                        case 6:
                            x.e("MicroMsg.UploadManager", "errtle  error");
                            break;
                    }
                    L(mVar.ruM, false);
                }
            } catch (Exception e2) {
                i3 = 0;
                x.e("MicroMsg.UploadManager", "parse uploadInfo error");
                x.d("MicroMsg.UploadManager", "post error " + i3);
                mVar.bze();
                ae.bwf().b(mVar.ruM, mVar);
                x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.ruM);
                qeVar = new qe();
                qeVar.fIF.fIG = (long) mVar.ruM;
                com.tencent.mm.sdk.b.a.xmy.m(qeVar);
                switch (i2) {
                    case 1:
                        x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                        break;
                    case 2:
                        x.e("MicroMsg.UploadManager", "parser protobuf error");
                        break;
                    case 3:
                        x.e("MicroMsg.UploadManager", "local id is not in db");
                        break;
                    case 4:
                        x.e("MicroMsg.UploadManager", "arg is error");
                        break;
                    case 5:
                        x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                        break;
                    case 6:
                        x.e("MicroMsg.UploadManager", "errtle  error");
                        break;
                }
                L(mVar.ruM, false);
            }
        }
        arf byS2 = mVar.byS();
        i3 = byS2 != null ? byS2.wFu : 0;
        x.d("MicroMsg.UploadManager", "post error " + i3);
        mVar.bze();
        ae.bwf().b(mVar.ruM, mVar);
        x.d("MicroMsg.UploadManager", "processError, publish SnsPostFailEvent, snsInfoLocalId:" + mVar.ruM);
        qeVar = new qe();
        qeVar.fIF.fIG = (long) mVar.ruM;
        com.tencent.mm.sdk.b.a.xmy.m(qeVar);
        switch (i2) {
            case 1:
                x.e("MicroMsg.UploadManager", "upload find timeLine is null delete this item");
                break;
            case 2:
                x.e("MicroMsg.UploadManager", "parser protobuf error");
                break;
            case 3:
                x.e("MicroMsg.UploadManager", "local id is not in db");
                break;
            case 4:
                x.e("MicroMsg.UploadManager", "arg is error");
                break;
            case 5:
                x.e("MicroMsg.UploadManager", "pullTimeLineXml  error");
                break;
            case 6:
                x.e("MicroMsg.UploadManager", "errtle  error");
                break;
        }
        L(mVar.ruM, false);
    }

    private void c(m mVar, int i, String str) {
        a(mVar, 0, i, str);
    }

    private static int xc(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    public final boolean ed(String str, String str2) {
        x.d("MicroMsg.UploadManager", "imgPath " + str + " text " + str2);
        String str3 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.s(str.getBytes());
        FileOp.x(str, str3);
        aw awVar = new aw(1);
        awVar.Le(str2);
        awVar.xi(6);
        List linkedList = new LinkedList();
        linkedList.add(new h(str3, 2));
        awVar.bP(linkedList);
        if (awVar.commit() > 0) {
            return true;
        }
        return false;
    }

    public static aw a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        int i;
        x.d("MicroMsg.UploadManager", "appmsg.description " + wXMediaMessage.description);
        x.d("MicroMsg.UploadManager", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        aw awVar = new aw(i);
        awVar.Lk(bi.aD(str2, "")).Ll(bi.aD(str3, ""));
        awVar.xi(5);
        x.d("MicroMsg.UploadManager", "TimeLineType " + i);
        if (i == -1) {
            x.d("MicroMsg.UploadManager", "timeLineType is invalid");
            return null;
        }
        if (!bi.oN(str)) {
            awVar.Le(str);
        }
        awVar.Lj(bi.aD(wXMediaMessage.title, "")).Lh(bi.aD(wXMediaMessage.description, ""));
        int xc;
        switch (iMediaObject.type()) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) iMediaObject;
                awVar.Lh("");
                awVar.Le(wXTextObject.text);
                return awVar;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                if (bi.by(wXImageObject.imageData)) {
                    if (bi.oN(wXImageObject.imagePath)) {
                        x.e("MicroMsg.UploadManager", "share img but no res is exist!");
                        return null;
                    } else if (awVar.el(wXImageObject.imagePath, "")) {
                        return awVar;
                    } else {
                        return null;
                    }
                } else if (awVar.b(wXImageObject.imageData, "", "")) {
                    return awVar;
                } else {
                    return null;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                String aD = bi.aD(!bi.oN(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                String aD2 = bi.aD(!bi.oN(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                awVar.Lj("").Lh("");
                xc = xc(3);
                if (xc == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, aD, bi.aD(!bi.oN(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, ""), aD2, xc, bi.aD(wXMediaMessage.title, ""), bi.aD(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                awVar.Lj("").Lh("");
                xc = xc(4);
                if (xc == -1) {
                    x.d("MicroMsg.UploadManager", "mediaType is invalid");
                    return null;
                }
                if (awVar.a(wXMediaMessage.thumbData, bi.aD(!bi.oN(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""), wXVideoObject.videoLowBandUrl, wXVideoObject.videoUrl, xc, bi.aD(wXMediaMessage.title, ""), bi.aD(wXMediaMessage.description, ""))) {
                    return awVar;
                }
                return null;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
                if (!bi.by(wXMediaMessage.thumbData)) {
                    awVar.b(wXMediaMessage.thumbData, bi.aD(wXMediaMessage.description, ""), bi.aD(wXMediaMessage.title, ""));
                }
                awVar.Lh(wXWebpageObject.webpageUrl).Li(wXWebpageObject.webpageUrl);
                awVar.reu.wYj.nlE = wXWebpageObject.webpageUrl;
                awVar.Lg(wXWebpageObject.canvasPageXml);
                return awVar;
            case 6:
                x.e("MicroMsg.UploadManager", "file is not support!");
                return null;
            case 7:
                WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
                if (bi.oN(wXAppExtendObject.filePath) || !wXAppExtendObject.filePath.startsWith("http")) {
                    x.e("MicroMsg.UploadManager", "appdata is not support!");
                    return null;
                }
                awVar.Lj(wXAppExtendObject.filePath);
                awVar.Lh(wXAppExtendObject.filePath);
                return awVar;
            default:
                x.e("MicroMsg.UploadManager", "none type not support!");
                return null;
        }
    }

    public final boolean a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i) {
        aw a = a(wXMediaMessage, str, str2, str3);
        if (a == null) {
            return false;
        }
        a.Lf(wXMediaMessage.mediaTagName);
        a.V(str2, wXMediaMessage.messageExt, wXMediaMessage.messageAction);
        if (i > com.tencent.mm.plugin.sns.c.a.qWI) {
            a.xe(1);
        }
        x.d("MicroMsg.UploadManager", "shareAppMsg set and the result: " + a.commit());
        return true;
    }

    private boolean q(m mVar) {
        if (mVar == null) {
            return false;
        }
        bpb byF = mVar.byF();
        if (byF.wYj.wfg == 8) {
            return true;
        }
        if (byF.wYj.wfg == 2) {
            return true;
        }
        if (byF.wYj.wfg == 26) {
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 30;
            fwVar.fwl.fws = 5;
            fwVar.fwl.desc = byF.wYj.wfj;
            fwVar.fwl.fwr = String.valueOf(mVar.ruM);
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            if (fwVar.fwm.ret != 1) {
                return false;
            }
        }
        if (byF == null || byF.wYj.wfh == null) {
            c(mVar, 1, "timeline or timelineObjList is null");
            return false;
        } else if (byF.wYj.wfh.size() == 0) {
            return true;
        } else {
            try {
                boolean z;
                boolean z2;
                arf arf = (arf) new arf().aH(mVar.field_postBuf);
                if (byF.wYj.wfg != 1) {
                    z = true;
                } else if (arf.wFn.size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (byF.wYj.wfg == 21) {
                    z2 = false;
                } else {
                    z2 = z;
                }
                if (byF.wYj.wfg == 15) {
                    Iterator it = arf.wFn.iterator();
                    while (it.hasNext()) {
                        apk apk = (apk) it.next();
                        int xd = xd(apk.wCR);
                        if (xd == b.rek) {
                            a(mVar, apk.wCR, 2, "upload has set it fail");
                            return false;
                        } else if (xd == b.rem) {
                            return false;
                        }
                    }
                    return true;
                }
                Iterator it2 = arf.wFn.iterator();
                while (it2.hasNext()) {
                    apk apk2 = (apk) it2.next();
                    int a = a(apk2.wCR, z2, arf, byF.wYj.wfg);
                    if (a == b.rek) {
                        a(mVar, apk2.wCR, 2, "upload has set it fail");
                        return false;
                    } else if (a == b.rem) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.bza());
                c(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                return false;
            }
        }
    }

    public final void r(m mVar) {
        if (mVar != null) {
            arf arf;
            x.i("MicroMsg.UploadManager", "cancel snsinfo " + mVar.bza());
            try {
                arf = (arf) new arf().aH(mVar.field_postBuf);
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "error to parser postinfo in canPost " + mVar.bza());
                c(mVar, 2, "mediaPostInfo parser error " + e.getMessage());
                arf = null;
            }
            if (!(arf == null || arf.wFn == null)) {
                Iterator it = arf.wFn.iterator();
                while (it.hasNext()) {
                    apk apk = (apk) it.next();
                    int wY = ae.bwe().wY(apk.wCR);
                    ae.bwe().wX(apk.wCR);
                    x.i("MicroMsg.UploadManager", "cancel upload %d", Integer.valueOf(wY));
                    if (mVar.field_type != 15 && wY >= 0) {
                        g.Dr();
                        g.Dp().gRu.cancel(wY);
                        ae.bwe().wW(apk.wCR);
                    }
                }
            }
            if (ae.bwe().wS(mVar.ruM) && this.rdW != null) {
                x.i("MicroMsg.UploadManager", "cancel post");
                this.rdW.lhA = true;
                g.Dr();
                g.Dp().gRu.c(this.rdW);
                ae.bwe().wU(mVar.ruM);
            }
            m xG = ae.bwf().xG(mVar.ruM);
            if (!(xG == null || xG.field_snsId == 0)) {
                ae.bwe().eE(xG.field_snsId);
                g.Dr();
                g.Dp().gRu.a(new q(xG.field_snsId, 1), 0);
            }
            ae.bwf().xH(mVar.ruM);
            if (mVar.field_type == 21) {
                com.tencent.mm.plugin.sns.lucky.a.g.buY().bva();
            }
            x.d("MicroMsg.UploadManager", "cancelPost, publish SnsPostFailEvent, snsInfoLocalId " + mVar.bza());
            com.tencent.mm.sdk.b.b qeVar = new qe();
            qeVar.fIF.fIG = (long) mVar.ruM;
            com.tencent.mm.sdk.b.a.xmy.m(qeVar);
        }
    }

    public final void buT() {
        ae.aOA().postDelayed(new Runnable() {
            public final void run() {
                av.a(av.this);
            }
        }, 1000);
    }

    private boolean bwM() {
        n bwf = ae.bwf();
        String str = "select *,rowid from SnsInfo  where " + n.rvh + " order by SnsInfo.rowid" + " asc ";
        Cursor rawQuery = bwf.gLA.rawQuery(str, null);
        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            rawQuery = null;
        } else {
            rawQuery.moveToFirst();
        }
        m mVar = new m();
        if (rawQuery == null) {
            return false;
        }
        rawQuery.moveToFirst();
        do {
            mVar.b(rawQuery);
            try {
                arf arf = (arf) new arf().aH(mVar.field_postBuf);
                int i = arf.hmE;
                if (m.eR(arf.wFq)) {
                    a(arf);
                    c(mVar, 6, "snsinfo is tle");
                    x.i("MicroMsg.UploadManager", "checkTLE snsinfo localId it time limit " + mVar.bza() + " is die ");
                }
            } catch (Exception e) {
                x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
                c(mVar, 2, "MediaPostInfo parser error");
            }
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return true;
    }

    private static bpb s(m mVar) {
        bpb byF = mVar.byF();
        apl apl = byF.wYh;
        String str = byF.wYg;
        String str2 = byF.vtA;
        String str3 = byF.vtB;
        String str4 = byF.wYj.nkL;
        String str5 = byF.wYj.fpg;
        String str6 = byF.wYj.nlE;
        String str7 = byF.wYj.wfj;
        cy cyVar = byF.wYi;
        bzk bzk = byF.wYp;
        int i = byF.wYj.wfg;
        int i2 = byF.wYj.wfi;
        bpb SH = com.tencent.mm.modelsns.e.SH();
        SH.kyG = mVar.field_userName;
        SH.wER = mVar.field_pravited;
        SH.wYg = str;
        SH.vtA = bi.oM(str2);
        SH.vtB = bi.oM(str3);
        SH.wYl = byF.wYl;
        SH.wYm = byF.wYm;
        SH.hcR = byF.hcR;
        SH.wYn = byF.wYn;
        SH.rRR = byF.rRR;
        SH.wYj.nkL = str4;
        SH.wYj.fpg = str5;
        SH.wYj.wfg = i;
        SH.wYj.wfi = i2;
        SH.wYj.nlE = str6;
        SH.wYj.wfj = str7;
        SH.wYh = apl;
        SH.wYo = byF.wYo;
        SH.rzD = byF.rzD;
        if (byF.rey != null) {
            SH.rey = byF.rey;
        }
        if (cyVar != null) {
            SH.wYi = cyVar;
        }
        if (bzk != null) {
            SH.wYp = bzk;
        }
        Iterator it = byF.wYj.wfh.iterator();
        while (it.hasNext()) {
            are are = (are) it.next();
            if (are.wEV == 1) {
                SH.wYj.wfh.add(are);
            }
        }
        if (byF.reA != null) {
            SH.reA = byF.reA;
        }
        return SH;
    }

    private boolean t(m mVar) {
        try {
            arf arf = (arf) new arf().aH(mVar.field_postBuf);
            arf.hmE++;
            mVar.field_postBuf = arf.toByteArray();
            ae.bwf().b(mVar.ruM, mVar);
            int i = arf.hmE;
            if (m.eR(arf.wFq)) {
                c(mVar, 6, "this item isTimeLimit");
                x.i("MicroMsg.UploadManager", "snsinfo localId it time limit " + mVar.bza() + " is die ");
                return false;
            }
            x.i("MicroMsg.UploadManager", "try start post " + mVar.bza());
            if (q(mVar)) {
                String str;
                bpb byF = mVar.byF();
                bpb s = s(mVar);
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arf.wFn.size()) {
                        break;
                    }
                    i = ((apk) arf.wFn.get(i2)).wCR;
                    q eT = ae.bvU().eT((long) i);
                    if (eT == null) {
                        c(mVar, 3, "can not get the media from db ,localMediaId: " + i);
                        return false;
                    }
                    try {
                        arh arh = (arh) new arh().aH(eT.rvw);
                        if (arh.wFI == null || arh.wFK.size() <= 0) {
                            x.e("MicroMsg.UploadManager", "item with not url" + mVar.field_type);
                        } else {
                            are a;
                            are are;
                            str = arh.wFI.nlE;
                            String str2 = ((arb) arh.wFK.get(0)).nlE;
                            int i3 = arh.wFI.kzz;
                            int i4 = ((arb) arh.wFK.get(0)).kzz;
                            String str3 = arh.frM;
                            arg arg = null;
                            if (i2 < byF.wYj.wfh.size()) {
                                arg = ((are) byF.wYj.wfh.get(i2)).wES;
                            }
                            if (byF.wYj.wfg != 4 && byF.wYj.wfg != 5) {
                                a = com.tencent.mm.modelsns.e.a(eT.rvv, eT.type, str, str2, i3, i4, arh.wER, "", arg);
                            } else if (i2 < byF.wYj.wfh.size()) {
                                are = (are) byF.wYj.wfh.get(i2);
                                are.wEP = str2;
                                are.wEQ = i4;
                                a = are;
                            } else {
                                a = null;
                            }
                            if (a != null && s.wYj.wfg == 1) {
                                a.frM = str3;
                            }
                            if (a != null && s.wYj.wfg == 15) {
                                a.frM = arh.frM;
                                a.wFk = arh.wFk;
                            }
                            if (i2 < byF.wYj.wfh.size()) {
                                are = (are) byF.wYj.wfh.get(i2);
                                a.fpg = are.fpg;
                                a.nkL = are.nkL;
                                a.fqh = are.fqh;
                                a.ryq = are.ryq;
                            }
                            if (a == null) {
                                c(mVar, 3, "make media error");
                                return false;
                            }
                            s.wYj.wfh.add(a);
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.UploadManager", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        c(mVar, 2, "mediaUploadInfo parser error " + e.getMessage());
                        return false;
                    }
                }
                x.e("MicroMsg.UploadManager", "item with not url" + mVar.field_type);
                if (mVar.field_type != 3) {
                    c(mVar, 4, "buf url is null");
                    return false;
                }
                if (ae.bwe().wT(mVar.ruM)) {
                    final List linkedList = new LinkedList();
                    Iterator it = arf.wFo.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((bmn) it.next()).kyG);
                    }
                    str = j.b(s);
                    x.d("MicroMsg.UploadManager", "timeLine contentDescScene ：  " + s.wYm + " contentDescShowType: " + s.wYl);
                    if (mVar.field_pravited == 1) {
                        x.i("MicroMsg.UploadManager", "content private xml is null ? " + bi.oN(str));
                    } else {
                        x.i("MicroMsg.UploadManager", "upload xmlsns: %s", str);
                    }
                    if (str == null || str.equals("")) {
                        c(mVar, 5, "content is error");
                        ae.bwe().wU(mVar.ruM);
                        return false;
                    }
                    boolean z;
                    if (arf.wFw == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    final int i5 = mVar.ruM;
                    final LinkedList linkedList2 = arf.wFx;
                    final com.tencent.mm.bp.b bVar = s.wYh.wCW;
                    final String str4 = s.wYj.fpg;
                    final arf arf2 = arf;
                    final bpb bpb = byF;
                    ae.aOA().post(new Runnable() {
                        public final void run() {
                            if (ae.bvO()) {
                                x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                return;
                            }
                            av.this.rdW = new r(str, arf2.wER, arf2.wFm, linkedList, bpb, i5, arf2.vNF, arf2.wFr, arf2.wFs, arf2.wFt, arf2, z, linkedList2, arf2.wFy, bVar, str4);
                            g.Dr();
                            g.Dp().gRu.a(av.this.rdW, 0);
                        }
                    });
                } else {
                    x.d("MicroMsg.UploadManager", "this snsinfo is posting");
                    return false;
                }
            }
            x.d("MicroMsg.UploadManager", "startPost, canPost is false, snsInfoId: " + mVar.bza());
            return true;
        } catch (Exception e2) {
            x.e("MicroMsg.UploadManager", "startPost parseFrom MediaPostInfo Exception");
            c(mVar, 2, "MediaPostInfo parser error:" + e2.getMessage());
            return false;
        }
    }

    private void L(final int i, final boolean z) {
        ae.aOA().post(new Runnable() {
            public final void run() {
                if (ae.bvO()) {
                    x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                    return;
                }
                for (a aVar : av.this.gDT) {
                    if (aVar != null) {
                        aVar.M(i, z);
                    }
                }
            }
        });
    }

    private int a(int i, boolean z, arf arf, int i2) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media");
            return b.rek;
        }
        q eT = ae.bvU().eT((long) i);
        try {
            arh arh = (arh) new arh().aH(eT.rvw);
            x.i("MicroMsg.UploadManager", "state " + arh.wFL + " pic isMuti: " + z);
            if (arh.wFL == 1) {
                return b.rek;
            }
            String str = am.r(ae.getAccSnsPath(), eT.rvs) + i.Km(eT.rvs);
            if (FileOp.mi(str) == 0) {
                x.i("MicroMsg.UploadManager", "path not exist  " + str);
                return b.rek;
            } else if (arh.wFL == 0) {
                return b.rel;
            } else {
                if (ae.bwe().wV(i)) {
                    ae.bvU().a(i, eT);
                    final String s = com.tencent.mm.a.g.s((bi.Wz() + " " + System.currentTimeMillis()).getBytes());
                    final int i3 = i;
                    final boolean z2 = z;
                    final arf arf2 = arf;
                    final int i4 = i2;
                    ae.aOA().post(new Runnable() {
                        public final void run() {
                            if (ae.bvO()) {
                                x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
                                return;
                            }
                            k yVar = new y(i3, s, z2, i4);
                            ae.bwe().dy(i3, yVar.hashCode());
                            g.Dr();
                            g.Dp().gRu.a(yVar, 0);
                        }
                    });
                }
                return b.rem;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error");
            return b.rek;
        }
    }

    private static void a(arf arf) {
        if (arf != null) {
            Iterator it = arf.wFn.iterator();
            while (it.hasNext()) {
                ae.bwe().wW(((apk) it.next()).wCR);
            }
        }
    }

    private int xd(int i) {
        if (i == -1) {
            x.e("MicroMsg.UploadManager", "uploading depend localMediaId can not get the media doUploadSight");
            return b.rek;
        }
        q eT = ae.bvU().eT((long) i);
        try {
            arh arh = (arh) new arh().aH(eT.rvw);
            x.i("MicroMsg.UploadManager", "state " + arh.wFL + " doUploadSight, serverErr:" + arh.wFu);
            if (arh.wFL == 1) {
                return b.rek;
            }
            if (FileOp.mi(arh.videoPath) == 0) {
                x.i("MicroMsg.UploadManager", "path not fileexist  " + arh.videoPath);
                return b.rek;
            } else if (FileOp.mi(arh.wFN) == 0) {
                x.i("MicroMsg.UploadManager", "thumbpath not fileexist  " + arh.wFN);
                return b.rek;
            } else if (arh.wFL == 0) {
                return b.rel;
            } else {
                if (ae.bwe().wV(i)) {
                    ae.bvU().a(i, eT);
                    new ab(i, eT, arh.videoPath, arh.wFN, this.rdX).bvF();
                }
                return b.rem;
            }
        } catch (Exception e) {
            x.e("MicroMsg.UploadManager", "parse uploadInfo error doUploadSight");
            return b.rek;
        }
    }

    public final void bwN() {
        for (a aVar : this.gDT) {
            if (aVar != null) {
                aVar.bwO();
            }
        }
    }

    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ad.k r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = "MicroMsg.UploadManager";
        r1 = new java.lang.StringBuilder;
        r2 = "onSceneEnd: errType = ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " errCode = ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " errMsg = ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " type = ";
        r1 = r1.append(r2);
        r2 = r12.getType();
        r1 = r1.append(r2);
        r2 = " @";
        r1 = r1.append(r2);
        r2 = r8.hashCode();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r12.getType();
        switch(r0) {
            case 207: goto L_0x0056;
            case 208: goto L_0x0051;
            case 209: goto L_0x005e;
            default: goto L_0x0051;
        };
    L_0x0051:
        if (r9 != 0) goto L_0x0055;
    L_0x0053:
        if (r10 == 0) goto L_0x0055;
    L_0x0055:
        return;
    L_0x0056:
        if (r9 != 0) goto L_0x005a;
    L_0x0058:
        if (r10 == 0) goto L_0x0051;
    L_0x005a:
        r8.buT();
        goto L_0x0051;
    L_0x005e:
        r12 = (com.tencent.mm.plugin.sns.model.r) r12;
        r0 = r12.qXb;
        r1 = r12.lhA;
        if (r1 == 0) goto L_0x00bc;
    L_0x0066:
        r2 = r12.raf;
        r1 = "MicroMsg.UploadManager";
        r4 = new java.lang.StringBuilder;
        r5 = "get the del post come back %d ";
        r4.<init>(r5);
        r4 = r4.append(r2);
        r4 = r4.toString();
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x00a8;
    L_0x008e:
        r1 = com.tencent.mm.plugin.sns.model.ae.bwe();
        r1.eE(r2);
        com.tencent.mm.kernel.g.Dr();
        r1 = com.tencent.mm.kernel.g.Dp();
        r1 = r1.gRu;
        r4 = new com.tencent.mm.plugin.sns.model.q;
        r5 = 1;
        r4.<init>(r2, r5);
        r5 = 0;
        r1.a(r4, r5);
    L_0x00a8:
        r1 = com.tencent.mm.plugin.sns.model.ae.bwf();
        r1.xH(r0);
        r0 = 0;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 == 0) goto L_0x00bc;
    L_0x00b5:
        r0 = com.tencent.mm.plugin.sns.model.ae.bwk();
        r0.eN(r2);
    L_0x00bc:
        if (r9 != 0) goto L_0x00c0;
    L_0x00be:
        if (r10 == 0) goto L_0x00ca;
    L_0x00c0:
        r0 = r12.qXb;
        r1 = 0;
        r8.L(r0, r1);
    L_0x00c6:
        r0 = 0;
        r8.rdW = r0;
        goto L_0x0051;
    L_0x00ca:
        r0 = r12.qXb;
        r1 = 1;
        r8.L(r0, r1);
        r0 = r12.raf;
        com.tencent.mm.plugin.sns.model.aj.eI(r0);
        goto L_0x00c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.av.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
