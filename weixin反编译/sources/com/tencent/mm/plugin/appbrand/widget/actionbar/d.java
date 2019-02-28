package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.q.e;

public final class d extends PopupWindow {
    private WindowManager kbN;
    private View kbO;
    public FrameLayout kbP;
    private Context mContext = null;

    public d(Context context) {
        super(context);
        this.mContext = context;
        this.kbN = (WindowManager) context.getSystemService("window");
        this.kbP = new FrameLayout(this.mContext);
    }

    public final void showAsDropDown(View view) {
        IBinder windowToken = view.getWindowToken();
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.token = windowToken;
        this.kbO = new View(this.mContext);
        this.kbO.setBackgroundColor(2130706432);
        this.kbO.setFitsSystemWindows(false);
        this.kbO.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                d.this.dismiss();
                return true;
            }
        });
        this.kbO.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                d.this.dismiss();
                return true;
            }
        });
        this.kbN.addView(this.kbO, layoutParams);
        super.showAsDropDown(view);
    }

    public final void dismiss() {
        if (this.kbO != null) {
            this.kbN.removeViewImmediate(this.kbO);
            this.kbO = null;
        }
        super.dismiss();
    }

    public final void setContentView(View view) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.topMargin = a.ab(this.mContext, e.ivb);
        layoutParams.rightMargin = a.ab(this.mContext, e.iva);
        layoutParams.leftMargin = a.ab(this.mContext, e.iva);
        this.kbP.addView(view, layoutParams);
        super.setContentView(this.kbP);
    }
}
