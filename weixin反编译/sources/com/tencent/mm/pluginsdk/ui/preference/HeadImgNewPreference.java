package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    private int height;
    public ImageView jSg;
    public OnClickListener ugx;
    public boolean vAa;
    private boolean vAb;
    private View vvy;
    private TextView vzY;
    public String vzZ;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        this.vAa = false;
        this.vAb = false;
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        if (this.vAb) {
            View.inflate(this.mContext, R.i.doA, viewGroup2);
        } else {
            View.inflate(this.mContext, R.i.dnH, viewGroup2);
        }
        this.jSg = (ImageView) onCreateView.findViewById(R.h.cpj);
        this.vzY = (TextView) onCreateView.findViewById(R.h.cAz);
        this.vvy = onCreateView.findViewById(R.h.cvc);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jSg == null) {
            this.jSg = (ImageView) view.findViewById(R.h.cpj);
        }
        if (this.vzY == null) {
            this.vzY = (TextView) view.findViewById(R.h.cAz);
        }
        if (this.vvy == null) {
            this.vvy = view.findViewById(R.h.cvc);
        }
        if (this.ugx != null) {
            this.vvy.setOnClickListener(this.ugx);
        }
        if (this.vzZ != null) {
            b.a(this.jSg, this.vzZ);
            this.vzZ = null;
        }
        if (this.vAa) {
            this.vzY.setVisibility(8);
            this.vvy.setVisibility(0);
        } else {
            this.vvy.setVisibility(8);
            this.vzY.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.h.cwt);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
    }
}
