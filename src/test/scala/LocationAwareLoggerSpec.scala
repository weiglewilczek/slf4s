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

import org.slf4j.spi.{LocationAwareLogger => SLF4JLocationAwareLogger}
import org.slf4j.spi.LocationAwareLogger.{ERROR_INT, WARN_INT, INFO_INT, DEBUG_INT, TRACE_INT}
import org.specs.Specification
import org.specs.mock.Mockito
import org.slf4j.Marker

class LocationAwareLoggerSpec extends Specification with Mockito {

  "Calling Logger.error(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(msg)
      there was no(slf4jLogger).log(null, FQCN, ERROR_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(msg)
      there was one(slf4jLogger).log(null, FQCN, ERROR_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.error(marker, msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when error not enabled" in {
      slf4jLogger.isErrorEnabled(marker) returns false
      logger.error(marker, msg)
      there was no(slf4jLogger).log(marker, FQCN, ERROR_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when error enabled" in {
      slf4jLogger.isErrorEnabled(marker) returns true
      logger.error(marker, msg)
      there was one(slf4jLogger).log(marker, FQCN, ERROR_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.error(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when error not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.error(msg, t)
      there was no(slf4jLogger).log(null, FQCN, ERROR_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when error enabled" in {
      slf4jLogger.isErrorEnabled returns true
      logger.error(msg, t)
      there was one(slf4jLogger).log(null, FQCN, ERROR_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.error(marker, msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when error not enabled" in {
      slf4jLogger.isErrorEnabled(marker) returns false
      logger.error(marker, msg, t)
      there was no(slf4jLogger).log(marker, FQCN, ERROR_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when error enabled" in {
      slf4jLogger.isErrorEnabled(marker) returns true
      logger.error(marker, msg, t)
      there was one(slf4jLogger).log(marker, FQCN, ERROR_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when warn not enabled" in {
      slf4jLogger.isWarnEnabled returns false
      logger.warn(msg)
      there was no(slf4jLogger).log(null, FQCN, WARN_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(msg)
      there was one(slf4jLogger).log(null, FQCN, WARN_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(marker, msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when warn not enabled" in {
      slf4jLogger.isWarnEnabled(marker) returns false
      logger.warn(marker, msg)
      there was no(slf4jLogger).log(marker, FQCN, WARN_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when warn enabled" in {
      slf4jLogger.isWarnEnabled(marker) returns true
      logger.warn(marker, msg)
      there was one(slf4jLogger).log(marker, FQCN, WARN_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when warn not enabled" in {
      slf4jLogger.isErrorEnabled returns false
      logger.warn(msg, t)
      there was no(slf4jLogger).log(null, FQCN, WARN_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when warn enabled" in {
      slf4jLogger.isWarnEnabled returns true
      logger.warn(msg, t)
      there was one(slf4jLogger).log(null, FQCN, WARN_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.warn(marker, msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when warn not enabled" in {
      slf4jLogger.isWarnEnabled(marker) returns false
      logger.warn(marker, msg, t)
      there was no(slf4jLogger).log(marker, FQCN, WARN_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when warn enabled" in {
      slf4jLogger.isWarnEnabled(marker) returns true
      logger.warn(marker, msg, t)
      there was one(slf4jLogger).log(marker, FQCN, WARN_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(msg)
      there was no(slf4jLogger).log(null, FQCN, INFO_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(msg)
      there was one(slf4jLogger).log(null, FQCN, INFO_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(marker, msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when info not enabled" in {
      slf4jLogger.isInfoEnabled(marker) returns false
      logger.info(marker, msg)
      there was no(slf4jLogger).log(marker, FQCN, INFO_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when info enabled" in {
      slf4jLogger.isInfoEnabled(marker) returns true
      logger.info(marker, msg)
      there was one(slf4jLogger).log(marker, FQCN, INFO_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when info not enabled" in {
      slf4jLogger.isInfoEnabled returns false
      logger.info(msg, t)
      there was no(slf4jLogger).log(null, FQCN, INFO_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when info enabled" in {
      slf4jLogger.isInfoEnabled returns true
      logger.info(msg, t)
      there was one(slf4jLogger).log(null, FQCN, INFO_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.info(marker, msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when info not enabled" in {
      slf4jLogger.isInfoEnabled(marker) returns false
      logger.info(marker, msg, t)
      there was no(slf4jLogger).log(marker, FQCN, INFO_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when info enabled" in {
      slf4jLogger.isInfoEnabled(marker) returns true
      logger.info(marker, msg, t)
      there was one(slf4jLogger).log(marker, FQCN, INFO_INT, Msg, null, t)
      evaluated mustBe true
    }
  }


  "Calling Logger.debug(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(msg)
      there was no(slf4jLogger).log(null, FQCN, DEBUG_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(msg)
      there was one(slf4jLogger).log(null, FQCN, DEBUG_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.debug(marker, msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when debug not enabled" in {
      slf4jLogger.isDebugEnabled(marker) returns false
      logger.debug(marker, msg)
      there was no(slf4jLogger).log(marker, FQCN, DEBUG_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when debug enabled" in {
      slf4jLogger.isDebugEnabled(marker) returns true
      logger.debug(marker, msg)
      there was one(slf4jLogger).log(marker, FQCN, DEBUG_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.debug(msg ,t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when debug not enabled" in {
      slf4jLogger.isDebugEnabled returns false
      logger.debug(msg, t)
      there was no(slf4jLogger).log(null, FQCN, DEBUG_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when debug enabled" in {
      slf4jLogger.isDebugEnabled returns true
      logger.debug(msg, t)
      there was one(slf4jLogger).log(null, FQCN, DEBUG_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.debug(marker, msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when debug not enabled" in {
      slf4jLogger.isDebugEnabled(marker) returns false
      logger.debug(marker, msg, t)
      there was no(slf4jLogger).log(marker, FQCN, DEBUG_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when debug enabled" in {
      slf4jLogger.isDebugEnabled(marker) returns true
      logger.debug(marker, msg, t)
      there was one(slf4jLogger).log(marker, FQCN, DEBUG_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger.trace(msg)
      there was no(slf4jLogger).log(null, FQCN, TRACE_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger.trace(msg)
      there was one(slf4jLogger).log(null, FQCN, TRACE_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(marker, msg)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when trace not enabled" in {
      slf4jLogger.isTraceEnabled(marker) returns false
      logger.trace(marker, msg)
      there was no(slf4jLogger).log(marker, FQCN, TRACE_INT, Msg, null, null)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when trace enabled" in {
      slf4jLogger.isTraceEnabled(marker) returns true
      logger.trace(marker, msg)
      there was one(slf4jLogger).log(marker, FQCN, TRACE_INT, Msg, null, null)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when trace not enabled" in {
      slf4jLogger.isTraceEnabled returns false
      logger.trace(msg, t)
      there was no(slf4jLogger).log(null, FQCN, TRACE_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when trace enabled" in {
      slf4jLogger.isTraceEnabled returns true
      logger.trace(msg, t)
      there was one(slf4jLogger).log(null, FQCN, TRACE_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  "Calling Logger.trace(marker, msg, t)" should {
    val (logger, slf4jLogger) = loggers
    var evaluated = false
    def msg = {
      evaluated = true
      Msg
    }

    "not call SLF4JLogger.log when trace not enabled" in {
      slf4jLogger.isTraceEnabled(marker) returns false
      logger.trace(marker, msg, t)
      there was no(slf4jLogger).log(marker, FQCN, TRACE_INT, Msg, null, t)
      evaluated mustBe false
    }

    "call SLF4JLogger.log when trace enabled" in {
      slf4jLogger.isTraceEnabled(marker) returns true
      logger.trace(marker, msg, t)
      there was one(slf4jLogger).log(marker, FQCN, TRACE_INT, Msg, null, t)
      evaluated mustBe true
    }
  }

  private lazy val Msg = "MESSAGE"

  private lazy val t = new Throwable

  private lazy val FQCN = classOf[DefaultLocationAwareLogger].getName

  private lazy val marker = mock[Marker]

  private def loggers = {
    val mockSLF4JLogger = mock[SLF4JLocationAwareLogger]
    val logger = new DefaultLocationAwareLogger(mockSLF4JLogger)
    (logger, mockSLF4JLogger)
  }
}
