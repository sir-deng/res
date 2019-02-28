package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class b {
    public int FA;
    public boolean FB = false;
    Button FC;
    CharSequence FD;
    Message FE;
    Button FF;
    CharSequence FG;
    Message FH;
    Button FI;
    CharSequence FJ;
    Message FK;
    NestedScrollView FL;
    public int FM = 0;
    TextView FN;
    public View FO;
    public ListAdapter FP;
    public int FQ = -1;
    int FR;
    int FS;
    public int FT;
    public int FU;
    public int FV;
    public int FW;
    int FX = 0;
    final OnClickListener FY = new OnClickListener() {
        public final void onClick(View view) {
            Message obtain;
            if (view == b.this.FC && b.this.FE != null) {
                obtain = Message.obtain(b.this.FE);
            } else if (view == b.this.FF && b.this.FH != null) {
                obtain = Message.obtain(b.this.FH);
            } else if (view != b.this.FI || b.this.FK == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(b.this.FK);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            b.this.mHandler.obtainMessage(1, b.this.Fs).sendToTarget();
        }
    };
    final j Fs;
    final Window Ft;
    public CharSequence Fu;
    public ListView Fv;
    public int Fw;
    public int Fx;
    public int Fy;
    public int Fz;
    public Drawable jY;
    public TextView jy;
    public ImageView kP;
    public final Context mContext;
    Handler mHandler;
    public View mView;
    CharSequence uU;

    /* renamed from: android.support.v7.app.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ View Ga;
        final /* synthetic */ View Gb;

        AnonymousClass3(View view, View view2) {
            this.Ga = view;
            this.Gb = view2;
        }

        public final void run() {
            b.a(b.this.FL, this.Ga, this.Gb);
        }
    }

    /* renamed from: android.support.v7.app.b$4 */
    class AnonymousClass4 implements OnScrollListener {
        final /* synthetic */ View Ga;
        final /* synthetic */ View Gb;

        AnonymousClass4(View view, View view2) {
            this.Ga = view;
            this.Gb = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            b.a(absListView, this.Ga, this.Gb);
        }
    }

    /* renamed from: android.support.v7.app.b$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ View Ga;
        final /* synthetic */ View Gb;

        AnonymousClass5(View view, View view2) {
            this.Ga = view;
            this.Gb = view2;
        }

        public final void run() {
            b.a(b.this.Fv, this.Ga, this.Gb);
        }
    }

    public static class a {
        public Cursor BA;
        public final LayoutInflater DF;
        public int FA;
        public boolean FB = false;
        public int FM = 0;
        public View FO;
        public ListAdapter FP;
        public int FQ = -1;
        public CharSequence Fu;
        public int Fw;
        public int Fx;
        public int Fy;
        public int Fz;
        public int Gc = 0;
        public CharSequence Gd;
        public DialogInterface.OnClickListener Ge;
        public CharSequence Gf;
        public DialogInterface.OnClickListener Gg;
        public CharSequence Gh;
        public DialogInterface.OnClickListener Gi;
        public OnCancelListener Gj;
        public OnDismissListener Gk;
        public OnKeyListener Gl;
        public CharSequence[] Gm;
        public DialogInterface.OnClickListener Gn;
        public boolean[] Go;
        public boolean Gp;
        public boolean Gq;
        public OnMultiChoiceClickListener Gr;
        public String Gs;
        public String Gt;
        public OnItemSelectedListener Gu;
        public boolean Gv = true;
        public Drawable jY;
        public final Context mContext;
        public View mView;
        public boolean pY;
        public CharSequence uU;

        /* renamed from: android.support.v7.app.b$a$1 */
        class AnonymousClass1 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView Gw;

            public AnonymousClass1(Context context, int i, CharSequence[] charSequenceArr, ListView listView) {
                this.Gw = listView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (a.this.Go != null && a.this.Go[i]) {
                    this.Gw.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.app.b$a$2 */
        class AnonymousClass2 extends CursorAdapter {
            final /* synthetic */ b GA;
            final /* synthetic */ ListView Gw;
            private final int Gy;
            private final int Gz;

            public AnonymousClass2(Context context, Cursor cursor, ListView listView, b bVar) {
                this.Gw = listView;
                this.GA = bVar;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.Gy = cursor2.getColumnIndexOrThrow(a.this.Gs);
                this.Gz = cursor2.getColumnIndexOrThrow(a.this.Gt);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.Gy));
                this.Gw.setItemChecked(cursor.getPosition(), cursor.getInt(this.Gz) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return a.this.DF.inflate(this.GA.FU, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.app.b$a$3 */
        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ b GA;

            public AnonymousClass3(b bVar) {
                this.GA = bVar;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a.this.Gn.onClick(this.GA.Fs, i);
                if (!a.this.Gq) {
                    this.GA.Fs.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.app.b$a$4 */
        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ b GA;
            final /* synthetic */ ListView Gw;

            public AnonymousClass4(ListView listView, b bVar) {
                this.Gw = listView;
                this.GA = bVar;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (a.this.Go != null) {
                    a.this.Go[i] = this.Gw.isItemChecked(i);
                }
                a.this.Gr.onClick(this.GA.Fs, i, this.Gw.isItemChecked(i));
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.pY = true;
            this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> GB;

        public b(DialogInterface dialogInterface) {
            this.GB = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.GB.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: android.support.v7.app.b$2 */
    class AnonymousClass2 implements android.support.v4.widget.NestedScrollView.b {
        final /* synthetic */ View Ga;
        final /* synthetic */ View Gb;

        AnonymousClass2(View view, View view2) {
            this.Ga = view;
            this.Gb = view2;
        }

        public final void b(NestedScrollView nestedScrollView) {
            b.a(nestedScrollView, this.Ga, this.Gb);
        }
    }

    static /* synthetic */ void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(z.h(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!z.h(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    public b(Context context, j jVar, Window window) {
        this.mContext = context;
        this.Fs = jVar;
        this.Ft = window;
        this.mHandler = new b(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, k.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.FR = obtainStyledAttributes.getResourceId(k.AlertDialog_android_layout, 0);
        this.FS = obtainStyledAttributes.getResourceId(k.AlertDialog_buttonPanelSideLayout, 0);
        this.FT = obtainStyledAttributes.getResourceId(k.AlertDialog_listLayout, 0);
        this.FU = obtainStyledAttributes.getResourceId(k.AlertDialog_multiChoiceItemLayout, 0);
        this.FV = obtainStyledAttributes.getResourceId(k.AlertDialog_singleChoiceItemLayout, 0);
        this.FW = obtainStyledAttributes.getResourceId(k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        jVar.db();
    }

    static boolean aH(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (aH(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.uU = charSequence;
        if (this.FN != null) {
            this.FN.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.FJ = charSequence;
                this.FK = message;
                return;
            case -2:
                this.FG = charSequence;
                this.FH = message;
                return;
            case -1:
                this.FD = charSequence;
                this.FE = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.jY = null;
        this.FM = i;
        if (this.kP == null) {
            return;
        }
        if (i != 0) {
            this.kP.setVisibility(0);
            this.kP.setImageResource(this.FM);
            return;
        }
        this.kP.setVisibility(8);
    }

    static ViewGroup b(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }
}
