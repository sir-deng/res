package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView rHb;
    public MaskTextView rTd;

    public TranslateCommentTextView(Context context) {
        super(context);
        init();
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(g.qOq, this);
        this.rTd = (MaskTextView) findViewById(f.qHK);
        this.rHb = (SnsTranslateResultView) findViewById(f.qLG);
        this.rHb.setVisibility(8);
    }
}
