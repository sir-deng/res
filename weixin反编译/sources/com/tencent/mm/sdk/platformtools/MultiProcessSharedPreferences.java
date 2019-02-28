package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.UriMatcher;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {
    private static String AUTHORITY;
    private static volatile Uri AUTHORITY_URI;
    private List<SoftReference<OnSharedPreferenceChangeListener>> eM;
    private BroadcastReceiver jle;
    private Context mContext;
    private int mMode;
    private String mName;
    private boolean xpc;
    private UriMatcher xpd;
    private Map<String, Integer> xpe;

    private static final class a extends MatrixCursor {
        private Bundle vf;

        public a(Bundle bundle) {
            super(new String[0], 0);
            this.vf = bundle;
        }

        public final Bundle getExtras() {
            return this.vf;
        }

        public final Bundle respond(Bundle bundle) {
            this.vf = bundle;
            return this.vf;
        }
    }

    public final class b implements Editor {
        private final Map<String, Object> xoR = new HashMap();
        private boolean xoS = false;

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.xoR.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.xoR.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.xoR.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.xoR.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.xoR.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.xoR.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.xoR.put(str, null);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.xoS = true;
            }
            return this;
        }

        public final void apply() {
            setValue("apply");
        }

        public final boolean commit() {
            return setValue("commit");
        }

        private boolean setValue(String str) {
            if (MultiProcessSharedPreferences.this.xpc) {
                return false;
            }
            boolean z;
            synchronized (MultiProcessSharedPreferences.this) {
                MultiProcessSharedPreferences.this.eN(MultiProcessSharedPreferences.this.mContext);
                String[] strArr = new String[]{String.valueOf(MultiProcessSharedPreferences.this.mMode), String.valueOf(this.xoS)};
                synchronized (this) {
                    if (MultiProcessSharedPreferences.this.mContext.getContentResolver().update(Uri.withAppendedPath(Uri.withAppendedPath(MultiProcessSharedPreferences.AUTHORITY_URI, MultiProcessSharedPreferences.this.mName), str), c.n((HashMap) this.xoR), null, strArr) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private static class c {
        public static ContentValues n(HashMap<String, Object> hashMap) {
            try {
                Constructor declaredConstructor = ContentValues.class.getDeclaredConstructor(new Class[]{HashMap.class});
                declaredConstructor.setAccessible(true);
                return (ContentValues) declaredConstructor.newInstance(new Object[]{hashMap});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            }
        }

        public static Editor a(Editor editor, String str, Set<String> set) {
            try {
                return (Editor) editor.getClass().getDeclaredMethod("putStringSet", new Class[]{String.class, Set.class}).invoke(editor, new Object[]{str, set});
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            }
        }
    }

    private void eN(Context context) {
        if (AUTHORITY_URI == null) {
            String str = null;
            Uri uri = AUTHORITY_URI;
            synchronized (this) {
                if (uri == null) {
                    str = eO(context);
                    uri = Uri.parse("content://" + str);
                }
                if (str == null) {
                    throw new IllegalArgumentException("'AUTHORITY' initialize failed.");
                }
            }
            AUTHORITY = str;
            AUTHORITY_URI = uri;
        }
    }

    private static String eO(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.providers == null) {
            return null;
        }
        for (ProviderInfo providerInfo : packageInfo.providers) {
            if (providerInfo.name.equals(MultiProcessSharedPreferences.class.getName())) {
                return providerInfo.authority;
            }
        }
        return null;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return new MultiProcessSharedPreferences(context, str, i);
    }

    private MultiProcessSharedPreferences(Context context, String str, int i) {
        this.mContext = context;
        this.mName = str;
        this.mMode = i;
        this.xpc = context.getPackageManager().isSafeMode();
    }

    public Map<String, ?> getAll() {
        return (Map) c("getAll", null, null);
    }

    public String getString(String str, String str2) {
        String str3 = (String) c("getString", str, str2);
        return str3 != null ? str3 : str2;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            set2 = (Set) c("getString", str, set);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public int getInt(String str, int i) {
        Integer num = (Integer) c("getInt", str, Integer.valueOf(i));
        return num != null ? num.intValue() : i;
    }

    public long getLong(String str, long j) {
        Long l = (Long) c("getLong", str, Long.valueOf(j));
        return l != null ? l.longValue() : j;
    }

    public float getFloat(String str, float f) {
        Float f2 = (Float) c("getFloat", str, Float.valueOf(f));
        return f2 != null ? f2.floatValue() : f;
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool = (Boolean) c("getBoolean", str, Boolean.valueOf(z));
        return bool != null ? bool.booleanValue() : z;
    }

    public boolean contains(String str) {
        Boolean bool = (Boolean) c("contains", str, null);
        return bool != null ? bool.booleanValue() : false;
    }

    public Editor edit() {
        return new b();
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            if (this.eM == null) {
                this.eM = new ArrayList();
            }
            Boolean bool = (Boolean) c("registerOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (bool != null && bool.booleanValue()) {
                this.eM.add(new SoftReference(onSharedPreferenceChangeListener));
                if (this.jle == null) {
                    this.jle = new BroadcastReceiver() {
                        public final void onReceive(Context context, Intent intent) {
                            List list = (List) intent.getSerializableExtra(Columns.VALUE);
                            if (MultiProcessSharedPreferences.this.mName.equals(intent.getStringExtra("name")) && list != null) {
                                Collection b;
                                synchronized (MultiProcessSharedPreferences.this) {
                                    b = MultiProcessSharedPreferences.this.eM;
                                }
                                List<SoftReference> arrayList = new ArrayList(b);
                                for (int size = list.size() - 1; size >= 0; size--) {
                                    String str = (String) list.get(size);
                                    for (SoftReference softReference : arrayList) {
                                        OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (OnSharedPreferenceChangeListener) softReference.get();
                                        if (onSharedPreferenceChangeListener != null) {
                                            onSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcessSharedPreferences.this, str);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    this.mContext.registerReceiver(this.jle, new IntentFilter(VO(this.mName)));
                }
            }
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            c("unregisterOnSharedPreferenceChangeListener", null, Boolean.valueOf(false));
            if (this.eM != null) {
                List<SoftReference> arrayList = new ArrayList();
                for (SoftReference softReference : this.eM) {
                    OnSharedPreferenceChangeListener onSharedPreferenceChangeListener2 = (OnSharedPreferenceChangeListener) softReference.get();
                    if (onSharedPreferenceChangeListener2 != null && onSharedPreferenceChangeListener2.equals(onSharedPreferenceChangeListener)) {
                        arrayList.add(softReference);
                    }
                }
                for (SoftReference softReference2 : arrayList) {
                    this.eM.remove(softReference2);
                }
                if (this.eM.isEmpty() && this.jle != null) {
                    this.mContext.unregisterReceiver(this.jle);
                    this.jle = null;
                    this.eM = null;
                }
            }
        }
    }

    private Object c(String str, String str2, Object obj) {
        Object obj2 = null;
        if (this.xpc) {
            return null;
        }
        eN(this.mContext);
        Uri withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(AUTHORITY_URI, this.mName), str);
        String[] strArr = new String[3];
        strArr[0] = String.valueOf(this.mMode);
        strArr[1] = str2;
        strArr[2] = obj == null ? null : String.valueOf(obj);
        Cursor query = this.mContext.getContentResolver().query(withAppendedPath, null, null, strArr, null);
        if (query != null) {
            try {
                Bundle extras = query.getExtras();
                if (extras != null) {
                    obj2 = extras.get(Columns.VALUE);
                    extras.clear();
                }
            } catch (Exception e) {
            }
            query.close();
        }
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }

    private static String VO(String str) {
        return String.format("%1$s_%2$s", new Object[]{MultiProcessSharedPreferences.class.getName(), str});
    }

    public boolean onCreate() {
        eN(getContext());
        this.xpd = new UriMatcher(-1);
        this.xpd.addURI(AUTHORITY, "*/getAll", 1);
        this.xpd.addURI(AUTHORITY, "*/getString", 2);
        this.xpd.addURI(AUTHORITY, "*/getInt", 3);
        this.xpd.addURI(AUTHORITY, "*/getLong", 4);
        this.xpd.addURI(AUTHORITY, "*/getFloat", 5);
        this.xpd.addURI(AUTHORITY, "*/getBoolean", 6);
        this.xpd.addURI(AUTHORITY, "*/contains", 7);
        this.xpd.addURI(AUTHORITY, "*/apply", 8);
        this.xpd.addURI(AUTHORITY, "*/commit", 9);
        this.xpd.addURI(AUTHORITY, "*/registerOnSharedPreferenceChangeListener", 10);
        this.xpd.addURI(AUTHORITY, "*/unregisterOnSharedPreferenceChangeListener", 11);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        boolean z = true;
        boolean z2 = false;
        String str3 = (String) uri.getPathSegments().get(0);
        int parseInt = Integer.parseInt(strArr2[0]);
        String str4 = strArr2[1];
        String str5 = strArr2[2];
        Bundle bundle = new Bundle();
        Integer num;
        Integer num2;
        switch (this.xpd.match(uri)) {
            case 1:
                bundle.putSerializable(Columns.VALUE, (HashMap) getContext().getSharedPreferences(str3, parseInt).getAll());
                break;
            case 2:
                bundle.putString(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getString(str4, str5));
                break;
            case 3:
                bundle.putInt(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getInt(str4, Integer.parseInt(str5)));
                break;
            case 4:
                bundle.putLong(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getLong(str4, Long.parseLong(str5)));
                break;
            case 5:
                bundle.putFloat(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getFloat(str4, Float.parseFloat(str5)));
                break;
            case 6:
                bundle.putBoolean(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).getBoolean(str4, Boolean.parseBoolean(str5)));
                break;
            case 7:
                bundle.putBoolean(Columns.VALUE, getContext().getSharedPreferences(str3, parseInt).contains(str4));
                break;
            case 10:
                cgD();
                num = (Integer) this.xpe.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) + 1;
                this.xpe.put(str3, Integer.valueOf(parseInt));
                num2 = (Integer) this.xpe.get(str3);
                str4 = Columns.VALUE;
                if (parseInt == (num2 == null ? 0 : num2.intValue())) {
                    z2 = true;
                }
                bundle.putBoolean(str4, z2);
                break;
            case 11:
                cgD();
                num = (Integer) this.xpe.get(str3);
                parseInt = (num == null ? 0 : num.intValue()) - 1;
                if (parseInt > 0) {
                    this.xpe.put(str3, Integer.valueOf(parseInt));
                    num2 = (Integer) this.xpe.get(str3);
                    str4 = Columns.VALUE;
                    if (parseInt != (num2 == null ? 0 : num2.intValue())) {
                        z = false;
                    }
                    bundle.putBoolean(str4, z);
                    break;
                }
                this.xpe.remove(str3);
                String str6 = Columns.VALUE;
                if (this.xpe.containsKey(str3)) {
                    z = false;
                }
                bundle.putBoolean(str6, z);
                break;
            default:
                throw new IllegalArgumentException("This is Unknown Uri：" + uri);
        }
        return new a(bundle);
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("No external call");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external insert");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external delete");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r13, android.content.ContentValues r14, java.lang.String r15, java.lang.String[] r16) {
        /*
        r12 = this;
        r6 = 0;
        r0 = r13.getPathSegments();
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = 0;
        r1 = r16[r1];
        r1 = java.lang.Integer.parseInt(r1);
        r2 = r12.getContext();
        r7 = r2.getSharedPreferences(r0, r1);
        r1 = r12.xpd;
        r8 = r1.match(r13);
        switch(r8) {
            case 8: goto L_0x003a;
            case 9: goto L_0x003a;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "This is Unknown Uri：";
        r1.<init>(r2);
        r1 = r1.append(r13);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x003a:
        r1 = r12.xpe;
        if (r1 == 0) goto L_0x009c;
    L_0x003e:
        r1 = r12.xpe;
        r1 = r1.get(r0);
        if (r1 == 0) goto L_0x009c;
    L_0x0046:
        r1 = r12.xpe;
        r1 = r1.get(r0);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r1 <= 0) goto L_0x009c;
    L_0x0054:
        r1 = 1;
        r3 = r1;
    L_0x0056:
        r2 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        if (r3 == 0) goto L_0x0196;
    L_0x005e:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r1 = r7.getAll();
        r4 = r1;
        r5 = r2;
    L_0x0069:
        r7 = r7.edit();
        r1 = 1;
        r1 = r16[r1];
        r1 = java.lang.Boolean.parseBoolean(r1);
        if (r1 == 0) goto L_0x00a2;
    L_0x0076:
        if (r3 == 0) goto L_0x009f;
    L_0x0078:
        if (r4 == 0) goto L_0x009f;
    L_0x007a:
        r1 = r4.isEmpty();
        if (r1 != 0) goto L_0x009f;
    L_0x0080:
        r1 = r4.entrySet();
        r2 = r1.iterator();
    L_0x0088:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x009f;
    L_0x008e:
        r1 = r2.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getKey();
        r5.add(r1);
        goto L_0x0088;
    L_0x009c:
        r1 = 0;
        r3 = r1;
        goto L_0x0056;
    L_0x009f:
        r7.clear();
    L_0x00a2:
        r1 = r14.valueSet();
        r9 = r1.iterator();
    L_0x00aa:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x0142;
    L_0x00b0:
        r1 = r9.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r10 = r1 instanceof com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.b;
        if (r10 != 0) goto L_0x00c6;
    L_0x00c4:
        if (r1 != 0) goto L_0x00e0;
    L_0x00c6:
        r7.remove(r2);
        if (r3 == 0) goto L_0x00d6;
    L_0x00cb:
        if (r4 == 0) goto L_0x00d6;
    L_0x00cd:
        r10 = r4.containsKey(r2);
        if (r10 == 0) goto L_0x00d6;
    L_0x00d3:
        r5.add(r2);
    L_0x00d6:
        r10 = r1 instanceof java.lang.String;
        if (r10 == 0) goto L_0x00fe;
    L_0x00da:
        r1 = (java.lang.String) r1;
        r7.putString(r2, r1);
        goto L_0x00aa;
    L_0x00e0:
        if (r3 == 0) goto L_0x00d6;
    L_0x00e2:
        if (r4 == 0) goto L_0x00d6;
    L_0x00e4:
        r10 = r4.containsKey(r2);
        if (r10 == 0) goto L_0x00fa;
    L_0x00ea:
        r10 = r4.containsKey(r2);
        if (r10 == 0) goto L_0x00d6;
    L_0x00f0:
        r10 = r4.get(r2);
        r10 = r1.equals(r10);
        if (r10 != 0) goto L_0x00d6;
    L_0x00fa:
        r5.add(r2);
        goto L_0x00d6;
    L_0x00fe:
        r10 = r1 instanceof java.util.Set;
        if (r10 == 0) goto L_0x0108;
    L_0x0102:
        r1 = (java.util.Set) r1;
        com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.c.a(r7, r2, r1);
        goto L_0x00aa;
    L_0x0108:
        r10 = r1 instanceof java.lang.Integer;
        if (r10 == 0) goto L_0x0116;
    L_0x010c:
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r7.putInt(r2, r1);
        goto L_0x00aa;
    L_0x0116:
        r10 = r1 instanceof java.lang.Long;
        if (r10 == 0) goto L_0x0124;
    L_0x011a:
        r1 = (java.lang.Long) r1;
        r10 = r1.longValue();
        r7.putLong(r2, r10);
        goto L_0x00aa;
    L_0x0124:
        r10 = r1 instanceof java.lang.Float;
        if (r10 == 0) goto L_0x0133;
    L_0x0128:
        r1 = (java.lang.Float) r1;
        r1 = r1.floatValue();
        r7.putFloat(r2, r1);
        goto L_0x00aa;
    L_0x0133:
        r10 = r1 instanceof java.lang.Boolean;
        if (r10 == 0) goto L_0x00aa;
    L_0x0137:
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        r7.putBoolean(r2, r1);
        goto L_0x00aa;
    L_0x0142:
        if (r3 == 0) goto L_0x014f;
    L_0x0144:
        r1 = r5.isEmpty();
        if (r1 == 0) goto L_0x014f;
    L_0x014a:
        r0 = 1;
    L_0x014b:
        r14.clear();
        return r0;
    L_0x014f:
        switch(r8) {
            case 8: goto L_0x0154;
            case 9: goto L_0x018a;
            default: goto L_0x0152;
        };
    L_0x0152:
        r0 = r6;
        goto L_0x014b;
    L_0x0154:
        r1 = r7.getClass();	 Catch:{ IllegalArgumentException -> 0x016e, IllegalAccessException -> 0x0175, InvocationTargetException -> 0x017c, NoSuchMethodException -> 0x0183 }
        r2 = "apply";
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ IllegalArgumentException -> 0x016e, IllegalAccessException -> 0x0175, InvocationTargetException -> 0x017c, NoSuchMethodException -> 0x0183 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ IllegalArgumentException -> 0x016e, IllegalAccessException -> 0x0175, InvocationTargetException -> 0x017c, NoSuchMethodException -> 0x0183 }
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalArgumentException -> 0x016e, IllegalAccessException -> 0x0175, InvocationTargetException -> 0x017c, NoSuchMethodException -> 0x0183 }
        r1.invoke(r7, r2);	 Catch:{ IllegalArgumentException -> 0x016e, IllegalAccessException -> 0x0175, InvocationTargetException -> 0x017c, NoSuchMethodException -> 0x0183 }
        r1 = 1;
        r12.j(r0, r5);
        r0 = r1;
        goto L_0x014b;
    L_0x016e:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0175:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x017c:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0183:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x018a:
        r1 = r7.commit();
        if (r1 == 0) goto L_0x0152;
    L_0x0190:
        r1 = 1;
        r12.j(r0, r5);
        r0 = r1;
        goto L_0x014b;
    L_0x0196:
        r4 = r1;
        r5 = r2;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public void onLowMemory() {
        if (this.xpe != null) {
            this.xpe.clear();
        }
        super.onLowMemory();
    }

    public void onTrimMemory(int i) {
        if (this.xpe != null) {
            this.xpe.clear();
        }
        super.onTrimMemory(i);
    }

    private void cgD() {
        if (this.xpe == null) {
            this.xpe = new HashMap();
        }
    }

    private void j(String str, ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction(VO(str));
            intent.setPackage(getContext().getPackageName());
            intent.putExtra("name", str);
            intent.putExtra(Columns.VALUE, arrayList);
            getContext().sendBroadcast(intent);
        }
    }
}
