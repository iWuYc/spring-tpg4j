package com.iwuyc.tpg4j.spring.core.exception;


import com.iwuyc.tpg4j.core.exception.Tpg4jException;

/**
 * tpg4j 的依赖项错误，缺少必要的依赖
 */
public class Tpg4jDependenciesException extends Tpg4jException {
    public Tpg4jDependenciesException() {
    }

    public Tpg4jDependenciesException(String message) {
        super(message);
    }

    public Tpg4jDependenciesException(String message, Throwable cause) {
        super(message, cause);
    }

    public Tpg4jDependenciesException(Throwable cause) {
        super(cause);
    }

    public Tpg4jDependenciesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
