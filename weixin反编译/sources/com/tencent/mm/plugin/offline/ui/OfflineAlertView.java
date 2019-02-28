package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

public class OfflineAlertView extends LinearLayout {
    private View contentView = null;
    public int pda = 0;
    RelativeLayout pdb = null;
    boolean pdc = true;
    a pdd = null;

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int iIG = 2;
        final /* synthetic */ View pde;
        final /* synthetic */ Runnable pdf;
        final /* synthetic */ Runnable pdg;

        AnonymousClass1(View view, Runnable runnable, Runnable runnable2, int i) {
            this.pde = view;
            this.pdf = runnable;
            this.pdg = runnable2;
        }

        public final void run() {
            OfflineAlertView.a(OfflineAlertView.this, this.pde, this.pdf, this.pdg, this.iIG);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int iIG = 4;
        final /* synthetic */ View pde;

        AnonymousClass2(View view, int i) {
            this.pde = view;
        }

        public final void run() {
            OfflineAlertView.a(OfflineAlertView.this, this.pde, this.iIG);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.ui.OfflineAlertView$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ View pde;

        AnonymousClass8(View view) {
            this.pde = view;
        }

        public final void run() {
            x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(this.pde.getHeight()), Integer.valueOf(this.pde.getMeasuredHeight()));
            LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
            if (this.pde.getHeight() > 0) {
                layoutParams.height = this.pde.getHeight();
                OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                OfflineAlertView.this.contentView.invalidate();
            }
            if (OfflineAlertView.this.pdd != null) {
                OfflineAlertView.this.pdd.onShow();
            }
        }
    }

    public interface a {
        void onClose();

        void onShow();
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, int i) {
        offlineAlertView.pda = i;
        offlineAlertView.setVisibility(0);
        k.bhD();
        bi.Wo(k.uF(196645));
        TextView textView = (TextView) offlineAlertView.contentView.findViewById(f.coL);
        if (textView != null) {
            textView.setOnClickListener(new r() {
                public final void azE() {
                    OfflineAlertView.this.dismiss();
                }
            });
            textView.setText(i.uZG);
        } else {
            x.e("MicroMsg.OfflineAlertView", "iKnowBtn is null!");
        }
        textView = (TextView) offlineAlertView.contentView.findViewById(f.uDm);
        if (textView != null) {
            textView.setText(i.uZH);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.plugin.offline.c.a.dn(OfflineAlertView.this.getContext());
                }
            });
        } else {
            x.e("MicroMsg.OfflineAlertView", "moreTV is null!");
        }
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        if (offlineAlertView.pdd != null) {
            offlineAlertView.pdd.onShow();
        }
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view, final Runnable runnable, final Runnable runnable2, int i) {
        offlineAlertView.pda = i;
        offlineAlertView.setVisibility(0);
        ((TextView) offlineAlertView.contentView.findViewById(f.coL)).setOnClickListener(new r() {
            public final void azE() {
                runnable.run();
            }
        });
        offlineAlertView.contentView.findViewById(f.uDm).setOnClickListener(new r() {
            public final void azE() {
                runnable2.run();
            }
        });
        x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.contentView.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.contentView.setLayoutParams(layoutParams);
            offlineAlertView.contentView.invalidate();
        }
        offlineAlertView.pdc = false;
        if (offlineAlertView.pdd != null) {
            offlineAlertView.pdd.onShow();
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.contentView = LayoutInflater.from(getContext()).inflate(g.uLN, this);
        this.pdb = (RelativeLayout) this.contentView.findViewById(f.uyu);
    }

    final void a(final View view, OnClickListener onClickListener, int i) {
        this.pda = i;
        setVisibility(0);
        this.pdb.removeAllViews();
        View inflate = LayoutInflater.from(getContext()).inflate(g.uLW, null);
        if (i == 6) {
            ((TextView) inflate.findViewById(f.ukZ)).setText(i.uSG);
        }
        this.pdb.addView(inflate);
        ((Button) this.contentView.findViewById(f.coL)).setOnClickListener(onClickListener);
        this.pdc = false;
        view.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight()));
                LayoutParams layoutParams = (LayoutParams) OfflineAlertView.this.contentView.getLayoutParams();
                if (view.getHeight() > 0) {
                    layoutParams.height = view.getHeight();
                    OfflineAlertView.this.contentView.setLayoutParams(layoutParams);
                    OfflineAlertView.this.contentView.invalidate();
                }
                if (OfflineAlertView.this.pdd != null) {
                    OfflineAlertView.this.pdd.onShow();
                }
            }
        });
    }

    public final boolean isShowing() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean uG(int i) {
        if (!isShowing() || i == this.pda) {
            return true;
        }
        if (i == 2 && (this.pda == 3 || this.pda == 4 || this.pda == 2 || this.pda == 5)) {
            return true;
        }
        if ((i == 5 && this.pda == 4) || i == 6) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (this.pdb != null) {
            this.pdb.removeAllViews();
        }
        setVisibility(8);
        if (this.pdd != null) {
            this.pdd.onClose();
        }
        this.pdc = true;
    }
}
