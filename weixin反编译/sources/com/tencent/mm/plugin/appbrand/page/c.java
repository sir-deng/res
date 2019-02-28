package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private int RT;
    private View jIo;
    CustomViewCallback jIp;
    private int jIq = 0;
    private Set<x> jIr = Collections.newSetFromMap(new ConcurrentHashMap());
    private Context mContext;

    c(Context context) {
        this.mContext = context;
    }

    final void r(View view, int i) {
        ajq();
        this.jIo = view;
        MMActivity mMActivity = (MMActivity) this.mContext;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        this.jIq = viewGroup.getSystemUiVisibility();
        viewGroup.addView(view, layoutParams);
        view.setX(0.0f);
        view.setY(0.0f);
        if (d.fO(19)) {
            viewGroup.setSystemUiVisibility(2);
        } else {
            viewGroup.setSystemUiVisibility(4102);
        }
        mMActivity.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.RT = mMActivity.getRequestedOrientation();
        switch (i) {
            case -90:
                mMActivity.setRequestedOrientation(8);
                break;
            case 0:
                mMActivity.setRequestedOrientation(1);
                break;
            case 90:
                mMActivity.setRequestedOrientation(0);
                break;
            default:
                mMActivity.setRequestedOrientation(9);
                break;
        }
        ajr();
    }

    final boolean ajq() {
        if (this.jIo == null) {
            return false;
        }
        if (this.jIp != null) {
            this.jIp.onCustomViewHidden();
        }
        MMActivity mMActivity = (MMActivity) this.mContext;
        ViewGroup viewGroup = (ViewGroup) mMActivity.getWindow().getDecorView();
        viewGroup.setSystemUiVisibility(this.jIq);
        viewGroup.removeView(this.jIo);
        mMActivity.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        mMActivity.setRequestedOrientation(this.RT);
        this.jIo = null;
        this.jIp = null;
        for (x agJ : this.jIr) {
            agJ.agJ();
        }
        return true;
    }

    final void a(x xVar) {
        this.jIr.add(xVar);
    }

    private void ajr() {
        Iterator it = this.jIr.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
