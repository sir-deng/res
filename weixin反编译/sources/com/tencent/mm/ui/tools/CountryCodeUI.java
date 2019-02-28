package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private String hGi;
    private String inJ = "";
    private p liK;
    private List<c> list;
    private boolean nOI = false;
    private ListView nOZ;
    private a yZw;
    private d zqa;
    private VerticalScrollBar zqb;

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        if (countryCodeUI.zqa != null) {
            countryCodeUI.zqa.Ds(countryCodeUI.inJ);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.hGi = t.aD(getIntent().getStringExtra("country_name"), "");
        this.countryCode = t.aD(getIntent().getStringExtra("couttry_code"), "");
        this.nOI = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        initView();
    }

    protected final int getLayoutId() {
        if (w.cfT()) {
            return R.i.dfq;
        }
        return R.i.dfp;
    }

    protected void onPause() {
        super.onPause();
        if (this.liK != null) {
            this.liK.cyP();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dDA);
        x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode start:" + System.currentTimeMillis());
        String[] split = getString(R.l.bZd).trim().split(",");
        String[] split2;
        if (w.cfT()) {
            x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t1:" + System.currentTimeMillis());
            for (String trim : split) {
                split2 = trim.trim().split(":");
                this.list.add(new c(split2[1], split2[0], com.tencent.mm.aq.a.lI(split2[1]), split2[1]));
            }
            x.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t2:" + System.currentTimeMillis());
            Collections.sort(this.list, new Comparator<c>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return new Integer(((c) obj).nMy).intValue() - new Integer(((c) obj2).nMy).intValue();
                }
            });
            x.d("MicroMsg.CountryCodeUI", "CHT2:initCountryCode t3:" + System.currentTimeMillis());
        } else {
            for (String trim2 : split) {
                split2 = trim2.trim().split(":");
                if (split2.length < 3) {
                    x.e("MicroMsg.CountryCodeUI", "this country item has problem %s", split[r0]);
                } else {
                    this.list.add(new c(split2[1], split2[0], split2[2].charAt(0), split2[2]));
                }
            }
            Collections.sort(this.list, new Comparator<c>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj).nMz.compareTo(((c) obj2).nMz);
                }
            });
        }
        this.liK = new p(true, true);
        this.liK.zvw = new b() {
            public final void pd(String str) {
                CountryCodeUI.this.inJ = str;
                CountryCodeUI.a(CountryCodeUI.this);
            }

            public final void XA() {
            }

            public final void XB() {
            }

            public final boolean pc(String str) {
                return false;
            }

            public final void XC() {
            }

            public final void XD() {
            }
        };
        a(this.liK);
        this.nOZ = (ListView) findViewById(R.h.bJf);
        this.zqa = new d(this, this.list);
        this.zqa.nOI = this.nOI;
        this.nOZ.setAdapter(this.zqa);
        this.nOZ.setVisibility(0);
        this.zqb = (VerticalScrollBar) findViewById(R.h.bJo);
        if (w.cfT()) {
            this.yZw = new a() {
                public final void xN(String str) {
                    int i = 0;
                    if (CountryCodeUI.this.getString(R.l.eID).equals(str)) {
                        CountryCodeUI.this.nOZ.setSelection(0);
                        return;
                    }
                    int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
                    int[] iArr = CountryCodeUI.this.zqa.nOH;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == intValue) {
                                CountryCodeUI.this.nOZ.setSelection(i + CountryCodeUI.this.nOZ.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        } else {
            this.yZw = new a() {
                public final void xN(String str) {
                    int i = 0;
                    char charAt = str.charAt(0);
                    if (CountryCodeUI.this.getString(R.l.eID).equals(str)) {
                        CountryCodeUI.this.nOZ.setSelection(0);
                        return;
                    }
                    int[] iArr = CountryCodeUI.this.zqa.nOH;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == charAt) {
                                CountryCodeUI.this.nOZ.setSelection(i + CountryCodeUI.this.nOZ.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        }
        this.zqb.yqj = this.yZw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CountryCodeUI.this.aWY();
                Intent intent = new Intent();
                intent.putExtra("country_name", CountryCodeUI.this.hGi);
                intent.putExtra("couttry_code", CountryCodeUI.this.countryCode);
                CountryCodeUI.this.setResult(100, intent);
                CountryCodeUI.this.finish();
                return true;
            }
        });
        this.nOZ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i >= CountryCodeUI.this.nOZ.getHeaderViewsCount()) {
                    c cVar = (c) CountryCodeUI.this.zqa.getItem(i - CountryCodeUI.this.nOZ.getHeaderViewsCount());
                    intent.putExtra("country_name", cVar.hGi);
                    intent.putExtra("couttry_code", cVar.countryCode);
                    CountryCodeUI.this.setResult(100, intent);
                }
                CountryCodeUI.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.hGi);
        intent.putExtra("couttry_code", this.countryCode);
        setResult(100, intent);
        finish();
        return true;
    }
}
