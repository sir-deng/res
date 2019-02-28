package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class g extends MenuInflater {
    private static final Class<?>[] JB;
    private static final Class<?>[] JC;
    private final Object[] JD;
    private final Object[] JE = this.JD;
    private Object JF;
    private Context mContext;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] JG = new Class[]{MenuItem.class};
        private Object JF;
        private Method mMethod;

        public a(Object obj, String str) {
            this.JF = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, JG);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.JF, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.JF, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        Menu JH;
        int JI;
        int JJ;
        int JK;
        int JL;
        boolean JM;
        boolean JN;
        boolean JO;
        int JP;
        int JQ;
        CharSequence JR;
        CharSequence JS;
        int JT;
        char JU;
        char JV;
        int JW;
        boolean JX;
        boolean JY;
        boolean JZ;
        int Ka;
        int Kb;
        String Kc;
        String Kd;
        String Ke;
        d Kf;

        public b(Menu menu) {
            this.JH = menu;
            dk();
        }

        public final void dk() {
            this.JI = 0;
            this.JJ = 0;
            this.JK = 0;
            this.JL = 0;
            this.JM = true;
            this.JN = true;
        }

        static char u(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        final void e(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.JX).setVisible(this.JY).setEnabled(this.JZ).setCheckable(this.JW > 0).setTitleCondensed(this.JS).setIcon(this.JT).setAlphabeticShortcut(this.JU).setNumericShortcut(this.JV);
            if (this.Ka >= 0) {
                m.a(menuItem, this.Ka);
            }
            if (this.Ke != null) {
                if (g.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.b(g.this), this.Ke));
            }
            if (this.JW >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).F(true);
                } else if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    try {
                        if (iVar.LQ == null) {
                            iVar.LQ = ((android.support.v4.c.a.b) iVar.KO).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        iVar.LQ.invoke(iVar.KO, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Kc != null) {
                m.a(menuItem, (View) newInstance(this.Kc, g.JB, g.this.JD));
            } else {
                z = false;
            }
            if (this.Kb > 0 && !z) {
                m.b(menuItem, this.Kb);
            }
            if (this.Kf != null) {
                m.a(menuItem, this.Kf);
            }
        }

        public final SubMenu dl() {
            this.JO = true;
            SubMenu addSubMenu = this.JH.addSubMenu(this.JI, this.JP, this.JQ, this.JR);
            e(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static /* synthetic */ Object b(g gVar) {
        if (gVar.JF == null) {
            Object obj = gVar.mContext;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            gVar.JF = obj;
        }
        return gVar.JF;
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        JB = clsArr;
        JC = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.JD = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = new android.support.v7.view.g$b;
        r4.<init>(r13);
        r0 = r11.getEventType();
        r3 = 0;
        r2 = 0;
    L_0x000b:
        r1 = 2;
        if (r0 != r1) goto L_0x0048;
    L_0x000e:
        r0 = r11.getName();
        r1 = "menu";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r1 = 0;
    L_0x0020:
        if (r1 != 0) goto L_0x022f;
    L_0x0022:
        switch(r0) {
            case 1: goto L_0x0226;
            case 2: goto L_0x0050;
            case 3: goto L_0x01ba;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0028:
        r3 = r11.next();
        r9 = r0;
        r0 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r9;
        goto L_0x0020;
    L_0x0032:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0048:
        r0 = r11.next();
        r1 = 1;
        if (r0 != r1) goto L_0x000b;
    L_0x004f:
        goto L_0x001f;
    L_0x0050:
        if (r3 != 0) goto L_0x0025;
    L_0x0052:
        r0 = r11.getName();
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x00a6;
    L_0x005f:
        r0 = r4.Kg;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.MenuGroup;
        r0 = r0.obtainStyledAttributes(r12, r5);
        r5 = android.support.v7.a.a.k.MenuGroup_android_id;
        r6 = 0;
        r5 = r0.getResourceId(r5, r6);
        r4.JI = r5;
        r5 = android.support.v7.a.a.k.MenuGroup_android_menuCategory;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.JJ = r5;
        r5 = android.support.v7.a.a.k.MenuGroup_android_orderInCategory;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.JK = r5;
        r5 = android.support.v7.a.a.k.MenuGroup_android_checkableBehavior;
        r6 = 0;
        r5 = r0.getInt(r5, r6);
        r4.JL = r5;
        r5 = android.support.v7.a.a.k.MenuGroup_android_visible;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.JM = r5;
        r5 = android.support.v7.a.a.k.MenuGroup_android_enabled;
        r6 = 1;
        r5 = r0.getBoolean(r5, r6);
        r4.JN = r5;
        r0.recycle();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x00a6:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x019f;
    L_0x00af:
        r0 = r4.Kg;
        r0 = r0.mContext;
        r5 = android.support.v7.a.a.k.MenuItem;
        r5 = r0.obtainStyledAttributes(r12, r5);
        r0 = android.support.v7.a.a.k.MenuItem_android_id;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.JP = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_menuCategory;
        r6 = r4.JJ;
        r0 = r5.getInt(r0, r6);
        r6 = android.support.v7.a.a.k.MenuItem_android_orderInCategory;
        r7 = r4.JK;
        r6 = r5.getInt(r6, r7);
        r7 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r7;
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r6 = r6 & r7;
        r0 = r0 | r6;
        r4.JQ = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_title;
        r0 = r5.getText(r0);
        r4.JR = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_titleCondensed;
        r0 = r5.getText(r0);
        r4.JS = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_icon;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.JT = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_alphabeticShortcut;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.u(r0);
        r4.JU = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_numericShortcut;
        r0 = r5.getString(r0);
        r0 = android.support.v7.view.g.b.u(r0);
        r4.JV = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_checkable;
        r0 = r5.hasValue(r0);
        if (r0 == 0) goto L_0x0194;
    L_0x0115:
        r0 = android.support.v7.a.a.k.MenuItem_android_checkable;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        if (r0 == 0) goto L_0x0192;
    L_0x011e:
        r0 = 1;
    L_0x011f:
        r4.JW = r0;
    L_0x0121:
        r0 = android.support.v7.a.a.k.MenuItem_android_checked;
        r6 = 0;
        r0 = r5.getBoolean(r0, r6);
        r4.JX = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_visible;
        r6 = r4.JM;
        r0 = r5.getBoolean(r0, r6);
        r4.JY = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_enabled;
        r6 = r4.JN;
        r0 = r5.getBoolean(r0, r6);
        r4.JZ = r0;
        r0 = android.support.v7.a.a.k.MenuItem_showAsAction;
        r6 = -1;
        r0 = r5.getInt(r0, r6);
        r4.Ka = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_onClick;
        r0 = r5.getString(r0);
        r4.Ke = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionLayout;
        r6 = 0;
        r0 = r5.getResourceId(r0, r6);
        r4.Kb = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionViewClass;
        r0 = r5.getString(r0);
        r4.Kc = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionProviderClass;
        r0 = r5.getString(r0);
        r4.Kd = r0;
        r0 = r4.Kd;
        if (r0 == 0) goto L_0x0199;
    L_0x016c:
        r0 = 1;
    L_0x016d:
        if (r0 == 0) goto L_0x019b;
    L_0x016f:
        r0 = r4.Kb;
        if (r0 != 0) goto L_0x019b;
    L_0x0173:
        r0 = r4.Kc;
        if (r0 != 0) goto L_0x019b;
    L_0x0177:
        r0 = r4.Kd;
        r6 = JC;
        r7 = r4.Kg;
        r7 = r7.JE;
        r0 = r4.newInstance(r0, r6, r7);
        r0 = (android.support.v4.view.d) r0;
        r4.Kf = r0;
    L_0x0187:
        r5.recycle();
        r0 = 0;
        r4.JO = r0;
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0192:
        r0 = 0;
        goto L_0x011f;
    L_0x0194:
        r0 = r4.JL;
        r4.JW = r0;
        goto L_0x0121;
    L_0x0199:
        r0 = 0;
        goto L_0x016d;
    L_0x019b:
        r0 = 0;
        r4.Kf = r0;
        goto L_0x0187;
    L_0x019f:
        r5 = "menu";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01b4;
    L_0x01a8:
        r0 = r4.dl();
        r10.a(r11, r12, r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01b4:
        r2 = 1;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01ba:
        r0 = r11.getName();
        if (r3 == 0) goto L_0x01cd;
    L_0x01c0:
        r5 = r0.equals(r2);
        if (r5 == 0) goto L_0x01cd;
    L_0x01c6:
        r2 = 0;
        r0 = 0;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0028;
    L_0x01cd:
        r5 = "group";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x01de;
    L_0x01d6:
        r4.dk();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01de:
        r5 = "item";
        r5 = r0.equals(r5);
        if (r5 == 0) goto L_0x0218;
    L_0x01e7:
        r0 = r4.JO;
        if (r0 != 0) goto L_0x0025;
    L_0x01eb:
        r0 = r4.Kf;
        if (r0 == 0) goto L_0x01ff;
    L_0x01ef:
        r0 = r4.Kf;
        r0 = r0.hasSubMenu();
        if (r0 == 0) goto L_0x01ff;
    L_0x01f7:
        r4.dl();
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x01ff:
        r0 = 1;
        r4.JO = r0;
        r0 = r4.JH;
        r5 = r4.JI;
        r6 = r4.JP;
        r7 = r4.JQ;
        r8 = r4.JR;
        r0 = r0.add(r5, r6, r7, r8);
        r4.e(r0);
        r0 = r1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0218:
        r5 = "menu";
        r0 = r0.equals(r5);
        if (r0 == 0) goto L_0x0025;
    L_0x0221:
        r0 = 1;
        r1 = r2;
        r2 = r3;
        goto L_0x0028;
    L_0x0226:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x022f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}
