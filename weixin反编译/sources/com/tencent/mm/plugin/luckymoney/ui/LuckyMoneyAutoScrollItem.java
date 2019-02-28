package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> olz;
    private int jXZ;
    private Context mContext;
    private a olt;
    private long olu;
    int olv;
    private CountDownTimer olw;
    private int olx;
    b oly;

    interface b {
        void aYc();
    }

    private class a extends BaseAdapter {

        class a {
            ImageView olD;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem, byte b) {
            this();
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i % 10);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(LuckyMoneyAutoScrollItem.this.mContext).inflate(g.uIJ, null);
                a aVar2 = new a();
                aVar2.olD = (ImageView) view.findViewById(f.uDp);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.olD.setImageResource(((Integer) LuckyMoneyAutoScrollItem.olz.get(i % 10)).intValue());
            return view;
        }
    }

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.jXZ + 1;
        luckyMoneyAutoScrollItem.jXZ = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        olz = sparseArray;
        sparseArray.put(0, Integer.valueOf(e.ujI));
        olz.put(1, Integer.valueOf(e.ujJ));
        olz.put(2, Integer.valueOf(e.ujK));
        olz.put(3, Integer.valueOf(e.ujL));
        olz.put(4, Integer.valueOf(e.ujM));
        olz.put(5, Integer.valueOf(e.ujN));
        olz.put(6, Integer.valueOf(e.ujO));
        olz.put(7, Integer.valueOf(e.ujP));
        olz.put(8, Integer.valueOf(e.ujQ));
        olz.put(9, Integer.valueOf(e.ujR));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.olt = null;
        this.olu = 900;
        this.olv = 0;
        this.jXZ = 0;
        this.oly = null;
        this.mContext = context;
        this.olt = new a();
        setAdapter(this.olt);
        this.olx = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", Integer.valueOf(this.olx));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void aYb() {
        if (this.olw != null) {
            this.olw.cancel();
        }
        final long j = ((long) (this.olv * 50)) + this.olu;
        ah.y(new Runnable() {
            public final void run() {
                LuckyMoneyAutoScrollItem.this.olw = new CountDownTimer(j) {
                    public final void onTick(long j) {
                        LuckyMoneyAutoScrollItem.this.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(LuckyMoneyAutoScrollItem.this));
                    }

                    public final void onFinish() {
                        if (LuckyMoneyAutoScrollItem.this.oly != null) {
                            LuckyMoneyAutoScrollItem.this.oly.aYc();
                        }
                    }
                }.start();
            }
        });
    }
}
