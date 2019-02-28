package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class f {
    public Alignment gVn;
    public TruncateAt gVo;
    public boolean gVw = true;
    CharSequence gVx;
    public TextPaint gVy;
    public StaticLayout gVz;
    public int gravity;
    public int maxLength;
    public int maxLines;
    CharSequence text;

    public f(StaticLayout staticLayout) {
        this.gVz = staticLayout;
    }
}
