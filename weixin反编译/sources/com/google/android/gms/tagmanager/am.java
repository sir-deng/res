package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.api.Status;

final class am implements b {
    private a bcP;
    private a bcQ;
    private Status bcR;
    private b bcS;
    a bcT;
    boolean bcU;
    private d bcV;

    public interface a {
        String ri();
    }

    private class b extends Handler {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    return;
                default:
                    m.qD();
                    return;
            }
        }
    }

    public final synchronized void bg(String str) {
        if (!this.bcU) {
            this.bcP.qx().bg(str);
        }
    }

    public final Status oh() {
        return this.bcR;
    }

    public final synchronized void refresh() {
        if (this.bcU) {
            m.qD();
        }
    }

    public final synchronized void release() {
        if (this.bcU) {
            m.qD();
        } else {
            this.bcU = true;
            this.bcV.bbB.remove(this);
            this.bcP.bbl = null;
            this.bcP = null;
            this.bcQ = null;
            this.bcT = null;
            this.bcS = null;
        }
    }

    final String rg() {
        if (!this.bcU) {
            return this.bcP.bbk;
        }
        m.qD();
        return "";
    }

    final void rh() {
        if (this.bcU) {
            m.qD();
        }
    }
}
