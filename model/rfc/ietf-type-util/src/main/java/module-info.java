/*
 * Copyright (c) 2023 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
/**
 * Common utilities to support {@code ietf-inet-types.yang} and {@code ietf-yang-types.yang}.
 */
module org.opendaylight.ietf.type.util {
    exports org.opendaylight.ietf.type.util;

    requires com.google.common;

    // Annotations
    requires static transitive org.eclipse.jdt.annotation;
    requires static org.osgi.annotation.bundle;
}
