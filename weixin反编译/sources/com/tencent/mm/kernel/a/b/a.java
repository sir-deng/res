package com.tencent.mm.kernel.a.b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a {
    private static ThreadLocal<Stack<b>> gTH = new ThreadLocal();

    public static class a {
        Object gTE;
        Class gTI;
        Set gTJ = new HashSet();

        a(Object obj, Class cls) {
            this.gTE = obj;
            if (cls != null) {
                this.gTI = cls;
            }
            aI(this.gTE);
        }

        private void aI(Object obj) {
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.gTI);
            if (!this.gTI.isInstance(obj)) {
                throw new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.gTI);
            }
        }

        public final a aJ(Object obj) {
            this.gTJ.add(obj);
            aI(obj);
            return this;
        }
    }

    static class b {
        public HashMap<Class, a> gTK = null;

        b() {
        }
    }

    public static a a(Object obj, Class cls) {
        b bVar = (b) ((Stack) gTH.get()).peek();
        Assert.assertNotNull(bVar);
        if (bVar.gTK == null) {
            bVar.gTK = new HashMap();
        }
        a aVar = (a) bVar.gTK.get(cls);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(obj, cls);
        bVar.gTK.put(aVar.gTI, aVar);
        return aVar;
    }

    static void start() {
        b bVar = new b();
        Stack stack = (Stack) gTH.get();
        if (stack == null) {
            stack = new Stack();
            gTH.set(stack);
        }
        stack.push(bVar);
    }

    static b DJ() {
        return (b) ((Stack) gTH.get()).pop();
    }
}
