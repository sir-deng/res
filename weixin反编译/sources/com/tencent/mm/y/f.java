package com.tencent.mm.y;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.ad.d.c;
import com.tencent.mm.af.a.e;
import com.tencent.mm.af.y;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.f.a.ia;
import com.tencent.mm.f.a.ip;
import com.tencent.mm.f.a.ml;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.j.g;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.aus;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.q.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.R;

public final class f implements l {
    private long hgF = -1;
    public a hgG;

    public interface a {
        void cD(String str);
    }

    public final b a(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
        d aU;
        String str2;
        String str3;
        String str4;
        int i;
        ae XF;
        long j;
        String str5;
        au auVar;
        int i2;
        String str6;
        String str7;
        int i3;
        String str8;
        int i4;
        com.tencent.mm.bp.a aoe;
        Object[] objArr;
        int i5;
        bx bxVar = aVar.hoa;
        String a = n.a(bxVar.vNO);
        b bVar = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                bxVar.vNO = n.oK((String) map.get(".sysmsg.addcontact.content"));
                bxVar.nlX = 1;
                aU = c.aU(Integer.valueOf(1));
                bVar = aU == null ? null : aU.b(aVar);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                g.Af().a(a, map, false);
                g.Ag();
                if (com.tencent.mm.j.c.zQ() == 2) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(10879, "");
                }
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(bi.getInt(g.Af().getValue("MuteRoomDisable"), 0)));
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                g.Af().a(a, map, true);
            }
        }
        if (str != null) {
            if (str.equals("banner")) {
                str2 = (String) map.get(".sysmsg.mainframebanner.$type");
                str3 = (String) map.get(".sysmsg.mainframebanner.showtype");
                str4 = (String) map.get(".sysmsg.mainframebanner.data");
                if (str2 != null && str2.length() > 0) {
                    try {
                        ba.Hy().a(new az(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        as.Hm().FM().a(str3, true, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(bi.oN(str2) || bi.oN(str4))) {
                    try {
                        boolean z;
                        if (str4.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        as.Hm().FN().a(str2, z, new String[]{str3});
                    } catch (Exception e22) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                as.Hm().FO().p(map);
            }
        }
        if (!bi.oN(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", (String) map.get(".sysmsg.midinfo.time_interval"), str2, a);
                i = bi.getInt(str3, 0);
                if (((long) i) > 86400 && ((long) i) < 864000) {
                    as.Hm();
                    c.Db().set(331777, Long.valueOf(bi.Wx() + ((long) i)));
                }
                if (!bi.oN(str2)) {
                    com.tencent.mm.plugin.report.b.d.Jb(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", (String) map.get(".sysmsg.revokemsg.newmsgid"), str4);
                long j2 = 0;
                try {
                    j2 = bi.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    as.Hm();
                    au G = c.Fh().G(str2, j2);
                    final au ae = au.ae(G);
                    if ((G.gkC & 4) != 4) {
                        G.setContent(str4);
                        G.setType(10000);
                        bb.a(G, aVar);
                        as.Hm();
                        c.Fh().a(G.field_msgId, G);
                    }
                    as.Hm();
                    XF = c.Fk().XF(G.field_talker);
                    if (XF != null && XF.field_unReadCount > 0) {
                        as.Hm();
                        if (XF.field_unReadCount >= c.Fh().P(G)) {
                            XF.eP(XF.field_unReadCount - 1);
                            as.Hm();
                            c.Fk().a(XF, XF.field_username);
                        }
                    }
                    if (aVar != null && aVar.hob) {
                        com.tencent.mm.sdk.e.c aoVar = new ao();
                        aoVar.field_originSvrId = j2;
                        if (G.field_msgId == 0) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", Long.valueOf(j2));
                            aoVar.field_content = a;
                            aoVar.field_createTime = (long) bxVar.pgR;
                            aoVar.field_flag = bb.c(aVar);
                            aoVar.field_fromUserName = n.a(bxVar.vNM);
                            aoVar.field_toUserName = n.a(bxVar.vNN);
                            aoVar.field_newMsgId = bxVar.vNT;
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", Boolean.valueOf(q.Ql().Qi().b(aoVar)), Long.valueOf(aoVar.xrR));
                            return null;
                        }
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", Long.valueOf(j2));
                        q.Ql().Qi().a(aoVar, true, new String[0]);
                        as.Hm();
                        c.Fh().dM(j2);
                        if (!(XF == null || aVar.hoa == null || XF.field_lastSeq != ((long) aVar.hoa.vNU))) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", Long.valueOf(XF.field_lastSeq), Long.valueOf(XF.field_firstUnDeliverSeq));
                            as.Hm();
                            cg Fe = c.Fh().Fe(XF.field_username);
                            if (Fe != null) {
                                XF.al(Fe.field_msgSeq);
                                as.Hm();
                                int a2 = c.Fk().a(XF, XF.field_username);
                                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", Long.valueOf(Fe.field_msgSvrId), Long.valueOf(Fe.field_msgSeq), Long.valueOf(XF.field_lastSeq), Long.valueOf(XF.field_firstUnDeliverSeq), Integer.valueOf(a2));
                            }
                        }
                    }
                    if (G.field_msgId == 0 && (aVar == null || !aVar.hob)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", Long.valueOf(j2));
                        as.Hm();
                        c.Fh().dM(j2);
                    }
                    com.tencent.mm.sdk.b.b obVar = new ob();
                    obVar.fGN.frh = G.wg();
                    obVar.fGN.fGO = str4;
                    obVar.fGN.fFE = G;
                    obVar.fGN.fGP = ae;
                    obVar.fGN.fGQ = j2;
                    com.tencent.mm.sdk.b.a.xmy.m(obVar);
                    if (ae != null) {
                        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", Long.valueOf(ae.field_msgId), Integer.valueOf(ae.getType()));
                                switch (ae.getType()) {
                                    case 3:
                                    case 34:
                                    case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                                    case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                                    case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                                    case 62:
                                    case 268435505:
                                        bb.j(ae);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                } catch (Throwable e3) {
                    j = j2;
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3, "[oneliang][revokeMsg] msgId:%d,error:%s", Long.valueOf(j), e3.toString());
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = ay.at(bj.y(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", str2, str3, str4, str5);
                try {
                    as.Hm();
                    LinkedList du = c.Fh().du(str4, str3);
                    if (du == null || du.size() <= 0) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        return null;
                    }
                    Iterator it = du.iterator();
                    while (it.hasNext()) {
                        auVar = (au) it.next();
                        if (auVar == null) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (auVar.wh() < 0) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.wg()), Long.valueOf(auVar.wh()));
                        } else {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", Long.valueOf(auVar.wg()), Long.valueOf(auVar.wh()));
                            i2 = bi.getInt(str2, 0);
                            if (i2 == 1) {
                                as.Hm();
                                c.Fh().P(auVar.wk(), auVar.wh());
                            } else if (i2 == 2 && auVar.cjK()) {
                                auVar.setContent(str5);
                                bb.a(auVar, aVar);
                                as.Hm();
                                c.Fh().b(auVar.wh(), auVar);
                                as.Hm();
                                ae XF2 = c.Fk().XF(auVar.wk());
                                if (XF2 != null && XF2.wb() > 0) {
                                    as.Hm();
                                    if (XF2.wb() >= c.Fh().P(auVar)) {
                                        XF2.eP(XF2.wb() - 1);
                                        as.Hm();
                                        c.Fk().a(XF2, XF2.getUsername());
                                    }
                                }
                            }
                            com.tencent.mm.sdk.b.b obVar2 = new ob();
                            obVar2.fGN.frh = auVar.wg();
                            obVar2.fGN.fGO = str5;
                            obVar2.fGN.fFE = auVar;
                            com.tencent.mm.sdk.b.a.xmy.m(obVar2);
                        }
                    }
                    return null;
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e32, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", str3, e32.toString());
                }
            }
        }
        if (str != null) {
            if (str.equals("updatepackage")) {
                aU = c.aU(Integer.valueOf(-1879048175));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("deletepackage")) {
                aU = c.aU(Integer.valueOf(-1879048174));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("delchatroommember")) {
                str3 = n.a(bxVar.vNM);
                as.Hm();
                auVar = c.Fh().G(str3, bxVar.vNT);
                Object obj = null;
                if (auVar.wg() > 0) {
                    obj = 1;
                }
                auVar.ap(bxVar.vNT);
                if (!(aVar != null && aVar.hob && aVar.hod)) {
                    auVar.aq(bb.n(str3, (long) bxVar.pgR));
                }
                auVar.setType(10002);
                auVar.setContent(a);
                auVar.eS(0);
                auVar.dU(str3);
                auVar.ea(bxVar.vNR);
                bb.a(auVar, aVar);
                if (obj == null) {
                    bb.i(auVar);
                } else {
                    as.Hm();
                    c.Fh().b(bxVar.vNT, auVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("WakenPush") && this.hgF != bxVar.vNT) {
                this.hgF = bxVar.vNT;
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                ca caVar = new ca(map);
                str6 = (String) caVar.hfv.get(".sysmsg.WakenPush.PushContent");
                str3 = (String) caVar.hfv.get(".sysmsg.WakenPush.Jump");
                str2 = (String) caVar.hfv.get(".sysmsg.WakenPush.ExpiredTime");
                str7 = (String) caVar.hfv.get(".sysmsg.WakenPush.Username");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str6, str3, str2);
                str2 = g.Af().getValue("WakenPushDeepLinkBitSet");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str2);
                j = !bi.oN(str2) ? bi.getLong(str2, 0) : 0;
                Bitmap iY = com.tencent.mm.ac.b.iY(str7);
                aj notification = as.getNotification();
                if (bi.oN(str3)) {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                    str4 = "com.tencent.mm.ui.LauncherUI";
                } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
                    str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                } else if ((j & HardCoderJNI.ACTION_NET_TX) == HardCoderJNI.ACTION_NET_TX && str3.startsWith("weixin://dl/recommendation")) {
                    str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                } else {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
                    str4 = "com.tencent.mm.ui.LauncherUI";
                }
                Intent intent = new Intent();
                intent.setClassName(ad.getContext(), str4);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) caVar.hfv.get(".sysmsg.WakenPush.PushContent"));
                if (!str3.equals("weixin://dl/update_newest_version")) {
                    intent.putExtra("LauncherUI.Show.Update.Url", (String) caVar.hfv.get(".sysmsg.WakenPush.Jump"));
                }
                com.tencent.mm.plugin.report.service.g.pWK.a(405, 32, 1, true);
                Notification a3 = notification.a(PendingIntent.getActivity(ad.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), ad.getContext().getString(com.tencent.mm.R.l.app_name), str6, str6, iY, str7);
                a3.flags |= 16;
                as.getNotification().a(a3, false);
                com.tencent.mm.plugin.report.service.g.pWK.a(405, 31, 1, true);
                bVar = null;
            }
        }
        if (str != null) {
            if (str.equals("DisasterNotice")) {
                str2 = (String) map.get(".sysmsg.NoticeId");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", str2, (String) map.get(".sysmsg.Content"));
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
                str5 = sharedPreferences.getString("disaster_noticeid_list_key", "");
                if (!str5.contains(str2)) {
                    String[] split = str5.split(";");
                    if (split == null || split.length <= 10) {
                        str4 = str5;
                    } else {
                        str4 = "";
                        for (String str82 : split) {
                            String[] split2 = str82.split(",");
                            try {
                                if (bi.bz(bi.getLong(split2[0], 0)) < 1296000) {
                                    str4 = str4 + split2[0] + "," + split2[1] + ";";
                                }
                            } catch (Exception e4) {
                                x.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", e4);
                            }
                        }
                    }
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", str5, str4 + bi.Wx() + "," + str2 + ";");
                    sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                }
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        if (f.this.hgG != null) {
                            f.this.hgG.cD(str2);
                        }
                    }
                });
                bxVar.vNO = n.oK(str3);
                bxVar.nlX = 1;
                aU = c.aU(Integer.valueOf(1));
                if (aU == null) {
                    bVar = null;
                } else {
                    bVar = aU.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("EmotionKv")) {
                str2 = (String) map.get(".sysmsg.EmotionKv.K");
                a = (String) map.get(".sysmsg.EmotionKv.I");
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", Integer.valueOf(str3.length()), str3, a);
                byte[] bytes = ac.cey().vIK.getBytes();
                byte[] bytes2 = ac.cey().vIL.getBytes();
                byte[] bArr = null;
                try {
                    bArr = as.CN().CR().KD().KA();
                } catch (Throwable e322) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", bi.i(e322));
                }
                if (bi.by(bArr)) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    return null;
                }
                PByteArray pByteArray = new PByteArray();
                if (bi.oN(str3) || bi.by(bytes2) || bi.by(bytes) || bi.by(bArr)) {
                    String str9 = "MicroMsg.BigBallSysCmdMsgConsumer";
                    String str10 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                    Object[] objArr2 = new Object[4];
                    if (str3 == null) {
                        i4 = -1;
                    } else {
                        i4 = str3.length();
                    }
                    objArr2[0] = Integer.valueOf(i4);
                    objArr2[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                    objArr2[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                    objArr2[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    x.w(str9, str10, objArr2);
                } else {
                    as.Hm();
                    MMProtocalJni.genClientCheckKVRes(c.Cn(), str3, bytes, bytes2, bArr, pByteArray);
                }
                byte[] bArr2 = pByteArray.value;
                aoe = new aoe();
                if (pByteArray.value != null) {
                    aoe.pWq = new String(pByteArray.value);
                } else {
                    aoe.pWq = "";
                }
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                objArr[1] = Integer.valueOf(aoe.pWq.length());
                objArr[2] = com.tencent.mm.a.g.s(aoe.pWq.getBytes());
                x.i(str4, str5, objArr);
                aoe.wBP = a;
                as.Hm();
                c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(59, aoe));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("globalalert")) {
                str2 = (String) map.get(".sysmsg.uuid");
                i3 = bi.getInt((String) map.get(".sysmsg.id"), -1);
                int i6 = bi.getInt((String) map.get(".sysmsg.important"), -1);
                if (bi.oN(str2) || i3 < 0 || i6 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", str2, Integer.valueOf(i3), Integer.valueOf(i6));
                    return null;
                }
                str3 = (String) map.get(".sysmsg.title");
                str4 = (String) map.get(".sysmsg.msg");
                if (bi.oN(str3) && bi.oN(str4)) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", str3, str4);
                    return null;
                }
                str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                int i7 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                i5 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                str82 = (String) map.get(".sysmsg.btnlist.btn");
                if (bi.oN(str5) || i7 < 0 || i5 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                    return null;
                }
                String str11 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                int i8 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                int i9 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                a = (String) map.get(".sysmsg.btnlist.btn1");
                boolean z2 = true;
                if (bi.oN(str11) || i8 < 0 || i9 < 0) {
                    z2 = false;
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", str5, Integer.valueOf(i7), Integer.valueOf(i5));
                }
                com.tencent.mm.sdk.b.b iaVar = new ia();
                com.tencent.mm.protocal.b.a.b bVar2 = new com.tencent.mm.protocal.b.a.b();
                iaVar.fzp.fzq = bVar2;
                bVar2.id = i3;
                bVar2.title = str3;
                bVar2.fpV = str4;
                bVar2.vJE = new LinkedList();
                com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                aVar2.id = i7;
                aVar2.actionType = i5;
                aVar2.vJC = str5;
                aVar2.vJD = str82;
                bVar2.vJE.add(aVar2);
                if (z2) {
                    com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                    aVar3.id = i8;
                    aVar3.actionType = i9;
                    aVar3.vJC = str11;
                    aVar3.vJD = a;
                    bVar2.vJE.add(aVar3);
                }
                boolean m = com.tencent.mm.sdk.b.a.xmy.m(iaVar);
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("yybsigcheck")) {
                com.tencent.mm.plugin.report.service.g.pWK.a(322, 14, 1, false);
                long currentTimeMillis = System.currentTimeMillis();
                str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url"));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Integer.valueOf(4014);
                objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str6, str7});
                gVar.h(11098, objArr3);
                if (bi.oN(str2)) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 15, 1, false);
                    com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.pWK;
                    Object[] objArr4 = new Object[2];
                    objArr4[0] = Integer.valueOf(4015);
                    objArr4[1] = String.format("%s|%s", new Object[]{str6, str7});
                    gVar2.h(11098, objArr4);
                    return null;
                }
                String[] split3 = str2.split(";");
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summertoken newxml infoStrs len is %d";
                objArr = new Object[1];
                objArr[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                x.d(str4, str5, objArr);
                if (split3 == null || split3.length == 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 16, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.h(11098, Integer.valueOf(4016), str2);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                i = 0;
                while (true) {
                    i5 = i;
                    if (i5 >= split3.length) {
                        break;
                    }
                    String str12 = split3[i5];
                    if (bi.oN(str12)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", Integer.valueOf(i5));
                    } else {
                        String[] split4 = str12.split(",");
                        str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str82 = "summertoken newxml fields len is %d";
                        Object[] objArr5 = new Object[1];
                        objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                        x.d(str5, str82, objArr5);
                        if (split4 == null || split4.length != 3) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", Integer.valueOf(i5));
                        } else {
                            try {
                                arrayList.add(new u.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                            } catch (Exception e5) {
                                x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", Integer.valueOf(i5), e5.getMessage());
                                com.tencent.mm.plugin.report.service.g.pWK.a(322, 17, 1, false);
                                com.tencent.mm.plugin.report.service.g.pWK.h(11098, Integer.valueOf(4017), str12);
                            }
                        }
                    }
                    i = i5 + 1;
                }
                if (arrayList.size() == 0) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 18, 1, false);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4018);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str6, str7});
                    gVar.h(11098, objArr3);
                    return null;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", Integer.valueOf(arrayList.size()), Boolean.valueOf(bi.getInt(g.Af().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(u.a(ad.getContext(), arrayList, bi.getInt(g.Af().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (u.a(ad.getContext(), arrayList, bi.getInt(g.Af().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                    as.Hk().setInt(46, 0);
                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 19, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4019);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str6, str7});
                    gVar.h(11098, objArr3);
                } else {
                    as.Hk().setInt(46, 4);
                    com.tencent.mm.sdk.b.b ipVar = new ip();
                    ipVar.fzS.fzT = str6;
                    ipVar.fzS.url = str7;
                    com.tencent.mm.sdk.b.a.xmy.m(ipVar);
                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 20, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(4020);
                    objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str6, str7});
                    gVar.h(11098, objArr3);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("qy_status_notify")) {
                str2 = (String) map.get(".sysmsg.chat_id");
                map.get(".sysmsg.last_create_time");
                str3 = (String) map.get(".sysmsg.brand_username");
                j = e.kw(str2);
                if (j == -1) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", str2);
                    return null;
                }
                i4 = y.Mo().aT(j).field_newUnReadCount;
                y.Mo().aV(j);
                com.tencent.mm.af.a.c ag = y.Mn().ag(j);
                as.Hm();
                XF = c.Fk().XF(str3);
                if (XF == null) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", str3);
                    return null;
                } else if (ag.hr(1)) {
                    if (XF.wc() <= i4) {
                        XF.eW(0);
                        as.Hm();
                        c.Fk().a(XF, str3);
                        as.getNotification().cancelNotification(str3);
                    } else {
                        XF.eW(XF.wc() - i4);
                        as.Hm();
                        c.Fk().a(XF, str3);
                    }
                    return null;
                } else {
                    if (XF.wb() <= i4) {
                        as.Hm();
                        c.Fk().XH(str3);
                        as.getNotification().cancelNotification(str3);
                    } else {
                        XF.eV(0);
                        XF.eY(0);
                        XF.eP(XF.wb() - i4);
                        as.Hm();
                        c.Fk().a(XF, str3);
                    }
                    return null;
                }
            }
        }
        if (str != null) {
            if (str.equals("qy_chat_update")) {
                e.l((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
            }
        }
        if (str != null) {
            if (str.equals("bindmobiletip")) {
                i = bi.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                str4 = bi.oM((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                Object oM = bi.oM((String) map.get(".sysmsg.bindmobiletip.wording"));
                str2 = new String(Base64.decode(str4.getBytes(), 0));
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", Integer.valueOf(i), str2, new String(com.tencent.mm.bp.b.be(com.tencent.mm.compatible.e.q.yM().getBytes()).CW(16).oz), oM);
                if (bi.oN(str2) || str2.equals(r4)) {
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.valueOf(true));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.valueOf(i == 1));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, oM);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckConsistency")) {
                aoe = new auq();
                aoe.hLi = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                aoe.wJo = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                aoe.wJp = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                aoe.vVz = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                aoe.wJq = e(aoe.hLi, (long) aoe.wJo, (long) aoe.wJp);
                aoe.wfl = (int) ga(aoe.hLi);
                aoe.wJr = com.tencent.mm.plugin.normsg.a.d.oXY.bgo() ? 1 : 0;
                aoe.wdO = w.zc();
                aoe.wJs = d(aoe.hLi, Integer.valueOf(aoe.wJo), Integer.valueOf(aoe.wJp), Integer.valueOf(aoe.vVz), aoe.wJq, Integer.valueOf(aoe.wfl), Integer.valueOf(aoe.wJr), Integer.valueOf(aoe.wdO));
                as.Hm();
                c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(61, aoe));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckHook")) {
                aoe = new aus();
                aoe.vVz = bi.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                aoe.wJu = com.tencent.mm.plugin.normsg.a.d.oXY.hg(false);
                aoe.wJr = com.tencent.mm.plugin.normsg.a.d.oXY.bgo() ? 1 : 0;
                aoe.wdO = w.zc();
                aoe.wJs = d(Integer.valueOf(aoe.vVz), aoe.wJu, Integer.valueOf(aoe.wJr), Integer.valueOf(aoe.wdO));
                as.Hm();
                c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(62, aoe));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetAppList")) {
                aoe = new aur();
                aoe.vVz = bi.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                aoe.wJt = com.tencent.mm.plugin.normsg.a.d.oXY.bgn();
                aoe.wJr = com.tencent.mm.plugin.normsg.a.d.oXY.bgo() ? 1 : 0;
                aoe.wdO = w.zc();
                aoe.wJs = d(Integer.valueOf(aoe.vVz), aoe.wJt, Integer.valueOf(aoe.wJr), Integer.valueOf(aoe.wdO));
                as.Hm();
                c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(63, aoe));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetExtInfo")) {
                com.tencent.mm.plugin.secinforeport.a.d.qli.ca(com.tencent.mm.plugin.normsg.a.d.oXY.t(true, true), bi.getInt((String) map.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0));
            }
        }
        if (!bi.oN(str)) {
            if (str.equals("functionmsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                com.tencent.mm.q.c Bt = i.Bt();
                x.k("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", Integer.valueOf(Bt.gLw.size()), Integer.valueOf(bxVar.pgR));
                map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(bxVar.pgR));
                Bt.gLw.add(map);
                Bt.Bj();
            }
        }
        if (!bi.oN(str)) {
            if (str.equals("paymsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(bxVar.vNT), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent"));
                try {
                    str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (!bi.oN(str2)) {
                        com.tencent.mm.sdk.b.b mlVar = new ml();
                        mlVar.fFh.type = i2;
                        mlVar.fFh.content = str2;
                        mlVar.fFh.fAJ = str3;
                        mlVar.fFh.toUser = str4;
                        mlVar.fFh.fFi = str5;
                        com.tencent.mm.sdk.b.a.xmy.m(mlVar);
                    }
                } catch (Throwable e3222) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3222, "", new Object[0]);
                    x.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", e3222.getMessage());
                }
            }
        }
        return bVar;
    }

    private static String e(String str, long j, long j2) {
        Throwable e;
        String str2;
        InputStream inputStream = null;
        ZipFile zipFile;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(ad.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                        str2 = "";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str2;
                    } catch (Throwable th) {
                        e = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw e;
                    }
                }
            }
            zipFile = null;
            inputStream = FileOp.openRead(str);
            while (j > 0) {
                j -= inputStream.skip(j);
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(2048, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            str2 = bi.bA(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e8) {
                }
            }
        } catch (Exception e9) {
            e = e9;
            zipFile = null;
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            str2 = "";
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return str2;
        } catch (Throwable th2) {
            e = th2;
            zipFile = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw e;
        }
        return str2;
    }

    private static long ga(String str) {
        Throwable e;
        Throwable th;
        long j = -1;
        if (!str.startsWith("@")) {
            return FileOp.mi(str);
        }
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(ad.getContext().getApplicationInfo().sourceDir);
            try {
                ZipEntry entry = zipFile.getEntry(str.substring(1));
                if (entry == null) {
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e2) {
                        return j;
                    }
                }
                j = entry.getSize();
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e3) {
                    return j;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            try {
                x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                if (zipFile == null) {
                    return j;
                }
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e6) {
                    return j;
                }
            } catch (Throwable th2) {
                th = th2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    private static String d(Object... objArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                int i;
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (i = 0; i < 4; i++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (i = 0; i < 8; i++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    byteArrayOutputStream.write(i);
                } else {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", obj);
                    return "";
                }
            }
            return bi.bA(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            return "";
        }
    }
}
