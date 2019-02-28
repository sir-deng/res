package c.t.m.g;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"NewApi"})
public final class cy extends ScanCallback {
    BluetoothManager a;
    BluetoothAdapter b;
    BluetoothLeScanner c;
    boolean d;
    a e;
    HandlerThread f;
    byte[] g = new byte[0];
    private final Context h;
    private List<dm> i;
    private long j;

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1000:
                    cy.this.b();
                    return;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    cy.b(cy.this);
                    return;
                case 3000:
                    cy.a(cy.this, (ScanResult) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c.t.m.g.cy$1 */
    class AnonymousClass1 implements Runnable {
        private /* synthetic */ Handler a;
        private /* synthetic */ HandlerThread b;

        AnonymousClass1(Handler handler, HandlerThread handlerThread) {
            this.a = handler;
            this.b = handlerThread;
        }

        public final void run() {
            try {
                if (this.a != null) {
                    this.a.removeCallbacksAndMessages(null);
                }
                if (this.b != null) {
                    this.b.quit();
                }
            } catch (Throwable th) {
            }
        }
    }

    public cy(Context context) {
        this.h = context;
        this.i = new LinkedList();
        this.a = (BluetoothManager) this.h.getSystemService("bluetooth");
    }

    public final List<dm> a() {
        synchronized (this.i) {
            if (System.currentTimeMillis() - this.j <= 5000) {
                List<dm> list = this.i;
                return list;
            }
            return null;
        }
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        Message message = new Message();
        message.what = 3000;
        message.obj = scanResult;
        synchronized (this.g) {
            if (!(this.e == null || this.e.getLooper() == null || !this.e.getLooper().getThread().isAlive())) {
                this.e.sendMessage(message);
            }
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
    }

    public final void onScanFailed(int i) {
    }

    private int b() {
        try {
            if (!this.h.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                return -1;
            }
            if (this.b == null || !this.b.isEnabled() || this.c == null) {
                return -2;
            }
            this.c.startScan(this);
            this.d = true;
            return 0;
        } catch (Throwable th) {
            return -3;
        }
    }

    static /* synthetic */ void b(cy cyVar) {
        try {
            synchronized (cyVar.g) {
                if (cyVar.h.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                    if (cyVar.c != null) {
                        cyVar.c.stopScan(cyVar);
                    }
                    cyVar.b = null;
                    cyVar.d = false;
                    synchronized (cyVar.i) {
                        cyVar.i.clear();
                    }
                    cyVar.j = 0;
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(cy cyVar, ScanResult scanResult) {
        if (scanResult != null) {
            try {
                BluetoothDevice device = scanResult.getDevice();
                int rssi = scanResult.getRssi();
                byte[] bytes = scanResult.getScanRecord().getBytes();
                if (bytes != null && bytes.length >= 30) {
                    dm a = dm.a(device, rssi, bytes);
                    synchronized (cyVar.i) {
                        if (a != null) {
                            cyVar.i.add(a);
                            cyVar.j = System.currentTimeMillis();
                        }
                        Iterator it = cyVar.i.iterator();
                        while (it.hasNext()) {
                            if (System.currentTimeMillis() - ((dm) it.next()).a > 5000) {
                                it.remove();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
