package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView lhD;
    public String nYR = "";
    public String nYS = "";
    public SimpleImageView nYT;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.dpw, this);
        this.lhD = (TextView) inflate.findViewById(R.h.coy);
        this.nYT = (SimpleImageView) inflate.findViewById(R.h.cot);
        this.lhD.setVisibility(8);
        this.nYT.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                x.d("MicroMsg.PoiHeaderView", "click url %s", bi.oN(PoiHeaderView.this.nYS) ? PoiHeaderView.this.nYR : PoiHeaderView.this.nYS);
                intent.putExtra("rawUrl", r0);
                intent.putExtra("showShare", false);
                d.a(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        });
    }
}
