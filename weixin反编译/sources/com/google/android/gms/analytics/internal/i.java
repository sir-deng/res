package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;

public final class i extends o {
    final a aFA = new a(this, "monitoring", ((Long) aj.aIh.get()).longValue(), (byte) 0);
    SharedPreferences aFx;
    private long aFy;
    private long aFz = -1;

    public final class a {
        final long aFB;
        private final String mName;

        private a(String str, long j) {
            w.aM(str);
            w.au(j > 0);
            this.mName = str;
            this.aFB = j;
        }

        /* synthetic */ a(i iVar, String str, long j, byte b) {
            this(str, j);
        }

        private String mA() {
            return this.mName + ":start";
        }

        String mB() {
            return this.mName + ":count";
        }

        String mC() {
            return this.mName + ":value";
        }

        void my() {
            long currentTimeMillis = i.this.aFo.aFD.currentTimeMillis();
            Editor edit = i.this.aFx.edit();
            edit.remove(mB());
            edit.remove(mC());
            edit.putLong(mA(), currentTimeMillis);
            edit.commit();
        }

        long mz() {
            return i.this.aFx.getLong(mA(), 0);
        }
    }

    protected i(q qVar) {
        super(qVar);
    }

    public final void aq(String str) {
        q.mZ();
        mR();
        Editor edit = this.aFx.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            ax("Failed to commit campaign data");
        }
    }

    protected final void mg() {
        this.aFx = this.aFo.mContext.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long mt() {
        q.mZ();
        mR();
        if (this.aFy == 0) {
            long j = this.aFx.getLong("first_run", 0);
            if (j != 0) {
                this.aFy = j;
            } else {
                j = this.aFo.aFD.currentTimeMillis();
                Editor edit = this.aFx.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    ax("Failed to commit first run time");
                }
                this.aFy = j;
            }
        }
        return this.aFy;
    }

    public final j mu() {
        return new j(this.aFo.aFD, mt());
    }

    public final long mv() {
        q.mZ();
        mR();
        if (this.aFz == -1) {
            this.aFz = this.aFx.getLong("last_dispatch", 0);
        }
        return this.aFz;
    }

    public final void mw() {
        q.mZ();
        mR();
        long currentTimeMillis = this.aFo.aFD.currentTimeMillis();
        Editor edit = this.aFx.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.aFz = currentTimeMillis;
    }

    public final String mx() {
        q.mZ();
        mR();
        CharSequence string = this.aFx.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }
}
