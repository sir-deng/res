package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.e;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public final class l {
    private static r yAh = null;
    private static a yAs;

    private static class a {
        String fFG;
        cg fFb;
        boolean yAA;
        List<au> yAp;
        d yAq;
        boolean yxU;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b implements com.tencent.mm.sdk.platformtools.at.a {
        private Context context;
        private String hpQ;
        private long kMn;
        private boolean vus;
        private com.tencent.mm.ui.chatting.ChattingUI.a yAB;
        private a yAC;

        public b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, Context context, String str, long j, a aVar2) {
            this.yAB = aVar;
            this.context = context;
            this.hpQ = str;
            this.kMn = j;
            this.yAC = aVar2;
            this.vus = f.eG(str);
        }

        public final boolean JH() {
            if (this.vus) {
                c ag = y.Mn().ag(this.kMn);
                synchronized (e.hsB) {
                    String HJ = e.HJ();
                    e.d(ag);
                    if (this.yAC.yAA) {
                        csj();
                    } else {
                        csk();
                    }
                    e.kv(HJ);
                }
            } else if (this.yAC.yAA) {
                csj();
            } else {
                csk();
            }
            return true;
        }

        private void csj() {
            for (au auVar : this.yAC.yAp) {
                Context context = this.context;
                boolean z = this.yAC.yxU;
                String str = this.hpQ;
                if (auVar.cjV()) {
                    i.a(context, str, auVar, z);
                } else if (auVar.cjT()) {
                    i.b(context, str, auVar);
                } else if (auVar.cjW() && !this.vus) {
                    i.c(context, str, auVar);
                } else if (auVar.aNL()) {
                    i.c(context, str, auVar, z);
                } else if ((auVar.cjY() || auVar.cjZ()) && !this.vus) {
                    if (!i.ai(auVar)) {
                        i.a(context, str, auVar);
                    }
                } else if (auVar.aNJ() && !((this.vus && !i.aq(auVar)) || i.ar(auVar) || auVar.getType() == 318767153 || i.av(auVar) || i.ak(auVar))) {
                    i.b(context, str, auVar, z);
                }
            }
        }

        private void csk() {
            l.bv(this.context, this.hpQ);
            com.tencent.mm.sdk.b.b mvVar = new mv();
            mvVar.fFz.type = 5;
            mvVar.fFz.fFF = this.yAC.yAp;
            mvVar.fFz.toUser = this.hpQ;
            mvVar.fFz.fFG = this.yAC.fFG;
            mvVar.fFz.context = this.context;
            mvVar.fFz.fFb = this.yAC.fFb;
            mvVar.fFz.fFI = this.yAC.yAq;
            com.tencent.mm.sdk.b.a.xmy.m(mvVar);
        }

        public final boolean JI() {
            if (l.yAh != null) {
                l.yAh.dismiss();
            }
            com.tencent.mm.ui.snackbar.a.a(this.context, this.yAB.getView().findViewById(R.h.cwr), this.context.getString(R.l.eip));
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, List<au> list, boolean z, s sVar, x xVar) {
        if (aVar == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
        } else if (list == null || list.isEmpty()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        } else {
            a aVar2 = new a();
            yAs = aVar2;
            aVar2.yAp = new LinkedList(list);
            yAs.yxU = z;
            yAs.fFG = xVar.field_username;
            yAs.yAA = true;
            final Context context = aVar.getContext();
            if (context != null) {
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
                lVar.zux = new com.tencent.mm.ui.base.p.a() {
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, menuItem.getTitle(), false);
                    }
                };
                lVar.zuy = new com.tencent.mm.ui.base.p.b() {
                    public final void a(TextView textView, MenuItem menuItem) {
                        if (textView != null) {
                            as.Hm();
                            com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(menuItem.getTitle());
                            if (Xv == null || ((int) Xv.gKO) <= 0) {
                                textView.setText(menuItem.getTitle());
                            } else {
                                textView.setText(i.a(context, Xv.AW()));
                            }
                        }
                    }
                };
                final List cse = p.m(context, "com.tencent.wework") ? i.cse() : i.csd();
                lVar.rQF = new com.tencent.mm.ui.base.p.c() {
                    public final void a(n nVar) {
                        nVar.aj(1193046, R.l.evg, R.g.bAL);
                        for (CharSequence add : cse) {
                            nVar.add(add);
                        }
                    }
                };
                final List<au> list2 = list;
                final com.tencent.mm.ui.chatting.ChattingUI.a aVar3 = aVar;
                final x xVar2 = xVar;
                final s sVar2 = sVar;
                lVar.rQG = new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(final MenuItem menuItem, int i) {
                        if (menuItem.getItemId() == 1193046) {
                            if (i.di(list2)) {
                                h.a(context, context.getString(R.l.dXL), "", context.getString(R.l.dCa), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (i.dj(list2)) {
                                h.a(context, context.getString(R.l.dXM), "", context.getString(R.l.dCa), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (i.dh(list2)) {
                                h.a(context, context.getString(R.l.dXN), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                            } else if (m.a(aVar3, list2, xVar2) && sVar2 != null) {
                                sVar2.csF();
                            }
                        } else if (i.di(list2)) {
                            h.a(context, context.getString(R.l.dXL), "", context.getString(R.l.dCa), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else if (i.dj(list2)) {
                            h.a(context, context.getString(R.l.dXM), "", context.getString(R.l.dCa), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            boolean z;
                            List<au> list = list2;
                            if (list != null) {
                                for (au auVar : list) {
                                    com.tencent.mm.modelvideo.r nv;
                                    if (auVar.field_isSend == 1) {
                                        break;
                                    } else if (auVar.cjT()) {
                                        com.tencent.mm.ap.e bj;
                                        com.tencent.mm.ap.e bi;
                                        if (auVar.field_msgId > 0) {
                                            bj = o.PC().bj(auVar.field_msgId);
                                        } else {
                                            bj = null;
                                        }
                                        if ((bj == null || bj.hBA <= 0) && auVar.field_msgSvrId > 0) {
                                            bi = o.PC().bi(auVar.field_msgSvrId);
                                        } else {
                                            bi = bj;
                                        }
                                        if (bi != null && (bi.offset < bi.hmZ || bi.hmZ == 0)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.cjW()) {
                                        nv = com.tencent.mm.modelvideo.o.Ub().nv(auVar.field_imgPath);
                                        if (!(nv == null || nv.status == 199 || nv.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.cjX()) {
                                        nv = t.nJ(auVar.field_imgPath);
                                        if (!(nv == null || nv.status == 199 || nv.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (auVar.cjZ()) {
                                        z = !i.aj(auVar);
                                    }
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                            }
                            z = false;
                            if (z || i.dh(list2)) {
                                h.a(context, context.getString(R.l.dXN), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                                return;
                            }
                            final String str = (String) menuItem.getTitle();
                            if (f.jY(str)) {
                                if (list2.size() <= 1) {
                                    l.yAs.yAA = true;
                                    l.a(str, aVar3, list2);
                                    return;
                                }
                                new com.tencent.mm.ui.tools.l(context).b(menuItem.getActionView(), new OnCreateContextMenuListener() {
                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        contextMenu.add(0, 0, 0, R.l.ewd);
                                        contextMenu.add(0, 1, 1, R.l.ewe);
                                    }
                                }, new com.tencent.mm.ui.base.p.d() {
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                        if (menuItem.getItemId() == 0) {
                                            l.yAs.yAA = true;
                                        } else {
                                            l.yAs.yAA = false;
                                        }
                                        l.a(str, aVar3, list2);
                                    }
                                });
                            } else if (i.df(list2)) {
                                h.a(context, context.getString(R.l.epP), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        boolean z;
                                        List<au> list = list2;
                                        if (list != null && !list.isEmpty()) {
                                            for (au auVar : list) {
                                                if (!i.an(auVar)) {
                                                    if (!auVar.cjL() && !i.ai(auVar) && !auVar.cjU() && !i.ak(auVar) && !i.al(auVar) && auVar.getType() != -1879048186 && !i.as(auVar) && !i.am(auVar) && !i.ar(auVar) && !i.av(auVar)) {
                                                        z = false;
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                        z = true;
                                        if (z) {
                                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                            if (sVar2 != null) {
                                                sVar2.csF();
                                                return;
                                            }
                                            return;
                                        }
                                        Context context = context;
                                        context.getString(R.l.dGZ);
                                        l.yAh = h.a(context, context.getString(R.l.eKo), false, null);
                                        s.yCw.c(new b(aVar3, context, menuItem.getTitle(), -1, l.yAs));
                                        if (sVar2 != null) {
                                            sVar2.csF();
                                        }
                                    }
                                }, null);
                            } else {
                                Context context = context;
                                context.getString(R.l.dGZ);
                                l.yAh = h.a(context, context.getString(R.l.eKo), false, null);
                                s.yCw.c(new b(aVar3, context, menuItem.getTitle(), -1, l.yAs));
                                if (sVar2 != null) {
                                    sVar2.csF();
                                }
                            }
                        }
                    }
                };
                lVar.bCH();
            }
        }
    }

    public static void a(final String str, final u uVar, List<au> list) {
        Context context = uVar.getContext();
        if (context != null) {
            com.tencent.mm.af.d jV = f.jV(str);
            if (jV != null) {
                String string;
                boolean Lm = jV.Lm();
                if (yAs.yAA) {
                    boolean df = i.df(list);
                    if (Lm) {
                        Object obj;
                        if (list == null || list.isEmpty()) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                            obj = 1;
                        } else {
                            for (au auVar : list) {
                                if (!auVar.cjV() && !auVar.cjL() && !auVar.cjT() && !auVar.aNL() && !i.aq(auVar)) {
                                    int obj2 = 1;
                                    break;
                                }
                            }
                            obj2 = null;
                        }
                        yAs.yAp = new LinkedList(list);
                        if (df || obj2 != null) {
                            string = context.getString(R.l.ecf);
                            if (string != null) {
                                h.a(context, string, "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        l.a(str, uVar);
                                    }
                                }, null);
                            } else {
                                a(str, uVar);
                            }
                        }
                    } else if (df) {
                        string = context.getString(R.l.ecg);
                        if (string != null) {
                            a(str, uVar);
                        } else {
                            h.a(context, string, "", /* anonymous class already generated */, null);
                        }
                    }
                }
                string = null;
                if (string != null) {
                    h.a(context, string, "", /* anonymous class already generated */, null);
                } else {
                    a(str, uVar);
                }
            }
        }
    }

    public static void a(String str, u uVar) {
        com.tencent.mm.af.d jV = f.jV(str);
        if (jV != null) {
            Intent intent;
            if (jV.Lm()) {
                intent = new Intent(uVar.getContext(), BizChatSelectConversationUI.class);
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("biz_chat_scene", 2);
                intent.putExtra("enterprise_extra_params", yAs.yAA);
                uVar.startActivityForResult(intent, 225);
            } else if (jV.Lk()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.bl.d.a((Fragment) uVar, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
        }
    }

    public static mv bv(Context context, String str) {
        com.tencent.mm.sdk.b.b mvVar = new mv();
        mvVar.fFz.type = 6;
        mvVar.fFz.fFF = yAs.yAp;
        mvVar.fFz.toUser = str;
        mvVar.fFz.fFG = yAs.fFG;
        mvVar.fFz.context = context;
        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
        yAs.fFb = mvVar.fFA.fFb;
        yAs.yAq = mvVar.fFA.fFI;
        return mvVar;
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, s sVar, String str, long j) {
        Context context = aVar.getContext();
        if (!com.tencent.mm.platformtools.t.oN(str) && str.length() > 0) {
            context.getString(R.l.dGZ);
            yAh = h.a(context, context.getString(R.l.eKo), false, null);
            s.yCw.c(new b(aVar, context, str, j, yAs));
        }
        if (sVar != null) {
            sVar.csF();
        }
    }
}
