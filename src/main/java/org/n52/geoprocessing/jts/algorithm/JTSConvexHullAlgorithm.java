/*
 * Copyright 2016 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.geoprocessing.jts.algorithm;

import org.n52.geoprocessing.jts.io.data.binding.complex.JTSGeometryBinding;
import org.n52.javaps.algorithm.annotation.Algorithm;
import org.n52.javaps.algorithm.annotation.ComplexInput;
import org.n52.javaps.algorithm.annotation.ComplexOutput;
import org.n52.javaps.algorithm.annotation.Execute;

import com.vividsolutions.jts.geom.Geometry;

/**
 * This algorithm creates a convex hull of a JTS geometry using build the in method.
 * @author BenjaminPross
 *
 */
@Algorithm(version = "1.1.0")
public class JTSConvexHullAlgorithm{

    private Geometry result;
    private Geometry data;

    @ComplexOutput(identifier = "result", binding = JTSGeometryBinding.class)
    public Geometry getResult() {
        return result;
    }

    @ComplexInput(identifier = "data", binding = JTSGeometryBinding.class)
    public void setData(Geometry data) {
        this.data = data;
    }

    @Execute
    public void runAlgorithm() {
        result = data.convexHull();
    }
}