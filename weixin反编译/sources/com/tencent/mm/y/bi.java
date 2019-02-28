package com.tencent.mm.y;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class bi {
    private static bi hja;
    private final SharedPreferences hbz = ad.getContext().getSharedPreferences(ad.cgf(), 0);

    public static class a {
        private int hjb;
        private int hjc;
        private int hjd;
        private int id;

        public final a hb(int i) {
            this.hjb = i;
            return this;
        }

        public final a hc(int i) {
            this.hjc = i;
            return this;
        }

        public final a hd(int i) {
            this.hjd = i;
            return this;
        }

        public final boolean commit() {
            Editor edit = bi.HU().hbz.edit();
            if (this.id > 0) {
                edit.putInt("MicroMsg.RegStyleStoragestyle_id", this.id);
            } else {
                edit.remove("MicroMsg.RegStyleStoragestyle_id");
            }
            if (this.hjb > 0) {
                edit.putInt("MicroMsg.RegStyleStoragenew_flow", this.hjb);
            } else {
                edit.putInt("MicroMsg.RegStyleStoragenew_flow", 0);
            }
            if (this.hjc > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_password", this.hjc);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_password");
            }
            if (this.hjd > 0) {
                edit.putInt("MicroMsg.RegStyleStoragehas_AVATAR", this.hjd);
            } else {
                edit.remove("MicroMsg.RegStyleStoragehas_AVATAR");
            }
            x.i("MicroMsg.RegStyleStorage", "id: " + this.id + " newFlow: " + this.hjb + "hasPassword:" + this.hjc + "hasAvatar:" + this.hjd);
            return edit.commit();
        }
    }

    private bi() {
    }

    public static bi HU() {
        synchronized (bi.class) {
            if (hja == null) {
                hja = new bi();
            }
        }
        return hja;
    }

    public final int HV() {
        return this.hbz.getInt("MicroMsg.RegStyleStoragenew_flow", 1);
    }
}
