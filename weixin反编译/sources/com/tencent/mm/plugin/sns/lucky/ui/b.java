package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.storage.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater DF;
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    List<com.tencent.mm.plugin.q.a.a> omo = new ArrayList();
    private int opJ = 1;

    class a {
        ImageView lpW;
        TextView nwk;
        TextView omb;
        TextView onI;
        TextView opP;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return wP(i);
    }

    public b(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.omo.size();
    }

    private com.tencent.mm.plugin.q.a.a wP(int i) {
        return (com.tencent.mm.plugin.q.a.a) this.omo.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.DF.inflate(g.uKK, viewGroup, false);
            aVar = new a();
            aVar.lpW = (ImageView) view.findViewById(f.uvW);
            aVar.nwk = (TextView) view.findViewById(f.uvZ);
            aVar.onI = (TextView) view.findViewById(f.uwa);
            aVar.omb = (TextView) view.findViewById(f.uvU);
            aVar.opP = (TextView) view.findViewById(f.uvY);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.q.a.a wP = wP(i);
        com.tencent.mm.kernel.g.Dr();
        x Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(wP.jPV);
        if (wP.jPV != null) {
            com.tencent.mm.pluginsdk.ui.a.b.o(aVar.lpW, wP.jPV);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", wP.jPV);
        }
        TextView textView = aVar.onI;
        Context context = this.mContext;
        long j = ((long) wP.oep) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = m.a(context.getString(i.lum, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.onI.setVisibility(0);
        if (Xv != null) {
            n.a(this.mContext, aVar.nwk, Xv.AX());
        } else {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", wP.jPV);
        }
        ako ako = new ako();
        try {
            if (wP.oeq == null || wP.oeq.wRk <= 0) {
                aVar.omb.setVisibility(8);
                aVar.opP.setVisibility(0);
                return view;
            }
            ako.aH(com.tencent.mm.platformtools.n.a(wP.oeq));
            if (ako.fMM > 0) {
                aVar.omb.setText(this.mContext.getString(i.uvJ, new Object[]{e.t(((double) ako.fMM) / 100.0d)}));
                aVar.opP.setVisibility(8);
            } else {
                aVar.omb.setVisibility(8);
                aVar.opP.setVisibility(0);
            }
            return view;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.omb.setVisibility(8);
            aVar.opP.setVisibility(8);
            aVar.lpW.setVisibility(8);
            aVar.nwk.setVisibility(8);
            aVar.onI.setVisibility(8);
        }
    }
}
