package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.a;
import com.tencent.mm.y.c;
import com.tencent.mm.y.l;
import com.tencent.mm.y.s;

public final class b {

    /* renamed from: com.tencent.mm.ui.conversation.b$5 */
    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ PBool zfq;

        AnonymousClass5(PBool pBool) {
            this.zfq = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.zfq.value = true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.b$6 */
    static class AnonymousClass6 implements a {
        final /* synthetic */ ProgressDialog lga;
        final /* synthetic */ PBool zfq;

        AnonymousClass6(PBool pBool, ProgressDialog progressDialog) {
            this.zfq = pBool;
            this.lga = progressDialog;
        }

        public final boolean HH() {
            return this.zfq.value;
        }

        public final void HG() {
            if (this.lga != null) {
                this.lga.dismiss();
            }
        }
    }

    static /* synthetic */ void a(Context context, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("chat_from_scene", 4);
            d.a(context, ".ui.chatting.ChattingUI", intent);
            return;
        }
        LauncherUI cnu = LauncherUI.cnu();
        if (cnu != null) {
            cnu.startChatting(str, null, true);
        }
    }

    static /* synthetic */ void a(final String str, final PBool pBool, final ProgressDialog progressDialog) {
        if (l.gc(str)) {
            q.Qk().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
        }
        bb.a(str, new a() {
            public final boolean HH() {
                return pBool.value || progressDialog == null || !progressDialog.isShowing();
            }

            public final void HG() {
                as.Hm();
                ag Xv = c.Ff().Xv(str);
                Xv.Au();
                if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                    s.s(Xv.field_username, false);
                } else {
                    as.Hm();
                    c.Ff().a(str, Xv);
                }
                as.Hm();
                c.Fk().XE(str);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void a(String str, ae aeVar, final PBool pBool, final ProgressDialog progressDialog) {
        bb.a(str, new a() {
            public final boolean HH() {
                return pBool.value || progressDialog == null || !progressDialog.isShowing();
            }

            public final void HG() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        Xv.Au();
        Xv.Av();
        if (Xv.ciN() && f.jW(str)) {
            g.pWK.h(13773, Integer.valueOf(0), Integer.valueOf(aeVar.field_unReadCount), Integer.valueOf(1), aeVar.field_username);
        }
        com.tencent.mm.bp.a asc = new asc();
        x.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", Xv.field_username, Xv.field_conRemark, Integer.valueOf(Xv.field_type));
        asc.wfM = new bet().Vf(t.oM(Xv.field_username));
        asc.wzM = new bet().Vf(t.oM(Xv.field_nickname));
        asc.wfA = new bet().Vf(t.oM(Xv.vX()));
        asc.wfB = new bet().Vf(t.oM(Xv.vY()));
        asc.hxe = Xv.fXa;
        asc.weQ = 561023;
        asc.weR = Xv.field_type;
        asc.wFS = new bet().Vf(t.oM(Xv.field_conRemark));
        asc.wFT = new bet().Vf(t.oM(Xv.field_conRemarkPYShort));
        asc.wFU = new bet().Vf(t.oM(Xv.field_conRemarkPYFull));
        asc.weW = Xv.fXf;
        asc.wGn = new bet().Vf(t.oM(Xv.field_domainList));
        asc.wfa = Xv.fXi;
        asc.hxi = Xv.fXj;
        asc.hxh = t.oM(Xv.signature);
        asc.hxg = t.oM(Xv.getCityCode());
        asc.hxf = t.oM(Xv.ciR());
        asc.wCs = t.oM(Xv.fXo);
        asc.wCu = Xv.field_weiboFlag;
        asc.wGj = 0;
        asc.vNQ = new bes();
        asc.hxn = t.oM(Xv.getCountryCode());
        as.Hm();
        c.Fe().b(new e.a(2, asc));
        as.Hm();
        c.Ff().a(str, Xv);
        as.Hm();
        ak XF = c.Fk().XF(str);
        as.Hm();
        c.Fk().XE(str);
        if (XF == null) {
            return;
        }
        if (XF.gd(4194304) || (Xv.ciN() && !com.tencent.mm.k.a.ga(Xv.field_type) && XF.field_conversationTime < y.Mx())) {
            as.CN().a(new i(str), 0);
        }
    }

    public static void a(String str, Context context, ae aeVar, Runnable runnable, boolean z, boolean z2) {
        final PBool pBool = new PBool();
        String str2;
        final String str3;
        final Context context2;
        final boolean z3;
        final String str4;
        final boolean z4;
        final ProgressDialog progressDialog;
        final PBool pBool2;
        if (s.eX(str)) {
            str2 = null;
            as.Hm();
            cg Fc = c.Fh().Fc(str);
            as.Hm();
            c.Fe().b(new com.tencent.mm.ax.d(str, Fc.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.dGZ);
            final ProgressDialog a = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.TE(str);
            }
            if (t.oN(str2)) {
                a.dismiss();
                str3 = str;
                final Runnable runnable2 = runnable;
                h.a(context, context.getString(R.l.eiP), "", context.getString(R.l.dEH), context.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.a(str3, pBool, a);
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                }, null, R.e.brm);
            } else {
                a.dismiss();
                String string = context.getString(R.l.eWu, new Object[]{str2});
                String string2 = context.getString(R.l.enQ);
                String string3 = context.getString(R.l.dYx);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                AnonymousClass7 anonymousClass7 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        pBool.value = true;
                        b.a(context2, z3, str4);
                        if (z4) {
                            g.pWK.h(14553, Integer.valueOf(1), Integer.valueOf(4), str4);
                        }
                    }
                };
                progressDialog = a;
                pBool2 = pBool;
                final String str5 = str;
                final boolean z5 = z;
                final Runnable runnable3 = runnable;
                h.a(context, false, string, null, string2, string3, anonymousClass7, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        progressDialog.show();
                        pBool2.value = false;
                        b.a(str5, pBool2, progressDialog);
                        if (z5) {
                            g.pWK.h(14553, Integer.valueOf(1), Integer.valueOf(3), str5);
                        }
                        if (runnable3 != null) {
                            runnable3.run();
                        }
                    }
                }, -1, R.e.brm);
            }
        } else if (s.gY(str)) {
            as.Hm();
            c.Fk().Fk(str);
            com.tencent.mm.sdk.b.b mjVar = new mj();
            mjVar.fEZ.opType = 4;
            mjVar.fEZ.fFe = 20;
            com.tencent.mm.sdk.b.a.xmy.m(mjVar);
        } else if (s.gO(str)) {
            as.Hm();
            c.Fk().Fk(str);
        } else if (s.gR(str)) {
            as.Hm();
            c.Fk().XE(str);
        } else if (f.eG(str)) {
            pBool.value = false;
            context.getString(R.l.dGZ);
            final ProgressDialog a2 = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            a2.dismiss();
            str3 = str;
            final String str6 = str;
            h.a(context, context.getString(R.l.eiN), "", context.getString(R.l.dEH), context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    bb.a(str3, new a() {
                        public final boolean HH() {
                            return pBool.value || a2 == null || !a2.isShowing();
                        }

                        public final void HG() {
                            com.tencent.mm.af.a.e.A(str6, false);
                            if (a2 != null) {
                                a2.dismiss();
                            }
                        }
                    });
                }
            }, null, R.e.brm);
        } else {
            as.Hm();
            cg Fc2 = c.Fh().Fc(str);
            as.Hm();
            c.Fe().b(new com.tencent.mm.ax.d(str, Fc2.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.dGZ);
            final ProgressDialog a3 = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            str2 = null;
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.TE(str);
            }
            final Runnable runnable4;
            if (t.oN(str2)) {
                a3.dismiss();
                final Context context3 = context;
                str4 = str;
                final ae aeVar2 = aeVar;
                final PBool pBool3 = pBool;
                runnable4 = runnable;
                h.a(context, context.getString(s.hg(str) ? R.l.eiO : R.l.eiN), "", context.getString(R.l.dEH), context.getString(R.l.dEy), (OnClickListener) new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.a(str4, aeVar2, pBool3, a3);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                    }
                }, null, R.e.brm);
            } else {
                a3.dismiss();
                String string4 = context.getString(R.l.eWu, new Object[]{str2});
                String string5 = context.getString(R.l.enQ);
                String string6 = context.getString(R.l.dYx);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                AnonymousClass13 anonymousClass13 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        pBool.value = true;
                        b.a(context2, z3, str4);
                        if (z4) {
                            g.pWK.h(14553, Integer.valueOf(0), Integer.valueOf(4), str4);
                        }
                    }
                };
                progressDialog = a3;
                pBool2 = pBool;
                final Context context4 = context;
                final String str7 = str;
                final ae aeVar3 = aeVar;
                runnable4 = runnable;
                final boolean z6 = z;
                h.a(context, false, string4, null, string5, string6, anonymousClass13, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        progressDialog.show();
                        pBool2.value = false;
                        b.a(str7, aeVar3, pBool2, progressDialog);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                        if (z6) {
                            g.pWK.h(14553, Integer.valueOf(0), Integer.valueOf(3), str7);
                        }
                    }
                }, -1, R.e.brm);
            }
        }
        if (s.gP(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all qmessage");
            bb.HE();
            as.Hm();
            c.Fk().Fk("@qqim");
        } else if (s.gN(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all tmessage");
            bb.HF();
            as.Hm();
            c.Fk().Fk("@t.qq.com");
        }
    }
}
