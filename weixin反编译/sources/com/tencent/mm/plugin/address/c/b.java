package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements e {
    private a ioA = null;
    private Set<Integer> ioB = new HashSet();
    HashSet<k> iol = new HashSet();
    HashSet<k> iom = new HashSet();
    Dialog ion = null;
    private Context mContext;

    public b(Context context, a aVar) {
        this.mContext = context;
        this.ioA = aVar;
    }

    public final void g(k kVar) {
        x.d("MicroMsg.WalletNetSceneMgr", new StringBuilder("isShowProgress true").toString());
        this.iom.add(kVar);
        if (this.ion == null || !(this.ion == null || this.ion.isShowing())) {
            if (this.ion != null) {
                this.ion.dismiss();
            }
            this.ion = h.a(this.mContext, "", true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (b.this.ion != null && b.this.iol.isEmpty()) {
                        b.this.ion.dismiss();
                        Iterator it = b.this.iom.iterator();
                        while (it.hasNext()) {
                            as.CN().c((k) it.next());
                        }
                        b.this.iom.clear();
                    }
                }
            });
        }
        as.CN().a(kVar, 0);
    }

    public final void jl(int i) {
        this.ioB.add(Integer.valueOf(i));
        as.CN().a(i, (e) this);
    }

    public final void jm(int i) {
        as.CN().b(i, (e) this);
        this.ioB.remove(Integer.valueOf(i));
        if (this.ioB.isEmpty()) {
            if (this.ion != null) {
                this.ion.dismiss();
                this.ion = null;
            }
            Iterator it = this.iol.iterator();
            while (it.hasNext()) {
                as.CN().c((k) it.next());
            }
            it = this.iom.iterator();
            while (it.hasNext()) {
                as.CN().c((k) it.next());
            }
            this.iol.clear();
            this.iom.clear();
            this.ioA = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        if (this.iom.contains(kVar)) {
            this.iom.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.iol.contains(kVar)) {
            this.iol.remove(kVar);
            x.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.iom.isEmpty() && this.iol.isEmpty() && this.ion != null) {
            this.ion.dismiss();
            this.ion = null;
        }
        if (obj != null && this.ioA != null) {
            this.ioA.e(i, i2, str, kVar);
        }
    }
}
