package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface p extends IInterface {

    public static abstract class a extends Binder implements p {

        private static class a implements p {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final o aFp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    o O = com.tencent.mm.plugin.exdevice.service.o.a.O(obtain2.readStrongBinder());
                    return O;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final l aFq() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    l N = com.tencent.mm.plugin.exdevice.service.l.a.N(obtain2.readStrongBinder());
                    return N;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        }

        public static p P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    o aFp = aFp();
                    parcel2.writeNoException();
                    if (aFp != null) {
                        iBinder = aFp.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    l aFq = aFq();
                    parcel2.writeNoException();
                    if (aFq != null) {
                        iBinder = aFq.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    o aFp();

    l aFq();
}
