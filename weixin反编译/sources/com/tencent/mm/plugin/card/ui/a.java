package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.oy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    List<CardInfo> kUx = new ArrayList();
    HashMap<String, Integer> kVv = new HashMap();
    Context mContext;

    public class a {
        public RelativeLayout kVl;
        public ImageView kVm;
        public TextView kVn;
        public TextView kVo;
        public TextView kVp;
        public TextView kVr;
        public LinearLayout kVw;
        public ImageView kVx;
        public TextView kVy;
        public TextView kVz;
    }

    public final /* synthetic */ Object getItem(int i) {
        return oh(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kUx.size();
    }

    public final CardInfo oh(int i) {
        return (CardInfo) this.kUx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b oh = oh(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dbM, null);
            aVar = new a();
            aVar.kVl = (RelativeLayout) view.findViewById(R.h.bQk);
            aVar.kVw = (LinearLayout) view.findViewById(R.h.bSq);
            aVar.kVm = (ImageView) view.findViewById(R.h.bQZ);
            aVar.kVn = (TextView) view.findViewById(R.h.bPQ);
            aVar.kVo = (TextView) view.findViewById(R.h.bRy);
            aVar.kVp = (TextView) view.findViewById(R.h.subtitle);
            aVar.kVr = (TextView) view.findViewById(R.h.bRz);
            aVar.kVx = (ImageView) view.findViewById(R.h.bRr);
            aVar.kVy = (TextView) view.findViewById(R.h.bQl);
            aVar.kVz = (TextView) view.findViewById(R.h.bSd);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (oh.atU()) {
            aVar.kVm.setVisibility(0);
            aVar.kVo.setVisibility(0);
            aVar.kVp.setVisibility(0);
            aVar.kVr.setVisibility(8);
            aVar.kVn.setVisibility(0);
            aVar.kVn.setText(oh.aui().kQL);
            if (!oh.atR()) {
                aVar.kVo.setText(oh.aui().title);
            } else if (oh.aui().vYM != null && oh.aui().vYM.size() == 1) {
                aVar.kVo.setText(((oy) oh.aui().vYM.get(0)).title);
            } else if (oh.aui().vYM != null && oh.aui().vYM.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((oy) oh.aui().vYM.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((oy) oh.aui().vYM.get(1)).title);
                aVar.kVo.setText(stringBuilder.toString());
            }
            if (oh.aui().vZl == 1) {
                aVar.kVx.setVisibility(0);
            } else {
                aVar.kVx.setVisibility(8);
            }
            long j = ((CardInfo) oh).field_begin_time;
            if (oh.getEndTime() > 0 && j > 0) {
                aVar.kVp.setText(this.mContext.getString(R.l.dQa, new Object[]{l.bq(j) + "  -  " + l.bq(oh.getEndTime())}));
                aVar.kVp.setVisibility(0);
            } else if (oh.getEndTime() > 0) {
                aVar.kVp.setText(this.mContext.getString(R.l.dPZ, new Object[]{l.bq(oh.getEndTime())}));
                aVar.kVp.setVisibility(0);
            } else {
                aVar.kVp.setText("");
                aVar.kVp.setVisibility(8);
            }
            m.a(aVar.kVm, oh.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bDU, true);
            if (oh.aui().vZj == 1) {
                aVar.kVm.setAlpha(255);
                aVar.kVz.setVisibility(8);
                aVar.kVo.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                aVar.kVp.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
            } else {
                aVar.kVz.setText(oh.aui().vZk);
                aVar.kVm.setAlpha(90);
                aVar.kVz.setVisibility(0);
                aVar.kVo.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                aVar.kVp.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
            }
            int intValue = ((Integer) this.kVv.get(oh.aun())).intValue();
            if (intValue == 1) {
                aVar.kVy.setText("");
                aVar.kVy.setVisibility(8);
            } else {
                aVar.kVy.setText("x" + intValue);
                aVar.kVy.setVisibility(0);
            }
        } else {
            aVar.kVm.setVisibility(8);
            aVar.kVo.setVisibility(8);
            aVar.kVn.setVisibility(8);
            aVar.kVp.setVisibility(8);
            aVar.kVz.setVisibility(8);
            aVar.kVy.setVisibility(8);
            aVar.kVr.setVisibility(0);
            aVar.kVl.setBackgroundColor(this.mContext.getResources().getColor(R.e.brO));
            aVar.kVr.setText(this.mContext.getResources().getString(R.l.dPc));
        }
        return view;
    }
}
