package org.nyet.ecuxplot;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.ui.ExtensionFileFilter;

public class ECUxChartPanel extends ChartPanel {
    public ECUxChartPanel(JFreeChart chart) { super(chart); }
    public void doSaveAs(String fname) throws IOException {
	JFileChooser fileChooser = new JFileChooser();
	fileChooser.setSelectedFile(new File(fname + ".png"));
	ExtensionFileFilter filter = new ExtensionFileFilter(
	       localizationResources.getString("PNG_Image_Files"), ".png");
	fileChooser.addChoosableFileFilter(filter);

	int option = fileChooser.showSaveDialog(this);
	if (option == JFileChooser.APPROVE_OPTION) {
	   String filename = fileChooser.getSelectedFile().getPath();
	   if (isEnforceFileExtensions()) {
	       if (!filename.endsWith(".png")) {
		   filename = filename + ".png";
	       }
	   }
	   saveChartAsPNG(filename);
	}
    }
    public void saveChartAsPNG(String filename) throws IOException {
	   ChartUtilities.saveChartAsPNG(new File(filename), this.getChart(),
		   this.getWidth(), this.getHeight());
    }
}
