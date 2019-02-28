package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.R;
import com.tencent.mm.af.e;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.a.c.g;
import com.tencent.mm.au.c;
import com.tencent.mm.f.a.or;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    boolean hpb;
    private View lTf;
    private TextView lTg;
    private TextView lTh;
    private TextView lTi;
    private TextView lTj;
    private View lTk;
    boolean lTl;
    Dialog lTm;
    private int width;

    public interface a {
        void zA(String str);
    }

    public static final String cx(Context context) {
        return new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
    }

    public final void a(Context context, String str, String str2, String str3, final a aVar) {
        if (!this.lTl) {
            this.lTl = true;
            this.hpb = false;
            if (this.lTm == null && !bi.oN(str3)) {
                context.getString(R.l.dGZ);
                this.lTm = h.a(context, context.getString(R.l.edY), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        ac.this.hpb = true;
                    }
                });
                this.lTm.show();
            }
            this.context = context;
            this.width = BuildConfig.VERSION_CODE;
            if (this.width > com.tencent.mm.bu.a.eB(context)) {
                this.width = com.tencent.mm.bu.a.eB(context);
            }
            this.lTf = LayoutInflater.from(context).inflate(R.i.dhq, null);
            this.lTg = (TextView) this.lTf.findViewById(R.h.cfy);
            this.lTh = (TextView) this.lTf.findViewById(R.h.cfw);
            this.lTi = (TextView) this.lTf.findViewById(R.h.cfH);
            this.lTj = (TextView) this.lTf.findViewById(R.h.cfG);
            this.lTk = this.lTf.findViewById(R.h.bMQ);
            this.lTg.setText(str);
            this.lTi.setText(str2);
            b.a((ImageView) this.lTf.findViewById(R.h.bLE), q.FY(), 0.5f, false);
            ImageView imageView = (ImageView) this.lTf.findViewById(R.h.bMO);
            this.lTf.setLayoutParams(new LayoutParams(-1, -1));
            this.lTf.measure(MeasureSpec.makeMeasureSpec(this.width, 1073741824), MeasureSpec.makeMeasureSpec(this.width, 1073741824));
            this.lTf.layout(0, 0, this.width, this.width);
            if (bi.oN(str3)) {
                imageView.setImageResource(R.e.brW);
                aVar.zA(v(null));
                this.lTl = false;
                return;
            }
            ad.aEU().a(str3, imageView, new g() {
                public final void lF(String str) {
                }

                public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
                    return null;
                }

                public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
                    if (ac.this.hpb) {
                        ac.this.lTl = false;
                        return;
                    }
                    ah.y(new Runnable() {
                        public final void run() {
                            if (ac.this.lTm.isShowing()) {
                                ac.this.lTm.dismiss();
                            }
                        }
                    });
                    aVar.zA(ac.this.v(bVar.bitmap));
                    ac.this.lTl = false;
                }
            });
        }
    }

    final String v(Bitmap bitmap) {
        int[] o;
        if (bitmap != null) {
            o = c.o(bitmap);
        } else {
            o = new int[]{-1, WebView.NIGHT_MODE_COLOR};
        }
        ShaderFactory anonymousClass3 = new ShaderFactory() {
            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, o[0]}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        };
        Drawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(anonymousClass3);
        this.lTk.setBackgroundDrawable(paintDrawable);
        this.lTg.setTextColor(o[1]);
        this.lTh.setTextColor(o[1]);
        this.lTi.setTextColor(o[1]);
        this.lTj.setTextColor(o[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.lTf.draw(new Canvas(createBitmap));
        File file = new File(cx(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            d.a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        return file.getAbsolutePath();
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        y.Ml();
        List hv = e.hv(1);
        String str5 = hv.size() > 0 ? (String) hv.get(0) : null;
        IMediaObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String gw = r.gw(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = gw;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(d.decodeFile(str2, null));
        com.tencent.mm.sdk.b.b orVar = new or();
        orVar.fHs.fzX = wXMediaMessage;
        orVar.fHs.appId = "wx7fa037cc7dfabad5";
        orVar.fHs.appName = context.getString(R.l.eee);
        orVar.fHs.toUser = str;
        orVar.fHs.fHt = 2;
        if (bi.oN(str5)) {
            orVar.fHs.fHw = null;
        } else {
            orVar.fHs.fHu = str5;
            orVar.fHs.fHv = gw;
        }
        boolean m = com.tencent.mm.sdk.b.a.xmy.m(orVar);
        if (!bi.oN(str3)) {
            com.tencent.mm.sdk.b.b otVar = new ot();
            otVar.fHD.fHE = str;
            otVar.fHD.content = str3;
            otVar.fHD.type = s.hs(str);
            otVar.fHD.flags = 0;
            com.tencent.mm.sdk.b.a.xmy.m(otVar);
        }
        return m;
    }
}
