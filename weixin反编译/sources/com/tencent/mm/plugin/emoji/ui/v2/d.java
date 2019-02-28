package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private boolean lOc;
    private LayoutParams lOd;
    private LayoutParams lOe;
    a lOf;
    List<sf> lzC;
    private int lzS;
    private int lzT;
    private int lzU;
    private Context mContext;
    private int mNumColumns;

    interface a {
        void mN(int i);
    }

    class b {
        LinearLayout lAa;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pr(i);
    }

    public d(Context context) {
        this.mNumColumns = 3;
        this.lOc = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.lzT = com.tencent.mm.bu.a.eB(this.mContext);
        this.lzS = this.mContext.getResources().getDimensionPixelSize(R.f.bxb);
        this.lzU = (int) (((float) (this.lzT - (this.mNumColumns * this.lzS))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final void aF(List<sf> list) {
        if (this.lzC == null) {
            this.lzC = new ArrayList();
        } else {
            this.lzC.clear();
        }
        this.lzC = list;
        notifyDataSetChanged();
    }

    private int aDx() {
        return this.lzC == null ? 0 : this.lzC.size();
    }

    public final int getCount() {
        return this.lzC == null ? 0 : (int) Math.ceil((double) (((float) this.lzC.size()) / ((float) this.mNumColumns)));
    }

    public final sf pr(int i) {
        if (i < 0 || i >= aDx() || this.lzC == null) {
            return null;
        }
        return (sf) this.lzC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = v.fw(this.mContext).inflate(R.i.dgi, null);
            bVar = new b();
            bVar.lAa = (LinearLayout) view.findViewById(R.h.cru);
            bVar.lAa.setPadding(0, this.lzU, 0, 0);
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                this.lOe = new LayoutParams(-2, -2);
                this.lOe.leftMargin = this.lzU;
                this.lOd = new LayoutParams(this.lzS, this.lzS);
                View paddingImageView = new PaddingImageView(this.mContext);
                ViewGroup.LayoutParams layoutParams = this.lOd;
                paddingImageView.addView(paddingImageView.lNZ, layoutParams);
                paddingImageView.addView(paddingImageView.lOa, layoutParams);
                bVar.lAa.addView(paddingImageView, i2, this.lOe);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            final int i4 = (this.mNumColumns * i) + i3;
            final PaddingImageView paddingImageView2 = (PaddingImageView) bVar.lAa.getChildAt(i3);
            if (i4 <= aDx() - 1) {
                sf pr = pr(i4);
                if (pr != null) {
                    String stringBuilder;
                    com.tencent.mm.ap.a.a PG;
                    String str;
                    ImageView imageView;
                    String str2;
                    if (!bi.oN(pr.phv)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        as.Hm();
                        stringBuilder = stringBuilder2.append(EmojiLogic.I(c.Fw(), "", pr.wgP)).append("_cover").toString();
                        PG = o.PG();
                        str = pr.phv;
                        imageView = paddingImageView2.lNZ;
                        str2 = pr.phv;
                        PG.a(str, imageView, f.a(stringBuilder, this.lzS, new Object[0]));
                    } else if (bi.oN(pr.nlE)) {
                        x.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    } else {
                        as.Hm();
                        stringBuilder = EmojiLogic.I(c.Fw(), "", pr.wgP);
                        PG = i.aBL();
                        str = pr.nlE;
                        imageView = paddingImageView2.lNZ;
                        str2 = pr.nlE;
                        PG.a(str, imageView, f.a(stringBuilder, this.lzS, new Object[0]));
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.lOa.setBackgroundResource(R.g.bBW);
                    paddingImageView2.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (d.this.lOf != null) {
                                d.this.lOf.mN(i4);
                            }
                        }
                    });
                } else {
                    paddingImageView2.lOa.setBackgroundDrawable(null);
                    o.PG().a("", paddingImageView2.lNZ);
                    x.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.lOa.setBackgroundDrawable(null);
                o.PG().a("", paddingImageView2.lNZ);
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        return view;
    }
}
