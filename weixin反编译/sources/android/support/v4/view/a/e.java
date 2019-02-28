package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class e {

    /* renamed from: android.support.v4.view.a.e$1 */
    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a AB;

        AnonymousClass1(a aVar) {
            this.AB = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.AB.ci();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.AB.cg();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.AB.cf();
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            this.AB.cj();
            return null;
        }
    }

    interface a {
        boolean cf();

        List<Object> cg();

        Object ci();

        Object cj();
    }
}
