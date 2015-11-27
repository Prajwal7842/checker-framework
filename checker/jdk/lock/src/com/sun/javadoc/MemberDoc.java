package com.sun.javadoc;

import org.checkerframework.checker.lock.qual.*;
import org.checkerframework.dataflow.qual.Pure;

public interface MemberDoc extends ProgramElementDoc {
  @Pure public abstract boolean isSynthetic(@GuardSatisfied MemberDoc this);
}
