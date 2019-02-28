package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class d {

    /* renamed from: android.support.v4.view.a.d$1 */
    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a AA;

        AnonymousClass1(a aVar) {
            this.AA = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.AA.ci();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.AA.cg();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.AA.cf();
        }
    }

    interface a {
        boolean cf();

        List<Object> cg();

        Object ci();
    }
}
