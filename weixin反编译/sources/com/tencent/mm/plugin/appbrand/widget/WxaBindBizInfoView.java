package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.af.m;
import com.tencent.mm.bu.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int kbg = a.fromDPToPix(ad.getContext(), 15);
    private static int kbh = a.fromDPToPix(ad.getContext(), 30);
    private TextView jOY;
    public List<WxaEntryInfo> kaZ;
    private View kba;
    private ImageView kbb;
    private TextView kbc;
    private LinearLayout kbd;
    private ViewGroup kbe;
    private View kbf;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.kaZ = new LinkedList();
        View inflate = View.inflate(getContext(), h.izA, this);
        this.kba = inflate.findViewById(g.cih);
        this.kbb = (ImageView) inflate.findViewById(g.coN);
        this.jOY = (TextView) inflate.findViewById(g.cSo);
        this.kbc = (TextView) inflate.findViewById(g.bZb);
        this.kbf = inflate.findViewById(g.cxm);
        this.kbd = (LinearLayout) inflate.findViewById(g.bYI);
        this.kbe = (ViewGroup) inflate.findViewById(g.crs);
    }

    public final void dr(boolean z) {
        if (this.kbe.getMeasuredWidth() != 0) {
            WxaEntryInfo wxaEntryInfo;
            if (this.kaZ.isEmpty()) {
                setVisibility(8);
                wxaEntryInfo = null;
            } else {
                setVisibility(0);
                wxaEntryInfo = (WxaEntryInfo) this.kaZ.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.kbb, this.jOY);
            }
            this.kbc.setText(getContext().getString(j.dUD, new Object[]{Integer.valueOf(this.kaZ.size())}));
            List list = this.kaZ;
            this.kbd.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = (this.kbe.getMeasuredWidth() - this.kbe.getPaddingLeft()) - this.kbe.getPaddingRight();
                int i = measuredWidth / (kbh + kbg);
                if (i > size) {
                    this.kbf.setVisibility(8);
                } else {
                    this.kbf.setVisibility(0);
                    i = (measuredWidth - this.kbf.getMeasuredWidth()) / (kbh + kbg);
                }
                measuredWidth = Math.min(i, size);
                if (measuredWidth > 1) {
                    for (size = 0; size < measuredWidth; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(getContext());
                        imageView.setLayoutParams(new LayoutParams(kbh + kbg, kbh));
                        imageView.setPadding(0, 0, kbg, 0);
                        this.kbd.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                x.i("MicroMsg.WxaBindBizInfoView", "attachItemToContainer(size : %s)", Integer.valueOf(list.size()));
            }
            if (this.kaZ.size() == 1) {
                this.kba.setVisibility(0);
                this.kbe.setTag(((WxaEntryInfo) this.kaZ.get(0)).username);
                return;
            }
            this.kba.setVisibility(8);
            this.kbe.setTag(null);
        } else if (z) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    WxaBindBizInfoView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    WxaBindBizInfoView.this.dr(false);
                    return true;
                }
            });
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                Bitmap kj = m.kj(wxaEntryInfo.username);
                if (kj == null || kj.isRecycled()) {
                    b.Jp().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
                } else {
                    imageView.setImageBitmap(kj);
                }
            }
            if (textView != null) {
                textView.setText(bi.oM(wxaEntryInfo.title));
            }
        }
    }
}
