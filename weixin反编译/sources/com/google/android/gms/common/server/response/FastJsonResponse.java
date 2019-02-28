package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface a<I, O> {
        I convertBack(O o);
    }

    public static class Field<I, O> implements SafeParcelable {
        public static final a CREATOR = new a();
        protected final int aOW;
        protected final boolean aOX;
        protected final int aOY;
        protected final boolean aOZ;
        protected final String aPa;
        protected final int aPb;
        protected final Class<? extends FastJsonResponse> aPc;
        protected final String aPd;
        FieldMappingDictionary aPe;
        a<I, O> aPf;
        final int mVersionCode;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            a aVar = null;
            this.mVersionCode = i;
            this.aOW = i2;
            this.aOX = z;
            this.aOY = i3;
            this.aOZ = z2;
            this.aPa = str;
            this.aPb = i4;
            if (str2 == null) {
                this.aPc = null;
                this.aPd = null;
            } else {
                this.aPc = SafeParcelResponse.class;
                this.aPd = str2;
            }
            if (converterWrapper != null) {
                if (converterWrapper.aOQ != null) {
                    aVar = converterWrapper.aOQ;
                } else {
                    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
                }
            }
            this.aPf = aVar;
        }

        public int describeContents() {
            return 0;
        }

        public final int oX() {
            return this.aOW;
        }

        public final boolean oY() {
            return this.aOX;
        }

        public final int oZ() {
            return this.aOY;
        }

        public final boolean pa() {
            return this.aOZ;
        }

        public final String pb() {
            return this.aPa;
        }

        public final int pc() {
            return this.aPb;
        }

        public final Class<? extends FastJsonResponse> pd() {
            return this.aPc;
        }

        final String pe() {
            return this.aPd == null ? null : this.aPd;
        }

        public final Map<String, Field<?, ?>> pf() {
            w.ag(this.aPd);
            w.ag(this.aPe);
            return this.aPe.aP(this.aPd);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.mVersionCode).append(10);
            stringBuilder.append("                 typeIn=").append(this.aOW).append(10);
            stringBuilder.append("            typeInArray=").append(this.aOX).append(10);
            stringBuilder.append("                typeOut=").append(this.aOY).append(10);
            stringBuilder.append("           typeOutArray=").append(this.aOZ).append(10);
            stringBuilder.append("        outputFieldName=").append(this.aPa).append(10);
            stringBuilder.append("      safeParcelFieldId=").append(this.aPb).append(10);
            stringBuilder.append("       concreteTypeName=").append(pe()).append(10);
            if (this.aPc != null) {
                stringBuilder.append("     concreteType.class=").append(this.aPc.getCanonicalName()).append(10);
            }
            stringBuilder.append("          converterName=").append(this.aPf == null ? "null" : this.aPf.getClass().getCanonicalName()).append(10);
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            a.a(this, parcel, i);
        }
    }

    private Object a(Field field) {
        String pb = field.pb();
        if (field.pd() != null) {
            field.pb();
            w.a(oV() == null, "Concrete field shouldn't be value object: %s", field.pb());
            field.pa();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(pb.charAt(0)) + pb.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.pb();
        return oV();
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return field.aPf != null ? field.aPf.convertBack(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.oX() == 11) {
            stringBuilder.append(((FastJsonResponse) field.pd().cast(obj)).toString());
        } else if (field.oX() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(x.aY((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, Field<?, ?>> oU();

    protected abstract Object oV();

    protected abstract boolean oW();

    public String toString() {
        Map oU = oU();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : oU.keySet()) {
            Field field = (Field) oU.get(str);
            if (field.oZ() != 11) {
                field.pb();
                if (oW()) {
                    Object a = a(field, a(field));
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("{");
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\":");
                    if (a != null) {
                        switch (field.oZ()) {
                            case 8:
                                stringBuilder.append("\"").append(s.j((byte[]) a)).append("\"");
                                break;
                            case 9:
                                stringBuilder.append("\"").append(s.k((byte[]) a)).append("\"");
                                break;
                            case 10:
                                y.a(stringBuilder, (HashMap) a);
                                break;
                            default:
                                if (!field.oY()) {
                                    a(stringBuilder, field, a);
                                    break;
                                }
                                a(stringBuilder, field, (ArrayList) a);
                                break;
                        }
                    }
                    stringBuilder.append("null");
                }
            } else if (field.pa()) {
                field.pb();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else {
                field.pb();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
