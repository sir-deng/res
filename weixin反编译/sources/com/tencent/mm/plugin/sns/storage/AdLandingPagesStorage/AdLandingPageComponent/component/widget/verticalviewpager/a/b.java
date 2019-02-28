package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class b extends Fragment {
    private static int rsV;
    private int bgColor;
    private boolean hJu;
    private boolean iky;
    private int kJB;
    private int kJC;
    private LinearLayoutManager roJ;
    private final Map<String, Bitmap> rqb = new WeakHashMap();
    private int rql = 1000;
    private int rqm = 700;
    private c rsR;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b rsW;
    private z rsX;
    private boolean rsY;
    private boolean rsZ;
    public boolean rta;
    private int rtb;
    public int rtc;
    private ah rtd;
    private a rte;
    private b rtf;
    private a rtg;
    private boolean rth;
    private int rti;

    public interface a extends Serializable {
        void o(b bVar);
    }

    private static class b {
        public LinearLayout iYQ;
        public RecyclerView jTh;
        public View rts;
        public ImageView rtt;
        public ImageView rtu;
        public boolean rtv;
        LinearLayout rtw;

        private b() {
            this.rtt = null;
            this.iYQ = null;
            this.rtu = null;
            this.rtv = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static /* synthetic */ void a(b bVar, final b bVar2) {
        if (!bVar2.rtv) {
            return;
        }
        if (bVar2.rtu.getVisibility() != 0) {
            x.d("ContentFragment", "nextBtn not visible");
            return;
        }
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -10.0f);
        translateAnimation.setDuration((long) bVar.rqm);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.8f, 0.3f);
        translateAnimation.setDuration((long) bVar.rqm);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (bVar2.rtu.getVisibility() != 0) {
                    x.d("ContentFragment", "nextBtn not visible");
                    return;
                }
                Animation animationSet = new AnimationSet(true);
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -10.0f, 0.0f);
                translateAnimation.setDuration((long) b.this.rqm);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) b.this.rqm);
                animationSet.addAnimation(translateAnimation);
                translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                translateAnimation.setDuration((long) b.this.rqm);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) b.this.rqm);
                animationSet.addAnimation(translateAnimation);
                animationSet.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        b.a(b.this, bVar2);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                bVar2.rtu.startAnimation(animationSet);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        bVar2.rtu.startAnimation(animationSet);
    }

    static /* synthetic */ void a(b bVar, String str, ImageView imageView) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(bVar.rsX.width, 0.0f) > 0) {
            layoutParams.width = (int) bVar.rsX.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(bVar.rsX.height, 0.0f) > 0) {
            layoutParams.height = (int) bVar.rsX.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = (int) bVar.rsX.rmQ;
        }
        imageView.setImageBitmap(decodeFile);
    }

    static /* synthetic */ void a(b bVar, final String str, final String str2, final String str3) {
        if (bVar.rtd == null) {
            bVar.rtd = new ah();
        }
        bVar.rtd.F(new Runnable() {
            public final void run() {
                float f = 1.0f;
                Bitmap bitmap = null;
                x.i("ContentFragment", "download bg ok path %s ", str);
                try {
                    if (b.this.rsR.rtS) {
                        ah.h(new Runnable() {
                            public final void run() {
                                int i = 0;
                                if (b.this.rtf != null) {
                                    if ((b.this.rsR.rtS || !TextUtils.isEmpty(b.this.rsR.rtR)) && !b.this.rth) {
                                        b.this.rth = true;
                                        b.this.rtf.rtw.setVisibility(0);
                                        b.this.rtf.rtt.setScaleType(ScaleType.CENTER_CROP);
                                        b.this.rtf.rtw.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                            public final boolean onPreDraw() {
                                                if (b.this.rtf.rtw.getHeight() > 0) {
                                                    b.this.rtf.rtw.getViewTreeObserver().removeOnPreDrawListener(this);
                                                    b.this.rti = b.this.rtf.rtw.getHeight();
                                                    if (b.this.rti < b.this.kJC) {
                                                        b.this.rti = b.this.kJC;
                                                    }
                                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.rtf.rtt.getLayoutParams();
                                                    layoutParams.height = b.this.rti;
                                                    b.this.rtf.rtt.setLayoutParams(layoutParams);
                                                    x.v("ContentFragment", "set bgIV height " + b.this.rtf.rtw.getHeight() + ", count " + b.this.rtf.rtw.getChildCount());
                                                    int i = 0;
                                                    while (true) {
                                                        int i2 = i;
                                                        if (i2 >= b.this.rtf.rtw.getChildCount()) {
                                                            break;
                                                        }
                                                        Object tag = b.this.rtf.rtw.getChildAt(i2).getTag();
                                                        if (tag instanceof i) {
                                                            ((i) tag).bxq();
                                                        }
                                                        i = i2 + 1;
                                                    }
                                                    b.this.rtf.rtw.removeAllViews();
                                                    b.this.rtf.rtw.setVisibility(8);
                                                }
                                                return true;
                                            }
                                        });
                                        a n = b.this.rtg;
                                        ViewGroup viewGroup = b.this.rtf.rtw;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 < n.rsR.rtT.size()) {
                                                i a = am.a(viewGroup.getContext(), (s) n.rsR.rtT.get(i2), viewGroup, n.bgColor);
                                                if (a != null) {
                                                    if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                                                        ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                                                    }
                                                    a.getView().setTag(a);
                                                    viewGroup.addView(a.getView());
                                                }
                                                i = i2 + 1;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }, 1000);
                        String ep = d.ep(str2, str3 + "_blurimg");
                        if (FileOp.bO(ep)) {
                            bitmap = BitmapFactory.decodeFile(ep);
                        } else {
                            Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                            if (decodeFile != null) {
                                n a;
                                if (decodeFile.getHeight() < b.this.kJC || decodeFile.getWidth() < b.this.kJB) {
                                    f = Math.max((((float) b.this.kJB) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) b.this.kJC)) / ((float) decodeFile.getHeight()));
                                }
                                Bitmap a2 = com.tencent.mm.sdk.platformtools.d.a(decodeFile, f, f);
                                try {
                                    a2 = Bitmap.createBitmap(a2, (a2.getWidth() - b.this.kJB) >>> 1, (a2.getHeight() - b.this.kJC) >>> 1, b.this.kJB, b.this.kJC);
                                } catch (Throwable e) {
                                    x.printErrStackTrace("ContentFragment", e, "", new Object[0]);
                                    a2 = null;
                                }
                                if (a2 != null) {
                                    a = com.tencent.mm.plugin.sns.lucky.a.a.a(a2, ep, Color.argb(com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX, 0, 0, 0), 180);
                                } else {
                                    a = null;
                                }
                                if (a != null) {
                                    bitmap = a.EK();
                                }
                            }
                        }
                    } else {
                        bitmap = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                    }
                    ah.y(new Runnable() {
                        public final void run() {
                            if (bitmap == null) {
                                x.i("ContentFragment", "decode img fail, set bg color %s", str3);
                                b.this.byo();
                                return;
                            }
                            x.i("ContentFragment", "set bg with bitmap");
                            b.this.rqb.put(str3, bitmap);
                            b.this.J(bitmap);
                        }
                    });
                } catch (Exception e2) {
                    x.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e2.toString());
                }
            }
        });
    }

    public static Fragment a(c cVar, DummyViewPager dummyViewPager, z zVar, boolean z, a aVar, boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pageInfo", cVar);
        bundle.putSerializable("viewpager", dummyViewPager);
        bundle.putSerializable("lifecycle", aVar);
        bundle.putSerializable("pageDownIconInfo", zVar);
        bundle.putBoolean("isLastPage", z);
        bundle.putBoolean("needEnterAnimation", z2);
        bundle.putBoolean("needDirectionAnimation", z3);
        Fragment bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rsV = com.tencent.mm.bu.a.fromDPToPix(getContext(), 60);
        int[] dw = ac.dw(getContext());
        this.kJB = dw[0];
        this.kJC = dw[1];
        if (this.rsR == null) {
            this.rsR = (c) getArguments().getSerializable("pageInfo");
        }
        this.rte = (a) getArguments().getSerializable("lifecycle");
        this.rsX = (z) getArguments().getSerializable("pageDownIconInfo");
        this.iky = getArguments().getBoolean("isLastPage");
        this.rsY = getArguments().getBoolean("needEnterAnimation");
        this.rsZ = getArguments().getBoolean("needDirectionAnimation");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.qMs, viewGroup, false);
        this.rtf = new b();
        this.rtf.rts = inflate;
        this.rtf.rtt = (ImageView) inflate.findViewById(f.qJG);
        this.rtf.iYQ = (LinearLayout) inflate.findViewById(f.qKb);
        this.rtf.rtu = (ImageView) inflate.findViewById(f.qLb);
        this.rtf.jTh = (RecyclerView) inflate.findViewById(f.bYR);
        this.rtf.rtw = (LinearLayout) inflate.findViewById(f.qIh);
        RecyclerView recyclerView = this.rtf.jTh;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a((DummyViewPager) getArguments().getSerializable("viewpager")));
        getActivity();
        this.roJ = new LinearLayoutManager();
        recyclerView.a(this.roJ);
        this.rtg = new a(this.rsR, this.bgColor, getActivity(), this.roJ);
        recyclerView.a(this.rtg);
        this.rsW = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(recyclerView, this);
        recyclerView.a(new k() {
            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                if (b.this.rtf.rtt != null && b.this.rtf.rtt.getVisibility() == 0) {
                    b.this.rtf.rtt.scrollBy(i, i2);
                }
            }

            public final void e(RecyclerView recyclerView, int i) {
                super.e(recyclerView, i);
                b.this.rtb = i;
                if (i == 0) {
                    if (b.this.byu()) {
                        b.this.byt();
                    }
                } else if (i == 1) {
                    b.this.bys();
                    ac.dx(b.this.getContext());
                }
            }
        });
        inflate.setTag(this.rtf);
        aKj();
        if (this.rte != null) {
            this.rte.o(this);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        x.i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.hJu = true;
        if (this.rsW != null && getUserVisibleHint()) {
            this.rsW.bxH();
        }
    }

    public final void onPause() {
        super.onPause();
        new StringBuilder().append(this).append(" onPause ").append(getUserVisibleHint());
        this.hJu = false;
        if (this.rsW != null && getUserVisibleHint()) {
            this.rsW.byj();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.rsW != null) {
            this.rsW.rsA.onDestroy();
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (this.rsW != null) {
                this.rsW.bxH();
            }
        } else if (this.rsW != null) {
            this.rsW.byj();
        }
    }

    public final void byn() {
        if (this.rsW != null) {
            this.rsW.byi();
        }
    }

    public final void a(c cVar) {
        if (this.rsR != cVar) {
            this.rsR = cVar;
            aKj();
        }
    }

    private void aKj() {
        if (this.rtf != null) {
            byo();
            if (this.rsR.rtR == null || this.rsR.rtR.length() <= 0) {
                byo();
            } else {
                final String str = this.rsR.rtR;
                x.i("ContentFragment", "bg need blur %b, url %s", Boolean.valueOf(this.rsR.rtS), str);
                if (this.rqb.containsKey(str)) {
                    x.i("ContentFragment", "bg has cache bitmap");
                    J((Bitmap) this.rqb.get(str));
                } else {
                    d.a("adId", str, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a() {
                        public final void bxM() {
                        }

                        public final void bxN() {
                            x.i("ContentFragment", "download img fail %s", str);
                            b.this.byo();
                        }

                        public final void LD(String str) {
                            b.a(b.this, str, "adId", str);
                        }
                    });
                }
            }
            if (this.rtg != null) {
                if (this.rsR.rtR == null || this.rsR.rtR.length() <= 0) {
                    this.rtg.bgColor = this.bgColor;
                } else {
                    this.rtg.bgColor = 0;
                }
                android.support.v7.widget.RecyclerView.a aVar = this.rtg;
                c cVar = this.rsR;
                if (aVar.rsR != cVar) {
                    aVar.rsR = cVar;
                    aVar.UR.notifyChanged();
                }
            }
        }
    }

    private void byo() {
        if (this.rsR.iPT != null && this.rsR.iPT.length() > 0) {
            x.i("ContentFragment", "setting bg color %s", this.rsR.iPT);
            try {
                this.bgColor = Color.parseColor(this.rsR.iPT);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.rsR.iPT);
            }
            this.rtf.rts.setBackgroundColor(this.bgColor);
            this.rtf.rtt.setBackgroundColor(this.bgColor);
            this.rtf.iYQ.setBackgroundColor(this.bgColor);
            byp();
        }
    }

    private void J(Bitmap bitmap) {
        if (bitmap != null) {
            this.rtf.rts.setBackgroundColor(0);
            this.rtf.rtt.setBackgroundColor(0);
            this.rtf.iYQ.setBackgroundColor(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rtf.rtt.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.kJC ? layoutParams.height : this.kJC;
            this.rtf.rtt.setLayoutParams(layoutParams);
            this.rtf.rtt.setImageBitmap(bitmap);
        } else {
            byo();
        }
        byp();
    }

    private void byp() {
        if (this.bgColor == 0 && this.rsR.iPT != null && this.rsR.iPT.length() > 0) {
            x.i("ContentFragment", "setDirectionColor bg color %s", this.rsR.iPT);
            try {
                this.bgColor = Color.parseColor(this.rsR.iPT);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.rsR.iPT);
            }
        }
        if (this.bgColor - WebView.NIGHT_MODE_COLOR <= -1 - this.bgColor) {
            this.rtf.rtu.setImageDrawable(com.tencent.mm.bu.a.b(getActivity(), e.qFx));
        } else {
            this.rtf.rtu.setImageDrawable(com.tencent.mm.bu.a.b(getActivity(), e.qFw));
        }
    }

    public final RecyclerView byq() {
        if (this.rtf != null) {
            return this.rtf.jTh;
        }
        return null;
    }

    public final Collection<i> byr() {
        if (this.rtg == null) {
            return Collections.EMPTY_LIST;
        }
        a aVar = this.rtg;
        return aVar.rsS == null ? Collections.EMPTY_LIST : aVar.rsS.values();
    }

    public final void bys() {
        if (this.rtf.rtu.getVisibility() == 0) {
            this.rtf.rtu.clearAnimation();
            this.rtf.rtu.setVisibility(4);
        }
    }

    public final void byt() {
        if (byu()) {
            this.rtf.rtu.clearAnimation();
            this.rtf.rtu.setVisibility(0);
            final Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.rql);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setStartOffset((long) this.rql);
            alphaAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    x.d("ContentFragment", "onAnimationStart show nextBtn");
                    b.this.rtf.rtv = true;
                }

                public final void onAnimationEnd(Animation animation) {
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            x.d("ContentFragment", "onAnimationEnd show nextBtn");
                            b.this.rtf.rtu.setAlpha(1.0f);
                            b.a(b.this, b.this.rtf);
                        }
                    }, 200);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.rsX == null || this.rsX.equals(this.rtf.rtu.getTag())) {
                this.rtf.rtu.startAnimation(alphaAnimation);
                return;
            }
            this.rtf.rtu.setTag(this.rsX);
            this.rtf.rtu.setVisibility(8);
            d.a(this.rsX.iconUrl, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a() {
                public final void bxM() {
                }

                public final void bxN() {
                    x.d("ContentFragment", "onDownloadError show nextBtn");
                    b.this.rtf.rtu.setVisibility(0);
                    b.this.rtf.rtu.startAnimation(alphaAnimation);
                }

                public final void LD(String str) {
                    x.d("ContentFragment", "onDownloaded show nextBtn");
                    b.a(b.this, str, b.this.rtf.rtu);
                    b.this.rtf.rtu.setVisibility(0);
                    b.this.rtf.rtu.startAnimation(alphaAnimation);
                }
            });
        }
    }

    public final boolean byu() {
        if (!this.rsZ || this.rtb != 0 || this.rtc != 0) {
            return false;
        }
        int fa = this.roJ.fa();
        int fb = this.roJ.fb();
        if (fa == fb && fa == -1) {
            return false;
        }
        boolean z;
        for (int i = fb; i >= fa; i--) {
            a aVar = this.rtg;
            i iVar = (i) aVar.rsS.get(((s) aVar.rsR.rtT.get(i)).rmN);
            if (iVar instanceof y) {
                fb = ((y) iVar).byg();
                if (fb >= 0 && fb < rsV) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && this.iky) {
            z = this.roJ.fb() != this.rtg.getItemCount() + -1;
        }
        return z;
    }
}
