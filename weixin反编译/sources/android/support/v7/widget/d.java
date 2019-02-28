package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class d extends DataSetObservable {
    private static final String Ef = d.class.getSimpleName();
    private static final Object Oe = new Object();
    private static final Map<String, d> Of = new HashMap();
    private Intent Ks;
    final Object Og;
    final List<a> Oh;
    private final List<c> Oi;
    private final String Oj;
    private b Ok;
    private int Ol;
    private boolean Om;
    private boolean On;
    private boolean Oo;
    private boolean Op;
    private d Oq;
    private final Context mContext;

    public final class a implements Comparable<a> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((a) obj).weight) - Float.floatToIntBits(this.weight);
        }

        public a(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((a) obj).weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface b {
    }

    public static final class c {
        public final ComponentName Os;
        public final long time;
        public final float weight;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.Os = componentName;
            this.time = j;
            this.weight = f;
        }

        public final int hashCode() {
            return (((((this.Os == null ? 0 : this.Os.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.Os == null) {
                if (cVar.Os != null) {
                    return false;
                }
            } else if (!this.Os.equals(cVar.Os)) {
                return false;
            }
            if (this.time != cVar.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(cVar.weight)) {
                return false;
            }
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.Os);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface d {
        boolean en();
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        private e() {
        }

        /* synthetic */ e(d dVar, byte b) {
            this();
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return b(objArr);
        }

        private Void b(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            try {
                OutputStream openFileOutput = d.this.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        c cVar = (c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", cVar.Os.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.time));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    d.this.Om = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    d.Ef;
                    new StringBuilder("Error writing historical recrod file: ").append(d.this.Oj);
                    d.this.Om = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IllegalStateException e4) {
                    d.Ef;
                    new StringBuilder("Error writing historical recrod file: ").append(d.this.Oj);
                    d.this.Om = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    d.Ef;
                    new StringBuilder("Error writing historical recrod file: ").append(d.this.Oj);
                    d.this.Om = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e7) {
                        }
                    }
                } catch (Throwable th) {
                    d.this.Om = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                }
            } catch (FileNotFoundException e9) {
                d.Ef;
            }
            return null;
        }
    }

    public final int eg() {
        int size;
        synchronized (this.Og) {
            ei();
            size = this.Oh.size();
        }
        return size;
    }

    public final ResolveInfo aJ(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.Og) {
            ei();
            resolveInfo = ((a) this.Oh.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.Og) {
            ei();
            List list = this.Oh;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent aK(int i) {
        synchronized (this.Og) {
            if (this.Ks == null) {
                return null;
            }
            ei();
            a aVar = (a) this.Oh.get(i);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.Ks);
            intent.setComponent(componentName);
            if (this.Oq != null) {
                Intent intent2 = new Intent(intent);
                if (this.Oq.en()) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo eh() {
        synchronized (this.Og) {
            ei();
            if (this.Oh.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((a) this.Oh.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.Og) {
            ei();
            size = this.Oi.size();
        }
        return size;
    }

    final void ei() {
        int i;
        int i2 = 1;
        if (!this.Op || this.Ks == null) {
            i = 0;
        } else {
            this.Op = false;
            this.Oh.clear();
            List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.Ks, 0);
            int size = queryIntentActivities.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.Oh.add(new a((ResolveInfo) queryIntentActivities.get(i3)));
            }
            i = 1;
        }
        if (this.Om && this.Oo && !TextUtils.isEmpty(this.Oj)) {
            this.Om = false;
            this.On = true;
            el();
        } else {
            i2 = 0;
        }
        i |= i2;
        ek();
        if (i != 0) {
            ej();
            notifyChanged();
        }
    }

    private boolean ej() {
        if (this.Ok == null || this.Ks == null || this.Oh.isEmpty() || this.Oi.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.Oi);
        return true;
    }

    final boolean a(c cVar) {
        boolean add = this.Oi.add(cVar);
        if (add) {
            this.Oo = true;
            ek();
            if (this.On) {
                if (this.Oo) {
                    this.Oo = false;
                    if (!TextUtils.isEmpty(this.Oj)) {
                        AsyncTask eVar = new e();
                        Object[] objArr = new Object[]{new ArrayList(this.Oi), this.Oj};
                        if (VERSION.SDK_INT >= 11) {
                            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
                        } else {
                            eVar.execute(objArr);
                        }
                    }
                }
                ej();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    private void ek() {
        int size = this.Oi.size() - this.Ol;
        if (size > 0) {
            this.Oo = true;
            for (int i = 0; i < size; i++) {
                this.Oi.remove(0);
            }
        }
    }

    private void el() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.Oj);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.Oi;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next != 1) {
                            if (!(next == 3 || next == 4)) {
                                if ("historical-record".equals(newPullParser.getName())) {
                                    list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                                } else {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                            }
                        } else if (openFileInput != null) {
                            try {
                                openFileInput.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (XmlPullParserException e2) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Oj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                new StringBuilder("Error reading historical recrod file: ").append(this.Oj);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            }
        } catch (FileNotFoundException e7) {
        }
    }
}
