package com.tencent.mm.plugin.webwx.a;

import android.content.Intent;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.i;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.d.a;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.qy;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI;
import com.tencent.mm.plugin.webwx.ui.WebWXPopupUnlockUI;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements d, a {
    public final b b(d.a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar != null && bxVar.nlX == 51) {
            x.d("MicroMsg.StatusNotifyMsgExtension", "msgType %d %d", Integer.valueOf(bxVar.nlX), Integer.valueOf(51));
            String a = n.a(bxVar.vNN);
            if (!bi.oN(a)) {
                String trim = n.a(bxVar.vNO).trim();
                Map y = bj.y(trim, "msg");
                if (y != null) {
                    int i = bi.getInt((String) y.get(".msg.op.$id"), 0);
                    x.d("MicroMsg.StatusNotifyMsgExtension", "handleStatusNotifyMsg, %d", Integer.valueOf(i));
                    String trim2;
                    com.tencent.mm.sdk.b.b qyVar;
                    if (i == 1 || i == 2 || i == 5) {
                        x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr mark conversation readed. userName = " + a);
                        com.tencent.mm.plugin.webwx.a.ihN.cancelNotification(a);
                        if (s.gM(a)) {
                            as.Hm();
                            c.Db().set(143618, Integer.valueOf(0));
                            l.TE().Tr();
                        } else {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq");
                            as.Hm();
                            c.Fk().XH(a);
                            if (s.eX(a)) {
                                as.Hm();
                                ae XF = c.Fk().XF(a);
                                if (XF != null && XF.field_unReadCount > 0 && XF.field_UnDeliverCount > 0) {
                                    x.i("MicroMsg.StatusNotifyMsgExtension", "summerbadcr STATUSNOTIFY clearChatRoomMsgSeq chatroom[%s], UnDeliver[%d], Unread[%d]", a, Integer.valueOf(XF.field_UnDeliverCount), Integer.valueOf(XF.field_unReadCount));
                                    com.tencent.mm.plugin.webwx.a.ihO.cB(a);
                                    XF.eP(0);
                                    as.Hm();
                                    c.Fk().a(XF, a);
                                }
                            }
                        }
                    } else if (i == 3) {
                        as.Hm();
                        List cju = c.Fk().cju();
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = 0;
                        while (i2 < cju.size()) {
                            stringBuilder.append(i2 > 0 ? "," : "");
                            stringBuilder.append((String) cju.get(i2));
                            i2++;
                        }
                        as.CN().a(new aj(stringBuilder.toString(), 4), 0);
                    } else if (i == 6) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                    } else if (i == 7) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        r3 = new Object[2];
                        as.Hm();
                        r3[0] = Integer.valueOf(c.Fb());
                        r3[1] = Integer.valueOf(q.Sa());
                        x.d("MicroMsg.StatusNotifyMsgExtension", "onlineversion: %d,%d", r3);
                        a = bi.oM((String) y.get(".msg.op.name")).trim();
                        trim2 = bi.oM((String) y.get(".msg.op.arg")).trim();
                        if ("WeixinStatus".equals(a)) {
                            as.Hm();
                            if (c.Fb() == q.Sa() && q.hPd != null && q.hPd.trim().length() > 0) {
                                Intent intent = new Intent(ad.getContext(), WebWXLogoutUI.class);
                                intent.setFlags(603979776);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("intent.key.online_version", q.Sa());
                                ad.getContext().startActivity(intent);
                            }
                        } else if ("MomentsUnreadMsgStatus".equals(a)) {
                            qyVar = new qy();
                            qyVar.fJC.fvo = 7;
                            qyVar.fJC.fJD = a;
                            qyVar.fJC.fJE = (long) bi.getInt(trim2, 0);
                            x.i("MicroMsg.StatusNotifyMsgExtension", "sns enter function, %d, %s, %d", Integer.valueOf(qyVar.fJC.fvo), qyVar.fJC.fJD, Long.valueOf(qyVar.fJC.fJE));
                            com.tencent.mm.sdk.b.a.xmy.m(qyVar);
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            y.Mw();
                            i.f(i, a, trim2);
                        }
                    } else if (i == 8) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = bi.oM((String) y.get(".msg.op.name")).trim();
                        trim2 = bi.oM((String) y.get(".msg.op.arg")).trim();
                        if ("EnterpriseChatStatus".equals(a)) {
                            y.Mw();
                            i.f(i, a, trim2);
                        } else {
                            com.tencent.mm.sdk.b.b qyVar2 = new qy();
                            qyVar2.fJC.fvo = 8;
                            com.tencent.mm.sdk.b.a.xmy.m(qyVar2);
                        }
                    } else if (i == 9) {
                        x.v("MicroMsg.StatusNotifyMsgExtension", "lyh statusNotify, %d, %s", Integer.valueOf(i), trim);
                        a = bi.oM((String) y.get(".msg.op.name")).trim();
                        trim2 = bi.oM((String) y.get(".msg.op.arg")).trim();
                        if ("MomentsTimelineStatus".equals(a)) {
                            String[] split = trim2.split(",");
                            if (split.length == 2) {
                                qyVar = new qy();
                                qyVar.fJC.fvo = 9;
                                qyVar.fJC.fJD = a;
                                qyVar.fJC.fJE = (long) bi.getInt(split[1], 0);
                                qyVar.fJC.fJF = split[0];
                                com.tencent.mm.sdk.b.a.xmy.m(qyVar);
                            }
                        } else if ("EnterpriseChatStatus".equals(a)) {
                            y.Mw();
                            i.f(i, a, trim2);
                        }
                    } else if (i == 11) {
                        a = bi.oM((String) y.get(".msg.op.name")).trim();
                        trim2 = bi.oM((String) y.get(".msg.op.arg")).trim();
                        if (!"DownloadFile".equals(a)) {
                            x.i("MicroMsg.StatusNotifyMsgExtension", "[MultiTerminalSyncMgr]not DownloadFile, ignore");
                        }
                        y = bj.y(trim2, "downloadList");
                        if (y != null) {
                            int i3 = 0;
                            while (true) {
                                a = ".downloadList.downloadItem" + (i3 == 0 ? "" : Integer.valueOf(i3));
                                int i4 = i3 + 1;
                                trim2 = a + ".username";
                                a = a + ".msgsvrid";
                                trim2 = (String) y.get(trim2);
                                if (!bi.oN(trim2)) {
                                    long j = bi.getLong((String) y.get(a), -1);
                                    if (j == -1) {
                                        break;
                                    }
                                    as.Hm();
                                    cg G = c.Fh().G(trim2, j);
                                    if (G.field_msgSvrId == 0) {
                                        x.i("MicroMsg.StatusNotifyMsgExtension", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(j));
                                        i3 = i4;
                                    } else {
                                        g.bWe().bWg().fn(G.field_msgId);
                                        i3 = i4;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (i == 12) {
                        x.d("MicroMsg.StatusNotifyMsgExtension", "williamjin extdevice unlock " + trim, Integer.valueOf(i));
                        try {
                            if (y.get(".msg.op.arg") != null) {
                                trim2 = new JSONObject((String) y.get(".msg.op.arg")).get("deviceName").toString();
                                if (q.RZ()) {
                                    Intent intent2 = new Intent(ad.getContext(), WebWXPopupUnlockUI.class);
                                    intent2.setFlags(872415232);
                                    intent2.putExtra("deviceName", trim2);
                                    ad.getContext().startActivity(intent2);
                                }
                            } else {
                                x.d("MicroMsg.StatusNotifyMsgExtension", "[williamjin] can not find the tag  .msg.op.arg");
                            }
                        } catch (JSONException e) {
                            x.e("MicroMsg.StatusNotifyMsgExtension", "[williamjin] " + e.getMessage());
                        }
                    } else {
                        x.e("MicroMsg.StatusNotifyMsgExtension", "unknow opCode, %d", Integer.valueOf(i));
                    }
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        x.i("MicroMsg.StatusNotifyMsgExtension", "onImgTaskEnd imgLocalId:%d, msgLocalId:%d", Long.valueOf(j), Long.valueOf(j2));
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
