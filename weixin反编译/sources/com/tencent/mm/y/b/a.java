package com.tencent.mm.y.b;

import android.content.SharedPreferences;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public abstract class a implements e {
    protected com.tencent.mm.y.b.e.a hjX;
    protected String hjY = Ir();
    protected String[] hjZ = Iq();

    public abstract String Ir();

    public final boolean in(String str) {
        as.Hm();
        SharedPreferences fN = c.fN("banner");
        if (fN == null || !fN.getBoolean(this.hjY + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        as.Hm();
        SharedPreferences fN = c.fN("banner");
        if (fN != null) {
            fN.edit().putBoolean(this.hjY + str, z).commit();
            if (!(this.hjZ == null || strArr == null || this.hjZ.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.hjZ) {
                    if (str2 != null) {
                        fN.edit().putString(this.hjY + str2 + str, strArr[i] != null ? strArr[i] : "").commit();
                    }
                    i++;
                }
            }
            if (this.hjX != null) {
                this.hjX.ID();
            }
        }
    }

    public final String W(String str, String str2) {
        as.Hm();
        SharedPreferences fN = c.fN("banner");
        if (fN == null) {
            return null;
        }
        return fN.getString(this.hjY + str2 + str, null);
    }

    public final void io(String str) {
        as.Hm();
        SharedPreferences fN = c.fN("banner");
        if (fN != null) {
            fN.edit().remove(this.hjY + str).commit();
            if (this.hjZ != null) {
                for (String str2 : this.hjZ) {
                    if (str2 != null) {
                        fN.edit().remove(this.hjY + str2 + str).commit();
                    }
                }
            }
            if (this.hjX != null) {
                this.hjX.IE();
            }
        }
    }

    public final void a(com.tencent.mm.y.b.e.a aVar) {
        this.hjX = aVar;
    }

    protected String[] Iq() {
        return null;
    }
}
