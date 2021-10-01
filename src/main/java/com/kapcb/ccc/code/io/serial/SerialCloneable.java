package com.kapcb.ccc.code.io.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <a>Title: SerialCloneable </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6-14:00
 */
public class SerialCloneable implements Cloneable, Serializable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

                objectOutputStream.writeObject(this);

            }
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray())) {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                return objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException cloneNotSupportedException = new CloneNotSupportedException();
            cloneNotSupportedException.initCause(e);
            throw cloneNotSupportedException;
        }
    }
}
