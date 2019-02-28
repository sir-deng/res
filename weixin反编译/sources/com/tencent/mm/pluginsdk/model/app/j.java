package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.ai;
import com.tencent.mm.f.a.bs;
import com.tencent.mm.f.a.g;
import com.tencent.mm.f.a.mk;
import com.tencent.mm.f.a.mm;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.f.a.sn;
import com.tencent.mm.f.a.so;
import com.tencent.mm.f.a.tj;
import com.tencent.mm.f.a.ts;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.k;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j implements d {
    a vkZ = null;

    public interface a {
        void bZy();
    }

    public static String c(bx bxVar) {
        String a = n.a(bxVar.vNM);
        String a2 = n.a(bxVar.vNN);
        if (!bi.oN(a) && !bi.oN(a2)) {
            return fk(a, n.a(bxVar.vNO));
        }
        x.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
        return null;
    }

    public static String fk(String str, String str2) {
        if (bi.oN(str2)) {
            return null;
        }
        if (s.eX(str)) {
            int hR = bb.hR(str2);
            if (hR != -1) {
                str2 = (str2 + " ").substring(hR + 2).trim();
            }
        }
        return bi.Wn(str2);
    }

    public final b b(com.tencent.mm.ad.d.a aVar) {
        x.d("MicroMsg.AppMessageExtension", "process add app message");
        bx bxVar = aVar.hoa;
        String c = c(bxVar);
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(c);
        if (fV == null) {
            x.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            return null;
        } else if (fV.hey) {
            as.Hm();
            c.Db().set(352273, c);
            as.Hm();
            c.Db().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(c).bZp();
            return null;
        } else {
            String str;
            f Sk = an.biT().Sk(fV.appId);
            String str2 = "MicroMsg.AppMessageExtension";
            String str3 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = fV.appId;
            objArr[1] = Integer.valueOf(fV.fJh);
            if (Sk == null) {
                str = "null";
            } else {
                str = Integer.valueOf(Sk.field_appVersion);
            }
            objArr[2] = str;
            x.i(str2, str3, objArr);
            if (Sk == null || Sk.field_appVersion < fV.fJh) {
                an.biS().Si(fV.appId);
            }
            b a = a(aVar, n.a(bxVar.vNO), fV);
            if (a.fou == null) {
                return null;
            }
            cg cgVar = a.fou;
            if (cgVar.cjK()) {
                if (!bi.oN(fV.hfs)) {
                    com.tencent.mm.sdk.b.b tsVar = new ts();
                    tsVar.fNg.fDn = fV.hfs;
                    com.tencent.mm.sdk.b.a.xmy.m(tsVar);
                }
                return a;
            } else if (cgVar.getType() == 301989937) {
                return a;
            } else {
                com.tencent.mm.sdk.b.b soVar;
                if (cgVar.getType() == -1879048190) {
                    soVar = new so();
                    soVar.fLd.fDn = c;
                    soVar.fLd.description = fV.description;
                    soVar.fLd.fou = cgVar;
                    com.tencent.mm.sdk.b.a.xmy.m(soVar);
                }
                if (cgVar.getType() == 49 && !bi.oN(fV.canvasPageXml)) {
                    soVar = new g();
                    soVar.fnM.fnN = fV.canvasPageXml;
                    com.tencent.mm.sdk.b.a.xmy.m(soVar);
                }
                com.tencent.mm.x.g gVar = new com.tencent.mm.x.g();
                fV.a(gVar);
                gVar.field_msgId = cgVar.field_msgId;
                if (!an.bZF().b((com.tencent.mm.sdk.e.c) gVar)) {
                    return null;
                }
                if (fV.type == 40) {
                    b fp = an.aqK().fp(cgVar.field_msgId);
                    k fZ = k.fZ(c);
                    if (fp == null) {
                        l.a(null, cgVar.field_msgId, 0, null, null, fZ.hfK, fV.type, 0);
                    }
                    as.CN().a(new ab(cgVar.field_msgId, cgVar.field_msgSvrId, null), 0);
                }
                return a;
            }
        }
    }

    static String a(byte[] bArr, boolean z, boolean z2) {
        return o.PC().a(9, bArr, z, CompressFormat.PNG, z2);
    }

    private b a(com.tencent.mm.ad.d.a aVar, String str, com.tencent.mm.x.g.a aVar2) {
        String str2;
        cg cgVar;
        com.tencent.mm.ap.a.a PG;
        String str3;
        com.tencent.mm.ap.a.a.c.a aVar3;
        int i;
        au auVar;
        cg auVar2;
        com.tencent.mm.sdk.b.b aiVar;
        String[] split;
        bb.b hW;
        b bVar;
        Map y;
        String oM;
        com.tencent.mm.x.b bVar2;
        com.tencent.mm.sdk.b.b mmVar;
        Map map;
        long currentTimeMillis;
        com.tencent.mm.sdk.b.b bsVar;
        int i2;
        String oM2;
        bx bxVar = aVar.hoa;
        as.Hm();
        com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = c.Fh();
        as.Hm();
        f Fn = c.Fn();
        String FY = q.FY();
        final String a = n.a(bxVar.vNM);
        String a2 = n.a(bxVar.vNN);
        Object obj = (Fn.has(a) || FY.equals(a)) ? 1 : null;
        if (obj != null) {
            str2 = a2;
        } else {
            str2 = a;
        }
        cg G = Fh.G(str2, bxVar.vNT);
        x.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
        if (G.field_msgId != 0 && G.field_createTime + 604800000 < bb.n(a, (long) bxVar.pgR)) {
            x.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
            bb.aL(G.field_msgId);
            G.ao(0);
        }
        if (G.field_msgId == 0) {
            G = new au();
            G.ap(bxVar.vNT);
            G.aq(bb.n(a, (long) bxVar.pgR));
            cgVar = G;
        } else {
            cgVar = G;
        }
        if (aVar2.hcJ != null) {
            cgVar.ec(aVar2.hcJ.gkM);
            x.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", cgVar.gkM);
        }
        cgVar.setType(l.d(aVar2));
        cgVar.setContent(cgVar.cjK() ? aVar2.content : str);
        if (cgVar.cjK()) {
            cgVar.dZ(aVar2.gkB);
        }
        if (bxVar.vNP == 2 && cgVar.field_msgId == 0) {
            Object obj2;
            switch (cgVar.getType()) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                final boolean z = aVar2.type == 2;
                byte[] a3 = n.a(bxVar.vNQ);
                if (r.ifT) {
                    x.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!bi.by(a3)) {
                    if (aVar2.type == 33 || aVar2.type == 36) {
                        str2 = o.PC().a(a3, CompressFormat.PNG);
                    } else {
                        str2 = a(a3, z, cgVar.cjZ());
                    }
                    if (bi.oN(str2)) {
                        x.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", cgVar.field_content);
                    }
                    if (!bi.oN(str2)) {
                        cgVar.dV(str2);
                        x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + str2);
                    }
                } else if (!bi.oN(aVar2.hcU) && !bi.oN(aVar2.hdb)) {
                    final long j = cgVar.field_msgSvrId;
                    str2 = aVar2.hdb;
                    final String str4 = aVar2.hcU;
                    final int i3 = aVar2.hcV;
                    x.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", Long.valueOf(cgVar.field_msgSvrId), str2, Integer.valueOf(i3), str4, a, Boolean.valueOf(z));
                    final long Wy = bi.Wy();
                    final int i4 = aVar2 != null ? aVar2.type : 0;
                    final String m = o.PC().m(bi.Wy(), "", "");
                    i iVar = new i();
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", cgVar.field_createTime, a, String.valueOf(j));
                    iVar.field_fullpath = m;
                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    iVar.field_totalLen = i3;
                    iVar.field_aesKey = str2;
                    iVar.field_fileId = str4;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.htv;
                    iVar.field_chattype = s.eX(a) ? 1 : 0;
                    x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", Integer.valueOf(iVar.field_chattype), a);
                    iVar.hve = new com.tencent.mm.modelcdntran.i.a() {
                        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                            if (i != 0) {
                                x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", Long.valueOf(j), Integer.valueOf(i), str4);
                                com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(Wy), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i3), "");
                                return i;
                            } else if (keep_sceneresult == null) {
                                return 0;
                            } else {
                                com.tencent.mm.plugin.report.service.g gVar;
                                if (keep_sceneresult.field_retCode != 0) {
                                    x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", Long.valueOf(j), Integer.valueOf(keep_sceneresult.field_retCode), str4);
                                } else {
                                    as.Hm();
                                    au G = c.Fh().G(a, j);
                                    if (G.field_msgSvrId != j) {
                                        x.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", Long.valueOf(j));
                                        return 0;
                                    }
                                    String a;
                                    long j;
                                    x.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", Long.valueOf(j), Integer.valueOf(G.getType()));
                                    byte[] d = e.d(m, 0, -1);
                                    if (i4 == 33 || i4 == 36) {
                                        a = o.PC().a(d, CompressFormat.JPEG);
                                    } else {
                                        a = j.a(d, z, G.cjZ());
                                    }
                                    if (!bi.oN(a)) {
                                        G.dV(a);
                                        as.Hm();
                                        c.Fh().b(G.field_msgSvrId, G);
                                    }
                                    x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", Long.valueOf(j), a, str4, a);
                                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 16, (long) i3, false);
                                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 17, 1, false);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    if (s.eX(a)) {
                                        j = 19;
                                    } else {
                                        j = 18;
                                    }
                                    gVar.a(198, j, 1, false);
                                }
                                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                Object[] objArr = new Object[16];
                                objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(Wy);
                                objArr[3] = Long.valueOf(bi.Wy());
                                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext()));
                                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                objArr[6] = Integer.valueOf(i3);
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
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[16];
                                    objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
                                    objArr[1] = Integer.valueOf(2);
                                    objArr[2] = Long.valueOf(Wy);
                                    objArr[3] = Long.valueOf(bi.Wy());
                                    objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext()));
                                    objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                                    objArr[6] = Integer.valueOf(i3);
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
                    com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
                } else if (!bi.oN(aVar2.thumburl)) {
                    x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
                    str2 = com.tencent.mm.a.g.s((bi.Wy()).getBytes());
                    FY = o.PC().getFullPath(str2);
                    o.PC();
                    str2 = com.tencent.mm.ap.g.lo(str2);
                    PG = o.PG();
                    str3 = aVar2.thumburl;
                    aVar3 = new com.tencent.mm.ap.a.a.c.a();
                    aVar3.hFn = FY;
                    aVar3.hFl = true;
                    PG.a(str3, null, aVar3.PQ());
                    cgVar.dV(str2);
                    x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + FY);
                }
                if (obj == null) {
                    cgVar.eS(1);
                    cgVar.dU(a2);
                    i = bxVar.kyY;
                    auVar2 = cgVar;
                } else {
                    cgVar.eS(0);
                    cgVar.dU(a);
                    if (bxVar.kyY <= 3) {
                        i = bxVar.kyY;
                        auVar2 = cgVar;
                    } else {
                        i = 3;
                        auVar2 = cgVar;
                    }
                }
                auVar2.eR(i);
                if (aVar2.type == 2001 && aVar2.showType == 1) {
                    if (!TextUtils.isEmpty(aVar2.hev) || TextUtils.isEmpty(aVar2.hew) || aVar2.hex <= 0) {
                        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                    } else {
                        x.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        aiVar = new ai();
                        aiVar.fpj = new com.tencent.mm.f.a.ai.a();
                        aiVar.fpj.fpl = aVar2.hew;
                        aiVar.fpj.fpk = aVar2.hev;
                        aiVar.fpj.fpm = aVar2.hex;
                        com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                    }
                }
                if (aVar2.type == 2001) {
                    try {
                        if (!bi.cC(aVar2.heH)) {
                            for (String str22 : aVar2.heH) {
                                split = str22.split(",");
                                if (split != null && split.length > 0) {
                                    str22 = split[0];
                                    if (!bi.oN(str22) && str22.equals(q.FY())) {
                                        cgVar.fb(cgVar.field_flag | 8);
                                        x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                        m(true, cgVar.field_talker);
                                    }
                                }
                            }
                        } else if (!"1001".equals(aVar2.her)) {
                            aiVar = new tj();
                            aiVar.fMF.fEK = str;
                            com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                            m(false, cgVar.field_talker);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", e.getMessage());
                    }
                }
                cgVar.ea(bxVar.vNR);
                hW = bb.hW(bxVar.vNR);
                if (hW != null) {
                    cgVar.eb(hW.hir);
                    cgVar.dY(hW.hiq);
                }
                bb.a((au) cgVar, aVar);
                if (cgVar.field_msgId != 0) {
                    cgVar.ao(bb.i(cgVar));
                    aiVar = new com.tencent.mm.f.a.r();
                    aiVar.fot.fou = cgVar;
                    aiVar.fot.fov = aVar2;
                    com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                    bVar = new b(cgVar, true);
                } else {
                    Fh.b(bxVar.vNT, (au) cgVar);
                    bVar = new b(cgVar, false);
                }
                if (cgVar.getType() == 301989937 && s.hk(cgVar.field_talker)) {
                    cgVar.ao(0);
                }
                if (cgVar.cjR() && "notifymessage".equals(cgVar.field_talker)) {
                    y = bj.y(cgVar.field_content, "msg");
                    if (y != null) {
                        oM = bi.oM((String) y.get(".msg.fromusername"));
                        if (com.tencent.mm.storage.x.fX(oM)) {
                            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rg(oM);
                            x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", oM);
                        }
                    }
                }
                if (!bi.oN(aVar2.heA) && cgVar.getType() == 436207665) {
                    aiVar = new mk();
                    aiVar.fFf.fFg = cgVar.field_msgId;
                    aiVar.fFf.fEK = str;
                    com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                }
                if (cgVar.getType() == 536870961) {
                    bVar2 = (com.tencent.mm.x.b) aVar2.r(com.tencent.mm.x.b.class);
                    mmVar = new mm();
                    mmVar.fFj.fFg = cgVar.field_msgId;
                    mmVar.fFj.fFk = bVar2.fFi;
                    com.tencent.mm.sdk.b.a.xmy.m(mmVar);
                }
                if (aVar2.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN && !bi.oN(aVar2.hdR)) {
                    aiVar = new mo();
                    aiVar.fFm.fFn = aVar2.hdR;
                    aiVar.fFm.frh = cgVar.field_msgId;
                    aiVar.fFm.fFo = aVar2;
                    com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                    m(false, cgVar.field_talker);
                }
                map = aVar2.hfv;
                str3 = bi.aD((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str3.equals("wx_f2f") || str3.equals("wx_md")) && bVar.hoe) {
                    currentTimeMillis = System.currentTimeMillis() - cgVar.field_createTime;
                    x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(cgVar.field_createTime), Long.valueOf(System.currentTimeMillis()));
                    bsVar = new bs();
                    i2 = bi.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                    oM2 = bi.oM((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                    str22 = bi.oM((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                    if (!(i2 <= 0 || bi.oN(oM2) || bi.oN(str22))) {
                        bsVar.fqI.fqJ = i2;
                        bsVar.fqI.fqK = oM2;
                        bsVar.fqI.fqL = str22;
                        bsVar.fqI.fqM = str3;
                        bsVar.fqI.fqN = currentTimeMillis;
                        bsVar.fqI.cPf = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(bsVar);
                    }
                }
                return bVar;
            }
        }
        if (!bi.oN(aVar2.thumburl)) {
            x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
            str22 = com.tencent.mm.a.g.s((bi.Wy()).getBytes());
            if (aVar2.type == 2001) {
                str22 = com.tencent.mm.a.g.s((aVar2.thumburl).getBytes());
            }
            FY = o.PC().getFullPath(str22);
            o.PC();
            str22 = com.tencent.mm.ap.g.lo(str22);
            PG = o.PG();
            str3 = aVar2.thumburl;
            aVar3 = new com.tencent.mm.ap.a.a.c.a();
            aVar3.hFn = FY;
            aVar3.hFl = true;
            PG.a(str3, null, aVar3.PQ());
            cgVar.dV(str22);
            x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + FY);
        }
        if (obj == null) {
            cgVar.eS(0);
            cgVar.dU(a);
            if (bxVar.kyY <= 3) {
                i = 3;
                auVar2 = cgVar;
            } else {
                i = bxVar.kyY;
                auVar2 = cgVar;
            }
        } else {
            cgVar.eS(1);
            cgVar.dU(a2);
            i = bxVar.kyY;
            auVar2 = cgVar;
        }
        auVar2.eR(i);
        if (TextUtils.isEmpty(aVar2.hev)) {
        }
        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        if (aVar2.type == 2001) {
            if (!bi.cC(aVar2.heH)) {
                while (r5.hasNext()) {
                    split = str22.split(",");
                    str22 = split[0];
                    cgVar.fb(cgVar.field_flag | 8);
                    x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                    m(true, cgVar.field_talker);
                }
            } else if ("1001".equals(aVar2.her)) {
                aiVar = new tj();
                aiVar.fMF.fEK = str;
                com.tencent.mm.sdk.b.a.xmy.m(aiVar);
                m(false, cgVar.field_talker);
            }
        }
        cgVar.ea(bxVar.vNR);
        hW = bb.hW(bxVar.vNR);
        if (hW != null) {
            cgVar.eb(hW.hir);
            cgVar.dY(hW.hiq);
        }
        bb.a((au) cgVar, aVar);
        if (cgVar.field_msgId != 0) {
            Fh.b(bxVar.vNT, (au) cgVar);
            bVar = new b(cgVar, false);
        } else {
            cgVar.ao(bb.i(cgVar));
            aiVar = new com.tencent.mm.f.a.r();
            aiVar.fot.fou = cgVar;
            aiVar.fot.fov = aVar2;
            com.tencent.mm.sdk.b.a.xmy.m(aiVar);
            bVar = new b(cgVar, true);
        }
        cgVar.ao(0);
        y = bj.y(cgVar.field_content, "msg");
        if (y != null) {
            oM = bi.oM((String) y.get(".msg.fromusername"));
            if (com.tencent.mm.storage.x.fX(oM)) {
                ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rg(oM);
                x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", oM);
            }
        }
        aiVar = new mk();
        aiVar.fFf.fFg = cgVar.field_msgId;
        aiVar.fFf.fEK = str;
        com.tencent.mm.sdk.b.a.xmy.m(aiVar);
        if (cgVar.getType() == 536870961) {
            bVar2 = (com.tencent.mm.x.b) aVar2.r(com.tencent.mm.x.b.class);
            mmVar = new mm();
            mmVar.fFj.fFg = cgVar.field_msgId;
            mmVar.fFj.fFk = bVar2.fFi;
            com.tencent.mm.sdk.b.a.xmy.m(mmVar);
        }
        aiVar = new mo();
        aiVar.fFm.fFn = aVar2.hdR;
        aiVar.fFm.frh = cgVar.field_msgId;
        aiVar.fFm.fFo = aVar2;
        com.tencent.mm.sdk.b.a.xmy.m(aiVar);
        m(false, cgVar.field_talker);
        map = aVar2.hfv;
        str3 = bi.aD((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        currentTimeMillis = System.currentTimeMillis() - cgVar.field_createTime;
        x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", str3, Long.valueOf(cgVar.field_createTime), Long.valueOf(System.currentTimeMillis()));
        bsVar = new bs();
        i2 = bi.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        oM2 = bi.oM((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        str22 = bi.oM((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        bsVar.fqI.fqJ = i2;
        bsVar.fqI.fqK = oM2;
        bsVar.fqI.fqL = str22;
        bsVar.fqI.fqM = str3;
        bsVar.fqI.fqN = currentTimeMillis;
        bsVar.fqI.cPf = 0;
        com.tencent.mm.sdk.b.a.xmy.m(bsVar);
        return bVar;
    }

    private static void m(boolean z, String str) {
        if (!bi.oN(str)) {
            x.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", Boolean.valueOf(z), str);
            as.Hm();
            ae XF = c.Fk().XF(str);
            if (XF != null) {
                if (z) {
                    XF.gc(16777216);
                } else {
                    XF.Bb();
                }
                as.Hm();
                c.Fk().a(XF, str);
            }
        }
    }

    public final void h(au auVar) {
        if (auVar == null) {
            x.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            return;
        }
        x.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + auVar.field_imgPath);
        com.tencent.mm.sdk.b.b snVar = new sn();
        snVar.fLc.path = auVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xmy.m(snVar);
        String str = auVar.field_content;
        if (str != null) {
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV != null && fV.type == 6) {
                FileOp.deleteFile(com.tencent.mm.compatible.util.e.gJd + fV.title);
                FileOp.deleteFile(com.tencent.mm.compatible.util.e.gJd + fV.title + "_tmp");
            }
        }
    }

    public final boolean a(final a aVar, String str, long j, String str2, final String str3, int i, String str4) {
        String m = o.PC().m("Note_" + str, "", "");
        if (FileOp.bO(m)) {
            return false;
        }
        this.vkZ = aVar;
        i iVar = new i();
        iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", j, str4, str);
        iVar.field_fullpath = m;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        iVar.field_totalLen = i;
        iVar.field_aesKey = str2;
        iVar.field_fileId = str3;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htv;
        iVar.field_chattype = s.eX(str4) ? 1 : 0;
        x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(iVar.field_chattype), str4);
        iVar.hve = new com.tencent.mm.modelcdntran.i.a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                x.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", str, str3);
                if (i != 0) {
                    x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", Integer.valueOf(i), str3);
                    return i;
                } else if (keep_sceneresult == null) {
                    return 0;
                } else {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", Integer.valueOf(keep_sceneresult.field_retCode), str3);
                    } else {
                        x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", str3);
                    }
                    o.PC().doNotify();
                    if (aVar != null) {
                        aVar.bZy();
                    }
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
        return true;
    }
}
