package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.ag;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean fBn = false;
    ag handler = ae.aOA();

    public abstract ag bvy();

    public abstract Result bvz();

    public final boolean m(final Params... paramsArr) {
        if (this.fBn) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fBn = true;
        ag bvy = bvy();
        if (bvy == null) {
            return false;
        }
        bvy.post(new Runnable() {
            public final void run() {
                final Object bvz = h.this.bvz();
                h.this.handler.post(new Runnable() {
                    public final void run() {
                        h.this.onPostExecute(bvz);
                    }
                });
            }
        });
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
