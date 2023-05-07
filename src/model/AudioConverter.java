package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 7R0N1X
 */
public class AudioConverter {

    public AudioConverter(String inputDirPath, String outputDirPath) throws IOException, InterruptedException {
        // Se crea un objeto File con la ruta del directorio de entrada
        File inputDir = new File(inputDirPath);
        // Se obtienen los archivos del directorio de entrada
        File[] files = inputDir.listFiles();
        // Si no hay archivos, se muestra un mensaje y se sale del método main
        if (files == null || files.length == 0) {
            System.out.println("No hay archivos para convertir");
            return;
        }

        // Se recorre la lista de archivos obtenidos del directorio de entrada
        for (File inputFile : files) {
            // Se obtiene el nombre del archivo
            String fileName = inputFile.getName();
            // Se obtiene la extensión del archivo y se convierte a minúsculas
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            // Si la extensión no es una de las permitidas, se muestra un mensaje y se pasa al siguiente archivo
            if (!extension.equals("wav") && !extension.equals("flac") && !extension.equals("m4a") && !extension.equals("aif")) {
                System.out.println("Archivo " + fileName + " no es compatible, se omite.");
                continue;
            }

            // Se obtiene la ruta absoluta del archivo de entrada
            String inputFilePath = inputFile.getAbsolutePath();
            // Se obtiene la ruta del archivo de salida
            String outputFilePath = getOutputFilePath(outputDirPath, fileName);
            // Se construye el comando para la conversión del archivo utilizando FFmpeg
            String ffmpegCommand = String.format("cmd /c ffmpeg -i \"%s\" -codec:a libmp3lame -b:a 320k \"%s\"", inputFilePath, outputFilePath);

            // Se inicia el proceso para la conversión del archivo
            Process process = new ProcessBuilder().command(ffmpegCommand.split(" ")).start();
            // Se crea un lector de la salida estándar del proceso
            BufferedReader stdReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // Se crea un lector de la salida de errores del proceso
            BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Se crean dos hilos para leer la salida estándar y la salida de errores del proceso en paralelo
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

            // Se inician los hilos
            stdThread.start();
            errThread.start();

            // Espera a que termine el proceso de conversión y guarda el código de salida en exitCode
            int exitCode = process.waitFor();
            // Espera a que las lecturas del buffer de entrada estándar y de error hayan finalizado
            stdThread.join();
            errThread.join();

            // Si el proceso finalizó correctamente, se muestra un mensaje indicando que el archivo ha sido convertido con éxito
            // De lo contrario, se muestra un mensaje de error
            if (exitCode == 0) {
                System.out.println("Archivo " + fileName + " convertido con éxito");
            } else {
                System.out.println("Error al convertir el archivo " + fileName);
            }
            // Destruye el proceso de conversión
            process.destroy();

        }
        // Mensaje de finalización del proceso de conversión
        System.out.println("Proceso de conversión finalizado");
    }

    // Método para obtener la ruta de salida del archivo convertido
    private static String getOutputFilePath(String outputDirPath, String inputFileName) {
        String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".mp3";
        return outputDirPath + "\\" + outputFileName;
    }
}
