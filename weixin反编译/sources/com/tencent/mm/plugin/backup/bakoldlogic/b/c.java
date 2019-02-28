package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c implements k {

    private static class a {
        public static String ksE = "<msg>";
        public static String ksF = "</msg>";

        public static String wa(String str) {
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a wh = a.wh(str);
            return wh == null ? null : wh.ktc;
        }

        public static String a(au auVar, ev evVar) {
            EmojiInfo YB = b.arq().arr().aqJ().YB(auVar.field_imgPath);
            if (YB == null) {
                return null;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a wi = a.wi(YB.Nx());
            if (wi == null) {
                wi = new com.tencent.mm.plugin.backup.bakoldlogic.b.a.a(YB.Nx(), YB.Nx(), YB.Nx(), YB.Nx());
            }
            Writer stringWriter = new StringWriter();
            try {
                String aD;
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", evVar.vNM.wRo);
                newSerializer.attribute(null, "tousername", evVar.vNN.wRo);
                newSerializer.attribute(null, Columns.TYPE, YB.field_type);
                newSerializer.attribute(null, "idbuffer", YB.clo());
                newSerializer.attribute(null, "md5", wi.ktd);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", wi.ktc);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", YB.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (YB.YI()) {
                    newSerializer.startTag(null, "gameext");
                    Map y = bj.y(YB.wl(), "gameext");
                    String aD2 = bi.aD((String) y.get(".gameext.$type"), "");
                    aD = bi.aD((String) y.get(".gameext.$content"), "");
                    if (aD2.equals("") || aD.equals("")) {
                        stringWriter.close();
                        return "";
                    }
                    newSerializer.attribute(null, Columns.TYPE, aD2);
                    newSerializer.attribute(null, "content", aD);
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                aD = stringWriter.getBuffer().toString();
                try {
                    aD = aD.substring(aD.indexOf(ksE), aD.indexOf(ksF) + ksF.length());
                    x.d("MicroMsg.EmojiConvert", "xml " + aD);
                    return aD;
                } catch (Exception e) {
                    return "";
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                return "";
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e22, "", new Object[0]);
                return "";
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e222, "", new Object[0]);
                return "";
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2222, "", new Object[0]);
                return "";
            }
        }
    }

    private static boolean vV(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bj.y(str, "msg") != null;
    }

    public final int a(ev evVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.bakoldlogic.b.i.a> hashMap, boolean z2, long j) {
        int i;
        if (bi.oN(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String trim = aj.XW(auVar.field_content).xGZ.trim();
        if (!vV(trim)) {
            trim = auVar.field_content;
            if (!vV(trim)) {
                trim = a.a(auVar, evVar);
                if (auVar.field_isSend != 1 && d.eX(auVar.field_talker)) {
                    trim = auVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !vV(trim)) {
            x.d("MicroMsg.BakOldItemEmoji", "emoji error" + trim);
            return -1;
        }
        bet bet = new bet();
        bet.Vf(bi.aD(trim, ""));
        evVar.vNO = bet;
        EmojiInfo YB = b.arq().arr().aqJ().YB(auVar.field_imgPath);
        if (YB != null && YB.clk()) {
            return i;
        }
        int a;
        if (YB != null) {
            String str2;
            if (TextUtils.isEmpty(YB.field_groupId)) {
                str2 = b.arq().arr().Fw() + YB.Nx() + "_thumb";
                if (e.bN(str2) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(str2, evVar, (LinkedList) linkedList, 4, false, "_thumb", false)) + i;
            } else {
                str2 = b.arq().arr().Fw() + YB.field_groupId + File.separator + YB.Nx() + "_cover";
                if (e.bN(str2) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(str2, evVar, (LinkedList) linkedList, 4, false, "_thumb", false)) + i;
            }
            if (TextUtils.isEmpty(YB.field_groupId) && YB.clh()) {
                a += j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(b.arq().arr().Fw() + YB.Nx(), evVar, linkedList, false, false, b.arq().arr().aqJ().YB(aj.XW(n.a(evVar.vNO)).frM)));
            } else if (YB.clj()) {
                a += j.a(new com.tencent.mm.plugin.backup.bakoldlogic.b.j.a(b.arq().arr().Fw() + YB.field_groupId + File.separator + YB.Nx(), evVar, linkedList, false, false, b.arq().arr().aqJ().YB(aj.XW(n.a(evVar.vNO)).frM)));
            }
        } else {
            a = i;
        }
        return a;
    }

    public final int a(String str, ev evVar, au auVar) {
        boolean z = true;
        auVar.setContent(evVar.vNO.wRo);
        String str2 = evVar.vNM.wRo;
        String str3 = evVar.vNN.wRo;
        if (!((String) b.arq().arr().Db().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = evVar.vNO.wRo;
        Map y = bj.y(str2, "msg");
        al cq = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().cq(str2, str3);
        if (cq == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(cq.frM);
        if (yI == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            return -1;
        }
        String wa;
        if (y.get(".msg.emoji.$androidmd5") == null) {
            wa = a.wa(cq.frM);
            if (!bi.oN(wa)) {
                cq.frM = wa;
                x.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", wa);
            }
        }
        wa = (String) y.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(wa)) {
            cq.frQ = wa;
        }
        auVar.setType(47);
        auVar.dV(cq.frM);
        str3 = cq.hXn;
        if (yI.YI() || yI.isGif()) {
            z = false;
        }
        auVar.setContent(aj.a(str3, 0, z, cq.frM, false, ""));
        if (!yI.clh()) {
            str3 = b.arq().arr().Fw();
            if (TextUtils.isEmpty(wa)) {
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(evVar, 4, str3 + cq.frM + "_thumb");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(evVar, 5, str3 + cq.frM);
            } else {
                File file = new File(str3 + wa);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(evVar, 4, str3 + wa + File.separator + cq.frM + "_cover");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(evVar, 5, str3 + wa + File.separator + cq.frM);
            }
            com.tencent.mm.sdk.e.c emojiInfo = new EmojiInfo(str3);
            emojiInfo.field_md5 = cq.frM;
            emojiInfo.field_svrid = cq.id;
            emojiInfo.field_catalog = EmojiInfo.xIH;
            emojiInfo.field_type = cq.xHf;
            emojiInfo.field_size = cq.xHg;
            emojiInfo.field_state = EmojiInfo.xIT;
            if (!TextUtils.isEmpty(wa)) {
                emojiInfo.field_groupId = wa;
            }
            if (!bi.oN(cq.xHo)) {
                emojiInfo.field_activityid = cq.xHo;
            }
            b.arq().arr().aqJ().a(emojiInfo);
        }
        x.d("MicroMsg.BakOldItemEmoji", "id " + d.i(auVar));
        return 0;
    }
}
