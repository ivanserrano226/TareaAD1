import java.io.File;
import java.io.IOException;

public class Tarea {
    public static void main(String[] args) {
        //1
        File directorio = new File("src/resources/directorio");
        System.out.println("1.");
        File[] files = directorio.listFiles();
        if(files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        }

        //2
        System.out.println("2.");
        File subdirectorio = new File("src/resources/directorio/subdirectorio");
        if (!subdirectorio.exists()) {
            subdirectorio.mkdirs();
        }

        File subdirectorioFichero = new File("src/resources/directorio/subdirectorio/ejemplo_fichero4.md");
        try {
            subdirectorioFichero.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (File file : directorio.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        for (File file : subdirectorio.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        //3
        File users = new File("C:\\Users");
        ListarNombresRecursivo(users);

    }

    private static void ListarNombresRecursivo(File directorio) {
        File[] ficheros = directorio.listFiles();
        if (ficheros != null) { //caso base
            for (File fichero : ficheros) {
                System.out.println(fichero.getAbsolutePath());
                if(fichero.isDirectory()) {
                    ListarNombresRecursivo(fichero);
                }
            }
        }
    }
}