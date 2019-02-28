package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.f.a.md;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class w {

    /* renamed from: com.tencent.mm.plugin.game.model.w$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String iIE;

        AnonymousClass1(String str) {
            this.iIE = str;
        }

        public final void run() {
            if (bi.oN(this.iIE)) {
                x.e("MicroMsg.GameMessageService", "msg content is null");
                return;
            }
            Map y = bj.y(this.iIE, "sysmsg");
            if (y == null || y.size() == 0) {
                x.e("MicroMsg.GameMessageService", "Parse failed");
                return;
            }
            String aD = bi.aD((String) y.get(".sysmsg.wepkg.$pkg_id"), "");
            x.i("MicroMsg.GameMessageService", "MicroMsg.Wepkg message pkgid:%s", aD);
            if (!bi.oN(aD)) {
                b txVar = new tx();
                txVar.fNy.fql = 1;
                txVar.fNy.fNz = aD;
                a.xmy.m(txVar);
            }
        }
    }

    static void a(t tVar, t tVar2) {
        tVar2.aQT();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldNoticeId", tVar2.niB);
            jSONObject.put("oldMsgId", tVar2.field_gameMsgId);
            if (tVar.field_weight.compareTo(tVar2.field_weight) >= 0) {
                jSONObject.put("coverType", 1);
            } else {
                jSONObject.put("coverType", 2);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameMessageService", "reportMsgCover: " + e.getMessage());
        }
        int i = tVar.field_msgType;
        if (tVar.field_msgType == 100) {
            i = tVar.niA;
        }
        ap.a(ad.getContext(), 0, 0, 0, 31, 0, tVar.field_appId, 0, i, tVar.field_gameMsgId, tVar.niB, ap.CD(jSONObject.toString()));
    }

    public final void a(md mdVar) {
        t aQU = aQU();
        if (aQU != null) {
            aQU.aQT();
            ap.CE(aQU.niB);
            mdVar.fEC.showType = aQU.nhU.niI;
            mdVar.fEC.appId = aQU.field_appId;
            mdVar.fEC.appName = aQU.nhU.kav;
            mdVar.fEC.fED = aQU.nhU.niG;
            mdVar.fEC.msgType = aQU.field_msgType;
            if (aQU.field_msgType == 100) {
                mdVar.fEC.msgType = aQU.niA;
            }
            mdVar.fEC.fEE = aQU.field_gameMsgId;
            mdVar.fEC.fpi = aQU.niB;
        }
    }

    public static t aQU() {
        t dw;
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            dw = SubCoreGameCenter.aRK().dw(longValue);
        } else {
            dw = null;
        }
        if (dw != null && !dw.field_isHidden && !f(dw)) {
            return dw;
        }
        ap.CE("");
        return null;
    }

    public static void aQV() {
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRK().dw(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
        }
    }

    public static t aQW() {
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        t dw = SubCoreGameCenter.aRK().dw(longValue);
        if (dw == null || dw.field_isHidden || f(dw)) {
            return null;
        }
        return dw;
    }

    public static void aQX() {
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRK().dw(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(0));
        }
    }

    public static t aQY() {
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        t dw = SubCoreGameCenter.aRK().dw(longValue);
        if (dw == null || dw.field_isHidden || f(dw)) {
            return null;
        }
        return dw;
    }

    public static void aQZ() {
        as.Hm();
        long longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRK().dw(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(0));
        }
    }

    public static t aRa() {
        as.Hm();
        return SubCoreGameCenter.aRK().dw(((Long) c.Db().get(com.tencent.mm.storage.w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
    }

    private static boolean f(t tVar) {
        return tVar.field_expireTime < System.currentTimeMillis() / 1000;
    }

    static void g(t tVar) {
        if (!bi.oN(tVar.field_mergerId)) {
            com.tencent.mm.sdk.e.c cVar;
            x aRK = SubCoreGameCenter.aRK();
            String str = "select * from GameRawMessage where msgType=" + tVar.field_msgType + " and mergerId= \"" + tVar.field_mergerId + "\" order by createTime desc limit 1";
            com.tencent.mm.sdk.e.c tVar2 = new t();
            Cursor rawQuery = aRK.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                cVar = null;
            } else {
                if (rawQuery.moveToFirst()) {
                    tVar2.b(rawQuery);
                }
                rawQuery.close();
                cVar = tVar2;
            }
            if (cVar != null) {
                cVar.aQT();
                if (!bi.cC(cVar.nhS)) {
                    tVar.aQT();
                    Object linkedList = new LinkedList(cVar.nhS);
                    if (!bi.cC(tVar.nhS)) {
                        String str2 = ((h) tVar.nhS.get(0)).userName;
                        if (!bi.oN(str2)) {
                            Iterator it = cVar.nhS.iterator();
                            while (it.hasNext()) {
                                h hVar = (h) it.next();
                                if (hVar.userName.equals(str2)) {
                                    linkedList.remove(hVar);
                                    break;
                                }
                            }
                        }
                    }
                    if (!bi.cC(linkedList)) {
                        tVar.field_rawXML = aq.a(tVar.field_rawXML, linkedList, cVar.nhX);
                    }
                    SubCoreGameCenter.aRK().a(cVar, new String[0]);
                }
            }
        }
    }
}
