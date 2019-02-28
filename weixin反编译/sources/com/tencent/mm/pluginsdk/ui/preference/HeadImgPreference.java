package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgPreference extends Preference {
    private int height;
    private ImageView jSg;
    public OnClickListener ugx;
    private Bitmap vAc;

    public HeadImgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnG, viewGroup2);
        this.jSg = (ImageView) onCreateView.findViewById(R.h.cpj);
        return onCreateView;
    }

    public final void O(Bitmap bitmap) {
        this.vAc = null;
        if (this.jSg != null) {
            this.jSg.setImageBitmap(bitmap);
        } else {
            this.vAc = bitmap;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jSg == null) {
            this.jSg = (ImageView) view.findViewById(R.h.cpj);
        }
        if (this.ugx != null) {
            this.jSg.setOnClickListener(this.ugx);
        }
        if (this.vAc != null) {
            this.jSg.setImageBitmap(this.vAc);
            this.vAc = null;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cwt);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
    }
}
