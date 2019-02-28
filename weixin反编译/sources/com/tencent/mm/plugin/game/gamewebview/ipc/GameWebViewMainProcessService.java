package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.plugin.game.gamewebview.model.e;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameWebViewMainProcessService extends Service {
    private static ServiceConnection jdY;
    private static final LinkedList<Parcel> jdZ = new LinkedList();
    private static Map<String, WeakReference<GWMainProcessTask>> jea = new ConcurrentHashMap();
    private static Handler jeb = new Handler() {
        public final void handleMessage(Message message) {
            GWMainProcessTask e = GameWebViewMainProcessService.d(message.getData(), false);
            GWMainProcessTask Cj = GameWebViewMainProcessService.Cj(e.jeC);
            if (Cj == null) {
                x.e("MicroMsg.GameWebViewMainProcessService", "receive client msg, get null task by id %s", e.jeC);
                return;
            }
            GameWebViewMainProcessService.a(e, Cj);
            Cj.YB();
        }
    };
    private static Messenger jec = new Messenger(jeb);
    private static b nbG;
    private static Set<Object> nbH = new HashSet();
    private final Messenger jdV = new Messenger(this.mHandler);
    private final Handler mHandler = new Handler(d.Dt().oFY.getLooper()) {
        public final void handleMessage(Message message) {
            GameWebViewMainProcessService.d(message.getData(), true).YA();
        }
    };
    private com.tencent.mm.plugin.game.gamewebview.model.d nbD;
    private e nbE;
    private final a nbF = new a() {
        public final void s(Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            GameWebViewMainProcessService.this.jdV.send(obtain);
        }

        public final void t(Bundle bundle) {
            GameWebViewMainProcessService.d(bundle, false).YA();
        }
    };

    static /* synthetic */ GWMainProcessTask Cj(String str) {
        if (jea.containsKey(str)) {
            return ((WeakReference) jea.get(str)).get() == null ? null : (GWMainProcessTask) ((WeakReference) jea.get(str)).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void aPm() {
        if (nbG != null) {
            synchronized (jdZ) {
                Iterator it = jdZ.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    r(bundle);
                    parcel.recycle();
                }
                jdZ.clear();
            }
        }
    }

    static /* synthetic */ void aPn() {
        Iterator it = nbH.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ void aPo() {
        Iterator it = nbH.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void onCreate() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onCreate");
        super.onCreate();
        if (g.Do().CF()) {
            this.nbD = new com.tencent.mm.plugin.game.gamewebview.model.d();
            f.bSn().a(this.nbD);
        }
        this.nbE = new e();
        com.tencent.mm.plugin.downloader.model.f.aAK();
        c.a(this.nbE);
    }

    public void onDestroy() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAK();
        c.b(this.nbE);
        if (as.Hp()) {
            f.bSn().b(this.nbD);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.nbF;
    }

    public static void a(GWMainProcessTask gWMainProcessTask) {
        jea.put(gWMainProcessTask.jeC, new WeakReference(gWMainProcessTask));
        r(a(gWMainProcessTask, true));
    }

    public static boolean b(GWMainProcessTask gWMainProcessTask) {
        Bundle a = a(gWMainProcessTask, false);
        if (!q(a)) {
            return false;
        }
        a(d(a, false), gWMainProcessTask);
        gWMainProcessTask.YB();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            nbG.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void r(Bundle bundle) {
        if (nbG == null) {
            afr();
            synchronized (jdZ) {
                LinkedList linkedList = jdZ;
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                linkedList.add(obtain);
            }
            return;
        }
        try {
            nbG.s(bundle);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
        }
    }

    private static void afr() {
        if (jdY == null) {
            jdY = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    GameWebViewMainProcessService.nbG = a.R(iBinder);
                    GameWebViewMainProcessService.aPm();
                    GameWebViewMainProcessService.aPn();
                    x.i("MicroMsg.GameWebViewMainProcessService", "onServiceConnected(%s)", ad.By());
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    GameWebViewMainProcessService.nbG = null;
                    GameWebViewMainProcessService.aPo();
                    GameWebViewMainProcessService.afr();
                    x.i("MicroMsg.GameWebViewMainProcessService", "onServiceDisconnected(%s)", ad.By());
                }
            };
        }
        x.i("MicroMsg.GameWebViewMainProcessService", "tryBindService");
        Context context = ad.getContext();
        context.bindService(new Intent(context, GameWebViewMainProcessService.class), jdY, 1);
    }

    private static void a(GWMainProcessTask gWMainProcessTask, GWMainProcessTask gWMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        gWMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gWMainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(GWMainProcessTask gWMainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", gWMainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", jec);
        }
        bundle.putString("task_id", gWMainProcessTask.jeC);
        return bundle;
    }

    private static GWMainProcessTask d(Bundle bundle, boolean z) {
        bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
        GWMainProcessTask gWMainProcessTask = (GWMainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            gWMainProcessTask.jeQ = (Messenger) bundle.getParcelable("task_client");
        }
        gWMainProcessTask.jeC = bundle.getString("task_id");
        return gWMainProcessTask;
    }
}
