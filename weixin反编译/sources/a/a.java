package a;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class a {
    private final boolean ADM = false;
    private final Object object;

    private static class a {
        private a() {
        }
    }

    public static a cD(Object obj) {
        return new a(obj);
    }

    private a(Object obj) {
        this.object = obj;
    }

    public final a n(String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? a.class : obj.getClass();
        }
        try {
            return a(a(str, clsArr), this.object, objArr);
        } catch (NoSuchMethodException e) {
            Class cKk = cKk();
            for (Method method : cKk.getMethods()) {
                if (a(method, str, clsArr)) {
                    break;
                }
            }
            Class cls = cKk;
            loop2:
            while (true) {
                for (Method method2 : cls.getDeclaredMethods()) {
                    if (a(method2, str, clsArr)) {
                        break loop2;
                    }
                }
                Class superclass = cls.getSuperclass();
                if (superclass == null) {
                    throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + cKk() + ".");
                }
                cls = superclass;
            }
            return a(method2, this.object, objArr);
        } catch (Throwable e2) {
            throw new b(e2);
        }
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class cKk = cKk();
        try {
            return cKk.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return cKk.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException e2) {
                    cKk = cKk.getSuperclass();
                    if (cKk != null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (cKk != null);
            throw new NoSuchMethodException();
        }
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (!method.getName().equals(str)) {
            return false;
        }
        boolean z;
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == clsArr.length) {
            int i = 0;
            while (i < clsArr.length) {
                if (clsArr[i] == a.class || Q(parameterTypes[i]).isAssignableFrom(Q(clsArr[i]))) {
                    i++;
                }
            }
            z = true;
            return z;
        }
        z = false;
        if (z) {
        }
    }

    public final int hashCode() {
        return this.object.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.object.equals(((a) obj).object);
        }
        return false;
    }

    public final String toString() {
        return this.object.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static a.a a(java.lang.reflect.Method r3, java.lang.Object r4, java.lang.Object... r5) {
        /*
        if (r3 == 0) goto L_0x002c;
    L_0x0002:
        r1 = r3 instanceof java.lang.reflect.Member;	 Catch:{ Exception -> 0x0045 }
        if (r1 == 0) goto L_0x0022;
    L_0x0006:
        r0 = r3;
        r0 = (java.lang.reflect.Member) r0;	 Catch:{ Exception -> 0x0045 }
        r1 = r0;
        r2 = r1.getModifiers();	 Catch:{ Exception -> 0x0045 }
        r2 = java.lang.reflect.Modifier.isPublic(r2);	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0022;
    L_0x0014:
        r1 = r1.getDeclaringClass();	 Catch:{ Exception -> 0x0045 }
        r1 = r1.getModifiers();	 Catch:{ Exception -> 0x0045 }
        r1 = java.lang.reflect.Modifier.isPublic(r1);	 Catch:{ Exception -> 0x0045 }
        if (r1 != 0) goto L_0x002c;
    L_0x0022:
        r1 = r3.isAccessible();	 Catch:{ Exception -> 0x0045 }
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r1 = 1;
        r3.setAccessible(r1);	 Catch:{ Exception -> 0x0045 }
    L_0x002c:
        r1 = r3.getReturnType();	 Catch:{ Exception -> 0x0045 }
        r2 = java.lang.Void.TYPE;	 Catch:{ Exception -> 0x0045 }
        if (r1 != r2) goto L_0x003c;
    L_0x0034:
        r3.invoke(r4, r5);	 Catch:{ Exception -> 0x0045 }
        r1 = cD(r4);	 Catch:{ Exception -> 0x0045 }
    L_0x003b:
        return r1;
    L_0x003c:
        r1 = r3.invoke(r4, r5);	 Catch:{ Exception -> 0x0045 }
        r1 = cD(r1);	 Catch:{ Exception -> 0x0045 }
        goto L_0x003b;
    L_0x0045:
        r1 = move-exception;
        r2 = new a.b;
        r2.<init>(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a(java.lang.reflect.Method, java.lang.Object, java.lang.Object[]):a.a");
    }

    private Class<?> cKk() {
        if (this.ADM) {
            return (Class) this.object;
        }
        return this.object.getClass();
    }

    private static Class<?> Q(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Void.TYPE == cls) {
            return Void.class;
        }
        return cls;
    }
}
