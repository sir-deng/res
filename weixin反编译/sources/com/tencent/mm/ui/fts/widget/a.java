package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public final class a extends LinearLayout {
    private View obQ = findViewById(g.bIc);
    public FTSEditTextView znx;
    public a zny;

    public interface b extends Comparable {
        String getTagName();
    }

    public interface a {
        void bqI();
    }

    public a(Context context) {
        super(context);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(h.gYU, this, true);
        this.obQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.zny != null) {
                    a.this.zny.bqI();
                }
            }
        });
        this.znx = (FTSEditTextView) findViewById(g.ckk);
    }
}
