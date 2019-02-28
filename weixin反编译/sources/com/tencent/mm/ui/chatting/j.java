package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.f;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.i;
import com.tencent.mm.x.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static a yAj = new a();

    private static class a {
        String fFG;
        cg fFb;
        ac yAi;
        List<au> yAp;
        d yAq;
        boolean yxU;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.j$4 */
    static class AnonymousClass4 implements com.tencent.mm.sdk.platformtools.at.a {
        final /* synthetic */ Runnable fgt = null;
        final /* synthetic */ String gKE;
        final /* synthetic */ Context val$context;
        final /* synthetic */ boolean yAo;

        AnonymousClass4(Context context, String str, boolean z, Runnable runnable) {
            this.val$context = context;
            this.gKE = str;
            this.yAo = z;
        }

        public final boolean JH() {
            if (j.yAj.yAp == null) {
                return false;
            }
            for (au d : j.yAj.yAp) {
                j.d(this.val$context, this.gKE, d, j.yAj.yxU);
            }
            return true;
        }

        public final boolean JI() {
            if (j.yAj.yAp != null) {
                g.pWK.h(10811, Integer.valueOf(5), Integer.valueOf(j.yAj.yAp.size()), Integer.valueOf(j.yAj.yAp.size() - i.dg(j.yAj.yAp)));
            }
            if (this.yAo) {
                if (this.fgt != null) {
                    x.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                    this.fgt.run();
                }
                if (j.yAj.yAi != null) {
                    j.yAj.yAi.b(com.tencent.mm.ui.chatting.ac.a.trans);
                }
                j.csf();
            }
            return true;
        }
    }

    static /* synthetic */ void d(Context context, String str, au auVar, boolean z) {
        x.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", Long.valueOf(auVar.field_msgId));
        if (!i.al(auVar) && !i.am(auVar)) {
            boolean eX;
            if (f.eG(str) && !auVar.cjT() && !auVar.cjV() && !auVar.cjL()) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", Integer.valueOf(auVar.getType()));
            } else if (auVar.cjT()) {
                i.b(context, str, auVar);
            } else if (auVar.cjW()) {
                i.c(context, str, auVar);
            } else if (auVar.cjX()) {
                i.c(context, str, auVar);
                eX = s.eX(str);
                a.a(eX ? c.Chatroom : c.Chat, a.d.Samll, auVar, eX ? m.gn(str) : 0);
            } else if (auVar.cjV()) {
                i.a(context, str, auVar, z);
            } else if (auVar.cjO() || auVar.aNJ()) {
                eX = s.eX(str);
                a.a(eX ? c.Chatroom : c.Chat, a.d.Samll, auVar, eX ? m.gn(str) : 0);
                if (auVar.cjZ()) {
                    if (i.a(context, str, auVar, "appEmoji")) {
                        com.tencent.mm.x.g.a aVar;
                        aj XW = aj.XW(auVar.field_content);
                        com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(auVar.field_content, auVar.field_reserved);
                        if (I == null) {
                            I = new com.tencent.mm.x.g.a();
                            I.hcO = XW.frM;
                            aVar = I;
                        } else {
                            aVar = I;
                        }
                        if (bi.oN(aVar.hcO) || aVar.hcO.equalsIgnoreCase("-1")) {
                            x.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                            return;
                        }
                        x.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", str, aVar.hcO);
                        EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(aVar.hcO);
                        if (yI != null) {
                            i.b(yI, str);
                        } else {
                            x.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", XW);
                        }
                    }
                } else if (auVar.cjK()) {
                    try {
                        l wr = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).wr(auVar.field_content);
                        List<com.tencent.mm.x.m> list = wr.hfI;
                        if (list != null) {
                            for (com.tencent.mm.x.m mVar : list) {
                                com.tencent.mm.x.g.a aVar2 = new com.tencent.mm.x.g.a();
                                if (i.fX(mVar.hfT)) {
                                    k.b(str, k.a(str, mVar), mVar.hfY);
                                } else {
                                    aVar2.title = mVar.title;
                                    aVar2.description = mVar.hfQ;
                                    aVar2.action = "view";
                                    aVar2.type = 5;
                                    aVar2.url = mVar.url;
                                    aVar2.fHu = wr.fHu;
                                    aVar2.fHv = wr.fHv;
                                    aVar2.gkB = wr.gkB;
                                    aVar2.thumburl = mVar.hfO;
                                    if (bi.oN(aVar2.thumburl)) {
                                        h jp = n.JW().jp(auVar.field_talker);
                                        if (jp != null) {
                                            aVar2.thumburl = jp.JM();
                                        }
                                    }
                                    i.a(context, str, com.tencent.mm.x.g.a.a(aVar2, null, null), auVar.field_isSend, z);
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                        x.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", e.getLocalizedMessage());
                    }
                } else {
                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_isSend == 0 ? bb.hT(auVar.field_content) : auVar.field_content);
                    if (fV == null) {
                        x.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false);
                    if (aZ != null && aZ.YI()) {
                        x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    } else if (fV.type == 19) {
                        b mvVar = new mv();
                        mvVar.fFz.type = 4;
                        mvVar.fFz.fFE = auVar;
                        mvVar.fFz.toUser = str;
                        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                    } else {
                        if (fV.type == 5 && !bi.oN(fV.url)) {
                            String str2 = "";
                            try {
                                str2 = URLEncoder.encode(fV.url, "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                            }
                            long Wx = bi.Wx();
                            x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), fV.url, Long.valueOf(Wx), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                            g.pWK.h(13378, str2, Long.valueOf(Wx), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
                        }
                        i.b(context, str, auVar, z);
                    }
                }
            } else if (auVar.cjU()) {
                if (i.a(context, str, auVar, "friendcard")) {
                    String q = i.q(auVar.field_content, auVar.field_isSend, z);
                    com.tencent.mm.plugin.messenger.a.f.aZN().C(str, q, com.tencent.mm.storage.x.Xg(com.tencent.mm.storage.au.a.XY(q).sfb) ? 66 : 42);
                }
            } else if (auVar.cjY() || auVar.cjZ()) {
                if (!i.ai(auVar)) {
                    i.a(context, str, auVar);
                }
            } else if (auVar.aNL()) {
                i.c(context, str, auVar, z);
            }
        }
    }

    public static void a(Context context, List<au> list, boolean z, String str, ac acVar) {
        csf();
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        } else if (i.a(list, acVar)) {
            Object obj;
            if (list != null && !list.isEmpty()) {
                for (au auVar : list) {
                    String str2 = null;
                    if (!auVar.ckh()) {
                        if (auVar.cjT()) {
                            e eVar = null;
                            if (auVar.field_msgId > 0) {
                                eVar = o.PC().bj(auVar.field_msgId);
                            }
                            if ((eVar == null || eVar.hBA <= 0) && auVar.field_msgSvrId > 0) {
                                eVar = o.PC().bi(auVar.field_msgSvrId);
                            }
                            if (eVar != null) {
                                str2 = o.PC().m(com.tencent.mm.ap.f.c(eVar), "", "");
                            }
                        } else if (auVar.cjX() || auVar.cjW()) {
                            com.tencent.mm.modelvideo.o.Ub();
                            str2 = com.tencent.mm.modelvideo.s.nx(auVar.field_imgPath);
                        } else if (auVar.aNJ()) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
                            if (fV != null) {
                                com.tencent.mm.pluginsdk.model.app.b Sn = com.tencent.mm.pluginsdk.model.app.l.Sn(fV.for);
                                if (Sn != null) {
                                    str2 = Sn.field_fileFullPath;
                                }
                            }
                        } else {
                            str2 = auVar.field_imgPath;
                        }
                        if (auVar.cjT() || auVar.cjW() || auVar.cjX() || i.av(auVar)) {
                            obj = (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bi.oN(str2) && com.tencent.mm.a.e.bO(str2))) ? null : 1;
                            if (obj == null) {
                            }
                        }
                        obj = null;
                        break;
                    }
                }
            } else {
                x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            }
            obj = 1;
            if (obj != null) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                if (acVar == null) {
                    return;
                }
                if (acVar.csI() || list.size() == 1) {
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.eeg), context.getString(R.l.dGZ), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                return;
            }
            b(context, list, z, str, acVar);
        } else {
            final List<au> list2 = list;
            final ac acVar2 = acVar;
            final Context context2 = context;
            final boolean z2 = z;
            final String str3 = str;
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.epQ), "", context.getString(R.l.dGL), context.getString(R.l.dEy), (OnClickListener) new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Object obj;
                    List<au> list = list2;
                    if (list != null && !list.isEmpty()) {
                        for (au auVar : list) {
                            if (!i.an(auVar)) {
                                if (!auVar.cjL() && !i.ai(auVar) && !i.ak(auVar) && !i.at(auVar) && !i.al(auVar) && auVar.getType() != -1879048186 && !i.as(auVar) && !i.am(auVar) && !i.ar(auVar) && !i.an(auVar) && auVar.getType() != 318767153) {
                                    obj = null;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
                    obj = 1;
                    if (obj != null) {
                        x.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
                        if (acVar2 != null) {
                            acVar2.b(com.tencent.mm.ui.chatting.ac.a.trans);
                            return;
                        }
                        return;
                    }
                    j.b(context2, list2, z2, str3, acVar2);
                }
            }, null);
        }
    }

    private static void b(Context context, List<au> list, boolean z, String str, final ac acVar) {
        if (i.di(list)) {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dXL), "", context.getString(R.l.dCa), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (acVar != null) {
                        ac acVar = acVar;
                        com.tencent.mm.ui.chatting.ac.a aVar = com.tencent.mm.ui.chatting.ac.a.trans;
                        acVar.csH();
                    }
                }
            });
            return;
        }
        int i;
        yAj.yAp = new LinkedList(list);
        yAj.yxU = z;
        yAj.yAi = acVar;
        yAj.fFG = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            String hC;
            int i2;
            au auVar = (au) list.get(0);
            if (auVar.aNJ() || auVar.cjK()) {
                hC = u.hC(auVar.field_msgSvrId);
                u.b t = u.GQ().t(hC, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, z, false));
                t.o("preChatName", auVar.field_talker);
                t.o("preMsgIndex", Integer.valueOf(0));
                t.o("sendAppMsgScene", Integer.valueOf(1));
                t.o("moreRetrAction", Boolean.valueOf(true));
                if (z) {
                    t.o("fromScene", Integer.valueOf(2));
                } else {
                    t.o("fromScene", Integer.valueOf(1));
                }
                ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", t, auVar);
                intent.putExtra("reportSessionId", hC);
            }
            String str2 = auVar.field_content;
            int i3 = 12;
            if (auVar.aNL()) {
                i3 = 9;
                hC = str2;
            } else if (auVar.cjY()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                hC = str2;
            } else if (auVar.cjU()) {
                i3 = 8;
                hC = str2;
            } else {
                r nJ;
                if (auVar.cjV()) {
                    i3 = 4;
                    if (z && auVar.field_isSend == 0) {
                        hC = bb.hT(str2);
                    }
                } else if (auVar.cjT()) {
                    e eVar = null;
                    if (auVar.field_msgId > 0) {
                        eVar = o.PC().bj(auVar.field_msgId);
                    }
                    if ((eVar == null || eVar.hBA <= 0) && auVar.field_msgSvrId > 0) {
                        eVar = o.PC().bi(auVar.field_msgSvrId);
                    }
                    intent.putExtra("Retr_File_Name", o.PC().m(com.tencent.mm.ap.f.c(eVar), "", ""));
                    i3 = 0;
                    hC = str2;
                } else if (auVar.cjX()) {
                    nJ = t.nJ(auVar.field_imgPath);
                    if (nJ != null) {
                        intent.putExtra("Retr_length", nJ.hXv);
                    }
                    i3 = 11;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    hC = str2;
                } else if (auVar.cjW()) {
                    nJ = t.nJ(auVar.field_imgPath);
                    if (nJ != null) {
                        intent.putExtra("Retr_length", nJ.hXv);
                    }
                    i3 = 1;
                    intent.putExtra("Retr_File_Name", auVar.field_imgPath);
                    hC = str2;
                } else if (auVar.aNJ()) {
                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str2);
                    if (fV != null && 19 == fV.type) {
                        i3 = 10;
                    } else if (fV != null && 24 == fV.type) {
                        i3 = 10;
                    } else if (fV == null || 16 != fV.type) {
                        i3 = 2;
                    } else {
                        i3 = 14;
                    }
                    if (auVar.cjK()) {
                        intent.putExtra("is_group_chat", z);
                    }
                }
                hC = str2;
            }
            if (auVar.cjK()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (acVar == null || acVar.csI()) {
                intent.putExtra("Retr_Msg_Type", i3);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_Msg_content", hC);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((acVar == null || !acVar.csI()) && ((!s.gI(str) || f.eG(str)) && !s.hr(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
            i = 2;
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
            i = 2;
        }
        intent.putExtra("Retr_MsgFromScene", i);
        intent.putExtra("Retr_show_success_tips", true);
        context.startActivity(intent);
        as.Dt().F(new com.tencent.mm.ui.chatting.k.AnonymousClass1(yAj.yAp));
    }

    public static void j(Context context, String str, boolean z) {
        b mvVar = new mv();
        mvVar.fFz.type = 5;
        mvVar.fFz.fFF = yAj.yAp;
        mvVar.fFz.toUser = str;
        mvVar.fFz.fFG = yAj.fFG;
        mvVar.fFz.context = context;
        mvVar.fFz.fFb = yAj.fFb;
        mvVar.fFz.fFI = yAj.yAq;
        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
        if (yAj.yAp != null) {
            g.pWK.h(10811, Integer.valueOf(8), Integer.valueOf(yAj.yAp.size()), Integer.valueOf(yAj.yAp.size() - i.dg(yAj.yAp)));
            for (au auVar : yAj.yAp) {
                long Wx = bi.Wx();
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(auVar.field_content));
                if (!(fV == null || fV.type != 5 || bi.oN(fV.url))) {
                    int i;
                    if (auVar.cjK()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(fV.url, "UTF-8");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), fV.url, Long.valueOf(Wx), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                    g.pWK.h(13378, str2, Long.valueOf(Wx), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        if (z && yAj.yAi != null) {
            yAj.yAi.b(com.tencent.mm.ui.chatting.ac.a.trans);
        }
    }

    public static void mK(boolean z) {
        if (z && yAj.yAi != null) {
            yAj.yAi.b(com.tencent.mm.ui.chatting.ac.a.trans);
        }
    }

    public static mv fM(Context context) {
        b mvVar = new mv();
        mvVar.fFz.type = 6;
        mvVar.fFz.fFF = yAj.yAp;
        mvVar.fFz.fFG = yAj.fFG;
        mvVar.fFz.context = context;
        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
        yAj.fFb = mvVar.fFA.fFb;
        yAj.yAq = mvVar.fFA.fFI;
        return mvVar;
    }

    public static void k(Context context, String str, boolean z) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
        } else if (bi.oN(str)) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
        } else if (yAj.yAp == null || yAj.yAp.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
        } else {
            x.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", str);
            s.yCw.c(new AnonymousClass4(context, str, z, null));
        }
    }

    public static void csf() {
        yAj.yAp = null;
        yAj.yxU = false;
        yAj.yAi = null;
        yAj.fFG = null;
        yAj.fFb = null;
        yAj.yAq = null;
    }
}
