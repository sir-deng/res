package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.f.a.ik;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Random;

public final class AddrBookObserver extends ContentObserver {
    private static ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            Context context = (Context) message.obj;
            if (AddrBookObserver.hwF == null) {
                AddrBookObserver.hwF = new Intent();
                AddrBookObserver.hwF.setClass(context, AddrBookService.class);
            }
            AddrBookObserver.hwF.putExtra(AddrBookService.hwG, new Random(System.currentTimeMillis()).nextFloat());
            try {
                x.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", Float.valueOf(new Random(System.currentTimeMillis()).nextFloat()));
                context.startService(AddrBookObserver.hwF);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
            }
        }
    };
    private static boolean hwE = false;
    private static Intent hwF;
    private final Context context;

    public static class AddrBookService extends Service {
        public static boolean aBT = false;
        public static boolean hwE = false;
        public static String hwG = "key_sync_session";
        private b hwH = new b() {
            public final void bO(boolean z) {
                if (z) {
                    System.currentTimeMillis();
                    as.CN().a(new aa(m.Oa(), m.NZ()), 0);
                    AddrBookService.this.stopSelf();
                    AddrBookService.hwE = false;
                    return;
                }
                x.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
                AddrBookService.this.stopSelf();
                AddrBookService.hwE = false;
            }
        };

        public int onStartCommand(Intent intent, int i, int i2) {
            super.onStartCommand(intent, i, i2);
            String str = "MicroMsg.AddrBookObserver";
            String str2 = "service start intent:%b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(intent == null);
            x.i(str, str2, objArr);
            if (intent == null) {
                x.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
                stopSelf();
            } else {
                float floatExtra = intent.getFloatExtra(hwG, -1.0f);
                if (floatExtra == -1.0f) {
                    x.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                    stopSelf();
                } else {
                    SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.cgf(), 0);
                    if (sharedPreferences.getFloat(hwG, 0.0f) == floatExtra) {
                        x.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", Float.valueOf(sharedPreferences.getFloat(hwG, 0.0f)));
                        stopSelf();
                    } else {
                        sharedPreferences.edit().putFloat(hwG, floatExtra).commit();
                        x.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", Float.valueOf(floatExtra));
                        if (aBT) {
                            x.i("MicroMsg.AddrBookObserver", "service canceled");
                            aBT = false;
                            stopSelf();
                        } else if (as.Hf()) {
                            x.e("MicroMsg.AddrBookObserver", "[onStartCommand] getCode is null, stop service");
                            stopSelf();
                        } else {
                            try {
                                if (as.Hp()) {
                                    if (d.aTK()) {
                                        a.xmy.m(new ik());
                                    }
                                    if (!m.NW() || m.NS()) {
                                        x.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                        stopSelf();
                                    } else {
                                        x.i("MicroMsg.AddrBookObserver", "start sync");
                                        if (com.tencent.mm.modelsimple.d.bu(this)) {
                                            x.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                            stopSelf();
                                        } else {
                                            hwE = true;
                                            a.a(this.hwH);
                                        }
                                    }
                                } else {
                                    x.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                    stopSelf();
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                                x.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", e.getMessage());
                                stopSelf();
                            }
                        }
                    }
                }
            }
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    public AddrBookObserver(Context context) {
        super(ag.fetchFreeHandler());
        this.context = context;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        x.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (hwE) {
            x.e("MicroMsg.AddrBookObserver", "isSyncing:" + hwE + ", is time to sync:true , return");
            return;
        }
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
    }
}
