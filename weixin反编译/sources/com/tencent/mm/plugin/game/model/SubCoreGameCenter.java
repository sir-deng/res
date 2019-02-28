package com.tencent.mm.plugin.game.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.go;
import com.tencent.mm.f.a.gp;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.f.a.gr;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gt;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.f.a.hh;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hj;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.lh;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.f.a.md;
import com.tencent.mm.f.a.ni;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.f.a.qt;
import com.tencent.mm.f.a.rd;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.ui.GameCenterUI;
import com.tencent.mm.plugin.game.ui.GameDetailUI;
import com.tencent.mm.plugin.game.ui.GameLibraryUI;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SubCoreGameCenter implements ap {
    private static String nkq = "";
    @SuppressLint({"UseSparseArrays"})
    static HashMap<Integer, d> nkr;
    private c bannerOnInitListener = new c<ad>() {
        {
            this.xmG = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.foO.foQ = new com.tencent.mm.plugin.game.gamewebview.model.c(com.tencent.mm.sdk.platformtools.ad.getContext());
            a.xmy.m(aeVar);
            return false;
        }
    };
    private bt.a lTH = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            com.tencent.mm.sdk.e.c cVar;
            w aRL = SubCoreGameCenter.aRL();
            String a = n.a(aVar.hoa.vNO);
            x.i("MicroMsg.GameMessageService", "Received a message: %d", Long.valueOf(r1.vNT));
            x.i("MicroMsg.GameMessageService", "Message content: %s" + a);
            new Thread(new com.tencent.mm.plugin.game.model.w.AnonymousClass1(a)).start();
            if (bi.oN(a)) {
                x.e("MicroMsg.GameMessageParser", "msg content is null");
                cVar = null;
            } else {
                Map y = bj.y(a, "sysmsg");
                if (y == null || y.size() == 0) {
                    x.e("MicroMsg.GameMessageParser", "Parse failed");
                    cVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
                    com.tencent.mm.sdk.e.c tVar = new t();
                    tVar.field_showInMsgList = true;
                    tVar.field_msgId = System.currentTimeMillis();
                    tVar.field_rawXML = a;
                    tVar.field_msgType = bi.getInt((String) y.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    long j;
                    if (tVar.field_msgType == 100) {
                        aa.aRf();
                        tVar.field_gameMsgId = bi.aD((String) y.get(".sysmsg.gamecenter.msg_id"), "");
                        tVar.field_appId = (String) y.get(".sysmsg.gamecenter.appid");
                        tVar.field_createTime = bi.getLong((String) y.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = bi.getLong((String) y.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            tVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            tVar.field_expireTime = j + bi.getLong((String) y.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        }
                        tVar.field_isHidden = bi.getInt((String) y.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        tVar.field_mergerId = bi.aD((String) y.get(".sysmsg.gamecenter.merge_id"), "");
                        tVar.field_weight = bi.aD((String) y.get(".sysmsg.gamecenter.weight"), "");
                        tVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        aa.d(y, tVar);
                        tVar.nih = bi.getLong((String) y.get(".sysmsg.gamecenter.filter_flag"), 0);
                        tVar.nii = bi.getInt((String) y.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        tVar.nhT = bi.getInt((String) y.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        tVar.nhU.niG = bi.aD((String) y.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (bi.oN((String) y.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && bi.oN((String) y.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            tVar.nhV = false;
                        } else {
                            tVar.nhV = true;
                        }
                        aa.e(y, tVar);
                        tVar.niz.niT = bi.aD((String) y.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        tVar.niz.kUn = bi.getInt((String) y.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!bi.oN(tVar.niz.niT)) {
                            tVar.field_isHidden = true;
                        }
                        tVar.niz.niU = bi.getLong((String) y.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                    } else {
                        tVar.field_gameMsgId = bi.aD((String) y.get(".sysmsg.gamecenter.msg_id"), "");
                        tVar.field_msgType = bi.getInt((String) y.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (tVar.field_msgType == 0) {
                            tVar.field_msgType = bi.getInt((String) y.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        tVar.field_appId = (String) y.get(".sysmsg.gamecenter.appinfo.appid");
                        tVar.field_showInMsgList = !bi.oN(v.y(y));
                        tVar.field_createTime = bi.getLong((String) y.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = bi.getLong((String) y.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            tVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            tVar.field_expireTime = j + bi.getLong((String) y.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        }
                        tVar.field_isHidden = bi.getInt((String) y.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        tVar.field_mergerId = bi.aD((String) y.get(".sysmsg.gamecenter.merge_id"), "");
                        if (tVar.field_msgType == 10) {
                            tVar.field_weight = "6";
                        } else {
                            tVar.field_weight = "2";
                        }
                        tVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        tVar.nih = bi.getLong((String) y.get(".sysmsg.game_control_info.filter_flag"), 0);
                        tVar.nig = v.z(y);
                        tVar.nii = bi.getInt((String) y.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        tVar.nhV = bi.getInt((String) y.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        tVar.niB = bi.aD((String) y.get(".sysmsg.gamecenter.noticeid"), "");
                        tVar.nhU.niI = bi.getInt((String) y.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        tVar.nhT = tVar.nhU.niI > 0;
                        if ((tVar.nig & 4) == 0) {
                            tVar.nhT = false;
                        }
                        v.b(y, tVar);
                    }
                    if (tVar.nii == 1) {
                        tVar.field_showInMsgList = false;
                    }
                    cVar = tVar;
                } else {
                    x.e("MicroMsg.GameMessageParser", "Type not matched");
                    cVar = null;
                }
            }
            if (cVar != null) {
                int i;
                x.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", Integer.valueOf(cVar.field_msgType), cVar.field_appId, Long.valueOf(cVar.field_msgId));
                if (cVar == null) {
                    x.e("MicroMsg.GameMessageService", "msg is null");
                    i = -1;
                } else {
                    Object obj;
                    long j2;
                    t aQU;
                    String str = cVar.field_gameMsgId;
                    if (!bi.oN(str)) {
                        int i2 = 0;
                        Cursor rawQuery = SubCoreGameCenter.aRK().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i2 = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                            if (i2 > 0) {
                                obj = 1;
                                if (obj == null) {
                                    x.e("MicroMsg.GameMessageService", "duplicated msg:%s", cVar.field_gameMsgId);
                                    i = 2;
                                } else {
                                    if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                                        x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", cVar.field_gameMsgId);
                                        i = 1;
                                    } else {
                                        j2 = cVar.nih;
                                        a = cVar.field_appId;
                                        if (j2 != 1) {
                                            if (bi.oN(a) || !g.m(com.tencent.mm.sdk.platformtools.ad.getContext(), a)) {
                                            }
                                            i = 0;
                                        } else {
                                            if (j2 == 2 && (bi.oN(a) || g.m(com.tencent.mm.sdk.platformtools.ad.getContext(), a))) {
                                            }
                                            i = 0;
                                        }
                                        if (i == 0) {
                                            x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", cVar.field_gameMsgId, Integer.valueOf(i));
                                        } else {
                                            if (cVar.field_msgType != 20) {
                                                aQU = w.aQU();
                                                if (aQU == null) {
                                                    aQU = w.aQW();
                                                }
                                                if (aQU == null) {
                                                    aQU = w.aQY();
                                                }
                                                if (aQU != null) {
                                                    w.a(cVar, aQU);
                                                    if ((cVar.field_weight.compareTo(aQU.field_weight) < 0 ? 1 : null) == null) {
                                                        obj = null;
                                                        if (obj != null) {
                                                            if (cVar.nhT) {
                                                                as.Hm();
                                                                com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                                            } else {
                                                                as.Hm();
                                                                com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                            }
                                                            if (bi.oN(cVar.nij.url)) {
                                                                as.Hm();
                                                                com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                            } else {
                                                                w.aQX();
                                                            }
                                                            if (cVar.nhV) {
                                                                w.aQZ();
                                                            } else {
                                                                as.Hm();
                                                                com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                            }
                                                        }
                                                        if (cVar.field_msgType == 4) {
                                                            as.Hm();
                                                            com.tencent.mm.y.c.Db().a(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                        }
                                                        if (!(cVar == null || bi.oN(cVar.nhU.niG))) {
                                                            com.tencent.mm.plugin.game.d.c.CS(cVar.nhU.niG);
                                                        }
                                                    }
                                                }
                                                obj = 1;
                                                if (obj != null) {
                                                    if (cVar.nhT) {
                                                        as.Hm();
                                                        com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                                    } else {
                                                        as.Hm();
                                                        com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                    }
                                                    if (bi.oN(cVar.nij.url)) {
                                                        w.aQX();
                                                    } else {
                                                        as.Hm();
                                                        com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                    }
                                                    if (cVar.nhV) {
                                                        w.aQZ();
                                                    } else {
                                                        as.Hm();
                                                        com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                    }
                                                }
                                                if (cVar.field_msgType == 4) {
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Db().a(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                }
                                                com.tencent.mm.plugin.game.d.c.CS(cVar.nhU.niG);
                                            }
                                            i = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        if (cVar.field_expireTime > System.currentTimeMillis() / 1000) {
                        }
                        if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                            j2 = cVar.nih;
                            a = cVar.field_appId;
                            i = j2 != 1 ? 4 : 3;
                            if (i == 0) {
                                if (cVar.field_msgType != 20) {
                                    aQU = w.aQU();
                                    if (aQU == null) {
                                        aQU = w.aQW();
                                    }
                                    if (aQU == null) {
                                        aQU = w.aQY();
                                    }
                                    if (aQU != null) {
                                        w.a(cVar, aQU);
                                        if (cVar.field_weight.compareTo(aQU.field_weight) < 0) {
                                        }
                                        if ((cVar.field_weight.compareTo(aQU.field_weight) < 0 ? 1 : null) == null) {
                                            obj = null;
                                            if (obj != null) {
                                                if (cVar.nhT) {
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                                }
                                                if (bi.oN(cVar.nij.url)) {
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    w.aQX();
                                                }
                                                if (cVar.nhV) {
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    w.aQZ();
                                                }
                                            }
                                            if (cVar.field_msgType == 4) {
                                                as.Hm();
                                                com.tencent.mm.y.c.Db().a(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                            }
                                            com.tencent.mm.plugin.game.d.c.CS(cVar.nhU.niG);
                                        }
                                    }
                                    obj = 1;
                                    if (obj != null) {
                                        if (cVar.nhT) {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                                        } else {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                        }
                                        if (bi.oN(cVar.nij.url)) {
                                            w.aQX();
                                        } else {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_FLOATLAYER_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                        }
                                        if (cVar.nhV) {
                                            w.aQZ();
                                        } else {
                                            as.Hm();
                                            com.tencent.mm.y.c.Db().a(w.a.GAME_INDEX_BUBBLE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                        }
                                    }
                                    if (cVar.field_msgType == 4) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(cVar.field_msgId));
                                    }
                                    com.tencent.mm.plugin.game.d.c.CS(cVar.nhU.niG);
                                }
                                i = 0;
                            } else {
                                x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", cVar.field_gameMsgId, Integer.valueOf(i));
                            }
                        } else {
                            x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", cVar.field_gameMsgId);
                            i = 1;
                        }
                    } else {
                        x.e("MicroMsg.GameMessageService", "duplicated msg:%s", cVar.field_gameMsgId);
                        i = 2;
                    }
                }
                if (i == 0) {
                    if (cVar.field_msgType == 20) {
                        com.tencent.mm.sdk.e.c CB = SubCoreGameCenter.aRK().CB(cVar.field_appId);
                        if (CB != null) {
                            SubCoreGameCenter.aRK().a(CB, new String[0]);
                            x.i("MicroMsg.GameMessageService", "duplicated appId, type = %d, appId = %s, msgId = %s", Integer.valueOf(CB.field_msgType), CB.field_appId, Long.valueOf(CB.field_msgId));
                        }
                    }
                    w.g(cVar);
                    x.i("MicroMsg.GameMessageService", "Insert raw message: %b", Boolean.valueOf(SubCoreGameCenter.aRK().b(cVar)));
                    if (SubCoreGameCenter.aRK().b(cVar) && cVar.field_msgType == 20) {
                        e.a(cVar);
                    }
                }
                int i3 = cVar.field_msgType;
                if (cVar.field_msgType == 100) {
                    i3 = cVar.niA;
                }
                ap.a(com.tencent.mm.sdk.platformtools.ad.getContext(), 0, 0, 0, 18, i, cVar.field_appId, 0, i3, cVar.field_gameMsgId, cVar.niB, ap.cS("resource", String.valueOf(cVar.nhU.niI)));
            }
        }
    };
    private c leJ = new c<rd>() {
        {
            this.xmG = rd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rd rdVar = (rd) bVar;
            if (rdVar.fJL.fJM.equals(gs.class.getName())) {
                if (rdVar.fJL.fvo == 1) {
                    SubCoreGameCenter.this.nkA.abp();
                } else {
                    SubCoreGameCenter.this.nkA.unregister();
                }
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.d.d nkA = new com.tencent.mm.pluginsdk.d.d() {
        public final b CH(String str) {
            b gsVar = new gs();
            gsVar.fxI.fpd = str;
            return gsVar;
        }

        public final j aRS() {
            return SubCoreGameCenter.aRK();
        }
    };
    private c nkB = new c<gp>() {
        {
            this.xmG = gp.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gp gpVar = (gp) bVar;
            m.fxC = gpVar.fxB.fxC;
            m.countryCode = gpVar.fxB.countryCode;
            return false;
        }
    };
    private c nkC = new c<hh>() {
        {
            this.xmG = hh.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((hh) bVar).fyt.fxC = m.fxC;
            return false;
        }
    };
    private c nkD = new c<gu>() {
        {
            this.xmG = gu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gu guVar = (gu) bVar;
            x.i("MicroMsg.SubCoreGameCenter", "opType = %d, opStatus = %d, appId = %s", Integer.valueOf(guVar.fxN.opType), Integer.valueOf(guVar.fxN.fxO), guVar.fxN.appId);
            if (guVar.fxN.opType != 0) {
                switch (guVar.fxN.opType) {
                    case 2:
                        n.aQN();
                        n.a(guVar.fxN.appId, guVar.fxN.fxO, false, guVar.fxN.fra);
                        break;
                    case 6:
                        n.aQN();
                        n.cR(guVar.fxN.appId, guVar.fxN.fra);
                        break;
                    default:
                        SubCoreGameCenter.aRN();
                        z.b(guVar.fxN.appId, guVar.fxN.opType, guVar.fxN.fxO, guVar.fxN.openId, guVar.fxN.fra);
                        break;
                }
            }
            return false;
        }
    };
    private c nkE = new c<lw>() {
        {
            this.xmG = lw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            j.aQL().fF(false);
            return false;
        }
    };
    private c nkF = new c<ji>() {
        {
            this.xmG = ji.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.SubCoreGameCenter", "manual force login");
            j.aQL().fF(true);
            return false;
        }
    };
    private c nkG = new c<hj>() {
        {
            this.xmG = hj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hj hjVar = (hj) bVar;
            hjVar.fyy.className = com.tencent.mm.plugin.game.gamewebview.model.b.Cl(hjVar.fyx.url);
            return false;
        }
    };
    private c nkH = new c<qt>() {
        {
            this.xmG = qt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qt qtVar = (qt) bVar;
            StartGameProcessTask startGameProcessTask = new StartGameProcessTask(com.tencent.mm.sdk.platformtools.ad.getContext());
            startGameProcessTask.fnS = qtVar.fJr.bundle.getLong("extra_download_id", -1);
            startGameProcessTask.aLl();
            return false;
        }
    };
    private c nkI = new c<hi>() {
        {
            this.xmG = hi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hi hiVar = (hi) bVar;
            dw aQK = i.aQI().aQK();
            if (aQK != null) {
                hiVar.fyu.fyv = aQK.hdx;
                hiVar.fyu.fyw = aQK.njP;
            }
            return false;
        }
    };
    private c nkJ = new c<gt>() {
        {
            this.xmG = gt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gt gtVar = (gt) bVar;
            String str = gtVar.fxJ.url;
            gtVar.fxK.fxL = com.tencent.mm.plugin.game.a.nbr;
            switch (gtVar.fxJ.pK) {
                case 1:
                    gtVar.fxK.fxM = a.nCD.CO(str);
                    break;
                case 2:
                    a.nCD.CP(str);
                    break;
            }
            return false;
        }
    };
    private x nkk;
    private w nkl;
    private c nkm;
    private ao nkn;
    private z nko;
    private ac nkp;
    private c nks = new c<gq>() {
        {
            this.xmG = gq.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gq gqVar = (gq) bVar;
            n.a(gqVar.fxE.url, gqVar.fxE.frM, gqVar.fxE.scene != 0 ? gqVar.fxE.scene : 1000, gqVar.fxE.appId, gqVar.fxE.extInfo);
            return false;
        }
    };
    private c nkt = new c<md>() {
        {
            this.xmG = md.class.getName().hashCode();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r15) {
            /*
            r14 = this;
            r13 = 12;
            r12 = 11;
            r4 = 2;
            r2 = 0;
            r1 = 1;
            r15 = (com.tencent.mm.f.a.md) r15;
            r0 = r15.fEC;
            r0 = r0.content;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 == 0) goto L_0x018b;
        L_0x0013:
            com.tencent.mm.plugin.game.model.SubCoreGameCenter.aRL();
            com.tencent.mm.y.as.Hm();
            r0 = com.tencent.mm.y.c.Db();
            r3 = com.tencent.mm.storage.w.a.GAME_DISCOVERY_ENTRANCE_MSGID_LONG_SYNC;
            r6 = 0;
            r5 = java.lang.Long.valueOf(r6);
            r0 = r0.get(r3, r5);
            r0 = (java.lang.Long) r0;
            r6 = r0.longValue();
            r0 = 0;
            r8 = 0;
            r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r3 == 0) goto L_0x0222;
        L_0x0036:
            r0 = com.tencent.mm.plugin.game.model.SubCoreGameCenter.aRK();
            r0 = r0.dw(r6);
            r3 = r0;
        L_0x003f:
            if (r3 == 0) goto L_0x0081;
        L_0x0041:
            r3.aQT();
            r6 = r3.field_receiveTime;
            r0 = r3.niz;
            r8 = r0.niU;
            r6 = r6 + r8;
            r8 = java.lang.System.currentTimeMillis();
            r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r8 = r8 / r10;
            r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r0 <= 0) goto L_0x0082;
        L_0x0056:
            r0 = r1;
        L_0x0057:
            r3 = r3.nif;
            if (r3 <= 0) goto L_0x0180;
        L_0x005b:
            r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r3 = com.tencent.mm.sdk.platformtools.ao.isWifi(r3);
            if (r3 == 0) goto L_0x00ce;
        L_0x0065:
            r1 = "MicroMsg.GameWifiStrategy";
            r3 = "WifiStrategy:isInWifi";
            com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        L_0x006e:
            r1 = r2;
        L_0x006f:
            if (r1 != 0) goto L_0x007a;
        L_0x0071:
            if (r0 == 0) goto L_0x007a;
        L_0x0073:
            r0 = com.tencent.mm.plugin.game.model.SubCoreGameCenter.aRK();
            r0.aRc();
        L_0x007a:
            r0 = com.tencent.mm.plugin.game.model.SubCoreGameCenter.aRL();
            r0.a(r15);
        L_0x0081:
            return r2;
        L_0x0082:
            r0 = r3.niz;
            r0 = r0.kUn;
            switch(r0) {
                case 0: goto L_0x008b;
                case 1: goto L_0x008d;
                case 2: goto L_0x00ad;
                default: goto L_0x0089;
            };
        L_0x0089:
            r0 = r2;
            goto L_0x0057;
        L_0x008b:
            r0 = r1;
            goto L_0x0057;
        L_0x008d:
            r0 = new com.tencent.mm.f.a.tx;
            r0.<init>();
            r5 = r0.fNy;
            r5.fql = r4;
            r5 = r0.fNy;
            r6 = r3.niz;
            r6 = r6.niT;
            r5.fNz = r6;
            r5 = com.tencent.mm.sdk.b.a.xmy;
            r5.m(r0);
            r0 = r0.fNy;
            r0 = r0.fNA;
            if (r0 == 0) goto L_0x00ab;
        L_0x00a9:
            r0 = r1;
            goto L_0x0057;
        L_0x00ab:
            r0 = r2;
            goto L_0x0057;
        L_0x00ad:
            r0 = new com.tencent.mm.f.a.tx;
            r0.<init>();
            r5 = r0.fNy;
            r6 = 4;
            r5.fql = r6;
            r5 = r0.fNy;
            r6 = r3.niz;
            r6 = r6.niT;
            r5.fNz = r6;
            r5 = com.tencent.mm.sdk.b.a.xmy;
            r5.m(r0);
            r0 = r0.fNy;
            r0 = r0.fNB;
            if (r0 <= 0) goto L_0x00cc;
        L_0x00ca:
            r0 = r1;
            goto L_0x0057;
        L_0x00cc:
            r0 = r2;
            goto L_0x0057;
        L_0x00ce:
            r3 = new java.util.GregorianCalendar;
            r3.<init>();
            r5 = r3.get(r12);
            r3.get(r13);
            r3 = 21;
            if (r5 < r3) goto L_0x0130;
        L_0x00de:
            r3 = 3;
        L_0x00df:
            r5 = "MicroMsg.GameWifiStrategy";
            r6 = new java.lang.StringBuilder;
            r7 = "WifiStrategy:inWhichTimeRange = ";
            r6.<init>(r7);
            r6 = r6.append(r3);
            r6 = r6.toString();
            com.tencent.mm.sdk.platformtools.x.i(r5, r6);
            if (r3 == 0) goto L_0x006f;
        L_0x00f7:
            r5 = 3;
            if (r3 == r5) goto L_0x006e;
        L_0x00fa:
            if (r3 != r1) goto L_0x0142;
        L_0x00fc:
            r3 = new java.util.GregorianCalendar;
            r3.<init>();
            r3 = r3.get(r12);
            r3 = r3 + -12;
            r3 = r3 << 1;
            r3 = r3 + 1;
            r3 = r3 * 10;
            r3 = r3 + 50;
            r5 = 100;
            r5 = com.tencent.mm.sdk.platformtools.bi.eI(r5, r2);
            r6 = "MicroMsg.GameWifiStrategy";
            r7 = "WifiStrategy:randomHide p = %s, randomNum = %s";
            r4 = new java.lang.Object[r4];
            r8 = java.lang.Integer.valueOf(r3);
            r4[r2] = r8;
            r8 = java.lang.Integer.valueOf(r5);
            r4[r1] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r6, r7, r4);
            if (r3 > r5) goto L_0x006e;
        L_0x012e:
            goto L_0x006f;
        L_0x0130:
            if (r5 >= r13) goto L_0x0134;
        L_0x0132:
            r3 = r2;
            goto L_0x00df;
        L_0x0134:
            r3 = 14;
            if (r5 >= r3) goto L_0x013a;
        L_0x0138:
            r3 = r1;
            goto L_0x00df;
        L_0x013a:
            r3 = 18;
            if (r5 >= r3) goto L_0x0140;
        L_0x013e:
            r3 = r2;
            goto L_0x00df;
        L_0x0140:
            r3 = r4;
            goto L_0x00df;
        L_0x0142:
            if (r3 != r4) goto L_0x006e;
        L_0x0144:
            r3 = new java.util.GregorianCalendar;
            r3.<init>();
            r5 = r3.get(r12);
            r3 = r3.get(r13);
            r5 = r5 + -18;
            r6 = 30;
            if (r3 <= r6) goto L_0x017e;
        L_0x0157:
            r3 = r1;
        L_0x0158:
            r3 = r3 + r5;
            r3 = r3 * 10;
            r3 = r3 + 50;
            r5 = 100;
            r5 = com.tencent.mm.sdk.platformtools.bi.eI(r5, r2);
            r6 = "MicroMsg.GameWifiStrategy";
            r7 = "WifiStrategy:randomHide p = %s, randomNum = %s";
            r4 = new java.lang.Object[r4];
            r8 = java.lang.Integer.valueOf(r3);
            r4[r2] = r8;
            r8 = java.lang.Integer.valueOf(r5);
            r4[r1] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r6, r7, r4);
            if (r3 > r5) goto L_0x006e;
        L_0x017c:
            goto L_0x006f;
        L_0x017e:
            r3 = r2;
            goto L_0x0158;
        L_0x0180:
            if (r0 == 0) goto L_0x007a;
        L_0x0182:
            r0 = com.tencent.mm.plugin.game.model.SubCoreGameCenter.aRK();
            r0.aRc();
            goto L_0x007a;
        L_0x018b:
            r0 = r15.fEC;
            r0 = r0.content;
            if (r0 == 0) goto L_0x0081;
        L_0x0191:
            r3 = "//gamemsg:";
            r3 = r0.startsWith(r3);
            if (r3 == 0) goto L_0x0081;
        L_0x019a:
            r3 = new com.tencent.mm.protocal.c.bx;
            r3.<init>();
            r4 = 10;
            r4 = r0.substring(r4);
            r4 = com.tencent.mm.platformtools.n.oK(r4);
            r3.vNO = r4;
            r3 = 10;
            r0 = r0.substring(r3);
            r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r3 != 0) goto L_0x0081;
        L_0x01b7:
            r3 = "jumpnative";
            r3 = r0.equals(r3);
            if (r3 == 0) goto L_0x01da;
        L_0x01c0:
            r0 = new android.content.Intent;
            r0.<init>();
            r3 = "from_find_more_friend";
            r0.putExtra(r3, r1);
            r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r3 = "game";
            r4 = ".ui.tab.GameRouteUI";
            com.tencent.mm.bl.d.b(r1, r3, r4, r0);
            goto L_0x0081;
        L_0x01da:
            r1 = "jumpLibrary";
            r1 = r0.equals(r1);
            if (r1 == 0) goto L_0x01f7;
        L_0x01e3:
            r0 = new android.content.Intent;
            r0.<init>();
            r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r3 = "game";
            r4 = ".ui.GameLibraryUI";
            com.tencent.mm.bl.d.b(r1, r3, r4, r0);
            goto L_0x0081;
        L_0x01f7:
            r1 = "jumpDetail:";
            r1 = r0.contains(r1);
            if (r1 == 0) goto L_0x0081;
        L_0x0200:
            r1 = r0.length();
            r0 = r0.substring(r12, r1);
            r1 = new android.content.Intent;
            r1.<init>();
            r3 = "game_app_id";
            r1.putExtra(r3, r0);
            r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r3 = "game";
            r4 = ".ui.GameDetailUI2";
            com.tencent.mm.bl.d.b(r0, r3, r4, r1);
            goto L_0x0081;
        L_0x0222:
            r3 = r0;
            goto L_0x003f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.SubCoreGameCenter.24.a(com.tencent.mm.sdk.b.b):boolean");
        }
    };
    private c nku = new c<gn>() {
        {
            this.xmG = gn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gn gnVar = (gn) bVar;
            int i;
            switch (gnVar.fxx.actionCode) {
                case 1:
                    g.a(gnVar.fxx.context, gnVar.fxx.appId, gnVar.fxx.messageAction, gnVar.fxx.messageExt, null);
                    ap.a(gnVar.fxx.context, gnVar.fxx.scene, gnVar.fxx.scene, 1, 3, gnVar.fxx.appId, 0, null);
                    break;
                case 2:
                    i = gnVar.fxx.scene;
                    x.i("MicroMsg.SubCoreGameCenter", "scene = %d, extinfo = %s", Integer.valueOf(i), gnVar.fxx.extMsg);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game_report_from_scene", i);
                    bundle.putCharSequence("game_app_id", gnVar.fxx.appId);
                    bundle.putCharSequence("game_report_extra_click_extinfo", r1);
                    ap.a(gnVar.fxx.context, gnVar.fxx.scene, gnVar.fxx.scene, 1, com.tencent.mm.plugin.game.d.c.a(gnVar.fxx.context, gnVar.fxx.appId, null, bundle), gnVar.fxx.appId, 0, null);
                    break;
                case 3:
                    s.update();
                    break;
                case 5:
                    i = gnVar.fxx.scene;
                    SubCoreGameCenter.aRL();
                    com.tencent.mm.plugin.game.d.c.a(w.aQW(), i);
                    break;
            }
            return false;
        }
    };
    private c nkv = new c<gr>() {
        {
            this.xmG = gr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return AnonymousClass26.b((gr) bVar);
        }

        private static boolean b(gr grVar) {
            t tVar;
            switch (grVar.fxF.pK) {
                case 1:
                    String str = grVar.fxF.fxA;
                    LinkedList linkedList = new LinkedList();
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int i = bi.getInt(jSONObject.optString(Columns.TYPE), 0);
                            int i2 = bi.getInt(jSONObject.optString("limit"), 0);
                            long j = bi.getLong(jSONObject.optString("lastLocalId"), -1);
                            int i3 = bi.getInt(jSONObject.optString("isUnread"), -1);
                            if (i2 > 0 && i2 <= 10000 && j >= 0 && i3 >= 0) {
                                Object b = SubCoreGameCenter.aRK().b(i, j, i3, i2);
                                if (!bi.cC(b)) {
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it = b.iterator();
                                    while (it.hasNext()) {
                                        tVar = (t) it.next();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("localId", tVar.field_msgId);
                                        jSONObject2.put("content", tVar.field_rawXML);
                                        jSONArray.put(jSONObject2);
                                    }
                                    grVar.fxG.fxH = jSONArray.toString();
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            x.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", e.getMessage());
                            break;
                        }
                    }
                    break;
                case 2:
                    y.a(grVar);
                    break;
                case 3:
                    SubCoreGameCenter.aRL();
                    tVar = w.aQY();
                    if (tVar != null) {
                        grVar.fxG.fxH = tVar.field_rawXML;
                        break;
                    }
                    break;
                case 4:
                    SubCoreGameCenter.aRL();
                    w.aQZ();
                    break;
                case 5:
                    SubCoreGameCenter.aRL();
                    as.Hm();
                    tVar = SubCoreGameCenter.aRK().dw(((Long) com.tencent.mm.y.c.Db().get(w.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (tVar == null || tVar.field_isHidden) {
                        tVar = null;
                    }
                    if (tVar != null) {
                        grVar.fxG.fxH = tVar.field_rawXML;
                        break;
                    }
                    break;
                case 6:
                    SubCoreGameCenter.aRL();
                    as.Hm();
                    tVar = SubCoreGameCenter.aRK().dw(((Long) com.tencent.mm.y.c.Db().get(w.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue());
                    if (!(tVar == null || tVar.field_isHidden)) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.GAME_MSG_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                case 9:
                    SubCoreGameCenter.aRL();
                    tVar = w.aRa();
                    if (tVar != null) {
                        grVar.fxG.fxH = tVar.field_rawXML;
                        break;
                    }
                    break;
                case 10:
                    SubCoreGameCenter.aRL();
                    as.Hm();
                    if (SubCoreGameCenter.aRK().dw(((Long) com.tencent.mm.y.c.Db().get(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0))).longValue()) != null) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.GAME_GIFT_ENTRANCE_MSGID_LONG_SYNC, Long.valueOf(0));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private c nkw = new c<lh>() {
        {
            this.xmG = lh.class.getName().hashCode();
        }

        private static boolean a(lh lhVar) {
            String optString;
            int i;
            JSONException e;
            Exception e2;
            Intent intent;
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(lhVar.fDy.extraInfo);
                optString = jSONObject.optString("appId");
                try {
                    i = bi.getInt(jSONObject.optString("ssid"), 0);
                } catch (JSONException e3) {
                    e = e3;
                } catch (Exception e4) {
                    e2 = e4;
                    x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e2.getMessage());
                    i = 0;
                    intent = new Intent();
                    switch (lhVar.fDy.fDz) {
                        case 0:
                            intent.setClass(lhVar.fDy.context, GameCenterUI.class);
                            if (lhVar.fDy.jumpType == 1) {
                                intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            lhVar.fDy.context.startActivity(intent);
                            ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                            break;
                        case 1:
                            intent.setClass(lhVar.fDy.context, GameLibraryUI.class);
                            if (lhVar.fDy.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            lhVar.fDy.context.startActivity(intent);
                            ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                            break;
                        case 2:
                            if (!bi.oN(optString)) {
                                intent.setClass(lhVar.fDy.context, GameDetailUI.class);
                                intent.putExtra("game_app_id", optString);
                                if (lhVar.fDy.jumpType == 1) {
                                    intent.putExtra("jump_game_center", "jump_game_center");
                                }
                                intent.putExtra("game_report_from_scene", 5);
                                lhVar.fDy.context.startActivity(intent);
                                ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                                break;
                            }
                            break;
                        case 3:
                            intent.setClass(lhVar.fDy.context, GameMessageUI.class);
                            intent.putExtra("game_report_from_scene", 5);
                            lhVar.fDy.context.startActivity(intent);
                            ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                            break;
                    }
                    return false;
                }
            } catch (JSONException e5) {
                JSONException jSONException = e5;
                optString = str;
                e = jSONException;
            } catch (Exception e6) {
                Exception exception = e6;
                optString = str;
                e2 = exception;
                x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e2.getMessage());
                i = 0;
                intent = new Intent();
                switch (lhVar.fDy.fDz) {
                    case 0:
                        intent.setClass(lhVar.fDy.context, GameCenterUI.class);
                        if (lhVar.fDy.jumpType == 1) {
                            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lhVar.fDy.context.startActivity(intent);
                        ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                        break;
                    case 1:
                        intent.setClass(lhVar.fDy.context, GameLibraryUI.class);
                        if (lhVar.fDy.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lhVar.fDy.context.startActivity(intent);
                        ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                        break;
                    case 2:
                        if (bi.oN(optString)) {
                            intent.setClass(lhVar.fDy.context, GameDetailUI.class);
                            intent.putExtra("game_app_id", optString);
                            if (lhVar.fDy.jumpType == 1) {
                                intent.putExtra("jump_game_center", "jump_game_center");
                            }
                            intent.putExtra("game_report_from_scene", 5);
                            lhVar.fDy.context.startActivity(intent);
                            ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                            break;
                        }
                        break;
                    case 3:
                        intent.setClass(lhVar.fDy.context, GameMessageUI.class);
                        intent.putExtra("game_report_from_scene", 5);
                        lhVar.fDy.context.startActivity(intent);
                        ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                        break;
                }
                return false;
            }
            intent = new Intent();
            switch (lhVar.fDy.fDz) {
                case 0:
                    intent.setClass(lhVar.fDy.context, GameCenterUI.class);
                    if (lhVar.fDy.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(lhVar.fDy.context, GameLibraryUI.class);
                    if (lhVar.fDy.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (bi.oN(optString)) {
                        intent.setClass(lhVar.fDy.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (lhVar.fDy.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lhVar.fDy.context.startActivity(intent);
                        ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(lhVar.fDy.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
            x.e("MicroMsg.OpenGameJsapiProcessor", "JSONException : %s", e.getMessage());
            i = 0;
            intent = new Intent();
            switch (lhVar.fDy.fDz) {
                case 0:
                    intent.setClass(lhVar.fDy.context, GameCenterUI.class);
                    if (lhVar.fDy.jumpType == 1) {
                        intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
                case 1:
                    intent.setClass(lhVar.fDy.context, GameLibraryUI.class);
                    if (lhVar.fDy.jumpType == 1) {
                        intent.putExtra("jump_game_center", "jump_game_center");
                    }
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
                case 2:
                    if (bi.oN(optString)) {
                        intent.setClass(lhVar.fDy.context, GameDetailUI.class);
                        intent.putExtra("game_app_id", optString);
                        if (lhVar.fDy.jumpType == 1) {
                            intent.putExtra("jump_game_center", "jump_game_center");
                        }
                        intent.putExtra("game_report_from_scene", 5);
                        lhVar.fDy.context.startActivity(intent);
                        ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                        break;
                    }
                    break;
                case 3:
                    intent.setClass(lhVar.fDy.context, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 5);
                    lhVar.fDy.context.startActivity(intent);
                    ap.a(lhVar.fDy.context, 5, 5, 1, 6, i, null);
                    break;
            }
            return false;
        }
    };
    private c nkx = new c<ni>() {
        {
            this.xmG = ni.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ni niVar = (ni) bVar;
            ap.a(com.tencent.mm.sdk.platformtools.ad.getContext(), niVar.fGd.scene, niVar.fGd.fGe, 1, niVar.fGd.action, 0, niVar.fGd.appId, 0, niVar.fGd.msgType, niVar.fGd.fEE, niVar.fGd.fpi, niVar.fGd.fGf);
            return false;
        }
    };
    private c nky = new c<nj>() {
        {
            this.xmG = nj.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            nj njVar = (nj) bVar;
            ap.a(njVar.fGg.context, njVar.fGg.fGh, njVar.fGg.packageName, njVar.fGg.fAJ, njVar.fGg.msgType, njVar.fGg.scene, njVar.fGg.fGi, njVar.fGg.mediaTagName, njVar.fGg.fGj, njVar.fGg.fGk);
            return false;
        }
    };
    private c nkz = new c<go>() {
        {
            this.xmG = go.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            h.a((go) bVar);
            return false;
        }
    };

    public static class StartGameProcessTask extends GameProcessActivityTask {
        public static final Creator<StartGameProcessTask> CREATOR = new Creator<StartGameProcessTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartGameProcessTask(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartGameProcessTask[i];
            }
        };
        public long fnS;

        /* synthetic */ StartGameProcessTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void a(Context context, GameProcessActivityTask.a aVar) {
            Intent intent = new Intent(context, FileDownloadConfirmUI.class);
            intent.putExtra("extra_download_id", this.fnS);
            context.startActivity(intent);
            aVar.afx();
        }

        public final void YB() {
        }

        public final void f(Parcel parcel) {
            this.fnS = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.fnS);
        }

        public StartGameProcessTask(Context context) {
            super(context);
        }

        private StartGameProcessTask(Parcel parcel) {
            f(parcel);
        }
    }

    public SubCoreGameCenter() {
        q.a.vjc = new q.j() {
            public final boolean aRR() {
                try {
                    boolean z;
                    i aQI = i.aQI();
                    if (aQI.nho != null) {
                        z = aQI.nho.nnp;
                    } else {
                        aQI.XQ();
                        x.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", com.tencent.mm.sdk.platformtools.w.d(com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.cgf(), 0)));
                        x.i("MicroMsg.GameConfigManager", "hide game center:[%s]", bi.aD(com.tencent.mm.j.g.Af().getValue("HideGameCenter"), "zh_CN".equals(com.tencent.mm.sdk.platformtools.w.d(com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ad.cgf(), 0))) ? "0" : "1"));
                        z = r0.equalsIgnoreCase("0");
                    }
                    x.i("MicroMsg.GameConfigManager", "getShowEntrance : " + z);
                    return z;
                } catch (Exception e) {
                    return true;
                }
            }

            public final void a(String str, String str2, int i, int i2, String str3, int i3) {
                ap.a(str, str2, i, i2, str3, i3);
            }

            public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
                ap.a(context, str, str2, str3, i, str4, i2);
            }

            public final void a(String str, String str2, int i, int i2, String str3, long j) {
                ap.a(str, str2, i, i2, str3, j);
            }

            public final void L(String str, int i, int i2) {
                ap.h(str, 1, i, i2);
            }

            public final void N(String str, String str2, String str3) {
                ap.N(str, str2, str3);
            }

            public final void o(Context context, String str, String str2) {
                ap.o(context, str, str2);
            }

            public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5) {
                ap.a(context, str, str2, str3, i, i2, i3, str4, 0, str5);
            }

            public final void cR(Context context) {
                context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
                context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
            }
        };
    }

    static {
        HashMap hashMap = new HashMap();
        nkr = hashMap;
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return x.gLy;
            }
        });
        nkr.put(Integer.valueOf("GAME_CENTER_JSON_CACHE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return r.gLy;
            }
        });
        nkr.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return ac.gLy;
            }
        });
    }

    public static String aRI() {
        return nkq;
    }

    private static SubCoreGameCenter aRJ() {
        as.Hg();
        SubCoreGameCenter subCoreGameCenter = (SubCoreGameCenter) bq.ib("plugin.game");
        if (subCoreGameCenter != null) {
            return subCoreGameCenter;
        }
        Object subCoreGameCenter2 = new SubCoreGameCenter();
        as.Hg().a("plugin.game", subCoreGameCenter2);
        return subCoreGameCenter2;
    }

    public static x aRK() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nkk == null) {
            SubCoreGameCenter aRJ = aRJ();
            as.Hm();
            aRJ.nkk = new x(com.tencent.mm.y.c.Fc());
        }
        return aRJ().nkk;
    }

    public static w aRL() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nkl == null) {
            aRJ().nkl = new w();
        }
        return aRJ().nkl;
    }

    public static ao aRM() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nkn == null) {
            aRJ().nkn = new ao();
        }
        return aRJ().nkn;
    }

    public static z aRN() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nko == null) {
            aRJ().nko = new z();
        }
        return aRJ().nko;
    }

    public static ac aRO() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nkp == null) {
            SubCoreGameCenter aRJ = aRJ();
            as.Hm();
            aRJ.nkp = new ac(com.tencent.mm.y.c.Fc());
        }
        return aRJ().nkp;
    }

    public static com.tencent.mm.pluginsdk.model.app.d aRP() {
        return an.aRP();
    }

    public static c aRQ() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aRJ().nkm == null) {
            aRJ().nkm = new c();
        }
        return aRJ().nkm;
    }

    public final HashMap<Integer, d> Bu() {
        return nkr;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        as.getSysCmdMsgExtension().a("gamecenter", this.lTH, true);
        a.xmy.b(this.nks);
        a.xmy.b(this.nkt);
        a.xmy.b(this.leJ);
        a.xmy.b(this.nku);
        a.xmy.b(this.nkv);
        a.xmy.b(this.nkw);
        a.xmy.b(this.nkx);
        a.xmy.b(this.nky);
        a.xmy.b(this.nkB);
        a.xmy.b(this.nkC);
        a.xmy.b(this.nkz);
        a.xmy.b(this.nkD);
        a.xmy.b(this.nkE);
        a.xmy.b(this.nkF);
        a.xmy.b(this.nkG);
        a.xmy.b(this.bannerOnInitListener);
        a.xmy.b(this.nkH);
        a.xmy.b(this.nkI);
        a.xmy.b(this.nkJ);
        n.aQB();
        e.aQB();
        i.aQI().XQ();
        ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                h aVar = new com.tencent.mm.plugin.game.b.a();
                ((m) com.tencent.mm.kernel.g.k(m.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.fts.a.j bVar = new com.tencent.mm.plugin.game.b.b();
                ((m) com.tencent.mm.kernel.g.k(m.class)).registerNativeLogic(5, bVar);
                bVar.create();
                return true;
            }

            public final String getName() {
                return "InitFTSGamePluginTask";
            }
        });
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        as.getSysCmdMsgExtension().b("gamecenter", this.lTH, true);
        a.xmy.c(this.nks);
        a.xmy.c(this.nkt);
        a.xmy.c(this.leJ);
        a.xmy.c(this.nku);
        a.xmy.c(this.nkv);
        a.xmy.c(this.nkw);
        a.xmy.c(this.nkx);
        a.xmy.c(this.nky);
        a.xmy.c(this.nkB);
        a.xmy.c(this.nkC);
        a.xmy.c(this.nkz);
        a.xmy.c(this.nkD);
        a.xmy.c(this.nkE);
        a.xmy.c(this.nkF);
        a.xmy.c(this.nkG);
        a.xmy.c(this.bannerOnInitListener);
        a.xmy.c(this.nkH);
        a.xmy.c(this.nkI);
        a.xmy.c(this.nkJ);
        com.tencent.mm.plugin.game.d.c.amq();
        if (this.nkn != null) {
            e eVar = this.nkn;
            if (eVar.njI != null) {
                eVar.njI.clear();
            }
            as.CN().b(427, eVar);
        }
        if (this.nko != null) {
            as.CN().b(1223, this.nko);
        }
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterIndexStorage(16);
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterNativeLogic(5);
        com.tencent.mm.plugin.fts.d.h.qz(80);
        com.tencent.mm.plugin.fts.d.h.qz(4144);
        n.aQC();
        e.aQC();
    }
}
