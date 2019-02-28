package com.tencent.mm.ui.applet;

import android.content.Context;
import android.os.Message;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bz.d.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

public final class d {
    private static int yfc = 0;

    public static final class a {
        Context context;
        ImageView fzb;
        ProgressBar fzd;
        View mView;
        TextView nub;
        FrameLayout yeJ;
        WindowManager yeK;
        LayoutParams yeL;
        private ViewGroup.LayoutParams yeM;
        boolean yfd = false;
        b yfe = new b() {
            public final void cmh() {
                a.this.fE(a.this.context);
                Toast.makeText(a.this.context, "trace file has saved ", 0).show();
            }
        };
        com.tencent.mm.bz.d.a yff;
        int yfg = 0;
        ag yfh = new ag() {
            public final void handleMessage(Message message) {
                if (a.this.nub.getVisibility() != 0) {
                    a.this.yfg = 0;
                    return;
                }
                a aVar = a.this;
                aVar.yfg++;
                a.this.cpv();
                super.handleMessage(message);
            }
        };

        public a(Context context, View view) {
            if (this.yeJ == null || this.yeK == null) {
                com.tencent.mm.bz.d.cmf().xLL = new WeakReference(this.yfe);
                this.nub = (TextView) view.findViewById(R.h.time);
                this.fzb = (ImageView) view.findViewById(R.h.button);
                ((ImageView) view.findViewById(R.h.caQ)).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.yfd && a.this.fzd.getVisibility() != 0) {
                            com.tencent.mm.bz.d.cmf().b(a.this.yff);
                        }
                        a aVar = a.this;
                        try {
                            if (aVar.yeK != null) {
                                if (aVar.yeJ != null) {
                                    aVar.yeK.removeView(aVar.yeJ);
                                }
                                aVar.yeK = null;
                            }
                            if (aVar.yeJ != null) {
                                aVar.yeJ.removeAllViews();
                                aVar.yeJ = null;
                            }
                            aVar.mView = null;
                        } catch (Exception e) {
                        }
                        d.cpu();
                    }
                });
                this.fzd = (ProgressBar) view.findViewById(R.h.cyz);
                this.fzd.setVisibility(8);
                this.context = context;
                this.yeL = new LayoutParams();
                this.yeL.height = -2;
                this.yeL.width = -2;
                this.yeK = (WindowManager) context.getSystemService("window");
                this.yeL.x = 0;
                this.yeL.y = 0;
                this.yeL.flags = 40;
                this.yeL.type = 2002;
                this.mView = view;
                this.nub.setVisibility(8);
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
                                    a aVar = a.this;
                                    aVar.yfh.removeMessages(0);
                                    aVar.yfg = 0;
                                    if (!aVar.yfd) {
                                        aVar.fzb.setVisibility(0);
                                        aVar.fzb.setBackgroundDrawable(aVar.context.getResources().getDrawable(R.g.bGZ));
                                        aVar.yfd = !aVar.yfd;
                                        aVar.yff = new com.tencent.mm.bz.d.a(null, 6, 8, 0);
                                        com.tencent.mm.bz.d.cmf().c(aVar.yff);
                                        aVar.cpv();
                                        break;
                                    }
                                    aVar.fzd.setVisibility(0);
                                    aVar.fzb.setVisibility(4);
                                    if (!com.tencent.mm.bz.d.cmf().b(aVar.yff)) {
                                        aVar.fE(aVar.context);
                                        break;
                                    }
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

        final void fE(Context context) {
            boolean z = false;
            this.fzb.setVisibility(0);
            this.fzd.setVisibility(4);
            if (!this.yfd) {
                z = true;
            }
            this.yfd = z;
            this.fzb.setBackgroundDrawable(context.getResources().getDrawable(R.g.bGY));
            this.nub.setVisibility(8);
        }

        final void cpv() {
            this.nub.setText(this.yfg);
            this.yfh.sendEmptyMessageDelayed(0, 1000);
        }
    }

    static /* synthetic */ int cpu() {
        int i = yfc;
        yfc = i - 1;
        return i;
    }

    public static void fD(Context context) {
        if (yfc <= 0) {
            a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.dtq, null));
            aVar.yeK.addView(aVar.yeJ, aVar.yeL);
            yfc++;
        }
    }
}
