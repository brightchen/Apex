/**
 * Copyright (C) 2015 DataTorrent, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datatorrent.bufferserver.util;

import com.datatorrent.api.PartitionMatcher;

/**
 * <p>BitVector class.</p>
 *
 * @since 0.3.2
 */
public class BitVector implements PartitionMatcher
{
  private static final long serialVersionUID = -317303608896835405L;
  int mask;
  int bits;

  public BitVector()
  {
  }
  public BitVector(int bits, int mask)
  {
    this.mask = mask;
    this.bits = bits & mask;
  }
  

  public int getMask() {
    return mask;
  }
  public void setMask(int mask) {
    this.mask = mask;
    if( bits != 0 )
      bits &= mask;
  }
  public int getBits() {
    return bits;
  }
  public void setBits(int bits) {
    this.bits = mask == 0 ? bits : mask & bits;
  }
  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 37 * hash + this.mask;
    hash = 37 * hash + this.bits;
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BitVector other = (BitVector)obj;
    if (this.mask != other.mask) {
      return false;
    }
    if (this.bits != other.bits) {
      return false;
    }
    return true;
  }

  public boolean matches(int value)
  {
    return (value & mask) == bits;
  }

  @Override
  public String toString()
  {
    return "BitVector{" + "mask=" + Integer.toBinaryString(mask) + ", bits=" + Integer.toBinaryString(bits) + '}';
  }

}
