package ru.medved_sa.tree_family.save.ioUtils;

import ru.medved_sa.tree_family.save.Writable;

import java.io.*;

public class IOUtils implements Writable {

    public boolean saveFile(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object readFile(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
