package com.tencent.mm.plugin.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {

        private static class a implements a {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int a(CDNTaskInfo cDNTaskInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int b(CDNTaskInfo cDNTaskInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean yg(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean yh(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final CDNTaskState yi(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    CDNTaskState cDNTaskState;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        cDNTaskState = (CDNTaskState) CDNTaskState.CREATOR.createFromParcel(obtain2);
                    } else {
                        cDNTaskState = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return cDNTaskState;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void b(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void oO(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void aAx() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void aAy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void aAz() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
        }

        public static a H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            CDNTaskInfo cDNTaskInfo = null;
            int i3 = 0;
            int a;
            boolean yg;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    a = a(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    a = b(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    yg = yg(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(yg ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    yg = yh(parcel.readString());
                    parcel2.writeNoException();
                    if (yg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    CDNTaskState yi = yi(parcel.readString());
                    parcel2.writeNoException();
                    if (yi != null) {
                        parcel2.writeInt(1);
                        yi.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    a(com.tencent.mm.plugin.downloader.a.b.a.I(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    b(com.tencent.mm.plugin.downloader.a.b.a.I(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    oO(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    aAx();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    aAy();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    aAz();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(CDNTaskInfo cDNTaskInfo);

    void a(b bVar);

    void aAx();

    void aAy();

    void aAz();

    int b(CDNTaskInfo cDNTaskInfo);

    void b(b bVar);

    void oO(int i);

    boolean yg(String str);

    boolean yh(String str);

    CDNTaskState yi(String str);
}
