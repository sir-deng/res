package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> gDi = new HashMap();
    private static final Map<Class<?>, Object> gDj = new HashMap();
    private static final Map<Class<?>, String> xrQ = new HashMap();

    static {
        try {
            gDi.put(byte[].class, new Object() {
            });
            gDi.put(Short.TYPE, new Object() {
            });
            gDi.put(Short.class, new Object() {
            });
            gDi.put(Boolean.TYPE, new Object() {
            });
            gDi.put(Boolean.class, new Object() {
            });
            gDi.put(Integer.TYPE, new Object() {
            });
            gDi.put(Integer.class, new Object() {
            });
            gDi.put(Float.TYPE, new Object() {
            });
            gDi.put(Float.class, new Object() {
            });
            gDi.put(Double.TYPE, new Object() {
            });
            gDi.put(Double.class, new Object() {
            });
            gDi.put(Long.TYPE, new Object() {
            });
            gDi.put(Long.class, new Object() {
            });
            gDi.put(String.class, new Object() {
            });
            gDj.put(byte[].class, new Object() {
            });
            gDj.put(Short.TYPE, new Object() {
            });
            gDj.put(Short.class, new Object() {
            });
            gDj.put(Boolean.TYPE, new Object() {
            });
            gDj.put(Boolean.class, new Object() {
            });
            gDj.put(Integer.TYPE, new Object() {
            });
            gDj.put(Integer.class, new Object() {
            });
            gDj.put(Float.TYPE, new Object() {
            });
            gDj.put(Float.class, new Object() {
            });
            gDj.put(Double.TYPE, new Object() {
            });
            gDj.put(Double.class, new Object() {
            });
            gDj.put(Long.TYPE, new Object() {
            });
            gDj.put(Long.class, new Object() {
            });
            gDj.put(String.class, new Object() {
            });
            xrQ.put(byte[].class, "BLOB");
            xrQ.put(Short.TYPE, "SHORT");
            xrQ.put(Short.class, "SHORT");
            xrQ.put(Boolean.TYPE, "INTEGER");
            xrQ.put(Boolean.class, "INTEGER");
            xrQ.put(Integer.TYPE, "INTEGER");
            xrQ.put(Integer.class, "INTEGER");
            xrQ.put(Float.TYPE, "FLOAT");
            xrQ.put(Float.class, "FLOAT");
            xrQ.put(Double.TYPE, "DOUBLE");
            xrQ.put(Double.class, "DOUBLE");
            xrQ.put(Long.TYPE, "LONG");
            xrQ.put(Long.class, "LONG");
            xrQ.put(String.class, "TEXT");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static String C(Class<?> cls) {
        return (String) xrQ.get(cls);
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), (byte[]) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), Short.valueOf(field.getShort(obj)));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.b(field), Integer.valueOf(field.getInt(obj)));
            } else {
                contentValues.put(c.b(field), (Integer) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.b(field), Float.valueOf(field.getFloat(obj)));
            } else {
                contentValues.put(c.b(field), (Float) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.b(field), Double.valueOf(field.getDouble(obj)));
            } else {
                contentValues.put(c.b(field), (Double) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.b(field), Long.valueOf(field.getLong(obj)));
            } else {
                contentValues.put(c.b(field), (Long) field.get(obj));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.b(field), (String) field.get(obj));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }
}
