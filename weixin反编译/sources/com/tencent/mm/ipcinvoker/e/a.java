package com.tencent.mm.ipcinvoker.e;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> gON;
    private String gOO;
    private boolean gOP;
    private Field mField;

    public a(Class<?> cls, String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.gON = cls;
        this.gOO = str;
    }

    private synchronized void prepare() {
        if (!this.gOP) {
            Class cls = this.gON;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.gOO);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
            this.gOP = true;
        }
    }

    private synchronized FieldType BH() {
        FieldType fieldType = null;
        synchronized (this) {
            prepare();
            if (this.mField == null) {
                x.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.gOO);
            } else {
                try {
                    fieldType = this.mField.get(null);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("unable to cast object");
                }
            }
        }
        return fieldType;
    }

    public final synchronized FieldType BI() {
        FieldType fieldType;
        fieldType = null;
        try {
            fieldType = BH();
        } catch (NoSuchFieldException e) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e);
        } catch (IllegalAccessException e2) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e2);
        } catch (IllegalArgumentException e3) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e3);
        }
        return fieldType;
    }
}
