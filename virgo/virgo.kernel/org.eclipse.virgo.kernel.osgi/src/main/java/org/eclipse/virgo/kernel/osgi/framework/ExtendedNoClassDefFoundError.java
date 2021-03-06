/*******************************************************************************
 * Copyright (c) 2008, 2010 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   VMware Inc. - initial contribution
 *******************************************************************************/

package org.eclipse.virgo.kernel.osgi.framework;

/**
 * An extension to {@link NoClassDefFoundError} that provides access to the ClassLoader that attempted
 * the class load. 
 * <p />
 * 
 * <strong>Concurrent Semantics</strong><br />
 * <strong>Thread-safe</strong>
 * 
 */
public class ExtendedNoClassDefFoundError extends NoClassDefFoundError {

    private static final long serialVersionUID = 4573722090207901849L;

    private final ClassLoader classLoader;

    public ExtendedNoClassDefFoundError(ClassLoader classLoader, NoClassDefFoundError cause) {
        super(cause.getMessage() + " in " + classLoader);
        this.classLoader = classLoader;
        initCause(cause);
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }
}
