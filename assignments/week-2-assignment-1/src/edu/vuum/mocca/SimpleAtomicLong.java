// Import the necessary Java synchronization and scheduling classes.
package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;
    
    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
    // TODO - replace the null with the appropriate initialization:
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock();

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public SimpleAtomicLong(long initialValue)
    {
        // TODO - you fill in here
        this.mValue = initialValue;
    }

    /**
     * @brief Gets the current value.
     * 
     * @returns The current value
     */
    public long get()
    {
        long value;
        // TODO - you fill in here, using a readLock()
        this.mRWLock.readLock().lock();
        try{
            value = this.mValue;
        }finally {
            this.mRWLock.readLock().unlock();
        }
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
    public long decrementAndGet()
    {
        long value;
        // TODO - you fill in here, using a writeLock()
        this.mRWLock.writeLock().lock();
        try{
            this.mValue --;
            value = mValue;
        }finally {
            this.mRWLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
    public long getAndIncrement()
    {
        long value;
        // TODO - you fill in here, using a writeLock()
        this.mRWLock.writeLock().lock();
        try{
            value = mValue;
            this.mValue ++;
        }finally {
            this.mRWLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
    public long getAndDecrement()
    {
        long value;
        // TODO - you fill in here, using a writeLock()
        this.mRWLock.writeLock().lock();
        try{
            value = this.mValue;
            this.mValue --;
        }finally {
            this.mRWLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
    public long incrementAndGet()
    {
        long value;
        // TODO - you fill in here, using a writeLock()
        this.mRWLock.writeLock().lock();
        try{
            this.mValue ++;
            value = this.mValue;
        }finally {
            this.mRWLock.writeLock().unlock();
        }
        return value;
    }
}

