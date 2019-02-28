package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

public class h extends BaseAdapter implements f {
    private final Context context;
    private final SharedPreferences hbz;
    private a yqF;
    private final j yrR;
    private final LinkedList<String> yrS = new LinkedList();
    private final HashMap<String, Preference> yrT = new HashMap();
    private final HashSet<String> yrU = new HashSet();
    private final LinkedList<String> yrV = new LinkedList();
    private final HashMap<String, Integer> yrW = new HashMap();
    private final HashMap<String, String> yrX = new HashMap();
    private int[] yrY = new int[0];
    private boolean yrZ = false;
    private boolean ysa = false;

    public h(Context context, SharedPreferences sharedPreferences) {
        this.yrR = new j(context);
        this.context = context;
        this.hbz = sharedPreferences;
    }

    private static String d(Preference preference) {
        return preference.getClass().getName() + "L" + preference.getLayoutResource() + QLog.TAG_REPORTLEVEL_COLORUSER + preference.ysv;
    }

    private static String e(Preference preference) {
        if (preference.idX == null || preference.idX.length() <= 0) {
            return "_anonymous_pref@" + preference.hashCode();
        }
        return preference.idX;
    }

    public final int indexOf(String str) {
        return this.yrS.indexOf(str);
    }

    public final int Zw(String str) {
        if (this.yrV == null) {
            return -1;
        }
        return this.yrV.indexOf(str);
    }

    public final void a(Preference preference) {
        a(preference, -1);
    }

    public final void b(Preference preference) {
        b(preference, -1);
    }

    public final void a(Preference preference, int i) {
        b(preference, i);
        if (!this.yrZ) {
            notifyDataSetChanged();
        }
    }

    private void b(Preference preference, int i) {
        String e = e(preference);
        this.yrT.put(e, preference);
        LinkedList linkedList = this.yrS;
        if (i == -1) {
            i = this.yrS.size();
        }
        linkedList.add(i, e);
        if (!(this.yrW.containsKey(d(preference)) || this.ysa)) {
            this.yrW.put(d(preference), Integer.valueOf(this.yrW.size()));
        }
        if (preference.ysq != null) {
            this.yrX.put(preference.ysq + "|" + preference.idX, preference.idX);
        }
    }

    public final Preference Zu(String str) {
        return (Preference) this.yrT.get(str);
    }

