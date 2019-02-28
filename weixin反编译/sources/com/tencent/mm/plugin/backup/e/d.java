package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.g;
import com.tencent.mm.plugin.backup.g.c;
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

public final class d implements l {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.ev r12, boolean r13, com.tencent.mm.storage.au r14, java.lang.String r15, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r16, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.e.h.a> r17, boolean r18, long r19) {
        /*
        r11 = this;
        r0 = r14.field_content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x014c;
    L_0x0008:
        r0 = 0;
        r8 = r0;
    L_0x000a:
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x000f:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r2 = r14.field_msgId;
        r0 = r0.bj(r2);
        r2 = r0.hBA;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x02a5;
    L_0x0029:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r2 = r14.field_msgSvrId;
        r0 = r0.bi(r2);
        r9 = r0;
    L_0x003c:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r1 = r14.field_imgPath;
        r2 = 1;
        r1 = r0.B(r1, r2);
        r0 = com.tencent.mm.a.e.bO(r1);
        if (r0 == 0) goto L_0x0156;
    L_0x0055:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 1;
        r6 = "_thumb";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0172;
    L_0x006e:
        r1 = "";
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r2 = r9.hBB;
        r3 = "";
        r4 = "";
        r10 = r0.m(r2, r3, r4);
        r0 = r9.Pk();
        if (r0 == 0) goto L_0x00fe;
    L_0x008f:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r2 = r9.hBK;
        r9 = r0.hT(r2);
        if (r9 == 0) goto L_0x0168;
    L_0x00a3:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r1 = r9.hBB;
        r2 = "";
        r3 = "";
        r1 = r0.m(r1, r2, r3);
        r0 = "MicroMsg.BackupItemImg";
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
        if (r0 == 0) goto L_0x0158;
    L_0x00e9:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r0 = r0 + r8;
        r8 = r0;
    L_0x00fe:
        com.tencent.mm.a.e.bN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x0107:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x010d:
        r0 = "MicroMsg.BackupItemImg";
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
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
    L_0x0145:
        r0 = a(r9, r14);
        if (r0 != 0) goto L_0x0293;
    L_0x014b:
        return r8;
    L_0x014c:
        r0 = r14.field_content;
        r0 = r0.getBytes();
        r0 = r0.length;
        r8 = r0;
        goto L_0x000a;
    L_0x0156:
        r8 = -1;
        goto L_0x014b;
    L_0x0158:
        r0 = "MicroMsg.BackupItemImg";
        r2 = "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r0, r2, r3);
        goto L_0x00fe;
    L_0x0168:
        r0 = "MicroMsg.BackupItemImg";
        r2 = "packet img.hasHdImg but img is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x00fe;
    L_0x0172:
        r0 = r9.Pj();
        if (r0 == 0) goto L_0x0145;
    L_0x0178:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r1 = r9.hBB;
        r2 = "";
        r3 = "";
        r10 = r0.m(r1, r2, r3);
        r1 = "";
        r0 = r9.Pk();
        if (r0 == 0) goto L_0x028c;
    L_0x0199:
        r0 = com.tencent.mm.plugin.backup.g.d.aqL();
        r0 = r0.aqM();
        r0 = r0.aqI();
        r2 = r9.hBK;
        r0 = r0.hT(r2);
        if (r0 == 0) goto L_0x028c;
    L_0x01ad:
        if (r0 == 0) goto L_0x01db;
    L_0x01af:
        r2 = "MicroMsg.BackupItemImg";
        r3 = "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r0.offset;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r0.hmZ;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = r0.hBE;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = r0.hBB;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
    L_0x01db:
        if (r0 == 0) goto L_0x023d;
    L_0x01dd:
        r2 = r0.hBE;
        r3 = 1;
        if (r2 != r3) goto L_0x023d;
    L_0x01e2:
        r2 = r0.equals(r9);
        if (r2 != 0) goto L_0x028f;
    L_0x01e8:
        r2 = r0.offset;
        r3 = r0.hmZ;
        if (r2 != r3) goto L_0x028f;
    L_0x01ee:
        r1 = com.tencent.mm.plugin.backup.g.d.aqL();
        r1 = r1.aqM();
        r1 = r1.aqI();
        r0 = r0.hBB;
        r2 = "";
        r3 = "";
        r1 = r1.m(r0, r2, r3);
        r0 = "MicroMsg.BackupItemImg";
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
        if (r0 == 0) goto L_0x023d;
    L_0x0226:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        com.tencent.mm.a.e.bN(r1);
    L_0x023d:
        r0 = com.tencent.mm.a.e.bO(r10);
        if (r0 == 0) goto L_0x0145;
    L_0x0243:
        com.tencent.mm.a.e.bN(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x024c:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x0252:
        r0 = "MicroMsg.BackupItemImg";
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
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        goto L_0x0145;
    L_0x028c:
        r0 = 0;
        goto L_0x01ad;
    L_0x028f:
        r0.equals(r9);
        goto L_0x023d;
    L_0x0293:
        r1 = new com.tencent.mm.protocal.c.bet;
        r1.<init>();
        r1 = r1.Vf(r0);
        r12.vNO = r1;
        r0 = r0.length();
        r8 = r8 + r0;
        goto L_0x014b;
    L_0x02a5:
        r9 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.e.d.a(com.tencent.mm.protocal.c.ev, boolean, com.tencent.mm.storage.au, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }

    private static String a(e eVar, au auVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (c.eX(auVar.field_talker)) {
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
                    j = (long) com.tencent.mm.a.e.bN(com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().m(eVar.hBB, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (!(auVar.field_isSend == 1 && eVar.hBE != 1 && bi.getLong((String) y.get(".msg.img.$hdlength"), 0) == 0)) {
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
            x.d("MicroMsg.BackupItemImg", "parseContent xml:%s", stringWriter.getBuffer().toString());
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BackupItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, ev evVar, au auVar) {
        if (evVar == null || evVar.vNO == null) {
            x.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        e bi;
        long j;
        Object obj;
        String aD;
        String str3;
        byte[] b;
        String s;
        String str4;
        File file;
        int VE;
        String m;
        String m2;
        long j2;
        int c;
        g gVar;
        Object obj2;
        int c2;
        PString pString;
        PInt pInt;
        PInt pInt2;
        e b2;
        int obj22;
        String str5 = new String(bi.aD(evVar.vNO.wRo, ""));
        x.d("MicroMsg.BackupItemImg", "recover msg" + evVar.vNT + " " + str5);
        String str6 = "MicroMsg.BackupItemImg";
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
        e eVar = null;
        auVar.setContent(str5);
        g aqI = com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI();
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
        long j3 = 0;
        if (y != null) {
            j3 = bi.getLong((String) y.get(".msg.img.$hdlength"), 0);
            if (j3 > 0) {
                j = j3;
                obj = 1;
                aD = bi.aD(com.tencent.mm.plugin.backup.a.g.a(evVar, 3), "");
                if (evVar.vQY == 3 && evVar.vQW != null) {
                    com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vS(aD), aD, evVar.vQW.wRm.oz);
                }
                str2 = bi.aD(com.tencent.mm.plugin.backup.a.g.a(evVar, 2), "");
                if (evVar.vQY == 2 && evVar.vQW != null) {
                    com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vS(str2), str2, evVar.vQW.wRm.oz);
                }
                x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", aD, str2);
                if (bi.oN(str2)) {
                    str3 = str2;
                } else {
                    x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
                    str3 = aD;
                }
                b = com.tencent.mm.plugin.backup.a.g.b(evVar, 1);
                if (b != null) {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
                    str2 = com.tencent.mm.plugin.backup.a.g.vS(str3) + str3;
                    s = com.tencent.mm.a.g.s((bi.Wy() + " ").getBytes());
                    str6 = com.tencent.mm.plugin.backup.a.g.vS(s);
                    str4 = str6 + s;
                    file = new File(str6);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    VE = z.VE(str4);
                    if (VE <= 0) {
                        if (!z.a(str2, CompressFormat.JPEG, str4, VE)) {
                            x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                            return -1;
                        }
                    } else if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                        x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                        return -1;
                    } else {
                        x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + s);
                    }
                    b = com.tencent.mm.a.e.e(str4, 0, -1);
                } else {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
                }
                if (b != null) {
                    x.e("MicroMsg.BackupItemImg", "img buf is null");
                    return -1;
                }
                m = aqI.m(aD, "", "");
                m2 = aqI.m(str3, "", "");
                j2 = 0;
                if (bi.hBA != 0) {
                    c = com.tencent.mm.plugin.backup.a.g.c(evVar, 2);
                    if (obj != null) {
                        gVar = aqI;
                        str4 = aD;
                        j2 = gVar.a(b, evVar.vNT, true, str4, com.tencent.mm.plugin.backup.a.g.c(evVar, 3), str5, new PString(), new PInt(), new PInt());
                        if (!com.tencent.mm.plugin.backup.a.g.b(evVar, 3, m)) {
                            x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", m);
                            if (((long) c) == j) {
                                if (com.tencent.mm.plugin.backup.a.g.b(evVar, 3, m2)) {
                                    x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", m2);
                                } else {
                                    x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", m2);
                                    j = j2;
                                    obj22 = null;
                                    if (c > 0) {
                                        c2 = com.tencent.mm.plugin.backup.a.g.c(evVar, 3);
                                    } else {
                                        c2 = c;
                                    }
                                    pString = new PString();
                                    pInt = new PInt();
                                    pInt2 = new PInt();
                                    j3 = aqI.a(b, evVar.vNT, false, str3, c2, str5, pString, pInt, pInt2);
                                    if (!(obj22 == null || com.tencent.mm.plugin.backup.a.g.b(evVar, 2, m2))) {
                                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", m);
                                    }
                                    if (j3 <= 0) {
                                        return -1;
                                    }
                                    auVar.dV(pString.value);
                                    auVar.fd(pInt.value);
                                    auVar.fe(pInt2.value);
                                    if (j > 0) {
                                        b2 = com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().b(Long.valueOf(j3));
                                        b2.hP((int) j);
                                        com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().a(Long.valueOf(j3), b2);
                                    }
                                }
                            }
                        }
                    }
                    j = j2;
                    obj22 = 1;
                    if (c > 0) {
                        c2 = c;
                    } else {
                        c2 = com.tencent.mm.plugin.backup.a.g.c(evVar, 3);
                    }
                    pString = new PString();
                    pInt = new PInt();
                    pInt2 = new PInt();
                    j3 = aqI.a(b, evVar.vNT, false, str3, c2, str5, pString, pInt, pInt2);
                    x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", m);
                    if (j3 <= 0) {
                        return -1;
                    }
                    auVar.dV(pString.value);
                    auVar.fd(pInt.value);
                    auVar.fe(pInt2.value);
                    if (j > 0) {
                        b2 = com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().b(Long.valueOf(j3));
                        b2.hP((int) j);
                        com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().a(Long.valueOf(j3), b2);
                    }
                } else {
                    str2 = bi.hBD;
                    if (str2 == null && str2.startsWith("THUMBNAIL_DIRPATH://")) {
                        auVar.dV(str2);
                    } else {
                        auVar.dV("THUMBNAIL://" + bi.hBA);
                    }
                }
                c.i(auVar);
                return 0;
            }
        }
        j = j3;
        obj = null;
        aD = bi.aD(com.tencent.mm.plugin.backup.a.g.a(evVar, 3), "");
        com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vS(aD), aD, evVar.vQW.wRm.oz);
        str2 = bi.aD(com.tencent.mm.plugin.backup.a.g.a(evVar, 2), "");
        com.tencent.mm.a.e.a(com.tencent.mm.plugin.backup.a.g.vS(str2), str2, evVar.vQW.wRm.oz);
        x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", aD, str2);
        if (bi.oN(str2)) {
            str3 = str2;
        } else {
            x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
            str3 = aD;
        }
        b = com.tencent.mm.plugin.backup.a.g.b(evVar, 1);
        if (b != null) {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", Integer.valueOf(b.length));
        } else {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            str2 = com.tencent.mm.plugin.backup.a.g.vS(str3) + str3;
            s = com.tencent.mm.a.g.s((bi.Wy() + " ").getBytes());
            str6 = com.tencent.mm.plugin.backup.a.g.vS(s);
            str4 = str6 + s;
            file = new File(str6);
            if (file.exists()) {
                file.mkdirs();
            }
            VE = z.VE(str4);
            if (VE <= 0) {
                if (com.tencent.mm.sdk.platformtools.d.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                    x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + s);
                } else {
                    x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                    return -1;
                }
            } else if (z.a(str2, CompressFormat.JPEG, str4, VE)) {
                x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.e(str4, 0, -1);
        }
        if (b != null) {
            m = aqI.m(aD, "", "");
            m2 = aqI.m(str3, "", "");
            j2 = 0;
            if (bi.hBA != 0) {
                str2 = bi.hBD;
                if (str2 == null) {
                }
                auVar.dV("THUMBNAIL://" + bi.hBA);
            } else {
                c = com.tencent.mm.plugin.backup.a.g.c(evVar, 2);
                if (obj != null) {
                    gVar = aqI;
                    str4 = aD;
                    j2 = gVar.a(b, evVar.vNT, true, str4, com.tencent.mm.plugin.backup.a.g.c(evVar, 3), str5, new PString(), new PInt(), new PInt());
                    if (com.tencent.mm.plugin.backup.a.g.b(evVar, 3, m)) {
                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", m);
                        if (((long) c) == j) {
                            if (com.tencent.mm.plugin.backup.a.g.b(evVar, 3, m2)) {
                                x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", m2);
                            } else {
                                x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", m2);
                                j = j2;
                                obj22 = null;
                                if (c > 0) {
                                    c2 = com.tencent.mm.plugin.backup.a.g.c(evVar, 3);
                                } else {
                                    c2 = c;
                                }
                                pString = new PString();
                                pInt = new PInt();
                                pInt2 = new PInt();
                                j3 = aqI.a(b, evVar.vNT, false, str3, c2, str5, pString, pInt, pInt2);
                                x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", m);
                                if (j3 <= 0) {
                                    return -1;
                                }
                                auVar.dV(pString.value);
                                auVar.fd(pInt.value);
                                auVar.fe(pInt2.value);
                                if (j > 0) {
                                    b2 = com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().b(Long.valueOf(j3));
                                    b2.hP((int) j);
                                    com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().a(Long.valueOf(j3), b2);
                                }
                            }
                        }
                    }
                }
                j = j2;
                obj22 = 1;
                if (c > 0) {
                    c2 = c;
                } else {
                    c2 = com.tencent.mm.plugin.backup.a.g.c(evVar, 3);
                }
                pString = new PString();
                pInt = new PInt();
                pInt2 = new PInt();
                j3 = aqI.a(b, evVar.vNT, false, str3, c2, str5, pString, pInt, pInt2);
                x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", m);
                if (j3 <= 0) {
                    return -1;
                }
                auVar.dV(pString.value);
                auVar.fd(pInt.value);
                auVar.fe(pInt2.value);
                if (j > 0) {
                    b2 = com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().b(Long.valueOf(j3));
                    b2.hP((int) j);
                    com.tencent.mm.plugin.backup.g.d.aqL().aqM().aqI().a(Long.valueOf(j3), b2);
                }
            }
            c.i(auVar);
            return 0;
        }
        x.e("MicroMsg.BackupItemImg", "img buf is null");
        return -1;
    }
}
