/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniapliki;

/**
 *
 * @author dawid
 */
import interfejsy.UserSerializerInterface;
import java.io.*;
import java.util.List;

public class BinaryUserSerializer implements UserSerializerInterface {

    @Override
    public void serialize(List<User> users, String filename) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
        }
    }

    @Override
    public List<User> deserialize(String filename) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<User>) ois.readObject();
        }
    }
}
