package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.e.c;
import android.support.v4.e.d;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class n extends m implements k {
    static boolean DEBUG = false;
    static Field qD = null;
    static final Interpolator qM = new DecelerateInterpolator(2.5f);
    static final Interpolator qN = new DecelerateInterpolator(1.5f);
    static final Interpolator qO = new AccelerateInterpolator(2.5f);
    static final Interpolator qP = new AccelerateInterpolator(1.5f);
    static final boolean qo;
    l mHost;
    int qA = 0;
    j qB;
    Fragment qC;
    boolean qE;
    boolean qF;
    boolean qG;
    String qH;
    boolean qI;
    Bundle qJ = null;
    SparseArray<Parcelable> qK = null;
    Runnable qL = new Runnable() {
        public final void run() {
            n.this.execPendingActions();
        }
    };
    ArrayList<Runnable> qp;
    Runnable[] qq;
    boolean qr;
    ArrayList<Fragment> qs;
    ArrayList<Fragment> qt;
    ArrayList<Integer> qu;
    ArrayList<e> qv;
    ArrayList<Fragment> qw;
    ArrayList<e> qx;
    ArrayList<Integer> qy;
    ArrayList<Object> qz;

    /* renamed from: android.support.v4.app.n$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int qR = 1;
        final /* synthetic */ int val$id;

        AnonymousClass3(int i, int i2) {
            this.val$id = i;
        }

        public final void run() {
            n nVar = n.this;
            l lVar = n.this.mHost;
            nVar.k(this.val$id, this.qR);
        }
    }

    static class a implements AnimationListener {
        private View mView = null;
        private AnimationListener qT = null;
        private boolean qU = false;

        public a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.qT = animationListener;
                this.mView = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView != null) {
                this.qU = n.a(this.mView, animation);
                if (this.qU) {
                    this.mView.post(new Runnable() {
                        public final void run() {
                            z.a(a.this.mView, 2, null);
                        }
                    });
                }
            }
            if (this.qT != null) {
                this.qT.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.qU) {
                this.mView.post(new Runnable() {
                    public final void run() {
                        z.a(a.this.mView, 0, null);
                    }
                });
            }
            if (this.qT != null) {
                this.qT.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.qT != null) {
                this.qT.onAnimationRepeat(animation);
            }
        }
    }

    static class b {
        public static final int[] qW = new int[]{16842755, 16842960, 16842961};
    }

    n() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        qo = z;
    }

    static boolean a(View view, Animation animation) {
        if (VERSION.SDK_INT < 19 || z.H(view) != 0 || !z.ac(view)) {
            return false;
        }
        boolean z;
        if (animation instanceof AlphaAnimation) {
            z = true;
        } else {
            if (animation instanceof AnimationSet) {
                List animations = ((AnimationSet) animation).getAnimations();
                for (int i = 0; i < animations.size(); i++) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    private void a(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new d("FragmentManager"));
        if (this.mHost != null) {
            try {
                this.mHost.a("  ", printWriter, new String[0]);
            } catch (Exception e) {
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
            }
        }
        throw runtimeException;
    }

    public final q aT() {
        return new e(this);
    }

    public final boolean executePendingTransactions() {
        return execPendingActions();
    }

    public final void popBackStack() {
        a(new Runnable() {
            public final void run() {
                n nVar = n.this;
                l lVar = n.this.mHost;
                nVar.k(-1, 0);
            }
        }, false);
    }

    public final boolean popBackStackImmediate() {
        aW();
        execPendingActions();
        return k(-1, 0);
    }

    public final void O(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new AnonymousClass3(i, 1), false);
    }

    public final int getBackStackEntryCount() {
        return this.qv != null ? this.qv.size() : 0;
    }

    public final void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment c(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.qs.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.qs.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final List<Fragment> aU() {
        return this.qs;
    }

    public final SavedState e(Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        Bundle j = j(fragment);
        if (j != null) {
            return new SavedState(j);
        }
        return null;
    }

    public final boolean isDestroyed() {
        return this.qG;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.qC != null) {
            c.a(this.qC, stringBuilder);
        } else {
            c.a(this.mHost, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        e eVar;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.qs != null) {
            size = this.qs.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qs.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.qt != null) {
            size = this.qt.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qt.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qw != null) {
            size = this.qw.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.qw.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.qv != null) {
            size = this.qv.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    eVar = (e) this.qv.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(eVar.toString());
                    eVar.a(str2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.qx != null) {
                int size2 = this.qx.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        eVar = (e) this.qx.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(eVar);
                    }
                }
            }
            if (this.qy != null && this.qy.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.qy.toArray()));
            }
        }
        if (this.qp != null) {
            i = this.qp.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.qp.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.qB);
        if (this.qC != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.qC);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.qA);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.qF);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.qG);
        if (this.qE) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.qE);
        }
        if (this.qH != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.qH);
        }
        if (this.qu != null && this.qu.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.qu.toArray()));
        }
    }

    private static Animation a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(qM);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(qN);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private static Animation f(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(qN);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    private Animation a(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.mHost.mContext, fragment.mNextAnim);
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        Object obj = -1;
        switch (i) {
            case 4097:
                if (!z) {
                    obj = 2;
                    break;
                }
                obj = 1;
                break;
            case 4099:
                if (!z) {
                    obj = 6;
                    break;
                }
                obj = 5;
                break;
            case 8194:
                if (!z) {
                    obj = 4;
                    break;
                }
                obj = 3;
                break;
        }
        if (obj < null) {
            return null;
        }
        switch (obj) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return f(0.0f, 1.0f);
            case 6:
                return f(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public final void f(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.qr) {
            this.qI = true;
            return;
        }
        fragment.mDeferStart = false;
        a(fragment, this.qA, 0, 0, false);
    }

    private static void b(View view, Animation animation) {
        if (view != null && animation != null && a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (qD == null) {
                    Field declaredField = Animation.class.getDeclaredField("mListener");
                    qD = declaredField;
                    declaredField.setAccessible(true);
                }
                animationListener = (AnimationListener) qD.get(animation);
            } catch (NoSuchFieldException e) {
                animationListener = null;
            } catch (IllegalAccessException e2) {
                animationListener = null;
            }
            animation.setAnimationListener(new a(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(final android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r10.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.mRemoving;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.mState;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.mState;
    L_0x001a:
        r0 = r10.mDeferStart;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.mState;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.mState;
        if (r0 >= r11) goto L_0x025f;
    L_0x0029:
        r0 = r10.mFromLayout;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.mInLayout;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.mAnimatingAway = r7;
        r2 = r10.mStateAfterAnimating;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.mState;
        switch(r0) {
            case 0: goto L_0x006f;
            case 1: goto L_0x0154;
            case 2: goto L_0x0217;
            case 3: goto L_0x0217;
            case 4: goto L_0x022b;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r10.mState;
        if (r0 == r11) goto L_0x0031;
    L_0x0049:
        r0 = new java.lang.StringBuilder;
        r1 = "moveToState: Fragment state for ";
        r0.<init>(r1);
        r0 = r0.append(r10);
        r1 = " not updated inline; expected state ";
        r0 = r0.append(r1);
        r0 = r0.append(r11);
        r1 = " found ";
        r0 = r0.append(r1);
        r1 = r10.mState;
        r0.append(r1);
        r10.mState = r11;
        goto L_0x0031;
    L_0x006f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x007e;
    L_0x0073:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto CREATED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x007e:
        r0 = r10.mSavedFragmentState;
        if (r0 == 0) goto L_0x00c8;
    L_0x0082:
        r0 = r10.mSavedFragmentState;
        r1 = r9.mHost;
        r1 = r1.mContext;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r10.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.mSavedViewState = r0;
        r0 = r10.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r9.c(r0, r1);
        r10.mTarget = r0;
        r0 = r10.mTarget;
        if (r0 == 0) goto L_0x00b4;
    L_0x00a9:
        r0 = r10.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.mTargetRequestCode = r0;
    L_0x00b4:
        r0 = r10.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.mUserVisibleHint = r0;
        r0 = r10.mUserVisibleHint;
        if (r0 != 0) goto L_0x00c8;
    L_0x00c3:
        r10.mDeferStart = r5;
        if (r11 <= r6) goto L_0x00c8;
    L_0x00c7:
        r11 = r6;
    L_0x00c8:
        r0 = r9.mHost;
        r10.mHost = r0;
        r0 = r9.qC;
        r10.mParentFragment = r0;
        r0 = r9.qC;
        if (r0 == 0) goto L_0x0104;
    L_0x00d4:
        r0 = r9.qC;
        r0 = r0.mChildFragmentManager;
    L_0x00d8:
        r10.mFragmentManager = r0;
        r10.mCalled = r3;
        r0 = r9.mHost;
        r0 = r0.mContext;
        r10.onAttach(r0);
        r0 = r10.mCalled;
        if (r0 != 0) goto L_0x0109;
    L_0x00e7:
        r0 = new android.support.v4.app.am;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0104:
        r0 = r9.mHost;
        r0 = r0.mFragmentManager;
        goto L_0x00d8;
    L_0x0109:
        r0 = r10.mParentFragment;
        if (r0 != 0) goto L_0x0112;
    L_0x010d:
        r0 = r9.mHost;
        r0.onAttachFragment(r10);
    L_0x0112:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x011b;
    L_0x0116:
        r0 = r10.mSavedFragmentState;
        r10.performCreate(r0);
    L_0x011b:
        r10.mRetaining = r3;
        r0 = r10.mFromLayout;
        if (r0 == 0) goto L_0x0154;
    L_0x0121:
        r0 = r10.mSavedFragmentState;
        r0 = r10.getLayoutInflater(r0);
        r1 = r10.mSavedFragmentState;
        r0 = r10.performCreateView(r0, r7, r1);
        r10.mView = r0;
        r0 = r10.mView;
        if (r0 == 0) goto L_0x024f;
    L_0x0133:
        r0 = r10.mView;
        r10.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0245;
    L_0x013d:
        r0 = r10.mView;
        android.support.v4.view.z.ab(r0);
    L_0x0142:
        r0 = r10.mHidden;
        if (r0 == 0) goto L_0x014d;
    L_0x0146:
        r0 = r10.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x014d:
        r0 = r10.mView;
        r1 = r10.mSavedFragmentState;
        r10.onViewCreated(r0, r1);
    L_0x0154:
        if (r11 <= r5) goto L_0x0217;
    L_0x0156:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0165;
    L_0x015a:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x0165:
        r0 = r10.mFromLayout;
        if (r0 != 0) goto L_0x0207;
    L_0x0169:
        r0 = r10.mContainerId;
        if (r0 == 0) goto L_0x03b1;
    L_0x016d:
        r0 = r9.qB;
        r1 = r10.mContainerId;
        r0 = r0.onFindViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01bb;
    L_0x0179:
        r1 = r10.mRestored;
        if (r1 != 0) goto L_0x01bb;
    L_0x017d:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r3 = "No view found for id 0x";
        r2.<init>(r3);
        r3 = r10.mContainerId;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = r10.getResources();
        r4 = r10.mContainerId;
        r3 = r3.getResourceName(r4);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.a(r1);
    L_0x01bb:
        r10.mContainer = r0;
        r1 = r10.mSavedFragmentState;
        r1 = r10.getLayoutInflater(r1);
        r2 = r10.mSavedFragmentState;
        r1 = r10.performCreateView(r1, r0, r2);
        r10.mView = r1;
        r1 = r10.mView;
        if (r1 == 0) goto L_0x025c;
    L_0x01cf:
        r1 = r10.mView;
        r10.mInnerView = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0253;
    L_0x01d9:
        r1 = r10.mView;
        android.support.v4.view.z.ab(r1);
    L_0x01de:
        if (r0 == 0) goto L_0x01f5;
    L_0x01e0:
        r1 = r9.a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01f0;
    L_0x01e6:
        r2 = r10.mView;
        b(r2, r1);
        r2 = r10.mView;
        r2.startAnimation(r1);
    L_0x01f0:
        r1 = r10.mView;
        r0.addView(r1);
    L_0x01f5:
        r0 = r10.mHidden;
        if (r0 == 0) goto L_0x0200;
    L_0x01f9:
        r0 = r10.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0200:
        r0 = r10.mView;
        r1 = r10.mSavedFragmentState;
        r10.onViewCreated(r0, r1);
    L_0x0207:
        r0 = r10.mSavedFragmentState;
        r10.performActivityCreated(r0);
        r0 = r10.mView;
        if (r0 == 0) goto L_0x0215;
    L_0x0210:
        r0 = r10.mSavedFragmentState;
        r10.restoreViewState(r0);
    L_0x0215:
        r10.mSavedFragmentState = r7;
    L_0x0217:
        if (r11 <= r6) goto L_0x022b;
    L_0x0219:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0228;
    L_0x021d:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x0228:
        r10.performStart();
    L_0x022b:
        if (r11 <= r8) goto L_0x0045;
    L_0x022d:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x023c;
    L_0x0231:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x023c:
        r10.performResume();
        r10.mSavedFragmentState = r7;
        r10.mSavedViewState = r7;
        goto L_0x0045;
    L_0x0245:
        r0 = r10.mView;
        r0 = android.support.v4.app.w.y(r0);
        r10.mView = r0;
        goto L_0x0142;
    L_0x024f:
        r10.mInnerView = r7;
        goto L_0x0154;
    L_0x0253:
        r1 = r10.mView;
        r1 = android.support.v4.app.w.y(r1);
        r10.mView = r1;
        goto L_0x01de;
    L_0x025c:
        r10.mInnerView = r7;
        goto L_0x0207;
    L_0x025f:
        r0 = r10.mState;
        if (r0 <= r11) goto L_0x0045;
    L_0x0263:
        r0 = r10.mState;
        switch(r0) {
            case 1: goto L_0x026a;
            case 2: goto L_0x02c1;
            case 3: goto L_0x02ad;
            case 4: goto L_0x0299;
            case 5: goto L_0x0284;
            default: goto L_0x0268;
        };
    L_0x0268:
        goto L_0x0045;
    L_0x026a:
        if (r11 > 0) goto L_0x0045;
    L_0x026c:
        r0 = r9.qG;
        if (r0 == 0) goto L_0x027b;
    L_0x0270:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x027b;
    L_0x0274:
        r0 = r10.mAnimatingAway;
        r10.mAnimatingAway = r7;
        r0.clearAnimation();
    L_0x027b:
        r0 = r10.mAnimatingAway;
        if (r0 == 0) goto L_0x0323;
    L_0x027f:
        r10.mStateAfterAnimating = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0284:
        r0 = 5;
        if (r11 >= r0) goto L_0x0299;
    L_0x0287:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0296;
    L_0x028b:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x0296:
        r10.performPause();
    L_0x0299:
        if (r11 >= r8) goto L_0x02ad;
    L_0x029b:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02aa;
    L_0x029f:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x02aa:
        r10.performStop();
    L_0x02ad:
        if (r11 >= r6) goto L_0x02c1;
    L_0x02af:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02be;
    L_0x02b3:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x02be:
        r10.performReallyStop();
    L_0x02c1:
        r0 = 2;
        if (r11 >= r0) goto L_0x026a;
    L_0x02c4:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02d3;
    L_0x02c8:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x02d3:
        r0 = r10.mView;
        if (r0 == 0) goto L_0x02e6;
    L_0x02d7:
        r0 = r9.mHost;
        r0 = r0.aQ();
        if (r0 == 0) goto L_0x02e6;
    L_0x02df:
        r0 = r10.mSavedViewState;
        if (r0 != 0) goto L_0x02e6;
    L_0x02e3:
        r9.i(r10);
    L_0x02e6:
        r10.performDestroyView();
        r0 = r10.mView;
        if (r0 == 0) goto L_0x031b;
    L_0x02ed:
        r0 = r10.mContainer;
        if (r0 == 0) goto L_0x031b;
    L_0x02f1:
        r0 = r9.qA;
        if (r0 <= 0) goto L_0x03ae;
    L_0x02f5:
        r0 = r9.qG;
        if (r0 != 0) goto L_0x03ae;
    L_0x02f9:
        r0 = r9.a(r10, r12, r3, r13);
    L_0x02fd:
        if (r0 == 0) goto L_0x0314;
    L_0x02ff:
        r1 = r10.mView;
        r10.mAnimatingAway = r1;
        r10.mStateAfterAnimating = r11;
        r1 = r10.mView;
        r2 = new android.support.v4.app.n$4;
        r2.<init>(r1, r0, r10);
        r0.setAnimationListener(r2);
        r1 = r10.mView;
        r1.startAnimation(r0);
    L_0x0314:
        r0 = r10.mContainer;
        r1 = r10.mView;
        r0.removeView(r1);
    L_0x031b:
        r10.mContainer = r7;
        r10.mView = r7;
        r10.mInnerView = r7;
        goto L_0x026a;
    L_0x0323:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0332;
    L_0x0327:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x0332:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x035f;
    L_0x0336:
        r10.performDestroy();
    L_0x0339:
        r10.mCalled = r3;
        r10.onDetach();
        r0 = r10.mCalled;
        if (r0 != 0) goto L_0x0362;
    L_0x0342:
        r0 = new android.support.v4.app.am;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x035f:
        r10.mState = r3;
        goto L_0x0339;
    L_0x0362:
        if (r14 != 0) goto L_0x0045;
    L_0x0364:
        r0 = r10.mRetaining;
        if (r0 != 0) goto L_0x03a4;
    L_0x0368:
        r0 = r10.mIndex;
        if (r0 < 0) goto L_0x0045;
    L_0x036c:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x037b;
    L_0x0370:
        r0 = new java.lang.StringBuilder;
        r1 = "Freeing fragment index ";
        r0.<init>(r1);
        r0.append(r10);
    L_0x037b:
        r0 = r9.qs;
        r1 = r10.mIndex;
        r0.set(r1, r7);
        r0 = r9.qu;
        if (r0 != 0) goto L_0x038d;
    L_0x0386:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r9.qu = r0;
    L_0x038d:
        r0 = r9.qu;
        r1 = r10.mIndex;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r1);
        r0 = r9.mHost;
        r1 = r10.mWho;
        r0.o(r1);
        r10.initState();
        goto L_0x0045;
    L_0x03a4:
        r10.mHost = r7;
        r10.mParentFragment = r7;
        r10.mFragmentManager = r7;
        r10.mChildFragmentManager = r7;
        goto L_0x0045;
    L_0x03ae:
        r0 = r7;
        goto L_0x02fd;
    L_0x03b1:
        r0 = r7;
        goto L_0x01bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.n.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void g(Fragment fragment) {
        a(fragment, this.qA, 0, 0, false);
    }

    final void P(int i) {
        a(i, 0, 0, false);
    }

    final void a(int i, int i2, int i3, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.qA != i) {
            this.qA = i;
            if (this.qs != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.qs.size()) {
                    Fragment fragment = (Fragment) this.qs.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            i5 |= fragment.mLoaderManager.ba();
                        }
                    }
                    i4++;
                    i5 = i5;
                }
                if (i5 == 0) {
                    aV();
                }
                if (this.qE && this.mHost != null && this.qA == 5) {
                    this.mHost.aR();
                    this.qE = false;
                }
            }
        }
    }

    final void aV() {
        if (this.qs != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.qs.size()) {
                    Fragment fragment = (Fragment) this.qs.get(i2);
                    if (fragment != null) {
                        f(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    final void h(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.qu == null || this.qu.size() <= 0) {
                if (this.qs == null) {
                    this.qs = new ArrayList();
                }
                fragment.setIndex(this.qs.size(), this.qC);
                this.qs.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.qu.remove(this.qu.size() - 1)).intValue(), this.qC);
                this.qs.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    public final void a(Fragment fragment, boolean z) {
        if (this.qt == null) {
            this.qt = new ArrayList();
        }
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        h(fragment);
        if (!fragment.mDetached) {
            if (this.qt.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.qt.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.qE = true;
            }
            if (z) {
                g(fragment);
            }
        }
    }

    public final void a(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("remove: ").append(fragment).append(" nesting=").append(fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            int i3;
            if (this.qt != null) {
                this.qt.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.qE = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(fragment, i3, i, i2, false);
        }
    }

    public final void b(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.qE = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final void c(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.qE = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public final void d(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.qt != null) {
                    if (DEBUG) {
                        new StringBuilder("remove from detach: ").append(fragment);
                    }
                    this.qt.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.qE = true;
                }
                fragment.mAdded = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public final void e(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.qt == null) {
                    this.qt = new ArrayList();
                }
                if (this.qt.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                this.qt.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.qE = true;
                }
                a(fragment, this.qA, i, i2, false);
            }
        }
    }

    public final Fragment N(int i) {
        int size;
        Fragment fragment;
        if (this.qt != null) {
            for (size = this.qt.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qt.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.qs != null) {
            for (size = this.qs.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qs.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment p(String str) {
        int size;
        Fragment fragment;
        if (!(this.qt == null || str == null)) {
            for (size = this.qt.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qt.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.qs == null || str == null)) {
            for (size = this.qs.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.qs.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        if (!(this.qs == null || str == null)) {
            for (int size = this.qs.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.qs.get(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void aW() {
        if (this.qF) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.qH != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.qH);
        }
    }

    public final void a(Runnable runnable, boolean z) {
        if (!z) {
            aW();
        }
        synchronized (this) {
            if (this.qG || this.mHost == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.qp == null) {
                this.qp = new ArrayList();
            }
            this.qp.add(runnable);
            if (this.qp.size() == 1) {
                this.mHost.mHandler.removeCallbacks(this.qL);
                this.mHost.mHandler.post(this.qL);
            }
        }
    }

    public final int a(e eVar) {
        int size;
        synchronized (this) {
            if (this.qy == null || this.qy.size() <= 0) {
                if (this.qx == null) {
                    this.qx = new ArrayList();
                }
                size = this.qx.size();
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(size).append(" to ").append(eVar);
                }
                this.qx.add(eVar);
            } else {
                size = ((Integer) this.qy.remove(this.qy.size() - 1)).intValue();
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(size).append(" with ").append(eVar);
                }
                this.qx.set(size, eVar);
            }
        }
        return size;
    }

    private void a(int i, e eVar) {
        synchronized (this) {
            if (this.qx == null) {
                this.qx = new ArrayList();
            }
            int size = this.qx.size();
            if (i < size) {
                if (DEBUG) {
                    new StringBuilder("Setting back stack index ").append(i).append(" to ").append(eVar);
                }
                this.qx.set(i, eVar);
            } else {
                while (size < i) {
                    this.qx.add(null);
                    if (this.qy == null) {
                        this.qy = new ArrayList();
                    }
                    if (DEBUG) {
                        this.qy.add(Integer.valueOf(size));
                        size++;
                    } else {
                        this.qy.add(Integer.valueOf(size));
                        size++;
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Adding back stack index ").append(i).append(" with ").append(eVar);
                }
                this.qx.add(eVar);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean execPendingActions() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.qr;
        if (r1 == 0) goto L_0x000f;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r1 = android.os.Looper.myLooper();
        r3 = r6.mHost;
        r3 = r3.mHandler;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001d:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.qp;	 Catch:{ all -> 0x0099 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.qp;	 Catch:{ all -> 0x0099 }
        r3 = r3.size();	 Catch:{ all -> 0x0099 }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        r0 = r6.qI;
        if (r0 == 0) goto L_0x00a7;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.qs;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a0;
    L_0x0043:
        r0 = r6.qs;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.mLoaderManager;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.mLoaderManager;
        r0 = r0.ba();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.qp;	 Catch:{ all -> 0x0099 }
        r3 = r1.size();	 Catch:{ all -> 0x0099 }
        r1 = r6.qq;	 Catch:{ all -> 0x0099 }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.qq;	 Catch:{ all -> 0x0099 }
        r1 = r1.length;	 Catch:{ all -> 0x0099 }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0099 }
        r6.qq = r1;	 Catch:{ all -> 0x0099 }
    L_0x006f:
        r1 = r6.qp;	 Catch:{ all -> 0x0099 }
        r4 = r6.qq;	 Catch:{ all -> 0x0099 }
        r1.toArray(r4);	 Catch:{ all -> 0x0099 }
        r1 = r6.qp;	 Catch:{ all -> 0x0099 }
        r1.clear();	 Catch:{ all -> 0x0099 }
        r1 = r6.mHost;	 Catch:{ all -> 0x0099 }
        r1 = r1.mHandler;	 Catch:{ all -> 0x0099 }
        r4 = r6.qL;	 Catch:{ all -> 0x0099 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0099 }
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        r6.qr = r0;
        r1 = r2;
    L_0x0088:
        if (r1 >= r3) goto L_0x009c;
    L_0x008a:
        r4 = r6.qq;
        r4 = r4[r1];
        r4.run();
        r4 = r6.qq;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0088;
    L_0x0099:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0099 }
        throw r0;
    L_0x009c:
        r6.qr = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a0:
        if (r4 != 0) goto L_0x00a7;
    L_0x00a2:
        r6.qI = r2;
        r6.aV();
    L_0x00a7:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.n.execPendingActions():boolean");
    }

    final void aX() {
        if (this.qz != null) {
            for (int i = 0; i < this.qz.size(); i++) {
                this.qz.get(i);
            }
        }
    }

    final boolean k(int i, int i2) {
        if (this.qv == null) {
            return false;
        }
        int i3;
        e eVar;
        if (i >= 0 || (i2 & 1) != 0) {
            int size;
            i3 = -1;
            if (i >= 0) {
                size = this.qv.size() - 1;
                while (size >= 0) {
                    eVar = (e) this.qv.get(size);
                    if (i >= 0 && i == eVar.mIndex) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        eVar = (e) this.qv.get(size);
                        if (i < 0 || i != eVar.mIndex) {
                            break;
                        }
                        size--;
                    }
                }
                i3 = size;
            }
            if (i3 == this.qv.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size = this.qv.size() - 1; size > i3; size--) {
                arrayList.add(this.qv.remove(size));
            }
            int size2 = arrayList.size() - 1;
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (size = 0; size <= size2; size++) {
                ((e) arrayList.get(size)).b(sparseArray, sparseArray2);
            }
            android.support.v4.app.e.b bVar = null;
            int i4 = 0;
            while (i4 <= size2) {
                boolean z;
                if (DEBUG) {
                    new StringBuilder("Popping back stack state: ").append(arrayList.get(i4));
                }
                eVar = (e) arrayList.get(i4);
                if (i4 == size2) {
                    z = true;
                } else {
                    z = false;
                }
                i4++;
                bVar = eVar.a(z, bVar, sparseArray, sparseArray2);
            }
        } else {
            i3 = this.qv.size() - 1;
            if (i3 < 0) {
                return false;
            }
            eVar = (e) this.qv.remove(i3);
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            eVar.b(sparseArray3, sparseArray4);
            eVar.a(true, null, sparseArray3, sparseArray4);
        }
        aX();
        return true;
    }

    private void i(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.qK == null) {
                this.qK = new SparseArray();
            } else {
                this.qK.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.qK);
            if (this.qK.size() > 0) {
                fragment.mSavedViewState = this.qK;
                this.qK = null;
            }
        }
    }

    private Bundle j(Fragment fragment) {
        Bundle bundle;
        if (this.qJ == null) {
            this.qJ = new Bundle();
        }
        fragment.performSaveInstanceState(this.qJ);
        if (this.qJ.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.qJ;
            this.qJ = null;
        }
        if (fragment.mView != null) {
            i(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    final Parcelable saveAllState() {
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (qo) {
            this.qF = true;
        }
        if (this.qs == null || this.qs.size() <= 0) {
            return null;
        }
        int size = this.qs.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.qs.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = j(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        a(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    new StringBuilder("Saved state of ").append(fragment).append(": ").append(fragmentState.mSavedFragmentState);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (!z) {
            return null;
        }
        int[] iArr;
        int i2;
        FragmentManagerState fragmentManagerState;
        if (this.qt != null) {
            i = this.qt.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((Fragment) this.qt.get(i2)).mIndex;
                    if (iArr[i2] < 0) {
                        a(new IllegalStateException("Failure saving state: active " + this.qt.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding fragment #").append(i2).append(": ").append(this.qt.get(i2));
                    }
                }
                if (this.qv != null) {
                    i = this.qv.size();
                    if (i > 0) {
                        backStackStateArr = new BackStackState[i];
                        for (i2 = 0; i2 < i; i2++) {
                            backStackStateArr[i2] = new BackStackState((e) this.qv.get(i2));
                            if (DEBUG) {
                                new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qv.get(i2));
                            }
                        }
                    }
                }
                fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.qX = fragmentStateArr;
                fragmentManagerState.qY = iArr;
                fragmentManagerState.qZ = backStackStateArr;
                return fragmentManagerState;
            }
        }
        iArr = null;
        if (this.qv != null) {
            i = this.qv.size();
            if (i > 0) {
                backStackStateArr = new BackStackState[i];
                for (i2 = 0; i2 < i; i2++) {
                    backStackStateArr[i2] = new BackStackState((e) this.qv.get(i2));
                    if (DEBUG) {
                        new StringBuilder("saveAllState: adding back stack #").append(i2).append(": ").append(this.qv.get(i2));
                    }
                }
            }
        }
        fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.qX = fragmentStateArr;
        fragmentManagerState.qY = iArr;
        fragmentManagerState.qZ = backStackStateArr;
        return fragmentManagerState;
    }

    final void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.qX != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.qX[fragment.mIndex];
                        fragmentState.re = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.mContext.getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                }
                this.qs = new ArrayList(fragmentManagerState.qX.length);
                if (this.qu != null) {
                    this.qu.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.qX.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.qX[i2];
                    if (fragmentState2 != null) {
                        l lVar = this.mHost;
                        Fragment fragment2 = this.qC;
                        if (fragmentState2.re == null) {
                            Context context = lVar.mContext;
                            if (fragmentState2.mArguments != null) {
                                fragmentState2.mArguments.setClassLoader(context.getClassLoader());
                            }
                            fragmentState2.re = Fragment.instantiate(context, fragmentState2.rd, fragmentState2.mArguments);
                            if (fragmentState2.mSavedFragmentState != null) {
                                fragmentState2.mSavedFragmentState.setClassLoader(context.getClassLoader());
                                fragmentState2.re.mSavedFragmentState = fragmentState2.mSavedFragmentState;
                            }
                            fragmentState2.re.setIndex(fragmentState2.mIndex, fragment2);
                            fragmentState2.re.mFromLayout = fragmentState2.mFromLayout;
                            fragmentState2.re.mRestored = true;
                            fragmentState2.re.mFragmentId = fragmentState2.mFragmentId;
                            fragmentState2.re.mContainerId = fragmentState2.mContainerId;
                            fragmentState2.re.mTag = fragmentState2.mTag;
                            fragmentState2.re.mRetainInstance = fragmentState2.mRetainInstance;
                            fragmentState2.re.mDetached = fragmentState2.mDetached;
                            fragmentState2.re.mFragmentManager = lVar.mFragmentManager;
                            if (DEBUG) {
                                new StringBuilder("Instantiated fragment ").append(fragmentState2.re);
                            }
                        }
                        Fragment fragment3 = fragmentState2.re;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: active #").append(i2).append(": ").append(fragment3);
                        }
                        this.qs.add(fragment3);
                        fragmentState2.re = null;
                    } else {
                        this.qs.add(null);
                        if (this.qu == null) {
                            this.qu = new ArrayList();
                        }
                        if (DEBUG) {
                            this.qu.add(Integer.valueOf(i2));
                        } else {
                            this.qu.add(Integer.valueOf(i2));
                        }
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.mTargetIndex >= 0) {
                            if (fragment.mTargetIndex < this.qs.size()) {
                                fragment.mTarget = (Fragment) this.qs.get(fragment.mTargetIndex);
                            } else {
                                new StringBuilder("Re-attaching retained fragment ").append(fragment).append(" target no longer exists: ").append(fragment.mTargetIndex);
                                fragment.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.qY != null) {
                    this.qt = new ArrayList(fragmentManagerState.qY.length);
                    for (i = 0; i < fragmentManagerState.qY.length; i++) {
                        fragment = (Fragment) this.qs.get(fragmentManagerState.qY[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.qY[i]));
                        }
                        fragment.mAdded = true;
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: added #").append(i).append(": ").append(fragment);
                        }
                        if (this.qt.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.qt.add(fragment);
                    }
                } else {
                    this.qt = null;
                }
                if (fragmentManagerState.qZ != null) {
                    this.qv = new ArrayList(fragmentManagerState.qZ.length);
                    for (i2 = 0; i2 < fragmentManagerState.qZ.length; i2++) {
                        e a = fragmentManagerState.qZ[i2].a(this);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: back stack #").append(i2).append(" (index ").append(a.mIndex).append("): ").append(a);
                            a.a("  ", new PrintWriter(new d("FragmentManager")), false);
                        }
                        this.qv.add(a);
                        if (a.mIndex >= 0) {
                            a(a.mIndex, a);
                        }
                    }
                    return;
                }
                this.qv = null;
            }
        }
    }

    public final void a(l lVar, j jVar, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = lVar;
        this.qB = jVar;
        this.qC = fragment;
    }

    public final void dispatchCreate() {
        this.qF = false;
        P(1);
    }

    public final void dispatchActivityCreated() {
        this.qF = false;
        P(2);
    }

    public final void dispatchStart() {
        this.qF = false;
        P(4);
    }

    public final void dispatchResume() {
        this.qF = false;
        P(5);
    }

    public final void dispatchStop() {
        this.qF = true;
        P(3);
    }

    public final void dispatchDestroy() {
        this.qG = true;
        execPendingActions();
        P(0);
        this.mHost = null;
        this.qB = null;
        this.qC = null;
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        if (this.qt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.qt.size()) {
                    Fragment fragment = (Fragment) this.qt.get(i2);
                    if (fragment != null) {
                        fragment.performConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void dispatchLowMemory() {
        if (this.qt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.qt.size()) {
                    Fragment fragment = (Fragment) this.qt.get(i2);
                    if (fragment != null) {
                        fragment.performLowMemory();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.qt != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.qt.size()) {
                fragment = (Fragment) this.qt.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.qw != null) {
            while (i < this.qw.size()) {
                fragment = (Fragment) this.qw.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.qw = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.qt == null) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i >= this.qt.size()) {
                return z2;
            }
            Fragment fragment = (Fragment) this.qt.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
            }
            z = i + 1;
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.qt == null) {
            return false;
        }
        for (int i = 0; i < this.qt.size(); i++) {
            Fragment fragment = (Fragment) this.qt.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.qt == null) {
            return false;
        }
        for (int i = 0; i < this.qt.size(); i++) {
            Fragment fragment = (Fragment) this.qt.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.qt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.qt.size()) {
                    Fragment fragment = (Fragment) this.qt.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static int Q(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.qW);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mHost.mContext, string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment N = resourceId != -1 ? N(resourceId) : null;
        if (N == null && string2 != null) {
            N = p(string2);
        }
        if (N == null && id != -1) {
            N = N(id);
        }
        if (DEBUG) {
            new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(resourceId)).append(" fname=").append(string).append(" existing=").append(N);
        }
        if (N == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.mContext, attributeSet, instantiate.mSavedFragmentState);
            a(instantiate, true);
            fragment = instantiate;
        } else if (N.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            N.mInLayout = true;
            N.mHost = this.mHost;
            if (!N.mRetaining) {
                N.onInflate(this.mHost.mContext, attributeSet, N.mSavedFragmentState);
            }
            fragment = N;
        }
        if (this.qA > 0 || !fragment.mFromLayout) {
            g(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }
}
