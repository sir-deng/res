package com.tencent.mm.ap;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.e;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class h extends e {
    protected final au a(bx bxVar, String str, String str2, String str3) {
        g PC = o.PC();
        cg a = super.a(bxVar, str, str2, str3);
        if (a.field_msgId != 0) {
            return a;
        }
        long j = bxVar.vNT;
        e bi = PC.bi(j);
        if (bi.fGj == j) {
            FileOp.deleteFile(PC.m(bi.hBB, "", ""));
            FileOp.deleteFile(PC.m(bi.hBD, "", ""));
            FileOp.deleteFile(PC.m(bi.hBD, "", "") + "hd");
            PC.hiZ.delete("ImgInfo2", "msgSvrId=?", new String[]{String.valueOf(j)});
            if (bi.Pk()) {
                bi = PC.hT(bi.hBK);
                if (bi != null) {
                    FileOp.deleteFile(PC.m(bi.hBB, "", ""));
                    FileOp.deleteFile(PC.m(bi.hBD, "", ""));
                    FileOp.deleteFile(PC.m(bi.hBD, "", "") + "hd");
                    PC.hiZ.delete("ImgInfo2", "id=?", new String[]{bi.hBA});
                }
            }
        }
        if (bxVar.vNP != 2) {
            x.e("MicroMsg.ImgMsgExtension", "data type img, but has no imgstatus_hasimg ?!");
            return a;
        }
        byte[] bArr;
        int i;
        byte[] a2 = n.a(bxVar.vNQ);
        if (r.ifT) {
            x.w("MicroMsg.ImgMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
            bArr = null;
        } else {
            bArr = a2;
        }
        Map y = bj.y(a.field_content, "msg");
        long j2 = -1;
        if (!bi.oN(a.field_content)) {
            Map y2;
            x.i("MicroMsg.ImgMsgExtension", "cdntra content:[%s]", a.field_content);
            if (y == null) {
                g.pWK.a(111, 190, 1, false);
            }
            if (y != null) {
                if (bi.getInt((String) y.get(".msg.img.$hdlength"), 0) > 0) {
                    i = bxVar.vNP;
                    j = PC.a(bArr, bxVar.vNT, true, a.field_content, new PString(), new PInt(), new PInt());
                    y2 = bj.y(a.field_content, "msgoperation");
                    if (y2 != null) {
                        a.ec((String) y2.get(".msgoperation.expinfo.expidstr"));
                        a.fg(bi.getInt((String) y2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                        x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.gkM, Integer.valueOf(a.gkN));
                    }
                    j2 = j;
                }
            }
            j = -1;
            y2 = bj.y(a.field_content, "msgoperation");
            if (y2 != null) {
                a.ec((String) y2.get(".msgoperation.expinfo.expidstr"));
                a.fg(bi.getInt((String) y2.get(".msgoperation.imagemsg.downloadcontroltype"), 0));
                x.i("MicroMsg.ImgMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", a.gkM, Integer.valueOf(a.gkN));
            }
            j2 = j;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        i = bxVar.vNP;
        j = PC.a(bArr, bxVar.vNT, false, a.field_content, pString, pInt, pInt2);
        if (j > 0) {
            a.dV(pString.value);
            a.fd(pInt.value);
            a.fe(pInt2.value);
            if (j2 > 0) {
                bi = o.PC().b(Long.valueOf(j));
                bi.hP((int) j2);
                o.PC().a(Long.valueOf(j), bi);
            }
        }
        if (bi.by(bArr) && y != null) {
            String str4 = (String) y.get(".msg.img.$cdnthumbaeskey");
            final String str5 = (String) y.get(".msg.img.$cdnthumburl");
            final int i2 = bi.getInt((String) y.get(".msg.img.$cdnthumblength"), 0);
            final String m = PC.m(com.tencent.mm.a.g.s(("SERVERID://" + a.field_msgSvrId).getBytes()), "th_", "");
            j = a.field_msgSvrId;
            x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Long.valueOf(j), str, str5, m);
            final long Wy = bi.Wy();
            final String str6 = m + ".tmp";
            i iVar = new i();
            iVar.field_mediaId = d.a("downimgthumb", a.field_createTime, str, String.valueOf(j));
            iVar.field_fullpath = str6;
            iVar.field_fileType = b.MediaType_THUMBIMAGE;
            iVar.field_totalLen = i2;
            iVar.field_aesKey = str4;
            iVar.field_fileId = str5;
            iVar.field_priority = b.htv;
            iVar.field_chattype = s.eX(str) ? 1 : 0;
            x.d("MicroMsg.ImgMsgExtension", "get thumb by cdn [image] chatType[%d] fromUser[%s] ", Integer.valueOf(iVar.field_chattype), str);
            final String str7 = str;
            final cg cgVar = a;
            iVar.hve = new a() {
                public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                    if (i != 0) {
                        x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(i), Long.valueOf(j), str7, str5, m);
                        cgVar.eR(5);
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().b(cgVar.field_msgSvrId, cgVar);
                        g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Wy), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
                        g.pWK.h(13937, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Wy), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(i2), "");
                        o.PC().doNotify();
                        return 0;
                    } else if (keep_sceneresult == null) {
                        return 0;
                    } else {
                        if (keep_sceneresult.field_retCode != 0) {
                            x.e("MicroMsg.ImgMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumbUrl:%s thumbPath:%s", Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(j), str7, str5, m);
                            cgVar.eR(5);
                            if (!bi.oN(cgVar.field_talker)) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().b(cgVar.field_msgSvrId, cgVar);
                            }
                        } else {
                            new File(str6).renameTo(new File(m));
                            cgVar.eR(6);
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            com.tencent.mm.sdk.platformtools.d.c(m, pInt, pInt2);
                            cgVar.fd(pInt.value);
                            cgVar.fe(pInt2.value);
                            x.i("MicroMsg.ImgMsgExtension", "getThumbByCdn succ. sceneResult.field_retCode:%d msgSvrId:%d fromUser:%s thumb[%d,%d] thumbUrl:%s thumbPath:%s", Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(j), str7, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), str5, m);
                            if (!bi.oN(cgVar.field_talker)) {
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().b(cgVar.field_msgSvrId, cgVar);
                            }
                            g.pWK.a(198, 1, (long) i2, false);
                            g.pWK.a(198, 2, 1, false);
                            g.pWK.a(198, s.eX(str7) ? 4 : 3, 1, false);
                        }
                        g gVar = g.pWK;
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(keep_sceneresult == null ? i : keep_sceneresult.field_retCode);
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = Long.valueOf(Wy);
                        objArr[3] = Long.valueOf(bi.Wy());
                        objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                        objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                        objArr[6] = Integer.valueOf(i2);
                        objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                        gVar.h(10421, objArr);
                        if (!(keep_sceneresult == null || keep_sceneresult.field_retCode == 0)) {
                            gVar = g.pWK;
                            objArr = new Object[16];
                            if (keep_sceneresult != null) {
                                i = keep_sceneresult.field_retCode;
                            }
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(Wy);
                            objArr[3] = Long.valueOf(bi.Wy());
                            objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                            objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                            objArr[6] = Integer.valueOf(i2);
                            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                            objArr[8] = "";
                            objArr[9] = "";
                            objArr[10] = "";
                            objArr[11] = "";
                            objArr[12] = "";
                            objArr[13] = "";
                            objArr[14] = "";
                            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                            gVar.h(13937, objArr);
                        }
                        o.PC().doNotify();
                        return 0;
                    }
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] h(String str, byte[] bArr) {
                    return null;
                }
            };
            a.eR(4);
            com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
        }
        return a;
    }

    public final void h(au auVar) {
        o.PC().o(auVar);
    }
}
