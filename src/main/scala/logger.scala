/*
 * Copyright 2010-2011 Weigle Wilczek GmbH
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
package com.weiglewilczek.slf4s

import org.slf4j.spi.{LocationAwareLogger => Slf4jLocationAwareLogger}
import org.slf4j.{Marker, Logger => Slf4jLogger, LoggerFactory}

/**
 * Factory for Loggers.
 */
object Logger {

  /**
   * Creates a Logger named corresponding to the given class.
   * @param clazz Class used for the Logger's name. Must not be null!
   */
  def apply(clazz: Class[_]): Logger = {
    require(clazz != null, "clazz must not be null!")
    logger(LoggerFactory getLogger clazz)
  }

  /**
   * Creates a Logger with the given name.
   * @param name The Logger's name. Must not be null!
   */
  def apply(name: String): Logger = {
    require(name != null, "loggerName must not be null!")
    logger(LoggerFactory getLogger name)
  }

  private def logger(slf4jLogger: Slf4jLogger): Logger = slf4jLogger match {
    case locationAwareLogger: Slf4jLocationAwareLogger =>
      new DefaultLocationAwareLogger(locationAwareLogger)
    case _ =>
      new DefaultLogger(slf4jLogger)
  }
}

/**
 * Thin wrapper for SLF4J making use of by-name parameters to improve performance.
 */
trait Logger {

  /**
   * The name of this Logger.
   */
  lazy val name = slf4jLogger.getName

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged
   */
  def error(msg: => String) {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg)
  }

  /**
   * Log a message with ERROR level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   */
  def error(marker: Marker, msg: => String) {
    if (slf4jLogger.isErrorEnabled(marker)) slf4jLogger.error(marker, msg)
  }

  /**
   * Log a message with ERROR level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def error(msg: => String, t: Throwable) {
    if (slf4jLogger.isErrorEnabled) slf4jLogger.error(msg, t)
  }

  /**
   * Log a message with ERROR level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def error(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isErrorEnabled(marker)) slf4jLogger.error(marker, msg, t)
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged
   */
  def warn(msg: => String) {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg)
  }

  /**
   * Log a message with WARN level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   */
  def warn(marker: Marker, msg: => String) {
    if (slf4jLogger.isWarnEnabled(marker)) slf4jLogger.warn(marker, msg)
  }

  /**
   * Log a message with WARN level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def warn(msg: => String, t: Throwable) {
    if (slf4jLogger.isWarnEnabled) slf4jLogger.warn(msg, t)
  }

  /**
   * Log a message with WARN level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def warn(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isWarnEnabled(marker)) slf4jLogger.warn(marker, msg, t)
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged
   */
  def info(msg: => String) {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg)
  }

  /**
   * Log a message with INFO level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   */
  def info(marker: Marker, msg: => String) {
    if (slf4jLogger.isInfoEnabled(marker)) slf4jLogger.info(marker, msg)
  }

  /**
   * Log a message with INFO level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def info(msg: => String, t: Throwable) {
    if (slf4jLogger.isInfoEnabled) slf4jLogger.info(msg, t)
  }

  /**
   * Log a message with INFO level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def info(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isInfoEnabled(marker)) slf4jLogger.info(marker, msg, t)
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged
   */
  def debug(msg: => String) {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg)
  }

  /**
   * Log a message with DEBUG level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   */
  def debug(marker: Marker, msg: => String) {
    if (slf4jLogger.isDebugEnabled(marker)) slf4jLogger.debug(marker, msg)
  }

  /**
   * Log a message with DEBUG level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def debug(msg: => String, t: Throwable) {
    if (slf4jLogger.isDebugEnabled) slf4jLogger.debug(msg, t)
  }

  /**
   * Log a message with DEBUG level.
   * @param marker the marker data specific to this log statement
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def debug(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isDebugEnabled(marker)) slf4jLogger.debug(marker, msg, t)
  }


  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged
   */
  def trace(msg: => String) {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg)
  }

  /**
   * Log a message with the specific Marker at the TRACE level.
   *
   * @param marker the marker data specific to this log statement
   * @param msg the message string to be logged
   *
   */
  def trace(marker: Marker, msg: => String) {
    if (slf4jLogger.isTraceEnabled(marker)) slf4jLogger.trace(marker, msg)
  }

  /**
   * Log a message with TRACE level.
   * @param msg The message to be logged
   * @param t The Throwable to be logged
   */
  def trace(msg: => String, t: Throwable) {
    if (slf4jLogger.isTraceEnabled) slf4jLogger.trace(msg, t)
  }

  /**
   * This method is similar to {@link #trace(String, Throwable)} method except that the
   * marker data is also taken into consideration.
   *
   * @param marker the marker data specific to this log statement
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  def trace(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isTraceEnabled(marker)) slf4jLogger.trace(marker, msg, t)
  }

  /**
   * The wrapped SLF4J Logger.
   */
  protected val slf4jLogger: Slf4jLogger
}

