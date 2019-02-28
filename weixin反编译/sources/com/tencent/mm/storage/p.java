package com.tencent.mm.storage;

import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.f;
import com.tencent.mm.af.o;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.s;
import java.util.Iterator;

public final class p implements d, e {
    private as xuP;

    public p(as asVar) {
        y.Mx();
        this.xuP = asVar;
        this.xuP.a((e) this);
        this.xuP.a((d) this);
    }

    public final void a(au auVar, ae aeVar) {
        String str = null;
        if (aeVar != null && auVar != null && auVar.field_bizChatId != -1 && aeVar.gd(8388608)) {
            c ag = y.Mn().ag(auVar.field_bizChatId);
            String str2 = aeVar.field_digest;
            if (bi.oN(auVar.field_bizChatUserId)) {
                x.w("MicroMsg.BizConversationStorage", "BizChatUserId is null:%s %s", ag.field_bizChatServId, ag.field_chatName);
                return;
            }
            String str3;
            j ca = y.Mp().ca(auVar.field_bizChatUserId);
            if (ca != null) {
                str3 = ca.field_userName;
            } else {
                str3 = null;
            }
            boolean equals = auVar.field_bizChatUserId.equals(y.Mp().cb(auVar.field_talker));
            if (ca != null && equals) {
                aeVar.dH(ad.getContext().getString(b.dFM) + ":" + str2);
            } else if (!(ca == null || bi.oN(ca.field_userName))) {
                aeVar.dH(ca.field_userName + ":" + str2);
            }
            if (!ag.Mz()) {
                if (equals || str3 == null || str3.length() <= 0 || str3.equals(ag.field_chatName)) {
                    j ca2 = y.Mp().ca(ag.field_bizChatServId);
                    if (ca2 != null) {
                        str = ca2.field_userName;
                    }
                    if (str != null && str.length() > 0 && !str.equals(ag.field_chatName)) {
                        ag.field_chatName = str;
                        y.Mn().b(ag);
                        return;
                    }
                    return;
                }
                ag.field_chatName = str3;
                y.Mn().b(ag);
            }
        }
    }

