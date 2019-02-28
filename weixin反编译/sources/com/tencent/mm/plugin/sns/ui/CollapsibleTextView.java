package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private Context context;
    private String fAR;
    private String fvn;
    private ag handler = new ag(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean qWK = false;
    protected SnsPostDescPreloadTextView rxZ;
    private int rxf = 0;
    protected SnsTextView rya;
    protected TextView ryb;
    private String ryc;
    private String ryd;
    private HashMap<String, Integer> rye;
    private Runnable ryf = new Runnable() {
        public final void run() {
            if (CollapsibleTextView.this.rxZ != null && (CollapsibleTextView.this.rxZ.getTag() instanceof as) && ((as) CollapsibleTextView.this.rxZ.getTag()).fAR.equals(CollapsibleTextView.this.fAR)) {
                CollapsibleTextView.this.rxZ.setMaxLines(6);
                CollapsibleTextView.this.ryb.setVisibility(0);
                CollapsibleTextView.this.ryb.setText(CollapsibleTextView.this.ryc);
            }
        }
    };
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.ryc = this.context.getString(j.qQy);
        this.ryd = this.context.getString(j.qQx);
        View inflate = v.fw(this.context).inflate(g.qMx, this);
        inflate.setPadding(0, -3, 0, 0);
        this.rxZ = (SnsPostDescPreloadTextView) inflate.findViewById(f.caU);
        this.ryb = (TextView) inflate.findViewById(f.gXe);
        this.rya = (SnsTextView) inflate.findViewById(f.qHZ);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, av avVar, String str3, boolean z) {
        this.context = avVar.fnF;
        this.rye = hashMap;
        this.text = charSequence;
        this.qWK = z;
        this.fvn = str;
        this.fAR = str2;
        this.rxf = i;
        this.ryc = this.context.getString(j.qQy);
        this.ryd = this.context.getString(j.qQx);
        this.rya.nZW = str3;
        as asVar = new as(this.fAR, this.fvn, false, false, 1);
        if (i == 0) {
            this.rxZ.setText(str3);
            this.rya.setVisibility(8);
            this.ryb.setVisibility(0);
            this.rxZ.setVisibility(0);
            this.rxZ.setOnTouchListener(new l(this.context));
            this.rxZ.setTag(asVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.ryb.setVisibility(8);
                this.rxZ.setMaxLines(7);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.ryb.setVisibility(8);
                    return;
                case 1:
                    this.rxZ.setMaxLines(6);
                    this.ryb.setVisibility(0);
                    this.ryb.setText(this.ryc);
                    return;
                case 2:
                    this.rxZ.setMaxLines(Integer.MAX_VALUE);
                    this.ryb.setVisibility(0);
                    this.ryb.setText(this.ryd);
                    return;
                default:
                    return;
            }
        }
        this.rya.setText(charSequence, bufferType);
        this.rya.setTag(asVar);
        this.rya.setVisibility(0);
        this.ryb.setVisibility(8);
        this.rxZ.setVisibility(8);
        this.rya.setOnClickListener(avVar.rfs.rVN);
    }

    public final int bzS() {
        x.i("MicroMsg.CollapsibleTextView", "count:" + this.rxZ.getLineCount() + "  height:" + this.rxZ.getLineHeight());
        return (this.rxZ.getLineCount() - 6) * this.rxZ.getLineHeight();
    }

    public final void i(OnClickListener onClickListener) {
        if (this.ryb != null) {
            this.ryb.setOnClickListener(onClickListener);
        }
    }

    public void setLongClickable(boolean z) {
        this.ryb.setLongClickable(z);
        this.rya.setLongClickable(z);
        this.rxZ.setLongClickable(z);
        super.setLongClickable(z);
    }

    public void setClickable(boolean z) {
        this.ryb.setClickable(z);
        this.rya.setClickable(z);
        this.rxZ.setClickable(z);
        super.setClickable(z);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rxf == 0 && !this.qWK && !this.hasCheck) {
            this.hasCheck = true;
            if (this.rxZ.getLineCount() <= 6) {
                this.rye.put(this.fvn, Integer.valueOf(0));
                return;
            }
            this.rye.put(this.fvn, Integer.valueOf(1));
            this.handler.post(this.ryf);
        }
    }
}
