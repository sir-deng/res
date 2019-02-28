package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.l;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.g.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import junit.framework.Assert;

public final class p implements e {
    private Context context;
    private ProgressDialog laU;
    private String path;
    private Runnable vkj = null;
    private Runnable vkk = null;

    public p(Context context, String str) {
        this.context = context;
        this.path = str;
        this.laU = null;
        as.CN().a(157, (e) this);
    }

    public final boolean c(int i, Runnable runnable) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.vkj = runnable;
        Context context = this.context;
        this.context.getString(R.l.dGZ);
        this.laU = h.a(context, this.context.getString(R.l.eOc), true, null);
        as.CN().a(new l(i, this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.vkj = runnable;
        this.vkk = runnable2;
        as.CN().a(new l(1, this.path), 0);
        x.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.valueOf(false));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        as.CN().b(157, (e) this);
        if (this.laU != null && this.laU.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.laU.dismiss();
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, R.l.eOb, 0).show();
            if (this.vkj != null) {
                new ag(Looper.getMainLooper()).post(this.vkj);
                return;
            }
            return;
        }
        if (this.vkk != null) {
            new ag(Looper.getMainLooper()).post(this.vkk);
        }
        if (str != null && str.length() > 0) {
            a eC = a.eC(str);
            if (eC != null) {
                eC.a(this.context, null, null);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, R.l.dVY, 0).show();
        } else {
            Toast.makeText(this.context, R.l.eOa, 0).show();
        }
    }
}
