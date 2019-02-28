package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener pMx;
    private View tFx;
    private final OnTouchListener vuQ = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    public ContactListCustomPreference(Context context) {
        super(context);
        setLayoutResource(f.ltF);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(f.ltF);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(f.ltF);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.tFx = view;
        }
    }

    public final void onBindView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.tFx == null || this.tFx == null)) {
            viewGroup.removeAllViews();
            if (this.tFx.getParent() != null) {
                ((ViewGroup) this.tFx.getParent()).removeAllViews();
            }
            viewGroup.addView(this.tFx);
            if (this.pMx != null) {
                viewGroup.setOnClickListener(this.pMx);
            } else {
                viewGroup.setOnTouchListener(this.vuQ);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
    }
}
