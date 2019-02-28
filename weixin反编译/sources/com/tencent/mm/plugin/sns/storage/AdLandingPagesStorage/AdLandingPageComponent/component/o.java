package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.smtt.sdk.WebView;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o extends i {
    private static final Map<String, Bitmap> rqb = new WeakHashMap();
    ViewPager rqc;
    a rqd;
    AdLandingControlView rqe;
    private int rqf = 0;
    private int rqg = 0;
    boolean rqh = true;

    static class a extends u {
        int backgroundColor;
        int kJB;
        int kJC;
        Context mContext;
        LayoutInflater mLayoutInflater;
        n rqk;
        private int rql = 600;
        int rqm = 700;
        int rqn = 250;
        HashMap<String, View> rqo = new HashMap();
        HashMap<String, a> rqp = new HashMap();

        public class a {
            public LinkedList<i> rqv = new LinkedList();
        }

        static /* synthetic */ void a(a aVar, final ImageView imageView) {
            Animation animationSet = new AnimationSet(true);
            Animation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) aVar.rqm);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            translateAnimation = new AlphaAnimation(0.8f, 0.3f);
            translateAnimation.setDuration((long) aVar.rqm);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    Animation animationSet = new AnimationSet(true);
                    Animation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) a.this.rqm);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) a.this.rqm);
                    animationSet.addAnimation(translateAnimation);
                    translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                    translateAnimation.setDuration((long) a.this.rqm);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) a.this.rqm);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            long longValue = new BigInteger((String) imageView.getTag()).longValue();
                            if (longValue >= 3) {
                                Animation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                                alphaAnimation.setDuration((long) a.this.rqn);
                                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                                alphaAnimation.setAnimationListener(new AnimationListener() {
                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        imageView.setAlpha(0.0f);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                imageView.startAnimation(alphaAnimation);
                                return;
                            }
                            imageView.setTag(String.valueOf(longValue + 1));
                            a.a(a.this, imageView);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(animationSet);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
        }

        public a(Context context, LayoutInflater layoutInflater, n nVar, int i) {
            this.mContext = context;
            this.mLayoutInflater = layoutInflater;
            this.rqk = nVar;
            this.backgroundColor = i;
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            this.kJB = windowManager.getDefaultDisplay().getWidth();
            this.kJC = windowManager.getDefaultDisplay().getHeight();
        }

        public final int getCount() {
            return this.rqk.rmy.size();
        }

        public final boolean a(View view, Object obj) {
            return view == ((View) obj);
        }

        public final void e(Object obj) {
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View inflate = this.mLayoutInflater.inflate(g.qMY, viewGroup, false);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.qJR);
            linearLayout.setBackgroundColor(this.backgroundColor);
            a aVar = (a) this.rqp.get(String.valueOf(i));
            List list = ((m) this.rqk.rmy.get(i)).rmy;
            if (aVar == null || aVar.rqv.size() == 0) {
                this.rqp.put(String.valueOf(i), a(list, 0, list.size(), linearLayout));
            } else {
                aVar.rqv.addAll(a(list, aVar.rqv.size(), list.size(), linearLayout).rqv);
                Iterator it = aVar.rqv.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                        ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
                    }
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    i iVar2 = (i) aVar.rqv.get(i2);
                    linearLayout.addView(iVar2.getView());
                    iVar2.a((s) list.get(i2));
                }
            }
            ImageView imageView = (ImageView) inflate.findViewById(f.qJT);
            TextView textView = (TextView) inflate.findViewById(f.qJS);
            if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(com.tencent.mm.bu.a.b(this.mContext, e.qFy));
            } else {
                imageView.setImageDrawable(com.tencent.mm.bu.a.b(this.mContext, e.qFz));
            }
            if (this.rqk.rmA == 1) {
                imageView.setVisibility(8);
                textView.setVisibility(8);
            } else {
                if (i == this.rqk.rmy.size() - 1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                textView.setText((i + 1) + "/" + this.rqk.rmy.size());
            }
            inflate.setLayoutParams(new LayoutParams(this.kJB, linearLayout.getMeasuredHeight()));
            inflate.setBackgroundColor(this.backgroundColor);
            viewGroup.addView(inflate);
            viewGroup.setBackgroundColor(this.backgroundColor);
            this.rqo.put(String.valueOf(i), inflate);
            return inflate;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int k(Object obj) {
            return -2;
        }

        public final void xp(int i) {
            View view = (View) this.rqo.get(String.valueOf(i));
            if (view != null) {
                final ImageView imageView = (ImageView) view.findViewById(f.qJT);
                if (imageView != null && imageView.getVisibility() == 0) {
                    if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                        imageView.setTag("1");
                        Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        alphaAnimation.setDuration((long) this.rql);
                        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                        alphaAnimation.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                new ag().postDelayed(new Runnable() {
                                    public final void run() {
                                        a.a(a.this, imageView);
                                    }
                                }, 200);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        imageView.startAnimation(alphaAnimation);
                    }
                }
            }
        }

        public final void xq(int i) {
            for (String str : this.rqp.keySet()) {
                a aVar = (a) this.rqp.get(str);
                if (!(aVar == null || aVar.rqv.size() == 0)) {
                    int i2;
                    i iVar;
                    if (str.equals(String.valueOf(i))) {
                        for (i2 = 0; i2 < aVar.rqv.size(); i2++) {
                            iVar = (i) aVar.rqv.get(i2);
                            if (!iVar.rpp) {
                                iVar.bxr();
                            }
                        }
                    } else {
                        for (i2 = 0; i2 < aVar.rqv.size(); i2++) {
                            iVar = (i) aVar.rqv.get(i2);
                            if (iVar.rpp) {
                                iVar.bxs();
                            }
                        }
                    }
                }
            }
        }

        private a a(List<s> list, int i, int i2, ViewGroup viewGroup) {
            a aVar = new a();
            if (list == null) {
                return aVar;
            }
            int max = Math.max(0, i);
            int min = Math.min(list.size(), i2);
            for (int i3 = max; i3 < min; i3++) {
                i a = am.a(this.mContext, (s) list.get(i3), viewGroup, this.backgroundColor);
                aVar.rqv.add(a);
                viewGroup.addView(a.getView());
            }
            return aVar;
        }
    }

    public o(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
        this.rqe = new AdLandingControlView(context);
    }

    public final void bxr() {
        this.rqd.xp(this.rqc.yF);
        if (this.rqh) {
            this.rqd.xq(0);
            this.rqh = false;
        } else {
            this.rqd.xq(this.rqg);
        }
        super.bxr();
    }

    public final void bxs() {
        this.rqd.xq(-1);
        super.bxs();
    }

    public final void Q(Map<String, Object> map) {
        super.Q(map);
        if (map.containsKey("startIndex")) {
            try {
                this.rqf = ((Integer) map.get("startIndex")).intValue();
                this.rqc.d(this.rqf, false);
            } catch (Exception e) {
            }
        }
    }

    public final void bxQ() {
        super.bxQ();
        this.rqc.d(this.rqf, false);
    }

    protected final void bxK() {
        a aVar;
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = (windowManager.getDefaultDisplay().getWidth() - ((int) ((n) this.rpm).rmR)) - ((int) ((n) this.rpm).rmS);
        int height = windowManager.getDefaultDisplay().getHeight();
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (this.rqc.yE == null) {
            final u aVar2 = new a(this.context, layoutInflater, (n) this.rpm, this.backgroundColor);
            this.rqc.zo = new ViewPager.e() {
                public final void a(int i, float f, int i2) {
                }

                public final void ae(int i) {
                    o.this.rqe.xs(i);
                    o.this.rqg = i;
                    if (o.this.rpp) {
                        aVar2.xp(i);
                        aVar2.xq(i);
                    }
                }

                public final void af(int i) {
                }
            };
            this.rqc.a(aVar2);
            aVar = aVar2;
        } else {
            a aVar3 = (a) this.rqc.yE;
            aVar3.rqk = (n) this.rpm;
            aVar = aVar3;
        }
        this.rqe.eU(((n) this.rpm).rmy.size(), 0);
        if (((n) this.rpm).rmB) {
            this.rqc.setLayoutParams(new LayoutParams(width, height));
        } else if (((n) this.rpm).rmy.size() > 0) {
            m mVar = (m) ((n) this.rpm).rmy.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i = 0;
            Iterator it = mVar.rmy.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                int i2 = (int) (((float) i) + sVar.rmP);
                if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u uVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u) sVar;
                    View inflate = layoutInflater.inflate(g.qMX, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(f.qJE)).setText(uVar.rnk);
                    ((TextView) inflate.findViewById(f.qJE)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = ((TextView) inflate.findViewById(f.qJE)).getPaddingBottom() + ((i2 + ((TextView) inflate.findViewById(f.qJE)).getPaddingTop()) + ((TextView) inflate.findViewById(f.qJE)).getHeight());
                } else if (sVar instanceof l) {
                    Button button = (Button) layoutInflater.inflate(g.qMP, null).findViewById(f.qJJ);
                    button.setText(((l) sVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    int paddingTop = button.getPaddingTop() + i2;
                    if (sVar.rmU > 0.0f && ((int) sVar.rmU) != Integer.MAX_VALUE) {
                        paddingTop = (int) (((float) paddingTop) + sVar.rmU);
                    } else if (sVar.height <= 0.0f || ((int) sVar.height) == Integer.MAX_VALUE) {
                        paddingTop += button.getHeight();
                    } else {
                        paddingTop = (int) (((float) paddingTop) + sVar.height);
                    }
                    i = button.getPaddingBottom() + paddingTop;
                } else if (sVar instanceof p) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = sVar.rmP;
                    float f4 = sVar.rmQ;
                    if (sVar instanceof p) {
                        p pVar = (p) sVar;
                        f = pVar.height;
                        f2 = pVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i = i2 + height;
                    } else {
                        i = (int) (((f * ((float) width)) / f2) + ((float) i2));
                    }
                    i = (int) (((float) ((int) (((float) i) + f3))) + f4);
                } else if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                    i = i2 + height;
                } else if (sVar instanceof q) {
                    q qVar = (q) sVar;
                    if (qVar.rmK == 1) {
                        i = i2 + height;
                    } else if (((int) qVar.width) > 0) {
                        i = ((((int) qVar.height) * width) / ((int) qVar.width)) + i2;
                    } else {
                        i = (int) (qVar.height + ((float) i2));
                    }
                } else if (sVar instanceof w) {
                    w wVar = (w) sVar;
                    if (wVar.rnr != 1) {
                        i = i2 + height;
                    } else if (((int) wVar.width) > 0) {
                        i = ((((int) wVar.height) * width) / ((int) wVar.width)) + i2;
                    } else {
                        i = (int) (wVar.height + ((float) i2));
                    }
                } else if (sVar instanceof v) {
                    i = i2 + height;
                } else {
                    i = i2;
                }
                i = (int) (sVar.rmQ + ((float) i));
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(width, i);
            layoutParams.leftMargin = (int) ((n) this.rpm).rmR;
            layoutParams.rightMargin = (int) ((n) this.rpm).rmS;
            this.rqc.setLayoutParams(layoutParams);
        }
        this.rqd = aVar;
        aVar.notifyDataSetChanged();
    }

    public final View bxG() {
        View view = this.contentView;
        this.rqc = (ViewPager) view.findViewById(f.qJW);
        this.rqe = (AdLandingControlView) view.findViewById(f.qJF);
        return view;
    }

    protected final int bkr() {
        return g.qMZ;
    }

    public final boolean T(JSONObject jSONObject) {
        if (super.T(jSONObject)) {
            return true;
        }
        return false;
    }

    public final LinkedList<JSONObject> bxZ() {
        a aVar = this.rqd;
        LinkedList<JSONObject> linkedList = new LinkedList();
        for (String str : aVar.rqp.keySet()) {
            a aVar2 = (a) aVar.rqp.get(str);
            if (aVar2 != null && aVar2.rqv.size() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= aVar2.rqv.size()) {
                        break;
                    }
                    i iVar = (i) aVar2.rqv.get(i2);
                    JSONObject jSONObject = new JSONObject();
                    if (iVar.T(jSONObject)) {
                        linkedList.add(jSONObject);
                    }
                    i = i2 + 1;
                }
            }
        }
        return linkedList;
    }
}