private[slf4s] class DefaultLogger(override protected val slf4jLogger: Slf4jLogger) extends Logger

/**
 * Thin wrapper for a location aware SLF4J logger making use of by-name parameters to improve performance.
 *
 * This implementation delegates to a location aware logger. For those SLF4J adapters that implement this
 * interface, such as log4j and java.util.logging adapters, the code location reported will be that
 * of the caller instead of the wrapper.
 *
 * Hint: Use the Logger object to choose the correct implementation automatically.
 */
trait LocationAwareLogger extends Logger {

  import Slf4jLocationAwareLogger.{ERROR_INT, WARN_INT, INFO_INT, DEBUG_INT, TRACE_INT}

  override def error(msg: => String) {
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, msg)
  }

  override def error(marker: Marker, msg: => String) {
    if (slf4jLogger.isErrorEnabled(marker)) log(ERROR_INT, msg, marker = marker)
  }

  override def error(msg: => String, t: Throwable) {
    if (slf4jLogger.isErrorEnabled) log(ERROR_INT, msg, throwable = t)
  }

  override def error(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isErrorEnabled(marker)) log(ERROR_INT, msg, marker = marker, throwable = t)
  }

  override def warn(msg: => String) {
    if (slf4jLogger.isWarnEnabled) log(WARN_INT, msg)
  }

  override def warn(marker: Marker, msg: => String) {
    if (slf4jLogger.isWarnEnabled(marker)) log(WARN_INT, msg, marker = marker)
  }

  override def warn(msg: => String, t: Throwable) {
    if (slf4jLogger.isWarnEnabled) log(WARN_INT, msg, throwable = t)
  }

  override def warn(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isWarnEnabled(marker)) log(WARN_INT, msg, marker = marker, throwable = t)
  }

  override def info(msg: => String) {
    if (slf4jLogger.isInfoEnabled) log(INFO_INT, msg)
  }

  override def info(marker: Marker, msg: => String) {
    if (slf4jLogger.isInfoEnabled(marker)) log(INFO_INT, msg, marker = marker)
  }

  override def info(msg: => String, t: Throwable) {
    if (slf4jLogger.isInfoEnabled) log(INFO_INT, msg, throwable = t)
  }

  override def info(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isInfoEnabled(marker)) log(INFO_INT, msg, marker = marker, throwable = t)
  }

  override def debug(msg: => String) {
    if (slf4jLogger.isDebugEnabled) log(DEBUG_INT, msg)
  }

  override def debug(marker: Marker, msg: => String) {
    if (slf4jLogger.isDebugEnabled(marker)) log(DEBUG_INT, msg, marker = marker)
  }

  override def debug(msg: => String, t: Throwable) {
    if (slf4jLogger.isDebugEnabled) log(DEBUG_INT, msg, throwable = t)
  }

  override def debug(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isDebugEnabled(marker)) log(DEBUG_INT, msg, marker = marker, throwable = t)
  }

  override def trace(msg: => String) {
    if (slf4jLogger.isTraceEnabled) log(TRACE_INT, msg)
  }

  override def trace(marker: Marker, msg: => String) {
    if (slf4jLogger.isTraceEnabled(marker)) log(TRACE_INT, msg, marker = marker)
  }

  override def trace(msg: => String, t: Throwable) {
    if (slf4jLogger.isTraceEnabled) log(TRACE_INT, msg, throwable = t)
  }

  override def trace(marker: Marker, msg: => String, t: Throwable) {
    if (slf4jLogger.isTraceEnabled(marker)) log(TRACE_INT, msg, marker = marker, throwable = t)
  }

  override protected val slf4jLogger: Slf4jLocationAwareLogger

  /**
   * Get the wrapper class name for detection of the stackframe of the user code calling into the log framework.
   * @return The fully qualified class name of the outermost logger wrapper class.
   */
  protected val wrapperClassName: String

  private final def log(level: Int, msg: String, marker: Marker = null, throwable: Throwable = null) {
    slf4jLogger.log(marker, wrapperClassName, level, msg, null, throwable)
  }
}

private[slf4s] object DefaultLocationAwareLogger {
  private val WrapperClassName = classOf[DefaultLocationAwareLogger].getName
}

private[slf4s] final class DefaultLocationAwareLogger(override protected val slf4jLogger: Slf4jLocationAwareLogger)
  extends LocationAwareLogger {
  override protected val wrapperClassName = DefaultLocationAwareLogger.WrapperClassName
}
