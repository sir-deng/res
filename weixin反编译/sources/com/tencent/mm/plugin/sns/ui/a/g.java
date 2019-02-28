package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class g extends a {
    private static int[] rVd = new int[]{f.qLT, f.qLU};
    private static int[] rVe = new int[]{f.qLV};
    private static int[][] rVf;
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int rVc = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.a.g$5 */
    class AnonymousClass5 implements AnimationListener {
        final /* synthetic */ float fjn;
        final /* synthetic */ float fjo;
        final /* synthetic */ View rGP;
        final /* synthetic */ View rGQ;
        final /* synthetic */ int rGS;
        final /* synthetic */ a rVi;
        final /* synthetic */ View ro;

        public AnonymousClass5(View view, View view2, a aVar, View view3, int i, float f, float f2) {
            this.rGP = view;
            this.rGQ = view2;
            this.rVi = aVar;
            this.ro = view3;
            this.rGS = i;
            this.fjn = f;
            this.fjo = f2;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            this.rGP.setVisibility(0);
            this.rGQ.setVisibility(8);
            g.a(this.rVi.rVl);
            Animation aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.ro.getContext(), (float) this.rGS, 0.0f, this.fjn, this.fjo, false);
            aVar.setDuration(187);
            aVar.setInterpolator(new DecelerateInterpolator());
            aVar.setFillAfter(true);
            this.ro.startAnimation(aVar);
        }
    }

    public static final class a {
        public int index;
        public are qZY;
        public m rEl;
        public View rVj;
        public c rVk;
        public a rVl;
        public View view;
    }

    static {
        r0 = new int[3][];
        r0[0] = new int[]{f.qLZ, f.qLX};
        r0[1] = new int[]{f.qLY, f.qLW};
        r0[2] = new int[]{f.qLY, f.qLX};
        rVf = r0;
    }

    public final void d(c cVar) {
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.rVc = Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 82);
        }
        if (cVar.rTR == null || cVar.rUK) {
            cVar.rUJ = cVar.nav.findViewById(f.qLS);
            cVar.rUK = true;
        } else {
            cVar.rTR.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOh);
            cVar.rUJ = cVar.rTR.inflate();
            cVar.rUK = true;
        }
        LayoutParams layoutParams = cVar.rUJ.getLayoutParams();
        layoutParams.width = this.rVc;
        layoutParams.height = this.rVc;
        ak akVar = cVar.rUM;
        akVar.rDk = i(cVar.rUJ, 0, 6);
        akVar.rDj = akVar.rDk;
        akVar.qBQ = (com.tencent.mm.plugin.sight.decode.a.a) akVar.rDk.findViewById(f.image);
        akVar.rqV = (ImageView) akVar.rDk.findViewById(f.cPs);
        akVar.rDl = (MMPinProgressBtn) akVar.rDk.findViewById(f.progress);
        akVar.rDm = (TextView) akVar.rDk.findViewById(f.qId);
        akVar.rqY = (TextView) akVar.rDk.findViewById(f.qIe);
        ((SightPlayImageView) akVar.qBQ).qAM = true;
        ((SightPlayImageView) akVar.qBQ).a(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        akVar.qBQ.dx(this.rVc, this.rVc);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bpb bpb, int i2, av avVar) {
        int hashCode;
        View findViewById;
        cVar.rUJ.setTag(cVar);
        cVar.rUJ.setVisibility(0);
        cVar.rUJ.setLayerType(2, null);
        for (int findViewById2 : rVd) {
            findViewById = cVar.rUJ.findViewById(findViewById2);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById instanceof MaskImageView) {
                ((MaskImageView) findViewById).a(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
            }
        }
        for (int findViewById22 : rVe) {
            findViewById = cVar.rUJ.findViewById(findViewById22);
            if (findViewById != null) {
                findViewById.setBackground(null);
                findViewById.setVisibility(8);
                if (findViewById instanceof ViewGroup) {
                    ((ViewGroup) findViewById).setClipChildren(false);
                }
            }
        }
        cVar.rUM.qBQ.clear();
        if (!ayVar.rxi || i2 != 12) {
            return;
        }
        if (bpb.wYj == null || bpb.wYj.wfh == null || bpb.wYj.wfh.size() < 2) {
            x.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
            return;
        }
        int i3;
        if (cVar.rTH == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        a aVar = null;
        a aVar2 = null;
        int i4 = 0;
        while (i4 < Math.min(bpb.wYj.wfh.size(), 2)) {
            a aVar3;
            a aVar4;
            are are = (are) bpb.wYj.wfh.get(i4);
            View i5 = i(cVar.rUJ, i4, 2);
            if (i5 != null) {
                LayoutParams layoutParams;
                ap apVar = new ap();
                apVar.fvn = cVar.fsC;
                apVar.index = i4;
                apVar.rFe = this.rFe;
                apVar.position = i;
                i5.setTag(apVar);
                com.tencent.mm.plugin.sns.model.g bwc;
                if (are.kzz == 2) {
                    bwc = ae.bwc();
                    int hashCode2 = this.mActivity.hashCode();
                    an cjD = an.cjD();
                    cjD.time = bpb.pgR;
                    bwc.a(are, i5, -1, hashCode2, cjD, 3);
                } else {
                    bwc = ae.bwc();
                    hashCode = this.mActivity.hashCode();
                    an cjD2 = an.cjD();
                    cjD2.time = bpb.pgR;
                    bwc.a(are, i5, hashCode, cjD2);
                }
                findViewById = null;
                if (are.kzz == 6 && i3 == i4) {
                    final boolean z = i3 > 0;
                    final long j = ayVar.rPN;
                    final ak akVar = cVar.rUM;
                    m mVar = ayVar.qEj;
                    findViewById = akVar.rDj;
                    akVar.rDi = bpb;
                    final av avVar2 = avVar;
                    akVar.qBQ.a(new e() {
                        public final void d(b bVar, int i) {
                            if (i != -1 && avVar2 != null && avVar2.rNs != null && avVar2.rNs.rxv != null) {
                                avVar2.rNs.rxv.m(j, z);
                            }
                        }
                    });
                    if (!avVar.rNs.rxv.ek(((long) i4) + j)) {
                        avVar2 = avVar;
                        akVar.qBQ.a(new b.f() {
                            public final void b(b bVar, long j) {
                                if (avVar2 != null && avVar2.rNs != null && avVar2.rNs.rxv != null) {
                                    int bty = (int) bVar.bty();
                                    avVar2.rNs.rxv.b(j, bi.Wz(), z);
                                    avVar2.rNs.rxv.a(j, bty, true, z);
                                    avVar2.rNs.rxv.B(j, j + ((long) i4));
                                    akVar.qBQ.a(null);
                                }
                            }
                        });
                    } else if (!(avVar == null || avVar.rNs == null || avVar.rNs.rxv == null)) {
                        avVar.rNs.rxv.b(j, bi.Wz(), z);
                    }
                    akVar.a(bpb, i, ayVar.ryG, ayVar.rxi);
                    akVar.rqY.setVisibility(8);
                    com.tencent.mm.plugin.sns.model.g bwc2 = ae.bwc();
                    long nanoTime = System.nanoTime() - System.nanoTime();
                    x.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(are)), Long.valueOf(nanoTime));
                    if (com.tencent.mm.plugin.sns.model.g.t(are)) {
                        if (bwc2.u(are)) {
                            akVar.rqV.setVisibility(0);
                            akVar.rDl.setVisibility(8);
                            akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this.mActivity, i.dAT));
                            akVar.rqV.setContentDescription(this.mActivity.getString(j.qPM));
                        } else if (bwc2.v(are)) {
                            akVar.rqV.setVisibility(8);
                            akVar.rDl.setVisibility(8);
                        } else if (!ayVar.rxi || bwc2.b(mVar, null) > 5) {
                            bwc2.y(are);
                            akVar.rqV.setVisibility(0);
                            akVar.rDl.setVisibility(8);
                            akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this.mActivity, i.dAT));
                            akVar.rqV.setContentDescription(this.mActivity.getString(j.qPM));
                        } else {
                            akVar.rqV.setVisibility(8);
                            akVar.rDl.setVisibility(8);
                        }
                        if (akVar.qBQ.btq()) {
                            x.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + are.nMq + " " + are.nlE + " " + are.wEP + " " + i);
                            bwc2.y(are);
                            akVar.rqV.setVisibility(0);
                            akVar.rDl.setVisibility(8);
                            akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this.mActivity, i.dAT));
                            akVar.rqV.setContentDescription(this.mActivity.getString(j.qPM));
                        }
                    } else if (bwc2.w(are)) {
                        akVar.rqV.setVisibility(8);
                        akVar.rDl.setVisibility(0);
                        akVar.rDl.czF();
                    } else if (ayVar.rxi && bwc2.b(mVar, null) == 5) {
                        bwc2.A(are);
                        akVar.rqV.setVisibility(8);
                        akVar.rDl.setVisibility(0);
                        akVar.rDl.czF();
                    } else if (bwc2.x(are)) {
                        akVar.rDl.setVisibility(8);
                        akVar.rqV.setImageResource(com.tencent.mm.plugin.sns.i.e.bGg);
                        akVar.rqV.setVisibility(0);
                    } else {
                        bwc2.y(are);
                        akVar.rqV.setVisibility(0);
                        akVar.rDl.setVisibility(8);
                        akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this.mActivity, i.dAT));
                        akVar.rqV.setContentDescription(this.mActivity.getString(j.qPM));
                        if (!ayVar.rxi && bwc2.a(mVar, null) == 4) {
                            akVar.rqY.setVisibility(0);
                        } else if (ayVar.rxi && bwc2.b(mVar, null) == 4) {
                            akVar.rqY.setVisibility(0);
                        }
                    }
                    layoutParams = akVar.rDm.getLayoutParams();
                    layoutParams.width = this.rVc;
                    layoutParams.height = this.rVc;
                    akVar.rDm.setLayoutParams(layoutParams);
                    akVar.qBQ.bI(akVar);
                    com.tencent.mm.plugin.sight.decode.a.a aVar5 = akVar.qBQ;
                    int hashCode3 = this.mActivity.hashCode();
                    an cjD3 = an.cjD();
                    cjD3.time = bpb.pgR;
                    bwc2.a(mVar, are, aVar5, -1, hashCode3, i, cjD3, ayVar.rxi, true);
                    findViewById.setVisibility(0);
                    akVar.rDk.setTag(akVar);
                    if (FileOp.bO(am.r(ae.getAccSnsPath(), are.nMq) + com.tencent.mm.plugin.sns.data.i.j(are))) {
                        avVar.rNs.rxv.b(ayVar.rPN, 0, true, z);
                    } else {
                        avVar.rNs.rxv.b(ayVar.rPN, 0, false, z);
                    }
                    boolean z2 = ayVar.rxi ? ae.bwc().b(mVar, null) == 5 : ae.bwc().a(mVar, null) == 5;
                    avVar.rNs.rxv.a(ayVar.rPN, z2, 1, z);
                }
                layoutParams = i5.getLayoutParams();
                layoutParams.width = this.rVc;
                layoutParams.height = this.rVc;
                i5.setLayoutParams(layoutParams);
                if (findViewById != null) {
                    layoutParams = findViewById.getLayoutParams();
                    layoutParams.width = this.rVc;
                    layoutParams.height = this.rVc;
                    findViewById.setLayoutParams(layoutParams);
                }
                if (i3 == i4 && are.kzz == 2) {
                    i5.setVisibility(0);
                    i5.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                }
                a aVar6 = new a();
                aVar6.index = i4;
                if (findViewById == null) {
                    findViewById = i5;
                }
                aVar6.view = findViewById;
                aVar6.rVj = i5;
                aVar6.rVk = cVar;
                aVar6.qZY = are;
                aVar6.rEl = ayVar.qEj;
                if (aVar != null) {
                    aVar.rVl = aVar6;
                    aVar3 = aVar2;
                } else {
                    aVar3 = aVar6;
                }
                if (i4 == bpb.wYj.wfh.size() - 1) {
                    aVar6.rVl = aVar3;
                }
                if (i4 == i3) {
                    cVar.rUL = aVar6;
                    a(aVar6);
                }
                aVar4 = aVar6;
            } else {
                aVar3 = aVar2;
                aVar4 = aVar;
            }
            i4++;
            aVar2 = aVar3;
            aVar = aVar4;
        }
        if (cVar.nav != null && (cVar.nav instanceof FrameLayout)) {
            ((FrameLayout) cVar.nav).setClipChildren(false);
        }
        if (cVar.rTQ != null) {
            cVar.rTQ.setClipChildren(false);
        }
        if (cVar.rUP != null && (cVar.rUP instanceof LinearLayout)) {
            ((LinearLayout) cVar.rUP).setClipChildren(false);
        }
        final av avVar3 = avVar;
        final int i6 = i3;
        final c cVar2 = cVar;
        cVar.rUJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                avVar3.rfs.rVX.onClick(view);
                if (i6 > 0) {
                    avVar3.rNs.rxv.em(cVar2.rTG);
                }
            }
        });
    }

    public static View i(View view, int i, int i2) {
        if (i2 == 6) {
            return view.findViewById(rVe[0]);
        }
        return view.findViewById(rVd[i]);
    }

    private static void a(a aVar) {
        View findViewById = aVar.rVk.rUJ.findViewById(f.qLM);
        View findViewById2 = aVar.rVk.rUJ.findViewById(f.qLL);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        ((TextView) aVar.rVk.rUJ.findViewById(f.qLY)).setText(null);
        ((TextView) aVar.rVk.rUJ.findViewById(f.qLZ)).setText(null);
        ((TextView) aVar.rVk.rUJ.findViewById(f.qLW)).setText(null);
        ((TextView) aVar.rVk.rUJ.findViewById(f.qLX)).setText(null);
        com.tencent.mm.plugin.sns.storage.b byB = aVar.rEl.byB();
        if (byB.rlo != null && byB.rlo.rlu != null && byB.rlo.rlu.size() >= 2) {
            com.tencent.mm.plugin.sns.storage.b.e eVar = (com.tencent.mm.plugin.sns.storage.b.e) byB.rlo.rlu.get(aVar.index);
            if (eVar.rlA >= 0 && eVar.rlA < rVf.length) {
                int[] iArr = rVf[eVar.rlA];
                TextView textView = (TextView) aVar.rVk.rUJ.findViewById(iArr[0]);
                TextView textView2 = (TextView) aVar.rVk.rUJ.findViewById(iArr[1]);
                if (bi.oN(eVar.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(eVar.title);
                }
                if (bi.oN(eVar.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(eVar.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
    }
}
