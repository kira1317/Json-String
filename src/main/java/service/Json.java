package service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Администратор on 14.09.15.
 */
public class Json{

  private final StringBuilder stringJson=new StringBuilder();
  private final static String CSV_SEPARATOR = ";";

  private String toJson(Object o){


    Field[] fields = o.getClass().getDeclaredFields();

    stringJson.append("{\n");
    for (Field field : fields)
    {


      stringJson.append('"').append(field.getName().toString()).append('"')
            .append(":").append('"').append(CSV_SEPARATOR)
            .append('"').append(",").append("\n");
    }
      stringJson.append("}"
      );


    Annotation[] annotations=o.getClass().getAnnotations();
    for (Annotation annotation:annotations){

      System.out.println(annotation.toString()+"\n");

    }


    return stringJson.toString();
  }
  public void fromJson(String json, Object o){


    String[] stringData = json.split(CSV_SEPARATOR);

    String[] fieldClass = toJson(o).split(CSV_SEPARATOR);


    if(stringData.length==fieldClass.length-1){

    StringBuilder stringBuilder=new StringBuilder();

    for(int i=0; i<fieldClass.length-1;i++){

      stringBuilder.append(fieldClass[i]).append(stringData[i]);

    }
    stringBuilder.append(fieldClass[fieldClass.length-1]);

    System.out.println(stringBuilder);
  }
    else{
      System.out.println("ERROR");
    }

  }


}
