package org.nyet.util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WaitCursor implements Cursors {
  private final static MouseAdapter mouseAdapter =
    new MouseAdapter() {};

  private WaitCursor() {}

  public static void startWaitCursor(JComponent component) {
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor());
    root.getGlassPane().setCursor(WAIT_CURSOR);
    root.getGlassPane().addMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(true);
  }

  public static void stopWaitCursor(JComponent component) {
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor());
    root.getGlassPane().setCursor(DEFAULT_CURSOR);
    root.getGlassPane().removeMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(false);
  }
}