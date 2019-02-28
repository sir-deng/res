package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.m;
import android.support.v4.view.m.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.j;
import com.tencent.mm.v.a.k;
import java.util.ArrayList;

public class p {
    final String TAG;
    ag hbP;
    MenuItem myJ;
    private boolean zvA;
    public int zvB;
    private int zvC;
    a zvD;
    boolean zvq;
    public boolean zvr;
    private boolean zvs;
    private boolean zvt;
    boolean zvu;
    public f zvv;
    public b zvw;
    private com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a zvx;
    private boolean zvy;
    private ArrayList<String> zvz;

    public interface a {
        void collapseActionView();

        void cyQ();
    }

    public interface b {
        void XA();

        void XB();

        void XC();

        void XD();

        boolean pc(String str);

        void pd(String str);
    }

    public p() {
        this.zvq = false;
        this.zvr = false;
        this.zvs = false;
        this.zvt = true;
        this.zvu = true;
        this.myJ = null;
        this.hbP = new ag(Looper.getMainLooper());
        this.zvv = null;
        this.zvy = true;
        this.zvB = k.dEU;
        this.zvC = 0;
        this.zvy = true;
        this.zvq = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public p(boolean z, boolean z2) {
        this.zvq = false;
        this.zvr = false;
        this.zvs = false;
        this.zvt = true;
        this.zvu = true;
        this.myJ = null;
        this.hbP = new ag(Looper.getMainLooper());
        this.zvv = null;
        this.zvy = true;
        this.zvB = k.dEU;
        this.zvC = 0;
        this.zvy = true;
        this.zvq = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public final String bVF() {
        if (this.zvv != null) {
            return this.zvv.bVF();
        }
        return "";
    }

    public final void aay(String str) {
        if (this.zvv != null) {
            this.zvv.aay(str);
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.zvv != null) {
            this.zvv.setHint(charSequence);
        }
    }

    public final void clearFocus() {
        if (this.zvv != null) {
            this.zvv.cyo();
        }
    }

    public boolean cdz() {
        return false;
    }

    public void cdA() {
    }

    public void cdB() {
    }

    public final void a(final FragmentActivity fragmentActivity, Menu menu) {
        x.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            x.w(this.TAG, "on add search menu, activity is null");
            return;
        }
        if (this.zvv == null) {
            if (this.zvy) {
                this.zvv = new ActionBarSearchView(fragmentActivity);
            } else {
                this.zvv = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.zvv.a(this.zvx);
            }
            this.zvv.nA(this.zvA);
            this.zvv.ak(this.zvz);
        }
        this.zvv.a(new com.tencent.mm.ui.tools.ActionBarSearchView.b() {
            public final void aXf() {
                if (p.this.zvr) {
                    p.this.cdA();
                } else {
                    x.v(p.this.TAG, "onVoiceSearchRequired, but not in searching");
                }
            }

            public final void aXe() {
                if (p.this.zvw != null) {
                    p.this.zvw.XD();
                }
            }

            public final void Eu(String str) {
                if (!p.this.zvr) {
                    x.v(p.this.TAG, "onSearchTextChange %s, but not in searching", str);
                } else if (p.this.zvw != null) {
                    p.this.zvw.pd(str);
                }
            }

            public final void XC() {
                if (p.this.zvw != null) {
                    p.this.zvw.XC();
                }
            }
        });
        this.zvv.nw(cdz());
        this.zvv.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || p.this.zvw == null) {
                    return false;
                }
                return p.this.zvw.pc(p.this.bVF());
            }
        });
        if (this.zvC != 0) {
            this.zvv.Hc(this.zvC);
        }
        this.myJ = menu.add(0, g.cvU, 0, this.zvB);
        this.myJ.setEnabled(this.zvt);
        this.myJ.setIcon(j.dvl);
        m.a(this.myJ, (View) this.zvv);
        if (this.zvq) {
            m.a(this.myJ, 9);
        } else {
            m.a(this.myJ, 2);
        }
        if (this.zvq) {
            m.a(this.myJ, new e() {
                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    p.this.a(fragmentActivity, false);
                    return true;
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    p.this.b(fragmentActivity, false);
                    return true;
                }
            });
        } else {
            this.zvD = new a() {
                public final void cyQ() {
                    p.this.a(fragmentActivity, true);
                }

                public final void collapseActionView() {
                    p.this.b(fragmentActivity, true);
                }
            };
        }
        this.zvv.a(new com.tencent.mm.ui.tools.ActionBarSearchView.a() {
            public final void aXg() {
                if (p.this.zvq) {
                    if (p.this.myJ != null) {
                        m.c(p.this.myJ);
                    }
                } else if (p.this.zvD != null) {
                    p.this.zvD.collapseActionView();
                }
            }
        });
    }

    public void a(Activity activity, Menu menu) {
        x.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.zvr), Boolean.valueOf(this.zvs), Boolean.valueOf(this.zvt));
        if (activity == null) {
            x.w(this.TAG, "on hanle status fail, activity is null");
            return;
        }
        this.myJ = menu.findItem(g.cvU);
        if (this.myJ == null) {
            x.w(this.TAG, "can not find search menu, error");
            return;
        }
        this.myJ.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
    }

    private void b(final Activity activity, Menu menu) {
        if (!this.zvt) {
            return;
        }
        if (this.zvr || this.zvs) {
            this.zvs = false;
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != g.cvU) {
                        item.setVisible(false);
                    }
                }
            }
            this.hbP.postDelayed(new Runnable() {
                public final void run() {
                    if (p.this.myJ == null) {
                        x.w(p.this.TAG, "on post expand search menu, but item is null");
                        return;
                    }
                    x.i(p.this.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(p.this.zvr));
                    if (p.this.zvq) {
                        if (!p.this.zvr) {
                            m.b(p.this.myJ);
                        }
                    } else if (p.this.zvD != null) {
                        p.this.zvD.cyQ();
                    }
                    final View a = m.a(p.this.myJ);
                    if (a != null && p.this.zvr) {
                        a.findViewById(g.cdl).requestFocus();
                        if (p.this.zvu) {
                            p.this.hbP.postDelayed(new Runnable() {
                                public final void run() {
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(g.cdl), 0);
                                }
                            }, 128);
                        }
                    }
                }
            }, 128);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.zvr));
        if (4 != i || !this.zvr) {
            return false;
        }
        cyP();
        return true;
    }

    public final void nC(boolean z) {
        boolean z2 = false;
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.zvr);
        if (this.myJ == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        if (!this.zvr) {
            if (this.zvt) {
                this.zvu = z;
                if (this.myJ != null) {
                    this.hbP.post(new Runnable() {
                        public final void run() {
                            if (p.this.myJ == null) {
                                x.w(p.this.TAG, "post do expand search menu, but search menu item is null");
                            } else if (p.this.zvq) {
                                m.b(p.this.myJ);
                            } else if (p.this.zvD != null) {
                                p.this.zvD.cyQ();
                            }
                        }
                    });
                    return;
                } else {
                    this.zvs = true;
                    return;
                }
            }
            x.w(this.TAG, "can not expand now");
        }
    }

    public final void cyP() {
        x.d(this.TAG, "do collapse");
        if (this.zvr && this.myJ != null) {
            if (this.zvq) {
                m.c(this.myJ);
            } else if (this.zvD != null) {
                this.zvD.collapseActionView();
            }
        }
    }

    public final boolean cyp() {
        if (this.zvv != null) {
            return this.zvv.cyp();
        }
        return false;
    }

    public final boolean cyq() {
        if (this.zvv != null) {
            return this.zvv.cyq();
        }
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewExpand, searchViewExpand " + this.zvr);
        if (!this.zvr) {
            this.zvr = true;
            b((Activity) fragmentActivity, null);
            this.hbP.post(new Runnable() {
                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(p.this.TAG, "want to expand search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.zvw != null) {
                this.zvw.XB();
            }
        }
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewCollapse, searchViewExpand " + this.zvr);
        if (this.zvr) {
            this.zvr = false;
            cdB();
            if (this.zvv != null) {
                this.zvv.nz(false);
            }
            this.hbP.post(new Runnable() {
                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(p.this.TAG, "want to collapse search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.zvw != null) {
                this.hbP.post(new Runnable() {
                    public final void run() {
                        p.this.zvw.XA();
                    }
                });
            }
        }
        this.hbP.post(new Runnable() {
            public final void run() {
                if (p.this.myJ == null) {
                    x.w(p.this.TAG, "want to collapse search view, but search menu item is null");
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = m.a(p.this.myJ);
                if (a != null) {
                    a.findViewById(g.cdl).clearFocus();
                }
            }
        });
    }
}
