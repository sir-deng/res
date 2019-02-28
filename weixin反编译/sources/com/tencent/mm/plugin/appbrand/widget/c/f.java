package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;

public final class f extends r implements h {
    private View contentView;
    private OnShowListener kbW;
    private OnDismissListener kbX;
    private OnCancelListener kbY;
    private boolean kbZ;
    private i kca;

    public f(Context context) {
        super(context, k.eZl, 0);
        try {
            onCreate(null);
        } catch (Exception e) {
        }
    }

    public final void a(i iVar) {
        if (this.kbW != null) {
            this.kbW.onShow(this);
        }
        this.kca = iVar;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final void setContentView(int i) {
        setContentView(v.fw(getContext()).inflate(i, null));
    }

    public final void setContentView(View view) {
        this.contentView = view;
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public final void show() {
    }

    public final void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.kbW = onShowListener;
    }

    public final void onCancel() {
        if (this.kbY != null) {
            this.kbY.onCancel(this);
        }
    }

    public final void dismiss() {
        if (this.kca != null) {
            this.kca.b(this);
            if (this.kbX != null) {
                this.kbX.onDismiss(this);
            }
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.kbX = onDismissListener;
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.kbZ = z;
    }

    public final boolean ana() {
        return this.kbZ;
    }

    public final void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.kbY = onCancelListener;
    }
}
