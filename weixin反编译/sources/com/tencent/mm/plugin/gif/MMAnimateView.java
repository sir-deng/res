package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.a.e;
import com.tencent.mm.bu.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.hy;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView extends AppCompatImageView {
    public String lzu;
    private float mDensity;
    public int nEj = 0;
    private int nEk;
    private boolean nEl;

    public MMAnimateView(Context context) {
        this(context, null);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMAnimateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nEj = d.lOQ;
        this.nEk = d.bEm;
        this.nEl = true;
        this.mDensity = 0.0f;
        if (com.tencent.mm.compatible.util.d.fN(26)) {
            setLayerType(1, null);
        }
    }

    public void setImageResource(int i) {
        a(getResources(), i, true);
    }

    public void setBackgroundResource(int i) {
        a(getResources(), i, false);
    }

    public final void CV(String str) {
        cY(str, null);
    }

    public final void cX(String str, String str2) {
        cY(str, str2);
    }

    public final void g(byte[] bArr, String str) {
        if (bArr == null) {
            try {
                x.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", Boolean.valueOf(true), str);
                return;
            } catch (MMGIFException e) {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap bn = com.tencent.mm.sdk.platformtools.d.bn(bArr);
                    if (bn != null) {
                        bn.setDensity(320);
                        setImageBitmap(bn);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                    init();
                    return;
                }
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e.toString());
            } catch (IOException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
            }
        } else {
            Drawable fVar;
            if (bi.oN(str)) {
                fVar = p.bs(bArr) ? new f(bArr) : new c(bArr);
                fVar.start();
            } else {
                this.lzu = str;
                fVar = b.aSR().o(this.lzu, bArr);
            }
            setImageDrawable(fVar);
            return;
        }
        init();
    }

    public final void a(InputStream inputStream, String str) {
        Drawable drawable = null;
        try {
            if (bi.oN(str)) {
                drawable = new c(inputStream);
            } else {
                this.lzu = str;
                b aSR = b.aSR();
                String str2 = this.lzu;
                if (inputStream != null) {
                    x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", str2);
                    if (aSR.nEh.get(str2) != null) {
                        drawable = (a) ((WeakReference) aSR.nEh.get(str2)).get();
                    }
                    if (drawable == null) {
                        drawable = new c(inputStream);
                        aSR.nEh.put(str2, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
            return;
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(320);
                    setImageBitmap(decodeStream);
                    return;
                }
                x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                return;
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e.toString());
        } catch (IOException e2) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
        }
        init();
    }

    public final float aSS() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ad.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    private void a(Resources resources, int i, boolean z) {
        Drawable drawable = null;
        try {
            if (bi.oN(null)) {
                drawable = new c(resources, i);
            } else {
                this.lzu = null;
                b aSR = b.aSR();
                if (aSR.nEh.get(null) != null) {
                    drawable = (a) ((WeakReference) aSR.nEh.get(null)).get();
                }
                if (drawable == null) {
                    drawable = new c(resources, i);
                    aSR.nEh.put(null, new WeakReference(drawable));
                }
            }
            if (z) {
                setImageDrawable(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        } catch (IOException e) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public final void a(String str, h hVar) {
        try {
            Drawable cVar = new c(str);
            setImageDrawable(cVar);
            cVar.nEE = Integer.MAX_VALUE;
            cVar.nEG = hVar;
            return;
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(new FileInputStream(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(320);
                        setImageBitmap(decodeStream);
                        return;
                    }
                    x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (FileNotFoundException e2) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
        } catch (IOException e3) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
        }
        init();
    }

    public final void cY(String str, String str2) {
        try {
            Drawable fVar;
            if (p.Vx(str)) {
                fVar = new f(e.d(str, 0, e.bN(str)));
                fVar.start();
                setImageDrawable(fVar);
                return;
            }
            if (bi.oN(str2)) {
                fVar = new c(str);
            } else {
                this.lzu = str2;
                fVar = b.aSR().cW(this.lzu, str);
            }
            setImageDrawable(fVar);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    try {
                        Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                        if (decodeFile != null) {
                            decodeFile.setDensity(320);
                            setImageBitmap(decodeFile);
                            return;
                        }
                        x.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                        init();
                        b.deleteFile(str);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", e2, "setMMGIFFilePath failed, oom happened. show default. path %s", str);
                        init();
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", bi.i(e22));
            }
        } catch (Throwable e222) {
            x.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", bi.i(e222));
            b.deleteFile(str);
            init();
        } catch (NullPointerException e3) {
            init();
        }
    }

    public final void init() {
        this.nEl = f.zl();
        if (this.nEl) {
            if (this.nEj > 0) {
                super.setImageResource(this.nEj);
            }
        } else if (this.nEk > 0) {
            super.setImageResource(this.nEk);
        }
    }

    public final void resume() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            c cVar = (c) getDrawable();
            if (!cVar.nEm) {
                cVar.mIsRunning = true;
                cVar.e(cVar.nEI, 0);
            }
        }
    }

    public static void a(MMGIFException mMGIFException) {
        com.tencent.mm.sdk.b.b hyVar = new hy();
        hyVar.fzl.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.b.a.xmy.m(hyVar);
    }

    public final void recycle() {
        if (getDrawable() != null && (getDrawable() instanceof c)) {
            ((c) getDrawable()).recycle();
        }
    }
}
