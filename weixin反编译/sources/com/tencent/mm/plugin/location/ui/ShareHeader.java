package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView ikn;
    private Context mContext;
    public ViewGroup nZh;
    public MMImageButton nZi;
    public MMImageButton nZj;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.cNS, this);
        this.nZh = (ViewGroup) inflate.findViewById(R.h.coq);
        this.nZi = (MMImageButton) inflate.findViewById(R.h.cSw);
        this.nZj = (MMImageButton) inflate.findViewById(R.h.cSy);
        this.ikn = (TextView) inflate.findViewById(R.h.title);
    }
}
