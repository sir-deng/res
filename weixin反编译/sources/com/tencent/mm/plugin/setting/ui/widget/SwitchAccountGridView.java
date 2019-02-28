package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView extends GridLayout {
    private static int qsY;
    public String qmX;
    public boolean qsZ;
    public boolean qta;
    public boolean qtb;
    public String qtc;
    public boolean qtd;
    public AnimatorSet qte;
    public List<String> qtf = new ArrayList();
    public List<d> qtg = new ArrayList();
    public List<View> qth = new ArrayList();
    public b qti;
    public a qtj;
    public c qtk;

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$4 */
    class AnonymousClass4 implements AnimatorUpdateListener {
        final /* synthetic */ int qtn;

        public AnonymousClass4(int i) {
            this.qtn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
            while (i < this.qtn) {
                if (!((String) SwitchAccountGridView.this.qtf.get(i)).equals(SwitchAccountGridView.this.qtc)) {
                    ((View) SwitchAccountGridView.this.qth.get(i)).setAlpha(1.0f - floatValue);
                }
                i++;
            }
            if (this.qtn < SwitchAccountGridView.this.getChildCount()) {
                ((View) SwitchAccountGridView.this.qth.get(this.qtn)).setTranslationX(((float) ((View) SwitchAccountGridView.this.qth.get(this.qtn)).getWidth()) * floatValue);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$5 */
    class AnonymousClass5 implements AnimatorUpdateListener {
        final /* synthetic */ int qtn;

        public AnonymousClass5(int i) {
            this.qtn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            x.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(((Float) valueAnimator.getAnimatedValue()).floatValue()));
            for (int i = 0; i < this.qtn; i++) {
                if (((String) SwitchAccountGridView.this.qtf.get(i)).equals(SwitchAccountGridView.this.qtc)) {
                    ((View) SwitchAccountGridView.this.qth.get(i)).setTranslationX(((float) (((SwitchAccountGridView.this.getWidth() / 2) - (((View) SwitchAccountGridView.this.qth.get(i)).getWidth() * i)) - (((View) SwitchAccountGridView.this.qth.get(i)).getWidth() / 2))) * r3);
                    return;
                }
            }
        }
    }

    public interface a {
        void brJ();
    }

    public interface b {
        void JG(String str);
    }

    public interface c {
        void JH(String str);
    }

    private class d {
        public ImageView ilM;
        public TextView nAG;
        public ImageView qry;
        public View qto;

        private d() {
        }

        /* synthetic */ d(SwitchAccountGridView switchAccountGridView, byte b) {
            this();
        }
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qsY = getResources().getDimensionPixelOffset(R.f.buq) * 2;
    }

    public final void O(Map<String, SwitchAccountModel> map) {
        ImageView imageView;
        ImageView imageView2;
        if (!(map == null || map.isEmpty())) {
            this.qtf.addAll(map.keySet());
            Collections.sort(this.qtf);
        }
        x.i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.qtf.size()));
        for (int i = 0; i < this.qtf.size(); i++) {
            View inflate = ((Activity) getContext()).getLayoutInflater().inflate(R.i.dsu, null);
            imageView = (ImageView) inflate.findViewById(R.h.bIt);
            imageView2 = (ImageView) inflate.findViewById(R.h.bIw);
            View findViewById = inflate.findViewById(R.h.cah);
            final String str = (String) this.qtf.get(i);
            TextView textView = (TextView) inflate.findViewById(R.h.bIA);
            d dVar = new d();
            dVar.ilM = imageView;
            dVar.qry = imageView2;
            dVar.nAG = textView;
            dVar.qto = findViewById;
            imageView.setScaleType(ScaleType.FIT_XY);
            String str2 = ((SwitchAccountModel) map.get(str)).muD;
            try {
                if (!bi.oN(str2)) {
                    Bitmap decodeByteArray;
                    if (this.qtb) {
                        x.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                        byte[] d = e.d(str2, 0, e.bN(str2));
                        if (d != null) {
                            decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length);
                            if (decodeByteArray != null) {
                                imageView.setImageBitmap(decodeByteArray);
                            }
                        }
                    } else {
                        decodeByteArray = com.tencent.mm.ac.d.jj(str2);
                        if (decodeByteArray != null) {
                            imageView.setImageBitmap(decodeByteArray);
                        } else {
                            com.tencent.mm.pluginsdk.ui.a.b.a(dVar.ilM, str);
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SwitchAccountGridView", e, "get avatar error", new Object[0]);
            }
            textView.setText(i.b(getContext(), ((SwitchAccountModel) map.get(str)).username, textView.getTextSize()));
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.i("MicroMsg.SwitchAccountGridView", "click %s", str);
                    if (!SwitchAccountGridView.this.qsZ && SwitchAccountGridView.this.qti != null) {
                        SwitchAccountGridView.this.qti.JG(str);
                    }
                }
            });
            imageView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (SwitchAccountGridView.this.qtk != null) {
                        SwitchAccountGridView.this.qtk.JH(str);
                    }
                }
            });
            this.qtg.add(dVar);
            this.qth.add(inflate);
        }
        View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(R.i.dsu, null);
        imageView = (ImageView) inflate2.findViewById(R.h.bIt);
        imageView2 = (ImageView) inflate2.findViewById(R.h.bIw);
        TextView textView2 = (TextView) inflate2.findViewById(R.h.bIA);
        d dVar2 = new d();
        dVar2.ilM = imageView;
        dVar2.qry = imageView2;
        dVar2.nAG = textView2;
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageResource(R.g.bzl);
        textView2.setText(getContext().getResources().getString(R.l.dst));
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SwitchAccountGridView", "click addBtn");
                if (SwitchAccountGridView.this.qti != null) {
                    SwitchAccountGridView.this.qti.JG(null);
                }
            }
        });
        this.qtg.add(dVar2);
        this.qth.add(inflate2);
    }

    public final void brW() {
        if (this.qtd) {
            x.i("MicroMsg.SwitchAccountGridView", "playing animation");
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.qtf.size());
        int i = 0;
        while (i < min) {
            if (!this.qsZ || ((String) this.qtf.get(i)).equals(this.qmX)) {
                ((d) this.qtg.get(i)).qry.setVisibility(4);
            } else {
                ((d) this.qtg.get(i)).qry.setVisibility(0);
            }
            ((d) this.qtg.get(i)).qto.setVisibility(4);
            if (!bi.oN(this.qmX) && ((String) this.qtf.get(i)).equals(this.qmX)) {
                if (this.qta) {
                    ((ImageView) ((d) this.qtg.get(i)).qto.findViewById(R.h.cai)).setImageResource(R.g.bCR);
                } else {
                    ((ImageView) ((d) this.qtg.get(i)).qto.findViewById(R.h.cai)).setImageResource(R.g.bCQ);
                }
                if (this.qta) {
                    ((TextView) ((d) this.qtg.get(i)).qto.findViewById(R.h.caj)).setText(getContext().getResources().getString(R.l.eYX));
                } else {
                    ((TextView) ((d) this.qtg.get(i)).qto.findViewById(R.h.caj)).setText(getContext().getResources().getString(R.l.eNz));
                }
                ((d) this.qtg.get(i)).qto.setVisibility(0);
            }
            if (!bi.oN(this.qtc) && ((String) this.qtf.get(i)).equals(this.qtc)) {
                ((ImageView) ((d) this.qtg.get(i)).qto.findViewById(R.h.cai)).setImageResource(R.g.bEP);
                ((TextView) ((d) this.qtg.get(i)).qto.findViewById(R.h.caj)).setText(getContext().getResources().getString(R.l.etS));
                ((d) this.qtg.get(i)).qto.setVisibility(0);
            }
            LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = qsY;
            addView((View) this.qth.get(i), layoutParams);
            i++;
        }
        if (getChildCount() < 2) {
            ((d) this.qtg.get(this.qtg.size() - 1)).qry.setVisibility(4);
            LayoutParams layoutParams2 = new GridLayout.LayoutParams();
            layoutParams2.width = qsY;
            addView((View) this.qth.get(this.qth.size() - 1), layoutParams2);
        }
    }
}