    public final void bl(String str, boolean z) {
        if (z) {
            if (!this.yrU.contains(str)) {
                this.yrU.add(str);
            } else {
                return;
            }
        } else if (!this.yrU.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    public final boolean c(Preference preference) {
        if (preference == null) {
            return false;
        }
        String e = e(preference);
        this.yrS.remove(e);
        this.yrT.remove(e);
        this.yrU.remove(preference.idX);
        notifyDataSetChanged();
        return true;
    }

    public final boolean Zv(String str) {
        return c(Zu(str));
    }

    public final void removeAll() {
        this.yrV.clear();
        this.yrT.clear();
        this.yrS.clear();
        this.yrU.clear();
        notifyDataSetChanged();
    }

    public final void addPreferencesFromResource(int i) {
        InflateException inflateException;
        this.yrZ = true;
        j jVar = this.yrR;
        XmlPullParser xml = jVar.mContext.getResources().getXml(i);
        try {
            synchronized (jVar.HO) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                jVar.HO[0] = jVar.mContext;
                try {
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new InflateException(xml.getPositionDescription() + ": No start tag found!");
                    }
                    jVar.a(xml.getName(), asAttributeSet);
                    jVar.a(xml, (f) this, asAttributeSet);
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xml.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            }
            this.yrZ = false;
            notifyDataSetChanged();
        } finally {
            xml.close();
        }
    }

    public final void b(a aVar) {
        this.yqF = aVar;
        notifyDataSetChanged();
    }

    private void cre() {
        Collection hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.yrV.size()) {
                Preference preference = (Preference) this.yrT.get(this.yrV.get(i2));
                if ((preference instanceof PreferenceCategory) && bi.oN(preference.idX) && i2 != 0) {
                    Preference preference2 = (Preference) this.yrT.get(this.yrV.get(i2 - 1));
                    if (preference2 instanceof PreferenceCategory) {
                        if (bi.oN(preference2.idX) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                            hashSet.add(e(preference2));
                        } else if (bi.oN(preference.idX) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                            hashSet.add(e(preference));
                        }
                    }
                }
                i = i2 + 1;
            } else {
                this.yrV.removeAll(hashSet);
                return;
            }
        }
    }

    private static boolean Fy(int i) {
        return i == com.tencent.mm.v.a.h.dnz || i == com.tencent.mm.v.a.h.gZC || i == com.tencent.mm.v.a.h.gZE;
    }

    public void notifyDataSetChanged() {
        int i = 0;
        this.yrV.clear();
        Iterator it = this.yrS.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.yrU.contains(str)) {
                if (this.yrT.get(str) == null) {
                    x.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
                } else {
                    this.yrV.add(str);
                }
            }
        }
        if (!this.yrV.isEmpty() && Fy(((Preference) this.yrT.get(this.yrV.get(0))).getLayoutResource())) {
            b(new PreferenceSmallCategory(this.context), 0);
        }
        cre();
        this.yrY = new int[this.yrV.size()];
        if (this.yrY.length > 0) {
            Preference preference;
            int[] iArr;
            if (this.yrY.length == 1) {
                preference = (Preference) this.yrT.get(this.yrV.get(0));
                if (!Fy(((Preference) this.yrT.get(this.yrV.get(0))).getLayoutResource())) {
                    this.yrY[0] = 4;
                } else if (preference instanceof CheckBoxPreference) {
                    iArr = this.yrY;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.yrY[0] = 3;
                }
                a((Preference) this.yrT.get(this.yrV.get(0)), this.hbz);
                super.notifyDataSetChanged();
                return;
            }
            while (i < this.yrV.size()) {
                a((Preference) this.yrT.get(this.yrV.get(i)), this.hbz);
                preference = (Preference) this.yrT.get(this.yrV.get(i));
                int layoutResource = preference.getLayoutResource();
                int layoutResource2;
                if (Fy(layoutResource)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.yrY;
                        iArr[i] = iArr[i] | 8;
                    } else if (i == 0) {
                        iArr = this.yrY;
                        iArr[i] = iArr[i] | 1;
                    } else {
                        if (i == this.yrV.size() - 1) {
                            iArr = this.yrY;
                            iArr[i] = iArr[i] | 2;
                        }
                        layoutResource2 = ((Preference) this.yrT.get(this.yrV.get(i - 1))).getLayoutResource();
                        if (layoutResource2 != com.tencent.mm.v.a.h.dnz || layoutResource2 == com.tencent.mm.v.a.h.gZC || layoutResource2 == com.tencent.mm.v.a.h.gZE) {
                            iArr = this.yrY;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (layoutResource != com.tencent.mm.v.a.h.doc) {
                    iArr = this.yrY;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        layoutResource2 = ((Preference) this.yrT.get(this.yrV.get(i - 1))).getLayoutResource();
                        if (Fy(layoutResource2) || layoutResource2 == com.tencent.mm.v.a.h.doc) {
                            iArr = this.yrY;
                            layoutResource = i - 1;
                            iArr[layoutResource] = iArr[layoutResource] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.yrY;
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr = this.yrY;
                    iArr[i] = iArr[i] | 16;
                    layoutResource2 = ((Preference) this.yrT.get(this.yrV.get(i - 1))).getLayoutResource();
                    if (layoutResource2 == com.tencent.mm.v.a.h.dnz || layoutResource2 == com.tencent.mm.v.a.h.gZC || layoutResource2 == com.tencent.mm.v.a.h.gZE) {
                        iArr = this.yrY;
                        layoutResource = i - 1;
                        iArr[layoutResource] = iArr[layoutResource] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
        }
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.ysp) {
                checkBoxPreference.tYU = sharedPreferences.getBoolean(preference.idX, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.ysp) {
                dialogPreference.setValue(sharedPreferences.getString(preference.idX, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.ysp) {
                editPreference.value = sharedPreferences.getString(preference.idX, null);
                editPreference.setSummary(editPreference.value);
            }
        }
    }

    public int getCount() {
        return this.yrV.size();
    }

    public Object getItem(int i) {
        return this.yrT.get(this.yrV.get(i));
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        if (!this.ysa) {
            this.ysa = true;
        }
        return Math.max(1, this.yrW.size());
    }

    public int getItemViewType(int i) {
        if (i > this.yrV.size()) {
            return -1;
        }
        Integer num = (Integer) this.yrW.get(d((Preference) this.yrT.get(this.yrV.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i <= this.yrV.size()) {
            Preference preference = (Preference) this.yrT.get(this.yrV.get(i));
            if (preference instanceof CheckBoxPreference) {
                preference.a(this.yqF);
            }
            if (!this.yrW.containsKey(d(preference))) {
                view = null;
            }
            view = preference.getView(view, viewGroup);
            int i2 = this.yrY[i];
            View findViewById = view.findViewById(g.content);
            if (findViewById == null) {
                x.d("MicroMsg.MMPreferenceAdapter", "find content view error");
            } else {
                View findViewById2 = view.findViewById(16908312);
                if ((i2 & 4) == 0) {
                    int i3 = 0;
                    int paddingLeft = findViewById.getPaddingLeft();
                    int paddingRight = findViewById.getPaddingRight();
                    int paddingTop = findViewById.getPaddingTop();
                    int paddingBottom = findViewById.getPaddingBottom();
                    int i4 = f.gWI;
                    int paddingLeft2 = view.getPaddingLeft();
                    int paddingRight2 = view.getPaddingRight();
                    int paddingTop2 = view.getPaddingTop();
                    int paddingBottom2 = view.getPaddingBottom();
                    if ((i2 & 8) != 0) {
                        if (i == this.yrV.size() - 1 || (i == this.yrV.size() - 2 && (getItem(this.yrV.size() - 1) instanceof PreferenceCategory))) {
                            i4 = f.bDK;
                        } else if ((i2 & 2) != 0) {
                            i4 = f.bDK;
                        } else {
                            i4 = f.bDq;
                        }
                        i3 = i4;
                        i4 = d.white;
                    } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                        i3 = f.bDq;
                    }
                    findViewById.setBackgroundResource(i3);
                    findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundResource(i3);
                    }
                    view.setBackgroundResource(i4);
                    view.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            }
        }
        return view;
    }
}
