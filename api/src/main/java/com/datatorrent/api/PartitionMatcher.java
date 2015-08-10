package com.datatorrent.api;

import java.io.Serializable;

public interface PartitionMatcher extends Serializable {
	public boolean matches(int value);
}
