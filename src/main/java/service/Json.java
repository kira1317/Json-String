package service;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Created by Администратор on 14.09.15.
 */
public class Json implements Serializable {

  private StringBuilder stringJson=new StringBuilder();
  private final static String CSV_SEPARATOR = ",";

  private final static String baseFile = "JsonFormat.json";


  public void toJson(String json, Object o) throws IOException {


    Field[] fields = o.getClass().getDeclaredFields();
    String[] stringData = json.split(CSV_SEPARATOR);

    stringJson.append("{");
    int i=0;
    for (Field field : fields)
    {


        stringJson.append('"').append(field.getName().toString()).append('"')
                .append(":").append('"').append(stringData[i])
                .append('"').append(CSV_SEPARATOR);

      i++;
    }
    stringJson.deleteCharAt(stringJson.length()-1);
    stringJson.append("}");



    // Annotation[] annotations=o.getClass().getAnnotations();
    //for (Annotation annotation:annotations){

   //   System.out.println(annotation.toString()+"\n");

    //}

   /* ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(baseFile), o);*/

    File file=new File(baseFile);
    FileWriter fileWriter=new FileWriter(file);
    fileWriter.write(stringJson.toString());
    fileWriter.flush();
    fileWriter.close();


    System.out.println("json created!");

  }



  public void fromJson(Object o) throws FileNotFoundException {

   // ObjectMapper mapper = new ObjectMapper();
   // return mapper.readValue(new File(baseFile), Object.class);

    FileReader fileReader = new FileReader(baseFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    Scanner scanner = new Scanner(bufferedReader);

    String json=scanner.nextLine();

  /*  String[]fieldAndData= json.split(CSV_SEPARATOR);

    fieldAndData[0].split(":");
    fieldAndData[1].split(":");
    fieldAndData[2].split(":");
    fieldAndData[3].split(":");

    Field[] fields = o.getClass().getDeclaredFields();
    int i=0;
    for (Field field : fields)
    {


      if(field.getName().equals(fieldAndData[i].split(":"))){




      }


    }*/



    System.out.printf(json);


  }





}
