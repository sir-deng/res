package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private LinearLayout mAt;
    private Context mContext;
    int niV;
    private int nxJ;
    private int nxK;

    public static class a {
        public String iNr;
        public int nxL;
        public String nxM;
        public String nxN;
        public int position;
    }

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mAt = (LinearLayout) findViewById(R.h.cmE);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.nxJ = (width * 100) / 750;
        this.nxK = (width - (this.nxJ * 6)) / 14;
        this.mAt.setPadding(this.nxK, com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12), this.nxK, com.tencent.mm.bu.a.fromDPToPix(this.mContext, 12));
    }

    public final void I(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mAt.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            View linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.ap.a.a PG = o.PG();
            String str = aVar.iNr;
            com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
            aVar2.hFk = true;
            PG.a(str, imageView, aVar2.PQ());
            linearLayout.addView(imageView, this.nxJ, this.nxJ);
            View textView = new TextView(this.mContext);
            textView.setText(aVar.nxM);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(getResources().getColor(R.e.bsO));
            textView.setSingleLine(true);
            textView.setEllipsize(TruncateAt.END);
            textView.setGravity(17);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setPadding(0, com.tencent.mm.bu.a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(textView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.nxK, 0, this.nxK, 0);
            this.mAt.addView(linearLayout, layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (bi.oN(aVar.nxN)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.nxL);
                intent.putExtra("extra_category_name", aVar.nxM);
                intent.putExtra("game_report_from_scene", aVar.nxL + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                c.ac(this.mContext, aVar.nxN);
            }
            ap.a(this.mContext, 11, aVar.nxL + 100, aVar.position, i, this.niV, null);
        }
    }
}
