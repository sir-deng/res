package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    ArrayList<View> Yo;
    Context mContext;
    MMAutoHeightViewPager tiG;
    MMPageControlView tiH;
    a tiI;
    d[] tiJ;

    private class a extends u {
        private a() {
        }

        /* synthetic */ a(WalletPayUOpenIntroView walletPayUOpenIntroView, byte b) {
            this();
        }

        public final int getCount() {
            return WalletPayUOpenIntroView.this.tiJ == null ? 0 : WalletPayUOpenIntroView.this.tiJ.length;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = (View) WalletPayUOpenIntroView.this.Yo.get(i);
            viewGroup.addView(view);
            d dVar = WalletPayUOpenIntroView.this.tiJ[i];
            TextView textView = (TextView) view.findViewById(f.uDD);
            TextView textView2 = (TextView) view.findViewById(f.hint);
            ((ImageView) view.findViewById(f.logo)).setImageResource(dVar.tiE);
            textView.setText(dVar.titleRes);
            textView2.setText(dVar.tiF);
            return view;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) WalletPayUOpenIntroView.this.Yo.get(i));
        }
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uJT, this, true);
        this.tiG = (MMAutoHeightViewPager) inflate.findViewById(f.cCs);
        this.tiH = (MMPageControlView) inflate.findViewById(f.upx);
        this.tiH.setVisibility(0);
        this.tiG.zo = new e() {
            public final void a(int i, float f, int i2) {
            }

            public final void ae(int i) {
                if (WalletPayUOpenIntroView.this.tiG.getParent() != null) {
                    WalletPayUOpenIntroView.this.tiG.getParent().requestDisallowInterceptTouchEvent(true);
                }
                WalletPayUOpenIntroView.this.tiH.xs(i);
            }

            public final void af(int i) {
            }
        };
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }
}
