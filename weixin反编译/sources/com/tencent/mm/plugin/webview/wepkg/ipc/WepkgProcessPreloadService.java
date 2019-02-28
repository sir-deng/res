package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.webview.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.plugin.webview.wepkg.model.c;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class WepkgProcessPreloadService extends Service {
    private static Messenger jdV = new Messenger(tSS);
    private static ServiceConnection jdY;
    private static final Handler mHandler = new Handler(d.Dt().oFY.getLooper()) {
        public final void handleMessage(Message message) {
            try {
                Messenger messenger = message.replyTo;
                Message obtain = Message.obtain();
                obtain.what = message.what;
                Bundle data = message.getData();
                switch (data.getInt("call_cmd_type")) {
                    case 0:
                        WepkgProcessPreloadService.a(data.getString("call_raw_url"), messenger, obtain);
                        return;
                    case 1:
                        WepkgProcessPreloadService.b(data.getString("call_pkg_id"), messenger, obtain);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    };
    private static Messenger mnY;
    private static final LinkedList<Message> tSP = new LinkedList();
    private static f<Integer, c> tSR = new f(10);
    private static final Handler tSS = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            c cVar = (c) WepkgProcessPreloadService.tSR.remove(Integer.valueOf(message.what));
            if (cVar != null) {
                cVar.r(message);
                return;
            }
            x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "receive client msg, get null task by id %s", Integer.valueOf(r1));
        }
    };
    private static final Messenger tST = new Messenger(mHandler);

    static /* synthetic */ void a(String str, final Messenger messenger, final Message message) {
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload entrance url:%s", str);
        if (WepkgMainProcessService.ahf()) {
            x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "preload wepkg");
            g.QI(str);
            a(messenger, message);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "prestart WepkgMainProcessService and preload wepkg");
        d.a(str, new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.foB) {
                    final String str = ((WepkgCrossProcessTask) baseWepkgProcessTask).tTu;
                    d.Dt().F(new Runnable() {
                        public final void run() {
                            g.QI(str);
                            WepkgProcessPreloadService.a(messenger, message);
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void akt() {
        if (mnY != null) {
            synchronized (tSP) {
                Iterator it = tSP.iterator();
                while (it.hasNext()) {
                    q((Message) it.next());
                }
                tSP.clear();
            }
        }
    }

    static /* synthetic */ void b(String str, Messenger messenger, Message message) {
        String str2 = "";
        if (!(b.tUt.QS(str) == null || b.tUt.QS(str).tTq == null)) {
            str2 = b.tUt.QS(str).tTq.version;
        }
        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "pkgid:%s used_version:%s", str, str2);
        Bundle data = message.getData();
        data.putString("used_wepkg_version", str2);
        message.setData(data);
        a(messenger, message);
    }

    private static final void a(Messenger messenger, Message message) {
        if (messenger != null) {
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", "messenger callback err:%s", e.getMessage());
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return tST.getBinder();
    }

    public static synchronized void a(c cVar, Bundle bundle) {
        synchronized (WepkgProcessPreloadService.class) {
            tSR.put(Integer.valueOf(cVar.hashCode()), cVar);
            Message obtain = Message.obtain();
            obtain.what = cVar.hashCode();
            obtain.setData(bundle);
            q(obtain);
        }
    }

    private static void q(Message message) {
        message.replyTo = jdV;
        if (mnY == null) {
            if (jdY == null) {
                jdY = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        WepkgProcessPreloadService.mnY = new Messenger(iBinder);
                        WepkgProcessPreloadService.akt();
                        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceConnected(%s)", ad.By());
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        WepkgProcessPreloadService.mnY = null;
                        x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "onServiceDisconnected(%s)", ad.By());
                    }
                };
            }
            x.i("MicroMsg.Wepkg.WepkgProcessPreloadService", "try bind WepkgProcessPreloadService");
            Context context = ad.getContext();
            context.bindService(new Intent(context, WepkgProcessPreloadService.class), jdY, 1);
            synchronized (tSP) {
                tSP.add(message);
            }
            return;
        }
        try {
            mnY.send(message);
        } catch (RemoteException e) {
            x.e("MicroMsg.Wepkg.WepkgProcessPreloadService", e.getMessage());
        }
    }
}
