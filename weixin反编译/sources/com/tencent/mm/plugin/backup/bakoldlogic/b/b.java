package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.me;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.l;
import com.tencent.mm.x.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements k {

    private static class a {
        public static String ksD = "]]>";
        public static String ksE = "<msg>";
        public static String ksF = "</msg>";

        static class a {
            Map<String, String> ksG = null;
            boolean ksH = true;

            public a(String str) {
                this.ksG = ay.VU(str);
                if (this.ksG == null) {
                    this.ksH = false;
                    this.ksG = new HashMap();
                }
            }

            final int getInt(String str) {
                if (this.ksG.containsKey(str)) {
                    return bi.getInt((String) this.ksG.get(str), 0);
                }
                return 0;
            }
        }

        static class b {
            StringBuffer ksI = new StringBuffer();

            b() {
            }

            public final void vY(String str) {
                this.ksI.append("<" + str + ">");
            }

            public final void vZ(String str) {
                this.ksI.append("</" + str + ">");
            }

            public final void bN(String str, String str2) {
                vY(str);
                if (!bi.oN(str2)) {
                    if (str2.contains(a.ksD)) {
                        this.ksI.append("<![CDATA[" + bi.Wm(str2) + "]]>");
                    } else {
                        this.ksI.append("<![CDATA[" + str2 + "]]>");
                    }
                }
                vZ(str);
            }

            public final void aU(String str, int i) {
                vY(str);
                this.ksI.append(i);
                vZ(str);
            }

            public final void g(String str, Map<String, String> map) {
                this.ksI.append("<" + str);
                for (String str2 : map.keySet()) {
                    this.ksI.append(" " + str2 + " =  \"" + ((String) map.get(str2)) + "\" ");
                }
                this.ksI.append(">");
                map.clear();
            }
        }

        public static String vX(String str) {
            l wr = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).wr(str);
            a aVar = new a(str);
            if (aVar.ksH) {
                String str2;
                String str3;
                String str4;
                b bVar = new b();
                List list = wr.hfI;
                Map hashMap = new HashMap();
                bVar.vY("msg");
                hashMap.put("appid", (String) aVar.ksG.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) aVar.ksG.get(".msg.appmsg.$sdkver"));
                bVar.g("appmsg", hashMap);
                if (list == null) {
                    list = new LinkedList();
                }
                if (list.size() == 0) {
                    str2 = "";
                    str3 = "";
                    str4 = "";
                } else {
                    str3 = ((m) list.get(0)).title;
                    str4 = ((m) list.get(0)).url;
                    str2 = ((m) list.get(0)).hfO;
                    str2 = str3;
                    str3 = str4;
                    str4 = ((m) list.get(0)).hfQ;
                }
                bVar.bN("title", str2);
                bVar.bN("des", (String) aVar.ksG.get(".msg.appmsg.des"));
                bVar.bN("action", (String) aVar.ksG.get(".msg.appmsg.action"));
                bVar.aU(Columns.TYPE, aVar.getInt(".msg.appmsg.type"));
                bVar.aU("showtype", aVar.getInt(".msg.appmsg.showtype"));
                bVar.bN("content", (String) aVar.ksG.get(".msg.appmsg.content"));
                bVar.bN(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
                bVar.bN("lowurl", (String) aVar.ksG.get(".msg.appmsg.lowurl"));
                bVar.vY("appattach");
                bVar.aU("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
                bVar.bN("attachid", (String) aVar.ksG.get(".msg.appmsg.appattach.attachid"));
                bVar.bN("fileext", (String) aVar.ksG.get(".msg.appmsg.appattach.fileext"));
                bVar.vZ("appattach");
                bVar.vY("mmreader");
                hashMap.put(Columns.TYPE, wr.type);
                hashMap.put("convMsgCount", list.size());
                bVar.g("category", hashMap);
                bVar.bN("name", wr.fHv);
                bVar.vY("topnew");
                bVar.bN("cover", (String) aVar.ksG.get(".msg.appmsg.mmreader.category.topnew.cover"));
                bVar.bN("width", (String) aVar.ksG.get(".msg.appmsg.mmreader.category.topnew.width"));
                bVar.bN("height", (String) aVar.ksG.get(".msg.appmsg.mmreader.category.topnew.height"));
                bVar.bN("digest", str4);
                bVar.vZ("topnew");
                int i = 0;
                while (i < list.size()) {
                    bVar.vY("item");
                    if (list.get(i) != null) {
                        str3 = ((m) list.get(i)).title;
                        String str5 = ((m) list.get(i)).url;
                        String str6 = ((m) list.get(i)).hfM;
                        String str7 = ((m) list.get(i)).hfN;
                        String str8 = ((m) list.get(i)).time;
                        String str9 = ((m) list.get(i)).hfO;
                        String str10 = ((m) list.get(i)).hfP;
                        str2 = ((m) list.get(i)).hfQ;
                        bVar.bN("title", str3);
                        bVar.bN(SlookSmartClipMetaTag.TAG_TYPE_URL, str5);
                        bVar.bN("shorturl", str6);
                        bVar.bN("longurl", str7);
                        bVar.bN("pub_time", str8);
                        bVar.bN("cover", str9);
                        bVar.bN("tweetid", str10);
                        bVar.bN("digest", str2);
                        bVar.bN("fileid", (String) aVar.ksG.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        bVar.vY("source");
                        bVar.vY("source");
                        bVar.bN("name", wr.fHv);
                        bVar.vZ("source");
                        bVar.vZ("source");
                        bVar.vZ("item");
                    }
                    i++;
                }
                bVar.vZ("category");
                bVar.vY(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.bN("convName", wr.fHu);
                bVar.bN("nickname", wr.fHv);
                bVar.vZ(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.vZ("mmreader");
                bVar.vZ("appmsg");
                bVar.bN("fromusername", wr.fHu);
                bVar.aU("scene", aVar.getInt(".msg.scene"));
                bVar.vY("appinfo");
                bVar.bN("version", (String) aVar.ksG.get(".msg.appinfo.appname"));
                bVar.bN("appname", (String) aVar.ksG.get(".msg.appinfo.version"));
                bVar.vZ("appinfo");
                bVar.bN("commenturl", wr.gkB);
                bVar.vZ("msg");
                x.d("MicroMsg.AppmsgConvert", "xml " + bVar.ksI.toString());
                return bVar.ksI.toString();
            }
            x.e("MicroMsg.AppmsgConvert", "buffer error");
            return "";
        }
    }

    public final int a(ev evVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.bakoldlogic.b.i.a> hashMap, boolean z2, long j) {
        String B;
        switch (auVar.getType()) {
            case 1048625:
                int length = bi.oN(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (auVar.field_content == null) {
                    return -1;
                }
                String trim = aj.XW(auVar.field_content).xGZ.trim();
                if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.vV(trim)) {
                    trim = auVar.field_content;
                    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.vV(trim)) {
                        x.e("MicroMsg.BakOldItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (!bi.oN(trim)) {
                    bet bet = new bet();
                    bet.Vf(bi.aD(trim, ""));
                    evVar.vNO = bet;
                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(trim);
                    String Fw = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().Fw();
                    B = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqI().B(auVar.field_imgPath, true);
                    String str2 = Fw + fV.hcO;
                    if (e.bN(B) <= 0) {
                        return -1;
                    }
                    length = (length + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(B, evVar, (LinkedList) linkedList, 6, false, "_thumb", false))) + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(str2, evVar, linkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqJ().YB(aj.XW(n.a(evVar.vNO)).frM)));
                }
                return length;
            case 285212721:
                int length2 = bi.oN(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                B = a.vX(auVar.field_content);
                if (bi.oN(B)) {
                    return 0;
                }
                bet bet2 = new bet();
                bet2.Vf(bi.aD(B, ""));
                evVar.vNO = bet2;
                return length2;
            default:
                return b(evVar, false, auVar, str, linkedList, null, false, 0);
        }
    }

    private static int b(ev evVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.bakoldlogic.b.i.a> hashMap, boolean z2, long j) {
        int i;
        com.tencent.mm.x.g.a fV;
        if (bi.oN(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String str2 = auVar.field_content;
        if (auVar.field_isSend != 1 && d.eX(auVar.field_talker)) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = bi.Wn(str2);
        if (str2 != null) {
            fV = com.tencent.mm.x.g.a.fV(str2);
        } else {
            fV = null;
        }
        if (fV == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "content is null");
            return 0;
        }
        x.d("MicroMsg.BakOldItemAppMsg", "content type " + fV.type);
        String B = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqI().B(auVar.field_imgPath, true);
        if (e.bO(B)) {
            i += j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(B, evVar, (LinkedList) linkedList, 6, z, "_thumb", z2));
        } else if (fV.type == 2) {
            return -1;
        }
        com.tencent.mm.pluginsdk.model.app.b Se;
        switch (fV.type) {
            case 2:
                if (bi.oN(fV.for)) {
                    return i;
                }
                com.tencent.mm.pluginsdk.model.app.b Se2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().Se(fV.for);
                if ((Se2 == null || !Se2.aPj()) && (auVar.field_isSend != 1 || Se2 == null || !Se2.field_isUpload)) {
                    return i;
                }
                B = Se2.field_fileFullPath;
                if (!e.bO(B)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "image " + B);
                return i + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(B, evVar, (LinkedList) linkedList, 8, z, z2, null));
            case 6:
                Se = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().Se(fV.for);
                if ((Se == null || !Se.aPj()) && (auVar.field_isSend != 1 || Se == null || !Se.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "full path " + Se.field_fileFullPath);
                if (!e.bO(Se.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(Se.field_fileFullPath, evVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                if (com.tencent.mm.plugin.backup.a.d.aoV() != 1 || ((long) (fV.hcM / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) < j || fV.filemd5 == null) {
                    return i + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(Se.field_fileFullPath, evVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                String str3;
                if (auVar.field_isSend == 1) {
                    str3 = auVar.field_talker;
                } else {
                    str3 = str;
                    str = auVar.field_talker;
                }
                u uVar = new u();
                i += j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(Se.field_fileFullPath, evVar, (LinkedList) linkedList, 7, z, true, uVar));
                if (hashMap == null) {
                    return i;
                }
                com.tencent.mm.plugin.backup.bakoldlogic.b.i.a aVar = new com.tencent.mm.plugin.backup.bakoldlogic.b.i.a();
                aVar.ksN = uVar;
                aVar.frM = fV.filemd5;
                aVar.ksP = str + "_" + str3 + "_" + auVar.field_msgSvrId + "_backup";
                aVar.ksO = auVar.field_msgSvrId;
                hashMap.put(Long.valueOf(auVar.field_msgSvrId), aVar);
                return i;
            case 7:
                Se = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().Se(fV.for);
                if ((Se == null || !Se.aPj()) && (auVar.field_isSend != 1 || Se == null || !Se.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "full path " + Se.field_fileFullPath);
                if (e.bO(Se.field_fileFullPath)) {
                    return i + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(Se.field_fileFullPath, evVar, (LinkedList) linkedList, 7, z, z2, null));
                }
                return i;
            case 19:
            case 24:
                com.tencent.mm.sdk.b.b meVar = new me();
                meVar.fEF.fDn = fV.hdm;
                meVar.fEF.fqB = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xmy.m(meVar);
                x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", meVar.fEG.fEH);
                String[] split = meVar.fEG.fEH.split(":");
                int i2 = i;
                i = 0;
                while (i < split.length) {
                    int a;
                    if (e.bO(split[i])) {
                        x.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", split[i], Integer.valueOf(i));
                        a = i2 + j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(split[i], evVar, (LinkedList) linkedList, 7, z, "_fav." + i, z2));
                    } else {
                        a = i2;
                    }
                    i++;
                    i2 = a;
                }
                return i2;
            default:
                return i;
        }
    }

    public final int a(String str, ev evVar, au auVar) {
        String str2 = evVar.vNM.wRo;
        String str3 = evVar.vNO.wRo;
        if (str3 == null) {
            return 0;
        }
        int hR;
        auVar.setContent(str3);
        if (auVar.field_isSend != 1 && d.eX(str2)) {
            hR = d.hR(evVar.vNO.wRo);
            if (hR != -1) {
                str3 = (evVar.vNO.wRo + " ").substring(hR + 2).trim();
            }
        }
        String Wn = bi.Wn(str3);
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(Wn);
        int i;
        if (fV == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (fV.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            auVar.setType(419430449);
            d.i(auVar);
            return 0;
        } else if (fV.type == 19 || fV.type == 24) {
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(fV));
            d.i(auVar);
            com.tencent.mm.sdk.b.b meVar = new me();
            meVar.fEF.fDn = fV.hdm;
            meVar.fEF.fqB = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xmy.m(meVar);
            x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", meVar.fEG.fEH);
            String[] split = meVar.fEG.fEH.split(":");
            for (i = 0; i < split.length; i++) {
                Wn = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(evVar, 7, "." + i);
                if (!bi.oN(Wn)) {
                    x.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", Wn, Integer.valueOf(i));
                    k.r(com.tencent.mm.plugin.backup.bakoldlogic.a.a.wg(Wn), split[i], false);
                }
            }
            return 0;
        } else {
            c fVar = new f();
            fVar.field_appId = fV.appId;
            com.tencent.mm.plugin.backup.bakoldlogic.d.c arr = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr();
            if (arr.uin == 0) {
                throw new com.tencent.mm.y.b();
            }
            if (arr.kvG.b(fVar, new String[0]) && fVar.field_appVersion < fV.fJh) {
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().ars().e(1, fV.appId);
            }
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(fV));
            byte[] b = com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(evVar, 6);
            if (b != null && auVar.field_msgId == 0) {
                str3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqI().a(b, fV.type == 2, CompressFormat.PNG);
                x.d("MicroMsg.BakOldItemAppMsg", com.tencent.mm.compatible.util.g.zo() + " thumbData MsgInfo path:" + str3);
                if (!bi.oN(str3)) {
                    auVar.dV(str3);
                    x.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(evVar, 8);
            i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(evVar, 8);
            if (bi.oN(str2)) {
                str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(evVar, 7);
                i = com.tencent.mm.plugin.backup.bakoldlogic.a.a.c(evVar, 7);
            }
            String wg = com.tencent.mm.plugin.backup.bakoldlogic.a.a.wg(str2);
            d.i(auVar);
            com.tencent.mm.x.g gVar = new com.tencent.mm.x.g();
            fV.a(gVar);
            gVar.field_msgId = auVar.field_msgId;
            com.tencent.mm.plugin.backup.bakoldlogic.d.c arr2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr();
            if (arr2.uin == 0) {
                throw new com.tencent.mm.y.b();
            }
            arr2.kvF.b((c) gVar);
            if (!bi.oN(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().Fh();
                if (str.equals(evVar.vNM.wRo)) {
                    str2 = evVar.vNN.wRo;
                } else {
                    str2 = evVar.vNM.wRo;
                }
                cg G = Fh.G(str2, evVar.vNT);
                c Se = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().Se(fV.for);
                if (Se == null) {
                    x.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j = G.field_msgId;
                    com.tencent.mm.x.g.a fV2 = com.tencent.mm.x.g.a.fV(Wn);
                    if (fV2 != null) {
                        Wn = com.tencent.mm.pluginsdk.model.app.l.ad(com.tencent.mm.compatible.util.e.gJd, fV2.title, fV2.hcN);
                        int i2 = fV2.sdkVer;
                        String str4 = fV2.appId;
                        String str5 = fV2.for;
                        hR = fV2.hcM;
                        c bVar = new com.tencent.mm.pluginsdk.model.app.b();
                        bVar.field_fileFullPath = Wn;
                        bVar.field_appId = str4;
                        bVar.field_sdkVer = (long) i2;
                        bVar.field_mediaSvrId = str5;
                        bVar.field_totalLen = (long) hR;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bi.Wy();
                        bVar.field_lastModifyTime = bi.Wx();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().b(bVar)) {
                            x.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", Long.valueOf(j));
                        }
                    }
                    Se = com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().Se(fV.for);
                    if (Se == null) {
                        x.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", fV.for);
                        return 0;
                    } else if (!(fV.hcM == 0 || i == 0)) {
                        if (i >= fV.hcM) {
                            Se.field_status = 199;
                        } else if (auVar.field_isSend == 1) {
                            Se.field_status = 105;
                        } else {
                            Se.field_status = 102;
                        }
                    }
                }
                long j2 = (long) i;
                Se.field_offset = j2;
                Se.field_totalLen = j2;
                k.r(wg, Se.field_fileFullPath, false);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.arq().arr().aqK().c(Se, new String[0]);
            }
            return 0;
        }
    }
}
