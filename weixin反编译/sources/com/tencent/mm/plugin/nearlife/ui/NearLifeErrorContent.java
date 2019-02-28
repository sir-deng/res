package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private View contentView;
    ListView ipH;
    private Context mContext;
    private TextView oWK;
    private View oWL;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.contentView = View.inflate(this.mContext, R.i.doL, this);
        this.oWK = (TextView) this.contentView.findViewById(R.h.cyQ);
        this.oWL = this.contentView.findViewById(R.h.czl);
    }

    public final void um(int i) {
        switch (i) {
            case 0:
                this.oWK.setVisibility(8);
                this.oWL.setVisibility(8);
                this.ipH.setVisibility(0);
                return;
            case 1:
                this.oWK.setVisibility(0);
                this.oWL.setVisibility(8);
                this.ipH.setVisibility(8);
                return;
            case 2:
                this.oWK.setVisibility(8);
                this.oWL.setVisibility(0);
                this.ipH.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
