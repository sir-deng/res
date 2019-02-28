package com.tencent.mm.plugin.wear.model;

import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public final class h {
    public static final Bitmap Oq(String str) {
        Bitmap cm = b.caI().cm(str);
        if (cm == null) {
            n.JF();
            x.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", d.x(str, false));
            return d.jj(d.x(str, false));
        }
        x.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", str);
        return cm;
    }

    public static String Or(String str) {
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (!s.eX(str)) {
            return r.a(Xv, str);
        }
        String string = ad.getContext().getString(R.l.dSY);
        String a = r.a(Xv, str);
        if (Xv.field_username.equals(a) || bi.oN(a)) {
            return string;
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.caf W(com.tencent.mm.storage.au r9) {
        /*
        r8 = 3;
        r7 = 2;
        r6 = -1;
        r3 = 0;
        r2 = 1;
        r4 = new com.tencent.mm.protocal.c.caf;
        r4.<init>();
        r0 = r9.field_msgId;
        r4.xgC = r0;
        r0 = r9.field_createTime;
        r4.xgH = r0;
        r4.nlX = r2;
        r4.xgI = r2;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x004c;
    L_0x001a:
        r0 = com.tencent.mm.y.q.FY();
        r0 = Or(r0);
        r4.wDh = r0;
        r0 = com.tencent.mm.y.q.FY();
        r4.xgB = r0;
    L_0x002a:
        r0 = 0;
        r1 = r9.isSystem();
        if (r1 == 0) goto L_0x0086;
    L_0x0031:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezv;
        r0 = r0.getString(r1);
        r4.nlX = r8;
    L_0x003d:
        if (r0 != 0) goto L_0x0049;
    L_0x003f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezu;
        r0 = r0.getString(r1);
    L_0x0049:
        r4.noL = r0;
        return r4;
    L_0x004c:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.y.s.eX(r0);
        if (r0 == 0) goto L_0x0079;
    L_0x0054:
        r1 = r9.field_talker;
        r0 = r9.field_content;
        r0 = com.tencent.mm.y.bb.hR(r0);
        if (r0 == r6) goto L_0x0443;
    L_0x005e:
        r5 = r9.field_content;
        r0 = r5.substring(r3, r0);
        r0 = r0.trim();
        if (r0 == 0) goto L_0x0443;
    L_0x006a:
        r5 = r0.length();
        if (r5 <= 0) goto L_0x0443;
    L_0x0070:
        r1 = Or(r0);
        r4.wDh = r1;
        r4.xgB = r0;
        goto L_0x002a;
    L_0x0079:
        r0 = r9.field_talker;
        r0 = Or(r0);
        r4.wDh = r0;
        r0 = r9.field_talker;
        r4.xgB = r0;
        goto L_0x002a;
    L_0x0086:
        r1 = r9.cjT();
        if (r1 == 0) goto L_0x009a;
    L_0x008c:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezb;
        r0 = r0.getString(r1);
        r1 = 4;
        r4.nlX = r1;
        goto L_0x003d;
    L_0x009a:
        r1 = r9.cjV();
        if (r1 == 0) goto L_0x00ca;
    L_0x00a0:
        r0 = r9.field_talker;
        r0 = com.tencent.mm.y.s.eX(r0);
        if (r0 == 0) goto L_0x00c6;
    L_0x00a8:
        r0 = r9.field_isSend;
        if (r0 == r2) goto L_0x00c6;
    L_0x00ac:
        r0 = r9.field_content;
        r0 = com.tencent.mm.y.bb.hR(r0);
        if (r0 == r6) goto L_0x00c2;
    L_0x00b4:
        r1 = r9.field_content;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = r0.trim();
        goto L_0x003d;
    L_0x00c2:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00c6:
        r0 = r9.field_content;
        goto L_0x003d;
    L_0x00ca:
        r1 = r9.cjL();
        if (r1 == 0) goto L_0x0110;
    L_0x00d0:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezx;
        r0 = r0.getString(r1);
        r1 = 6;
        r4.nlX = r1;
        r1 = com.tencent.mm.modelvoice.q.C(r9);
        r4.xgI = r1;
        r1 = new com.tencent.mm.modelvoice.n;
        r5 = r9.field_content;
        r1.<init>(r5);
        r6 = r1.time;
        r1 = com.tencent.mm.modelvoice.q.bw(r6);
        r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r6 = com.tencent.mm.R.l.ejB;
        r2 = new java.lang.Object[r2];
        r1 = (int) r1;
        r1 = java.lang.Integer.valueOf(r1);
        r2[r3] = r1;
        r1 = r5.getString(r6, r2);
        r2 = new com.tencent.mm.bp.b;
        r1 = r1.getBytes();
        r2.<init>(r1);
        r4.xgJ = r2;
        goto L_0x003d;
    L_0x0110:
        r1 = r9.cjW();
        if (r1 == 0) goto L_0x0122;
    L_0x0116:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezw;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0122:
        r1 = r9.cjX();
        if (r1 == 0) goto L_0x0134;
    L_0x0128:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezt;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x0134:
        r1 = r9.cjM();
        if (r1 == 0) goto L_0x0175;
    L_0x013a:
        r1 = r9.field_content;
        r1 = com.tencent.mm.x.g.a.fV(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0142:
        r0 = r1.hes;
        r5 = "wxpay://c2cbizmessagehandler/hongbao/receivehongbao";
        r0 = r0.startsWith(r5);
        if (r0 == 0) goto L_0x015c;
    L_0x014d:
        r0 = 5;
        r4.nlX = r0;
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0158;
    L_0x0154:
        r0 = r1.hem;
        goto L_0x003d;
    L_0x0158:
        r0 = r1.hel;
        goto L_0x003d;
    L_0x015c:
        r0 = r9.field_isSend;
        if (r0 != r2) goto L_0x0172;
    L_0x0160:
        r0 = r1.hem;
    L_0x0162:
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyV;
        r2 = new java.lang.Object[r2];
        r2[r3] = r0;
        r0 = r1.getString(r5, r2);
        goto L_0x003d;
    L_0x0172:
        r0 = r1.hel;
        goto L_0x0162;
    L_0x0175:
        r1 = r9.cjN();
        if (r1 == 0) goto L_0x018a;
    L_0x017b:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.eyU;
        r0 = r0.getString(r1);
        r1 = 5;
        r4.nlX = r1;
        goto L_0x003d;
    L_0x018a:
        r1 = r9.aNJ();
        if (r1 == 0) goto L_0x02ec;
    L_0x0190:
        r1 = r9.field_content;
        r1 = com.tencent.mm.x.g.a.fV(r1);
        if (r1 == 0) goto L_0x003d;
    L_0x0198:
        r5 = r1.type;
        switch(r5) {
            case 2: goto L_0x019f;
            case 3: goto L_0x01ce;
            case 4: goto L_0x0208;
            case 5: goto L_0x01b1;
            case 6: goto L_0x01eb;
            case 7: goto L_0x019d;
            case 8: goto L_0x02d3;
            case 9: goto L_0x019d;
            case 10: goto L_0x025f;
            case 11: goto L_0x019d;
            case 12: goto L_0x019d;
            case 13: goto L_0x027c;
            case 14: goto L_0x019d;
            case 15: goto L_0x0242;
            case 16: goto L_0x02b6;
            case 17: goto L_0x019d;
            case 18: goto L_0x019d;
            case 19: goto L_0x0225;
            case 20: goto L_0x0299;
            default: goto L_0x019d;
        };
    L_0x019d:
        goto L_0x003d;
    L_0x019f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezb;
        r0 = r0.getString(r1);
        r1 = new java.lang.Object[r3];
        r0 = java.lang.String.format(r0, r1);
        goto L_0x003d;
    L_0x01b1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyM;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01ce:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyP;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x01eb:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyL;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0208:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyT;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0225:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyR;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0242:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyK;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x025f:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyQ;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x027c:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyO;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x0299:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyS;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02b6:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyW;
        r0 = r0.getString(r5);
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r5 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r5);
        r2[r3] = r1;
        r0 = java.lang.String.format(r0, r2);
        goto L_0x003d;
    L_0x02d3:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyX;
        r2 = new java.lang.Object[r2];
        r1 = r1.title;
        r6 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aD(r1, r6);
        r2[r3] = r1;
        r0 = r0.getString(r5, r2);
        goto L_0x003d;
    L_0x02ec:
        r1 = r9.cjY();
        if (r1 == 0) goto L_0x0391;
    L_0x02f2:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.eyY;
        r1 = r0.getString(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        if (r0 == 0) goto L_0x0440;
    L_0x030a:
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r1 = r9.field_imgPath;
        r1 = r0.yI(r1);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r3 = r1.Nx();
        r0 = r0.yF(r3);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0362;
    L_0x0336:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r3 = com.tencent.mm.R.l.eyY;
        r0 = r0.getString(r3);
    L_0x0340:
        r3 = new com.tencent.mm.protocal.c.bzo;
        r3.<init>();
        r5 = r1.Nx();
        r3.wgY = r5;
        r1 = r1.isGif();
        if (r1 == 0) goto L_0x038e;
    L_0x0351:
        r3.kzz = r2;
    L_0x0353:
        r1 = new com.tencent.mm.bp.b;	 Catch:{ IOException -> 0x043d }
        r2 = r3.toByteArray();	 Catch:{ IOException -> 0x043d }
        r1.<init>(r2);	 Catch:{ IOException -> 0x043d }
        r4.xgJ = r1;	 Catch:{ IOException -> 0x043d }
    L_0x035e:
        r4.nlX = r7;
        goto L_0x003d;
    L_0x0362:
        r3 = new java.lang.StringBuilder;
        r0 = "[";
        r3.<init>(r0);
        r0 = com.tencent.mm.plugin.emoji.b.c.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.emoji.b.c) r0;
        r0 = r0.getEmojiMgr();
        r5 = r1.Nx();
        r0 = r0.yF(r5);
        r0 = r3.append(r0);
        r3 = "]";
        r0 = r0.append(r3);
        r0 = r0.toString();
        goto L_0x0340;
    L_0x038e:
        r3.kzz = r7;
        goto L_0x0353;
    L_0x0391:
        r1 = r9.aNL();
        if (r1 == 0) goto L_0x03a3;
    L_0x0397:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezc;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03a3:
        r1 = r9.cjP();
        if (r1 != 0) goto L_0x03ba;
    L_0x03a9:
        r1 = r9.cjQ();
        if (r1 != 0) goto L_0x03ba;
    L_0x03af:
        r1 = r9.getType();
        r5 = 64;
        if (r1 != r5) goto L_0x03ed;
    L_0x03b7:
        r1 = r2;
    L_0x03b8:
        if (r1 == 0) goto L_0x03fd;
    L_0x03ba:
        r0 = r9.field_content;
        r1 = com.tencent.mm.storage.au.xHB;
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x03e1;
    L_0x03c4:
        r0 = r9.field_content;
        r1 = new com.tencent.mm.f.a.sr;
        r1.<init>();
        r5 = r1.fLl;
        r5.fvG = r2;
        r5 = r1.fLl;
        r5.content = r0;
        r0 = com.tencent.mm.sdk.b.a.xmy;
        r0.m(r1);
        r0 = r1.fLm;
        r0 = r0.type;
        if (r0 != r8) goto L_0x03ef;
    L_0x03de:
        r0 = r2;
    L_0x03df:
        if (r0 == 0) goto L_0x03f1;
    L_0x03e1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezz;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03ed:
        r1 = r3;
        goto L_0x03b8;
    L_0x03ef:
        r0 = r3;
        goto L_0x03df;
    L_0x03f1:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.ezy;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x03fd:
        r1 = r9.cjU();
        if (r1 == 0) goto L_0x0428;
    L_0x0403:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r9.field_content;
        r0 = r0.Fq(r1);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r5 = com.tencent.mm.R.l.eyW;
        r1 = r1.getString(r5);
        r2 = new java.lang.Object[r2];
        r0 = r0.getDisplayName();
        r2[r3] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x003d;
    L_0x0428:
        r1 = r9.getType();
        r2 = -1879048186; // 0xffffffff90000006 float:-2.5243567E-29 double:NaN;
        if (r1 != r2) goto L_0x003d;
    L_0x0431:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r1 = com.tencent.mm.R.l.eyN;
        r0 = r0.getString(r1);
        goto L_0x003d;
    L_0x043d:
        r1 = move-exception;
        goto L_0x035e;
    L_0x0440:
        r0 = r1;
        goto L_0x003d;
    L_0x0443:
        r0 = r1;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wear.model.h.W(com.tencent.mm.storage.au):com.tencent.mm.protocal.c.caf");
    }

    public static byte[] M(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean aBZ() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean aCa() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static byte[] Os(String str) {
        return FileOp.d(new File(new File(a.hbu, "lib"), "lib" + str + ".so").getAbsolutePath(), 0, -1);
    }
}
