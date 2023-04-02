package com.serializers;

import com.annotations.LocalizedName;
import com.ui.events.ShowMessage;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

@LocalizedName("XML Serializer")
public class XMLSerializer implements Serializer{
    @Override
    public void serialize(Stage parentStage, ArrayList<Object> objectListToWrite, OutputStream outputStream) {
        try {
            XMLEncoder xmlEncoder = new XMLEncoder(outputStream);
            xmlEncoder.writeObject(objectListToWrite);
            xmlEncoder.close();
        } catch (Exception e) {
            new ShowMessage(parentStage, "There is some exceptions while XML serialization.");
        }
    }

    @Override
    public ArrayList<Object> deserialize(Stage parentStage, InputStream inputStream) {
        Object deserializedObject;
        try {
            XMLDecoder xmlDecoder = new XMLDecoder(inputStream);
            deserializedObject = xmlDecoder.readObject();
            xmlDecoder.close();
        } catch (Exception e) {
            new ShowMessage(parentStage, "There is some exceptions while XML deserialization.");
            deserializedObject = null;
        }
        return (ArrayList<Object>)deserializedObject;
    }
}