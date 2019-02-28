package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends BaseAdapter {
    private Context mContext;
    LinkedList<a> nzC;
    List<a> nzD;
    int nzE = 0;
    String nzF;
    a nzG;
    GameRankFooter nzH;
    boolean nzI = false;
    boolean nzJ = false;
    int nzK = 0;

    public static class a implements Serializable {
        public String fEx;
        public int level = 0;
        public long mRP;
        public int njg;
    }

    static final class b {
        public TextView nzL;
        public ImageView nzM;
        public ImageView nzN;
        public TextView nzO;
        public TextView nzP;
        public ImageView nzQ;

        b() {
        }
    }

    public s(Context context, GameRankFooter gameRankFooter) {
        this.mContext = context;
        this.nzC = new LinkedList();
        this.nzD = new LinkedList();
        this.nzF = q.FY();
        this.nzH = gameRankFooter;
    }

    public final void T(LinkedList<a> linkedList) {
        int i = 25;
        if (linkedList.size() == 0) {
            x.i("MicroMsg.GameRankAdapter", "Null or empty rank info");
            return;
        }
        this.nzC.clear();
        this.nzC.addAll(linkedList);
        if (this.nzC.size() <= 25) {
            i = this.nzC.size();
        }
        this.nzE = i;
        this.nzD = this.nzC.subList(0, this.nzE);
        this.nzK = 0;
        if (this.nzC != null && this.nzC.size() > 0) {
            Iterator it = this.nzC.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                this.nzK++;
                if (!bi.oN(aVar.fEx) && aVar.fEx.equals(this.nzF)) {
                    this.nzG = aVar;
                    break;
                }
            }
        }
        if (this.nzE == this.nzC.size()) {
            this.nzH.aSs();
            this.nzJ = true;
        } else {
            this.nzH.aSr();
        }
        if (this.nzI || this.nzK <= this.nzE) {
            this.nzH.aSt();
        } else if (this.nzG != null) {
            this.nzH.a(this.nzG);
        } else {
            this.nzH.aSt();
        }
    }

    public final int getCount() {
        return this.nzD.size();
    }

    public final Object getItem(int i) {
        return this.nzD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.mContext, R.i.dlj, null);
            bVar.nzL = (TextView) view.findViewById(R.h.cFv);
            bVar.nzM = (ImageView) view.findViewById(R.h.cFu);
            bVar.nzN = (ImageView) view.findViewById(R.h.cUo);
            bVar.nzO = (TextView) view.findViewById(R.h.cUq);
            bVar.nzP = (TextView) view.findViewById(R.h.cUu);
            bVar.nzQ = (ImageView) view.findViewById(R.h.cUp);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        a aVar = (a) getItem(i);
        as.Hm();
        ag Xv = c.Ff().Xv(aVar.fEx);
        if (Xv != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nzN, Xv.field_username);
            bVar.nzO.setText(new SpannableString(i.b(this.mContext, Xv.AX(), bVar.nzO.getTextSize())));
        }
        bVar.nzP.setText(bi.formatNumber(aVar.mRP));
        switch (aVar.njg) {
            case 1:
                bVar.nzL.setVisibility(8);
                bVar.nzM.setVisibility(0);
                bVar.nzM.setImageResource(R.g.bCP);
                break;
            case 2:
                bVar.nzL.setVisibility(8);
                bVar.nzM.setVisibility(0);
                bVar.nzM.setImageResource(R.g.bGr);
                break;
            case 3:
                bVar.nzL.setVisibility(8);
                bVar.nzM.setVisibility(0);
                bVar.nzM.setImageResource(R.g.bAb);
                break;
            default:
                bVar.nzL.setVisibility(0);
                bVar.nzM.setVisibility(8);
                bVar.nzL.setText(aVar.njg);
                break;
        }
        switch (aVar.level) {
            case 1:
                bVar.nzQ.setVisibility(0);
                bVar.nzQ.setImageResource(R.g.bCK);
                break;
            case 2:
                bVar.nzQ.setVisibility(0);
                bVar.nzQ.setImageResource(R.g.bCL);
                break;
            case 3:
                bVar.nzQ.setVisibility(0);
                bVar.nzQ.setImageResource(R.g.bCM);
                break;
            case 4:
                bVar.nzQ.setVisibility(0);
                bVar.nzQ.setImageResource(R.g.bCN);
                break;
            default:
                bVar.nzQ.setVisibility(8);
                break;
        }
        if (i == 0) {
            if (getCount() == 1) {
                if (CN(aVar.fEx)) {
                    view.setBackgroundResource(R.g.bDX);
                } else {
                    view.setBackgroundResource(R.g.bDW);
                }
            } else if (CN(aVar.fEx)) {
                view.setBackgroundResource(R.g.bEd);
            } else {
                view.setBackgroundResource(R.g.bEc);
            }
        } else if (i != getCount() - 1) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
            if (CN(aVar.fEx)) {
                view.setBackgroundResource(R.g.bEb);
            } else {
                view.setBackgroundResource(R.g.bEa);
            }
        } else if (CN(aVar.fEx)) {
            if (this.nzJ) {
                view.setBackgroundResource(R.g.bDZ);
            } else {
                view.setBackgroundResource(R.g.bEb);
            }
        } else if (this.nzJ) {
            view.setBackgroundResource(R.g.bDY);
        } else {
            view.setBackgroundResource(R.g.bEa);
        }
        return view;
    }

    private boolean CN(String str) {
        if (bi.oN(str) || bi.oN(this.nzF)) {
            return false;
        }
        boolean equals = this.nzF.equals(str);
        this.nzI = equals;
        return equals;
    }
}
