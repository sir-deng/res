package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.k;

public class MMTextInputUI extends MMActivity {
    private int gDq;
    private int kJo;
    private EditText yqL;
    private TextView zuF;
    private int zuG;
    private boolean zuH;

    public int getLayoutId() {
        return h.gYW;
    }

    private void goBack() {
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(k.har), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MMTextInputUI.this.aWY();
                    MMTextInputUI.this.setResult(0);
                    MMTextInputUI.this.finish();
                }
            }, null);
            return;
        }
        aWY();
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        x.i("MicroMsg.MMTextInputUI", "on back key down");
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.yqL = (EditText) findViewById(g.gYg);
        this.zuF = (TextView) findViewById(g.gYa);
        this.yqL.setHint(bi.aD(getIntent().getStringExtra("key_hint"), ""));
        this.yqL.append(bi.aD(getIntent().getStringExtra("key_value"), ""));
        this.gDq = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.kJo = 0;
        this.zuG = Math.max(this.gDq - 120, (this.gDq * 9) / 10);
        this.zuH = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MMTextInputUI.this.goBack();
                return false;
            }
        });
        a(0, getString(k.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MMTextInputUI.this.y(MMTextInputUI.this.yqL.getText());
                Intent intent = new Intent();
                intent.putExtra("key_result", MMTextInputUI.this.yqL.getText());
                MMTextInputUI.this.setResult(-1, intent);
                MMTextInputUI.this.finish();
                return true;
            }
        }, b.xSe);
        enableOptionMenu(this.zuH);
        if (!this.zuH || this.gDq > 0) {
            this.yqL.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean z = false;
                    String obj = editable.toString();
                    if (!MMTextInputUI.this.zuH) {
                        if (obj.trim().length() > 0) {
                            MMTextInputUI.this.enableOptionMenu(true);
                        } else {
                            MMTextInputUI.this.enableOptionMenu(false);
                        }
                    }
                    if (MMTextInputUI.this.gDq > 0) {
                        MMTextInputUI.this.kJo = 0;
                        for (int i = 0; i < obj.length(); i++) {
                            if (bi.n(obj.charAt(i))) {
                                MMTextInputUI.this.kJo = MMTextInputUI.this.kJo + 2;
                            } else {
                                MMTextInputUI.this.kJo = MMTextInputUI.this.kJo + 1;
                            }
                        }
                        if (MMTextInputUI.this.kJo >= MMTextInputUI.this.zuG && MMTextInputUI.this.kJo <= MMTextInputUI.this.gDq) {
                            MMTextInputUI.this.enableOptionMenu(true);
                            MMTextInputUI.this.zuF.setVisibility(0);
                            MMTextInputUI.this.zuF.setTextColor(MMTextInputUI.this.getResources().getColor(d.gWq));
                            MMTextInputUI.this.zuF.setText(MMTextInputUI.this.getString(k.gWq, new Object[]{Integer.valueOf((MMTextInputUI.this.gDq - MMTextInputUI.this.kJo) >> 1)}));
                        } else if (MMTextInputUI.this.kJo > MMTextInputUI.this.gDq) {
                            MMTextInputUI.this.enableOptionMenu(false);
                            MMTextInputUI.this.zuF.setVisibility(0);
                            MMTextInputUI.this.zuF.setTextColor(MMTextInputUI.this.getResources().getColor(d.gWr));
                            MMTextInputUI.this.zuF.setText(MMTextInputUI.this.getString(k.hau, new Object[]{Integer.valueOf(((MMTextInputUI.this.kJo - MMTextInputUI.this.gDq) >> 1) + 1)}));
                        } else {
                            MMTextInputUI mMTextInputUI = MMTextInputUI.this;
                            if (MMTextInputUI.this.zuH) {
                                z = true;
                            } else if (MMTextInputUI.this.kJo > 0) {
                                z = true;
                            }
                            mMTextInputUI.enableOptionMenu(z);
                            MMTextInputUI.this.zuF.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    public void y(CharSequence charSequence) {
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
