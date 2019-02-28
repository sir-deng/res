package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.c;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;
import java.util.List;

public class Preference implements Comparable<Preference> {
    private boolean AW;
    public int Kw;
    public String idX;
    public Drawable jY;
    public int ldF;
    public final Context mContext;
    private Bundle mExtras;
    private CharSequence pqE;
    private CharSequence uU;
    private int[] yd;
    private a ysh;
    public b ysi;
    private int ysj;
    private int ysk;
    private int ysl;
    private String ysm;
    boolean ysn;
    private boolean yso;
    public boolean ysp;
    String ysq;
    private Object ysr;
    private boolean yss;
    private boolean yst;
    private int ysu;
    int ysv;
    private boolean ysw;
    private List<Preference> ysx;

    public static class BaseSavedState extends AbsSavedState {
        public static final Creator<BaseSavedState> CREATOR = new Creator<BaseSavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    public interface a {
        boolean a(Preference preference, Object obj);
    }

    public interface b {
        boolean bkg();
    }

    public /* synthetic */ int compareTo(Object obj) {
        int i = 0;
        Preference preference = (Preference) obj;
        if (this.ysj != Integer.MAX_VALUE || (this.ysj == Integer.MAX_VALUE && preference.ysj != Integer.MAX_VALUE)) {
            return this.ysj - preference.ysj;
        }
        if (this.uU == null) {
            return 1;
        }
        if (preference.uU == null) {
            return -1;
        }
        CharSequence charSequence = this.uU;
        CharSequence charSequence2 = preference.uU;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char toLowerCase = Character.toLowerCase(charSequence.charAt(i3));
            i3 = i + 1;
            i = toLowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (i != 0) {
                return i;
            }
            i = i3;
            i3 = i4;
        }
        return length - length2;
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.yd = new int[]{c.title, c.summary};
        this.ysj = Integer.MAX_VALUE;
        this.AW = true;
        this.ysn = true;
        this.ysp = true;
        this.yss = true;
        this.ldF = -1;
        this.yst = true;
        this.ysu = h.dnz;
        this.ysw = false;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fbf, i, 0);
        for (int indexCount = obtainStyledAttributes.getIndexCount(); indexCount >= 0; indexCount--) {
            int index = obtainStyledAttributes.getIndex(indexCount);
            if (index == m.hbf) {
                this.Kw = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == m.hbg) {
                this.idX = obtainStyledAttributes.getString(index);
            } else if (index == m.hbe) {
                this.ysk = obtainStyledAttributes.getResourceId(index, 0);
                this.uU = obtainStyledAttributes.getString(index);
                if (this.ysk != 0) {
                    this.uU = context.getString(this.ysk);
                }
            } else if (index == m.hbd) {
                this.pqE = obtainStyledAttributes.getString(index);
                this.ysl = obtainStyledAttributes.getResourceId(index, 0);
                if (this.ysl != 0) {
                    this.pqE = context.getString(this.ysl);
                }
            } else if (index == m.hbh) {
                this.ysj = obtainStyledAttributes.getInt(index, this.ysj);
            } else if (index == m.hbb) {
                this.ysm = obtainStyledAttributes.getString(index);
            } else if (index == m.hbn) {
                this.ysu = obtainStyledAttributes.getResourceId(index, this.ysu);
            } else if (index == m.hbi) {
                this.ysv = obtainStyledAttributes.getResourceId(index, this.ysv);
            } else if (index == m.hba) {
                this.AW = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.hbj) {
                this.ysn = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == m.hbc) {
                this.ysp = obtainStyledAttributes.getBoolean(index, this.ysp);
            } else if (index == m.hbk) {
                this.ysq = obtainStyledAttributes.getString(index);
            } else if (index == m.hbl) {
                this.ysr = null;
            } else if (index == m.hbm) {
                this.yst = obtainStyledAttributes.getBoolean(index, this.yst);
            }
        }
        obtainStyledAttributes.recycle();
        if (!getClass().getName().startsWith("android.preference")) {
            this.ysw = true;
        }
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842894);
    }

    public Preference(Context context) {
        this(context, null);
    }

    public final Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public final void setLayoutResource(int i) {
        if (i != this.ysu) {
            this.ysw = true;
        }
        this.ysu = i;
    }

    public int getLayoutResource() {
        return this.ysu;
    }

    public final void setWidgetLayoutResource(int i) {
        if (i != this.ysv) {
            this.ysw = true;
        }
        this.ysv = i;
    }

    public View getView(View view, ViewGroup viewGroup) {
        if (view == null) {
            view = onCreateView(viewGroup);
        }
        onBindView(view);
        return view;
    }

    public View onCreateView(ViewGroup viewGroup) {
        LayoutInflater fw = v.fw(this.mContext);
        View inflate = fw.inflate(this.ysu, viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (this.ysv != 0) {
                fw.inflate(this.ysv, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return inflate;
    }

    public void onBindView(View view) {
        int i = 0;
        View findViewById = view.findViewById(g.content);
        if (findViewById != null) {
            findViewById.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.bvS)) * com.tencent.mm.bu.a.ey(this.mContext)));
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
        }
        textView = (TextView) view.findViewById(16908304);
        if (textView != null) {
            if (!TextUtils.isEmpty(getSummary())) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(getSummary());
                if (this.ldF != -1) {
                    textView.setTextColor(this.ldF);
                }
            } else if (textView.getVisibility() != 8) {
                textView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            if (!(this.Kw == 0 && this.jY == null)) {
                if (this.jY == null) {
                    this.jY = this.mContext.getResources().getDrawable(this.Kw);
                }
                if (this.jY != null) {
                    imageView.setImageDrawable(this.jY);
                }
            }
            if (this.jY == null) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
        if (this.yst) {
            m(view, isEnabled());
        }
    }

    private void m(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence == null && this.uU != null) || (charSequence != null && !charSequence.equals(this.uU))) {
            this.ysk = 0;
            this.uU = charSequence;
            notifyChanged();
        }
    }

    public void setTitle(int i) {
        setTitle(this.mContext.getString(i));
        this.ysk = i;
    }

    public CharSequence getTitle() {
        return this.uU;
    }

    public CharSequence getSummary() {
        return this.pqE;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence == null && this.pqE != null) || (charSequence != null && !charSequence.equals(this.pqE))) {
            this.pqE = charSequence;
            notifyChanged();
        }
    }

    public void setSummary(int i) {
        setSummary(this.mContext.getString(i));
    }

    public final void setEnabled(boolean z) {
        if (this.AW != z) {
            this.AW = z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public final boolean isEnabled() {
        return this.AW && this.yss;
    }

    public final void setSelectable(boolean z) {
        if (this.ysn != z) {
            this.ysn = z;
            notifyChanged();
        }
    }

    public final void setKey(String str) {
        this.idX = str;
        if (this.yso) {
            if (!(!TextUtils.isEmpty(this.idX))) {
                if (this.idX == null) {
                    throw new IllegalStateException("Preference does not have a key assigned.");
                }
                this.yso = true;
            }
        }
    }

    public final boolean callChangeListener(Object obj) {
        return this.ysh == null ? true : this.ysh.a(this, obj);
    }

    public void a(a aVar) {
        this.ysh = aVar;
    }

    public void notifyChanged() {
    }

    private void notifyDependencyChange(boolean z) {
        List list = this.ysx;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Preference preference = (Preference) list.get(i);
                if (preference.yss == z) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    preference.yss = z2;
                    preference.notifyDependencyChange(preference.shouldDisableDependents());
                    preference.notifyChanged();
                }
            }
        }
    }

    private boolean shouldDisableDependents() {
        return !isEnabled();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        title = getSummary();
        if (!TextUtils.isEmpty(title)) {
            stringBuilder.append(title).append(' ');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
