package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c {

    public static final class b implements Runnable {
        private final BluetoothSocket kFI;
        private b kFK;
        a kFL;
        private InputStream kFO = null;
        private volatile boolean kFP = false;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.kFI = bluetoothSocket;
            this.kFK = bVar;
            this.kFL = aVar;
            try {
                this.kFO = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                this.kFO = null;
                x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", e.toString());
            }
        }

        public final void run() {
            x.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.kFO == null) {
                x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                return;
            }
            Object obj = new byte[2048];
            while (!this.kFP) {
                try {
                    int read = this.kFO.read(obj);
                    if (read > 0) {
                        x.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", Integer.valueOf(read));
                        x.d("MicroMsg.exdevice.RecvThread", "data dump = %s", com.tencent.mm.plugin.exdevice.j.b.L(obj, read));
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        if (this.kFL != null) {
                            this.kFL.kFB.b(this.kFK.mSessionId, obj2);
                        }
                    }
                } catch (IOException e) {
                    x.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", e.toString());
                    try {
                        this.kFI.close();
                        return;
                    } catch (IOException e2) {
                        x.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", e2.toString());
                        return;
                    }
                }
            }
            x.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        }

        public final void cancel() {
            x.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.kFP) {
                x.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                return;
            }
            this.kFP = true;
            e.Q(this);
            try {
                this.kFI.close();
            } catch (IOException e) {
                x.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", e);
            }
        }
    }

    public static final class a {
        BluetoothSocket kFI;
        final boolean kFJ = true;
        public final b kFK;
        public final a kFL;
        boolean kFM = false;
        final BluetoothDevice kFN;
        public final ag mHandler;
        private final HandlerThread mThread;

        private static class a extends ag {
            private WeakReference<a> kDf = null;

            public a(Looper looper, a aVar) {
                super(looper);
                this.kDf = new WeakReference(aVar);
            }

            public final void handleMessage(Message message) {
                a aVar = (a) this.kDf.get();
                if (aVar == null) {
                    x.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    return;
                }
                switch (message.what) {
                    case 0:
                        x.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (aVar.kFM) {
                            x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            return;
                        }
                        try {
                            if (aVar.kFJ) {
                                aVar.kFI = aVar.kFN.createRfcommSocketToServiceRecord(a.kFz);
                            } else {
                                aVar.kFI = aVar.kFN.createInsecureRfcommSocketToServiceRecord(a.kFA);
                            }
                            try {
                                aVar.kFI.connect();
                                aVar.kFM = true;
                                b bVar = aVar.kFK;
                                a aVar2 = aVar.kFL;
                                BluetoothSocket bluetoothSocket = aVar.kFI;
                                x.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                bVar.mState = 3;
                                if (bVar.kFG != null) {
                                    bVar.kFG.cancel();
                                    bVar.kFG = null;
                                }
                                if (bVar.kFH != null) {
                                    bVar.kFH.cancel();
                                    bVar.kFH = null;
                                }
                                bVar.kFG = new b(bVar, aVar2, bluetoothSocket);
                                e.b(bVar.kFG, "BluetoothChatSession_recv").start();
                                bVar.kFH = new c(bVar, aVar2, bluetoothSocket);
                                e.b(bVar.kFH, "BluetoothChatSession_send").start();
                                if (aVar.kFL != null) {
                                    aVar.kFL.kFB.g(aVar.kFK.mSessionId, true);
                                    return;
                                }
                                return;
                            } catch (IOException e) {
                                x.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", e.toString());
                                try {
                                    aVar.kFI.close();
                                } catch (IOException e2) {
                                    x.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", e2.toString());
                                }
                                if (aVar.kFL != null) {
                                    aVar.kFL.kFB.g(aVar.kFK.mSessionId, false);
                                    return;
                                }
                                return;
                            }
                        } catch (IOException e22) {
                            aVar.kFI = null;
                            x.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", e22.toString());
                            if (aVar.kFL != null) {
                                aVar.kFL.kFB.g(aVar.kFK.mSessionId, false);
                                return;
                            }
                            return;
                        }
                    case 1:
                        if (aVar.kFM) {
                            try {
                                aVar.kFI.close();
                                return;
                            } catch (IOException e3) {
                                x.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", e3.toString());
                                return;
                            }
                        }
                        x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                        return;
                    default:
                        return;
                }
            }
        }

        public a(b bVar, a aVar, BluetoothDevice bluetoothDevice, boolean z) {
            this.kFL = aVar;
            this.kFK = bVar;
            this.kFN = bluetoothDevice;
            this.mThread = e.WL("BluetoothChatThreads_handlerThread");
            this.mThread.start();
            this.mHandler = new a(this.mThread.getLooper(), this);
        }

        public final void disconnect() {
            x.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                x.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", Integer.valueOf(1));
            }
            if (f.fN(18)) {
                this.mThread.quitSafely();
            } else {
                this.mThread.quit();
            }
        }
    }

    public static final class c implements Runnable {
        private b kFK = null;
        private a kFL = null;
        private volatile boolean kFP = false;
        private volatile Runnable kFQ = null;
        private OutputStream kFR = null;
        private final LinkedList<byte[]> kFS = new LinkedList();
        private final LinkedList<byte[]> kFT = new LinkedList();

        public c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.kFK = bVar;
            this.kFL = aVar;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.kFQ = this;
                this.kFR = outputStream;
            } catch (IOException e) {
                x.e("MicroMsg.exdevice.SendThread", "temp sockets not created", e);
                this.kFR = null;
                if (this.kFL != null) {
                    this.kFL.kFB.b(this.kFK.mSessionId, 11, "Can not get write stream");
                }
            }
        }

        public final void run() {
            x.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
            if (this.kFR != null) {
                while (!this.kFP) {
                    if (this.kFQ == null) {
                        x.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                        return;
                    } else if (!this.kFT.isEmpty()) {
                        try {
                            this.kFR.write((byte[]) this.kFT.pop());
                            if (this.kFL != null) {
                                this.kFL.kFB.h(this.kFK.mSessionId, true);
                            }
                        } catch (IOException e) {
                            if (this.kFL != null) {
                                this.kFL.kFB.h(this.kFK.mSessionId, false);
                            }
                        }
                    } else if (this.kFS.isEmpty()) {
                        synchronized (this) {
                            try {
                                wait();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                                x.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                            }
                        }
                    } else {
                        synchronized (this.kFS) {
                            Assert.assertTrue(this.kFT.addAll(this.kFS));
                            this.kFS.clear();
                        }
                    }
                }
            }
        }

        public final boolean ah(byte[] bArr) {
            x.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", Integer.valueOf(bArr.length));
            if (this.kFQ == null) {
                x.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                return false;
            }
            synchronized (this) {
                this.kFS.add(bArr);
                notify();
            }
            return true;
        }

        public final void cancel() {
            this.kFQ = null;
            this.kFP = true;
            synchronized (this) {
                notify();
            }
            this.kFT.clear();
            this.kFS.clear();
        }
    }
}
