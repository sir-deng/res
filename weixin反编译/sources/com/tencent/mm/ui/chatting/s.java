package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.d;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.f;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.u;
import com.tencent.wework.api.WWAPIFactory;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class s implements ac {
    public static at yCw = new at(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private x fBc;
    private l jqz;
    public p liK;
    Animation qBt;
    a yAD;
    public q yAE;
    private ChatFooter yAF;
    public boolean yAH = false;
    public boolean yBT = false;
    private boolean yCA = true;
    public ChattingFooterMoreBtnBar yCx;
    public u yCy;
    private ChatFooterCustom yCz;
    private boolean yxU;

    static /* synthetic */ void h(s sVar) {
        final List csE = sVar.csE();
        new ag().post(new Runnable() {
            public final void run() {
                for (au auVar : csE) {
                    if (auVar.cjT()) {
                        int i;
                        e bi = o.PC().bi(auVar.field_msgSvrId);
                        if (auVar.field_isSend == 1) {
                            int i2;
                            if (bi.Pk()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            i = i2;
                        } else if (bi.Pk()) {
                            if (com.tencent.mm.a.e.bO(o.PC().m(f.a(bi).hBB, "", ""))) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (bi.offset < bi.hmZ || bi.hmZ == 0) {
                            o.PD().a(bi.hBA, auVar.field_msgId, i, Long.valueOf(auVar.field_msgId), R.g.bAI, new d.a() {
                                public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
                                }

                                public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
                                    boolean z = i3 == 0 && i4 == 0;
                                    as.Hm();
                                    s.this.yAE.a(j2, c.Fh().dI(j2), z);
                                }

                                public final void a(long j, long j2, int i, int i2, Object obj) {
                                }
                            });
                        }
                    } else if (auVar.ckb()) {
                        com.tencent.mm.pluginsdk.model.app.l.a(auVar, null);
                    } else if (auVar.cjW() || auVar.cjX()) {
                        r nJ = t.nJ(auVar.field_imgPath);
                        if (!(nJ == null || nJ.status == 199)) {
                            if (nJ.Up()) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                                t.nN(auVar.field_imgPath);
                            } else {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                                t.nF(auVar.field_imgPath);
                            }
                        }
                    }
                }
            }
        });
    }

    public s(a aVar, ChattingFooterMoreBtnBar chattingFooterMoreBtnBar, q qVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z) {
        this.yAD = aVar;
        this.yCx = chattingFooterMoreBtnBar;
        this.yAF = chatFooter;
        this.yCz = chatFooterCustom;
        this.yAE = qVar;
        b(xVar, z);
        this.qBt = AnimationUtils.loadAnimation(aVar.getContext(), R.a.bqo);
        if (this.yAH) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
        } else {
            this.liK = new p(true, true);
            this.liK.zvw = new b() {
                public final void pd(String str) {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                    if (!bi.oN(str)) {
                        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                        s.this.yCx.setVisibility(8);
                        s.this.yAD.yEG.cuI();
                        if (s.this.yCy != null) {
                            s.this.yCy.Ds(str);
                        }
                    } else if (s.this.yAD.yEG.yJy) {
                        if (s.this.yCy != null) {
                            s.this.yCy.Ds("");
                        }
                        s.this.yAD.yEG.FY(-1);
                    } else if (s.this.yBT) {
                        s.this.yAD.yEG.cuJ();
                        s.this.yCx.setVisibility(0);
                        s.this.yCx.FN(s.this.yAE.yBX.size());
                    } else {
                        s.this.yAD.yEG.cuJ();
                        s.this.yCx.setVisibility(8);
                    }
                }

                public final void XA() {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                    if (s.this.yAE.yBT) {
                        s.this.yAD.yEG.cuJ();
                        s.this.yCx.setVisibility(0);
                        s.this.yCx.FN(s.this.yAE.yBX.size());
                    }
                }

                public final void XB() {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                    g.pWK.a(219, 21, 1, true);
                    if (s.this.yAE.yBT) {
                        s.this.yAD.yEG.cuI();
                        s.this.yCx.setVisibility(8);
                    }
                }

                public final boolean pc(String str) {
                    return false;
                }

                public final void XC() {
                }

                public final void XD() {
                }
            };
        }
        this.yCx.c(3, new OnClickListener() {
            public final void onClick(View view) {
                if (s.this.yAE.yBX.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                final Context context = s.this.yAD.getContext();
                h.a(context, context.getString(R.l.dUg), "", context.getString(R.l.dYG), context.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                        h.a(context, s.this.yAE.yBX, s.this);
                        s.this.csF();
                    }
                }, null, R.e.brm);
            }
        });
        this.yCx.c(2, new OnClickListener() {
            public final void onClick(View view) {
                if (s.this.yAE.yBX.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else {
                    l.a(s.this.yAD, s.this.csE(), s.this.yxU, s.this, s.this.fBc);
                }
            }
        });
        this.yCx.c(1, new OnClickListener() {
            public final void onClick(View view) {
                if (s.this.yAE.yBX.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                    return;
                }
                List e = s.this.csE();
                if (i.di(e)) {
                    h.a(s.this.yAD.getContext(), s.this.yAD.getContext().getString(R.l.dXL), "", s.this.yAD.getContext().getString(R.l.dCa), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i.dj(e)) {
                    h.a(s.this.yAD.getContext(), s.this.yAD.getContext().getString(R.l.dXM), "", s.this.yAD.getContext().getString(R.l.dCa), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i.dh(e)) {
                    h.a(s.this.yAD.getContext(), s.this.yAD.getContext().getString(R.l.dXN), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, null);
                } else if (m.a(s.this.yAD, e, s.this.fBc)) {
                    s.this.csF();
                }
            }
        });
        this.yCx.c(0, new OnClickListener() {
            public final void onClick(View view) {
                if (s.this.yAE.yBX.size() == 0) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                } else if ((!com.tencent.mm.y.s.gI(s.this.fBc.field_username) || com.tencent.mm.af.f.eG(s.this.fBc.field_username)) && !com.tencent.mm.y.s.hr(s.this.fBc.field_username)) {
                    s.this.jqz.b(view, new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, R.l.ewd);
                            contextMenu.add(0, 1, 1, R.l.ewe);
                            if (WWAPIFactory.iP(s.this.yAD.getContext()).cIZ()) {
                                contextMenu.add(0, 2, 2, s.this.yAD.getContext().getString(R.l.ewf, new Object[]{WWAPIFactory.iP(s.this.yAD.getContext()).cJa()}));
                            }
                        }
                    }, new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == 0) {
                                s.this.yCA = true;
                                s.h(s.this);
                            } else if (2 == menuItem.getItemId()) {
                                Context context = s.this.yAD.getContext();
                                x g = s.this.fBc;
                                List e = s.this.csE();
                                boolean f = s.this.yxU;
                                if (!(e == null || e.size() == 0)) {
                                    if (i.dh(e)) {
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                                        h.a(context, context.getString(R.l.dXO), "", new com.tencent.mm.ui.chatting.ai.AnonymousClass1(), null);
                                    } else if (i.a(e, null)) {
                                        ai.a(context, g, e, f);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                                        h.a(context, context.getString(R.l.epQ), "", context.getString(R.l.eEP), context.getString(R.l.dEy), new com.tencent.mm.ui.chatting.ai.AnonymousClass2(context, g, e, f), null);
                                    }
                                }
                                s.this.csF();
                                return;
                            } else {
                                s.this.yCA = false;
                            }
                            j.a(s.this.yAD.getContext(), s.this.csE(), s.this.yxU, s.this.fBc.field_username, s.this);
                        }
                    });
                } else {
                    s.this.yCA = true;
                    j.a(s.this.yAD.getContext(), s.this.csE(), s.this.yxU, s.this.fBc.field_username, s.this);
                }
            }
        });
        this.yCx.c(4, new OnClickListener() {
            private void b(cg cgVar) {
                int i;
                cgVar.frk.pL = s.this.yAD;
                cgVar.frk.frr = 41;
                cgVar.frk.frt = new com.tencent.mm.ui.snackbar.b.c() {
                    public final void onShow() {
                        s.this.csF();
                        s.this.yCx.setVisibility(4);
                    }

                    public final void onHide() {
                        s.this.csF();
                    }

                    public final void aPu() {
                        s.this.yAD.yEM.cuz();
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                if (cgVar.frl.ret == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
                List<au> e = s.this.csE();
                long Wx = bi.Wx();
                for (au auVar : e) {
                    if (auVar.aNJ()) {
                        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(auVar.field_content));
                        if (!(fV == null || fV.type != 5 || bi.oN(fV.url))) {
                            int i2;
                            if (auVar.cjK()) {
                                i2 = 1;
                            } else {
                                i2 = 2;
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), fV.url, Long.valueOf(Wx), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1));
                            String str = "";
                            try {
                                str = URLEncoder.encode(fV.url, "UTF-8");
                            } catch (Throwable e2) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e2, "", new Object[0]);
                            }
                            g.pWK.h(13378, str, Long.valueOf(Wx), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i));
                        }
                    }
                }
                if (cgVar.frl.ret != 0) {
                    return;
                }
                if (14 != cgVar.frk.type) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                } else if (cgVar.frk.frn == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                } else {
                    g.pWK.h(11142, Integer.valueOf(cgVar.frk.frn.wmo), Integer.valueOf(cgVar.frk.frn.wmp), Integer.valueOf(cgVar.frk.frn.wmq), Integer.valueOf(cgVar.frk.frn.wmr), Integer.valueOf(cgVar.frk.frn.wms), Integer.valueOf(cgVar.frk.frn.wmt), Integer.valueOf(cgVar.frk.frn.wmu), Integer.valueOf(cgVar.frk.frn.wmv), Integer.valueOf(cgVar.frk.frn.wmw), Integer.valueOf(cgVar.frk.frn.wmx), Integer.valueOf(cgVar.frk.frn.wmy), Integer.valueOf(cgVar.frk.frn.wmz), Integer.valueOf(cgVar.frk.frn.wmA), Integer.valueOf(cgVar.frk.frn.wmB), Integer.valueOf(cgVar.frk.frn.wmC));
                }
            }

            public final void onClick(View view) {
                final List<au> e = s.this.csE();
                if (i.di(e)) {
                    h.a(s.this.yAD.getContext(), s.this.yAD.getContext().getString(R.l.efI), "", s.this.yAD.getContext().getString(R.l.dCa), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                au auVar;
                final cg cgVar = new cg();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", s.this.fBc.field_username);
                if (e != null && e.size() == 1) {
                    auVar = (au) e.get(0);
                    if (auVar != null && (auVar.aNJ() || auVar.cjK())) {
                        String hC = u.hC(auVar.field_msgSvrId);
                        u.b t = u.GQ().t(hC, true);
                        t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                        t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, s.this.yxU, s.this.yAD.yEL.vus));
                        t.o("preChatName", s.this.fBc.field_username);
                        t.o("preMsgIndex", Integer.valueOf(0));
                        t.o("sendAppMsgScene", Integer.valueOf(1));
                        ((i) com.tencent.mm.kernel.g.h(i.class)).a("adExtStr", t, auVar);
                        cgVar.frk.frp = hC;
                    }
                }
                if (com.tencent.mm.pluginsdk.model.h.a(s.this.yAD.getContext(), cgVar, s.this.fBc.field_username, e, false, true)) {
                    for (au auVar2 : e) {
                        if (auVar2.aNJ()) {
                            com.tencent.mm.modelstat.b.hRo.b(auVar2, com.tencent.mm.x.h.g(auVar2));
                        } else {
                            com.tencent.mm.modelstat.b.hRo.u(auVar2);
                        }
                    }
                    b(cgVar);
                    AnonymousClass6.dk(s.this.csE());
                } else if (s.this.csE().size() > 1) {
                    String string;
                    Context context = s.this.yAD.getContext();
                    String string2 = cgVar.frk.frq >= 0 ? s.this.yAD.getContext().getString(R.l.efH) : s.this.yAD.getContext().getString(R.l.efG);
                    String str = "";
                    if (cgVar.frk.frq >= 0) {
                        string = s.this.yAD.getContext().getString(R.l.dUn);
                    } else {
                        string = s.this.yAD.getContext().getString(R.l.eAq);
                    }
                    h.a(context, string2, str, string, s.this.yAD.getContext().getString(R.l.dUl), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            for (au auVar : e) {
                                if (!auVar.cjZ() && !auVar.cjY()) {
                                    if (cgVar.frk.type == 14 && cgVar.frk.frm.wlY.size() == 0) {
                                        s.this.csF();
                                        return;
                                    }
                                    AnonymousClass6.this.b(cgVar);
                                    AnonymousClass6.dk(s.this.csE());
                                    return;
                                }
                            }
                        }
                    }, null);
                } else {
                    h.h(s.this.yAD.getContext(), cgVar.frk.frq, 0);
                }
            }

            private static void dk(List<au> list) {
                for (au a : list) {
                    a.a(a.c.Fav, a.d.Samll, a, 0);
                }
            }
        });
        this.yAE.yCi = new OnClickListener() {
            public final void onClick(View view) {
                if (s.this.yAE.fX(((Long) view.getTag()).longValue())) {
                    int size = s.this.yAE.yBX.size();
                    s.this.yAD.yEG.cuJ();
                    s.this.liK.cyP();
                    s.this.yCx.setVisibility(0);
                    s.this.yCx.FN(size);
                }
            }
        };
        this.jqz = new l(this.yAD.getContext());
    }

    public final void b(x xVar, boolean z) {
        this.fBc = xVar;
        this.yxU = z;
    }

    private List<au> csE() {
        List<au> linkedList = new LinkedList();
        for (Long longValue : this.yAE.yBX) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue.longValue()));
            as.Hm();
            linkedList.add(c.Fh().dI(r4));
        }
        Collections.sort(linkedList, new Comparator<au>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return (int) (((au) obj).field_createTime - ((au) obj2).field_createTime);
            }
        });
        return linkedList;
    }

    public final void aw(au auVar) {
        this.yAD.addSearchMenu(true, this.liK);
        this.yCx.startAnimation(this.qBt);
        this.yCx.setVisibility(0);
        this.yBT = true;
        this.yAD.yEG.cuJ();
        q qVar = this.yAE;
        qVar.yBT = true;
        qVar.notifyDataSetChanged();
        qVar.csD();
        this.yAE.csC();
        this.yAE.fX(auVar.field_msgId);
        this.yCx.FN(this.yAE.yBX.size());
        this.yAD.yEO.cur();
        this.yAD.hideVKB();
        this.yAD.ctB();
        this.yAD.yEM.cuB();
        g.pWK.h(10811, Integer.valueOf(1));
    }

    public final void csF() {
        this.yAD.addSearchMenu(false, this.liK);
        this.yCx.setVisibility(8);
        q qVar = this.yAE;
        qVar.yBT = false;
        qVar.notifyDataSetChanged();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
        qVar.yBC = qVar.yBD;
        qVar.yBE = qVar.AJd;
        qVar.yBF = qVar.yBG;
        qVar.yBH = qVar.yBI;
        qVar.yBJ = qVar.yBK;
        qVar.yAN.yEL.ctX();
        this.yAD.yEG.cuJ();
        this.yBT = false;
        this.yAD.ctB();
        this.yAD.yEO.cus();
        this.yAD.yEM.cuB();
        this.yAD.hideVKB();
        j.csf();
    }

    public final void a(ac.a aVar) {
    }

    public final void csG() {
        if (this.liK != null) {
            this.liK.cyP();
        }
    }

    public final void csH() {
        csF();
    }

    public final void b(ac.a aVar) {
        csF();
    }

    public final boolean csI() {
        return this.yCA;
    }
}
