package android.support.v4.view.a;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static final a Av;
    public final Object Aw;

    interface a {
        Object a(c cVar);
    }

    static class d implements a {
        d() {
        }

        public Object a(c cVar) {
            return null;
        }
    }

    static class b extends d {
        b() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.d.AnonymousClass1(new a() {
                public final boolean cf() {
                    return c.cf();
                }

                public final List<Object> cg() {
                    List list = null;
                    c.cg();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).zX);
                    }
                    return arrayList;
                }

                public final Object ci() {
                    c.ce();
                    return null;
                }
            });
        }
    }

    static class c extends d {
        c() {
        }

        public final Object a(final c cVar) {
            return new android.support.v4.view.a.e.AnonymousClass1(new a() {
                public final boolean cf() {
                    return c.cf();
                }

                public final List<Object> cg() {
                    List list = null;
                    c.cg();
                    List<Object> arrayList = new ArrayList();
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        arrayList.add(((b) list.get(i)).zX);
                    }
                    return arrayList;
                }

                public final Object ci() {
                    c.ce();
                    return null;
                }

                public final Object cj() {
                    c.ch();
                    return null;
                }
            });
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            Av = new c();
        } else if (VERSION.SDK_INT >= 16) {
            Av = new b();
        } else {
            Av = new d();
        }
    }

    public c() {
        this.Aw = Av.a(this);
    }

    public c(Object obj) {
        this.Aw = obj;
    }

    public static b ce() {
        return null;
    }

    public static boolean cf() {
        return false;
    }

    public static List<b> cg() {
        return null;
    }

    public static b ch() {
        return null;
    }
}
