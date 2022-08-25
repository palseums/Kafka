package package1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class Driver {
    public static void main(String args[])
    {
        try {
            //Create object mapper
            ObjectMapper mapper = new ObjectMapper();
            //read JSON file and map/convert to JAVA POJO:
            Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
            //print first name and last name
            System.out.println(theStudent.getFirstName());
            System.out.println(theStudent.getLastName());
            System.out.println(theStudent.getAddress().getCity());
            System.out.println(theStudent.getAddress().getCountry());

            // now write JSON to a output file
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("data/output.json"),theStudent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
