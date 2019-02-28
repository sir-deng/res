package com.tencent.mm.plugin.g.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int aen;
    private BluetoothAdapter kBQ;
    BluetoothDevice kCP;
    Context kCQ;
    BluetoothGatt kCR;
    b kCS;
    BluetoothGattCharacteristic kCT;
    BluetoothGattCharacteristic kCU;
    a kCV;
    Runnable kCW;
    Runnable kCX;
    Runnable kCY;
    d kCZ;
    final LinkedList<byte[]> kDa;
    volatile boolean kDb;
    int kDc;
    final BluetoothGattCallback kDd;
    public ag mHandler;
    long mSessionId;
    private HandlerThread mThread;

    private static class a extends ag {
        private final WeakReference<d> kDf;

        public a(Looper looper, d dVar) {
            super(looper);
            this.kDf = new WeakReference(dVar);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            d dVar = (d) this.kDf.get();
            if (dVar == null) {
                x.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                return;
            }
            byte[] arP;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        return;
                    } else if (dVar.kDc == 0) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        return;
                    } else {
                        dVar.arU();
                        if (dVar.kCR == null) {
                            dVar.kCR = dVar.kCP.connectGatt(dVar.kCQ, false, dVar.kDd);
                            if (dVar.kCR == null) {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.kCS != null) {
                                    dVar.kCS.kCw.g(dVar.mSessionId, false);
                                    return;
                                }
                                return;
                            }
                            dVar.kDc = 0;
                            dVar.mHandler.postDelayed(dVar.kCY, 10000);
                            return;
                        } else if (dVar.kCR.connect()) {
                            dVar.kDc = 0;
                            dVar.mHandler.postDelayed(dVar.kCY, 10000);
                            return;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                    }
                case 1:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        return;
                    }
                    dVar.arU();
                    if (dVar.kCR == null) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        return;
                    }
                    dVar.kDc = 3;
                    dVar.mHandler.removeCallbacks(dVar.kCY);
                    dVar.mHandler.removeCallbacks(dVar.kCX);
                    dVar.kCR.disconnect();
                    return;
                case 2:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                        return;
                    }
                    dVar.arU();
                    if (dVar.kCR == null) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        return;
                    }
                    dVar.kDc = 3;
                    dVar.kCR.disconnect();
                    dVar.kCR.close();
                    dVar.kCR = null;
                    return;
                case 3:
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", Integer.valueOf(((byte[]) message.obj).length));
                    if (1 != dVar.kDc) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", Integer.valueOf(dVar.kDc));
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.h(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    boolean z2 = (dVar.kCR == null || dVar.kCU == null) ? false : true;
                    Assert.assertTrue(z2);
                    dVar.kDa.add(arP);
                    if (!dVar.kDb) {
                        if (1 != dVar.kDa.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.arV();
                        return;
                    }
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    x.i(str, str2, objArr);
                    if (i == 2) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", Integer.valueOf(dVar.kDc));
                        if (3 == dVar.kDc) {
                            x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            return;
                        } else if (1 == dVar.kDc) {
                            x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            return;
                        } else if (dVar.kCR.discoverServices()) {
                            x.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            return;
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                    } else if (i == 0) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        dVar.kDc = 2;
                        dVar.mHandler.removeCallbacks(dVar.kCY);
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", Integer.valueOf(message.arg1));
                    if (3 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.kCY);
                        return;
                    } else if (1 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.kCY);
                        return;
                    } else if (i != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.kDc = 2;
                        dVar.mHandler.removeCallbacks(dVar.kCY);
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.kDH));
                        if (service == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        dVar.kCT = service.getCharacteristic(UUID.fromString(h.kDJ));
                        if (dVar.kCT == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        dVar.kCU = service.getCharacteristic(UUID.fromString(h.kDI));
                        if (dVar.kCU == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", Integer.valueOf(dVar.kCT.getProperties()));
                        if ((dVar.kCT.getProperties() & 32) == 0) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.kCZ;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.kCT;
                        if (dVar2.kCR.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.kDG));
                            if (descriptor == null) {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                x.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    x.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (dVar2.kCR.writeDescriptor(descriptor)) {
                                    dVar2.mHandler.postDelayed(dVar2.kCX, 5000);
                                } else {
                                    x.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.kDc = 2;
                            dVar.mHandler.removeCallbacks(dVar.kCY);
                            if (dVar.kCS != null) {
                                dVar.kCS.kCw.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", Integer.valueOf(message.arg1));
                    dVar.mHandler.removeCallbacks(dVar.kCX);
                    dVar.mHandler.removeCallbacks(dVar.kCY);
                    if (3 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        return;
                    } else if (1 == dVar.kDc) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        return;
                    } else if (i2 != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.kDc = 2;
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    } else {
                        dVar.kDc = 1;
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.g(dVar.mSessionId, true);
                        }
                        x.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", Integer.valueOf(dVar.kDc));
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", Integer.valueOf(i2));
                    dVar.mHandler.removeCallbacks(dVar.kCW);
                    if (i2 != 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i2);
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.h(dVar.mSessionId, false);
                        }
                        dVar.arV();
                        return;
                    }
                    arP = dVar.kCV.arP();
                    x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.ar(arP));
                    if (arP == null) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.kCS != null) {
                            dVar.kCS.kCw.h(dVar.mSessionId, true);
                        }
                        dVar.arV();
                        return;
                    }
                    x.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.kCU.setValue(arP);
                    dVar.kCR.writeCharacteristic(dVar.kCU);
                    dVar.mHandler.postDelayed(dVar.kCW, 5000);
                    return;
                case 8:
                    arP = (byte[]) message.obj;
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (bi.by(arP)) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        return;
                    }
                    String L = b.L(arP, arP.length);
                    x.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", Integer.valueOf(arP.length));
                    x.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", L);
                    if (dVar.kCS != null) {
                        dVar.kCS.kCw.b(dVar.mSessionId, arP);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        this.kDa = new LinkedList();
        this.kDb = false;
        this.kDd = new BluetoothGattCallback() {
            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(d.this.kDc));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, i2, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(4));
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(5));
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(6));
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(8));
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", Integer.valueOf(i));
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", Integer.valueOf(i));
                if (!d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(7, i, 0))) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(7));
                }
            }
        };
        this.aen = -1;
        this.aen = hashCode();
        this.kCZ = this;
        this.kCS = bVar;
        this.kCQ = context;
        this.kBQ = ((BluetoothManager) this.kCQ.getSystemService("bluetooth")).getAdapter();
        this.mSessionId = j;
        this.kDc = 3;
        this.kCP = this.kBQ.getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.bN(j));
        this.kCT = null;
        this.kCU = null;
        this.kCV = new a();
        this.mThread = e.WL("BluetoothLESession_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
        this.kCW = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (d.this.kCS != null) {
                    d.this.kCS.kCw.h(d.this.mSessionId, false);
                }
                d.this.arV();
            }
        };
        this.kCX = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
                if (3 == d.this.kDc) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.kCY);
                d.this.kDc = 2;
                if (d.this.kCS != null) {
                    d.this.kCS.kCw.g(d.this.mSessionId, false);
                }
            }
        };
        this.kCY = new Runnable() {
            public final void run() {
                x.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
                if (3 == d.this.kDc) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                d.this.mHandler.removeCallbacks(d.this.kCX);
                d.this.kDc = 2;
                if (d.this.kCS != null) {
                    d.this.kCS.kCw.g(d.this.mSessionId, false);
                }
            }
        };
    }

    public final boolean connect() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void close() {
        x.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", Integer.valueOf(2));
        }
        this.mThread.quitSafely();
    }

    final void arU() {
        this.kDb = false;
        this.kDa.clear();
    }

    final void arV() {
        if (this.kDa.isEmpty()) {
            this.kDb = false;
            return;
        }
        this.kCV.setData((byte[]) this.kDa.pop());
        x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", b.ar(this.kCV.arP()));
        this.kCU.setValue(r0);
        this.mHandler.postDelayed(this.kCW, 5000);
        if (!this.kCR.writeCharacteristic(this.kCU)) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.kDb = true;
    }
}
