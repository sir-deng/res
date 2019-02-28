package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private int gravity;
    private TextView ill;
    private int imeOptions;
    private int inputType;
    private OnFocusChangeListener ipj;
    ImageView ipm;
    private String ipn;
    String ipo;
    int ipp;
    public boolean ipr;
    boolean ipt;
    private int ipu;
    private int ipv;
    b pHX;
    AutoCompleteTextView pHY;
    boolean pHZ;
    private a pIa;
    private boolean pIb;
    private List<String[]> pIc;
    private com.tencent.mm.plugin.recharge.model.a pId;
    private Runnable pIe;
    private boolean pIf;
    private int pIg;

    private class a extends BaseAdapter implements Filterable {
        public List<com.tencent.mm.plugin.recharge.model.a> pIi;
        public boolean pIj;
        private List<com.tencent.mm.plugin.recharge.model.a> pIk;
        private a pIl;
        private String pIm;

        private class a extends Filter {
            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults;
                FilterResults filterResults2 = new FilterResults();
                List arrayList = new ArrayList();
                String II = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.II(charSequence.toString()) : "";
                if (II.equals(a.this.pIm)) {
                    MallEditText.this.pHY.post(new Runnable() {
                        public final void run() {
                            MallEditText.this.pHY.dismissDropDown();
                        }
                    });
                    filterResults = filterResults2;
                } else {
                    final com.tencent.mm.plugin.recharge.model.a aVar;
                    boolean z;
                    boolean z2;
                    a.this.pIm = II;
                    if (MallEditText.this.XX()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : a.this.pIk) {
                            if (aVar2.pHq.equals(a.this.pIm)) {
                                aVar2.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                                arrayList.clear();
                                arrayList.add(aVar2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (MallEditText.this.pIc == null) {
                                try {
                                    MallEditText.this.pIc = com.tencent.mm.pluginsdk.a.bW(MallEditText.this.getContext());
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                                }
                            }
                            if (MallEditText.this.pIc != null) {
                                for (String[] strArr : MallEditText.this.pIc) {
                                    String II2 = com.tencent.mm.plugin.recharge.model.b.II(strArr[2]);
                                    Object dS = dS(a.this.pIm, II2);
                                    if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(dS)) {
                                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(II2, strArr[1], 1);
                                        aVar3.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                                        arrayList.clear();
                                        arrayList.add(aVar3);
                                        break;
                                    } else if (!com.tencent.mm.plugin.recharge.model.a.pHp.equals(dS) && arrayList.size() < 5) {
                                        com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(II2, strArr[1], 1);
                                        aVar4.pHs = dS;
                                        arrayList.add(aVar4);
                                    }
                                }
                            }
                        }
                        x.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (bi.oN(a.this.pIm)) {
                        arrayList.addAll(a.this.pIk);
                        z = false;
                    } else {
                        x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar22 : a.this.pIk) {
                            if (aVar22.pHq.startsWith(a.this.pIm)) {
                                arrayList.add(aVar22);
                            }
                        }
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        MallEditText.this.pHY.post(new Runnable() {
                            public final void run() {
                                MallEditText.this.pHY.dismissDropDown();
                            }
                        });
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && MallEditText.this.XX()) {
                            aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                            if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(aVar22.pHs)) {
                                MallEditText.this.pHY.post(new Runnable() {
                                    public final void run() {
                                        MallEditText.this.pId = aVar22;
                                        if (bi.oN(MallEditText.this.pId.name)) {
                                            MallEditText.this.ill.setText("");
                                            MallEditText.this.ill.setVisibility(8);
                                        } else {
                                            MallEditText.this.ill.setText(MallEditText.this.pId.name);
                                            MallEditText.this.ill.setVisibility(0);
                                        }
                                        MallEditText.this.pHY.dismissDropDown();
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List list = a.this.pIi;
                    a.this.pIi = arrayList;
                    a.this.pIj = z2;
                    filterResults2.count = a.this.pIi.size();
                    filterResults2.values = a.this.pIi;
                    x.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            }

            private static int[] dS(String str, String str2) {
                if (str.equals(str2)) {
                    return com.tencent.mm.plugin.recharge.model.a.pHo;
                }
                if (str2 != null && str.length() == str2.length()) {
                    int[] iArr = new int[]{-1, -1};
                    int i = 0;
                    for (int length = str.length() - 1; length > 0; length--) {
                        if (str2.charAt(length) != str.charAt(length)) {
                            i++;
                            if (i > 2) {
                                break;
                            }
                            iArr[i - 1] = length;
                        }
                    }
                    if (i <= 2) {
                        return iArr;
                    }
                }
                return com.tencent.mm.plugin.recharge.model.a.pHp;
            }
        }

        private a() {
            this.pIi = new ArrayList();
            this.pIj = false;
        }

        /* synthetic */ a(MallEditText mallEditText, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return vD(i);
        }

        public final void bv(List<com.tencent.mm.plugin.recharge.model.a> list) {
            this.pIk = list;
            this.pIi.clear();
            this.pIj = false;
        }

        public final Filter getFilter() {
            x.d("MicroMsg.MallEditText", "getFilter");
            if (this.pIl == null) {
                this.pIl = new a();
            }
            return this.pIl;
        }

        public final int getCount() {
            if (this.pIj) {
                return this.pIi.size() + 2;
            }
            return this.pIi.size() > 0 ? this.pIi.size() + 1 : 0;
        }

        public final synchronized com.tencent.mm.plugin.recharge.model.a vD(int i) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                if (this.pIj) {
                    if (i != 0) {
                        if (i <= this.pIi.size()) {
                            aVar = (com.tencent.mm.plugin.recharge.model.a) this.pIi.get(i - 1);
                        }
                    }
                } else if (i < this.pIi.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.pIi.get(i);
                }
            }
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    c cVar;
                    if (view == null) {
                        view = View.inflate(MallEditText.this.getContext(), g.uKs, null);
                        c cVar2 = new c(MallEditText.this, (byte) 0);
                        cVar2.pIq = (TextView) view.findViewById(f.uwC);
                        cVar2.ipR = (TextView) view.findViewById(f.uwB);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a vD = vD(i);
                    if (vD == null || cVar == null || cVar.pIq == null || cVar.ipR == null) {
                        return view;
                    }
                    CharSequence IJ = com.tencent.mm.plugin.recharge.model.b.IJ(vD.pHq);
                    x.d("MicroMsg.MallEditText", "record.record " + IJ + ", record.name " + vD.name);
                    if (com.tencent.mm.plugin.recharge.model.a.pHo.equals(vD.pHs)) {
                        cVar.pIq.setText(IJ);
                    } else {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(IJ);
                        for (int i2 : vD.pHs) {
                            int i22;
                            if (i22 >= 0) {
                                if (i22 >= 7) {
                                    i22 += 2;
                                } else if (i22 >= 3) {
                                    i22++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                            }
                        }
                        cVar.pIq.setText(spannableStringBuilder);
                    }
                    if (vD.name == null || bi.oN(vD.name.trim())) {
                        cVar.ipR.setText("");
                    } else {
                        cVar.ipR.setText(MallEditText.this.getResources().getString(i.uSA, new Object[]{vD.name}));
                    }
                    view.setBackgroundResource(e.bBy);
                    return view;
                case 1:
                    view = View.inflate(MallEditText.this.getContext(), g.uKt, null);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.plugin.recharge.a.a.bmX().bv(null);
                            MallEditText.this.b(null);
                            MallEditText.this.pIa.bv(new LinkedList());
                            MallEditText.this.pIa.notifyDataSetChanged();
                        }
                    });
                    return view;
                case 2:
                    view = View.inflate(MallEditText.this.getContext(), g.uKr, null);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            MallEditText.this.pHY.dismissDropDown();
                        }
                    });
                    return view;
                case 3:
                    View inflate = View.inflate(MallEditText.this.getContext(), g.uKt, null);
                    ((TextView) inflate).setText(i.uSr);
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            MallEditText.this.pHY.dismissDropDown();
                        }
                    });
                    return inflate;
                default:
                    return view;
            }
        }

        public final int getItemViewType(int i) {
            if (this.pIj) {
                if (i == 0) {
                    return 2;
                }
                if (i > this.pIi.size()) {
                    return 3;
                }
                return 0;
            } else if (i >= this.pIi.size()) {
                return 1;
            } else {
                return 0;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    private class c {
        TextView ipR;
        TextView pIq;

        private c() {
        }

        /* synthetic */ c(MallEditText mallEditText, byte b) {
            this();
        }
    }

    public interface b {
        void bnd();

        void hB(boolean z);
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.pIa = null;
        this.ipn = "";
        this.ipo = "";
        this.inputType = 1;
        this.pIb = true;
        this.ipv = -1;
        this.ipu = 1;
        this.gravity = 19;
        this.ipp = -1;
        this.ipt = false;
        this.pId = null;
        this.ipr = true;
        this.pIe = null;
        this.pIf = false;
        this.pIg = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.vfz, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(k.vfG, 0);
        if (resourceId != 0) {
            this.ipn = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.vfH, 0);
        if (resourceId != 0) {
            this.ipo = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(k.vfE, 1);
        this.ipr = obtainStyledAttributes.getBoolean(k.vfD, true);
        this.gravity = obtainStyledAttributes.getInt(k.vfA, 19);
        this.pIb = obtainStyledAttributes.getBoolean(k.vfB, true);
        this.ipv = obtainStyledAttributes.getInteger(k.vfC, -1);
        this.ipp = obtainStyledAttributes.getInteger(k.vfI, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(k.vfF, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(g.uKq, this, true);
        this.ill = (TextView) inflate.findViewById(f.cUx);
        this.pHY = (AutoCompleteTextView) inflate.findViewById(f.coC);
        if (com.tencent.mm.bu.a.ez(context)) {
            this.pHY.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(d.bvL)) * 1.25f);
        } else {
            this.pHY.setTextSize(0, (float) com.tencent.mm.bu.a.aa(context, d.bvL));
        }
        this.ipm = (ImageView) inflate.findViewById(f.cpP);
        x.d("MicroMsg.MallEditText", "setFormat editType:" + this.ipp);
        this.pHY.setImeOptions(this.imeOptions);
        switch (this.ipp) {
            case 0:
                if (!this.ipr) {
                    this.ipm.setImageResource(e.ujH);
                    this.ipm.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.ipu = 13;
                this.ipv = 13;
                this.inputType = 2;
                vC(e.ukc);
                this.ipm.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.pHY.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = MallEditText.this.pHY.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > MallEditText.this.pIg) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < MallEditText.this.pIg && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    MallEditText.this.pIg = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (charSequence2.equals(str3)) {
                    MallEditText.this.bnb();
                    return;
                }
                MallEditText.this.pHY.setText(str3);
                if (i4 < MallEditText.this.pIg) {
                    MallEditText.this.pHY.setSelection(i4);
                } else {
                    MallEditText.this.pHY.setSelection(MallEditText.this.pIg);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.pHY.setOnFocusChangeListener(this);
        if (!bi.oN(this.ipn)) {
            this.pHY.setHint(this.ipn);
        }
        if (this.inputType == 2) {
            this.pHY.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.pHY.setInputType(this.inputType);
            this.pHY.setRawInputType(this.inputType);
        }
        this.pHY.setGravity(this.gravity);
        if (!this.pIb) {
            this.pHY.setEnabled(false);
            this.pHY.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.black));
            this.pHY.setFocusable(false);
            this.pHY.setClickable(false);
        }
        if (this.ipr) {
            this.ipt = false;
        } else {
            this.ipt = true;
            this.pHY.setEnabled(false);
            this.pHY.setFocusable(false);
            this.pHY.setClickable(false);
        }
        if (this.ipv != -1) {
            this.pHY.setFilters(new InputFilter[]{new LengthFilter(this.ipv)});
        }
        x.d("MicroMsg.MallEditText", "initData editType:" + this.ipp);
        switch (this.ipp) {
            case 1:
                x.d("MicroMsg.MallEditText", "setMobileEditTv");
                List bmY = com.tencent.mm.plugin.recharge.a.a.bmX().bmY();
                this.pIa = new a();
                this.pIa.bv(bmY);
                if (bmY != null && bmY.size() > 0) {
                    this.pId = (com.tencent.mm.plugin.recharge.model.a) bmY.get(0);
                    b(this.pId);
                } else if (this.pIc == null) {
                    new Runnable() {
                        public final void run() {
                            try {
                                MallEditText.this.pIc = com.tencent.mm.pluginsdk.a.bW(MallEditText.this.getContext());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                            }
                        }
                    }.run();
                }
                if (bmY == null || bmY.size() == 0) {
                    com.tencent.mm.kernel.g.Dr();
                    this.pHY.setText((String) com.tencent.mm.kernel.g.Dq().Db().get(6, null));
                    this.pHY.setSelection(this.pHY.getText().length());
                    bnb();
                }
                this.pHY.setAdapter(this.pIa);
                this.pHY.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        MallEditText.this.pId = MallEditText.this.pIa.vD(i);
                        if (MallEditText.this.pId != null) {
                            x.d("MicroMsg.MallEditText", "onItemClick record.record " + MallEditText.this.pId.pHq + ", record.name " + MallEditText.this.pId.name);
                            MallEditText.this.b(MallEditText.this.pId);
                        }
                        MallEditText.this.pHY.dismissDropDown();
                    }
                });
                return;
            default:
                return;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void vC(int i) {
        this.pHZ = i == e.bDp;
        this.ipm.setImageResource(i);
    }

    public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.pId = aVar;
        if (aVar != null) {
            this.pHY.setText(aVar.pHq);
            this.pHY.setSelection(this.pHY.getText().length());
            bnb();
            x.d("MicroMsg.MallEditText", "editTv.setText " + aVar.pHq + ", name " + aVar.name + ", isInputValid " + this.ipt);
            if (bi.oN(aVar.name) || !this.ipt) {
                this.ill.setText("");
                this.ill.setVisibility(8);
                return;
            }
            this.ill.setText(aVar.name);
            this.ill.setVisibility(0);
            return;
        }
        this.pHY.setText("");
        bnb();
        x.d("MicroMsg.MallEditText", "editTv.setText null");
        this.ill.setText("");
        this.ill.setVisibility(8);
    }

    private void bnb() {
        boolean XX = XX();
        if (XX != this.ipt) {
            x.d("MicroMsg.MallEditText", "View:" + this.ipo + ", editType:" + this.ipp + " inputValid change to " + XX);
            this.ipt = XX;
            if (this.pHX != null) {
                this.pHX.hB(this.ipt);
            }
            if (!XX) {
                if (this.ill.getVisibility() == 0) {
                    this.ill.setText("");
                    this.ill.setVisibility(8);
                }
                this.pId = null;
            }
        }
        if (this.pHX != null) {
            this.pHX.bnd();
        }
    }

    public final String getText() {
        switch (this.ipp) {
            case 1:
                return bi.aD(this.pHY.getText().toString(), "");
            default:
                return bi.aD(this.pHY.getText().toString(), "");
        }
    }

    public final boolean XX() {
        switch (this.ipp) {
            case 1:
                String obj = this.pHY.getText().toString();
                if (obj.length() < this.ipu || obj.length() > this.ipv || !PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.II(obj))) {
                    return false;
                }
                return true;
            default:
                if (this.pHY.getText().length() >= this.ipu) {
                    return true;
                }
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ipr) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.pHY.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.ipj = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.ipj != null) {
            this.ipj.onFocusChange(this, z);
        }
        if (!((!this.pIf) != z || z || this.pIe == null)) {
            this.pIe.run();
        }
        this.pIf = z;
        x.d("MicroMsg.MallEditText", "View:" + this.ipo + ", editType:" + this.ipp + " onFocusChange to " + z);
        if (this.pHX != null) {
            this.pHX.hB(this.ipt);
        }
    }

    public final com.tencent.mm.plugin.recharge.model.a bnc() {
        if (this.pId != null) {
            return this.pId;
        }
        this.pId = new com.tencent.mm.plugin.recharge.model.a(getText(), this.ill.getText().toString(), 0);
        return this.pId;
    }
}
