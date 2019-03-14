/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/denghl/Vtime/vtime/client/app/src/main/aidl/com/vargo/vtime/IVTimeService.aidl
 */
package com.vargo.vtime;
// Declare any non-default types here with import statements

public interface IVTimeService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.vargo.vtime.IVTimeService
{
private static final java.lang.String DESCRIPTOR = "com.vargo.vtime.IVTimeService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.vargo.vtime.IVTimeService interface,
 * generating a proxy if needed.
 */
public static com.vargo.vtime.IVTimeService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.vargo.vtime.IVTimeService))) {
return ((com.vargo.vtime.IVTimeService)iin);
}
return new com.vargo.vtime.IVTimeService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_handler:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
com.vargo.vtime.IVTimeListener _arg2;
_arg2 = com.vargo.vtime.IVTimeListener.Stub.asInterface(data.readStrongBinder());
java.lang.String _result = this.handler(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.vargo.vtime.IVTimeService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String handler(java.lang.String method, java.lang.String params, com.vargo.vtime.IVTimeListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(method);
_data.writeString(params);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_handler, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_handler = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String handler(java.lang.String method, java.lang.String params, com.vargo.vtime.IVTimeListener listener) throws android.os.RemoteException;
}
