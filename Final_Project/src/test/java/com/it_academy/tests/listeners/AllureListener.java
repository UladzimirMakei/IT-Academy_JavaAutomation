package com.it_academy.tests.listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static com.it_academy.tests.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener implements TestWatcher {

  public void onTestFailure(ExtensionContext context, Throwable cause) {
    takeScreenshotAndAttachToAllureReport();
  }

  public void onTestSkipped(ExtensionContext context, Throwable cause) {
    takeScreenshotAndAttachToAllureReport();
  }
}