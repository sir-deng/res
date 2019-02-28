package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar lvk = null;
    private Context mContext = null;
    TextView snK;
    TextView snL;
    b snM;
    a snN;

    public interface a {
        void bGz();
    }

    public interface b {
        void bGA();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.i.dpi, this);
        this.lvk = (ProgressBar) findViewById(R.h.cAG);
        this.snK = (TextView) findViewById(R.h.cAF);
        this.snL = (TextView) findViewById(R.h.cAH);
        this.snL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (NoiseDetectMaskView.this.snM != null) {
                    NoiseDetectMaskView.this.snM.bGA();
                }
            }
        });
        findViewById(R.h.csO).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (NoiseDetectMaskView.this.snN != null) {
                    NoiseDetectMaskView.this.snN.bGz();
                }
            }
        });
    }
}
