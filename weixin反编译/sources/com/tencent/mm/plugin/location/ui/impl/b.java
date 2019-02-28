package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b extends a {
    public Activity activity;
    protected float kHQ = 0.0f;
    protected d nYW;
    protected float nrl = 0.0f;
    protected int type = 0;

    public abstract d aXa();

    public abstract int getLayoutId();

    public b(Activity activity) {
        this.activity = activity;
    }

    public void onCreate(Bundle bundle) {
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(getLayoutId());
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        x.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", Integer.valueOf(this.type));
        ((FrameLayout) findViewById(R.h.cva)).addView(d.cZ(this.activity));
        this.nYW = aXa();
        this.nYW.setMapViewOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                x.i("MicroMsg.MMBaseMapUI", "map action " + action);
                switch (action) {
                    case 0:
                        b.this.nrl = motionEvent.getX();
                        b.this.kHQ = motionEvent.getY();
                        break;
                    case 1:
                        if (Math.abs(motionEvent.getX() - b.this.nrl) > 10.0f || Math.abs(motionEvent.getY() - b.this.kHQ) > 10.0f) {
                            b.this.aXb();
                            break;
                        }
                }
                return false;
            }
        });
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    public final void onBackPressed() {
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void aXb() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        x.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.activity.finish();
        return true;
    }

    public final boolean aWZ() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    protected final void aWY() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public final void showVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
