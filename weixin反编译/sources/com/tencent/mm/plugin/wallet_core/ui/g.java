package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;

public class g extends ClickableSpan {
    private int jmw = -1;
    private Context mContext = null;
    public a sZF = null;
    int su = -1;

    public interface a {
        void onClick(View view);
    }

    public g(Context context) {
        this.mContext = context;
        this.su = this.mContext.getResources().getColor(c.uhY);
        this.jmw = this.mContext.getResources().getColor(c.transparent);
    }

    public void onClick(View view) {
        if (this.sZF != null) {
            this.sZF.onClick(view);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.su);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.jmw;
    }
}
