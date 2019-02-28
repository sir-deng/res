package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.tencent.mm.by.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.plugin.appbrand.dynamic.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private static volatile boolean gQM = false;
    private static volatile int iZb = 0;

    public static void initialize() {
        a.post(new Runnable() {
            public final void run() {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.gOV;
                com.tencent.mm.storage.c fp = com.tencent.mm.ipcinvoker.wx_extension.a.a.fp("100284");
                if (fp == null) {
                    x.i("MicroMsg.WidgetDrawableViewFactory", "widget canvas mode ABTest item is null.");
                } else if (fp.isValid()) {
                    try {
                        c.ke(bi.getInt((String) fp.civ().get("mode"), 0));
                        x.i("MicroMsg.WidgetDrawableViewFactory", "current canvas mode is : %d", Integer.valueOf(c.iZb));
                    } catch (Throwable e) {
                        x.w("MicroMsg.WidgetDrawableViewFactory", "parse widget canvas mode error : %s", Log.getStackTraceString(e));
                    }
                } else {
                    c.ke(0);
                }
            }
        });
    }

    public static void ke(int i) {
        iZb = i;
        gQM = true;
    }

    public static int adD() {
        return iZb;
    }

    public static View be(Context context) {
        if (!gQM) {
            initialize();
        }
        x.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", Integer.valueOf(iZb));
        View mTextureView;
        switch (iZb) {
            case 1:
                mTextureView = new MTextureView(context);
                mTextureView.iOr.iND.iNZ = b.abD();
                return mTextureView;
            case 2:
                mTextureView = new MSurfaceView(context);
                mTextureView.iOr.iND.iNZ = b.abD();
                return mTextureView;
            case 3:
                mTextureView = new MCanvasView(context);
                mTextureView.iOr.iND.iNZ = b.abD();
                return mTextureView;
            case 4:
                mTextureView = new MDrawableView(context);
                mTextureView.iOr.iND.iNZ = b.abD();
                return mTextureView;
            default:
                mTextureView = new MHardwareAccelerateDrawableView(context);
                mTextureView.iOr.iND.iNZ = b.abD();
                return mTextureView;
        }
    }

    public static String adE() {
        switch (iZb) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }
}
