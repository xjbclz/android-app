package com.ruwant.aspectj;

import java.util.concurrent.TimeUnit;

public class AOPTimer {
  private long startTime;
  private long endTime;
  private long elapsedTime;

  public AOPTimer() {
  }

  private void reset() {
    startTime = 0;
    endTime = 0;
    elapsedTime = 0;
  }

  public void start() {
    reset();
    startTime = System.nanoTime();
  }

  public void stop() {
    if (startTime != 0) {
      endTime = System.nanoTime();
      elapsedTime = endTime - startTime;
    } else {
      reset();
    }
  }

  public long getTotalTime(){
    return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toMicros(endTime - startTime) /1000: 0;
  }
}
