package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.k;

public class MMCollapsibleTextView extends LinearLayout {
    private Context context;
    private boolean hasCheck = true;
    private TextView ipP;
    private Runnable mxE = new Runnable() {
        public final void run() {
            MMCollapsibleTextView.this.ipP.setMaxLines(10);
            MMCollapsibleTextView.this.ryb.setVisibility(0);
            MMCollapsibleTextView.this.ryb.setText(MMCollapsibleTextView.this.ryc);
        }
    };
    private int qXb;
    private TextView ryb;
    private String ryc;
    private String ryd;
    private SparseIntArray yis = new SparseIntArray();

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.yis.get(mMCollapsibleTextView.qXb, -1)) {
            case 0:
                mMCollapsibleTextView.ryb.setVisibility(8);
                return;
            case 1:
                mMCollapsibleTextView.ipP.setMaxLines(10);
                mMCollapsibleTextView.ryb.setVisibility(0);
                mMCollapsibleTextView.ryb.setText(mMCollapsibleTextView.ryc);
                return;
            case 2:
                mMCollapsibleTextView.ipP.setMaxLines(Integer.MAX_VALUE);
                mMCollapsibleTextView.ryb.setVisibility(0);
                mMCollapsibleTextView.ryb.setText(mMCollapsibleTextView.ryd);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.ryb.setVisibility(8);
                mMCollapsibleTextView.ipP.setMaxLines(11);
                return;
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.ryc = this.context.getString(k.hat);
        this.ryd = this.context.getString(k.has);
        View inflate = inflate(this.context, h.gZf, this);
        inflate.setPadding(0, -3, 0, 0);
        this.ipP = (TextView) inflate.findViewById(g.caU);
        this.ryb = (TextView) inflate.findViewById(g.gXe);
        this.ryb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                switch (MMCollapsibleTextView.this.yis.get(MMCollapsibleTextView.this.qXb, -1)) {
                    case 1:
                        MMCollapsibleTextView.this.yis.put(MMCollapsibleTextView.this.qXb, 2);
                        break;
                    case 2:
                        MMCollapsibleTextView.this.yis.put(MMCollapsibleTextView.this.qXb, 1);
                        break;
                    default:
                        return;
                }
                MMCollapsibleTextView.c(MMCollapsibleTextView.this);
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.hasCheck) {
            this.hasCheck = true;
            if (this.ipP.getLineCount() <= 10) {
                this.yis.put(this.qXb, 0);
                return;
            }
            this.yis.put(this.qXb, 1);
            post(this.mxE);
        }
    }
}
