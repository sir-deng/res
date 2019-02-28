package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import java.io.File;

public final class l {
    private static ab vle;

    public interface a {
        void ey(int i, int i2);
    }

    public static boolean Sl(String str) {
        if (bi.oN(str) || str.equals("0:0")) {
            return false;
        }
        return true;
    }

    public static void fr(long j) {
        c fp = an.aqK().fp(j);
        if (fp != null) {
            boolean deleteFile = b.deleteFile(fp.field_fileFullPath);
            boolean a = an.aqK().a(fp, "msgInfoId");
            x.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(fp.field_msgInfoId), fp.field_mediaSvrId, fp.field_fileFullPath, bi.chl());
        }
    }

    public static void fs(long j) {
        c aqK = an.aqK();
        aqK.gLA.fD("appattach", " update appattach set status = 198" + " , lastModifyTime = " + bi.Wx() + " where rowid = " + j);
        aqK.doNotify();
        c bVar = new b();
        an.aqK().b(j, bVar);
        if (bVar.field_msgInfoId > 0) {
            as.Hm();
            au dI = com.tencent.mm.y.c.Fh().dI(bVar.field_msgInfoId);
            if (dI.field_msgId == bVar.field_msgInfoId) {
                dI.eR(5);
                as.Hm();
                com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
            }
        }
    }

    public static int Sm(String str) {
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
        if (fV == null) {
            return -1;
        }
        if (!Sl(fV.for)) {
            return -1;
        }
        b bVar = new b();
        long j = bi.getLong(fV.for, -1);
        if (j != -1) {
            an.aqK().b(j, (c) bVar);
            if (bVar.xrR != j) {
                bVar = an.aqK().Se(fV.for);
                if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
                    return -1;
                }
            }
        }
        bVar = an.aqK().Se(fV.for);
        if (bVar == null || !bVar.field_mediaSvrId.equals(fV.for)) {
            return -1;
        }
        if (bVar.field_totalLen == 0) {
            return -1;
        }
        return (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
    }

    public static String c(long j, String str, String str2) {
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, str2);
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
        if (fV == null) {
            return null;
        }
        String str3;
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = ad(e.gJd, fV.title, fV.hcN);
        }
        if (bi.oN(fV.for) && !bi.oN(fV.hcT)) {
            fV.for = fV.hcT.hashCode();
        }
        int i = fV.sdkVer;
        String str4 = fV.appId;
        String str5 = fV.for;
        int i2 = fV.hcM;
        int i3 = fV.type;
        String str6 = fV.hda;
        return a(str3, j, i, str4, str5, i2, i3, fV.hcQ);
    }

    public static void a(au auVar, final a aVar) {
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
        if (fV == null) {
            x.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", auVar.field_content);
            return;
        }
        if (bi.oN(fV.for) && !bi.oN(fV.hcT)) {
            x.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", auVar.field_content);
            fV.for = fV.hcT.hashCode();
        }
        String str = fV.for;
        if (!a(auVar, aj(str, auVar.field_msgId)) && e(str, auVar)) {
            vle = new ab(auVar.field_msgId, str, new f() {
                public final void a(int i, int i2, k kVar) {
                    if (aVar != null) {
                        aVar.ey(i, i2);
                    }
                }
            });
            as.CN().a(vle, 0);
        }
    }

    public static boolean a(au auVar, b bVar) {
        if (bVar == null || !new File(bVar.field_fileFullPath).exists()) {
            return false;
        }
        if (bVar.aPj() || (auVar.field_isSend == 1 && bVar.field_isUpload)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str, au auVar) {
        if (auVar == null) {
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        b aj = aj(str, auVar.field_msgId);
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
        if (aj != null) {
            String str7 = aj.field_fileFullPath;
        }
        if (fV != null) {
            str2 = t.oM(fV.title);
            str3 = t.oM(fV.hcN).toLowerCase();
            str4 = t.oM(fV.filemd5);
            str5 = t.oM(fV.fAJ);
            str6 = t.oM(fV.hda);
        }
        String str8;
        if (aj == null) {
            c(auVar.field_msgId, auVar.field_content, null);
            aj = aj(str, auVar.field_msgId);
            if (aj != null) {
                str8 = "MicroMsg.AppMsgLogic";
                String str9 = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(aj.xrR);
                objArr[1] = Long.valueOf(aj.field_totalLen);
                objArr[2] = aj.field_fileFullPath;
                objArr[3] = Long.valueOf(aj.field_type);
                objArr[4] = aj.field_mediaId;
                objArr[5] = Long.valueOf(aj.field_msgInfoId);
                objArr[6] = Boolean.valueOf(aj.field_isUpload);
                objArr[7] = Integer.valueOf(aj.field_signature == null ? -1 : aj.field_signature.length());
                x.i(str8, str9, objArr);
                if (fV != null && (fV.hcQ != 0 || fV.hcM > 26214400)) {
                    boolean z2;
                    if (t.oN(aj.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
        } else {
            File file = new File(aj.field_fileFullPath);
            if (aj.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                c(auVar.field_msgId, auVar.field_content, null);
            }
            String str10 = "MicroMsg.AppMsgLogic";
            str8 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(aj.xrR);
            objArr2[1] = Long.valueOf(aj.field_totalLen);
            objArr2[2] = aj.field_fileFullPath;
            objArr2[3] = Long.valueOf(aj.field_type);
            objArr2[4] = aj.field_mediaId;
            objArr2[5] = Long.valueOf(aj.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(aj.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(aj.field_status);
            objArr2[9] = Integer.valueOf(aj.field_signature == null ? -1 : aj.field_signature.length());
            x.i(str10, str8, objArr2);
        }
        if (!z) {
            as.CN().a(new y(aj, str6, str4, str2, str3, str5), 0);
        }
        return z;
    }

    public static b aj(String str, long j) {
        b Sn = Sn(str);
        if (Sn == null) {
            Sn = an.aqK().fp(j);
        }
        if (Sn != null) {
            x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", Sn, Long.valueOf(Sn.xrR), Boolean.valueOf(Sn.field_isUpload), Sn.field_fileFullPath, Long.valueOf(Sn.field_totalLen), Long.valueOf(Sn.field_offset), Sn.field_mediaSvrId, Sn.field_mediaId, Long.valueOf(Sn.field_msgInfoId), Long.valueOf(Sn.field_type), t.WB());
        } else {
            x.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", t.WB());
        }
        return Sn;
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        c bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bi.Wy();
        bVar.field_lastModifyTime = bi.Wx();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(an.aqK().b(bVar)), Long.valueOf(bVar.xrR), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bi.chl());
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bi.Wy();
        bVar.field_lastModifyTime = bi.Wx();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        return bVar;
    }

    public static b a(String str, com.tencent.mm.x.g.a aVar, String str2) {
        x.i("MicroMsg.AppMsgLogic", g.zo() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(e.hbu)) {
            x.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            return null;
        }
        c bVar = new b();
        bVar.field_totalLen = (long) aVar.hcM;
        bVar.field_fileFullPath = str2;
        bVar.field_sdkVer = (long) aVar.sdkVer;
        bVar.field_appId = aVar.appId;
        bVar.field_clientAppDataId = str;
        bVar.field_type = (long) aVar.type;
        bVar.field_status = 200;
        bVar.field_isUpload = true;
        bVar.field_createTime = bi.Wy();
        bVar.field_lastModifyTime = bi.Wx();
        bVar.field_mediaSvrId = bi.Wy();
        an.aqK().b(bVar);
        x.d("MicroMsg.AppMsgLogic", g.zo() + " summerbig buildUploadAttachInfo file:" + bVar.field_fileFullPath + " rowid:" + bVar.xrR + " clientAppDataId:" + bVar.field_clientAppDataId);
        if (bVar.xrR >= 0) {
            return bVar;
        }
        x.e("MicroMsg.AppMsgLogic", g.zo() + " summerbig uploadAttach insert appattach info failed :" + bVar.xrR);
        return null;
    }

    public static int a(long j, String str, keep_SceneResult keep_sceneresult) {
        as.Hm();
        au dI = com.tencent.mm.y.c.Fh().dI(j);
        if (dI.field_msgId != j) {
            x.e("MicroMsg.AppMsgLogic", g.zo() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI.field_content);
        if (fV == null) {
            x.e("MicroMsg.AppMsgLogic", g.zo() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        fV.for = str;
        dI.setContent(com.tencent.mm.x.g.a.a(fV, fV.for, keep_sceneresult));
        as.Hm();
        com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
        c fq = an.bZF().fq(j);
        if (fq != null) {
            fq.field_xml = dI.field_content;
            an.bZF().c(fq, "msgId");
        }
        c fp = an.aqK().fp(j);
        fp.field_mediaSvrId = str;
        fp.field_offset = fp.field_totalLen;
        an.aqK().c(fp, new String[0]);
        return 0;
    }

    public static int a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
        return a(aVar, str, str2, str3, str4, bArr, null);
    }

    public static int a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        return a(aVar, str, str2, str3, str4, bArr, str5, "");
    }

    public static String ad(String str, String str2, String str3) {
        String str4;
        if (bi.oN(str2)) {
            str4 = str + "da_" + bi.Wy();
        } else {
            str4 = str + str2;
            if (com.tencent.mm.a.e.bO(str4)) {
                File file = new File(str + "/" + bi.Wy());
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                str4 = file.getAbsolutePath() + "/" + str2;
            }
        }
        if (!(bi.oN(str3) || str4.endsWith(str3))) {
            str4 = str4 + "." + str3;
        }
        try {
            if (new File(str4).getCanonicalPath().equalsIgnoreCase(str4)) {
                return str4;
            }
            x.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", str + "da_" + bi.Wy());
            return str + "da_" + bi.Wy();
        } catch (Exception e) {
            return str + "da_" + bi.Wy();
        }
    }

    public static int a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, aVar);
        c cVar = null;
        String str7 = System.currentTimeMillis();
        if (!bi.oN(str4)) {
            cVar = a(str7, aVar, str4);
            if (cVar == null) {
                return 0 - g.getLine();
            }
        }
        cg auVar = new au();
        if (bArr != null && bArr.length > 0) {
            if (aVar.type == 33 || aVar.type == 36) {
                str7 = o.PC().a(bArr, CompressFormat.JPEG, (int) (d.cfC().density * 240.0f), (int) (d.cfC().density * 240.0f));
            } else {
                str7 = o.PC().a(6, bArr, aVar.type == 2, CompressFormat.PNG);
            }
            x.d("MicroMsg.AppMsgLogic", g.zo() + " thumbData MsgInfo path:" + str7);
            if (!bi.oN(str7)) {
                auVar.dV(str7);
                x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str7);
            }
        }
        if (cVar != null) {
            aVar.for = cVar.xrR;
        }
        auVar.setContent(com.tencent.mm.x.g.a.a(aVar, null, null));
        auVar.eR(1);
        auVar.dU(str3);
        auVar.aq(bb.hU(str3));
        auVar.eS(1);
        auVar.setType(d(aVar));
        if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
            auVar.ea(com.tencent.mm.af.a.e.HJ());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar.gkD);
        }
        as.Hm();
        long Q = com.tencent.mm.y.c.Fh().Q(auVar);
        x.d("MicroMsg.AppMsgLogic", g.zo() + " msginfo insert id: " + Q);
        if (Q < 0) {
            x.e("MicroMsg.AppMsgLogic", g.zo() + "insert msg failed :" + Q);
            return 0 - g.getLine();
        }
        x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
        auVar.ao(Q);
        c gVar = new com.tencent.mm.x.g();
        gVar.field_xml = auVar.field_content;
        gVar.field_appId = str;
        gVar.field_title = aVar.title;
        gVar.field_type = aVar.type;
        gVar.field_description = aVar.description;
        gVar.field_msgId = Q;
        gVar.field_source = str2;
        an.bZF().b(gVar);
        String str8 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(cVar == null);
        x.i(str8, str9, objArr);
        if (cVar != null) {
            cVar.field_msgInfoId = Q;
            cVar.field_status = 101;
            an.aqK().c(cVar, new String[0]);
            if (aVar.type == 2 || !bi.oN(str5)) {
                an.bZH().t(Q, str5);
            }
            an.bZH().run();
        } else {
            an.bZH();
            com.tencent.mm.pluginsdk.model.app.am.a.d(Q, str5, str6);
        }
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        return a(wXMediaMessage, str, str2, str3, i, str4, null);
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
        aVar.appId = str;
        aVar.appName = str2;
        aVar.hcP = i;
        return a(aVar, wXMediaMessage, str3, str4, str5);
    }

    public static int a(com.tencent.mm.x.g.a aVar, WXMediaMessage wXMediaMessage, String str) {
        return a(aVar, wXMediaMessage, str, null, null);
    }

    private static int a(com.tencent.mm.x.g.a aVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        c cVar;
        c a;
        String f;
        String b = b(aVar, wXMediaMessage, str2);
        x.d("MicroMsg.AppMsgLogic", g.zo() + "summerbig content url:" + aVar.url + " lowUrl:" + aVar.hcL + " attachlen:" + aVar.hcM + " attachid:" + aVar.for + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (bi.oN(b)) {
            cVar = null;
        } else {
            a = a(str4, aVar, b);
            if (a == null) {
                return 0 - g.getLine();
            }
            Options Vq = d.Vq(b);
            if (Vq != null) {
                aVar.hcZ = Vq.outWidth;
                aVar.hcY = Vq.outHeight;
            }
            cVar = a;
        }
        cg auVar = new au();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            if (wXMediaMessage.thumbData.length <= WXMediaMessage.THUMB_LENGTH_LIMIT || wXMediaMessage.getType() == 36) {
                f = o.PC().f(6, wXMediaMessage.thumbData);
            } else {
                f = o.PC().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.JPEG);
            }
            x.d("MicroMsg.AppMsgLogic", g.zo() + " summerbig thumbData MsgInfo path:" + f);
            if (!bi.oN(f)) {
                auVar.dV(f);
            }
        }
        if (cVar != null) {
            aVar.for = cVar.xrR;
        }
        for (String f2 : bi.F(str.split(","))) {
            aVar.hcO = str2;
            auVar.setContent(com.tencent.mm.x.g.a.a(aVar, null, null));
            auVar.eR(1);
            auVar.dU(f2);
            auVar.aq(bb.hU(f2));
            auVar.eS(1);
            auVar.setType(d(aVar));
            if (com.tencent.mm.af.f.eG(auVar.field_talker)) {
                auVar.ea(com.tencent.mm.af.a.e.HJ());
            }
            as.Hm();
            long Q = com.tencent.mm.y.c.Fh().Q(auVar);
            if (Q < 0) {
                x.e("MicroMsg.AppMsgLogic", g.zo() + " summerbig insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " summerbig new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            a = new com.tencent.mm.x.g();
            a.field_xml = auVar.field_content;
            a.field_title = wXMediaMessage.title;
            a.field_type = wXMediaMessage.mediaObject.type();
            a.field_description = wXMediaMessage.description;
            a.field_msgId = Q;
            a.field_source = aVar.appName;
            an.bZF().b(a);
            if (cVar != null) {
                cVar.field_msgInfoId = Q;
                cVar.field_status = 101;
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(cVar.field_msgInfoId), Long.valueOf(cVar.field_status), Long.valueOf(cVar.xrR), Integer.valueOf(a.field_type));
                an.aqK().c(cVar, new String[0]);
                if (!bi.oN(str3)) {
                    an.bZH().t(cVar.field_msgInfoId, str3);
                }
                an.bZH().run();
            } else {
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", cVar, Long.valueOf(Q), str3, Integer.valueOf(a.field_type));
                an.bZH();
                com.tencent.mm.pluginsdk.model.app.am.a.u(Q, str3);
            }
        }
        return 0;
    }

    public static String bd(byte[] bArr) {
        if (bi.by(bArr)) {
            x.e("MicroMsg.AppMsgLogic", g.zo() + " attachBuf is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.y.c.FB()).append("ua_").append(bi.Wy()).toString();
        x.d("MicroMsg.AppMsgLogic", g.zo() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (com.tencent.mm.a.e.b(stringBuilder2, bArr, bArr.length) == 0) {
            return stringBuilder2;
        }
        x.e("MicroMsg.AppMsgLogic", g.zo() + " writeFile error file:" + stringBuilder2);
        return null;
    }

    public static String b(com.tencent.mm.x.g.a aVar, WXMediaMessage wXMediaMessage, String str) {
        x.d("MicroMsg.AppMsgLogic", g.zo() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        aVar.sdkVer = wXMediaMessage.sdkVer;
        aVar.title = wXMediaMessage.title;
        aVar.description = wXMediaMessage.description;
        aVar.mediaTagName = wXMediaMessage.mediaTagName;
        aVar.messageAction = wXMediaMessage.messageAction;
        aVar.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        aVar.type = iMediaObject.type();
        if (aVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            aVar.extInfo = wXAppExtendObject.extInfo;
            if (bi.by(wXAppExtendObject.fileData)) {
                aVar.hcM = com.tencent.mm.a.e.bN(wXAppExtendObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.zo() + " read file:" + wXAppExtendObject.filePath + " len:" + aVar.hcM);
                if (aVar.hcM <= 0) {
                    return null;
                }
                aVar.hcN = com.tencent.mm.a.e.bQ(wXAppExtendObject.filePath);
                return wXAppExtendObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.zo() + " fileData:" + wXAppExtendObject.fileData.length);
            aVar.hcM = wXAppExtendObject.fileData.length;
            return bd(wXAppExtendObject.fileData);
        } else if (aVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (bi.by(wXFileObject.fileData)) {
                aVar.hcM = com.tencent.mm.a.e.bN(wXFileObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.zo() + " read file:" + wXFileObject.filePath + " len:" + aVar.hcM);
                if (aVar.hcM <= 0) {
                    return null;
                }
                aVar.hcN = com.tencent.mm.a.e.bQ(wXFileObject.filePath);
                return wXFileObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.zo() + " fileData:" + wXFileObject.fileData.length);
            aVar.hcM = wXFileObject.fileData.length;
            return bd(wXFileObject.fileData);
        } else if (aVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!bi.by(wXImageObject.imageData)) {
                x.d("MicroMsg.AppMsgLogic", g.zo() + " fileData:" + wXImageObject.imageData.length);
                aVar.hcM = wXImageObject.imageData.length;
                return bd(wXImageObject.imageData);
            } else if (bi.oN(wXImageObject.imagePath)) {
                return null;
            } else {
                aVar.hcM = com.tencent.mm.a.e.bN(wXImageObject.imagePath);
                x.d("MicroMsg.AppMsgLogic", g.zo() + " read file:" + wXImageObject.imagePath + " len:" + aVar.hcM);
                if (aVar.hcM <= 0) {
                    return null;
                }
                aVar.hcN = com.tencent.mm.a.e.bQ(wXImageObject.imagePath);
                as.Hm();
                String absolutePath = new File(com.tencent.mm.y.c.FB(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
                Options Vq = d.Vq(wXImageObject.imagePath);
                if (Vq == null || Vq.outWidth <= 0 || Vq.outHeight <= 0) {
                    boolean z;
                    String str2 = "MicroMsg.AppMsgLogic";
                    String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                    Object[] objArr = new Object[3];
                    if (Vq == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Integer.valueOf(Vq == null ? -1 : Vq.outWidth);
                    objArr[2] = Integer.valueOf(Vq == null ? -1 : Vq.outHeight);
                    x.e(str2, str3, objArr);
                    return null;
                } else if (q.a(wXImageObject.imagePath, "", true)) {
                    x.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, absolutePath);
                    if (com.tencent.mm.a.e.x(wXImageObject.imagePath, absolutePath) >= 0) {
                        return absolutePath;
                    }
                    x.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, absolutePath);
                    return null;
                } else {
                    if (Vq.outWidth > 960 || Vq.outHeight > 960) {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        Bitmap a = d.a(wXImageObject.imagePath, 960, 960, false, decodeResultLogger, 0);
                        if (a != null) {
                            try {
                                d.a(a, 100, CompressFormat.JPEG, absolutePath, true);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                return null;
                            }
                        }
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.pWK.k(12712, KVStatHelper.getKVStatString(wXImageObject.imagePath, 6, decodeResultLogger));
                        }
                        return null;
                    } else if (com.tencent.mm.a.e.x(wXImageObject.imagePath, absolutePath) < 0) {
                        return null;
                    }
                    return absolutePath;
                }
            }
        } else if (aVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            aVar.url = wXMusicObject.musicUrl;
            aVar.hcL = wXMusicObject.musicLowBandUrl;
            aVar.hdd = wXMusicObject.musicDataUrl;
            aVar.hde = wXMusicObject.musicLowBandDataUrl;
            return null;
        } else if (aVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            aVar.url = wXVideoObject.videoUrl;
            aVar.hcL = wXVideoObject.videoLowBandUrl;
            return null;
        } else if (aVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            aVar.url = wXWebpageObject.webpageUrl;
            if (!bi.oN(wXWebpageObject.extInfo)) {
                aVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!bi.oN(wXWebpageObject.canvasPageXml)) {
                aVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            return null;
        } else {
            WXEmojiSharedObject wXEmojiSharedObject;
            if (aVar.type == 36) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                aVar.hfi = wXMiniProgramObject.userName;
                aVar.hfh = wXMiniProgramObject.path;
                aVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(wXMiniProgramObject.userName);
                if (rf != null) {
                    if (rf.acs() != null) {
                        aVar.hfq = rf.acs().fJh;
                    }
                    aVar.hfr = rf.field_brandIconURL;
                    x.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(aVar.hfq), aVar.hfr);
                }
            } else if (aVar.type == 1) {
                aVar.title = ((WXTextObject) iMediaObject).text;
                return null;
            } else if (aVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!bi.by(wXEmojiObject.emojiData)) {
                    x.d("MicroMsg.AppMsgLogic", g.zo() + " fileData:" + wXEmojiObject.emojiData.length);
                    aVar.hcM = wXEmojiObject.emojiData.length;
                    return bd(wXEmojiObject.emojiData);
                } else if (bi.oN(wXEmojiObject.emojiPath)) {
                    aVar.hcO = str;
                } else {
                    aVar.hcM = com.tencent.mm.a.e.bN(wXEmojiObject.emojiPath);
                    x.d("MicroMsg.AppMsgLogic", g.zo() + " read file:" + wXEmojiObject.emojiPath + " len:" + aVar.hcM);
                    if (aVar.hcM <= 0) {
                        return null;
                    }
                    aVar.hcN = com.tencent.mm.a.e.bQ(wXEmojiObject.emojiPath);
                    return wXEmojiObject.emojiPath;
                }
            } else if (aVar.type == 15) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiSharedObject.thumburl;
                aVar.hdq = wXEmojiSharedObject.packageflag;
                aVar.hdp = wXEmojiSharedObject.packageid;
                aVar.showType = 8;
                aVar.url = wXEmojiSharedObject.url;
                return null;
            } else if (aVar.type == 13) {
                wXEmojiSharedObject = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiSharedObject.thumburl;
                aVar.hdq = wXEmojiSharedObject.packageflag;
                aVar.hdp = wXEmojiSharedObject.packageid;
                aVar.showType = 8;
                aVar.url = wXEmojiSharedObject.url;
                return null;
            } else if (aVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                aVar.thumburl = wXDesignerSharedObject.thumburl;
                aVar.url = wXDesignerSharedObject.url;
                aVar.heW = wXDesignerSharedObject.designerUIN;
                aVar.designerName = wXDesignerSharedObject.designerName;
                aVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                aVar.showType = 18;
                return null;
            } else if (aVar.type == 27 || aVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                aVar.url = wXEmojiPageSharedObject.url;
                aVar.tid = wXEmojiPageSharedObject.tid;
                aVar.heX = wXEmojiPageSharedObject.title;
                aVar.desc = wXEmojiPageSharedObject.desc;
                aVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                aVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                aVar.pageType = wXEmojiPageSharedObject.pageType;
                aVar.showType = 20;
                return null;
            }
            return null;
        }
    }

    public static b Sn(String str) {
        c bVar = new b();
        if (bi.oN(str)) {
            return null;
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j = bi.getLong(str, -1);
        if (j != -1) {
            an.aqK().b(j, bVar);
            if (bVar.xrR != j) {
                bVar = an.aqK().Se(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = an.aqK().Se(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j));
        return bVar;
    }

    public static void aa(au auVar) {
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
        if (fV == null) {
            x.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            return;
        }
        String B;
        byte[] d;
        com.tencent.mm.x.g.a a;
        String str;
        String str2;
        c a2;
        cg auVar2;
        long Q;
        com.tencent.mm.sdk.b.b ryVar;
        c gVar;
        b Sn = Sn(fV.for);
        String str3 = "";
        if (!(Sn == null || Sn.field_fileFullPath == null || Sn.field_fileFullPath.equals(""))) {
            as.Hm();
            str3 = ad(com.tencent.mm.y.c.FB(), fV.title, fV.hcN);
            com.tencent.mm.sdk.platformtools.k.r(Sn.field_fileFullPath, str3, false);
        }
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            B = o.PC().B(auVar.field_imgPath, true);
            try {
                d = com.tencent.mm.a.e.d(B, 0, com.tencent.mm.a.e.bN(B));
            } catch (Exception e) {
            }
            a = com.tencent.mm.x.g.a.a(fV);
            str = fV.appId;
            str = fV.appName;
            str2 = System.currentTimeMillis();
            if (bi.oN(str3)) {
                a2 = a(str2, a, str3);
                if (a2 == null) {
                    g.getLine();
                    return;
                }
            }
            a2 = null;
            auVar2 = new au();
            if (d != null && d.length > 0) {
                B = o.PC().a(6, d, a.type != 2, CompressFormat.PNG);
                x.d("MicroMsg.AppMsgLogic", g.zo() + " thumbData MsgInfo path:" + B);
                if (!bi.oN(B)) {
                    auVar2.dV(B);
                    x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + B);
                }
            }
            if (a2 != null) {
                a.for = a2.xrR;
            }
            auVar2.setContent(com.tencent.mm.x.g.a.a(a, null, null));
            auVar2.eR(1);
            auVar2.dU(auVar.field_talker);
            auVar2.aq(bb.hU(auVar.field_talker));
            auVar2.eS(1);
            auVar2.setType(d(a));
            if (com.tencent.mm.af.f.eG(auVar2.field_talker)) {
                auVar2.ea(com.tencent.mm.af.a.e.HJ());
                x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gkD);
            }
            as.Hm();
            Q = com.tencent.mm.y.c.Fh().Q(auVar2);
            x.d("MicroMsg.AppMsgLogic", g.zo() + " msginfo insert id: " + Q);
            if (Q >= 0) {
                x.e("MicroMsg.AppMsgLogic", g.zo() + "insert msg failed :" + Q);
                g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar2.ao(Q);
            ryVar = new ry();
            ryVar.fKy.fKz = auVar.field_msgId;
            ryVar.fKy.fKA = Q;
            com.tencent.mm.sdk.b.a.xmy.m(ryVar);
            gVar = new com.tencent.mm.x.g();
            gVar.field_xml = auVar2.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            gVar.field_source = str;
            an.bZF().b(gVar);
            if (a2 == null) {
                a2.field_msgInfoId = Q;
                a2.field_status = 101;
                an.aqK().c(a2, new String[0]);
                an.bZH().run();
                return;
            }
            an.bZH();
            com.tencent.mm.pluginsdk.model.app.am.a.fu(Q);
            return;
        }
        d = null;
        a = com.tencent.mm.x.g.a.a(fV);
        str = fV.appId;
        str = fV.appName;
        str2 = System.currentTimeMillis();
        if (bi.oN(str3)) {
            a2 = null;
        } else {
            a2 = a(str2, a, str3);
            if (a2 == null) {
                g.getLine();
                return;
            }
        }
        auVar2 = new au();
        if (a.type != 2) {
        }
        B = o.PC().a(6, d, a.type != 2, CompressFormat.PNG);
        x.d("MicroMsg.AppMsgLogic", g.zo() + " thumbData MsgInfo path:" + B);
        if (bi.oN(B)) {
            auVar2.dV(B);
            x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + B);
        }
        if (a2 != null) {
            a.for = a2.xrR;
        }
        auVar2.setContent(com.tencent.mm.x.g.a.a(a, null, null));
        auVar2.eR(1);
        auVar2.dU(auVar.field_talker);
        auVar2.aq(bb.hU(auVar.field_talker));
        auVar2.eS(1);
        auVar2.setType(d(a));
        if (com.tencent.mm.af.f.eG(auVar2.field_talker)) {
            auVar2.ea(com.tencent.mm.af.a.e.HJ());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gkD);
        }
        as.Hm();
        Q = com.tencent.mm.y.c.Fh().Q(auVar2);
        x.d("MicroMsg.AppMsgLogic", g.zo() + " msginfo insert id: " + Q);
        if (Q >= 0) {
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar2.ao(Q);
            ryVar = new ry();
            ryVar.fKy.fKz = auVar.field_msgId;
            ryVar.fKy.fKA = Q;
            com.tencent.mm.sdk.b.a.xmy.m(ryVar);
            gVar = new com.tencent.mm.x.g();
            gVar.field_xml = auVar2.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            gVar.field_source = str;
            an.bZF().b(gVar);
            if (a2 == null) {
                an.bZH();
                com.tencent.mm.pluginsdk.model.app.am.a.fu(Q);
                return;
            }
            a2.field_msgInfoId = Q;
            a2.field_status = 101;
            an.aqK().c(a2, new String[0]);
            an.bZH().run();
            return;
        }
        x.e("MicroMsg.AppMsgLogic", g.zo() + "insert msg failed :" + Q);
        g.getLine();
    }

    public static int d(com.tencent.mm.x.g.a aVar) {
        if (aVar == null) {
            return 49;
        }
        int i = aVar.type;
        int i2 = aVar.showType;
        int i3 = aVar.hdf;
        int i4 = aVar.hdg;
        int i5 = aVar.heB;
        x.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            return 318767153;
        }
        if (i != 2001) {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        return -1879048185;
                    }
                    return 285212721;
                case 2:
                    if (i != 21) {
                        return 301989937;
                    }
                    return -1879048183;
                case 3:
                    if (i == 21) {
                        return -1879048176;
                    }
                    return -1879048189;
                case 4:
                    if (i != 21) {
                        return -1879048190;
                    }
                    return -1879048183;
                case 5:
                    return -1879048191;
                case 17:
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            return 16777265;
                        case 2:
                            return 268435505;
                        case 8:
                            return 1048625;
                        case 10:
                            return 335544369;
                        case 13:
                            return 369098801;
                        case 16:
                            return 452984881;
                        case 17:
                            return -1879048186;
                        case 20:
                            return 402653233;
                        case 33:
                            com.tencent.mm.x.a aVar2 = (com.tencent.mm.x.a) aVar.r(com.tencent.mm.x.a.class);
                            if (aVar2 != null && aVar2.hck && (aVar.hfk == 2 || aVar.hfk == 3)) {
                                return 553648177;
                            }
                        case 34:
                            return 520093745;
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            return 419430449;
                    }
                    return 49;
            }
        } else if (i2 == 1) {
            return 469762097;
        } else {
            if (i5 == 4) {
                return 503316529;
            }
            return 436207665;
        }
    }

    public static int BY(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 335544369:
            case 402653233:
            case 419430449:
            case 553648177:
                return 49;
            default:
                return i;
        }
    }
}
