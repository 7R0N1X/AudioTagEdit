package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author 7R0N1X
 */

public class VideoConverter {

    public VideoConverter(String inputDirPath, String outputDirPath) throws IOException, InterruptedException {
        File inputDir = new File(inputDirPath);
        File[] files = inputDir.listFiles();
        if (files == null || files.length == 0) {
            JOptionPane.showMessageDialog(null, "No files to convert.");
            return;
        }

        for (File inputFile : files) {
            String fileName = inputFile.getName();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!extension.equals("mp4")) {
                continue;
            }

            String inputFilePath = inputFile.getAbsolutePath();
            String outputFilePath = getOutputFilePath(outputDirPath, fileName);
            String ffmpegCommand = String.format("cmd /c ffmpeg -i \"%s\" -codec:a libmp3lame -b:a 320k \"%s\"", inputFilePath, outputFilePath);

            Process process = new ProcessBuilder().command(ffmpegCommand.split(" ")).start();
            BufferedReader stdReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            Thread stdThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = stdReader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error in stdThread: " + e.toString());
                }
            });

            Thread errThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = errReader.readLine()) != null) {
                        System.err.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error in errThread: " + e.toString());
                }
            });

            stdThread.start();
            errThread.start();

            int exitCode = process.waitFor();
            stdThread.join();
            errThread.join();

            if (exitCode == 0) {
                System.out.println(fileName + " successfully converted.");
            } else {
                System.out.println("Error converting the file: " + fileName);
            }
            process.destroy();
        }
    }

    private static String getOutputFilePath(String outputDirPath, String inputFileName) {
        String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".mp3";
        return outputDirPath + File.separator + outputFileName;

    }

}
