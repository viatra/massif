/*******************************************************************************
 * Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 *     Robert Doczi, Akos Horvath - initial API and implementation 
 *******************************************************************************/
package hu.bme.mit.massif.oslc.adaptor.util;

import hu.bme.mit.massif.oslc.adaptor.util.ParallelIterator.Pair;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Special iterator class to iterate through two collections in a parallel
 * manner.
 * 
 * @param <T1>
 *            The type of the 1st iterable.
 * @param <T2>
 *            The type of the 2nd iterable.
 */
public class ParallelIterator<T1, T2> implements Iterator<Pair<T1, T2>> {

    /**
     * Creates an iterator from the provided iterables.
     * 
     * @param i1
     *            first iterable
     * @param i2
     *            second iterable
     * @return a parallel iterator.
     */
    public static <TT1, TT2> ParallelIterator<TT1, TT2> of(final Iterable<TT1> i1, final Iterable<TT2> i2) {
        return new ParallelIterator<TT1, TT2>(i1.iterator(), i2.iterator());
    }

    private final Iterator<T1> it1;
    private final Iterator<T2> it2;

    private ParallelIterator(final Iterator<T1> it1, final Iterator<T2> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    /**
     * Contains a pair of data.
     * 
     * @param <TT1>
     *            The type of the 1st data.
     * @param <TT2>
     *            The type of the 2nd data.
     */
    public static class Pair<TT1, TT2> {
        private final TT1 v1;
        private final TT2 v2;

        public Pair(final TT1 v1, final TT2 v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        /**
         * @return the 1st data
         */
        public TT1 getV1() {
            return v1;
        }

        /**
         * 
         * @return the 2nd data
         */
        public TT2 getV2() {
            return v2;
        }
    }

    @Override
    public boolean hasNext() {
        return it1.hasNext() && it2.hasNext();
    }

    @Override
    public Pair<T1, T2> next() {
        return new Pair<T1, T2>(it1.next(), it2.next());
    }

    @Override
    public void remove() {
        it1.remove();
        it2.remove();
    }

    @Override
    public void forEachRemaining(final Consumer<? super Pair<T1, T2>> action) {
        while (hasNext()) {
            final Pair<T1, T2> pair = next();
            action.accept(pair);
        }
    }
}
