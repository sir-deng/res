package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends i {
    TextView ioR;
    private RelativeLayout rqL;
    ImageView rqM;

    public u(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
        this.rpm = tVar;
    }

    protected final int bkr() {
        return g.qMU;
    }

    public final void bxq() {
        super.bxq();
    }

    protected final void bxK() {
        this.ioR.setText(((t) this.rpm).label);
        this.ioR.setTextSize(0, ((t) this.rpm).azb);
        if (((t) this.rpm).iPT != null && ((t) this.rpm).iPT.length() > 0) {
            this.rqL.setBackgroundColor(Color.parseColor(((t) this.rpm).iPT));
        }
        d.a(((t) this.rpm).rne, ((t) this.rpm).rmO, new a() {
            public final void bxM() {
            }

            public final void bxN() {
            }

            public final void LD(String str) {
                try {
                    u.this.rqM.setImageBitmap(BitmapFactory.decodeFile(str));
                    TextView textView = u.this.ioR;
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    float measureText = (u.this.rpm.rmT - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, u.this.context.getResources().getDisplayMetrics());
                    int i = (int) (measureText - (((t) u.this.rpm).value * measureText));
                    LayoutParams layoutParams = (LayoutParams) u.this.rqM.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
                    u.this.rqM.setLayoutParams(layoutParams);
                } catch (Throwable e) {
                    x.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + bi.i(e));
                }
            }
        });
    }

    public final View bxG() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.ioR = (TextView) view.findViewById(f.qJC);
        this.rqL = (RelativeLayout) view.findViewById(f.qJA);
        this.rqM = (ImageView) view.findViewById(f.qJB);
        return view;
    }

    public final void bxr() {
        super.bxr();
    }

    public final void bxs() {
        super.bxs();
    }
}
