package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bi;

public class ProfileNormalItemView extends ProfileItemView {
    private TextView jOY;
    private String mTitle;
    TextView pkT;
    CharSequence pqE;
    OnClickListener pqF;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fbg);
        this.mTitle = obtainStyledAttributes.getString(R.n.fbh);
        obtainStyledAttributes.recycle();
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bkr() {
        return R.i.dpS;
    }

    public final void init() {
        this.jOY = (TextView) findViewById(R.h.bYp);
        this.pkT = (TextView) findViewById(R.h.bYo);
    }

    public final ProfileNormalItemView vk(int i) {
        this.mTitle = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView vl(int i) {
        this.pqE = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView vm(int i) {
        this.pkT.setTextColor(i);
        return this;
    }

    public final boolean bks() {
        this.jOY.setText(this.mTitle);
        if (bi.N(this.pqE)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.pkT.setText(this.pqE);
        setOnClickListener(this.pqF);
        return true;
    }
}
