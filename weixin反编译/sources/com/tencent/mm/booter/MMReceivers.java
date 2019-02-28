package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class MMReceivers {

    public static class AlarmReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
                x.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + booleanExtra);
                if (booleanExtra) {
                    aB(context);
                } else if (!b.q(context, "alarm")) {
                    aE(context);
                    x.cfX();
                }
            }
        }

        public static void aB(Context context) {
            long cga = ab.cga();
            x.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + cga);
            if (cga <= 1860000) {
                if (cga < 30000) {
                    cga = 30000;
                }
                x.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + cga);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                if (alarmManager == null) {
                    x.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                    return;
                }
                alarmManager.set(0, cga + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.CREATE_IF_NECESSARY));
            }
        }

        public static void aC(Context context) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, AlarmReceiver.class).putExtra("MMBoot_Bump", true), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }

        public static void aD(Context context) {
            x.w("MicroMsg.AlarmReceiver", "keep awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            int i = aa.VS() ? 300000 : 900000;
            alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.CREATE_IF_NECESSARY));
        }

        public static void aE(Context context) {
            x.w("MicroMsg.AlarmReceiver", "stop awaker");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }
    }

    public static class ExdeviceProcessReceiver extends BroadcastReceiver {
        private static a gzM = null;

        public static void a(a aVar) {
            gzM = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gzM != null) {
                gzM.onReceive(context, intent);
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class ConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                x.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
                if (!b.q(context, "connection")) {
                    AlarmReceiver.aE(context);
                    x.cfX();
                } else if (aa.VW() != null) {
                    NetworkInfo networkInfo = null;
                    try {
                        networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception e) {
                        x.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", e.getMessage());
                    }
                    com.tencent.mm.network.aa.a VW;
                    if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                        String str = "MicroMsg.ConnectionReceiver";
                        String str2 = "NetworkAvailable: false, state:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = networkInfo == null ? "null" : networkInfo.getState();
                        x.i(str, str2, objArr);
                        VW = aa.VW();
                        if (networkInfo != null) {
                            networkInfo.getTypeName();
                        }
                        if (networkInfo != null) {
                            networkInfo.getSubtypeName();
                        }
                        VW.aU(false);
                        return;
                    }
                    x.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                    VW = aa.VW();
                    networkInfo.getTypeName();
                    networkInfo.getSubtypeName();
                    VW.aU(true);
                }
            }
        }
    }

    public static class ToolsProcessReceiver extends BroadcastReceiver {
        private static a gzM = null;

        public static void a(a aVar) {
            gzM = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gzM != null) {
                gzM.onReceive(context, intent);
            }
        }
    }

    public interface a {
        void onReceive(Context context, Intent intent);
    }

    public static class SandBoxProcessReceiver extends BroadcastReceiver {
        private static a gzM = null;

        public static void a(a aVar) {
            gzM = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (gzM != null) {
                gzM.onReceive(context, intent);
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class BootReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (context != null) {
                new StringBuilder("system booted, pid=").append(Process.myPid());
                if (!b.q(context, "auto")) {
                    AlarmReceiver.aE(context);
                    x.cfX();
                }
            }
        }
    }
}
