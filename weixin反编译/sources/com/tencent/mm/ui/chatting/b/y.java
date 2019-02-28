package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.aw.a.b;
import com.tencent.mm.ax.e;
import com.tencent.mm.be.i;
import com.tencent.mm.f.a.bt;
import com.tencent.mm.f.a.kc;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.g.a;
import com.tencent.mm.ui.chatting.g.c;
import com.tencent.mm.ui.chatting.g.d;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y implements b, a.b {
    private l contextMenuHelper;
    p fhH;
    public a yEI;
    public e yEK;
    public c yEL;
    public q yEz;
    public final x yKA;
    public com.tencent.mm.ui.chatting.g.b yKB;
    public c yKC;
    public d yKD;
    public int yKE;
    public int yKF;
    public int yKG;

    public y(p pVar) {
        this.fhH = pVar;
        this.yKA = new x(pVar);
    }

    public final void aB(LinkedList<String> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            aC(linkedList);
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(aVar.username);
            a(view, linkedList, aVar.hPT);
        }
    }

    public final void aH(au auVar) {
        if (!this.fhH.csW().field_username.equals("medianote")) {
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new e(auVar.field_talker, auVar.field_msgSvrId));
        }
        af.aH(auVar);
        this.fhH.mT(true);
    }

    public final boolean dp(String str, final int i) {
        int i2 = 0;
        final String WD = bi.WD(str);
        if (WD == null || WD.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "doSendMessage null");
            return false;
        }
        x xVar = this.yKA;
        if (!t.oN(WD)) {
            au auVar = new au();
            auVar.setContent(WD);
            auVar.eS(1);
            xVar.aB(auVar);
        }
        com.tencent.mm.sdk.b.b btVar = new bt();
        btVar.fqO.fqQ = WD;
        btVar.fqO.context = this.fhH.cte().getContext();
        com.tencent.mm.sdk.b.a.xmy.m(btVar);
        if (btVar.fqP.fqR) {
            return true;
        }
        if (this.fhH.ctk() != null) {
            String str2 = null;
            String Yo = this.fhH.ctk().xIx.Yo("");
            if (Yo.equalsIgnoreCase("@t.qq.com") && !this.fhH.ctk().isEnable()) {
                str2 = this.fhH.cte().getMMString(R.l.ejw);
            } else if (Yo.equalsIgnoreCase("@qqim") && (q.Gc() & 64) == 0) {
                str2 = this.fhH.cte().getMMString(R.l.ejv);
            } else if (!this.fhH.ctk().isEnable()) {
                str2 = this.fhH.cte().getMMString(R.l.eju, com.tencent.mm.k.a.fd(this.fhH.ctk().name));
            }
            if (str2 != null) {
                h.b(this.fhH.cte().getContext(), str2, this.fhH.cte().getMMString(R.l.dGZ), true);
                return false;
            }
        }
        boolean z = HardCoderJNI.hcSendMsgEnable;
        int i3 = HardCoderJNI.hcSendMsgDelay;
        int i4 = HardCoderJNI.hcSendMsgCPU;
        int i5 = HardCoderJNI.hcSendMsgIO;
        if (HardCoderJNI.hcSendMsgThr) {
            i2 = g.Dt().cgq();
        }
        this.yKG = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcSendMsgTimeout, 202, HardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.TextImp");
        this.fhH.ctg().post(new Runnable() {
            public final void run() {
                f.vR(20);
                int i = (y.this.fhH.csW().field_username.equals("medianote") && (q.Gc() & 16384) == 0) ? 1 : 0;
                if (i != 0) {
                    y.this.fhH.ctj();
                    as.CN().a(new com.tencent.mm.ak.a(y.this.fhH.csW().field_username, WD), 0);
                    return;
                }
                String csY;
                if (y.this.fhH.ctm().getCount() == 0 && com.tencent.mm.storage.x.Xf(y.this.fhH.csn())) {
                    bp.HY().c(10076, Integer.valueOf(1));
                }
                String csn = y.this.fhH.csn();
                int hs = s.hs(csn);
                String str = WD;
                q qVar = y.this.yEz;
                if (qVar.fhH.csZ()) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.LbsImp", "[oneliang]encrypt:" + qVar.fhH.vZ() + ",raw:" + qVar.fhH.csY());
                    csY = bi.oN(qVar.fhH.vZ()) ? qVar.fhH.csY() : qVar.fhH.vZ();
                } else {
                    csY = csn;
                }
                if (bi.oN(csY)) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.TextImp", "tempUser is null");
                    return;
                }
                ChatFooter ctp = y.this.fhH.ctp();
                int i2 = i;
                int i3 = ctp.vwR.vxS.containsKey(csn) ? ((LinkedList) ctp.vwR.vxS.get(csn)).size() > 0 ? JsApiCreateAudioInstance.CTRL_INDEX : i2 : i2;
                k jVar = new j(csY, str, hs, i3, y.this.fhH.ctp().fl(csn, str));
                q qVar2 = y.this.yEz;
                if (qVar2.fhH.csZ()) {
                    com.tencent.mm.be.h hVar;
                    csY = qVar2.kBn;
                    i TF = com.tencent.mm.be.l.TF();
                    String vZ = qVar2.fhH.vZ();
                    Cursor a = TF.gLA.a("SELECT * FROM " + TF.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0" + " ORDER BY createtime desc LIMIT 1", new String[]{vZ}, 2);
                    if (a == null) {
                        hVar = null;
                    } else if (a.moveToFirst()) {
                        hVar = new com.tencent.mm.be.h();
                        hVar.b(a);
                        a.close();
                    } else {
                        a.close();
                        hVar = null;
                    }
                    if (!(hVar == null || bi.oN(hVar.field_ticket))) {
                        csY = hVar.field_ticket;
                    }
                    if (bi.oN(csY)) {
                        hVar = com.tencent.mm.be.l.TF().nf(qVar2.fhH.vZ());
                        if (!(hVar == null || bi.oN(hVar.field_ticket))) {
                            csY = hVar.field_ticket;
                        }
                    }
                    if (csY != null) {
                        jVar.hHs = new com.tencent.mm.plugin.bbom.h(csY);
                    }
                }
                as.CN().a(jVar, 0);
                if (s.ho(csn)) {
                    as.CN().a(new n(com.tencent.mm.compatible.e.q.za(), WD + " key " + be.ckL() + " local key " + be.ckK() + "NetType:" + ao.getNetTypeString(y.this.fhH.cte().getContext().getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.e.n.yC() + " isArmv6: " + com.tencent.mm.compatible.e.n.yE() + " isArmv7: " + com.tencent.mm.compatible.e.n.yD()), 0);
                }
            }
        });
        this.fhH.mT(true);
        return true;
    }

    private void aC(LinkedList<String> linkedList) {
        if (this.fhH.csT()) {
            c cVar = this.yEL;
            com.tencent.mm.af.y.Mn().ag(cVar.ctW());
            LinkedList linkedList2 = new LinkedList();
            List My = cVar.yvJ.My();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (My != null && My.contains(str)) {
                    linkedList2.add(str);
                }
            }
            if (linkedList2.size() != 0) {
                h.a(cVar.fhH.cte().getContext(), cVar.fhH.cte().getMMString(R.l.eFp, cVar.az(linkedList2)), null, cVar.fhH.cte().getMMString(R.l.eFw), cVar.fhH.cte().getMMString(R.l.dEy), true, new com.tencent.mm.ui.chatting.b.c.AnonymousClass5(linkedList2), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            } else if (linkedList.size() == 1) {
                h.a(cVar.fhH.cte().getContext(), cVar.fhH.cte().getMMString(R.l.eFu), null, cVar.fhH.cte().getMMString(R.l.eFv), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            } else {
                h.a(cVar.fhH.cte().getContext(), cVar.fhH.cte().getMMString(R.l.eFq), null, cVar.fhH.cte().getMMString(R.l.eFv), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            }
        }
        this.yEK.aA(linkedList);
    }

    private void a(View view, final LinkedList<String> linkedList, final String str) {
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(this.fhH.cte().getContext());
        }
        this.contextMenuHelper.b(view, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eFy));
                contextMenu.add(0, 1, 1, view.getContext().getString(R.l.eFr));
            }
        }, new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        y.this.yEK.aA(linkedList);
                        return;
                    case 1:
                        final com.tencent.mm.sdk.b.b kcVar = new kc();
                        Context context = y.this.fhH.cte().getContext();
                        y.this.fhH.cte().getString(R.l.dGZ);
                        y.this.fhH.b(h.a(context, y.this.fhH.cte().getString(R.l.eFt), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                kcVar.fCj.fBE = true;
                                com.tencent.mm.sdk.b.a.xmy.m(kcVar);
                            }
                        }));
                        kcVar.fCj.chatroomName = y.this.fhH.csW().field_username;
                        kcVar.fCj.fCl = str;
                        com.tencent.mm.sdk.b.a.xmy.m(kcVar);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void a(View view, au auVar, com.tencent.mm.aw.a aVar, int i) {
        if (aVar instanceof com.tencent.mm.aw.d) {
            com.tencent.mm.aw.d dVar = (com.tencent.mm.aw.d) aVar;
            String oM = bi.oM(dVar.hKi);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.TextImp", "click delchatroommember link %s,isBizChat:%s", oM, Boolean.valueOf(this.yEL.vus));
            if (dVar.hKw == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "click members is null!!!");
            } else if (!this.fhH.csR()) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.TextImp", "not group chat !!!!!");
            } else if (oM.equals("invite")) {
                aC(dVar.hKw);
            } else if (oM.equals("qrcode")) {
                a(view, dVar.hKw, dVar.fCl);
            } else if (oM.equals("webview") && !bi.oN(dVar.url)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", dVar.url);
                intent.putExtra("geta8key_username", q.FY());
                com.tencent.mm.bl.d.b(this.fhH.cte().getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        } else if (aVar instanceof com.tencent.mm.aw.c) {
            com.tencent.mm.aw.c cVar = (com.tencent.mm.aw.c) aVar;
            if (i == 0) {
                a aVar2 = this.yEI;
                String str = cVar.hKt;
                String str2 = cVar.hKu;
                String str3 = cVar.hKn;
                String str4 = cVar.fsK;
                List list = cVar.hKo;
                List list2 = cVar.hKr;
                List list3 = cVar.hKs;
                Intent intent2 = new Intent();
                intent2.putExtra("msgLocalId", auVar.field_msgId);
                intent2.putExtra("invitertitle", aVar2.fhH.cte().getString(R.l.dCo, Integer.valueOf(list.size())));
                intent2.putExtra("inviterusername", str);
                intent2.putExtra("chatroom", str3);
                intent2.putExtra("invitationreason", str2);
                intent2.putExtra("ticket", str4);
                intent2.putExtra("username", bi.d(list, ","));
                intent2.putExtra("nickname", bi.d(list2, ","));
                intent2.putExtra("headimgurl", bi.d(list3, ","));
                com.tencent.mm.bl.d.b(aVar2.fhH.cte().getContext(), "chatroom", ".ui.SeeAccessVerifyInfoUI", intent2);
            }
        } else if (aVar instanceof com.tencent.mm.aw.b) {
            com.tencent.mm.aw.b bVar = (com.tencent.mm.aw.b) aVar;
            List arrayList = new ArrayList();
            arrayList.addAll(bVar.hKo);
            e eVar = this.yEK;
            k kVar = new com.tencent.mm.plugin.chatroom.d.k(eVar.fhH.csS() ? eVar.fhH.csW().field_username : "", arrayList, bVar.fsK, auVar);
            as.CN().a(kVar, 0);
            Context context = eVar.fhH.cte().getContext();
            eVar.fhH.cte().getString(R.l.dGZ);
            eVar.fhH.b(h.a(context, eVar.fhH.cte().getString(R.l.eFL), true, new com.tencent.mm.ui.chatting.b.e.AnonymousClass3(kVar)));
        } else if (aVar instanceof com.tencent.mm.ui.chatting.d.a) {
            as.Hm();
            if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue()) {
                final View view2 = view;
                final com.tencent.mm.aw.a aVar3 = aVar;
                h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eqD), this.fhH.cte().getMMString(R.l.cSb), this.fhH.cte().getMMString(R.l.epx), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        y.this.a(view2, (com.tencent.mm.ui.chatting.d.a) aVar3);
                    }
                });
                return;
            }
            a(view, (com.tencent.mm.ui.chatting.d.a) aVar);
        }
    }

    final void a(final View view, com.tencent.mm.ui.chatting.d.a aVar) {
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_POSITION_INVOKE_EDIT_TIP_IN_BOOLEAN, Boolean.valueOf(false));
        final au auVar = aVar.fFE;
        if (System.currentTimeMillis() - aVar.yPN >= 300000) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.TextImp", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
            h.b(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eqE), this.fhH.cte().getMMString(R.l.dGZ), true);
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.TextImp", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", Long.valueOf(auVar.field_msgId));
                    z.a(y.this.fhH.cte().getMMString(R.l.dSX), "", auVar, "");
                    as.Hm();
                    com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                    ah.y(new Runnable() {
                        public final void run() {
                            view.invalidate();
                        }
                    });
                }
            }, "deleteInvokeMsg");
            return;
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(15037, Integer.valueOf(1));
        this.fhH.ctp().Td(this.fhH.ctp().ccf() + aVar.yPM);
        if (!this.fhH.ctp().ccD()) {
            this.fhH.cte().showVKB();
        }
    }
}
