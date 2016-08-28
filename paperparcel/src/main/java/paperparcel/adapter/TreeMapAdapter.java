/*
 * Copyright (C) 2016 Bradley Campbell.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package paperparcel.adapter;

import java.util.TreeMap;
import paperparcel.TypeAdapter;

/** Default {@link TypeAdapter} for {@link TreeMap} types */
public final class TreeMapAdapter<K, V> extends AbstractMutableMapAdapter<TreeMap<K, V>, K, V> {
  public TreeMapAdapter(TypeAdapter<K> keyAdapter, TypeAdapter<V> valueAdapter) {
    super(keyAdapter, valueAdapter);
  }

  @Override protected TreeMap<K, V> newMap(int size) {
    return new TreeMap<>();
  }
}
