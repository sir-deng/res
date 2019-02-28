package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.u;
import com.tencent.mm.v.a.h;

public abstract class i extends u {
    private SharedPreferences hbz;
    private boolean mvv = false;
    private ListView nQn;
    private boolean sjr = false;
    private long tzJ;
    public h yrJ;
    public boolean ysb;

    public abstract int XK();

    public abstract boolean a(f fVar, Preference preference);

    protected int getLayoutId() {
        return h.dnZ;
    }

    protected View getLayoutView() {
        return b.Ef().a(getContext(), "R.layout.mm_preference_fragment_list_content", h.dnZ);
    }

    public void onResume() {
        super.onResume();
        this.yrJ.notifyDataSetChanged();
        this.tzJ = System.currentTimeMillis();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ysb = false;
        this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.yrJ = new h(getContext(), this.hbz);
        this.nQn = (ListView) findViewById(16908298);
        this.yrJ.b(new a() {
            public final boolean a(Preference preference, Object obj) {
                if (!i.this.sjr && preference.isEnabled() && preference.ysn) {
                    boolean z;
                    i.this.sjr = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.tYU = checkBoxPreference.isChecked();
                        if (checkBoxPreference.ysp) {
                            i.this.hbz.edit().putBoolean(preference.idX, checkBoxPreference.isChecked()).commit();
                        }
                        i.this.mvv = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.idX != null) {
                        i.this.a(i.this.yrJ, preference);
                    }
                    if (z) {
                        i.this.yrJ.notifyDataSetChanged();
                    }
                    i.this.sjr = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        this.nQn.setAdapter(this.yrJ);
        this.nQn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= i.this.nQn.getHeaderViewsCount()) {
                    x.i("MicroMsg.mmui.MMPreference", "click after resume %d", Long.valueOf(System.currentTimeMillis() - i.this.tzJ));
                    if (System.currentTimeMillis() - i.this.tzJ < 400) {
                        x.w("MicroMsg.mmui.MMPreference", "too quick click after resume, ignore");
                        return;
                    }
                    final Preference preference = (Preference) i.this.yrJ.getItem(i - i.this.nQn.getHeaderViewsCount());
                    if (preference.isEnabled() && preference.ysn && !(preference instanceof CheckBoxPreference)) {
                        if (preference instanceof DialogPreference) {
                            final DialogPreference dialogPreference = (DialogPreference) preference;
                            dialogPreference.showDialog();
                            dialogPreference.yqI = new DialogPreference.a() {
                                public final void cra() {
                                    i.this.mvv = true;
                                    if (dialogPreference.ysp) {
                                        i.this.hbz.edit().putString(preference.idX, dialogPreference.getValue()).commit();
                                    }
                                    i.this.yrJ.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference instanceof EditPreference) {
                            final EditPreference editPreference = (EditPreference) preference;
                            editPreference.showDialog();
                            editPreference.yqK = new EditPreference.a() {
                                public final void cra() {
                                    i.this.mvv = true;
                                    if (editPreference.ysp) {
                                        i.this.hbz.edit().putString(preference.idX, editPreference.value).commit();
                                    }
                                    i.this.yrJ.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference.idX != null) {
                            i.this.a(i.this.yrJ, preference);
                        }
                    }
                }
            }
        });
        this.nQn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < i.this.nQn.getHeaderViewsCount()) {
                    return false;
                }
                i.this.yrJ.getItem(i - i.this.nQn.getHeaderViewsCount());
                i.this.yrJ;
                i.this.nQn;
                return i.crd();
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean crd() {
        return false;
    }
}
