package com.insurance.verificationsystem.cache;

import java.util.Iterator;
import java.util.List;

public interface CacheValuesProvider<T> {

    Iterator<List<T>> getValues();

}
