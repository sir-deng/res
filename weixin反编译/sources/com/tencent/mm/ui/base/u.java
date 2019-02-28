package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.k;

public final class u extends Toast {
    private final Context context;
    public long duration;
    public final al fia = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (u.this.duration == -1) {
                u.this.show();
                return true;
            }
            u.this.las = u.this.las - 1;
            if (u.this.las >= 0) {
                u.this.show();
                return true;
            }
            u.this.cancel();
            return false;
        }
    }, true);
    private View jtv;
    public int las;
    private int level;
    private final TextView nOT;

    private static class a {
        private static Toast vzb = null;
        public static int ymU = 0;

        public static void aj(Context context, int i) {
            Context applicationContext = context.getApplicationContext();
            if (ymU != i) {
                vzb = null;
                ymU = i;
            }
            if (vzb == null) {
                vzb = Toast.makeText(applicationContext, "", 1);
            }
            View inflate = View.inflate(applicationContext, h.gZM, null);
            if (i == 1) {
                ((TextView) inflate.findViewById(g.gXU)).setText(k.han);
            } else if (i == 3) {
                ((TextView) inflate.findViewById(g.gXU)).setText(k.hao);
            } else {
                ((TextView) inflate.findViewById(g.gXU)).setText(k.hap);
            }
            vzb.setView(inflate);
            vzb.show();
        }
    }

    public u(Context context) {
        super(context);
        this.context = context;
        reset();
        this.jtv = View.inflate(context, h.gZT, null);
        setView(this.jtv);
        setGravity(55, 0, b.b(context, 40.0f));
        setDuration(0);
        this.nOT = (TextView) this.jtv.findViewById(g.gYE);
        switch (this.level) {
            case 1:
                this.nOT.setTextColor(-1);
                return;
            case 2:
                this.nOT.setTextColor(this.context.getResources().getColor(d.gWu));
                return;
            default:
                return;
        }
    }

    public final void setText(CharSequence charSequence) {
        this.nOT.setText(charSequence);
    }

    public final void setText(int i) {
        this.nOT.setText(i);
    }

    public final void reset() {
        this.level = 1;
        this.duration = 2000;
        this.las = ((int) (this.duration / 70)) + 1;
    }

    public static q a(Activity activity, String str, long j) {
        View inflate = View.inflate(activity, h.gZT, null);
        ((TextView) inflate.findViewById(g.gYE)).setText(str);
        final q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        qVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + cj(activity));
        new ag() {
            public final void handleMessage(Message message) {
                qVar.dismiss();
                super.handleMessage(message);
            }
        }.sendEmptyMessageDelayed(0, j);
        return qVar;
    }

    private static int cj(Context context) {
        int dimensionPixelSize;
        if (!(context instanceof ActionBarActivity) || ((ActionBarActivity) context).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.buG);
            } else {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(e.buH);
            }
        } else {
            dimensionPixelSize = ((ActionBarActivity) context).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            return context.getResources().getDimensionPixelSize(e.buH);
        }
        return dimensionPixelSize;
    }

    public static q a(final Activity activity, int i, String str) {
        View inflate = View.inflate(activity, h.gYY, null);
        TextView textView = (TextView) inflate.findViewById(g.ctj);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(g.cti);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        final q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int cj = cj(activity);
        if (i2 == 0) {
            i2 = ai(activity, 25);
        }
        i2 += cj;
        ah.y(new Runnable() {
            public final void run() {
                qVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2);
            }
        });
        ah.h(new Runnable() {
            public final void run() {
                qVar.dismiss();
            }
        }, 2000);
        ImageButton imageButton = (ImageButton) inflate.findViewById(g.cth);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                qVar.dismiss();
            }
        });
        return qVar;
    }

    public static q a(Activity activity, int i, int i2, String str, int i3, final OnClickListener onClickListener) {
        View inflate = View.inflate(activity, h.gZR, null);
        ((LinearLayout) inflate.findViewById(g.gYm)).setBackgroundColor(activity.getResources().getColor(i));
        TextView textView = (TextView) inflate.findViewById(g.gYp);
        textView.setText(str);
        textView.setOnClickListener(null);
        if (i == d.gWt || i == d.gWs) {
            textView.setTextColor(activity.getResources().getColor(d.gWg));
        }
        ImageView imageView = (ImageView) inflate.findViewById(g.gYn);
        if (i2 == 0) {
            imageView.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(activity, 16);
            textView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
        } else {
            imageView.setImageResource(i2);
        }
        final q qVar = new q(inflate);
        qVar.setWidth(-1);
        qVar.setHeight(-2);
        Rect rect = new Rect();
        final Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        int cj = cj(activity);
        if (i4 == 0) {
            i4 = ai(activity, 25);
        }
        i4 += cj;
        if (window.getDecorView() != null) {
            window.getDecorView().post(new Runnable() {
                public final void run() {
                    ah.y(new Runnable() {
                        public final void run() {
                            qVar.showAtLocation(window.getDecorView(), 48, 0, i4);
                        }
                    });
                }
            });
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(g.gYo);
        if (i3 == 0) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setImageResource(i3);
        }
        imageView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                qVar.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        return qVar;
    }

    public static void fJ(Context context) {
        if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted_ro")) {
            a.aj(context, 3);
        } else {
            a.aj(context, 1);
        }
    }

    public static void fK(Context context) {
        a.aj(context, 2);
    }

    public static int fL(Context context) {
        return ai(context, 25);
    }

    public static int ai(Context context, int i) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(bi.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMToast", e, "", new Object[0]);
            return i;
        }
    }
}
