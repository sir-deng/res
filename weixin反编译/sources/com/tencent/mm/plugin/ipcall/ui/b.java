package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    MMActivity fnF;
    String hiw;
    TextView ill;
    a nMJ;
    private DialPad nMK;
    TextView nML;
    EditText nMM;
    View nMN;
    private ImageButton nMO;
    View nMP;
    TextView nMQ;
    TextView nMR;
    private ap nMS;
    String nMT;
    String nMU;
    String nMV = "";
    String nMW;
    LinkedList<byd> nMX;
    long nMY = 0;
    boolean nMZ = false;
    private Runnable nNa = new Runnable() {
        public final void run() {
            if (System.currentTimeMillis() - b.this.nMY >= 500) {
                b.this.nMW = com.tencent.mm.plugin.ipcall.b.a.ak(b.this.fnF, b.this.nMU + b.this.nMV);
                final c Di = i.aUk().Di(b.this.nMW);
                ah.y(new Runnable() {
                    public final void run() {
                        if (Di == null || Di.xrR == -1) {
                            b.this.ill.setText("");
                        } else {
                            b.this.ill.setText(Di.field_systemAddressBookUsername);
                        }
                    }
                });
                return;
            }
            ah.y(new Runnable() {
                public final void run() {
                    b.this.ill.setText("");
                    b.this.nMW = null;
                    b.this.hiw = null;
                }
            });
        }
    };
    private ah nNb = new ah("IPCallDialQueryPhoneNumber");
    boolean nNc = false;
    private TextWatcher nNd = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int measureText;
            if (b.this.nMP.getLayoutParams() != null) {
                int i4;
                Paint paint = b.this.nML.getPaint();
                if ("+".equals(b.this.nML.getText().toString())) {
                    measureText = (int) paint.measureText(b.this.nML.getText().toString());
                    b.this.nMN.setVisibility(8);
                    b.this.nMQ.setVisibility(8);
                    i4 = measureText;
                } else {
                    measureText = (int) paint.measureText(b.this.nML.getText() + "+");
                    b.this.nMN.setVisibility(0);
                    b.this.nMQ.setVisibility(0);
                    i4 = measureText;
                }
                LayoutParams layoutParams = (LayoutParams) b.this.nMP.getLayoutParams();
                layoutParams.width = i4;
                b.this.nMP.setLayoutParams(layoutParams);
            }
            String replace = b.this.nML.getText().toString().replace("+", "");
            if (com.tencent.mm.plugin.ipcall.b.a.DL(replace)) {
                b.this.nMQ.setText(com.tencent.mm.plugin.ipcall.b.a.DI(replace));
                if (b.this.nMX != null && b.this.nMX.size() > 0) {
                    String DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(replace);
                    Iterator it = b.this.nMX.iterator();
                    while (it.hasNext()) {
                        byd byd = (byd) it.next();
                        if (byd != null && byd.hxn.equals(DJ)) {
                            measureText = 1;
                            break;
                        }
                    }
                    measureText = 0;
                }
                measureText = 0;
            } else {
                b.this.nMQ.setText(b.this.fnF.getString(R.l.eqN));
                measureText = 0;
            }
            if (measureText != 0) {
                b.this.nMR.setVisibility(0);
            } else {
                b.this.nMR.setVisibility(8);
            }
            if (b.this.nMJ != null) {
                b.this.nMJ.Dq(replace);
            }
        }

        public final void afterTextChanged(Editable editable) {
            String replace = b.this.nML.getText().toString().replace("+", "");
            if (replace.startsWith("0") || replace.startsWith("*") || replace.startsWith("#")) {
                b.this.nML.setText("+");
                b.this.nMU = "+";
            }
        }
    };
    String nNe = "";

    public interface a {
        void Dq(String str);

        void Dr(String str);

        void i(String str, String str2, String str3, String str4);
    }

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        this.fnF = mMActivity;
        this.nMM = editText;
        this.nML = textView;
        this.nMN = view;
        this.nMK = dialPad;
        this.nMO = imageButton;
        this.ill = textView2;
        this.nMP = view2;
        this.nMQ = textView3;
        this.nMR = textView4;
        this.nMS = new ap();
        this.nMU = com.tencent.mm.plugin.ipcall.b.c.aVu();
        String string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (bi.oN(string)) {
            string = com.tencent.mm.plugin.ipcall.b.a.DI(com.tencent.mm.plugin.ipcall.b.a.aVr());
        }
        this.nMT = string;
        this.nML.addTextChangedListener(this.nNd);
        this.nML.setText("+" + this.nMU);
        this.nMK.nMI = new com.tencent.mm.plugin.ipcall.ui.DialPad.a() {
            public final void Dn(String str) {
                b.this.nMV = b.this.nMM.getText().toString();
                if (b.this.nMZ) {
                    b.this.nMU += str;
                    b.this.nML.setText(b.this.nMU);
                    if (com.tencent.mm.plugin.ipcall.b.a.DL(b.this.nMU.replace("+", "")) || b.this.nMU.replace("+", "").length() >= 4) {
                        g.pWK.h(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        b.this.nMZ = false;
                        b.this.nMT = com.tencent.mm.plugin.ipcall.b.a.DI(b.this.nMU.replace("+", ""));
                        b.this.nMV = b.this.dd(b.this.nMU.replace("+", ""), b.this.nMV);
                        b.this.bx(b.this.nMV, -1);
                        return;
                    }
                    return;
                }
                String replace = b.this.nML.getText().toString().replace("+", "");
                if (b.this.nNc) {
                    StringBuffer stringBuffer = new StringBuffer(b.this.nMV);
                    stringBuffer.insert(b.this.nMM.getSelectionStart(), str);
                    b.this.nMV = stringBuffer.toString();
                } else {
                    b.this.nMV += str;
                }
                if (b.this.nMV.equals("00")) {
                    b.this.nML.setText("+");
                    b.this.nMZ = true;
                    b.this.nMU = "+";
                    b.this.nMV = "";
                }
                if (com.tencent.mm.plugin.ipcall.b.a.DL(b.this.nMU.replace("+", "") + b.this.nMV)) {
                    b.this.nML.setText("+" + b.this.nMU.replace("+", "") + b.this.nMV);
                    b.this.nMT = com.tencent.mm.plugin.ipcall.b.a.DI(b.this.nMU.replace("+", ""));
                    b.this.nMZ = false;
                    b.this.nMU = b.this.nMU.replace("+", "") + b.this.nMV;
                    b.this.nMV = "";
                }
                String str2 = b.this.nMV;
                b.this.nMV = b.this.dd(replace, b.this.nMV);
                if (!b.this.nNc) {
                    b.this.bx(b.this.nMV, -1);
                } else if (str2.length() < b.this.nMV.length()) {
                    b.this.bx(b.this.nMV, b.this.nMM.getSelectionEnd() + 2);
                } else if (str2.length() == b.this.nMV.length()) {
                    b.this.bx(b.this.nMV, b.this.nMM.getSelectionEnd() + 1);
                } else if (str2.length() > b.this.nMV.length()) {
                    b.this.bx(b.this.nMV, (b.this.nMM.getSelectionEnd() + 1) - (str2.length() - b.this.nMV.length()));
                }
                b.this.nMY = System.currentTimeMillis();
                if (b.this.nMV.length() > com.tencent.mm.plugin.ipcall.b.a.nTQ && !bi.oN(b.this.nMU + b.this.nMV)) {
                    b.this.aUS();
                }
            }

            public final void Do(String str) {
                if (str.equals("0")) {
                    b.this.nML.setText("+");
                    b.this.nMZ = true;
                    b.this.nMU = "+";
                }
            }
        };
        this.nMN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String obj = b.this.nMM.getText().toString();
                if (bi.oN(obj)) {
                    obj = b.this.nML.getText().toString();
                    if (!bi.oN(obj)) {
                        Object substring = obj.substring(0, obj.length() - 1);
                        if (bi.oN(substring) || substring.equals("+")) {
                            b.this.nML.setText("+");
                            b.this.nMU = "+";
                            b.this.nMZ = true;
                            return;
                        }
                        b.this.nML.setText(substring);
                        b.this.nMU = substring;
                        return;
                    }
                    return;
                }
                int selectionStart = b.this.nMM.getSelectionStart();
                if (!b.this.nNc || selectionStart - 1 < 0) {
                    obj = obj.substring(0, obj.length() - 1);
                } else {
                    Editable text = b.this.nMM.getText();
                    text.delete(selectionStart - 1, selectionStart);
                    obj = text.toString();
                }
                if (bi.oN(obj)) {
                    b.this.nMV = "";
                    b.this.bx("", -1);
                } else {
                    String replace = b.this.nML.getText().toString().replace("+", "");
                    if (b.this.nNc) {
                        b.this.nMV = b.this.dd(replace, obj);
                        b.this.bx(b.this.nMV, (b.this.nMV.length() - obj.length()) + (selectionStart - 1));
                    } else {
                        b.this.nMV = b.this.dd(replace, obj);
                        b.this.bx(b.this.nMV, -1);
                    }
                    b.this.aUS();
                }
                b.this.nMW = "";
                b.this.ill.setText("");
            }
        });
        this.nMN.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (b.this.nMZ) {
                    b.this.nMU = "+";
                    b.this.nML.setText(b.this.nMU);
                } else {
                    b.this.ill.setText("");
                    b.this.nMV = "";
                    b.this.bx("", -1);
                }
                return true;
            }
        });
        this.nML.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(12061, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                String replace = b.this.nML.getText().toString().replace("+", "");
                Intent intent = new Intent(b.this.fnF, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                b.this.fnF.startActivityForResult(intent, 100);
                b.this.fnF.overridePendingTransition(R.a.bqo, -1);
            }
        });
        this.nMO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b bVar = b.this;
                bVar.nMU = bVar.nML.getText().toString();
                bVar.nMV = bVar.nMM.getText().toString();
                String string;
                if (bi.oN(bVar.nMU) || bi.oN(bVar.nMV)) {
                    string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                    if (!bi.oN(string)) {
                        bVar.nMV = bVar.dd(bVar.nML.getText().toString().replace("+", ""), com.tencent.mm.plugin.ipcall.b.c.DS(string));
                        bVar.bx(bVar.nMV, -1);
                        bVar.aUS();
                        return;
                    }
                    return;
                }
                bVar.nMU = bVar.nML.getText().toString().replace("+", "");
                bVar.nMW = com.tencent.mm.plugin.ipcall.b.a.ak(bVar.fnF, bVar.nMU + bVar.nMV);
                bVar.hiw = com.tencent.mm.plugin.ipcall.b.a.am(bVar.fnF, bVar.nMW);
                string = com.tencent.mm.plugin.ipcall.b.c.DS(bVar.nMV);
                Editor edit = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                edit.putString("IPCall_LastInputPhoneNumber", string);
                edit.apply();
                String charSequence = bVar.nML.getText().toString();
                string = bVar.nMT;
                if (!bi.oN(charSequence)) {
                    if (bi.oN(string)) {
                        string = "";
                    }
                    Editor edit2 = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                    edit2.putString("IPCall_LastInputCountryName", string);
                    edit2.apply();
                }
                if (bVar.nMJ != null) {
                    bVar.nMJ.i(bVar.nMU, com.tencent.mm.plugin.ipcall.b.c.DS(bVar.nMV), bVar.nMW, bVar.hiw);
                }
            }
        });
        this.nMM.setHorizontallyScrolling(true);
        this.nMM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.this.nMM.setCursorVisible(true);
                b.this.fnF.aWY();
                b.this.nNc = true;
            }
        });
        this.nMM.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CharSequence DS = bi.DS(charSequence.toString());
                if (DS.contains(" ")) {
                    DS = DS.replace(" ", "");
                    b.this.nMM.setText(bi.O(DS));
                } else if ((!b.this.nNe.equals(DS) || i3 > 0) && bi.oN(DS)) {
                    b.this.nNe = DS;
                    b.this.nMM.setText("");
                }
                if (com.tencent.mm.plugin.ipcall.b.a.DM(DS)) {
                    String DK = com.tencent.mm.plugin.ipcall.b.a.DK(DS);
                    if (!bi.oN(DK)) {
                        b.this.nML.setText("+" + DK);
                        b.this.nMM.setText(com.tencent.mm.plugin.ipcall.b.a.DP(DS));
                    }
                } else if (!DS.equals(b.this.nNe)) {
                    b.this.nNe = DS;
                    b.this.nMM.setText(DS);
                    if (bi.oN(b.this.nML.getText().toString())) {
                        b.this.nML.setText("+" + com.tencent.mm.plugin.ipcall.b.a.aVr());
                    }
                }
                if (b.this.nMJ != null) {
                    b.this.nMJ.Dr(b.this.nMM.getText().toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        if (d.fN(16)) {
            this.nML.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nMM.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ill.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    public final void Dp(String str) {
        this.nMU = str;
        if (this.nML != null) {
            this.nML.setText("+" + str);
        }
    }

    public final void X(LinkedList<byd> linkedList) {
        int i;
        this.nMX = linkedList;
        String replace = this.nML.getText().toString().replace("+", "");
        if (com.tencent.mm.plugin.ipcall.b.a.DL(replace) && this.nMX != null && this.nMX.size() > 0) {
            String DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(replace);
            Iterator it = this.nMX.iterator();
            while (it.hasNext()) {
                byd byd = (byd) it.next();
                if (byd != null && byd.hxn.equals(DJ)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            this.nMR.setVisibility(0);
        } else {
            this.nMR.setVisibility(8);
        }
    }

    final String dd(String str, String str2) {
        String formatNumber = ap.formatNumber(str, com.tencent.mm.plugin.ipcall.b.c.DS(str2));
        return bi.oN(formatNumber) ? str2 : formatNumber;
    }

    public final void bx(String str, int i) {
        this.nMM.setText(str);
        if (!bi.oN(str)) {
            if (i != -1) {
                if (this.nNc) {
                    if (i > 0 && i <= this.nMM.getText().length()) {
                        this.nMM.setSelection(i);
                    }
                }
            }
            this.nMM.setSelection(this.nMM.getText().length());
        }
        this.nMV = str;
    }

    public final void aUS() {
        this.nNb.cgs().removeCallbacks(this.nNa);
        this.nNb.g(this.nNa, 500);
    }
}
