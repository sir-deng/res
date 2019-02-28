package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import junit.framework.Assert;

public abstract class l<Params, Progress, Result> {
    private boolean fBn = false;
    ag handler = new ag(Looper.getMainLooper());

    public abstract ag bvy();

    public abstract Result bvz();

    public final boolean m(final Params... paramsArr) {
        if (this.fBn) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fBn = true;
        n(paramsArr);
        ag bvy = bvy();
        if (bvy == null) {
            return false;
        }
        bvy.post(new Runnable() {
            public final void run() {
                final Object bvz = l.this.bvz();
                l.this.handler.post(new Runnable() {
                    public final void run() {
                        l.this.onPostExecute(bvz);
                    }
                });
            }
        });
        return true;
    }

    public void n(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
