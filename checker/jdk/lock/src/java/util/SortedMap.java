package java.util;
import org.checkerframework.dataflow.qual.*;
import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.checker.lock.qual.*;

// Subclasses of this interface/class may opt to prohibit null elements
public interface SortedMap<K extends Object, V extends Object> extends Map<K, V> {
  @SideEffectFree public abstract Comparator<? super K> comparator(@GuardSatisfied SortedMap<K,V> this);
  @SideEffectFree public abstract SortedMap<K, V> subMap(@GuardSatisfied SortedMap<K,V> this,@GuardSatisfied K a1, @GuardSatisfied K a2);
  @SideEffectFree public abstract SortedMap<K, V> headMap(@GuardSatisfied SortedMap<K,V> this,K a1);
  @SideEffectFree public abstract SortedMap<K, V> tailMap(@GuardSatisfied SortedMap<K,V> this,K a1);
  @SideEffectFree public abstract K firstKey(@GuardSatisfied SortedMap<K,V> this);
  @SideEffectFree public abstract K lastKey(@GuardSatisfied SortedMap<K,V> this);
  @SideEffectFree public abstract Set<K> keySet(@GuardSatisfied SortedMap<K,V> this);
  @SideEffectFree public abstract Collection<V> values(@GuardSatisfied SortedMap<K,V> this);
  @SideEffectFree public abstract Set<Map.Entry<K,V>> entrySet(@GuardSatisfied SortedMap<K,V> this);
}