    public final void a(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.BizConversationStorage", "compose notifyInfo is null");
            return;
        }
        String str = cVar.talker;
        if (z) {
            if (!(auVar == null || auVar.field_isSend == 1 || (bd.k(auVar) & 1) == 0)) {
                x.i("MicroMsg.BizConversationStorage", "create a temp session conversation.");
                aeVar.gc(4194304);
            }
            if (auVar != null && f.eG(str)) {
                x.i("MicroMsg.BizConversationStorage", "create a bitChat conversation.");
                aeVar.gc(8388608);
            }
        } else {
            ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
            if (!(Xv == null || !Xv.ciN() || a.ga(Xv.field_type) || auVar == null || auVar.field_isSend == 1 || aeVar.gd(4194304) || (aeVar.field_conversationTime >= y.Mx() && (bd.k(auVar) & 1) == 0))) {
                aeVar.gc(4194304);
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange is old temp session, %s", str);
            }
            if (auVar != null && f.eG(str)) {
                x.i("MicroMsg.BizConversationStorage", "onNotifyChange a bitChat conversation, %s", str);
                aeVar.gc(8388608);
            }
        }
        if (cVar != null && !cVar.ouB.isEmpty() && cVar.ouB.get(0) != null) {
            aeVar.eS(((au) cVar.ouB.get(0)).field_isSend);
            if (cVar.ouA.equals("insert")) {
                aeVar.xGE = (au) cVar.ouB.get(cVar.ouB.size() - 1);
            }
        }
    }

    public final void b(au auVar, ae aeVar, boolean z, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        int i;
        int i2;
        as Fk = ((h) g.h(h.class)).Fk();
        String str = cVar == null ? null : cVar.talker;
        if (cVar == null || !cVar.ouA.equals("delete") || cVar.ouE <= 0) {
            i = 0;
        } else {
            i = cVar.ouE;
        }
        if (cVar == null || !cVar.ouA.equals("insert") || cVar.ouD <= 0) {
            i2 = 0;
        } else {
            i2 = cVar.ouD;
        }
        if (!bi.oN(aeVar.field_parentRef)) {
            ae XF = Fk.XF(aeVar.field_parentRef);
            if (XF != null && XF.gd(2097152)) {
                if (i2 > 0) {
                    if ((cVar.ouA.equals("insert") && cVar.ouC > 0) || (cVar.ouA.equals("update") && XF.field_unReadCount + cVar.ouC >= 0)) {
                        x Xv = ((h) g.h(h.class)).Ff().Xv(str);
                        if (Xv == null || !Xv.AP()) {
                            XF.eP(XF.field_unReadCount + i2);
                        } else {
                            XF.eW(XF.field_unReadMuteCount + i2);
                        }
                    }
                    Fk.a(aeVar, i, i2);
                }
                au Fd = ((h) g.h(h.class)).aZO().Fd(((h) g.h(h.class)).Fk().XQ(aeVar.field_parentRef));
                if (Fd == null || Fd.field_msgId <= 0) {
                    XF.cjn();
                } else {
                    XF.ac(Fd);
                    XF.setContent(Fd.field_talker + ":" + Fd.field_content);
                    XF.dG(Integer.toString(Fd.getType()));
                    if (Fk.ux() != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Fd.dU(aeVar.field_parentRef);
                        Fd.setContent(XF.field_content);
                        Fk.ux().a(Fd, pString, pString2, pInt, true);
                        String aY = Fk.aY(Fd.getType(), Fd.field_content);
                        XF.dH(bi.oM(pString.value).concat(bi.oN(aY) ? "" : " " + bi.oM(aY)));
                        XF.dI(pString2.value);
                        XF.eT(pInt.value);
                    }
                }
                if (Fk.a(XF, aeVar.field_parentRef) > 0) {
                    x.d("MicroMsg.BizConversationStorage", "hakon update parent conversation's unread %s, %d", aeVar.field_parentRef, Integer.valueOf(XF.field_unReadCount + i2));
                    Fk.b(3, (m) Fk, aeVar.field_parentRef);
                }
            } else if (XF == null || !"officialaccounts".equals(XF.field_username)) {
                if (XF != null && "appbrandcustomerservicemsg".equals(XF.field_username) && i2 > 0) {
                    if ((cVar.ouA.equals("insert") && cVar.ouC > 0) || (cVar.ouA.equals("update") && XF.field_unReadCount + cVar.ouC >= 0)) {
                        XF.eP(XF.field_unReadCount + i2);
                    }
                    Fk.a(aeVar, i, i2);
                    Fk.a(XF, aeVar.field_parentRef);
                }
            } else if (i2 > 0 && ((cVar.ouA.equals("insert") && cVar.ouC > 0) || (cVar.ouA.equals("update") && XF.field_unReadCount + cVar.ouC >= 0))) {
                XF.eP(XF.field_unReadCount + i2);
                Fk.a(XF, aeVar.field_parentRef);
            }
        }
        a(str, aeVar, i2, i, cVar);
    }

    private void a(String str, ae aeVar, int i, int i2, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar) {
        if (aeVar != null && cVar != null && cVar.kMn != -1 && aeVar.gd(8388608)) {
            au ao = ((o) g.h(o.class)).Fi().ao(str, cVar.kMn);
            com.tencent.mm.af.a.a aT = y.Mo().aT(cVar.kMn);
            c ag = y.Mn().ag(cVar.kMn);
            if (ag.field_bizChatServId == null) {
                x.w("MicroMsg.BizConversationStorage", "willen updateBizChatConversation bizChatInfo == null");
            } else if (ao == null || ao.field_msgId == 0) {
                x.i("MicroMsg.BizConversationStorage", "update null BizChatConversation with talker " + str);
                aT.field_status = 0;
                aT.field_isSend = 0;
                aT.field_content = "";
                aT.field_msgType = "0";
                aT.field_unReadCount = 0;
                aT.field_digest = "";
                aT.field_digestUser = "";
                y.Mo();
                com.tencent.mm.af.a.b.a(aT, i2, i);
                y.Mo().b(aT);
            } else {
                com.tencent.mm.af.a.a aVar;
                long j;
                Object obj;
                int i3;
                String cb;
                Iterator it;
                Object obj2;
                au auVar;
                boolean Mz = ag.Mz();
                aT.field_brandUserName = str;
                if (ao.cjS()) {
                    aT.field_content = ao.ckt();
                } else {
                    aT.field_content = ao.field_content;
                }
                PString pString = new PString();
                this.xuP.ux().a(ao, pString, new PString(), new PInt(), false);
                String str2 = pString.value;
                j ca = y.Mp().ca(ao.field_bizChatUserId);
                if (!Mz) {
                    aT.field_digest = str2;
                    str2 = null;
                } else if (ao.field_isSend == 1 && ca != null) {
                    aT.field_digest = ad.getContext().getString(b.dFM) + ":" + str2;
                    ca.field_userName = ad.getContext().getString(b.dFM);
                    str2 = null;
                } else if (ca == null || bi.oN(ca.field_userName)) {
                    aT.field_digest = str2;
                    str2 = null;
                } else {
                    aT.field_digest = ca.field_userName + ":" + str2;
                    str2 = ca.field_userName;
                }
                String aY = this.xuP.aY(ao.getType(), ao.field_content);
                aT.field_digest = bi.oM(aT.field_digest).concat(bi.oN(aY) ? "" : " " + bi.oM(aY));
                aT.field_digestUser = "";
                aT.field_chatType = ag.field_chatType;
                aT.field_lastMsgID = ao.field_msgId;
                if (ao.cjX()) {
                    aVar = aT;
                } else if (ao.field_status == 1) {
                    j = Long.MAX_VALUE;
                    aVar = aT;
                    aVar.field_lastMsgTime = j;
                    aT.field_status = ao.field_status;
                    aT.field_isSend = ao.field_isSend;
                    aT.field_msgType = Integer.toString(ao.getType());
                    aT.field_flag = com.tencent.mm.af.a.b.a(aT, 1, ao.field_createTime);
                    obj = null;
                    if ((cVar.ouA.equals("insert") && cVar.ouC > 0) || (cVar.ouA.equals("update") && aT.field_unReadCount + cVar.ouC >= 0)) {
                        aT.field_unReadCount += cVar.ouC;
                        aT.field_newUnReadCount += cVar.ouC;
                        if (cVar.ouC > 0 && ag.hr(1)) {
                            i3 = aeVar.field_unReadCount - cVar.ouC;
                            if (i3 > 0) {
                                aeVar.eP(0);
                            } else {
                                aeVar.eP(i3);
                            }
                            aeVar.eW(aeVar.field_unReadMuteCount + cVar.ouC);
                            obj = 1;
                        }
                    }
                    if (cVar.ouA.equals("insert") && cVar.ouB.size() > 0 && ag.Mz()) {
                        cb = y.Mp().cb(ao.field_talker);
                        it = cVar.ouB.iterator();
                        while (true) {
                            obj2 = obj;
                            if (it.hasNext()) {
                                break;
                            }
                            auVar = (au) it.next();
                            if (cb == null && auVar.field_isSend != 1 && auVar.cjV() && auVar.XX(cb)) {
                                aT.field_atCount++;
                                aeVar.eV(aeVar.field_atCount + 1);
                                obj = 1;
                            } else {
                                obj = obj2;
                            }
                        }
                        obj = obj2;
                    }
                    y.Mo();
                    com.tencent.mm.af.a.b.a(aT, i2, i);
                    if (bi.oN(str2)) {
                        str2 = ag.gw(ao.field_bizChatUserId);
                    }
                    x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, ag.field_bizChatServId, ao.field_bizChatUserId, str2);
                    y.Mo().b(aT);
                    if (obj != null) {
                        this.xuP.a(aeVar, str);
                    }
                } else {
                    aVar = aT;
                }
                j = ao.field_createTime;
                aVar.field_lastMsgTime = j;
                aT.field_status = ao.field_status;
                aT.field_isSend = ao.field_isSend;
                aT.field_msgType = Integer.toString(ao.getType());
                aT.field_flag = com.tencent.mm.af.a.b.a(aT, 1, ao.field_createTime);
                obj = null;
                aT.field_unReadCount += cVar.ouC;
                aT.field_newUnReadCount += cVar.ouC;
                i3 = aeVar.field_unReadCount - cVar.ouC;
                if (i3 > 0) {
                    aeVar.eP(i3);
                } else {
                    aeVar.eP(0);
                }
                aeVar.eW(aeVar.field_unReadMuteCount + cVar.ouC);
                obj = 1;
                cb = y.Mp().cb(ao.field_talker);
                it = cVar.ouB.iterator();
                while (true) {
                    obj2 = obj;
                    if (it.hasNext()) {
                        break;
                    }
                    auVar = (au) it.next();
                    if (cb == null) {
                    }
                    obj = obj2;
                }
                obj = obj2;
                y.Mo();
                com.tencent.mm.af.a.b.a(aT, i2, i);
                if (bi.oN(str2)) {
                    str2 = ag.gw(ao.field_bizChatUserId);
                }
                x.i("MicroMsg.BizConversationStorage", "updateBizChatConversation brandUserName:%s, bizChatId:%s, userId:%s, displayName:%s", str, ag.field_bizChatServId, ao.field_bizChatUserId, str2);
                y.Mo().b(aT);
                if (obj != null) {
                    this.xuP.a(aeVar, str);
                }
            }
        }
    }

    public final void WZ(String str) {
        if (str != null && s.gI(str) && f.ka(str)) {
            ae XF = this.xuP.XF(str);
            if (XF != null) {
                au Fd = ((h) g.h(h.class)).aZO().Fd(((h) g.h(h.class)).Fk().XQ(str));
                if (Fd != null && Fd.field_msgId > 0) {
                    XF.ac(Fd);
                    XF.setContent(Fd.field_talker + ":" + Fd.field_content);
                    XF.dG(Integer.toString(Fd.getType()));
                    as.b ux = this.xuP.ux();
                    if (ux != null) {
                        PString pString = new PString();
                        PString pString2 = new PString();
                        PInt pInt = new PInt();
                        Fd.dU(str);
                        Fd.setContent(XF.field_content);
                        ux.a(Fd, pString, pString2, pInt, true);
                        XF.dH(pString.value);
                        XF.dI(pString2.value);
                        XF.eT(pInt.value);
                    } else {
                        XF.cjn();
                    }
                    this.xuP.a(XF, XF.field_username);
                }
            }
        }
    }
}
