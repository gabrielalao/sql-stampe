/*
 * ToroDB Stampede
 * Copyright © 2016 8Kdata Technology (www.8kdata.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.torodb.stampede.config.jackson;

import com.google.common.collect.ImmutableMap;
import com.torodb.packaging.config.jackson.AbstractBackendDeserializer;
import com.torodb.stampede.config.model.backend.Backend;
import com.torodb.stampede.config.model.backend.Pool;
import org.jooq.lambda.tuple.Tuple2;

import java.util.function.BiConsumer;

public class BackendDeserializer extends AbstractBackendDeserializer<Backend> {

  public BackendDeserializer() {
    super(() -> new Backend(),
        ImmutableMap.<String, Tuple2<Class<?>, BiConsumer<Backend, Object>>>of(
            "pool", new Tuple2<>(Pool.class, (backend, value) -> backend.setPool((Pool) value))
        )
    );
  }

}
