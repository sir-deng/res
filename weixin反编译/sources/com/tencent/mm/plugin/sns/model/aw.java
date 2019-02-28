package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.protocal.c.bno;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class aw {
    private static final Pattern ioz = Pattern.compile("(\n){3,}");
    public int afu;
    public aqp fIK;
    private String gAM;
    int qWZ;
    int qXa;
    public cbj reA;
    private boolean reB;
    List<h> reo;
    String rep;
    String req;
    LinkedList<bmn> rer;
    LinkedList<Long> res;
    public bpb reu = e.SH();
    public arf rev = new arf();
    m rew = new m();
    blf rex = null;
    au rey;
    public bno rez;

    public aw(int i) {
        au auVar = new au();
        auVar.vMx = new as();
        auVar.vMz = new cs();
        auVar.vMA = new da();
        this.rey = auVar;
        this.rez = new bno();
        this.fIK = new aqp();
        this.reA = null;
        this.gAM = "";
        this.reB = false;
        this.gAM = ae.bvL();
        this.afu = i;
        this.reu.wYj.wfg = i;
        x.d("MicroMsg.UploadPackHelper", "contentType " + i);
        this.reu.wER = 0;
        this.reu.kyG = this.gAM;
        this.rev.vNF = g.s((ae.bvL() + bi.Wz() + System.currentTimeMillis()).getBytes());
        this.rev.wFl = 0;
        this.rev.wFm = 0;
        this.rev.wER = 0;
        this.rev.wFp = 0;
        this.rev.hmE = 0;
        this.rev.wFr = 0;
        this.rev.wFt = 0;
        blf blf = new blf();
        blf.vWS = 0;
        blf.pgR = 0;
        blf.wUO = 0;
        blf.vPp = ae.bvL();
        blf.wUR = new LinkedList();
        blf.wUP = 0;
        blf.wUQ = 0;
        blf.wUX = new LinkedList();
        blf.wUV = 0;
        blf.wUW = 0;
        blf.wUU = new LinkedList();
        blf.wUS = 0;
        blf.wUT = 0;
        blf.wGH = 1;
        blf.wUO = 0;
        blf.wUY = 0;
        blf.wUN = new bes().bl(new byte[0]);
        this.rex = blf;
        m mVar = this.rew;
        mVar.field_localFlag |= 16;
        this.rew.hN((int) (System.currentTimeMillis() / 1000));
        this.rew.field_type = i;
        this.rew.field_userName = this.gAM;
        this.rew.field_pravited = 0;
        this.rew.field_stringSeq = "0000099999999999999999999";
        this.rew.xB(2);
        this.rew.byX();
        if (i == 1 || i == 2) {
            this.rew.xB(4);
        }
        if (i == 7) {
            this.rew.xE(2);
        }
        this.res = new LinkedList();
        this.rev.wFs = this.res;
        Iterator it = this.res.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            bla bla = new bla();
            bla.wUL = longValue;
            this.rex.vOp.add(bla);
        }
        this.rex.wHZ = this.res.size();
    }

    private static String Ld(String str) {
        String str2;
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                x.e("MicroMsg.UploadPackHelper", "filter desc error ");
                return str2;
            }
        }
        str2 = str;
        try {
            return ioz.matcher(str2.trim().replace("\r\n", "\n")).replaceAll("\n\n");
        } catch (Exception e2) {
        }
    }

    public final aw Le(String str) {
        this.rep = Ld(str);
        this.reu.wYg = this.rep;
        return this;
    }

    public final aw ek(String str, String str2) {
        this.rev.token = str;
        this.rev.wFv = str2;
        return this;
    }

    public final aw xe(int i) {
        this.reu.wYl = 1;
        this.reu.wYm = i;
        return this;
    }

    public final aw Lf(String str) {
        this.reu.wYn = str;
        this.rey.vMx.vMr = str;
        return this;
    }

    public final aw Lg(String str) {
        this.reu.rRR = str;
        return this;
    }

    public final aw V(String str, String str2, String str3) {
        as asVar = this.rey.vMx;
        if (bi.oN(str)) {
            str = "";
        }
        asVar.nlV = str;
        asVar = this.rey.vMx;
        if (bi.oN(str2)) {
            str2 = "";
        }
        asVar.vMs = str2;
        asVar = this.rey.vMx;
        if (bi.oN(str3)) {
            str3 = "";
        }
        asVar.vMt = str3;
        return this;
    }

    public final aw Lh(String str) {
        this.req = str;
        this.reu.wYj.nkL = str;
        return this;
    }

    public final aw Li(String str) {
        this.reu.wYj.nlE = str;
        return this;
    }

    public final aw Lj(String str) {
        this.reu.wYj.fpg = str;
        return this;
    }

    public final void xf(int i) {
        x.d("MicroMsg.UploadPackHelper", "set post form " + i);
        this.rev.wFr = i;
    }

    public final aw a(apl apl) {
        if (apl != null) {
            this.reu.wYh = apl;
        }
        return this;
    }

    public final aw xg(int i) {
        this.qXa = i;
        this.rev.wER = i;
        this.reu.wER = i;
        if (i > 0) {
            this.rew.field_pravited = i;
            this.rew.byU();
            this.rew.xE(2);
            this.rew.byY();
        }
        return this;
    }

    public final aw xh(int i) {
        this.qWZ = i;
        this.rev.wFm = i;
        return this;
    }

    public final aw aj(LinkedList<bmn> linkedList) {
        this.rer = linkedList;
        this.rev.wFo = linkedList;
        Iterator it = this.rer.iterator();
        while (it.hasNext()) {
            bmn bmn = (bmn) it.next();
            bku bku = new bku();
            bku.vPp = bmn.kyG;
            this.rex.wUX.add(bku);
        }
        this.rex.wUV = this.rer.size();
        this.rex.wUW = this.rer.size();
        return this;
    }

    public final aw xi(int i) {
        this.rev.wFt = i;
        return this;
    }

    public final aw Lk(String str) {
        cy cyVar = this.reu.wYi;
        if (cyVar == null) {
            cyVar = new cy();
        }
        cyVar.nMq = str;
        this.reu.wYi = cyVar;
        return this;
    }

    public final aw Ll(String str) {
        cy cyVar = this.reu.wYi;
        if (cyVar == null) {
            cyVar = new cy();
        }
        cyVar.noG = str;
        this.reu.wYi = cyVar;
        return this;
    }

    public final aw Lm(String str) {
        this.reu.vtA = bi.oM(str);
        return this;
    }

    public final aw Ln(String str) {
        this.reu.vtB = bi.oM(str);
        return this;
    }

    public final aw bO(List<String> list) {
        if (list == null || list.size() == 0) {
            this.rex.wGH = 1;
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bet bet = new bet();
                bet.Vf(str);
                linkedList.add(bet);
            }
            this.rev.wFx = linkedList;
            if (this.rex.wGH == 3) {
                this.rex.wVc = linkedList;
                this.rex.wVb = linkedList.size();
            } else if (this.rex.wGH == 5) {
                this.rex.wFx = linkedList;
                this.rex.wVd = linkedList.size();
            }
        }
        return this;
    }

    public final aw xj(int i) {
        if (i == 1) {
            this.rex.wGH = 3;
        } else if (i == 0) {
            this.rex.wGH = 5;
        }
        this.rev.wFw = i;
        return this;
    }

    private static are r(String str, byte[] bArr) {
        if (bi.by(bArr)) {
            x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zo() + " attachBuf is null");
            return null;
        }
        String str2 = ae.getAccSnsTmpPath() + g.s((" " + System.currentTimeMillis()).getBytes());
        FileOp.ml(ae.getAccSnsTmpPath());
        x.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zo() + " buildUploadAttachInfo file:" + str2);
        if (FileOp.b(str2, bArr, bArr.length) >= 0) {
            return t(str, 2, str2);
        }
        x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.zo() + " writeFile error file:" + str2);
        return null;
    }

    public static are a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        are SI = e.SI();
        SI.nMq = str;
        x.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", Integer.valueOf(6), str2, str4, str5, str6);
        SI.kzz = 6;
        if (FileOp.mi(str2) <= 0) {
            return null;
        }
        arg arg;
        h hVar = new h(str2, 6);
        hVar.qXe = str4;
        hVar = ae.bvU().a(hVar, str2, str3, str5, str6);
        if (hVar.height <= 0 || hVar.width <= 0 || hVar.fileSize <= 0) {
            arg = null;
        } else {
            arg = new arg();
            arg.wFG = (float) hVar.height;
            arg.wFF = (float) hVar.width;
            arg.wFH = (float) hVar.fileSize;
        }
        SI.nMq = "Locall_path" + hVar.qXb;
        SI.wES = arg;
        SI.qXb = hVar.qXb;
        return SI;
    }

    private static are t(String str, int i, String str2) {
        arg arg = null;
        are SI = e.SI();
        SI.nMq = str;
        x.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        SI.kzz = 2;
        if (FileOp.mi(str2) <= 0) {
            return null;
        }
        String str3 = ae.getAccSnsTmpPath() + g.s((str2 + System.currentTimeMillis()).getBytes());
        FileOp.x(str2, str3);
        h hVar = new h(str3, 2);
        List linkedList = new LinkedList();
        linkedList.add(hVar);
        linkedList = ae.bvU().bT(linkedList);
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        h hVar2 = (h) linkedList.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            arg = new arg();
            arg.wFG = (float) hVar2.height;
            arg.wFF = (float) hVar2.width;
            arg.wFH = (float) hVar2.fileSize;
        }
        SI.nMq = "Locall_path" + hVar2.qXb;
        SI.wES = arg;
        SI.qXb = hVar2.qXb;
        return SI;
    }

    public static are W(String str, String str2, String str3) {
        are SI = e.SI();
        SI.nMq = str;
        x.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        SI.kzz = 2;
        SI.nlE = str2;
        SI.wEO = 0;
        SI.wEP = str3;
        SI.wEQ = 0;
        SI.wEV = 1;
        return SI;
    }

    public final boolean l(String str, String str2, String str3, String str4) {
        String str5 = ae.getAccSnsTmpPath() + g.s(str.getBytes());
        Lo(str5);
        FileOp.x(str, str5);
        String str6 = ae.getAccSnsTmpPath() + g.s(str2.getBytes());
        FileOp.x(str2, str6);
        are a = a("", 6, str5, str6, str4, "", "");
        if (a == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        a.nkL = str3;
        if (bi.oN(a.fpg)) {
            a.fpg = str3;
        }
        this.reu.wYj.wfh.add(a);
        apk apk = new apk();
        apk.wCR = a.qXb;
        this.rev.wFn.add(apk);
        return true;
    }

    public static void Lo(String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public final boolean el(String str, String str2) {
        String str3 = ae.getAccSnsTmpPath() + g.s(str.getBytes());
        Lo(str3);
        FileOp.x(str, str3);
        are t = t("", 2, str3);
        if (t == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        t.nkL = str2;
        if (bi.oN(t.fpg)) {
            t.fpg = str2;
        }
        this.reu.wYj.wfh.add(t);
        apk apk = new apk();
        apk.wCR = t.qXb;
        this.rev.wFn.add(apk);
        return true;
    }

    @Deprecated
    public final boolean b(String str, String str2, String str3, int i, String str4) {
        are W = W("", str, str2);
        if (W == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            return false;
        }
        W.nkL = str3;
        if (i > 0) {
            W.fqh = i;
        }
        if (!bi.oN(str4)) {
            W.ryq = str4;
        }
        this.reu.wYj.wfh.add(W);
        return true;
    }

    public final boolean b(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, -1, "");
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        are r = r("", bArr);
        if (r == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            return false;
        }
        r.nkL = str;
        if (i > 0) {
            r.fqh = i;
        }
        if (!bi.oN(str3)) {
            r.ryq = str3;
        }
        if (!bi.oN(str2)) {
            r.fpg = str2;
        }
        if (!bi.oN(str)) {
            r.nkL = str;
        }
        this.reu.wYj.wfh.add(r);
        apk apk = new apk();
        apk.wCR = r.qXb;
        this.rev.wFn.add(apk);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        are r = r("", bArr);
        if (r == null || (bi.oN(str2) && bi.oN(str3))) {
            x.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            return false;
        }
        if (!bi.oN(str)) {
            this.reu.wYj.nlE = str;
        }
        if (!bi.oN(str3)) {
            r.nlE = str3;
            r.wEO = 0;
        } else if (!bi.oN(str2)) {
            r.nlE = str2;
            r.wEO = 0;
        }
        if (!bi.oN(str2)) {
            r.wET = str2;
            r.wEU = 0;
        }
        r.kzz = i;
        r.fpg = bi.aD(str4, "");
        r.nkL = bi.aD(str5, "");
        this.reu.wYj.wfh.add(r);
        apk apk = new apk();
        apk.wCR = r.qXb;
        this.rev.wFn.add(apk);
        return true;
    }

    public final void bP(List<h> list) {
        this.reo = list;
        List<h> bT = ae.bvU().bT(this.reo);
        LinkedList linkedList = new LinkedList();
        if (bT != null) {
            for (h hVar : bT) {
                apk apk = new apk();
                apk.wCR = hVar.qXb;
                linkedList.add(apk);
            }
            this.rev.wFn = linkedList;
            for (h hVar2 : bT) {
                arg arg = new arg();
                arg.wFG = 0.0f;
                arg.wFF = 0.0f;
                arg.wFH = 0.0f;
                if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                    arg.wFG = (float) hVar2.height;
                    arg.wFF = (float) hVar2.width;
                    arg.wFH = (float) hVar2.fileSize;
                }
                this.reu.wYj.wfh.add(e.a("Locall_path" + hVar2.qXb, hVar2.type, "", "", 0, 0, this.qXa, "", arg));
            }
        }
    }

    public final void e(String str, String str2, String str3, int i, int i2) {
        blp blp = new blp();
        blp.vOP = str;
        blp.vOQ = str2;
        blp.vOR = str3;
        blp.rCW = i;
        blp.rCX = i2;
        this.rev.wFy = blp;
    }

    public final void qA(String str) {
        this.rev.frp = str;
    }

    public final int commit() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.rev.wFq = System.currentTimeMillis();
            this.rev.hmE = 0;
            this.rew.aL(this.rex.toByteArray());
            this.rew.field_postBuf = this.rev.toByteArray();
            x.d("MicroMsg.UploadPackHelper", "snsObj " + this.rex.toString());
            x.d("MicroMsg.UploadPackHelper", "postinfo " + this.rev.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        x.d("MicroMsg.UploadPackHelper", "timelineObj " + this.reu.toString());
        if (this.reu.wYj.wfh != null) {
            x.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", Integer.valueOf(this.reu.wYj.wfh.size()));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.reu.wYj.wfh.size()) {
                    break;
                }
                if (((are) this.reu.wYj.wfh.get(i2)) != null) {
                    x.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", Integer.valueOf(((are) this.reu.wYj.wfh.get(i2)).qXb), bi.aD(((are) this.reu.wYj.wfh.get(i2)).nlE, ""));
                }
                i = i2 + 1;
            }
        }
        if (this.rey != null) {
            this.reu.rey = this.rey;
        }
        if (this.reA != null) {
            this.reu.reA = this.reA;
        }
        this.rew.c(this.reu);
        int y = ae.bwf().y(this.rew);
        Iterator it = this.rev.wFn.iterator();
        int i3 = 0;
        String str = null;
        while (it.hasNext()) {
            apk apk = (apk) it.next();
            q eT = ae.bvU().eT((long) apk.wCR);
            try {
                arh arh = (arh) new arh().aH(eT.rvw);
                if (this.reu.wYi != null) {
                    arh.fGh = this.reu.wYi.nMq;
                }
                if (this.fIK != null) {
                    this.fIK.wEb = 0;
                }
                arh.wFP = this.fIK;
                arh.afu = this.reu.wYj.wfg;
                if (arh.afu == 1 || arh.afu == 15) {
                    int i4;
                    arh arh2;
                    if (!bi.oN(arh.fGh)) {
                        i4 = 5;
                        arh2 = arh;
                    } else if (arh.wFP != null && arh.afu == 15) {
                        if (arh.wFP.wEa) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        arh.wFQ = i4;
                    } else if (((h) this.reo.get(i3)).qXf) {
                        i4 = 1;
                        arh2 = arh;
                    } else {
                        i4 = 2;
                        arh2 = arh;
                    }
                    arh2.wFQ = i4;
                }
                eT.rvw = arh.toByteArray();
                ae.bvU().a(apk.wCR, eT);
                i3++;
                str = arh.frM;
            } catch (Exception e2) {
                x.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        x.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", Integer.valueOf(y), Integer.valueOf(this.rew.field_type), str);
        if (y > 0 && this.rew.field_type == 15) {
            ap.ej(u.af("sns_table_", (long) y), str);
        }
        x.d("MicroMsg.UploadPackHelper", "pack commit result " + y + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return y;
    }
}
