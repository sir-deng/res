package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;

public abstract class MMPreference extends MMActivity {
    public SharedPreferences hbz;
    private boolean mvv = false;
    public ListView nQn;
    private boolean sjr = false;
    public h yrJ;
    protected RelativeLayout yrK;
    protected TextView yrL;
    protected ImageView yrM;

    public abstract int XK();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return h.cws;
    }

    public boolean XJ() {
        return true;
    }

    public void onResume() {
        if (XJ()) {
            this.yrJ.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.yrJ = a(this.hbz);
        this.nQn = (ListView) findViewById(16908298);
        this.yrK = (RelativeLayout) findViewById(g.gXM);
        this.yrL = (TextView) findViewById(g.gXL);
        this.yrM = (ImageView) findViewById(g.gXK);
        int atg = atg();
        if (atg != -1) {
            this.nQn.addHeaderView(getLayoutInflater().inflate(atg, null));
        }
        View awb = awb();
        if (awb != null) {
            if (awb.getLayoutParams() != null) {
                awb.setLayoutParams(new LayoutParams(awb.getLayoutParams()));
            } else {
                x.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.nQn.addFooterView(awb);
        }
        View brg = brg();
        if (brg != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(g.gXJ);
            frameLayout.addView(brg);
            frameLayout.setVisibility(0);
        }
        this.yrJ.b(new a() {
            public final boolean a(Preference preference, Object obj) {
                if (!MMPreference.this.sjr && preference.isEnabled() && preference.ysn) {
                    boolean z;
                    MMPreference.this.sjr = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.tYU = checkBoxPreference.isChecked();
                        if (checkBoxPreference.ysp) {
                            MMPreference.this.hbz.edit().putBoolean(preference.idX, checkBoxPreference.isChecked()).commit();
                        }
                        MMPreference.this.mvv = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.idX != null) {
                        MMPreference.this.a(MMPreference.this.yrJ, preference);
                    }
                    if (z) {
                        MMPreference.this.yrJ.notifyDataSetChanged();
                    }
                    MMPreference.this.sjr = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        atg = XK();
        if (atg != -1) {
            this.yrJ.addPreferencesFromResource(atg);
        }
        this.nQn.setAdapter(this.yrJ);
        this.nQn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
                if (preference != null && preference.isEnabled() && preference.ysn && !(preference instanceof CheckBoxPreference)) {
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.yqI = new DialogPreference.a() {
                            public final void cra() {
                                MMPreference.this.mvv = true;
                                if (dialogPreference.ysp) {
                                    MMPreference.this.hbz.edit().putString(preference.idX, dialogPreference.getValue()).commit();
                                }
                                MMPreference.this.yrJ.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.yqK = new EditPreference.a() {
                            public final void cra() {
                                MMPreference.this.mvv = true;
                                if (editPreference.ysp) {
                                    MMPreference.this.hbz.edit().putString(preference.idX, editPreference.value).commit();
                                }
                                MMPreference.this.yrJ.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference.idX != null) {
                        MMPreference.this.a(MMPreference.this.yrJ, preference);
                    }
                }
            }
        });
        this.nQn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < MMPreference.this.nQn.getHeaderViewsCount()) {
                    return false;
                }
                int headerViewsCount = i - MMPreference.this.nQn.getHeaderViewsCount();
                if (headerViewsCount >= MMPreference.this.yrJ.getCount()) {
                    x.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(MMPreference.this.yrJ.getCount()));
                    return false;
                }
                MMPreference.this.yrJ.getItem(headerViewsCount);
                MMPreference.this.yrJ;
                MMPreference.this.nQn;
                return MMPreference.crd();
            }
        });
        this.nQn.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    View currentFocus = MMPreference.this.getCurrentFocus();
                    if (currentFocus != null) {
                        currentFocus.clearFocus();
                    }
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean crd() {
        return false;
    }

    public final void setSelection(int i) {
        this.nQn.setSelection(i);
    }

    public int atg() {
        return -1;
    }

    public View awb() {
        return null;
    }

    public View brg() {
        return null;
    }

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, sharedPreferences);
    }
}
