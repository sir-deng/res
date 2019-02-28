package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.buo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.x.g;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.LinkedList;

public final class ai extends b {
    private e hRg;
    private ProgressDialog qob;
    private a yyH;

    public final boolean aXP() {
        return false;
    }

    public final boolean ak(int i, boolean z) {
        if (i == -1879048189) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.den);
        view.setTag(new an().dG(view));
        return view;
    }

    protected final boolean cwl() {
        return false;
    }

    public final void a(b.a aVar, final int i, a aVar2, final au auVar, String str) {
        String S;
        an anVar = (an) aVar;
        this.yyH = aVar2;
        g fq = an.bZF().fq(auVar.field_msgId);
        String str2 = auVar.field_content;
        g.a aVar3 = null;
        if (!(fq == null || str2 == null)) {
            aVar3 = g.a.fV(str2);
        }
        boolean z = false;
        final com.tencent.mm.plugin.subapp.c.e MO = com.tencent.mm.plugin.subapp.c.e.MO(str2);
        if (!(MO == null || MO.sct == 0)) {
            try {
                S = n.S(this.yyH.getContext(), MO.sct);
                if (!(aVar3 == null || aVar3.description == null)) {
                    int indexOf = aVar3.description.indexOf(124);
                    if (indexOf <= 0 || aVar3.description.length() <= indexOf + 1) {
                        anVar.ikM.setText("");
                    } else {
                        anVar.ikM.setText(aVar3.description.substring(indexOf + 1));
                    }
                }
                if (S != null && S.length() > 0) {
                    String[] split = S.split(";");
                    anVar.yXh.setText(split[0]);
                    if (split.length > 1) {
                        anVar.yXi.setText(split[1]);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = t.ja(MO.sct);
        }
        if (z) {
            anVar.yXl.setVisibility(0);
            anVar.ikM.setTextColor(this.yyH.getResources().getColor(R.e.bud));
            anVar.yXi.setTextColor(this.yyH.getResources().getColor(R.e.bud));
            anVar.yXh.setTextColor(this.yyH.getResources().getColor(R.e.bud));
        } else {
            anVar.yXl.setVisibility(8);
            anVar.ikM.setTextColor(this.yyH.getResources().getColor(R.e.buc));
            anVar.yXi.setTextColor(this.yyH.getResources().getColor(R.e.buc));
            anVar.yXh.setTextColor(this.yyH.getResources().getColor(R.e.buc));
        }
        anVar.yXj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (t.oN(auVar.field_imgPath)) {
                    x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                } else {
                    ai.this.yyH.yAM.yBy.b(i, auVar);
                }
            }
        });
        Object obj = (this.yyH.yAM.yBy != null && this.yyH.yAM.yBy.isPlaying() && this.yyH.yAM.yBy.yyT == auVar.field_msgId) ? 1 : null;
        if (obj != null) {
            anVar.yXj.setBackgroundResource(R.g.bHl);
        } else {
            anVar.yXj.setBackgroundResource(R.g.bHm);
        }
        if (!(MO == null || t.oN(MO.scv) || MO.scw <= 0 || !t.oN(auVar.field_reserved) || aVar3 == null)) {
            str2 = k.nw(q.FY());
            S = h.aJ(str2, false);
            auVar.dW(str2);
            as.Hm();
            c.Fh().a(auVar.field_msgId, auVar);
            long j = auVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = MO.scv;
            int i3 = MO.scw;
            int i4 = aVar3.type;
            String str5 = aVar3.hda;
            S = l.a(S, j, i2, str3, str4, i3, i4, aVar3.hcQ);
            if (S != null) {
                com.tencent.mm.ad.n CN = as.CN();
                e anonymousClass2 = new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ak.a.hhy != null) {
                            z = ak.a.hhy.aK(auVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(S)) {
                            au ae = au.ae(auVar);
                            ae.dV(auVar.field_reserved);
                            ae.ao(-1);
                            ai.this.yyH.yAM.yBy.b(i, ae);
                        }
                        as.CN().b(221, ai.this.hRg);
                        ai.this.hRg = null;
                    }
                };
                this.hRg = anonymousClass2;
                CN.a(221, anonymousClass2);
                com.tencent.mm.ad.k abVar = new ab(S);
                abVar.bZA();
                as.CN().a(abVar, 0);
            }
        }
        if (t.oN(auVar.field_imgPath) && MO.scz > 0) {
            as.Hm();
            cg G = c.Fh().G(auVar.field_talker, (long) MO.scz);
            if (!t.oN(G.field_imgPath)) {
                str2 = k.nw(q.FY());
                if (com.tencent.mm.sdk.platformtools.k.r(h.aJ(G.field_imgPath, false), h.aJ(str2, false), false)) {
                    auVar.dV(str2);
                    as.Hm();
                    c.Fh().a(auVar.field_msgId, auVar);
                }
            }
        }
        if (t.oN(auVar.field_imgPath) && MO != null && !t.oN(MO.for) && MO.hcM > 0 && this.hRg == null) {
            str2 = k.nw(q.FY());
            S = h.aJ(str2, false);
            auVar.dV(str2);
            as.Hm();
            c.Fh().a(auVar.field_msgId, auVar);
            final b a = l.a(S, auVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.for, aVar3.hcM);
            x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                com.tencent.mm.ad.n CN2 = as.CN();
                e anonymousClass3 = new e() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        if (((ab) kVar).getMediaId().equals(a.field_mediaSvrId)) {
                            as.CN().b(221, ai.this.hRg);
                            ai.this.hRg = null;
                        }
                    }
                };
                this.hRg = anonymousClass3;
                CN2.a(221, anonymousClass3);
                as.CN().a(new ab(a), 0);
            }
        }
        anVar.yXk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(ai.this.yyH.getContext(), R.l.eUe, R.l.eUg, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        as.CN().a(331, ai.this.hRg = new e() {
                            public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                                x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                                if (i == 0 && i2 == 0) {
                                    g.a fV;
                                    String str2 = auVar.field_content;
                                    if (str2 != null) {
                                        fV = g.a.fV(str2);
                                    } else {
                                        fV = null;
                                    }
                                    if (fV != null) {
                                        l.fr(auVar.field_msgId);
                                    }
                                    bb.aL(auVar.field_msgId);
                                    Toast.makeText(ai.this.yyH.getContext(), ai.this.yyH.getString(R.l.dRI), 0).show();
                                }
                                as.CN().b(331, ai.this.hRg);
                                ai.this.hRg = null;
                                if (ai.this.qob != null) {
                                    ai.this.qob.dismiss();
                                }
                            }
                        });
                        LinkedList linkedList = new LinkedList();
                        buo buo = new buo();
                        buo.vOO = MO.scu;
                        linkedList.add(buo);
                        final com.tencent.mm.ad.k aVar = new com.tencent.mm.plugin.subapp.c.a(linkedList, linkedList.size());
                        as.CN().a(aVar, 0);
                        ai aiVar = ai.this;
                        Context context = ai.this.yyH.getContext();
                        ai.this.yyH.getString(R.l.dGZ);
                        aiVar.qob = com.tencent.mm.ui.base.h.a(context, ai.this.yyH.getString(R.l.dRJ), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(aVar);
                                as.CN().b(331, ai.this.hRg);
                                ai.this.hRg = null;
                                if (ai.this.qob != null) {
                                    ai.this.qob.dismiss();
                                }
                            }
                        });
                    }
                }, null);
            }
        });
        anVar.yRn.setTag(new ar(auVar, this.yyH.yxU, i, null, (byte) 0));
        as.Hm();
        if (c.isSDCardAvailable()) {
            anVar.yRn.setOnLongClickListener(s(this.yyH));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        int Sm = l.Sm(this.yyH.dn(auVar.field_content, auVar.field_isSend));
        g.a fV = g.a.fV(this.yyH.dn(auVar.field_content, auVar.field_isSend));
        if (fV.hcM <= 0 || (fV.hcM > 0 && Sm >= 100)) {
            contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
        }
        if (!this.yyH.ctJ()) {
            contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.fV(str);
                }
                if (aVar2 != null) {
                    l.fr(auVar.field_msgId);
                }
                bb.aL(auVar.field_msgId);
                break;
            case 111:
                Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.dn(auVar.field_content, auVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return true;
    }
}
