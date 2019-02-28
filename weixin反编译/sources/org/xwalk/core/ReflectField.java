package org.xwalk.core;

import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

public class ReflectField {
    private Class<?> mClass;
    private Field mField;
    private Object mInstance;
    private String mName;

    public ReflectField(Object obj, String str) {
        init(obj, null, str);
    }

    public ReflectField(Class<?> cls, String str) {
        init(null, cls, str);
    }

    public boolean init(Object obj, Class<?> cls, String str) {
        Class cls2;
        this.mInstance = obj;
        if (cls2 == null) {
            cls2 = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls2;
        this.mName = str;
        this.mField = null;
        if (this.mClass == null) {
            return false;
        }
        try {
            this.mField = this.mClass.getField(this.mName);
        } catch (NoSuchFieldException e) {
            Class cls3 = this.mClass;
            while (cls3 != null) {
                try {
                    this.mField = cls3.getDeclaredField(this.mName);
                    this.mField.setAccessible(true);
                    break;
                } catch (NoSuchFieldException e2) {
                    cls3 = cls3.getSuperclass();
                }
            }
        }
        return this.mField != null;
    }

    public Object get() {
        Throwable e;
        if (this.mField == null) {
            throw new UnsupportedOperationException(toString());
        }
        try {
            return this.mField.get(this.mInstance);
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (NullPointerException e3) {
            e = e3;
        } catch (IllegalArgumentException e4) {
            throw e4;
        } catch (Throwable e5) {
            throw new RuntimeException(e5);
        }
        throw new RejectedExecutionException(e5);
    }

    public boolean isNull() {
        return this.mField == null;
    }

    public String toString() {
        if (this.mField != null) {
            return this.mField.toString();
        }
        String str = "";
        if (this.mClass != null) {
            str = str + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            return str + this.mName;
        }
        return str;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }
}
