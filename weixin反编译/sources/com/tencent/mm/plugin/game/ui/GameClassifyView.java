package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.eb;
import com.tencent.mm.plugin.game.c.ec;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;

public class GameClassifyView extends LinearLayout implements OnClickListener {
    private LinearLayout mAt;
    private Context mContext;
    private int niV;
    private LayoutInflater ntf;

    private static class a {
        public String extInfo;
        public int position;
        public String url;

        public a(String str, int i, String str2) {
            this.url = str;
            this.position = i;
            this.extInfo = str2;
        }
    }

    public GameClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.ntf = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.mAt = (LinearLayout) findViewById(R.h.cmJ);
    }

    public final void a(ec ecVar, int i, int i2) {
        if (ecVar == null || bi.cC(ecVar.nmz)) {
            setVisibility(8);
            return;
        }
        LinearLayout linearLayout;
        this.niV = i2;
        if (this.ntf == null) {
            this.ntf = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        }
        while (this.mAt.getChildCount() < ecVar.nmz.size()) {
            linearLayout = (LinearLayout) this.ntf.inflate(R.i.djX, this, false);
            linearLayout.setOnClickListener(this);
            this.mAt.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.mAt.getChildCount(); i3++) {
            if (i3 < ecVar.nmz.size()) {
                this.mAt.getChildAt(i3).setVisibility(0);
            } else {
                this.mAt.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < ecVar.nmz.size(); i4++) {
            linearLayout = (LinearLayout) this.mAt.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(R.h.ckS);
            e.aSC().h((ImageView) linearLayout.findViewById(R.h.ckR), ((eb) ecVar.nmz.get(i4)).nlA);
            textView.setText(((eb) ecVar.nmz.get(i4)).fpg);
            linearLayout.setTag(new a(((eb) ecVar.nmz.get(i4)).nkN, i4 + 1, ((eb) ecVar.nmz.get(i4)).nlr));
        }
        setVisibility(0);
        if (i == 2) {
            ap.a(this.mContext, 10, 1019, 1, null, this.niV, null);
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (!bi.oN(aVar.url)) {
                c.ac(this.mContext, aVar.url);
                ap.a(this.mContext, 10, 1019, aVar.position, 7, null, this.niV, aVar.extInfo);
            }
        }
    }
}
