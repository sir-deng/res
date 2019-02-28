package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.r.a;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao extends k<x> {
    final ExecutorService beV = Executors.newCachedThreadPool();
    private final y<a> beW = new y();
    private final y<q.a> beX = new y();
    private final y<b.a> beY = new y();
    private final y<c.b> beZ = new y();
    private final y<com.google.android.gms.wearable.k.a> bfa = new y();
    private final y<n.b> bfb = new y();
    private final y<n.c> bfc = new y();
    private final Map<String, y<com.google.android.gms.wearable.a.a>> bfd = new HashMap();

    /* renamed from: com.google.android.gms.wearable.internal.ao$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Uri bep;
        final /* synthetic */ boolean beq;
        final /* synthetic */ com.google.android.gms.common.api.k.b bfg;
        final /* synthetic */ String bfh;

        AnonymousClass2(Uri uri, com.google.android.gms.common.api.k.b bVar, boolean z, String str) {
            this.bep = uri;
            this.bfg = bVar;
            this.beq = z;
            this.bfh = str;
        }

        public final void run() {
            Log.isLoggable("WearableClient", 2);
            if ("file".equals(this.bep.getScheme())) {
                Object file = new File(this.bep.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (this.beq ? 33554432 : 0) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                    try {
                        ((x) ao.this.oL()).a(new i(this.bfg), this.bfh, open);
                        try {
                            open.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    } catch (RemoteException e2) {
                        this.bfg.c(new Status(8));
                        try {
                            open.close();
                            return;
                        } catch (IOException e3) {
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    new StringBuilder("File couldn't be opened for Channel.receiveFile: ").append(file);
                    this.bfg.c(new Status(13));
                    return;
                }
            }
            this.bfg.c(new Status(10, "Channel.receiveFile used with non-file URI"));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ao$1 */
    class AnonymousClass1 implements Callable<Boolean> {
        final /* synthetic */ byte[] beP;
        final /* synthetic */ ParcelFileDescriptor bfe;

        AnonymousClass1(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.bfe = parcelFileDescriptor;
            this.beP = bArr;
        }

        private Boolean ru() {
            if (Log.isLoggable("WearableClient", 3)) {
                new StringBuilder("processAssets: writing data to FD : ").append(this.bfe);
            }
            AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(this.bfe);
            try {
                autoCloseOutputStream.write(this.beP);
                autoCloseOutputStream.flush();
                if (Log.isLoggable("WearableClient", 3)) {
                    new StringBuilder("processAssets: wrote data: ").append(this.bfe);
                }
                Boolean valueOf = Boolean.valueOf(true);
                try {
                    if (Log.isLoggable("WearableClient", 3)) {
                        new StringBuilder("processAssets: closing: ").append(this.bfe);
                    }
                    autoCloseOutputStream.close();
                    return valueOf;
                } catch (IOException e) {
                    return valueOf;
                }
            } catch (IOException e2) {
                new StringBuilder("processAssets: writing data failed: ").append(this.bfe);
                try {
                    if (Log.isLoggable("WearableClient", 3)) {
                        new StringBuilder("processAssets: closing: ").append(this.bfe);
                    }
                    autoCloseOutputStream.close();
                } catch (IOException e3) {
                }
                return Boolean.valueOf(false);
            } catch (Throwable th) {
                try {
                    if (Log.isLoggable("WearableClient", 3)) {
                        new StringBuilder("processAssets: closing: ").append(this.bfe);
                    }
                    autoCloseOutputStream.close();
                } catch (IOException e4) {
                }
                throw th;
            }
        }

        public final /* synthetic */ Object call() {
            return ru();
        }
    }

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar, h hVar) {
        super(context, looper, 14, hVar, bVar, cVar);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            if (i == 0) {
                this.beW.u(iBinder);
                this.beX.u(iBinder);
                this.beZ.u(iBinder);
                this.bfa.u(iBinder);
                this.bfb.u(iBinder);
                this.bfc.u(iBinder);
                synchronized (this.bfd) {
                    for (y u : this.bfd.values()) {
                        u.u(iBinder);
                    }
                }
            }
            super.a(i, iBinder, bundle, i2);
        }
        if (i == 0) {
            this.beW.u(iBinder);
            this.beX.u(iBinder);
            this.beZ.u(iBinder);
            this.bfa.u(iBinder);
            this.bfb.u(iBinder);
            this.bfc.u(iBinder);
            synchronized (this.bfd) {
                while (r2.hasNext()) {
                    u.u(iBinder);
                }
            }
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void a(e eVar) {
        int i = 7887000;
        if (!nX()) {
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", FileUtils.S_IWUSR).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 7887000);
                }
                if (i < com.google.android.gms.common.b.aJG) {
                    new StringBuilder("Android Wear out of date. Requires API version ").append(com.google.android.gms.common.b.aJG).append(" but found ").append(i);
                    Context context = this.mContext;
                    Context context2 = this.mContext;
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter(SlookAirButtonFrequentContactAdapter.ID, "com.google.android.wearable.app.cn").build());
                    }
                    a(eVar, new ConnectionResult(6, PendingIntent.getActivity(context, 0, intent, 0)));
                    return;
                }
            } catch (NameNotFoundException e) {
                a(eVar, new ConnectionResult(16, null));
                return;
            }
        }
        super.a(eVar);
    }

    public final void disconnect() {
        this.beW.a(this);
        this.beX.a(this);
        this.beZ.a(this);
        this.bfa.a(this);
        this.bfb.a(this);
        this.bfc.a(this);
        synchronized (this.bfd) {
            for (y a : this.bfd.values()) {
                a.a(this);
            }
        }
        super.disconnect();
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return x.a.t(iBinder);
    }

    public final boolean nX() {
        return !com.google.android.gms.common.k.pp().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
    }

    protected final String nY() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String nZ() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected final String oG() {
        return com.google.android.gms.common.k.pp().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }
}
