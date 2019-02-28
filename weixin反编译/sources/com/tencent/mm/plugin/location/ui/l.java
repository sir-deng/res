package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class l {
    public i iUF = null;
    public Context mContext;
    public Resources mResources;
    public a oay;

    public interface a {
        void aWO();

        void aWP();

        void aWQ();

        void gs(boolean z);

        void si(int i);
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$8 */
    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ int iIG;

        public AnonymousClass8(int i) {
            this.iIG = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (l.this.oay != null) {
                l.this.oay.si(this.iIG);
            }
        }
    }

    public l(Context context, a aVar) {
        this.mContext = context;
        this.oay = aVar;
        this.mResources = this.mContext.getResources();
    }

    public final void aWN() {
        if (!sg(67590)) {
            h.a(this.mContext, this.mResources.getString(R.l.etB), "", false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (l.this.oay != null) {
                        l.this.oay.aWO();
                    }
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            sh(67590);
        } else if (this.oay != null) {
            this.oay.aWO();
        }
    }

    public static boolean sg(int i) {
        as.Hm();
        Object obj = c.Db().get(i, null);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static void sh(int i) {
        as.Hm();
        c.Db().set(i, Boolean.valueOf(true));
    }
}
