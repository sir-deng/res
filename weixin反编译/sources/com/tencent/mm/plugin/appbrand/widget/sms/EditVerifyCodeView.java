package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.x;

public class EditVerifyCodeView extends RelativeLayout {
    private EditText kT;
    private ImageView[] klZ;
    private TextView[] kma;
    OnKeyListener kmb;
    public StringBuilder mBuilder;
    private Context mContext;

    static /* synthetic */ void b(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length > 0 && length <= 6) {
            editVerifyCodeView.kma[length - 1].setVisibility(0);
            editVerifyCodeView.kma[length - 1].setText(String.valueOf(stringBuilder.charAt(length - 1)));
            editVerifyCodeView.klZ[length - 1].setVisibility(4);
        }
    }

    static /* synthetic */ void c(EditVerifyCodeView editVerifyCodeView) {
        String stringBuilder = editVerifyCodeView.mBuilder.toString();
        x.i("MicroMsg.EditVerifyCodeView", "del before str:" + editVerifyCodeView.mBuilder);
        int length = stringBuilder.length();
        if (length != 0) {
            if (length > 0 && length <= 6) {
                editVerifyCodeView.mBuilder.delete(length - 1, length);
            }
            editVerifyCodeView.kma[length - 1].setVisibility(4);
            editVerifyCodeView.kma[length - 1].setText("");
            editVerifyCodeView.klZ[length - 1].setVisibility(0);
            x.i("MicroMsg.EditVerifyCodeView", "del after str:" + editVerifyCodeView.mBuilder);
        }
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBuilder = new StringBuilder();
        this.klZ = new ImageView[6];
        this.kma = new TextView[6];
        this.kmb = new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67 || keyEvent.getAction() != 1) {
                    return false;
                }
                EditVerifyCodeView.c(EditVerifyCodeView.this);
                return true;
            }
        };
        init(context);
    }

    public EditVerifyCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBuilder = new StringBuilder();
        this.klZ = new ImageView[6];
        this.kma = new TextView[6];
        this.kmb = /* anonymous class already generated */;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(h.iAe, null);
        TextView textView = (TextView) inflate.findViewById(g.ixR);
        TextView textView2 = (TextView) inflate.findViewById(g.ixS);
        TextView textView3 = (TextView) inflate.findViewById(g.ixT);
        TextView textView4 = (TextView) inflate.findViewById(g.ixU);
        TextView textView5 = (TextView) inflate.findViewById(g.ixV);
        this.kma[0] = (TextView) inflate.findViewById(g.ixQ);
        this.kma[1] = textView;
        this.kma[2] = textView2;
        this.kma[3] = textView3;
        this.kma[4] = textView4;
        this.kma[5] = textView5;
        ImageView imageView = (ImageView) inflate.findViewById(g.ixL);
        ImageView imageView2 = (ImageView) inflate.findViewById(g.ixM);
        ImageView imageView3 = (ImageView) inflate.findViewById(g.ixN);
        ImageView imageView4 = (ImageView) inflate.findViewById(g.ixO);
        ImageView imageView5 = (ImageView) inflate.findViewById(g.ixP);
        this.klZ[0] = (ImageView) inflate.findViewById(g.ixK);
        this.klZ[1] = imageView;
        this.klZ[2] = imageView2;
        this.klZ[3] = imageView3;
        this.klZ[4] = imageView4;
        this.klZ[5] = imageView5;
        this.kT = (EditText) inflate.findViewById(g.iyY);
        this.kT.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() != 0) {
                    x.i("MicroMsg.EditVerifyCodeView", "afterTextChanged:%s", editable.toString());
                    if (EditVerifyCodeView.this.mBuilder.length() < 6) {
                        EditVerifyCodeView.this.mBuilder.append(editable.toString());
                        EditVerifyCodeView.b(EditVerifyCodeView.this);
                    }
                    editable.delete(0, editable.length());
                }
            }
        });
        this.kT.setKeyListener(new NumberKeyListener() {
            protected final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            }

            public final int getInputType() {
                return 3;
            }
        });
        this.kT.setOnKeyListener(this.kmb);
        addView(inflate, new LayoutParams(-1, -1));
    }

    public final void setText(String str) {
        this.mBuilder.delete(0, this.mBuilder.length());
        this.mBuilder.append(str);
        String stringBuilder = this.mBuilder.toString();
        int length = stringBuilder.length();
        x.i("MicroMsg.EditVerifyCodeView", "mBuilder:" + this.mBuilder);
        int i;
        if (length > 0) {
            for (i = 0; i < length; i++) {
                this.kma[i].setVisibility(0);
                this.kma[i].setText(String.valueOf(stringBuilder.charAt(i)));
                this.klZ[i].setVisibility(4);
            }
            return;
        }
        for (i = 0; i < 6; i++) {
            this.kma[i].setVisibility(4);
            this.kma[i].setText("");
            this.klZ[i].setVisibility(0);
        }
    }
}
