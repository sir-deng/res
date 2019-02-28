package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.f.a;
import junit.framework.Assert;

public final class c implements b {
    private com.tencent.mm.vending.e.c zKa = new com.tencent.mm.vending.e.c();
    private b zKs = b.cAy();
    private a zKt;
    private com.tencent.mm.vending.c.b<? extends a> zKu;
    private int zKv = 0;

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T M(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        if (this.zKu == null) {
            try {
                this.zKu = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.zKt == null) {
                    this.zKt = (a) this.zKu.WM();
                }
                cAz();
                t = this.zKu;
            } catch (IllegalAccessException e) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            } catch (InstantiationException e2) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.zKu)) {
            t = this.zKu;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private synchronized <T extends a> T N(Class<? extends a> cls) {
        T t;
        if (this.zKu != null) {
            t = (a) this.zKu.WM();
        } else if (this.zKt == null) {
            try {
                this.zKt = (a) cls.newInstance();
                cAz();
                t = this.zKt;
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e2) {
            }
        } else if (cls.isInstance(this.zKt)) {
            t = this.zKt;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
        throw new InternalError("Could not create interactor instance : " + cls.toString());
    }

    private void cAz() {
        if (this.zKs != null) {
            b bVar = this.zKs;
            a aVar = this.zKt;
            if (bVar.zKo.containsKey(this)) {
                a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
                return;
            }
            bVar.zKo.put(this, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", this, Integer.valueOf(hashCode()), aVar, Looper.myLooper());
            int i = bVar.zKp.get(hashCode(), 0);
            if (i > 0 && i < 4) {
                if (i > 0) {
                    bVar.zKq.sendMessage(bVar.zKq.obtainMessage(1, aVar));
                }
                if (i >= 2) {
                    bVar.zKq.sendMessage(bVar.zKq.obtainMessage(2, aVar));
                }
                if (i >= 3) {
                    bVar.zKq.sendMessage(bVar.zKq.obtainMessage(3, aVar));
                }
                if (i >= 4) {
                    bVar.zKq.sendMessage(bVar.zKq.obtainMessage(4, aVar));
                }
            }
        }
    }

    private synchronized void A(Intent intent, Context context) {
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zKt);
        this.zKt.mContext = context;
        this.zKt.zKi = new com.tencent.mm.vending.d.a(intent);
    }

    public final synchronized a Ed() {
        if (this.zKt == null && this.zKs != null) {
            this.zKt = (a) this.zKs.zKo.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.zKt);
        return this.zKt;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return M(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
        return null;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return N(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
        return null;
    }

    public final void HF(int i) {
        this.zKv = i;
        b bVar = this.zKs;
        a aVar = (a) bVar.zKo.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    bVar.zKo.remove(this);
                    break;
                default:
                    a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    return;
            }
            bVar.zKq.sendMessage(bVar.zKq.obtainMessage(i, aVar));
        }
        bVar.zKp.put(hashCode(), i);
    }

    public final void B(Intent intent, Context context) {
        A(intent, context);
        HF(1);
    }

    public final void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.zKa.keep(aVar);
    }

    public final void onDestroy() {
        this.zKa.dead();
        HF(4);
    }
}
