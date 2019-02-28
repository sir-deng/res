package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {
    private Context pkP;
    private List<com.tencent.mm.plugin.product.c.a> pkQ;
    private List<Boolean> pkR;
    private int pkS = 1;

    public final /* synthetic */ Object getItem(int i) {
        return uW(i);
    }

    public a(Context context) {
        this.pkP = context;
    }

    public final void bp(List<com.tencent.mm.plugin.product.c.a> list) {
        this.pkQ = list;
        this.pkS = 0;
        this.pkR = new ArrayList();
        if (this.pkQ != null) {
            Set hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.pkR.add(Boolean.valueOf(false));
                hashSet.add(Integer.valueOf(aVar.kzz));
            }
            this.pkS = list.size();
        }
        if (this.pkS <= 0) {
            this.pkS = 1;
        }
    }

    public final void a(Activity activity, View view, int i) {
        b bVar = (b) view.getTag();
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        x.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.pkW);
        Intent intent;
        switch (bVar.type) {
            case 0:
                return;
            case 1:
                if (bVar.pkW instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.pkW);
                    intent.putExtra("showShare", false);
                    d.b(this.pkP, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 10000);
                    return;
                }
                return;
            case 2:
                if (bVar.pkW instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.pkW;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    return;
                }
                return;
            case 4:
            case 6:
                if (bVar.pkW instanceof String) {
                    String str = (String) bVar.pkW;
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra(SlookAirButtonFrequentContactAdapter.DATA, str);
                    intent2.putExtra("QRDataFlag", false);
                    d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            case 5:
                if (((Boolean) this.pkR.get(i)).booleanValue()) {
                    this.pkR.set(i, Boolean.valueOf(false));
                } else {
                    this.pkR.set(i, Boolean.valueOf(true));
                }
                notifyDataSetChanged();
                return;
            default:
                x.w("MicroMsg.MallCustomActionAdapter", "not support type");
                return;
        }
    }

    public final int getCount() {
        return this.pkQ != null ? this.pkQ.size() : 0;
    }

    private com.tencent.mm.plugin.product.c.a uW(int i) {
        return (com.tencent.mm.plugin.product.c.a) this.pkQ.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.pkS;
    }

    public final int getItemViewType(int i) {
        return uW(i).kzz;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.pkP, g.uKa, null);
            bVar = new b();
            bVar.jOY = (TextView) view.findViewById(f.cSB);
            bVar.pkT = (TextView) view.findViewById(f.uDh);
            bVar.pkU = (ImageView) view.findViewById(f.uru);
            bVar.pkV = (HtmlTextView) view.findViewById(f.upM);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a uW = uW(i);
        if (uW != null) {
            bVar.jOY.setText(uW.nkW);
            bVar.pkT.setText(uW.pke);
            bVar.type = uW.kzz;
            bVar.pkW = uW.noL;
            bVar.title = uW.nkW;
            switch (uW.kzz) {
                case 0:
                    bVar.pkU.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.pkR.get(i)).booleanValue()) {
                        bVar.pkV.setVisibility(0);
                    } else {
                        bVar.pkV.setVisibility(8);
                    }
                    if (!bVar.pkV.getText().equals(uW.noL)) {
                        bVar.pkV.setText(uW.noL);
                        break;
                    }
                    break;
            }
        }
        return view;
    }
}
