package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.m;

public class MMFormSelectorView extends LinearLayout {
    private TextView ikL;
    private int layout;
    private Context mContext;
    private EditText pwv;
    private String title;
    private String vAe;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faw, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.haL, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(m.haM, 0);
        if (resourceId != 0) {
            this.vAe = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(m.haK, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.ikL = (TextView) findViewById(g.title);
        this.pwv = (EditText) findViewById(g.cdl);
        if (this.ikL == null || this.pwv == null) {
            x.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", this.ikL, this.pwv);
            return;
        }
        if (this.title != null) {
            this.ikL.setText(this.title);
        }
        if (this.vAe != null) {
            this.pwv.setHint(this.vAe);
        }
    }
}
