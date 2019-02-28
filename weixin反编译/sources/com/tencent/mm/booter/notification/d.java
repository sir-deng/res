package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.j.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static boolean gBA = true;
    private static String gBB = "samsung";
    public static boolean gBC = true;
    public static boolean gBD = false;
    private static int gBE = -1;
    private static boolean gBF = true;
    private static Uri gBG = Uri.parse("content://com.android.badge/badge");
    private static boolean gBv = true;
    private static boolean gBw = true;
    private static boolean gBx = false;
    private static int gBy = -1;
    private static int gBz = -1;

    public static void fp(int i) {
        boolean z;
        if (ad.getContext() != null && xn()) {
            Context context = ad.getContext();
            int Ab = i == -1 ? f.Ab() : i;
            if (!(context == null || !xn() || gBE == Ab)) {
                gBE = Ab;
                Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                intent.putExtra("badge_count", Ab);
                intent.putExtra("badge_count_package_name", ad.getPackageName());
                intent.putExtra("badge_count_class_name", LauncherUI.class.getName());
                x.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", Integer.valueOf(Ab), Build.BRAND);
                context.sendBroadcast(intent);
            }
        }
        if (gBA) {
            if (VERSION.SDK_INT < 11) {
                gBA = false;
            } else if (gBz != i) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("package", ad.getPackageName());
                    bundle.putString("class", LauncherUI.class.getName());
                    bundle.putInt("badgenumber", i);
                    gBA = ad.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle) != null;
                    x.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", Integer.valueOf(i), Boolean.valueOf(gBA));
                } catch (Exception e) {
                    x.i("MicroMsg.BusinessNotification", "no huawei badge");
                    x.e("MicroMsg.BusinessNotification", "alvin: no badge" + e.toString());
                    gBA = false;
                }
            }
        }
        if (gBx) {
            z = gBw;
        } else {
            gBx = true;
            if (Build.BRAND.equals("vivo")) {
                gBw = true;
                z = true;
            } else {
                gBw = false;
                z = false;
            }
        }
        if (z && gBy != i) {
            try {
                Intent intent2 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                intent2.putExtra(DownloadInfoColumns.PACKAGENAME, ad.getPackageName());
                intent2.putExtra("className", LauncherUI.class.getName());
                intent2.putExtra("notificationNum", i);
                ad.getContext().sendBroadcast(intent2);
                x.i("MicroMsg.BusinessNotification", "vivo badge: %d", Integer.valueOf(i));
            } catch (Throwable e2) {
                gBw = false;
                x.printErrStackTrace("MicroMsg.BusinessNotification", e2, "", new Object[0]);
            }
        }
        x(null, i);
    }

    public static void w(String str, int i) {
        if (t.oN(str)) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
            return;
        }
        String wk = b.wk(str);
        if (!t.oN(wk)) {
            x(wk, i);
        }
    }

    public static void aY(boolean z) {
        if (gBF) {
            Context context = ad.getContext();
            if (context != null) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    try {
                        x.i("MicroMsg.BusinessNotification", "sync all user badge");
                        Bundle call = contentResolver.call(gBG, "getShortcutList", null, null);
                        if (call == null) {
                            x.i("MicroMsg.BusinessNotification", "getShortcutList return null");
                            return;
                        }
                        String string = call.getString("shortcut_list");
                        if (string != null) {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                string = ((JSONObject) jSONArray.get(i)).getString("app_shortcut_custom_id");
                                if (!(string == null || string.equalsIgnoreCase("null"))) {
                                    String wj = b.wj(string);
                                    w(wj, z ? 0 : f.eV(wj));
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BusinessNotification", e, "sync all user badge: no support getShortcutList", new Object[0]);
                    }
                }
            }
        }
    }

    public static int a(Notification notification, g gVar) {
        if (notification == null || !gBv) {
            return 0;
        }
        int i;
        if (gVar == null) {
            i = 0;
        } else {
            int i2 = gVar.gCu;
            NotificationQueue notificationQueue = com.tencent.mm.booter.notification.queue.b.xp().gBV;
            if (notificationQueue.gBU == null) {
                notificationQueue.restore();
            }
            Iterator it = notificationQueue.gBU.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = ((NotificationItem) it.next()).gBO + i3;
            }
            i = i2 - i3;
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, Integer.valueOf(i));
            notification.getClass().getField("extraNotification").set(notification, newInstance);
            x.i("MicroMsg.BusinessNotification", "miuiNotification: %d", Integer.valueOf(i));
            return i;
        } catch (NoSuchFieldException e) {
            gBv = false;
            return i;
        } catch (IllegalArgumentException e2) {
            gBv = false;
            return i;
        } catch (IllegalAccessException e3) {
            gBv = false;
            return i;
        } catch (ClassNotFoundException e4) {
            gBv = false;
            return i;
        } catch (InstantiationException e5) {
            gBv = false;
            return i;
        } catch (Exception e6) {
            gBv = false;
            return i;
        }
    }

    private static boolean xn() {
        if (gBD) {
            return gBC;
        }
        gBD = true;
        if (Build.BRAND.equals(gBB)) {
            gBC = true;
            return true;
        }
        gBC = false;
        return false;
    }

    private static void x(String str, int i) {
        if (ad.getContext() == null) {
            x.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
            return;
        }
        Context context = ad.getContext();
        if (i < 0) {
            i = f.Ab();
        }
        a(context, str, i);
    }

    private static boolean a(Context context, String str, int i) {
        boolean z = true;
        if (!gBF) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                bundle.putStringArrayList("app_shortcut_custom_id", arrayList);
            } else {
                bundle.putStringArrayList("app_shortcut_custom_id", null);
            }
            bundle.putInt("app_badge_count", i);
            bundle.putString("app_shortcut_class_name", ad.cge() + ".ui.LauncherUI");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || contentResolver.call(gBG, "setAppBadgeCount", null, bundle) == null) {
                z = false;
            }
            x.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", str, Integer.valueOf(i), Boolean.valueOf(z));
            return z;
        } catch (Exception e) {
            gBF = false;
            x.i("MicroMsg.BusinessNotification", "no support normal badge");
            x.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
            return false;
        }
    }
}
