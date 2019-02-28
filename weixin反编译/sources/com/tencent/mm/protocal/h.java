package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        private static class a implements h {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean a(int i, byte[] bArr, byte[] bArr2) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] Ky() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hp(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int KT() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int KR() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String KS() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void jy(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] CM() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] KU() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] KA() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int Cn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String KY() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getCmdId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String KV() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String KW() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int KX() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseResp_AIDL");
        }

        public static h ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            byte[] Ky;
            int KT;
            String KS;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    boolean a = a(parcel.readInt(), parcel.createByteArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Ky = Ky();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ky);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    hp(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KT = KT();
                    parcel2.writeNoException();
                    parcel2.writeInt(KT);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KT = KR();
                    parcel2.writeNoException();
                    parcel2.writeInt(KT);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KS = KS();
                    parcel2.writeNoException();
                    parcel2.writeString(KS);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    jy(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Ky = CM();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ky);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Ky = KU();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ky);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    Ky = KA();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ky);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KT = Cn();
                    parcel2.writeNoException();
                    parcel2.writeInt(KT);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KS = KY();
                    parcel2.writeNoException();
                    parcel2.writeString(KS);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KT = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(KT);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KS = KV();
                    parcel2.writeNoException();
                    parcel2.writeString(KS);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KS = KW();
                    parcel2.writeNoException();
                    parcel2.writeString(KS);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    KT = KX();
                    parcel2.writeNoException();
                    parcel2.writeInt(KT);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    byte[] CM();

    int Cn();

    byte[] KA();

    int KR();

    String KS();

    int KT();

    byte[] KU();

    String KV();

    String KW();

    int KX();

    String KY();

    byte[] Ky();

    boolean a(int i, byte[] bArr, byte[] bArr2);

    int getCmdId();

    void hp(int i);

    void jy(String str);
}
