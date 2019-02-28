package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.x;

public class f {

    private static class a implements a {
        private a() {
        }

        public final void a(Bundle bundle, final c cVar) {
            Parcelable parcelable = bundle.getParcelable("__remote_task_data");
            String string = bundle.getString("__remote_task_class");
            if (string == null || string.length() == 0) {
                x.e("IPC.IPCInvoker", "proxy AsyncInvoke failed, class is null or nil.");
                return;
            }
            h hVar = (h) o.d(string, h.class);
            if (hVar == null) {
                x.w("IPC.IPCInvoker", "proxy AsyncInvoke failed, newInstance(%s) return null.", string);
                return;
            }
            hVar.a(parcelable, new i<Parcelable>() {
                public final /* synthetic */ void as(Object obj) {
                    Parcelable parcelable = (Parcelable) obj;
                    if (cVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("__remote_task_result_data", parcelable);
                        cVar.i(bundle);
                    }
                }
            });
        }
    }

    private static class b implements l {
        private b() {
        }

        public final Bundle j(Bundle bundle) {
            if (bundle == null) {
                x.e("IPC.IPCInvoker", "proxy SyncInvoke failed, data is null.");
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("__remote_task_data");
            String string = bundle.getString("__remote_task_class");
            if (string == null || string.length() == 0) {
                x.e("IPC.IPCInvoker", "proxy SyncInvoke failed, class is null or nil.");
                return null;
            }
            j jVar = (j) o.d(string, j.class);
            if (jVar == null) {
                x.w("IPC.IPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", string);
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("__remote_task_result_data", (Parcelable) jVar.at(parcelable));
            return bundle2;
        }
    }

    public static <T extends a> boolean a(final String str, final Bundle bundle, final Class<T> cls, final c cVar) {
        if (str != null && str.length() != 0) {
            return m.g(new Runnable() {
                public final void run() {
                    if (e.fj(str)) {
                        a aVar = (a) o.a(cls, a.class);
                        if (aVar == null) {
                            x.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", cls);
                            return;
                        }
                        aVar.a(bundle, cVar);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a fh = b.Bz().fh(str);
                    if (fh == null) {
                        x.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.b bVar = null;
                    try {
                        if (cVar != null) {
                            bVar = new com.tencent.mm.ipcinvoker.b.b.a() {
                                public final void i(Bundle bundle) {
                                    if (bundle != null) {
                                        bundle.setClassLoader(f.class.getClassLoader());
                                    }
                                    cVar.i(bundle);
                                }
                            };
                        }
                        fh.a(bundle, cls.getName(), bVar);
                    } catch (RemoteException e) {
                        x.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                    }
                }
            });
        }
        x.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends l> Bundle a(String str, Bundle bundle, Class<T> cls) {
        if (str.length() == 0) {
            x.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (e.fj(str)) {
            l lVar = (l) o.a(cls, l.class);
            if (lVar != null) {
                return lVar.j(bundle);
            }
            x.e("IPC.IPCInvoker", "invokeSync failed, newInstance(%s) return null.", cls);
            return null;
        } else {
            com.tencent.mm.ipcinvoker.b.a fh = b.Bz().fh(str);
            if (fh == null) {
                x.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                return null;
            }
            try {
                Bundle d = fh.d(bundle, cls.getName());
                if (d == null) {
                    return d;
                }
                d.setClassLoader(f.class.getClassLoader());
                return d;
            } catch (RemoteException e) {
                x.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                return null;
            }
        }
    }

    public static <T extends h<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(final String str, final InputType inputType, final Class<T> cls, final i<ResultType> iVar) {
        if (str != null && str.length() != 0) {
            return m.g(new Runnable() {
                public final void run() {
                    if (e.fj(str)) {
                        ((a) o.a(a.class, a.class)).a(f.a(inputType, cls), new c() {
                            public final void i(Bundle bundle) {
                                if (iVar == null) {
                                    return;
                                }
                                if (bundle == null) {
                                    iVar.as(null);
                                    return;
                                }
                                bundle.setClassLoader(f.class.getClassLoader());
                                iVar.as(bundle.getParcelable("__remote_task_result_data"));
                            }
                        });
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a fh = b.Bz().fh(str);
                    if (fh == null) {
                        x.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.b bVar = null;
                    try {
                        if (iVar != null) {
                            bVar = new com.tencent.mm.ipcinvoker.b.b.a() {
                                public final void i(Bundle bundle) {
                                    if (bundle == null) {
                                        iVar.as(null);
                                        return;
                                    }
                                    bundle.setClassLoader(f.class.getClassLoader());
                                    iVar.as(bundle.getParcelable("__remote_task_result_data"));
                                }
                            };
                        }
                        fh.a(f.a(inputType, cls), a.class.getName(), bVar);
                    } catch (RemoteException e) {
                        x.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                    }
                }
            });
        }
        x.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends j<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputType, Class<T> cls) {
        Bundle j;
        if (str == null || str.length() == 0) {
            x.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (e.fj(str)) {
            j = ((b) o.a(b.class, b.class)).j(a(inputType, cls));
            if (j == null) {
                return null;
            }
            j.setClassLoader(f.class.getClassLoader());
            return j.getParcelable("__remote_task_result_data");
        } else {
            com.tencent.mm.ipcinvoker.b.a fh = b.Bz().fh(str);
            if (fh == null) {
                x.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                return null;
            }
            try {
                j = fh.d(a(inputType, cls), b.class.getName());
                if (j == null) {
                    return null;
                }
                j.setClassLoader(f.class.getClassLoader());
                return j.getParcelable("__remote_task_result_data");
            } catch (RemoteException e) {
                x.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                return null;
            }
        }
    }

    private static Bundle a(Parcelable parcelable, Class<?> cls) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        bundle.putString("__remote_task_class", cls.getName());
        return bundle;
    }
}
