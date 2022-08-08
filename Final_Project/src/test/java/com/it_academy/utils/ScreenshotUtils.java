package com.it_academy.utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;
import static org.apache.commons.io.FileUtils.openInputStream;

public final class ScreenshotUtils {

  protected static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

  public static void takeScreenshotAndAttachToAllureReport() {
    try {
      File screenshotAs = takeScreenShotAsFile();
      Allure.addAttachment("Screenshot", openInputStream(screenshotAs));
    } catch (IOException var1) {
      LOG.error("Error creating screenshot");
    }
  }
}