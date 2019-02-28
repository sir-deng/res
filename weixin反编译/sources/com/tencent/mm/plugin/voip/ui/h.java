package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class h extends BaseSmallView {
    private TextView maq = ((TextView) findViewById(R.h.cYr));

    public h(Context context) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dua, this);
    }

    public final void Nk(String str) {
        this.maq.setTextSize(1, 14.0f);
        this.maq.setText(str);
    }

    public final void Nj(String str) {
        this.maq.setTextSize(1, 12.0f);
        this.maq.setText(str);
    }

    public final void a(CaptureView captureView) {
    }

    protected final void bIT() {
    }

    protected final void bIU() {
    }

    protected final void onAnimationEnd() {
    }
}
