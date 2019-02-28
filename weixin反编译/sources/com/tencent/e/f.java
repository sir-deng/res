package com.tencent.e;

import com.tencent.e.b.b;
import com.tencent.e.b.c;
import com.tencent.e.b.d;
import java.util.HashMap;

public final class f {
    private static f AvK;
    private HashMap<String, g> AvL = new HashMap();
    HashMap<String, Object> AvM = new HashMap();
    private Object AvN = new Object();
    Object AvO = new Object();
    private a AvP = new a();

    class a {
        private final HashMap<String, Object> AvQ = new HashMap();
        private final Object mLock = new Object();

        a() {
        }

        final void gk(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                while (this.AvQ.get(str3) != null) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        throw new c("install fail,lock interrupted!");
                    }
                }
                this.AvQ.put(str3, str2);
            }
        }

        final void gl(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                this.AvQ.remove(str3);
                this.mLock.notifyAll();
            }
        }
    }

    static f cIl() {
        if (AvK == null) {
            synchronized (f.class) {
                if (AvK == null) {
                    AvK = new f();
                }
            }
        }
        return AvK;
    }

    public static Object acA(String str) {
        return cIl().acB(str);
    }

    public static b a(d dVar) {
        return cIl().b(dVar);
    }

    private Object acB(String str) {
        if (str == null) {
            throw new h("TpfServiceCenter|getService|service name should not be null");
        }
        Object obj;
        synchronized (this.AvO) {
            obj = this.AvM.get(str);
        }
        if (obj == null) {
            g gVar;
            synchronized (this.AvN) {
                gVar = (g) this.AvL.get(str);
            }
            if (gVar != null) {
                if (gVar.AvT.Awf) {
                    return c(gVar);
                }
                Object obj2;
                if (4 == gVar.mState) {
                    try {
                        a(gVar);
                    } catch (c e) {
                        com.tencent.pb.common.c.c.m("service", e);
                        return null;
                    }
                }
                synchronized (this.AvO) {
                    obj2 = this.AvM.get(str);
                }
                return obj2;
            }
        }
        return obj;
    }

    private b b(d dVar) {
        Object obj = 1;
        if (dVar == null || dVar.Awd == null) {
            return null;
        }
        String str = dVar.Awd;
        this.AvP.gk("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.AvN) {
                bVar = (g) this.AvL.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] installed!");
                    this.AvL.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] had been installed!");
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.Awc == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] resolved!");
                } else {
                    throw new c("resolve service [" + str + "] failed.");
                }
            }
            this.AvP.gl("install_", str);
            return bVar;
        } catch (Throwable th) {
            this.AvP.gl("install_", str);
        }
    }

    final boolean a(g gVar) {
        boolean z = false;
        d dVar = gVar.AvT;
        String str = dVar.Awd;
        this.AvP.gk("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.c.d("service", "service [", str, "] starting...");
                if (dVar.Awe != null) {
                    P(dVar.Awe);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.AvP.gl("service_", str);
            if (z) {
                return true;
            }
            throw new c("startService [" + str + "] failed");
        } catch (Throwable th) {
            this.AvP.gl("service_", str);
        }
    }

    private boolean P(String[] strArr) {
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.AvN) {
                        gVar = (g) this.AvL.get(obj);
                    }
                    if (gVar == null) {
                        return false;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        return false;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.c.d("reference_count", "addReferenceCount|", gVar.AvT.Awd, "|refcount=", Integer.valueOf(gVar.mReferenceCount));
                }
            }
        }
        return true;
    }

    private static boolean b(g gVar) {
        if (!gVar.AvT.Awf) {
            try {
                b bVar = (b) Class.forName(gVar.AvT.Awc).newInstance();
                gVar.AvU = bVar;
                com.tencent.e.b.a aVar = new a(gVar);
                gVar.AvV = aVar;
                bVar.a(aVar);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.m("service", e);
            }
        }
        return false;
    }

    private static Object c(g gVar) {
        try {
            c cVar = (c) Class.forName(gVar.AvT.Awc).newInstance();
            gVar.AvV = new a(gVar);
            gVar.mState = 32;
            return cVar.cIi();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("service", e);
            return null;
        }
    }
}
