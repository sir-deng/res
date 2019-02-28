package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.i;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        View appBrandDrawableView = new AppBrandDrawableView(context);
        appBrandDrawableView.iOr.iND.iNZ = i.abD();
        appBrandDrawableView.qz(pVar.mAppId);
        return new CoverViewContainer(context, appBrandDrawableView);
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final boolean agb() {
        return true;
    }

    protected final boolean agc() {
        return true;
    }
}
