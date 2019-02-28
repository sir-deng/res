package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bz.b;

public final class c {

    public static final class a {
        private ImageView fzb;
        private View mView;
        FrameLayout yeJ;
        WindowManager yeK;
        LayoutParams yeL;
        private ViewGroup.LayoutParams yeM;

        public a(Context context, View view) {
            if (this.yeJ == null || this.yeK == null) {
                view.findViewById(R.h.cyz).setVisibility(8);
                this.fzb = (ImageView) view.findViewById(R.h.button);
                ((ImageView) view.findViewById(R.h.caQ)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        a.this.cps();
                    }
                });
                this.yeL = new LayoutParams();
                this.yeL.height = -2;
                this.yeL.width = -2;
                this.yeK = (WindowManager) context.getSystemService("window");
                this.yeL.x = 0;
                this.yeL.y = 0;
                this.yeL.flags = 40;
                this.yeL.type = 2002;
                this.mView = view;
                this.yeL.gravity = 51;
                this.yeL.format = 1;
                this.yeJ = new FrameLayout(context);
                this.yeJ.setPadding(4, 4, 4, 4);
                this.yeM = new ViewGroup.LayoutParams(-2, -2);
                this.yeJ.addView(this.mView, this.yeM);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.yeJ.setOnTouchListener(new OnTouchListener() {
                    int yeO;
                    int yeP;
                    int yeQ = ((displayMetrics.widthPixels - a.this.yeL.width) - 1);
                    int yeR = ((displayMetrics.heightPixels - a.this.yeL.height) - 1);
                    long yeS;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.yeO = ((int) motionEvent.getRawX()) - a.this.yeL.x;
                                this.yeP = ((int) motionEvent.getRawY()) - a.this.yeL.y;
                                this.yeS = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.yeS < 300) {
                                    b.cmd();
                                    b.R(false, true);
                                    a.this.cps();
                                    break;
                                }
                                break;
                            case 2:
                                this.yeQ = (displayMetrics.widthPixels - a.this.yeL.width) - 1;
                                this.yeR = (displayMetrics.heightPixels - a.this.yeL.height) - 1;
                                a.this.yeL.x = ((int) motionEvent.getRawX()) - this.yeO;
                                a.this.yeL.y = ((int) motionEvent.getRawY()) - this.yeP;
                                a.this.yeL.x = a.this.yeL.x < 0 ? 0 : a.this.yeL.x;
                                a.this.yeL.x = a.this.yeL.x > this.yeQ ? this.yeQ : a.this.yeL.x;
                                a.this.yeL.y = a.this.yeL.y < 0 ? 0 : a.this.yeL.y;
                                a.this.yeL.y = a.this.yeL.y > this.yeR ? this.yeR : a.this.yeL.y;
                                a.this.yeK.updateViewLayout(a.this.yeJ, a.this.yeL);
                                break;
                        }
                        return false;
                    }
                });
            }
        }

        public final void cps() {
            try {
                if (this.yeK != null) {
                    if (this.yeJ != null) {
                        this.yeK.removeView(this.yeJ);
                    }
                    this.yeK = null;
                }
                if (this.yeJ != null) {
                    this.yeJ.removeAllViews();
                    this.yeJ = null;
                }
                this.mView = null;
            } catch (Exception e) {
            }
        }
    }

    public static void fC(Context context) {
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dtq, null));
        aVar.yeK.addView(aVar.yeJ, aVar.yeL);
    }
}
