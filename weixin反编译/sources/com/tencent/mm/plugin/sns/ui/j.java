package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.StrictMode;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.bq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.f.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.av.AnonymousClass7;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import java.util.List;

public final class j {
    public static List<l> rxF = new LinkedList();
    private Context context;
    String gAM;
    ClipboardManager mCW;
    protected ListView nQn;
    public av rfY;
    FrameLayout rft;
    bi rxA;
    ao rxB;
    private boolean rxC = false;
    private String rxD = "";
    private boolean rxE = false;
    bh rxG;
    c rxH;
    b rxI;
    public com.tencent.mm.plugin.sns.ui.b.b rxJ;
    r rxK = null;
    c rxL = new c<bq>() {
        {
            this.xmG = bq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (j.this.rxG != null) {
                j.this.rxG.bAb();
            }
            return false;
        }
    };
    OnLongClickListener rxM = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            g.Dr();
            if (((Boolean) g.Dq().Db().get(7490, Boolean.valueOf(true))).booleanValue()) {
                j.this.context.startActivity(new Intent().setClass(j.this.context, SnsLongMsgUI.class));
                g.Dr();
                g.Dq().Db().set(7490, Boolean.valueOf(false));
            } else {
                Intent intent = new Intent();
                intent.setClass(j.this.context, SnsCommentUI.class);
                intent.putExtra("sns_comment_type", 1);
                ((MMActivity) j.this.context).startActivityForResult(intent, 9);
            }
            return true;
        }
    };
    public com.tencent.mm.plugin.sns.a.b.g rxv;
    public at rxw;
    boolean rxx;
    boolean rxy = false;
    SnsCommentFooter rxz;

    public class a implements OnClickListener {
        private String gDt;
        private bku raa;
        private CharSequence rxU = "";
        private com.tencent.mm.plugin.sns.ui.a.a.c rxe;

        public a(bku bku, String str, CharSequence charSequence, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
            this.gDt = str;
            this.raa = bku;
            this.rxe = cVar;
            this.rxU = charSequence;
        }

        public final void onClick(View view) {
            int i = 0;
            if (u.Mm(this.rxe.fAR)) {
                this.rxe.rUd = view;
                if (this.raa == null || this.raa.vPp == null || !this.raa.vPp.equals(j.this.gAM)) {
                    m mVar = new m();
                    m xL = j.this.rfY.xL(this.rxe.position);
                    if (!xL.bvO()) {
                        if (com.tencent.mm.plugin.sns.lucky.a.m.h(xL)) {
                            com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(742);
                            blf n = ai.n(xL);
                            com.tencent.mm.modelsns.b iA = ix.mF(i.g(xL)).iA(xL.field_type).bW(xL.xD(32)).mF(xL.bzk()).mF(this.raa.wUn == 0 ? this.raa.wUq : this.raa.wUn).mF(this.raa.vPp).iA(n == null ? 0 : n.wUP);
                            if (n != null) {
                                i = n.wUS;
                            }
                            iA.iA(i);
                            ix.SE();
                            j.this.a(this.rxe, xL, j.this.context.getString(com.tencent.mm.plugin.sns.i.j.qSc) + this.gDt, this.raa);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.e(this.rxe.rUj.getContext(), this.rxe.rUj.xQ(0));
                        return;
                    }
                    return;
                }
                if (j.this.rxA.rST) {
                    j.this.bzO();
                    j.this.rxA.rST = false;
                }
                com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(j.this.context);
                OnCreateContextMenuListener anonymousClass1 = new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, j.this.context.getString(com.tencent.mm.plugin.sns.i.j.dED));
                        contextMenu.add(1, 1, 0, j.this.context.getString(com.tencent.mm.plugin.sns.i.j.dEH));
                    }
                };
                d anonymousClass2 = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        int i2 = 4;
                        switch (menuItem.getItemId()) {
                            case 0:
                                j.this.mCW.setText(a.this.rxU);
                                h.bu(j.this.context, j.this.context.getString(com.tencent.mm.plugin.sns.i.j.dEE));
                                if (a.this.raa != null) {
                                    String fM = bi.fM(u.Mk(a.this.rxe.fAR));
                                    int i3 = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                                    com.tencent.mm.plugin.secinforeport.a.a.d(4, fM + ":" + a.this.raa.wUn, bi.We(a.this.rxU.toString()));
                                    return;
                                }
                                return;
                            case 1:
                                x.e("MicroMsg.BaseTimeLine", "del snsId:" + a.this.rxe.fAR + " commentId:" + a.this.raa);
                                long Mk = u.Mk(a.this.rxe.fAR);
                                if (u.Mj(a.this.rxe.fAR)) {
                                    i2 = 6;
                                }
                                final k qVar = new q(Mk, i2, a.this.raa);
                                g.Dr();
                                g.Dp().gRu.a(qVar, 0);
                                j jVar = j.this;
                                Context c = j.this.context;
                                j.this.context.getString(com.tencent.mm.plugin.sns.i.j.dGZ);
                                jVar.rxK = h.a(c, j.this.context.getString(com.tencent.mm.plugin.sns.i.j.qQw), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        g.Dr();
                                        g.Dp().gRu.c(qVar);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(f.cSM) instanceof int[]) {
                    iArr = (int[]) view.getTag(f.cSM);
                }
                iVar.a(view, anonymousClass1, anonymousClass2, iArr[0], iArr[1]);
            }
        }
    }

    public j(Context context, int i, String str, int i2) {
        this.context = context;
        this.gAM = com.tencent.mm.y.q.FY();
        this.rxw = new at();
        this.rxw.rcW = new com.tencent.mm.plugin.sns.h.b(i, str, i2);
        this.rxJ = new com.tencent.mm.plugin.sns.ui.b.b((Activity) context, this.rxw) {
            public final void b(View view, int i, int i2, int i3) {
                if (i2 < 0) {
                    final int i4 = i;
                    final int i5 = i2;
                    final int i6 = i3;
                    final View view2 = view;
                    new Runnable() {
                        int count = 20;

                        public final void run() {
                            j.this.nQn.setSelectionFromTop(i4 + j.this.nQn.getHeaderViewsCount(), i5 + i6);
                            this.count--;
                            x.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", Integer.valueOf(this.count), Integer.valueOf(Math.abs(view2.getTop() - (i5 + i6))));
                            if (this.count <= 0 || Math.abs(view2.getTop() - (i5 + i6)) < 5) {
                                x.d("MicroMsg.TimelineClickListener", "count: %s", Integer.valueOf(this.count));
                                j.this.rfY.notifyDataSetChanged();
                                return;
                            }
                            new ag().postDelayed(this, 5);
                        }
                    }.run();
                }
            }

            public final void bM(Object obj) {
                j.this.rxB.a((View) obj, 1, j.this.rxw);
            }

            public final void bzQ() {
                if (j.this.rfY != null) {
                    j.this.rfY.bCl();
                }
            }

            public final void cB(View view) {
                int i = 0;
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                if (j.this.rfY.bCi() != null) {
                    j.this.rfY.bCi().bAb();
                    m mVar = new m();
                    m xL = j.this.rfY.xL(cVar.position);
                    if (xL.isValid()) {
                        com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(741);
                        blf n = ai.n(xL);
                        com.tencent.mm.modelsns.b iA = ix.mF(i.g(xL)).iA(xL.field_type).bW(xL.xD(32)).mF(xL.bzk()).mF(xL.field_userName).iA(n == null ? 0 : n.wUP);
                        if (n != null) {
                            i = n.wUS;
                        }
                        iA.iA(i);
                        ix.SE();
                        j.this.a(cVar, xL, "", new bku());
                        bku bku = new bku();
                    }
                }
            }

            public final void cC(View view) {
                int i = 0;
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                    if (j.this.rfY.bCi() != null) {
                        j.this.rfY.bCi().bAb();
                        m mVar = new m();
                        m xL = j.this.rfY.xL(cVar.position);
                        if (xL.isValid()) {
                            com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(741);
                            blf n = ai.n(xL);
                            com.tencent.mm.modelsns.b iA = ix.mF(i.g(xL)).iA(xL.field_type).bW(xL.xD(32)).mF(xL.bzk()).mF(xL.field_userName).iA(n == null ? 0 : n.wUP);
                            if (n != null) {
                                i = n.wUS;
                            }
                            iA.iA(i);
                            ix.SE();
                            j.this.a(cVar, xL, new bku());
                        }
                    }
                }
            }

            public final void cD(View view) {
                if (j.this.rfY != null) {
                    j.this.rfY.cI(view);
                }
            }

            public final void cE(View view) {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                m LR = ae.bwf().LR(cVar.fsC);
                if (LR != null && !LR.bvO() && !j.this.rxy) {
                    int i = 0;
                    if (LR.xD(32) && LR.byF().wYj.wfg == 27 && (cVar.rUQ instanceof com.tencent.mm.plugin.sns.ui.a.g)) {
                        com.tencent.mm.plugin.sns.ui.a.g gVar = (com.tencent.mm.plugin.sns.ui.a.g) cVar.rUQ;
                        com.tencent.mm.plugin.sns.ui.a.g.a aVar = cVar.rUL;
                        if (aVar.rVl != null) {
                            com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = aVar.rVk;
                            m mVar = aVar.rEl;
                            bpb bpb = cVar2.rUN;
                            com.tencent.mm.plugin.sns.ui.a.g.a aVar2 = cVar2.rUL;
                            if (bpb.wYj.wfg == 27 && bpb.wYj.wfh.size() >= 2) {
                                int i2;
                                int i3;
                                int i4;
                                if (mVar.field_likeFlag == 1) {
                                    i2 = 1;
                                    i = 0;
                                } else {
                                    i2 = 0;
                                    i = 1;
                                }
                                are are = (are) bpb.wYj.wfh.get(i2);
                                bpb.wYj.wfh.get(i);
                                View view2 = cVar2.rUJ;
                                View i5 = com.tencent.mm.plugin.sns.ui.a.g.i(cVar2.rUJ, i2, are.kzz);
                                View i6 = com.tencent.mm.plugin.sns.ui.a.g.i(cVar2.rUJ, i, 2);
                                int[] iArr = new int[2];
                                view2.getLocationOnScreen(iArr);
                                view2.setPivotY((float) ((gVar.mScreenHeight / 2) - iArr[1]));
                                view2.setCameraDistance(8000.0f);
                                float width = ((float) view2.getWidth()) / 2.0f;
                                float height = ((float) view2.getHeight()) / 2.0f;
                                if (mVar.field_likeFlag == 1) {
                                    i3 = -90;
                                    i4 = 90;
                                } else {
                                    i3 = 90;
                                    i4 = -90;
                                }
                                Animation aVar3 = new com.tencent.mm.plugin.sns.ui.widget.a(view2.getContext(), 0.0f, (float) i4, width, height, true);
                                aVar3.setDuration(187);
                                aVar3.setInterpolator(new AccelerateInterpolator());
                                aVar3.setFillAfter(true);
                                aVar3.setAnimationListener(new com.tencent.mm.plugin.sns.ui.a.g.AnonymousClass5(i6, i5, aVar2, view2, i3, width, height));
                                view2.startAnimation(aVar3);
                                i = 374;
                                if (LR.field_likeFlag == 0) {
                                    j.this.rxv.el(cVar.rTG);
                                }
                                if (LR.byF().wYj.wfh.size() > cVar.rUL.index && ((are) LR.byF().wYj.wfh.get(cVar.rUL.index)).kzz == 6) {
                                    j.this.rxv.p(cVar.rTG, cVar.rUL.index <= 0);
                                }
                                j.this.rxy = true;
                            }
                        }
                        i = 0;
                        if (LR.field_likeFlag == 0) {
                            j.this.rxv.el(cVar.rTG);
                        }
                        if (cVar.rUL.index <= 0) {
                        }
                        j.this.rxv.p(cVar.rTG, cVar.rUL.index <= 0);
                        j.this.rxy = true;
                    }
                    final m mVar2 = LR;
                    final com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = cVar;
                    final View view3 = view;
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            if (j.this.rxw != null) {
                                j.this.rxw.rcW.u(mVar2);
                            }
                            if (cVar3.rTH == 0) {
                                blf n = ai.n(mVar2);
                                com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(707);
                                ix.mF(i.g(mVar2)).iA(mVar2.field_type).bW(mVar2.xD(32)).mF(mVar2.bzk()).mF(mVar2.field_userName).iA(n.wUP).iA(n.wUS);
                                ix.SE();
                                StrictMode.allowThreadDiskReads();
                                cVar3.rTH = 1;
                                mVar2.field_likeFlag = cVar3.rTH;
                                com.tencent.mm.plugin.sns.storage.h.a(mVar2.byG(), mVar2);
                                ((TextView) view3.findViewById(f.qHh)).setText(com.tencent.mm.plugin.sns.i.j.qRa);
                                com.tencent.mm.plugin.sns.model.al.a.a(mVar2, mVar2.xD(32) ? 7 : 1, "");
                            } else {
                                cVar3.rTH = 0;
                                mVar2.field_likeFlag = cVar3.rTH;
                                com.tencent.mm.plugin.sns.storage.h.a(mVar2.byG(), mVar2);
                                ((TextView) view3.findViewById(f.qHh)).setText(com.tencent.mm.plugin.sns.i.j.qRA);
                                com.tencent.mm.plugin.sns.model.al.a.KV(mVar2.byG());
                            }
                            av avVar = j.this.rfY;
                            LinearLayout linearLayout = (LinearLayout) view3;
                            Runnable anonymousClass1 = new Runnable() {
                                public final void run() {
                                    j.this.rxy = false;
                                }
                            };
                            ImageView imageView = (ImageView) linearLayout.findViewById(f.qHf);
                            Animation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(400);
                            scaleAnimation.setStartOffset(100);
                            scaleAnimation.setRepeatCount(0);
                            imageView.clearAnimation();
                            imageView.startAnimation(scaleAnimation);
                            scaleAnimation.setAnimationListener(new AnonymousClass7(linearLayout, anonymousClass1));
                        }
                    }, (long) i);
                }
            }

            public final void cF(View view) {
                j.this.rxG.bAb();
                j.this.rxH.cA(view);
            }

            public final void bzR() {
                j.this.rxH.bzC();
            }

            public final void cG(View view) {
                j.this.rxH.bwW();
                if (view.getTag() != null) {
                    com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
                    j.this.rxv.t(bVar.position, bVar.fsC, bVar.iWv);
                }
            }
        };
        this.rxJ.aVm();
        com.tencent.mm.sdk.b.a.xmy.b(this.rxL);
    }

    private void bzN() {
        if (!this.rxC) {
            this.rxC = true;
            this.rxz.bBu();
            this.rxz.a(new c() {
                public final void Mp(String str) {
                    m mVar = (m) j.this.rxz.getTag();
                    x.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                    if (str == null || str.trim().equals("")) {
                        x.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                        return;
                    }
                    bku bBA = j.this.rxz.bBA();
                    blf n = ai.n(mVar);
                    int i = (bBA.wUn == 0 && bBA.wUq == 0) ? 708 : 709;
                    com.tencent.mm.modelsns.b ix = com.tencent.mm.modelsns.b.ix(i);
                    if (ix.opType == 708) {
                        ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32)).mF(mVar.bzk()).mF(mVar.field_userName).iA(n.wUP).iA(n.wUS);
                    } else {
                        String str2;
                        com.tencent.mm.modelsns.b mF = ix.mF(i.g(mVar)).iA(mVar.field_type).bW(mVar.xD(32)).mF(mVar.bzk()).mF(bBA.vPp);
                        if (bBA.wUn == 0) {
                            str2 = bBA.wUq;
                        } else {
                            str2 = bBA.wUn;
                        }
                        mF.mF(str2).iA(n.wUP).iA(n.wUS);
                    }
                    ix.SE();
                    if (j.this.rxw != null) {
                        j.this.rxw.rcW.u(mVar);
                    }
                    if (mVar.xD(32) && j.this.rxz.rHh == 1) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    com.tencent.mm.plugin.sns.model.al.a.a(mVar, mVar.xD(32) ? 8 : 2, str, j.this.rxz.bBA(), i);
                    j.this.rfY.E(j.this.rxA.rSW);
                    j.this.bzO();
                    if (bi.oN(j.this.rxD)) {
                        for (l lVar : j.rxF) {
                            if (j.this.rxD.equals(lVar.aAM)) {
                                x.d("MicroMsg.BaseTimeLine", "remove ct");
                                j.rxF.remove(lVar);
                                return;
                            }
                        }
                    }
                }
            });
            SnsCommentFooter snsCommentFooter = this.rxz;
            com.tencent.mm.ui.widget.MMEditText.a anonymousClass4 = new com.tencent.mm.ui.widget.MMEditText.a() {
                public final void aYi() {
                    if (j.this.rxz.getVisibility() == 0) {
                        j.this.rxz.setVisibility(8);
                    } else {
                        ((Activity) j.this.context).finish();
                    }
                }
            };
            if (snsCommentFooter.oqa != null) {
                snsCommentFooter.oqa.zCT = anonymousClass4;
            }
        }
    }

    final void bzO() {
        if (this.rxC) {
            if (this.rxz.getVisibility() != 8) {
                this.rxz.setVisibility(8);
            }
            av avVar = this.rfY;
            if (avVar.rNv != null) {
                avVar.rNv.setVisibility(8);
            }
            avVar.rNv = null;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, bku bku) {
        String str = cVar.fAR + "@";
        this.rxD = str;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.rxD + " " + cVar.fAR + " position:" + cVar.position);
        bzN();
        g.Dr();
        String AX = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(mVar.field_userName).AX();
        this.rxz.setTag(mVar);
        this.rxz.setVisibility(0);
        this.rxz.b(AX, bku);
        this.rxz.i(rxF, str);
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.context, 8);
        if (cVar.rUd != null) {
            fromDPToPix += cVar.rUf.getHeight() - cVar.rUd.getBottom();
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.rUd.getBottom());
        } else {
            fromDPToPix = 0;
        }
        this.rxA.position = cVar.position;
        this.rxA.rSQ = cVar.nav.getHeight() - fromDPToPix;
        cVar.rUd = null;
        this.rxA.rSR = cVar.nav.getTop();
        this.rxA.rFH = this.nQn.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rxA.rSR);
        bzP();
    }

    private void bzP() {
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).mController.xRL == 1) {
            this.rxA.bCV();
        } else {
            this.rxx = true;
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, m mVar, String str, bku bku) {
        int i = 0;
        String str2 = cVar.fAR + str;
        this.rxD = str2;
        x.d("MicroMsg.BaseTimeLine", "onCommentClick:  commentkey " + this.rxD + " " + cVar.fAR + " position:" + cVar.position);
        bzN();
        this.rxz.setTag(mVar);
        this.rxz.setVisibility(0);
        this.rxz.a(str, bku);
        this.rxz.i(rxF, str2);
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.context, 8);
        if (cVar.rUd != null) {
            i = (cVar.rUf.getHeight() - cVar.rUd.getBottom()) + fromDPToPix;
            x.i("MicroMsg.BaseTimeLine", "comment item bottom = " + cVar.rUd.getBottom());
        }
        this.rxA.position = cVar.position;
        this.rxA.rSQ = cVar.nav.getHeight() - i;
        cVar.rUd = null;
        this.rxA.rSR = cVar.nav.getTop();
        this.rxA.rFH = this.nQn.getBottom();
        x.e("MicroMsg.BaseTimeLine", "originalTop:" + this.rxA.rSR);
        bzP();
    }
}
