package com.datatorrent.common.util.debug;

import org.slf4j.Logger;

public class StackTracer extends Exception {

  private static final long serialVersionUID = -2147010947034545984L;

  public static void logStack( Logger logger)
  {
    try
    {
      trace();
    }
    catch(StackTracer st)
    {
      logger.info("StackTracer", st);
    }
  }
  
  public static void trace() throws StackTracer
  {
    throw new StackTracer();
  }
  
  public StackTracer(){}
}
