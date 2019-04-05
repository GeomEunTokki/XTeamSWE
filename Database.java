import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import jdk.nashorn.internal.objects.Global;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Arrays;

public class Database {

    MongoClientURI uri = new MongoClientURI(
            "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                    "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                    ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");

    //add Admin to database
    public static void addAdmin(String Name, int ID, int Password){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Admin");
        System.out.println("connected...");

        Document document = new Document();
        document.append("Name", Name);
        document.append("idNumber", ID);
        document.append("Pass", Password);

        collection.insertOne(document);
        JOptionPane.showMessageDialog(null,"Added "+Name+" to database successful!");
    }

    //add Staff to database
    public static void addStaff(String Name, int ID, int Password) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Staff");

        Document document = new Document();
        document.append("Name", Name);
        document.append("idNumber", ID);
        document.append("Pass", Password);

        collection.insertOne(document);
        JOptionPane.showMessageDialog(null,"Added "+Name+" to database successful!");

    }

    //gets the name of all workshops and returns an ArrayList<String> of all workshop names
    public static void getWorkshops(String[] WS_List){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Workshop");

        ArrayList<String> workshopArray = new ArrayList<String>();

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            String Name = (String) document.get("Name");
            workshopArray.add(Name);

        }
        String[] stringArray = workshopArray.toArray(new String[0]);
        for(int i = 0; i < stringArray.length; i++){
            WS_List[i] = stringArray[i];

        }
        //System.out.println(workshopArray);
        //return workshopArray;

    }

    //add workshop to database
    public static void addWorkshop(String name, String instructor, String time, String date){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
       //connect
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection<Document> collection = db.getCollection("Workshop");
        System.out.println("connected...");

        //set counter so new Workshop has next max ID
        Integer maxID = 0;

        //query for max ID number ".sort(new BasicDBObject("ID",-1))"
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("ID",new BasicDBObject("$gt", 0));
        MongoCursor<Document> cursor = collection.find(searchQuery).sort(new BasicDBObject("ID",-1)).limit(1).iterator();

        //loop to find max; set maxID to it
        while (cursor.hasNext()) {
            Document max = cursor.next();
            maxID = (Integer) max.get("ID");
            System.out.println(maxID.getClass());
        }
        //set maxID to next max ID number
        maxID += 1;
        System.out.println(maxID);

        //declare empty String List to store enrolled students
        List<String> array = Arrays.asList();

        //append new workshop document
        Document document = new Document("Name", name);
        document.append("Instructor",instructor);
        document.append("Time",time);
        document.append("Date",date);
        document.append("ID",maxID);
        document.append("Enrolled",array);

        try {
            collection.insertOne(document);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error adding workshop");
            JOptionPane.showMessageDialog(null,e);
        }
    }

    //remove specified workshop
    public static boolean removeWorkshop(String name){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Workshop");

        DBObject query = new BasicDBObject("Name", name);
        DBObject workshop = collection.findOne(query);

        System.out.println(name);

        try{

            collection.remove(workshop);
            System.out.println("workshop successfully removed");
            JOptionPane.showMessageDialog(null,"workshop successfully removed");
            return true;
        }catch (Exception e) {
            System.out.println("error: no workshop with that name!");
            JOptionPane.showMessageDialog(null,"error: no workshop with that name!");
            return false;
        }
    }

    //verify Admin login credentials
    public static boolean AdminLogin(String name, String pass){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Admin");

        DBObject query = new BasicDBObject("Name", name).append("Pass", new BasicDBObject("$eq", pass));
        DBObject found = collection.findOne(query);

        //System.out.println(d1);
        if(found != null){
            return true;
        }else{
            return false;
        }


    }

    //verify Staff login credentials
    public static boolean StaffLogin(String name, String pass){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Staff");

        DBObject query = new BasicDBObject("Name", name).append("Pass", new BasicDBObject("$eq", pass));
        DBObject d1 = collection.findOne(query);
        System.out.println(d1);
        if(d1 != null){
            return true;
        }else{
            return false;
        }

    }

    //add student name to array of names in Enrolled attribute
    public static void enrollStudent(String workshopName, String studentName){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Workshop");
        System.out.println("connected...");

        Document found = (Document) collection.find(new Document("Name", workshopName)).first();
        Bson updatedValue = new Document("Enrolled", studentName);
        Bson updateoperation = new Document("$push", updatedValue);

        try {
            collection.updateOne(found, updateoperation);
            JOptionPane.showMessageDialog(null,"Successfully enrolled "+studentName+" to "+workshopName);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            JOptionPane.showMessageDialog(null,"Error enrolling student!");
        }
    }

    //adds student Name and ID to the database
    public static void addStudent(String Name, String ID){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Student");

        Document document = new Document();
        document.append("Name", Name);
        document.append("ID", ID);

        try {
            collection.insertOne(document);
            JOptionPane.showMessageDialog(null, "Added " + Name + " to database successful!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error adding student to database");
        }
    }

    //checks database to see if input ID has a corresponding Name
    public static void verifyStudent(String ID){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Student");

        DBObject query = new BasicDBObject("ID", ID);
        DBObject studentID = collection.findOne(query);

        if(studentID == null){
            JOptionPane.showMessageDialog(null,"student doesn't exist in database yet! (enroll)");
        }else{
            JOptionPane.showMessageDialog(null,"student is in database");
        }

    }

}
