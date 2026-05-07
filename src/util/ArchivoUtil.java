package util;

import java.io.*;

public class ArchivoUtil {
    public static void guardarObjeto(String archivo, Object obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(obj);
        }
    }

    public static Object cargarObjeto(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return ois.readObject();
        }
    }
}