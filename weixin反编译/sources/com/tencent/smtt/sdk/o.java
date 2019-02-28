package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkUpdater;

public final class o {
    private static o Agw;
    Map<String, Object> Agx = new HashMap();
    public SharedPreferences Agy;
    private Context tI;

    private o(Context context) {
        this.Agy = context.getSharedPreferences("tbs_download_config", 4);
        this.tI = context.getApplicationContext();
        if (this.tI == null) {
            this.tI = context;
        }
    }

    public static synchronized o cFb() {
        o oVar;
        synchronized (o.class) {
            oVar = Agw;
        }
        return oVar;
    }

    public static synchronized o gI(Context context) {
        o oVar;
        synchronized (o.class) {
            if (Agw == null) {
                Agw = new o(context);
            }
            oVar = Agw;
        }
        return oVar;
    }

    public final synchronized void Im(int i) {
        try {
            Editor edit = this.Agy.edit();
            edit.putInt("tbs_download_interrupt_code", i);
            edit.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
            edit.commit();
        } catch (Exception e) {
        }
    }

    public final synchronized void In(int i) {
        Editor edit = this.Agy.edit();
        edit.putInt("tbs_install_interrupt_code", i);
        edit.commit();
    }

    public final synchronized long cFc() {
        int i;
        i = this.Agy.getInt("tbs_download_maxflow", 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
    }

    public final synchronized long cFd() {
        return p.cFp() >= 0 ? p.cFp() : this.Agy.getLong("retry_interval", 86400);
    }

    public final synchronized long cFe() {
        long j;
        int i = 0;
        synchronized (this) {
            int i2 = this.Agy.getInt("tbs_download_min_free_space", 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
        }
        return j;
    }

    public final synchronized int cFf() {
        int i;
        i = this.Agy.getInt("tbs_download_success_max_retrytimes", 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public final synchronized int cFg() {
        int i;
        i = this.Agy.getInt("tbs_download_failed_max_retrytimes", 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    public final synchronized boolean cFh() {
        boolean z = true;
        synchronized (this) {
            try {
                z = this.Agy.getBoolean("tbs_core_load_rename_file_lock_enable", true);
            } catch (Exception e) {
            }
        }
        return z;
    }

    public final synchronized int cFi() {
        int i;
        if (this.Agy.contains("tbs_download_interrupt_code")) {
            i = this.Agy.getInt("tbs_download_interrupt_code", -99);
            if (i == -119 || i == -121) {
                i = this.Agy.getInt("tbs_download_interrupt_code_reason", -119);
            }
            if (System.currentTimeMillis() - this.Agy.getLong("tbs_download_interrupt_time", 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.tI.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.Agy.contains("tbs_needdownload") ? -96 : XWalkUpdater.ERROR_SET_VERNUM;
            } catch (Throwable th) {
                i = -95;
            }
        }
        i = (this.tI == null || !"com.tencent.mobileqq".equals(this.tI.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) ? (i * 1000) + this.Agy.getInt("tbs_install_interrupt_code", -1) : -320;
        return i;
    }

    public final synchronized void commit() {
        Editor edit = this.Agy.edit();
        for (String str : this.Agx.keySet()) {
            Object obj = this.Agx.get(str);
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else {
                try {
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } catch (Exception e) {
                }
            }
        }
        edit.commit();
        this.Agx.clear();
    }

    public final synchronized void oa(boolean z) {
        try {
            Editor edit = this.Agy.edit();
            edit.putBoolean("tbs_core_load_rename_file_lock_enable", z);
            edit.commit();
        } catch (Exception e) {
        }
    }
}
