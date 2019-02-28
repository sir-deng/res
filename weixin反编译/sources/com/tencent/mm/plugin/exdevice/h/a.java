package com.tencent.mm.plugin.exdevice.h;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static void b(SharedPreferences sharedPreferences) {
        int i = 0;
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
        if (VERSION.SDK_INT >= 11) {
            if (sharedPreferences == null) {
                x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
                return;
            }
            String[] strArr = new String[]{"conneted_device", "shut_down_device"};
            while (i < 2) {
                String str = strArr[i];
                try {
                    if (sharedPreferences.getStringSet(str, null) != null) {
                        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", str);
                        if (!sharedPreferences.edit().remove(str).commit()) {
                            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
                        }
                    }
                } catch (Exception e) {
                }
                i++;
            }
        }
    }

    public static boolean y(String str, long j) {
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", str, Long.valueOf(j));
        if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        if (b.cA(String.valueOf(j), sharedPreferences.getString(str, new String()))) {
            return true;
        }
        return false;
    }

    public static boolean z(String str, long j) {
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        String valueOf = String.valueOf(j);
        String string = sharedPreferences.getString(str, new String());
        x.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", valueOf, string);
        if (bi.oN(valueOf) || string == null) {
            x.e("MicroMsg.exdevice.Util", "Error parameters!!!");
            valueOf = null;
        } else {
            valueOf = ((new String() + string) + valueOf) + "|";
            x.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", valueOf);
        }
        if (valueOf == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
            return false;
        } else if (sharedPreferences.edit().putString(str, valueOf).commit()) {
            x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", valueOf);
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
            return false;
        }
    }

    public static boolean A(String str, long j) {
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return false;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return false;
        }
        b(sharedPreferences);
        String cB = b.cB(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (cB == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
            return false;
        }
        boolean commit;
        if (cB.length() == 0) {
            commit = sharedPreferences.edit().remove(str).commit();
        } else {
            commit = sharedPreferences.edit().putString(str, cB).commit();
        }
        if (commit) {
            x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", cB);
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
        return false;
    }

    public static long[] zK(String str) {
        Exception e;
        int i = 1;
        Object[] objArr = new Object[i];
        objArr[0] = str;
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", objArr);
        if (bi.oN(str)) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            return null;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            return null;
        }
        b(sharedPreferences);
        try {
            String[] split = sharedPreferences.getString(str, new String()).split("\\|");
            if (split == null || split.length == 0) {
                x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
                return null;
            }
            long[] jArr = new long[split.length];
            int i2 = 0;
            for (String str2 : split) {
                try {
                    x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", str2);
                    if (str2.length() != 0) {
                        int i3 = i2 + 1;
                        try {
                            jArr[i2] = bi.getLong(str2, 0);
                            i2 = i3;
                        } catch (Exception e2) {
                            Exception exception = e2;
                            i2 = i3;
                            e = exception;
                            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + e.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (i2 == 0) {
                return null;
            }
            return jArr;
        } catch (Exception e22) {
            Object[] objArr2 = new Object[i];
            objArr2[0] = e22.getMessage();
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", objArr2);
            return null;
        }
    }
}
