package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ap.g;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e implements k {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.ev r12, boolean r13, com.tencent.mm.storage.au r14, java.lang.String r15, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r16, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.bakoldlogic.b.i.a> r17, boolean r18, long r19) {
        /*
        r11 = this;
        r0 = r14.field_content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0149;
    L_0x0008:
        r0 = 0;
        r8 = r0;
    L_0x000a:
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x000f:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r2 = r14.field_msgId;
        r0 = r0.bj(r2);
        r2 = r0.hBA;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x02bb;
    L_0x0029:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r2 = r14.field_msgSvrId;
        r0 = r0.bi(r2);
        r9 = r0;
    L_0x003c:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r1 = r14.field_imgPath;
        r2 = 1;
        r1 = r0.B(r1, r2);
        r0 = com.tencent.mm.a.e.bO(r1);
        if (r0 == 0) goto L_0x0153;
    L_0x0055:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.j$a;
        r4 = 1;
        r5 = 0;
        r6 = "_thumb";
        r7 = 0;
        r2 = r12;
        r3 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(r0);
        r8 = r8 + r0;
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x016f;
    L_0x006d:
        r1 = "";
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r2 = r9.hBB;
        r3 = "";
        r4 = "";
        r10 = r0.m(r2, r3, r4);
        r0 = r9.Pk();
        if (r0 == 0) goto L_0x00fc;
    L_0x008e:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r2 = r9.hBK;
        r9 = r0.hT(r2);
        if (r9 == 0) goto L_0x0165;
    L_0x00a2:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r1 = r9.hBB;
        r2 = "";
        r3 = "";
        r1 = r0.m(r1, r2, r3);
        r0 = "MicroMsg.BakOldItemImg";
        r2 = new java.lang.StringBuilder;
        r3 = "packet hd bigImgPath ";
        r2.<init>(r3);
        r2 = r2.append(r1);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = com.tencent.mm.a.e.bN(r1);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);
        com.tencent.mm.a.e.bN(r1);
        r0 = com.tencent.mm.a.e.bO(r1);
        if (r0 == 0) goto L_0x0155;
    L_0x00e8:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.j$a;
        r4 = 3;
        r5 = 0;
        r6 = "_hd";
        r7 = 0;
        r2 = r12;
        r3 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(r0);
        r0 = r0 + r8;
        r8 = r0;
    L_0x00fc:
        com.tencent.mm.a.e.bN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 != 0) goto L_0x0142;
    L_0x0105:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0142;
    L_0x010b:
        r0 = "MicroMsg.BakOldItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.bN(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.j$a;
        r4 = 2;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(r0);
        r8 = r8 + r0;
    L_0x0142:
        r0 = a(r9, r14);
        if (r0 != 0) goto L_0x02a9;
    L_0x0148:
        return r8;
    L_0x0149:
        r0 = r14.field_content;
        r0 = r0.getBytes();
        r0 = r0.length;
        r8 = r0;
        goto L_0x000a;
    L_0x0153:
        r8 = -1;
        goto L_0x0148;
    L_0x0155:
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r0, r2, r3);
        goto L_0x00fc;
    L_0x0165:
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet img.hasHdImg but img is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x00fc;
    L_0x016f:
        r0 = r9.Pj();
        if (r0 == 0) goto L_0x0142;
    L_0x0175:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r1 = r9.hBB;
        r2 = "";
        r3 = "";
        r10 = r0.m(r1, r2, r3);
        r2 = "";
        r0 = r9.Pk();
        if (r0 == 0) goto L_0x02a7;
    L_0x0196:
        r0 = r9.Pk();
        if (r0 == 0) goto L_0x0291;
    L_0x019c:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r0 = r0.arr();
        r0 = r0.aqI();
        r1 = r9.hBK;
        r0 = r0.hT(r1);
        if (r0 == 0) goto L_0x0291;
    L_0x01b0:
        r3 = "MicroMsg.BakOldItemImg";
        r4 = "packet hdinfo off:%d total:%d path:%s, compressType[%d]";
        r1 = 4;
        r5 = new java.lang.Object[r1];
        r6 = 0;
        if (r0 != 0) goto L_0x0294;
    L_0x01bc:
        r1 = -1;
    L_0x01bd:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        r6 = 1;
        if (r0 != 0) goto L_0x0298;
    L_0x01c6:
        r1 = -1;
    L_0x01c7:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        r6 = 2;
        if (r0 != 0) goto L_0x029c;
    L_0x01d0:
        r1 = "null";
    L_0x01d3:
        r5[r6] = r1;
        r6 = 3;
        if (r0 != 0) goto L_0x02a0;
    L_0x01d8:
        r1 = -1;
    L_0x01d9:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        if (r0 == 0) goto L_0x02a7;
    L_0x01e4:
        r1 = r0.hBE;
        r3 = 1;
        if (r1 != r3) goto L_0x02a7;
    L_0x01e9:
        r1 = r0.equals(r9);
        if (r1 != 0) goto L_0x02a4;
    L_0x01ef:
        r1 = r0.offset;
        r3 = r0.hmZ;
        if (r1 != r3) goto L_0x02a4;
    L_0x01f5:
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq();
        r1 = r1.arr();
        r1 = r1.aqI();
        r0 = r0.hBB;
        r2 = "";
        r3 = "";
        r1 = r1.m(r0, r2, r3);
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet hdPath:%s, fileLen[%d]";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        r4 = 1;
        r5 = com.tencent.mm.a.e.bN(r1);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r0 = com.tencent.mm.a.e.bO(r1);
        if (r0 == 0) goto L_0x0243;
    L_0x022d:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.j$a;
        r4 = 3;
        r5 = 0;
        r6 = "_hd";
        r7 = 0;
        r2 = r12;
        r3 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(r0);
        r8 = r8 + r0;
        com.tencent.mm.a.e.bN(r1);
    L_0x0243:
        r0 = com.tencent.mm.a.e.bO(r10);
        if (r0 == 0) goto L_0x0142;
    L_0x0249:
        com.tencent.mm.a.e.bN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 != 0) goto L_0x0142;
    L_0x0252:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0142;
    L_0x0258:
        r0 = "MicroMsg.BakOldItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.bN(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.j$a;
        r4 = 2;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(r0);
        r8 = r8 + r0;
        goto L_0x0142;
    L_0x0291:
        r0 = r9;
        goto L_0x01b0;
    L_0x0294:
        r1 = r0.offset;
        goto L_0x01bd;
    L_0x0298:
        r1 = r0.hmZ;
        goto L_0x01c7;
    L_0x029c:
        r1 = r0.hBB;
        goto L_0x01d3;
    L_0x02a0:
        r1 = r0.hBE;
        goto L_0x01d9;
    L_0x02a4:
        r0.equals(r9);
    L_0x02a7:
        r1 = r2;
        goto L_0x0243;
    L_0x02a9:
        r1 = new com.tencent.mm.protocal.c.bet;
        r1.<init>();
        r1 = r1.Vf(r0);
        r12.vNO = r1;
        r0 = r0.length();
        r8 = r8 + r0;
        goto L_0x0148;
    L_0x02bb:
        r9 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.b.e.a(com.tencent.mm.protocal.c.ev, boolean, com.tencent.mm.storage.au, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }

    private static String a(com.tencent.mm.ap.e eVar, au auVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (d.eX(auVar.field_talker)) {
                stringWriter.write(bb.hS(auVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map y = bj.y(eVar.hBL, "msg");
            if (y != null) {
                newSerializer.attribute(null, "aeskey", ((String) y.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) y.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) y.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) y.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", bi.getLong((String) y.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", bi.getInt((String) y.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", bi.getInt((String) y.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", bi.getInt((String) y.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", bi.getInt((String) y.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", bi.getInt((String) y.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", bi.getInt((String) y.get(".msg.img.$cdnhdwidth"), 0));
                newSerializer.attribute(null, "cdnmidimgurl", ((String) y.get(".msg.img.$cdnmidimgurl")));
                long j = bi.getLong((String) y.get(".msg.img.$length"), 0);
                String str = "length";
                StringBuilder stringBuilder = new StringBuilder();
                if (j == 0) {
                    j = (long) com.tencent.mm.a.e.bN(b.arq().arr().aqI().m(eVar.hBB, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (auVar.field_isSend != 1 || eVar.hBE == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) y.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bi.getLong((String) y.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) y.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            x.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, ev evVar, au auVar) {
        if (evVar == null || evVar.vNO == null) {
            x.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        com.tencent.mm.ap.e bi;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(bi.aD(evVar.vNO.wRo, ""));
        x.d("MicroMsg.BakOldItemImg", "recover msg" + evVar.vNT + " " + str5);
        String str6 = "MicroMsg.BakOldItemImg";
        String str7 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (evVar.vQW == null) {
            i = 0;
        } else {
            i = evVar.vQW.wRk;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(evVar.vQY);
        if (evVar.vQV == null) {
            str2 = "";
        } else {
            str2 = evVar.vQV.toString();
        }
        objArr[2] = str2;
        if (evVar.vQU == null) {
            str2 = "";
        } else {
            str2 = evVar.vQU.toString();
        }
        objArr[3] = str2;
        x.d(str6, str7, objArr);
        com.tencent.mm.ap.e eVar = null;
        auVar.setContent(str5);
        g aqI = b.arq().arr().aqI();
        if (auVar.field_isSend == 1) {
            if (auVar.field_msgId != 0) {
                eVar = aqI.bj(auVar.field_msgId);
            }
            if (eVar == null || eVar.hBA == 0) {
                bi = aqI.bi(auVar.field_msgSvrId);
            } else {
                bi = eVar;
            }
        } else {
            bi = aqI.bi(auVar.field_msgSvrId);
        }
        Map y = bj.y(str5, "msg");
        if (y == null || bi.getLong((String) y.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String aD = bi.aD(a.a(evVar, 3), "");
        if (evVar.vQY == 3 && evVar.vQW != null) {
            com.tencent.mm.a.e.a(a.aqP() + "backupMeida/" + a.vT(aD), aD, evVar.vQW.wRm.oz);
        }
        str2 = bi.aD(a.a(evVar, 2), "");
        if (evVar.vQY == 2 && evVar.vQW != null) {
            com.tencent.mm.a.e.a(a.aqP() + "backupMeida/" + a.vT(str2), str2, evVar.vQW.wRm.oz);
        }
        x.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", aD, str2);
        if (bi.oN(str2)) {
            x.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str3 = aD;
        } else {
            str3 = str2;
        }
        byte[] b = a.b(evVar, 1);
        if (b == null) {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            str2 = a.wg(str3);
            String s = com.tencent.mm.a.g.s((bi.Wy() + " ").getBytes());
            str6 = a.aqP() + "backupMeida/" + a.vT(s);
            str4 = str6 + s;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int VE = z.VE(str4);
            if (VE > 0) {
                if (!z.a(str2, CompressFormat.JPEG, str4, VE)) {
                    x.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                x.d("MicroMsg.BakOldItemImg", "insert: thumbName = " + s);
            } else {
                x.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.e(str4, 0, -1);
        } else {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
        }
        if (b == null) {
            x.e("MicroMsg.BakOldItemImg", "img buf is null");
            return -1;
        }
        String m = aqI.m(aD, "", "");
        String m2 = aqI.m(str3, "", "");
        long j = 0;
        if (bi.hBA == 0) {
            if (obj != null) {
                g gVar = aqI;
                str4 = aD;
                j = gVar.a(b, evVar.vNT, true, str4, a.c(evVar, 3), str5, new PString(), new PInt(), new PInt());
                if (!a.b(evVar, 3, m)) {
                    x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", m);
                }
            }
            long j2 = j;
            int c = a.c(evVar, 2);
            if (c <= 0) {
                c = a.c(evVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = aqI.a(b, evVar.vNT, false, str3, c, str5, pString, pInt, pInt2);
            if (!a.b(evVar, 2, m2)) {
                x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", m);
            }
            if (a <= 0) {
                return -1;
            }
            auVar.dV(pString.value);
            auVar.fd(pInt.value);
            auVar.fe(pInt2.value);
            if (j2 > 0) {
                com.tencent.mm.ap.e b2 = b.arq().arr().aqI().b(Long.valueOf(a));
                b2.hP((int) j2);
                b.arq().arr().aqI().a(Long.valueOf(a), b2);
            }
        } else {
            str2 = bi.hBD;
            if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                auVar.dV("THUMBNAIL://" + bi.hBA);
            } else {
                auVar.dV(str2);
            }
        }
        d.i(auVar);
        return 0;
    }
}
