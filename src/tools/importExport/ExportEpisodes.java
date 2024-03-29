/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.importExport;

import Exceptions.DatabaseException;
import database.EpisodesRecord;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import myComponents.MyMessages;
import myComponents.myFileFilters.EpisodesExportFilter;
import myseriesproject.episodes.Episodes;
import myseriesproject.series.Series;
import tools.MySeriesLogger;

/**
 * Export episodes to a file
 * @author lordovol
 */
public class ExportEpisodes {

    public static final String EXT = ".eef";
    private File file;

    /**
     * Exports the episodes of the current Series<br />
     * It exports the episode number, the episode title and the date when the episodes was aired
     */
    public ExportEpisodes(JTable episodesTable) {
        MySeriesLogger.logger.log(Level.INFO, "Exporting episodes of {0}", Series.getCurrentSerial().getFullTitle());
        JFileChooser f = new JFileChooser();
        f.setApproveButtonText("Export");
        f.setDialogTitle("Export episodes of " + Series.getCurrentSerial().getFullTitle());
        f.setFileFilter(new EpisodesExportFilter());
        f.setSelectedFile(new File(Series.getCurrentSerial().getFullTitle() + EXT));
        int returnVal = f.showDialog(null, "Export");
        f.setApproveButtonText("Export");
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            MySeriesLogger.logger.log(Level.INFO, "Exporting aborted");
        } else {
            file = f.getSelectedFile();
            MySeriesLogger.logger.log(Level.INFO, "Exporting episodes to {0}", file.getName());
            try {
                exportEpisodesToFile(file, episodesTable);
            } catch (IOException ex) {
                MySeriesLogger.logger.log(Level.SEVERE, "Could not write to file", ex);
            } catch (SQLException ex) {
                MySeriesLogger.logger.log(Level.SEVERE, "Could not fetch the episodes from the database", ex);
            }
        }
    }

    /**
     * Writes the file with the episodes
     * @param file The file to write
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    private void exportEpisodesToFile(File file, JTable episodesTable) throws IOException, SQLException, DatabaseException {
        PrintWriter out = myComponents.MyUsefulFunctions.createOutputStream(file, false);
        ArrayList<EpisodesRecord> episodes = Episodes.getCurrentSeriesEpisodes(episodesTable);
        for (int i = 0; i < episodes.size(); i++) {
            EpisodesRecord ep = episodes.get(i);
            out.println(
                    ep.getEpisode() + "\t"
                    + ep.getTitle() + "\t"
                    + ep.getAired());
        }
        out.close();
        MySeriesLogger.logger.log(Level.FINE, "Export completed");
        MyMessages.message("Export completed", "Export of " + Series.getCurrentSerial().getFullTitle() + " is completed");
    }
}
