package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] jXA = new char[]{'<', '>', '\"', '\'', '&', 10};
    private static final String[] jXB = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String yFZ = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + s.fp("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private Context context;
    private x fBc = null;
    private float gVS = 1.0f;
    private List<au> yAp;
    private String yFX = null;

    public static class ImageSpanData implements Parcelable {
        public static final Creator<ImageSpanData> CREATOR = new Creator<ImageSpanData>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.hna = parcel.readInt();
                imageSpanData.endPos = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                return imageSpanData;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ImageSpanData[i];
            }
        };
        int endPos;
        int hna;
        String path;
        private int thumbnail = 0;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.hna);
            parcel.writeInt(this.endPos);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
        }
    }

    private static String Wm(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = jXA.length - 1; length2 >= 0; length2--) {
                if (jXA[length2] == charAt) {
                    stringBuffer.append(jXB[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public QQMailHistoryExporter(Context context, List<au> list, x xVar) {
        this.context = context;
        this.yAp = list;
        this.fBc = xVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String ctQ() {
        /*
        r15 = this;
        r14 = 4;
        r13 = 3;
        r12 = 2;
        r11 = 0;
        r10 = 1;
        r0 = "MicroMsg.QQMailHistoryExporter";
        r1 = "selectItems.size = %d";
        r2 = new java.lang.Object[r10];
        r3 = r15.yAp;
        r3 = r3.size();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r11] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r15.context;
        r0 = com.tencent.mm.bu.a.ez(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r15.context;
        r0 = com.tencent.mm.bu.a.ev(r0);
        r15.gVS = r0;
    L_0x002c:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = "<div id=\"history\">\n";
        r3.append(r0);
        r0 = "<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>";
        r1 = new java.lang.Object[r13];
        r2 = r15.gVS;
        r2 = java.lang.Float.valueOf(r2);
        r1[r11] = r2;
        r2 = r15.gVS;
        r2 = java.lang.Float.valueOf(r2);
        r1[r10] = r2;
        r2 = r15.ctR();
        r1[r12] = r2;
        r0 = java.lang.String.format(r0, r1);
        r3.append(r0);
        r0 = r15.yAp;
        r4 = r0.iterator();
    L_0x005f:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x052d;
    L_0x0065:
        r0 = r4.next();
        r0 = (com.tencent.mm.storage.au) r0;
        r1 = r15.yFX;
        if (r1 != 0) goto L_0x00cb;
    L_0x006f:
        r6 = r0.field_createTime;
        r1 = gb(r6);
        r15.yFX = r1;
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r11] = r5;
        r5 = r15.yFX;
        r2[r10] = r5;
        r1 = java.lang.String.format(r1, r2);
        r3.append(r1);
    L_0x008f:
        r1 = r0.cjV();
        if (r1 == 0) goto L_0x016e;
    L_0x0095:
        r1 = r0.cjV();
        if (r1 == 0) goto L_0x016b;
    L_0x009b:
        r1 = 0;
        r2 = r0.field_isSend;
        if (r2 != r10) goto L_0x00fa;
    L_0x00a0:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r11] = r5;
        r5 = r15.aC(r0);
        r2[r10] = r5;
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r12] = r5;
        r0 = r0.field_content;
        r0 = Wm(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
    L_0x00c7:
        r3.append(r0);
        goto L_0x005f;
    L_0x00cb:
        r6 = r0.field_createTime;
        r1 = gb(r6);
        r2 = r15.yFX;
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x008f;
    L_0x00d9:
        r15.yFX = r1;
        r1 = "<br>";
        r3.append(r1);
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r11] = r5;
        r5 = r15.yFX;
        r2[r10] = r5;
        r1 = java.lang.String.format(r1, r2);
        r3.append(r1);
        goto L_0x008f;
    L_0x00fa:
        r2 = r15.fBc;
        r2 = r2.field_username;
        r5 = "@chatroom";
        r2 = r2.endsWith(r5);
        if (r2 != 0) goto L_0x012f;
    L_0x0107:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r11] = r5;
        r5 = r15.aC(r0);
        r2[r10] = r5;
        r5 = r15.gVS;
        r5 = java.lang.Float.valueOf(r5);
        r2[r12] = r5;
        r0 = r0.field_content;
        r0 = Wm(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x00c7;
    L_0x012f:
        r2 = r0.field_content;
        r2 = com.tencent.mm.y.bb.hR(r2);
        r5 = -1;
        if (r2 == r5) goto L_0x053b;
    L_0x0138:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r5 = new java.lang.Object[r14];
        r6 = r15.gVS;
        r6 = java.lang.Float.valueOf(r6);
        r5[r11] = r6;
        r6 = r15.aC(r0);
        r5[r10] = r6;
        r6 = r15.gVS;
        r6 = java.lang.Float.valueOf(r6);
        r5[r12] = r6;
        r0 = r0.field_content;
        r2 = r2 + 1;
        r0 = r0.substring(r2);
        r0 = r0.trim();
        r0 = Wm(r0);
        r5[r13] = r0;
        r0 = java.lang.String.format(r1, r5);
        goto L_0x00c7;
    L_0x016b:
        r0 = 0;
        goto L_0x00c7;
    L_0x016e:
        r1 = r0.cjT();
        if (r1 == 0) goto L_0x01f3;
    L_0x0174:
        r1 = r0.cjT();
        if (r1 == 0) goto L_0x01f1;
    L_0x017a:
        r6 = r0.field_msgId;
        r8 = r0.field_msgSvrId;
        r1 = com.tencent.mm.ui.chatting.ab.fZ(r6);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 == 0) goto L_0x018c;
    L_0x0188:
        r1 = com.tencent.mm.ui.chatting.ab.ga(r8);
    L_0x018c:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r5 = "hdPath[%s]";
        r6 = new java.lang.Object[r10];
        r6[r11] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r5, r6);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 != 0) goto L_0x01f1;
    L_0x019f:
        r2 = new java.lang.StringBuilder;
        r5 = "file://";
        r2.<init>(r5);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r5 = yFZ;
        r6 = new java.lang.Object[r14];
        r8 = r0.field_msgId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r11] = r7;
        r8 = r0.field_msgSvrId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r10] = r7;
        r6[r12] = r2;
        r6[r13] = r1;
        r1 = java.lang.String.format(r5, r6);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r5 = new java.lang.Object[r14];
        r6 = r15.gVS;
        r6 = java.lang.Float.valueOf(r6);
        r5[r11] = r6;
        r0 = r15.aC(r0);
        r5[r10] = r0;
        r0 = r15.gVS;
        r0 = java.lang.Float.valueOf(r0);
        r5[r12] = r0;
        r5[r13] = r1;
        r0 = java.lang.String.format(r2, r5);
    L_0x01ec:
        r3.append(r0);
        goto L_0x005f;
    L_0x01f1:
        r0 = 0;
        goto L_0x01ec;
    L_0x01f3:
        r1 = 0;
        r2 = r0.cjL();
        if (r2 == 0) goto L_0x0240;
    L_0x01fa:
        r1 = "[%s]";
        r2 = new java.lang.Object[r10];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZG;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r1 = java.lang.String.format(r1, r2);
    L_0x020d:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r5 = "formatOtherMsg, msgStr = %s";
        r6 = new java.lang.Object[r10];
        r6[r11] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r5, r6);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r5 = new java.lang.Object[r14];
        r6 = r15.gVS;
        r6 = java.lang.Float.valueOf(r6);
        r5[r11] = r6;
        r0 = r15.aC(r0);
        r5[r10] = r0;
        r0 = r15.gVS;
        r0 = java.lang.Float.valueOf(r0);
        r5[r12] = r0;
        r5[r13] = r1;
        r0 = java.lang.String.format(r2, r5);
        r3.append(r0);
        goto L_0x005f;
    L_0x0240:
        r2 = r0.cjP();
        if (r2 == 0) goto L_0x025c;
    L_0x0246:
        r1 = r0.field_isSend;
        if (r1 != r10) goto L_0x0253;
    L_0x024a:
        r1 = r15.context;
        r2 = com.tencent.mm.R.l.dZE;
        r1 = r1.getString(r2);
        goto L_0x020d;
    L_0x0253:
        r1 = r15.context;
        r2 = com.tencent.mm.R.l.dZD;
        r1 = r1.getString(r2);
        goto L_0x020d;
    L_0x025c:
        r2 = r0.aNL();
        if (r2 == 0) goto L_0x0284;
    L_0x0262:
        r1 = new com.tencent.mm.f.a.iy;
        r1.<init>();
        r2 = r1.fAs;
        r2.fAm = r10;
        r2 = r1.fAs;
        r2.fou = r0;
        r2 = com.tencent.mm.sdk.b.a.xmy;
        r2.m(r1);
        r1 = r1.fAt;
        r1 = r1.fxq;
        r2 = "[%s]";
        r5 = new java.lang.Object[r10];
        r5[r11] = r1;
        r1 = java.lang.String.format(r2, r5);
        goto L_0x020d;
    L_0x0284:
        r2 = r0.aNJ();
        if (r2 == 0) goto L_0x04a7;
    L_0x028a:
        r2 = "";
        r1 = r0.field_content;
        r5 = r15.fBc;
        r5 = r5.field_username;
        r6 = "@chatroom";
        r5 = r5.endsWith(r6);
        if (r5 == 0) goto L_0x02ba;
    L_0x029c:
        r5 = "MicroMsg.QQMailHistoryExporter";
        r6 = "chatroom msg, parse it";
        com.tencent.mm.sdk.platformtools.x.d(r5, r6);
        r5 = r0.field_content;
        r5 = com.tencent.mm.y.bb.hR(r5);
        r6 = -1;
        if (r5 == r6) goto L_0x02ba;
    L_0x02ae:
        r1 = r0.field_content;
        r5 = r5 + 1;
        r1 = r1.substring(r5);
        r1 = r1.trim();
    L_0x02ba:
        r1 = com.tencent.mm.sdk.platformtools.bi.Wn(r1);
        r5 = com.tencent.mm.x.g.a.fV(r1);
        if (r5 != 0) goto L_0x02e2;
    L_0x02c4:
        r1 = "MicroMsg.QQMailHistoryExporter";
        r2 = "appmsg content is null";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);
        r1 = "[%s]";
        r2 = new java.lang.Object[r10];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZw;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x02e2:
        r1 = r5.appId;
        r6 = com.tencent.mm.pluginsdk.model.app.g.aZ(r1, r10);
        if (r6 == 0) goto L_0x02f2;
    L_0x02ea:
        r1 = r6.field_appName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x030e;
    L_0x02f2:
        r1 = r5.appName;
    L_0x02f4:
        r7 = r15.context;
        r1 = com.tencent.mm.pluginsdk.model.app.g.a(r7, r6, r1);
        r6 = r0.cka();
        if (r6 == 0) goto L_0x0326;
    L_0x0300:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 == 0) goto L_0x0311;
    L_0x0306:
        r1 = r5.title;
        r1 = Wm(r1);
        goto L_0x020d;
    L_0x030e:
        r1 = r6.field_appName;
        goto L_0x02f4;
    L_0x0311:
        r2 = "[%s: %s]";
        r6 = new java.lang.Object[r12];
        r6[r11] = r1;
        r1 = r5.title;
        r1 = Wm(r1);
        r6[r10] = r1;
        r1 = java.lang.String.format(r2, r6);
        goto L_0x020d;
    L_0x0326:
        r6 = r0.ckb();
        if (r6 == 0) goto L_0x0364;
    L_0x032c:
        r1 = com.tencent.mm.ui.chatting.ab.a(r0, r5);
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r5 != 0) goto L_0x0538;
    L_0x0336:
        r2 = new java.lang.StringBuilder;
        r5 = "file://";
        r2.<init>(r5);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r5 = yFZ;
        r6 = new java.lang.Object[r14];
        r8 = r0.field_msgId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r11] = r7;
        r8 = r0.field_msgSvrId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r10] = r7;
        r6[r12] = r2;
        r6[r13] = r1;
        r1 = java.lang.String.format(r5, r6);
        goto L_0x020d;
    L_0x0364:
        r6 = r5.type;
        switch(r6) {
            case 1: goto L_0x0469;
            case 2: goto L_0x0431;
            case 3: goto L_0x037e;
            case 4: goto L_0x048c;
            case 5: goto L_0x048c;
            case 6: goto L_0x03dd;
            case 7: goto L_0x0369;
            case 8: goto L_0x03c8;
            default: goto L_0x0369;
        };
    L_0x0369:
        r1 = "[%s]";
        r2 = new java.lang.Object[r10];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZw;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x037e:
        r1 = r5.description;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x03a3;
    L_0x0386:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r6 = r15.context;
        r7 = com.tencent.mm.R.l.dZC;
        r6 = r6.getString(r7);
        r2[r11] = r6;
        r5 = r5.title;
        r5 = Wm(r5);
        r2[r10] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03a3:
        r1 = "[%s: %s-%s]";
        r2 = new java.lang.Object[r13];
        r6 = r15.context;
        r7 = com.tencent.mm.R.l.dZC;
        r6 = r6.getString(r7);
        r2[r11] = r6;
        r6 = r5.title;
        r6 = Wm(r6);
        r2[r10] = r6;
        r5 = r5.description;
        r5 = Wm(r5);
        r2[r12] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03c8:
        r1 = "[%s]";
        r2 = new java.lang.Object[r10];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZz;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x03dd:
        r1 = r5.description;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x0402;
    L_0x03e5:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r6 = r15.context;
        r7 = com.tencent.mm.R.l.dZA;
        r6 = r6.getString(r7);
        r2[r11] = r6;
        r5 = r5.title;
        r5 = Wm(r5);
        r2[r10] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0402:
        r1 = "[%s: %s-%s(%s)]";
        r2 = new java.lang.Object[r14];
        r6 = r15.context;
        r7 = com.tencent.mm.R.l.dZA;
        r6 = r6.getString(r7);
        r2[r11] = r6;
        r6 = r5.title;
        r6 = Wm(r6);
        r2[r10] = r6;
        r5 = r5.description;
        r5 = Wm(r5);
        r2[r12] = r5;
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZx;
        r5 = r5.getString(r6);
        r2[r13] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x0431:
        r1 = com.tencent.mm.ui.chatting.ab.a(r0, r5);
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r5 != 0) goto L_0x0538;
    L_0x043b:
        r2 = new java.lang.StringBuilder;
        r5 = "file://";
        r2.<init>(r5);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r5 = yFZ;
        r6 = new java.lang.Object[r14];
        r8 = r0.field_msgId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r11] = r7;
        r8 = r0.field_msgSvrId;
        r7 = java.lang.Long.valueOf(r8);
        r6[r10] = r7;
        r6[r12] = r2;
        r6[r13] = r1;
        r1 = java.lang.String.format(r5, r6);
        goto L_0x020d;
    L_0x0469:
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 == 0) goto L_0x0477;
    L_0x046f:
        r1 = r5.title;
        r1 = Wm(r1);
        goto L_0x020d;
    L_0x0477:
        r2 = "[%s: %s]";
        r6 = new java.lang.Object[r12];
        r6[r11] = r1;
        r1 = r5.title;
        r1 = Wm(r1);
        r6[r10] = r1;
        r1 = java.lang.String.format(r2, r6);
        goto L_0x020d;
    L_0x048c:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r6 = r5.title;
        r6 = Wm(r6);
        r2[r11] = r6;
        r5 = r5.url;
        r5 = Wm(r5);
        r2[r10] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x04a7:
        r2 = r0.cjU();
        if (r2 == 0) goto L_0x04d3;
    L_0x04ad:
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Fh();
        r2 = r0.field_content;
        r1 = r1.Fq(r2);
        r1 = r1.fqG;
        r2 = "[%s: %s]";
        r5 = new java.lang.Object[r12];
        r6 = r15.context;
        r7 = com.tencent.mm.R.l.dZy;
        r6 = r6.getString(r7);
        r5[r11] = r6;
        r5[r10] = r1;
        r1 = java.lang.String.format(r2, r5);
        goto L_0x020d;
    L_0x04d3:
        r2 = r0.cjW();
        if (r2 == 0) goto L_0x050c;
    L_0x04d9:
        r1 = "[%s: %s(%s)]";
        r2 = new java.lang.Object[r13];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZF;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r5 = new java.io.File;
        com.tencent.mm.modelvideo.o.Ub();
        r6 = r0.field_imgPath;
        r6 = com.tencent.mm.modelvideo.s.nx(r6);
        r5.<init>(r6);
        r5 = r5.getName();
        r2[r10] = r5;
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZx;
        r5 = r5.getString(r6);
        r2[r12] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x050c:
        r2 = r0.cjY();
        if (r2 != 0) goto L_0x0518;
    L_0x0512:
        r2 = r0.cjZ();
        if (r2 == 0) goto L_0x020d;
    L_0x0518:
        r1 = "[%s]";
        r2 = new java.lang.Object[r10];
        r5 = r15.context;
        r6 = com.tencent.mm.R.l.dZz;
        r5 = r5.getString(r6);
        r2[r11] = r5;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020d;
    L_0x052d:
        r0 = "\n</div>\n";
        r3.append(r0);
        r0 = r3.toString();
        return r0;
    L_0x0538:
        r1 = r2;
        goto L_0x020d;
    L_0x053b:
        r0 = r1;
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.QQMailHistoryExporter.ctQ():java.lang.String");
    }

    private String ctR() {
        String str;
        if (this.fBc.field_username.endsWith("@chatroom")) {
            if (bi.oN(this.fBc.field_nickname)) {
                String str2;
                str = "";
                Iterator it = m.gl(this.fBc.field_username).iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = str2 + r.gw((String) it.next()) + ", ";
                }
                str = str2.substring(0, str2.length() - 2);
            } else {
                str = this.fBc.AW();
            }
            return String.format(this.context.getString(R.l.eKd), new Object[]{str});
        }
        str = this.context.getString(R.l.eKe);
        Object[] objArr = new Object[2];
        objArr[0] = this.fBc.AW();
        as.Hm();
        objArr[1] = c.Db().get(4, null);
        return String.format(str, objArr);
    }

    private String aC(au auVar) {
        String str;
        String str2 = null;
        if (this.fBc.field_username.endsWith("@chatroom")) {
            str = auVar.field_content;
            int hR = bb.hR(str);
            if (hR != -1) {
                str2 = r.gw(str.substring(0, hR).trim());
            }
        } else {
            str2 = r.gw(auVar.field_talker);
        }
        if (auVar.field_isSend == 1) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = q.Ga();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(auVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String gb(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
