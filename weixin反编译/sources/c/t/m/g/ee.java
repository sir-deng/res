package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;
import java.util.List;

public final class ee {
    private static ee a = null;

    public static ee a() {
        if (a == null) {
            a = new ee();
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        int i;
        Object obj;
        Object obj2;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        if (context == null) {
            return -1;
        }
        int i4;
        LocationManager locationManager;
        boolean isProviderEnabled;
        List allProviders;
        boolean b = b(context);
        try {
            Object i5;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                try {
                    if (VERSION.SDK_INT < 18 || !wifiManager.isScanAlwaysAvailable()) {
                        i5 = 1;
                    } else {
                        obj = 1;
                        obj2 = 1;
                        i2 = i4;
                        locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager == null) {
                            try {
                                i4 = Secure.getInt(context.getContentResolver(), "location_mode");
                            } catch (Throwable th) {
                                i4 = 0;
                            }
                            try {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                                allProviders = locationManager.getAllProviders();
                                if (allProviders != null) {
                                    z = isProviderEnabled;
                                    i3 = i4;
                                    z2 = false;
                                } else {
                                    z = isProviderEnabled;
                                    i3 = i4;
                                    z2 = allProviders.contains("gps");
                                }
                            } catch (Exception e) {
                                i5 = i4;
                                z2 = false;
                                i3 = i5;
                                z = false;
                                if (b) {
                                    i5 = 1;
                                } else {
                                    i5 = 0;
                                }
                                if (i2 == 0) {
                                    i5 += 2;
                                }
                                if (!z) {
                                    i5 += 4;
                                }
                                if (obj == null) {
                                    i5 += 8;
                                }
                                if (!z2) {
                                    i5 += 16;
                                }
                                if (obj2 == null) {
                                    i5 += 32;
                                }
                                switch (i3) {
                                    case 0:
                                        return i5 + 64;
                                    case 1:
                                        return i5 + FileUtils.S_IWUSR;
                                    case 2:
                                        return i5 + 256;
                                    case 3:
                                        return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                                    default:
                                        return i5;
                                }
                            }
                        }
                        z2 = false;
                        i3 = 0;
                        z = false;
                        if (b) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                        if (i2 == 0) {
                            i5 += 2;
                        }
                        if (z) {
                            i5 += 4;
                        }
                        if (obj == null) {
                            i5 += 8;
                        }
                        if (z2) {
                            i5 += 16;
                        }
                        if (obj2 == null) {
                            i5 += 32;
                        }
                        switch (i3) {
                            case 0:
                                return i5 + 64;
                            case 1:
                                return i5 + FileUtils.S_IWUSR;
                            case 2:
                                return i5 + 256;
                            case 3:
                                return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                            default:
                                return i5;
                        }
                    }
                } catch (Throwable th2) {
                    obj = null;
                    obj2 = null;
                    i2 = i4;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager == null) {
                        i4 = Secure.getInt(context.getContentResolver(), "location_mode");
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        allProviders = locationManager.getAllProviders();
                        if (allProviders != null) {
                            z = isProviderEnabled;
                            i3 = i4;
                            z2 = false;
                        } else {
                            z = isProviderEnabled;
                            i3 = i4;
                            z2 = allProviders.contains("gps");
                        }
                    } else {
                        z2 = false;
                        i3 = 0;
                        z = false;
                    }
                    if (b) {
                        i5 = 0;
                    } else {
                        i5 = 1;
                    }
                    if (i2 == 0) {
                        i5 += 2;
                    }
                    if (z) {
                        i5 += 4;
                    }
                    if (obj == null) {
                        i5 += 8;
                    }
                    if (z2) {
                        i5 += 16;
                    }
                    if (obj2 == null) {
                        i5 += 32;
                    }
                    switch (i3) {
                        case 0:
                            return i5 + 64;
                        case 1:
                            return i5 + FileUtils.S_IWUSR;
                        case 2:
                            return i5 + 256;
                        case 3:
                            return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                        default:
                            return i5;
                    }
                }
            }
            i5 = null;
            i4 = 0;
            obj = i5;
            obj2 = null;
            i2 = i4;
        } catch (Throwable th3) {
            i4 = 0;
            obj = null;
            obj2 = null;
            i2 = i4;
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z2 = false;
                i3 = 0;
                z = false;
            } else {
                i4 = Secure.getInt(context.getContentResolver(), "location_mode");
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = isProviderEnabled;
                    i3 = i4;
                    z2 = allProviders.contains("gps");
                } else {
                    z = isProviderEnabled;
                    i3 = i4;
                    z2 = false;
                }
            }
            if (b) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            if (i2 == 0) {
                i5 += 2;
            }
            if (z) {
                i5 += 4;
            }
            if (obj == null) {
                i5 += 8;
            }
            if (z2) {
                i5 += 16;
            }
            if (obj2 == null) {
                i5 += 32;
            }
            switch (i3) {
                case 0:
                    return i5 + 64;
                case 1:
                    return i5 + FileUtils.S_IWUSR;
                case 2:
                    return i5 + 256;
                case 3:
                    return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                default:
                    return i5;
            }
        }
        try {
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z2 = false;
                i3 = 0;
                z = false;
            } else {
                i4 = Secure.getInt(context.getContentResolver(), "location_mode");
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = isProviderEnabled;
                    i3 = i4;
                    z2 = allProviders.contains("gps");
                } else {
                    z = isProviderEnabled;
                    i3 = i4;
                    z2 = false;
                }
            }
        } catch (Exception e2) {
            i5 = 0;
            z2 = false;
            i3 = i5;
            z = false;
            if (b) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i2 == 0) {
                i5 += 2;
            }
            if (z) {
                i5 += 4;
            }
            if (obj == null) {
                i5 += 8;
            }
            if (z2) {
                i5 += 16;
            }
            if (obj2 == null) {
                i5 += 32;
            }
            switch (i3) {
                case 0:
                    return i5 + 64;
                case 1:
                    return i5 + FileUtils.S_IWUSR;
                case 2:
                    return i5 + 256;
                case 3:
                    return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                default:
                    return i5;
            }
        }
        if (b) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        if (i2 == 0) {
            i5 += 2;
        }
        if (z) {
            i5 += 4;
        }
        if (obj == null) {
            i5 += 8;
        }
        if (z2) {
            i5 += 16;
        }
        if (obj2 == null) {
            i5 += 32;
        }
        switch (i3) {
            case 0:
                return i5 + 64;
            case 1:
                return i5 + FileUtils.S_IWUSR;
            case 2:
                return i5 + 256;
            case 3:
                return i5 + WXMediaMessage.TITLE_LENGTH_LIMIT;
            default:
                return i5;
        }
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
